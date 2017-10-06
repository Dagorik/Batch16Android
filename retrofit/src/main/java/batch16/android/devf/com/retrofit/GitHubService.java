package batch16.android.devf.com.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Dagorik on 04/10/17.
 */

public interface GitHubService {

    @GET("/users/Dagorik")
    public Call<ResponseBody> getUserInfo();

    @GET("/users/{username}")
    public Call<ResponseBody> getUserInfoPath(@Path("username") String username);
}
