// Simcenter STAR-CCM+ macro: sc.java
// Written by Simcenter STAR-CCM+ 19.06.009
package macro;

import java.util.*;
import java.io.File;
import star.common.*;
import star.base.neo.*;
import star.vis.*;

public class sc extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Scene scene_2 = 
      simulation_0.getSceneManager().getScene("x=-500");

    CurrentView currentView_0 = 
      scene_2.getCurrentView();

    Units units_0 = 
      ((Units) simulation_0.getUnitsManager().getObject("mm"));

    currentView_0.getFocalPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {408.46572891602176, 25.0, 585.0020025736011}));

    currentView_0.getPositionCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {100562.35308548197, 25.0, 585.0020025736011}));

    Scene scene_3 = 
      simulation_0.getSceneManager().getScene("x=1350");

    CurrentView currentView_1 = 
      scene_3.getCurrentView();

    currentView_1.getFocalPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {408.46572891602176, 25.0, 585.0020025736011}));

    currentView_1.getPositionCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {100562.35308548197, 25.0, 585.0020025736011}));

    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("y=-600");

    CurrentView currentView_2 = 
      scene_0.getCurrentView();

    currentView_2.getFocalPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1480.0, 247.58547478086257, 703.448641768538}));

    currentView_2.getPositionCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1480.0, -99969.03212128211, 703.448641768538}));

    Scene scene_4 = 
      simulation_0.getSceneManager().getScene("y=0");

    CurrentView currentView_3 = 
      scene_4.getCurrentView();

    currentView_3.getFocalPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1480.0, 247.58547478086257, 703.448641768538}));

    currentView_3.getPositionCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1480.0, -99969.03212128211, 703.448641768538}));

    Scene scene_5 = 
      simulation_0.getSceneManager().getScene("y=600");

    CurrentView currentView_4 = 
      scene_5.getCurrentView();

    currentView_4.getFocalPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1480.0, 247.58547478086257, 703.448641768538}));

    currentView_4.getPositionCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1480.0, -99969.03212128211, 703.448641768538}));

    Scene scene_1 = 
      simulation_0.getSceneManager().getScene("z=0");

    CurrentView currentView_5 = 
      scene_1.getCurrentView();

    currentView_5.getFocalPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1380.0, -62.420441784284186, 703.4486773800808}));

    currentView_5.getPositionCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1380.0, -62.420441784284186, 100920.0662378315}));

    Scene scene_6 = 
      simulation_0.getSceneManager().getScene("z=200");

    ScalarDisplayer scalarDisplayer_0 = 
      ((ScalarDisplayer) scene_6.getDisplayerManager().getObject("Scalar 1"));

    scalarDisplayer_0.getInputParts().setQuery(null);

    PlaneSection planeSection_0 = 
      ((PlaneSection) simulation_0.getPartManager().getObject("z=200"));

    scalarDisplayer_0.getInputParts().setObjects(planeSection_0);

    CurrentView currentView_6 = 
      scene_6.getCurrentView();

    currentView_6.getFocalPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1380.0, -62.420441784284186, 703.4486773800808}));

    currentView_6.getPositionCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1380.0, -62.420441784284186, 100920.0662378315}));

    Scene scene_7 = 
      simulation_0.getSceneManager().getScene("x=-500 copy copy");

    CurrentView currentView_7 = 
      scene_7.getCurrentView();

    currentView_7.getFocalPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {408.46572891602176, 25.0, 585.0020025736011}));

    currentView_7.getPositionCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {100562.35308548197, 25.0, 585.0020025736011}));

    Scene scene_8 = 
      simulation_0.getSceneManager().getScene("x=1350 copy copy");

    CurrentView currentView_8 = 
      scene_8.getCurrentView();

    currentView_8.getFocalPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {408.46572891602176, 25.0, 585.0020025736011}));

    currentView_8.getPositionCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {100562.35308548197, 25.0, 585.0020025736011}));

    currentView_2.getFocalPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1345.0, 247.58547478086257, 703.448641768538}));

    currentView_2.getPositionCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1345.0, -99969.03212128211, 703.448641768538}));

    currentView_3.getFocalPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1345.0, 247.58547478086257, 703.448641768538}));

    currentView_3.getPositionCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1345.0, -99969.03212128211, 703.448641768538}));

    currentView_4.getFocalPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1345.0, 247.58547478086257, 703.448641768538}));

    currentView_4.getPositionCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1345.0, -99969.03212128211, 703.448641768538}));

    Scene scene_9 = 
      simulation_0.getSceneManager().getScene("y=-600 copy copy");

    CurrentView currentView_9 = 
      scene_9.getCurrentView();

    currentView_9.getFocalPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1345.0, 247.58547478086257, 703.448641768538}));

    currentView_9.getPositionCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1345.0, -99969.03212128211, 703.448641768538}));

    Scene scene_10 = 
      simulation_0.getSceneManager().getScene("y=0 copy copy");

    CurrentView currentView_10 = 
      scene_10.getCurrentView();

    currentView_10.getPositionCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1345.0, -99969.03212128211, 703.448641768538}));

    currentView_10.getFocalPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1345.0, 247.58547478086257, 703.448641768538}));

    Scene scene_11 = 
      simulation_0.getSceneManager().getScene("y=600 copy copy");

    CurrentView currentView_11 = 
      scene_11.getCurrentView();

    currentView_11.getFocalPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1345.0, 247.58547478086257, 703.448641768538}));

    currentView_11.getPositionCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1345.0, -99969.03212128211, 703.448641768538}));

    Scene scene_12 = 
      simulation_0.getSceneManager().getScene("z=0 copy copy");

    CurrentView currentView_12 = 
      scene_12.getCurrentView();

    currentView_12.getFocalPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1380.0, -62.420441784284186, 703.4486773800808}));

    currentView_12.getPositionCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1380.0, -62.420441784284186, 100920.0662378315}));

    Scene scene_13 = 
      simulation_0.getSceneManager().getScene("z=200 copy copy");

    CurrentView currentView_13 = 
      scene_13.getCurrentView();

    currentView_13.getPositionCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1380.0, -62.420441784284186, 100920.0662378315}));

    currentView_13.getFocalPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1380.0, -62.420441784284186, 703.4486773800808}));

    Scene scene_14 = 
      simulation_0.getSceneManager().getScene("x=-500 copy");

    CurrentView currentView_14 = 
      scene_14.getCurrentView();

    currentView_14.getFocalPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {408.46572891602176, 25.0, 585.0020025736011}));

    currentView_14.getPositionCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {100562.35308548197, 25.0, 585.0020025736011}));

    Scene scene_15 = 
      simulation_0.getSceneManager().getScene("x=1350 copy");

    CurrentView currentView_15 = 
      scene_15.getCurrentView();

    currentView_15.getPositionCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {100562.35308548197, 25.0, 585.0020025736011}));

    currentView_15.getFocalPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {408.46572891602176, 25.0, 585.0020025736011}));

    Scene scene_16 = 
      simulation_0.getSceneManager().getScene("y=-600 copy");

    CurrentView currentView_16 = 
      scene_16.getCurrentView();

    currentView_16.getFocalPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1345.0, 247.58547478086257, 703.448641768538}));

    currentView_16.getPositionCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1345.0, -99969.03212128211, 703.448641768538}));

    Scene scene_17 = 
      simulation_0.getSceneManager().getScene("y=0 copy");

    CurrentView currentView_17 = 
      scene_17.getCurrentView();

    currentView_17.getPositionCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1345.0, -99969.03212128211, 703.448641768538}));

    Scene scene_18 = 
      simulation_0.getSceneManager().getScene("y=600 copy");

    CurrentView currentView_18 = 
      scene_18.getCurrentView();

    currentView_18.getPositionCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1345.0, -99969.03212128211, 703.448641768538}));

    currentView_17.getFocalPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1345.0, 247.58547478086257, 703.448641768538}));

    currentView_18.getFocalPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1345.0, 247.58547478086257, 703.448641768538}));

    Scene scene_19 = 
      simulation_0.getSceneManager().getScene("z=0 copy");

    CurrentView currentView_19 = 
      scene_19.getCurrentView();

    currentView_19.getFocalPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1380.0, -62.420441784284186, 703.4486773800808}));

    Scene scene_20 = 
      simulation_0.getSceneManager().getScene("z=200 copy");

    ScalarDisplayer scalarDisplayer_1 = 
      ((ScalarDisplayer) scene_20.getDisplayerManager().getObject("Scalar 1"));

    scalarDisplayer_1.getInputParts().setQuery(null);

    scalarDisplayer_1.getInputParts().setObjects(planeSection_0);

    CurrentView currentView_20 = 
      scene_20.getCurrentView();

    currentView_20.getFocalPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1380.0, -62.420441784284186, 703.4486773800808}));

    currentView_19.getPositionCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1380.0, -62.420441784284186, 100920.0662378315}));

    currentView_20.getPositionCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1380.0, -62.420441784284186, 100920.0662378315}));

    String FileName = simulation_0.getPresentationName();
    simulation_0.saveState(resolvePath(FileName + ".sim"));

  }
}
