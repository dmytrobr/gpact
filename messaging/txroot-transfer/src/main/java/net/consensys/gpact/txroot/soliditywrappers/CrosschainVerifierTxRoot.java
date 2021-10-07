package net.consensys.gpact.txroot.soliditywrappers;

import java.math.BigInteger;
import java.util.Arrays;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.8.5-SNAPSHOT.
 */
@SuppressWarnings("rawtypes")
public class CrosschainVerifierTxRoot extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5060405161118d38038061118d83398101604081905261002f91610054565b600080546001600160a01b0319166001600160a01b0392909216919091179055610084565b60006020828403121561006657600080fd5b81516001600160a01b038116811461007d57600080fd5b9392505050565b6110fa806100936000396000f3fe608060405234801561001057600080fd5b506004361061002b5760003560e01c80634c1ce90214610030575b600080fd5b61004361003e366004610e06565b610045565b005b600061008683838080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152506102b692505050565b600054815160208301516040808501516060860151608087015160a0880151935163917ede9960e01b81529798506001600160a01b039096169663917ede99966100d69695949091600401610ee5565b60206040518083038186803b1580156100ee57600080fd5b505afa158015610102573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906101269190610faa565b508051871461018d5760405162461bcd60e51b815260206004820152602860248201527f4576656e74206e6f7420656d697474656420627920657870656374656420626c60448201526737b1b5b1b430b4b760c11b60648201526084015b60405180910390fd5b60006101a461019f8360600151610586565b6105d5565b905060006101cb826001815181106101be576101be610fd3565b60200260200101516106b6565b905060606101de84602001518a84610733565b602080870151604051929450600093506101fe928e928e91879101610fe9565b60408051601f198184030181526020601f8c018190048102840181019092528a835292506102489183918c908c908190840183828082843760009201919091525061089e92505050565b6102a95760405162461bcd60e51b815260206004820152602c60248201527f4578706563746564206576656e7420646f6573206e6f74206d6174636820657660448201526b32b73a1034b710383937b7b360a11b6064820152608401610184565b5050505050505050505050565b6040805160c08101825260008082526020820181905291810182905260608082018190526080820181905260a0820152906102f361019f84610586565b90506000610317610310836000815181106101be576101be610fd3565b60006108cb565b9050600061033b610334846001815181106101be576101be610fd3565b6014015190565b9050600061035f610358856002815181106101be576101be610fd3565b6000610931565b90506000610379856003815181106101be576101be610fd3565b905060006103a08660048151811061039357610393610fd3565b60200260200101516105d5565b905060006103ba8760058151811061039357610393610fd3565b905080518251146104285760405162461bcd60e51b815260206004820152603260248201527f4c656e677468206f662070726f6f664f66667365747320646f6573206e6f742060448201527136b0ba31b4103632b733ba3410383937b7b360711b6064820152608401610184565b6000825167ffffffffffffffff8111156104445761044461102f565b60405190808252806020026020018201604052801561046d578160200160208202803683370190505b5090506000825167ffffffffffffffff81111561048c5761048c61102f565b6040519080825280602002602001820160405280156104bf57816020015b60608152602001906001900390816104aa5790505b50905060005b8351811015610549576104e66103108683815181106101be576101be610fd3565b8382815181106104f8576104f8610fd3565b6020026020010181815250506105198482815181106101be576101be610fd3565b82828151811061052b5761052b610fd3565b602002602001018190525080806105419061105b565b9150506104c5565b506040805160c0810182529889526001600160a01b0390971660208901529587019490945250506060840152608083015260a08201529392505050565b60408051808201909152600080825260208201528151806105bc5750506040805180820190915260008082526020820152919050565b6040805180820190915260209384018152928301525090565b60606105e082610996565b6105e957600080fd5b60006105f4836109bd565b90508067ffffffffffffffff81111561060f5761060f61102f565b60405190808252806020026020018201604052801561065457816020015b604080518082019091526000808252602082015281526020019060019003908161062d5790505b509150600061066284610a4f565b905060005b61067082610aaa565b156106ae5761067e82610ace565b84828151811061069057610690610fd3565b602002602001018190525080806106a69061105b565b915050610667565b505050919050565b60606106c182610b28565b6106ca57600080fd5b6000806106d684610b4e565b90925090508067ffffffffffffffff8111156106f4576106f461102f565b6040519080825280601f01601f19166020018201604052801561071e576020820181803683370190505b50925061072c828483610bf2565b5050919050565b606080600061074461019f85610586565b9050600061075e8260038151811061039357610393610fd3565b905060005b815181101561083f57600061078383838151811061039357610393610fd3565b905060006107a0610334836000815181106101be576101be610fd3565b90506107b88260018151811061039357610393610fd3565b96506107d0826002815181106101be576101be610fd3565b955060006107f7886000815181106107ea576107ea610fd3565b6020026020010151610c30565b9050898114801561081957508a6001600160a01b0316826001600160a01b0316145b1561082957505050505050610896565b50505080806108379061105b565b915050610763565b5060405162461bcd60e51b815260206004820152602560248201527f4e6f206576656e7420666f756e6420696e207472616e73616374696f6e20726560448201526418d95a5c1d60da1b6064820152608401610184565b935093915050565b600081518351146108b1575060006108c5565b818051906020012083805190602001201490505b92915050565b60006108d8826020611076565b835110156109285760405162461bcd60e51b815260206004820152601e60248201527f736c6963696e67206f7574206f662072616e6765202875696e743235362900006044820152606401610184565b50016020015190565b60008060005b602081101561098e5761094b81600861108e565b856109568387611076565b8151811061096657610966610fd3565b01602001516001600160f81b031916901c9190911790806109868161105b565b915050610937565b509392505050565b60008160200151600014156109ad57506000919050565b50515160c060009190911a101590565b60006109c882610996565b6109d457506000919050565b81518051600090811a91906109e885610c3b565b6109f29083611076565b905060006001866020015184610a089190611076565b610a1291906110ad565b905060005b818311610a4557610a2783610cc9565b610a319084611076565b925080610a3d8161105b565b915050610a17565b9695505050505050565b6040805160808101825260009181018281526060820183905281526020810191909152610a7b82610996565b610a8457600080fd5b6000610a8f83610c3b565b8351610a9b9190611076565b92825250602081019190915290565b80516020810151815160009291610ac091611076565b836020015110915050919050565b6040805180820190915260008082526020820152610aeb82610aaa565b1561002b5760208201516000610b0082610cc9565b828452602084018190529050610b168183611076565b602085015250610b239050565b919050565b6000816020015160001415610b3f57506000919050565b50515160c060009190911a1090565b600080610b5a83610b28565b610b6357600080fd5b8251805160001a906080821015610b7f57946001945092505050565b60b8821015610bad5760018560200151610b9991906110ad565b9250610ba6816001611076565b9350610beb565b602085015160b6198301908190610bc6906001906110ad565b610bd091906110ad565b9350610bdc8183611076565b610be7906001611076565b9450505b5050915091565b6020601f820104836020840160005b83811015610c1d57602081028381015190830152600101610c01565b5050505060008251602001830152505050565b60006108c582610d67565b6000816020015160001415610c5257506000919050565b8151805160001a906080821015610c6d575060009392505050565b60b8821080610c88575060c08210158015610c88575060f882105b15610c97575060019392505050565b60c0821015610cbe57610cab60b7836110ad565b610cb6906001611076565b949350505050565b610cab60f7836110ad565b8051600090811a6080811015610ce25760019150610d61565b60b8811015610d0857610cf66080826110ad565b610d01906001611076565b9150610d61565b60c0811015610d3157600183015160b76020839003016101000a9004810160b519019150610d61565b60f8811015610d4557610cf660c0826110ad565b600183015160f76020839003016101000a9004810160f5190191505b50919050565b6000610d7282610b28565b610d7b57600080fd5b600080610d8784610b4e565b90925090506020811115610d9a57600080fd5b80610da9575060009392505050565b806020036101000a82510492505050919050565b60008083601f840112610dcf57600080fd5b50813567ffffffffffffffff811115610de757600080fd5b602083019150836020828501011115610dff57600080fd5b9250929050565b60008060008060008060808789031215610e1f57600080fd5b8635955060208701359450604087013567ffffffffffffffff80821115610e4557600080fd5b610e518a838b01610dbd565b90965094506060890135915080821115610e6a57600080fd5b50610e7789828a01610dbd565b979a9699509497509295939492505050565b60005b83811015610ea4578181015183820152602001610e8c565b83811115610eb3576000848401525b50505050565b60008151808452610ed1816020860160208601610e89565b601f01601f19169290920160200192915050565b8681526000602060018060a01b0388168184015286604084015260c06060840152610f1360c0840187610eb9565b838103608085015285518082528287019183019060005b81811015610f4657835183529284019291840191600101610f2a565b505084810360a086015285518082528382019250600581901b8201840184880160005b83811015610f9757601f19858403018652610f85838351610eb9565b95870195925090860190600101610f69565b50909d9c50505050505050505050505050565b600060208284031215610fbc57600080fd5b81518015158114610fcc57600080fd5b9392505050565b634e487b7160e01b600052603260045260246000fd5b8481526bffffffffffffffffffffffff198460601b1660208201528260348201526000825161101f816054850160208701610e89565b9190910160540195945050505050565b634e487b7160e01b600052604160045260246000fd5b634e487b7160e01b600052601160045260246000fd5b600060001982141561106f5761106f611045565b5060010190565b6000821982111561108957611089611045565b500190565b60008160001904831182151516156110a8576110a8611045565b500290565b6000828210156110bf576110bf611045565b50039056fea2646970667358221220635d2dd86714ca12ec86ba118a7797dba2abcf8194150e20b3060c6d4594e4c664736f6c63430008090033";

    public static final String FUNC_DECODEANDVERIFYEVENT = "decodeAndVerifyEvent";

    @Deprecated
    protected CrosschainVerifierTxRoot(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected CrosschainVerifierTxRoot(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected CrosschainVerifierTxRoot(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected CrosschainVerifierTxRoot(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    @Deprecated
    public static CrosschainVerifierTxRoot load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new CrosschainVerifierTxRoot(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static CrosschainVerifierTxRoot load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new CrosschainVerifierTxRoot(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static CrosschainVerifierTxRoot load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new CrosschainVerifierTxRoot(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static CrosschainVerifierTxRoot load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new CrosschainVerifierTxRoot(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<CrosschainVerifierTxRoot> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _txReceiptRootStorage) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _txReceiptRootStorage)));
        return deployRemoteCall(CrosschainVerifierTxRoot.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<CrosschainVerifierTxRoot> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _txReceiptRootStorage) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _txReceiptRootStorage)));
        return deployRemoteCall(CrosschainVerifierTxRoot.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<CrosschainVerifierTxRoot> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _txReceiptRootStorage) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _txReceiptRootStorage)));
        return deployRemoteCall(CrosschainVerifierTxRoot.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<CrosschainVerifierTxRoot> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _txReceiptRootStorage) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _txReceiptRootStorage)));
        return deployRemoteCall(CrosschainVerifierTxRoot.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
