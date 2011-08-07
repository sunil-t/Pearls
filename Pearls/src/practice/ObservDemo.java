package practice;

import java.util.Observable;
import java.util.Observer;

/**
 * A simple demo of Observable->Observer
 * 
 * @author Sunil Thunuguntla
 */
public class ObservDemo extends Object {
  MyView view;
  
  MyView view2;

  MyModel model;
  
  MyModel model2;

  public ObservDemo() {

    view = new MyView();

    model = new MyModel();
    model.addObserver(view);
    
    model2 = new MyModel();
    model2.addObserver(view);
    
  }

  public static void main(String[] av) {
    ObservDemo me = new ObservDemo();
    me.demo();
  }

  public void demo() {
    model.changeSomething();
    model2.changeSomething();
  }

  /** The Observer normally maintains a view on the data */
  class MyView implements Observer {
    /** For now, we just print the fact that we got notified. */
    public void update(Observable obs, Object x) {
      System.out.println("update(" + obs + "," + x + ");");
    }
  }

  /** The Observable normally maintains the data */
  class MyModel extends Observable {
    public void changeSomething() {
      // Notify observers of change
      setChanged();
      notifyObservers();
    }
  }
}