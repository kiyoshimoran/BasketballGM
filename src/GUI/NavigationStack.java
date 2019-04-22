package GUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Stack;

public class NavigationStack
{
    private static Stack<Stage> stageStack = new Stack<>(); // navigation logic
    private int WINDOW_WIDTH;
    private int WINDOW_HEIGHT;

    public NavigationStack(int window_width, int window_height)
    {
        WINDOW_WIDTH = window_width;
        WINDOW_HEIGHT = window_height;
    }

    public void performSegue(String resource, boolean backtrace)
    {
        if(stageStack.isEmpty())
        {
            Stage initialView = getStage(resource);
            System.out.println(resource);
            stageStack.push(initialView);
            initialView.show();
        }
        else
            {
            Stage destStage = getStage(resource);

            Stage parent;
            if (backtrace) {
                parent = stageStack.peek();
            } else // no parent screen reference saved
            {
                parent = stageStack.pop();
            }

            parent.hide();
            stageStack.push(destStage);
            destStage.show();
        }
    }

    public Stage getPreviousScreen()
    {
        return stageStack.peek();
    }

    public void unwind()
    {
        //pop current view
        Stage currentview = stageStack.pop();
        Stage parentView = stageStack.peek();
        currentview.close();
        parentView.show();
    }

    public void unwindLooped(int back)
    {
        Stage currentview = null;
        Stage parentView = null;
        while(back > 0)
        {
            currentview = stageStack.pop();
            parentView = stageStack.peek();
            currentview.close();
            back--;
        }
        parentView.show();
    }

    private Stage getStage(String resource)
    {
        Parent root;
        Stage stage;
        System.out.println(resource);
        try {
            root = FXMLLoader.load(getClass().getResource(resource));
            stage = new Stage();
            stage.setTitle("RealGM DB");
            stage.setScene(new Scene(root, WINDOW_WIDTH , WINDOW_HEIGHT));

            return stage;

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }

}
