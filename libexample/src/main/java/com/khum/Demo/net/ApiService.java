package com.khum.Demo.net;

import com.khum.Demo.test.TestData;

import io.reactivex.Observable;
import retrofit2.http.GET;


/**
 * <pre>
 *     author : khum
 *     time   : 2018/5/9
 *     desc   :
 * </pre>
 */
public interface ApiService {

    @GET("location/test")
    Observable<TestData> test();
}
