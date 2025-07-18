// Simcenter STAR-CCM+ macro: rans.java
// Written by Simcenter STAR-CCM+ 18.06.006
package macro;

import java.util.*;
import java.io.File;
import star.common.*;
import star.base.neo.*;

public class rans extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    simulation_0.getSimulationIterator().run();

    String FileName = simulation_0.getPresentationName();
    simulation_0.saveState(resolvePath(FileName + ".sim"));


  }
}
