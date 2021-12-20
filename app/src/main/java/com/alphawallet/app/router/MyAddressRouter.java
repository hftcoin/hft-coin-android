package com.alphawallet.app.router;

import static com.alphawallet.ethereum.EthereumNetworkBase.HFTC_ID;

import android.content.Context;
import android.content.Intent;

import com.alphawallet.app.C;
import com.alphawallet.app.ui.MyAddressActivity;
import com.alphawallet.app.entity.tokens.Token;
import com.alphawallet.app.entity.Wallet;

public class MyAddressRouter {

    public void open(Context context, Wallet wallet) {
        Intent intent = new Intent(context, MyAddressActivity.class);
        intent.putExtra(C.Key.WALLET, wallet);
        // Added by HFT
        intent.putExtra(C.EXTRA_CHAIN_ID, HFTC_ID);
        intent.putExtra(C.EXTRA_ADDRESS, C.HFTC_TOKEN);
        intent.setFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        context.startActivity(intent);
    }

    public void open(Context context, Wallet wallet, Token token) {
        Intent intent = new Intent(context, MyAddressActivity.class);
        intent.putExtra(C.Key.WALLET, wallet);
        intent.putExtra(C.EXTRA_CHAIN_ID, token.tokenInfo.chainId);
        intent.putExtra(C.EXTRA_ADDRESS, token.getAddress());
        intent.setFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        context.startActivity(intent);
    }
}
