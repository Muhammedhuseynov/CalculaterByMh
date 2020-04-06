package tm.learner.calcbymh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn1, btn2, btn3,
                   btn4, btn5, btn6,
                   btn7, btn8, btn9,
                   btnPlus,btnMin,btnRes,btnMultip,btnPersent,btnDivide,
                   btnAdder,btnClean;
    private EditText input;
    private StringBuilder txtBuilder;
    private String operation = "";
    private int num;
    private int num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        btnNumbers();
        btnWithIds();

        btnRes = findViewById(R.id.BtnRes);
        input = findViewById(R.id.input);
        btnClean = findViewById(R.id.btnClean);
        btnAdder.setOnClickListener(clickOperation);
        btnRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateedRes();
            }
        });

        btnClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("");
            }
        });


    }
    /// Buttons For Operations
    public void btnWithIds(){
        btnAdder = findViewById(R.id.btnAdd);
        btnMin = findViewById(R.id.btnMin);
        btnMultip = findViewById(R.id.btnMultiple);
        btnDivide = findViewById(R.id.btnDevide);
        btnPersent = findViewById(R.id.btnPercent);


        btnAdder.setOnClickListener(clickOperation);
        btnMin.setOnClickListener(clickOperation);
        btnPersent.setOnClickListener(clickOperation);
        btnDivide.setOnClickListener(clickOperation);
        btnMultip.setOnClickListener(clickOperation);

    }

    /// Button for Numbers
    public void btnNumbers(){
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);


        btn1.setOnClickListener(clickListener);
        btn2.setOnClickListener(clickListener);
        btn3.setOnClickListener(clickListener);
        btn4.setOnClickListener(clickListener);
        btn5.setOnClickListener(clickListener);
        btn6.setOnClickListener(clickListener);
        btn7.setOnClickListener(clickListener);
        btn8.setOnClickListener(clickListener);
        btn9.setOnClickListener(clickListener);
    }

    // Calculater
    public void calculateedRes(){
        if(!input.getText().toString().isEmpty()){
            num2 = Integer.parseInt(input.getText().toString());
            int result;
            if(operation.equals("+")) {
                result = num + num2;
                input.setText(String.valueOf(result));
                Toast.makeText(MainActivity.this, String.valueOf(result), Toast.LENGTH_SHORT).show();
            }
            if(operation.equals("-")) {
                result = num - num2;
                input.setText(String.valueOf(result));
                Toast.makeText(MainActivity.this, String.valueOf(result), Toast.LENGTH_SHORT).show();
            }
            if(operation.equals("*")) {
                result = num * num2;
                input.setText(String.valueOf(result));
                Toast.makeText(MainActivity.this, String.valueOf(result), Toast.LENGTH_SHORT).show();
            }
            if(operation.equals("/")) {
                result = num / num2;
                input.setText(String.valueOf(result));
                Toast.makeText(MainActivity.this, String.valueOf(result), Toast.LENGTH_SHORT).show();
            }
            if(operation.equals("%")) {
                result = num % num2;
                input.setText(String.valueOf(result));
                Toast.makeText(MainActivity.this, String.valueOf(result), Toast.LENGTH_SHORT).show();
            }
        }

    }


    // For btn clicked Operations
    private Button.OnClickListener clickOperation = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(input.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"0",Toast.LENGTH_SHORT).show();
            }
            else{
                switch (v.getId()){
                    case R.id.btnAdd:
                        num = Integer.parseInt(input.getText().toString());
                        operation = "+";
                        input.setText("");
                        break;
                    case R.id.btnMultiple:
                        num = Integer.parseInt(input.getText().toString());
                        operation = "*";
                        input.setText("");
                        break;
                    case R.id.btnMin:
                        num = Integer.parseInt(input.getText().toString());
                        operation = "-";
                        input.setText("");
                        break;
                    case R.id.btnDevide:
                        num = Integer.parseInt(input.getText().toString());
                        operation = "/";
                        input.setText("");
                        break;
                    case R.id.btnPercent:
                        num = Integer.parseInt(input.getText().toString());
                        operation = "%";
                        input.setText("");
                        break;
                }
            }

        }
    };

    // Buttom for getting clicked numbers
    private Button.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn1:
                    input.append("1");
                    break;
                case R.id.btn2:
                    input.append("2");
                    break;
                case R.id.btn3:
                    input.append("3");
                    break;
                case R.id.btn4:
                    input.append("4");
                    break;
                case R.id.btn5:
                    input.append("5");
                    break;
                case R.id.btn6:
                    input.append("6");
                    break;
                case R.id.btn7:
                    input.append("7");
                    break;
                case R.id.btn8:
                    input.append("8");
                    break;
                case R.id.btn9:
                    input.append("9");
                    break;
            }
        }
    };
}
