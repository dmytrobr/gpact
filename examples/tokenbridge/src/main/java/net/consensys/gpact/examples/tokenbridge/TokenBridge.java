/*
 * Copyright 2021 ConsenSys Software Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package net.consensys.gpact.examples.tokenbridge;

import net.consensys.gpact.cbc.CbcManager;
import net.consensys.gpact.common.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.web3j.crypto.Credentials;

import java.math.BigInteger;


public class TokenBridge {
  static final Logger LOG = LogManager.getLogger(TokenBridge.class);

  public static final int NUM_TIMES_EXECUTE = 10;

  public static void main(String[] args) throws Exception {
    StatsHolder.log("Example: Token Bridge");
    LOG.info("Started");

    if (args.length != 1) {
      LOG.info("Usage: [properties file name]");
      return;
    }

    PropertiesLoader propsLoader = new PropertiesLoader(args[0]);
    Credentials creds = propsLoader.getCredentials();
    PropertiesLoader.BlockchainInfo root = propsLoader.getBlockchainInfo("ROOT");
    PropertiesLoader.BlockchainInfo bc2 = propsLoader.getBlockchainInfo("BC2");
    CrossBlockchainConsensusType consensusMethodology = propsLoader.getConsensusMethodology();
    StatsHolder.log(consensusMethodology.name());
    ExecutionEngineType engineType = propsLoader.getExecutionEnngine();
    StatsHolder.log(engineType.name());

    // Set-up GPACT contracts: Deploy Crosschain Control and Registrar contracts on
    // each blockchain.
    CbcManager cbcManager = new CbcManager(consensusMethodology);
    cbcManager.addBlockchainAndDeployContracts(creds, root);
    cbcManager.addBlockchainAndDeployContracts(creds, bc2);
    // Have each Crosschain Control contract trust the Crosschain Control
    // contracts on the other blockchains.
    cbcManager.setupCrosschainTrust();
    // To keep the example simple, just have one signer for all blockchains.
    AnIdentity globalSigner = new AnIdentity();
    cbcManager.registerSignerOnAllBlockchains(globalSigner);

    final int CHAIN_A_TOKEN_SUPPLY = 1000;
    final int CHAIN_B_TOKEN_SUPPLY = 2000;

    // Set-up classes to manage blockchains.
    Credentials erc20OwnerCreds = propsLoader.getCredentials();
    SourceAndDestinationBlockchain chainA = new SourceAndDestinationBlockchain(
            "ChainA", BigInteger.valueOf(CHAIN_A_TOKEN_SUPPLY),
            erc20OwnerCreds, root.bcId, root.uri, root.gasPriceStrategy, root.period);
    SourceAndDestinationBlockchain chainB = new SourceAndDestinationBlockchain(
            "ChainB", BigInteger.valueOf(CHAIN_B_TOKEN_SUPPLY),
            erc20OwnerCreds, bc2.bcId, bc2.uri, bc2.gasPriceStrategy, bc2.period);

    // Deploy application contracts.
    BigInteger chainABcId = chainA.getBlockchainId();
    chainA.deployContract(cbcManager.getCbcAddress(chainABcId));
    BigInteger chainBBcId = chainB.getBlockchainId();
    chainB.deployContract(cbcManager.getCbcAddress(chainBBcId));

    // Register the ERC20 contracts with each other.
    chainA.addRemoteERC20(chainBBcId, chainB.getErc20ContractAddress());
    chainB.addRemoteERC20(chainABcId, chainA.getErc20ContractAddress());


      // Create some users and give them some tokens.
    Erc20User user1 = new Erc20User(
            "User1",
            root.bcId, root.uri, root.gasPriceStrategy, root.period, chainA.getErc20ContractAddress(),
            bc2.bcId, bc2.uri, bc2.gasPriceStrategy, bc2.period, chainB.getErc20ContractAddress());
    Erc20User user2 = new Erc20User(
            "User2",
            root.bcId, root.uri, root.gasPriceStrategy, root.period, chainA.getErc20ContractAddress(),
            bc2.bcId, bc2.uri, bc2.gasPriceStrategy, bc2.period, chainB.getErc20ContractAddress());
    Erc20User user3 = new Erc20User(
            "User3",
            root.bcId, root.uri, root.gasPriceStrategy, root.period, chainA.getErc20ContractAddress(),
            bc2.bcId, bc2.uri, bc2.gasPriceStrategy, bc2.period, chainB.getErc20ContractAddress());

    user1.createCbcManager(
            consensusMethodology,
            root, cbcManager.getCbcAddress(chainABcId),
            bc2, cbcManager.getCbcAddress(chainBBcId),
            globalSigner);
    user2.createCbcManager(
            consensusMethodology,
            root, cbcManager.getCbcAddress(chainABcId),
            bc2, cbcManager.getCbcAddress(chainBBcId),
            globalSigner);
    user3.createCbcManager(
            consensusMethodology,
            root, cbcManager.getCbcAddress(chainABcId),
            bc2, cbcManager.getCbcAddress(chainBBcId),
            globalSigner);


      // Give some balance to the users
    chainA.giveTokens(user1, 500);
    chainA.giveTokens(user2, 200);
    chainA.giveTokens(user3, 300);

    Erc20User[] users = new Erc20User[]{user1, user2, user3};

    chainA.showErc20Balances(users);
    chainB.showErc20Balances(users);

    for (int numExecutions = 0; numExecutions < NUM_TIMES_EXECUTE; numExecutions++) {
      LOG.info("Execution: {}  *****************", numExecutions);
      StatsHolder.log("Execution: " + numExecutions + " **************************");

      user1.transfer(true, numExecutions + 7);

      chainA.showErc20Balances(users);
      chainB.showErc20Balances(users);

//      try {
//        throw new Exception("Exception now thrown as expected");
//      } catch (Exception ex) {
//        LOG.info("Exception thrown as expected: not enough train seats");
//      }
    }

    chainA.shutdown();
    chainB.shutdown();
    user1.shutdown();
    user2.shutdown();
    user3.shutdown();

    StatsHolder.log("End");
    StatsHolder.print();
  }
}