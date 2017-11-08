package megha.jindal.FirebaseDatabase;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Megha Chauhan on 01-Nov-17.
 */

public interface DataSource {
    Completable createStudent(DataInfo dataInfo);
    Single<DataInfo> studentLogin(DataInfo dataInfo);
}
