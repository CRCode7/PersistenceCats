package com.crcr.listagatos.Menu_Opciones;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.crcr.listagatos.R;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ContactoActivity extends AppCompatActivity {

    String contraseña;
    String correo;

    EditText ETnombre;
    EditText ETcorreo;
    EditText ETmensaje;
    Button enviar;

    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

       ETnombre = (EditText) findViewById(R.id.ETnombre);
        ETcorreo = (EditText) findViewById(R.id.ETcorreo);
        ETmensaje = (EditText) findViewById(R.id.ETmensaje);

        correo ="777correodeprueba777@gmail.com";


        enviar = (Button) findViewById(R.id.enviar);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);

                Properties properties = new Properties();
                properties.put("mail.smtp.host","smtp.googlemail.com");
                properties.put("mail.smtp.socketFactory.port","465");
                properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
                properties.put("mail.smtp.auth","true");
                properties.put("mail.smtp.port","465");

                try{
                    session = Session.getDefaultInstance(properties, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(correo,contraseña);
                        }
                    });

                    if(session!=null){
                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(correo));
                        message.setSubject("Contacto");
                        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("ccornejo1988@gmail.com"));
                        message.setContent(ETmensaje.getText().toString(),"text/html; charset=utf-8");

                        Transport.send(message);
                    }

                }catch(Exception e){
                    e.printStackTrace();
                }

            }

        });

    }
}
