package com.example.latihan.absensi;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.latihan.absensi.entity.LoginAbsensi;
import com.example.latihan.absensi.services.ApiClientLogin;
import com.example.latihan.absensi.services.ApiLoginInterface;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.gson.Gson;

import java.io.File;
import java.util.Date;
import java.util.Locale;

import in.mayanknagwanshi.imagepicker.ImageSelectActivity;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginAbsen extends AppCompatActivity {

    Button btnKamera, btnSubmit;
    ImageView imageView;
    private int requestCode = 1;
    String mediaPath;
//    String latitude = "0";
//    String longitude = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_absen);

        btnKamera = findViewById(R.id.btnKamera);
        btnSubmit = findViewById(R.id.btnSubmit);
        imageView = findViewById(R.id.imageView2);

        //GET LOCATION




        btnKamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gambar = new Intent(getApplicationContext(), ImageSelectActivity.class);
                gambar.putExtra(ImageSelectActivity.FLAG_COMPRESS, true);
                gambar.putExtra(ImageSelectActivity.FLAG_CAMERA, true);
                gambar.putExtra(ImageSelectActivity.FLAG_GALLERY, true);
                startActivityForResult(gambar, 1);
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onUploadProgress();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (this.requestCode == requestCode && resultCode == RESULT_OK) {
//            Uri selectedImage = data.getData();
//            String[] filePathColumn={MediaStore.Images.Media.DATA};
//            Cursor cursor = getContentResolver().query(selectedImage,filePathColumn,null,null,null);
//
//            assert cursor != null;
//            cursor.moveToFirst();
//            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);

            mediaPath = data.getStringExtra(ImageSelectActivity.RESULT_FILE_PATH);
//            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
//            requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), String.valueOf(bitmap));

            imageView.setImageBitmap(BitmapFactory.decodeFile(mediaPath));
        }
    }

    protected void onUploadProgress() {


        LoginAbsensi loginAbsensi = new LoginAbsensi();
        Date tglMasuk = new Date();
        String name = "test";
        loginAbsensi.setUsername(name);
        loginAbsensi.setTglMasuk(tglMasuk.toString());



        //get location


        Gson gson = new Gson();
        String json = gson.toJson(loginAbsensi);

        ApiLoginInterface apiLoginInterface = ApiClientLogin.getRetrofit().create(ApiLoginInterface.class);

        File file = new File(mediaPath);

        RequestBody requestBody = RequestBody.create(MediaType.parse("*/*"), file);

        MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("file", file.getName(), requestBody);
        RequestBody data = RequestBody.create(MediaType.parse("text/plain"), json);
        Call<String> call = apiLoginInterface.addLogin(fileToUpload, data);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                finish();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                System.out.println(t);

            }
        });

    }
    /*
    private void GetLocation() {
        FusedLocationProviderClient mFusedLocationProviderClient = LocationServices
                .getFusedLocationProviderClient(LoginAbsen.this);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Toast.makeText(LoginAbsen.this, "First enable LOCATION ACCESS in settings.", Toast.LENGTH_LONG).show();
            return;
        }
        mFusedLocationProviderClient.getLastLocation()
                .addOnSuccessListener(LoginAbsen.this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if (location != null){
                            latitude = String.valueOf(location.getLatitude());
                            longitude = String.valueOf(location.getLongitude());

                            ApiLoginInterface apiLoginInterface = ApiClientLogin.getRetrofit().create(ApiLoginInterface.class);
                            Call<LoginAbsensi> call = apiLoginInterface.getOneCallLogin(latitude,latitude);
                            call.enqueue(new Callback<LoginAbsensi>() {
                                @Override
                                public void onResponse(Call<LoginAbsensi> call, Response<LoginAbsensi> response) {
                                    System.out.println(response.body());
                                }

                                @Override
                                public void onFailure(Call<LoginAbsensi> call, Throwable t) {

                                }
                            });
                        }
                    }
                });
    }*/


}