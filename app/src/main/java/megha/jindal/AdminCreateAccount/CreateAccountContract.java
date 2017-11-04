package megha.jindal.AdminCreateAccount;

import android.graphics.Paint;

/**
 * Created by Megha Chauhan on 16-Oct-17.
 */

public interface CreateAccountContract {
    interface view {
        String getEmail();

        String getPassword();

        void showProgressbar(Boolean show);

        void showToast(String message);

        void startLoginActivity();
    }

    interface presenter {
        public void OnCreateClick();
    }
}
