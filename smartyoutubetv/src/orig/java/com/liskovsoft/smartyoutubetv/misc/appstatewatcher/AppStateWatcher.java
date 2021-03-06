package com.liskovsoft.smartyoutubetv.misc.appstatewatcher;

import android.app.Activity;
import com.liskovsoft.smartyoutubetv.flavors.common.FragmentManagerActivity;
import com.liskovsoft.smartyoutubetv.misc.appstatewatcher.handlers.ATVChannelsHandler;
import com.liskovsoft.smartyoutubetv.misc.appstatewatcher.handlers.ATVYouTubeBridgeHandler;
import com.liskovsoft.smartyoutubetv.misc.appstatewatcher.handlers.AdBlockPermissionsHandler;
import com.liskovsoft.smartyoutubetv.misc.appstatewatcher.handlers.AmazonYouTubeBridgeHandler;
import com.liskovsoft.smartyoutubetv.misc.appstatewatcher.handlers.ApkUpdaterHandler;
import com.liskovsoft.smartyoutubetv.misc.appstatewatcher.handlers.BackupAndRestoreHandler;
import com.liskovsoft.smartyoutubetv.misc.appstatewatcher.handlers.CacheCleanHandler;
import com.liskovsoft.smartyoutubetv.misc.appstatewatcher.handlers.ForceNewUIHandler;
import com.liskovsoft.smartyoutubetv.misc.appstatewatcher.handlers.LoadingCheckHandler;

public class AppStateWatcher extends AppStateWatcherBase {
    public AppStateWatcher(Activity context) {
        super(context);

        //addHandler(new ForceNewUIHandler(context));

        addHandler(new AdBlockPermissionsHandler(context, this));

        addHandler(new ApkUpdaterHandler(context, this));

        addHandler(new ATVYouTubeBridgeHandler(context, this));
        addHandler(new AmazonYouTubeBridgeHandler(context, this));

        if (context instanceof FragmentManagerActivity) {
            addHandler(new LoadingCheckHandler((FragmentManagerActivity) context));
        }

        addHandler(new CacheCleanHandler(context));

        addHandler(new BackupAndRestoreHandler(context, this));

        // update recommendations
        addHandler(new ATVChannelsHandler(context));
    }

}
