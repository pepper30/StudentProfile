package megha.jindal.AdminCreateAccount;

import android.graphics.Paint;

/**
 * Created by Megha Chauhan on 16-Oct-17.
 */

public interface CreateAccountContract {
    interface view {
        String getEmail();

        String getPassword();

        void ShowProgressbar(Boolean show);

        void ShowToast(String message);

        void StartLoginActivity();
    }

    interface presenter {
        public void OnCreateClick();
    }
}
