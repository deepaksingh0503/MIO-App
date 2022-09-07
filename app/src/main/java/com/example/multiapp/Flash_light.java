package com.example.multiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

public class Flash_light extends AppCompatActivity {

    ImageButton torchBtn;
    boolean state=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_light);
        torchBtn=findViewById(R.id.torch_btn);

        Dexter.withContext(this).withPermission(Manifest.permission.CAMERA).withListener(new PermissionListener() {
            @Override
            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                onFlashLight();
            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                Toast.makeText(Flash_light.this, "Camera Permmision is required to on torch!!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {

            }
        }).check();
    }

   private void onFlashLight(){
       torchBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               if(!state){
                   CameraManager cameraManager= (CameraManager) getSystemService(Context.CAMERA_SERVICE);
                   try{
                        String cameraId= cameraManager.getCameraIdList()[0];
                        cameraManager.setTorchMode(cameraId,true);
                        state=true;
                        torchBtn.setImageResource(R.drawable.torch_on);
                   }catch (CameraAccessException e){

                   }
               }else{
                   CameraManager cameraManager= (CameraManager) getSystemService(Context.CAMERA_SERVICE);
                   try{
                       String cameraId= cameraManager.getCameraIdList()[0];
                       cameraManager.setTorchMode(cameraId,false);
                       state=false;
                       torchBtn.setImageResource(R.drawable.torch_off);
                   }catch (CameraAccessException e){

                   }
               }

           }
       });
    }
}