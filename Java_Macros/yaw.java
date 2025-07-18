// Simcenter STAR-CCM+ macro: yaw.java
// Written by Simcenter STAR-CCM+ 18.06.006
package macro;

import java.util.*;
import java.io.File;
import star.common.*;
import star.base.neo.*;

public class yaw extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    ScalarGlobalParameter scalarGlobalParameter_0 = 
      ((ScalarGlobalParameter) simulation_0.get(GlobalParameterManager.class).getObject("Yaw"));

    Units units_0 = 
      ((Units) simulation_0.getUnitsManager().getObject(""));

    scalarGlobalParameter_0.getQuantity().setValueAndUnits(2.0, units_0);

    String FileName = simulation_0.getPresentationName();
    simulation_0.saveState(resolvePath(FileName + ".sim"));

  }
}
