package com.example.intentku;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonPindahActivity ,  buttonKirimData , buttonMaps , buttonCall , buttonSendTo , buttonSendToShare , buttonPick;
    private static final int PICK_CONTACT_REQUEST = 1;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPindahActivity= findViewById(R.id.buttonPindahActivity);
        buttonPindahActivity.setOnClickListener(this);

        buttonKirimData= findViewById(R.id.buttonKirimData);
        buttonKirimData.setOnClickListener(this);

        buttonMaps= findViewById(R.id.buttonMaps);
        buttonMaps.setOnClickListener(this);

        buttonCall= findViewById(R.id.buttonCall);
        buttonCall.setOnClickListener(this);

        buttonSendTo= findViewById(R.id.buttonSendTo);
        buttonSendTo.setOnClickListener(this);

        buttonSendToShare= findViewById(R.id.buttonSendToShare);
        buttonSendToShare.setOnClickListener(this);

        buttonPick= findViewById(R.id.buttonPick);
        buttonPick.setOnClickListener(this);

        textViewResult = findViewById(R.id.teksViewResult);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.buttonPindahActivity:
                Intent intentPindahActivity = new Intent(this, PindahActivity.class);
                startActivity(intentPindahActivity);
                break;
            case R.id.buttonKirimData:
                Intent intentKirimData = new Intent(this, ForResultActivity.class);
                intentKirimData.putExtra("extra_name", "Politeknik Negeri Jember");
                intentKirimData.putExtra("extra_umur", 40);
                startActivity(intentKirimData);
                break;
            case R.id.buttonMaps:
                Intent intentMaps = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:-8.1575041,113.7222517"));
                intentMaps.setPackage("com.google.android.apps.maps");
                if (intentMaps.resolveActivity(getPackageManager()) != null){
                    startActivity(intentMaps);
                }

            case R.id.buttonCall:
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:082301753605"));
                startActivity(intentCall);
                break;

            case R.id.buttonSendTo:
                Intent intentSend = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto: 082301753627"));
                intentSend.putExtra("sms_body", "Ayah, Ini aku ulfi. Tolong kirimi aku uang jajan");
                startActivity(intentSend);
                break;

            case R.id.buttonSendToShare:
                Intent intentShare = new Intent(Intent.ACTION_SEND);
                intentShare.putExtra(Intent.EXTRA_TEXT, "Kuyy !!! Belajar Android, Masio ngebug gapopo ");
                intentShare.setType("text/plain");
                startActivity(Intent.createChooser(intentShare, "Share Link"));
                break;

            case R.id.buttonPick:
                Intent pickContact = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
                pickContact.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
                startActivityForResult(pickContact, PICK_CONTACT_REQUEST);
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_CONTACT_REQUEST) {
            if (resultCode == RESULT_OK) {
                Uri contactUri = data.getData();
                String[] projection = {ContactsContract.CommonDataKinds.Phone.NUMBER};

                Cursor cursor = getContentResolver().query(contactUri, projection, null, null, null);
                cursor.moveToFirst();

                int column = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                String number = cursor.getString(column);
                textViewResult.setText(number);
            }
        }
    }
}