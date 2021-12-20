package com.alphawallet.app.entity;

import com.alphawallet.app.repository.TokenRepository;
import com.alphawallet.token.tools.Numeric;

import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;

/**
 * Created by HFT on 21/10/2021.
 */

public class HFTCTransaction extends EtherscanEvent
{
    boolean status;
    public int index;
    public String cumulativeGasUsed;
    public String data; // input
    public String privateData;
    public boolean isPrivate;
    public long timestamp; // not timeStamp ...
    // public Object events;
    // public Object internalCalls;

    public Transaction createTransaction(@NotNull NetworkInfo networkInfo)
    {
        /*
        BigInteger valueBI = BigInteger.ZERO;
        if (value != null && value.length() > 0 && Character.isDigit(value.charAt(0)))
        {
            valueBI = new BigInteger(value);
        }

        String input = Numeric.toHexString(TokenRepository.createTokenTransferData(to, valueBI)); //write the input to the transaction to ensure this is correctly handled elsewhere in the wallet
         */

        return new Transaction(hash, "0", blockNumber, timestamp, nonce, from, contractAddress, "0", gas, gasPrice, data,
                gasUsed, networkInfo.chainId, false);
    }

    /*
    public Transaction createNFTTransaction(@NotNull NetworkInfo networkInfo)
    {
        BigInteger tokenId = BigInteger.ONE;
        try
        {
            tokenId = new BigInteger(tokenID);
        }
        catch (Exception e)
        {
            //no action, default to '1'
        }

        String input = Numeric.toHexString(TokenRepository.createERC721TransferFunction(from, to, contractAddress, tokenId)); //write the input to the transaction to ensure this is correctly handled elsewhere in the wallet

        return new Transaction(hash, "0", blockNumber, timestamp, nonce, from, contractAddress, "0", gas, gasPrice, input,
                gasUsed, networkInfo.chainId, false);
    }
     */
}
