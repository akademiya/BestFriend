package com.example.user.bestfriends.calendar;


import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.user.bestfriends.BaseActivity;
import com.example.user.bestfriends.R;
import com.example.user.bestfriends.calendar.notification.NotificationReceiver;
import com.example.user.bestfriends.settings.SettingsView;

import javax.inject.Inject;

public class HCalendarView extends BaseActivity {

    @Inject
    HCalendarPresenter presenter;

    private int NOTIFICATION_ID = 100;
    private NotificationManager notificationManager;
    private Switch calendar_push_notification;
    private String selectedDate;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_calendar);
        mContext = getApplicationContext();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // TODO: show string selected date
        TextView text_calendar_day = findViewById(R.id.text_calendar_day);
        CalendarView calendarView = findViewById(R.id.calendar_view);
        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            selectedDate = new StringBuilder()
                    .append("Сегодня ").append(dayOfMonth).append(" число, ")
                    .append(month + 1).append(" месяц, ")
                    .append(year).append(" год").toString();
            text_calendar_day.setText(selectedDate);

        });
        // TODO: end string selected date

        calendar_push_notification = findViewById(R.id.calendar_push_notification);
        calendar_push_notification.setOnCheckedChangeListener((CompoundButton buttonView, boolean isChecked) -> {
            if (calendar_push_notification.isChecked()) {
                NotificationReceiver.scheduleRepeatingRTCNotification(mContext);
                NotificationReceiver.enableBootReceiver(mContext);
            } else if (!calendar_push_notification.isChecked()) {
                NotificationReceiver.cancelAlarmRTC();
                NotificationReceiver.disableBootReceiver(mContext);
            }

        });

    }

    // TODO: app bar menu переход в activity по клику на item
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_settings:
                startActivity(SettingsView.getStartIntent(this));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    // TODO: end app bar menu переход в activity по клику на item

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, HCalendarView.class);
        return intent;
    }

//    public void createNotification() {
//// инициализируем интерфейс NotificationCompat.Builder
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
//        builder.setSmallIcon(android.R.drawable.ic_menu_my_calendar);
//
//        // устанавливаем объект PendingIntent, большую иконку, заголовки и контент
//        builder.setSmallIcon(android.R.drawable.ic_menu_my_calendar);
//        builder.setContentTitle(selectedDate);
//        builder.setContentText("Пора проводить утреннюю службу ОС");
//
//        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//
//        // отображаем объект Notification в панели уведомлений
//        notificationManager.notify(NOTIFICATION_ID, builder.build());
//
//        // TODO: repeat notification
//        Intent intent = new Intent(getApplicationContext(),
//                NotificationReceiver.class);
//        PendingIntent pi = PendingIntent.getBroadcast(getApplicationContext(),
//                1,
//                intent,
//                PendingIntent.FLAG_UPDATE_CURRENT);
//        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
//        java.util.Calendar calendar = java.util.Calendar.getInstance();
//
//        calendar.set(java.util.Calendar.DAY_OF_WEEK,
//                Calendar.DAY_OF_WEEK);
//        calendar.set(java.util.Calendar.HOUR_OF_DAY,
//                20);
//        calendar.set(java.util.Calendar.MINUTE,
//                30);
//        calendar.set(java.util.Calendar.SECOND,
//                0);
//
//        alarmManager.setExact(AlarmManager.RTC, calendar.getTimeInMillis(), pi);
//        // TODO: end repeat notification
//    }
//
//    public void cancelNotification() {
//        notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
//        assert notificationManager != null;
//        notificationManager.cancel(NOTIFICATION_ID);
//    }

}