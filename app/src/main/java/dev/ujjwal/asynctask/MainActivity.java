package dev.ujjwal.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView1, textView2, textView3;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setVisibility(View.INVISIBLE);
                new TestAsyncTask1().execute(8);
                new TestAsyncTask2().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, 8);
                //new TestAsyncTask3().executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, 8);
                new TestAsyncTask3().execute(8);
            }
        });
    }

    private class TestAsyncTask1 extends AsyncTask<Integer, Integer, Boolean> {
        int i = 0;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            textView1.setText("onPreExecute\n");
        }

        @Override
        protected Boolean doInBackground(Integer... integers) {
            final Integer num = integers[0];
            while (i != num) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(++i);
            }
            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            textView1.append(values[0] + " ");
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            textView1.append("\nonPostExecute");
        }
    }

    private class TestAsyncTask2 extends AsyncTask<Integer, Integer, Boolean> {
        int i = 0;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            textView2.setText("onPreExecute\n");
        }

        @Override
        protected Boolean doInBackground(Integer... integers) {
            final Integer num = integers[0];
            while (i != num) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(++i);
            }
            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            textView2.append(values[0] + " ");
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            textView2.append("\nonPostExecute");
        }
    }

    private class TestAsyncTask3 extends AsyncTask<Integer, Integer, Boolean> {
        int i = 0;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            textView3.setText("onPreExecute\n");
        }

        @Override
        protected Boolean doInBackground(Integer... integers) {
            final Integer num = integers[0];
            while (i != num) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(++i);
            }
            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            textView3.append(values[0] + " ");
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            textView3.append("\nonPostExecute");
            button.setVisibility(View.VISIBLE);
        }
    }
}
