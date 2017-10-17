package megha.jindal.firebase;

import io.reactivex.Completable;

/**
 * Created by Megha Chauhan on 15-Oct-17.
 */

public interface AuthSource {
// public void  login(Data data);
 public Completable createacc(Data data);
 public Completable login(Data data);
}
