package com.kercer.kerkee.activity;

import android.app.Application;

import com.kercer.kerkeeplus.deploy.KCDek;
import com.kercer.kerkeeplus.deploy.KCDeployError;
import com.kercer.kerkeeplus.deploy.KCDeployFlow;
import com.kercer.kerkeeplus.deploy.KCWebAppManager;

import java.io.File;

public class KCApplication extends Application {
    public static Application instance;
    KCWebAppManager mWebAppManager;
    @Override
    public void onCreate() {
        super.onCreate();
        deployWebApp();

        instance = this;
    }

    private void deployWebApp()
    {
        mWebAppManager = new KCWebAppManager(this, "html.zip", new KCDeployFlow()
        {
            @Override
            public File decodeFile(File aSrcFile, KCDek aDek)
            {
                return aSrcFile;
            }

            @Override
            public void onComplete(KCDek aDek)
            {

            }

            @Override
            public void onDeployError(KCDeployError aError, KCDek aDek)
            {

            }
        });
    }
}
