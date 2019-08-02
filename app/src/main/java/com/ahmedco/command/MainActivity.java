package com.ahmedco.command;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ahmedco.command.test2.ActionListenerCommand;
import com.ahmedco.command.test2.ActionOpen;
import com.ahmedco.command.test2.ActionSave;
import com.ahmedco.command.test2.Document;
import com.ahmedco.command.test2.MenuOptions;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Test1();
        Test3();
       // Test2();

        WithoutCommand();
    }

    private void WithoutCommand() {
       // https://alvinalexander.com/java/java-command-design-pattern-in-java-examples
        /*
        Document e = ???;
        Object o = e.getSource();
        if (o instanceof fileNewMenuItem)
            doFileNewAction();
        else if (o instanceof fileOpenMenuItem)
            doFileOpenAction();
        else if (o instanceof fileOpenRecentMenuItem)
            doFileOpenRecentAction();
        else if (o instanceof fileSaveMenuItem)
            doFileSaveAction();
        // and more ...
        */
    }


    private void Test3() {
        Document doc = new Document();
        ActionListenerCommand clickOpen = new ActionOpen(doc);
        ActionListenerCommand clickSave = new ActionSave(doc);

        MenuOptions menu = new MenuOptions(clickOpen , clickSave);
        menu.clickOpen();
        menu.clickSave();
    }


    private void Test2(){
       //  https://www.youtube.com/watch?v=TaDk76RRwic
    }

    private void Test1(){
        // https://www.tutorialspoint.com/design_pattern/command_pattern
        Stock abcStock = new Stock();
        BuyStock buyStockOrder = new BuyStock(abcStock);
        SellStock sellStockOrder = new SellStock(abcStock);
        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);
        broker.placeOrders();

    }
}
