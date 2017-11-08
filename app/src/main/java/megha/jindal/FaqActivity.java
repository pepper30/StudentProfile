package megha.jindal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FaqActivity extends AppCompatActivity {
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        text=findViewById(R.id.text);
        text.setText("Tell me about the most challenging engineering project that you have been involved with during past year.\n" +
                "Describe the most challenging written technical report or presentation that you've had to complete.\n" +
                "Describe an experience with a difficult client. How did you handle the situation? What would you have done differently?\n" +
                "Tell me about your greatest success in using logic to solve an engineering problem.\n" +
                "Give me an example of a time when you applied your ability to use analytical techniques to define problems or design solutions.\n" +
                "What checks and balances do you use to make sure that you don't make mistakes?\n" +
                "Do you have any patents? If so, tell me about them. If not, is that something you see yourself pursuing in the future? Why or why not?\n" +
                "What engineering skills have you developed or improved upon during the past year?\n" +
                "Which software packages are you familiar with? What is the most interesting thing you know how to do with one of these packages?\n" +
                "What are you doing to stay current with the latest technology?\n" +
                "Chat conversation end\n" +
                "Type a message...\n" +
                "\n" +
                "Choose Files\n" +
                "Choose Files\n");
    }
}
