package com.khum.Demo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.libexample.R;
import com.khum.Demo.net.ApiService;
import com.khum.Demo.test.TestData;
import com.khum.lib.global.BaseActivity;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends BaseActivity {

    @Inject
    ApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.btn_get);
        TextView tv_get = findViewById(R.id.tv_test);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mApiService.test()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<TestData>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                CompositeDisposable compositeDisposable = new CompositeDisposable();
                                compositeDisposable.add(d);
                            }

                            @Override
                            public void onNext(TestData testData) {
                                tv_get.setText(testData.getErrorMessage());
                            }

                            @Override
                            public void onError(Throwable e) {
                                tv_get.setText(e.getMessage());
                            }

                            @Override
                            public void onComplete() {
                                Toast.makeText(MainActivity.this,
                                        "complete", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

    }
}
