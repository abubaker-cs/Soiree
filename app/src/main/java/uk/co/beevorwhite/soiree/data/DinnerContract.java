package uk.co.beevorwhite.soiree.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public class DinnerContract {

    // content authority constants
    public static final String CONTENT_AUTHORITY = "uk.co.beevorwhite.soiree";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_DINNER = "dinner";


    // empty constructor
    private DinnerContract() {
    }

    public static final class DinnerEntry implements BaseColumns {

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_DINNER);

        // MIME type for directory of items
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_DINNER;
        // MIME type for single item
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_DINNER;

        // table name
        public static final String TABLE_DINNER = "dinner";


        public static final String _ID = BaseColumns._ID;
        public static final String DINNER_NAME = "dinner_name";
        public static final String STARTER_ID = "starter_id";
        public static final String STARTER_NAME = "starter_name";
        public static final String STARTER_URI = "starter_uri";
        public static final String STARTER_IMAGE = "starter_image";
        public static final String STARTER_NOTES = "starter_notes";
        public static final String MAIN_ID = "main_id";
        public static final String MAIN_NAME = "main_name";
        public static final String MAIN_URI = "main_uri";
        public static final String MAIN_IMAGE = "main_image";
        public static final String MAIN_NOTES = "main_notes";
        public static final String PUDDING_ID = "pudding_id";
        public static final String PUDDING_NAME = "pudding_name";
        public static final String PUDDING_URI = "pudding_uri";
        public static final String PUDDING_IMAGE = "pudding_image";
        public static final String PUDDING_NOTES = "pudding_notes";
        public static final String GUEST_LIST = "guest_list";

    }
}
