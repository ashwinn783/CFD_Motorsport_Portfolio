// Simcenter STAR-CCM+ macro: autosave.java
// Written by Simcenter STAR-CCM+ 19.06.009
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;

public class autosave extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    AutoSave autoSave_0 = 
      simulation_0.getSimulationIterator().getAutoSave();

    autoSave_0.setMaxAutosavedFiles(2);

    AutoSaveFileSet autoSaveFileSet_0 = 
      ((AutoSaveFileSet) autoSave_0.getAutoSaveFileSetManager().getObject("Auto Save File Set 1"));

    autoSaveFileSet_0.setMaxAutosavedFiles(2);

    StarUpdate starUpdate_0 = 
      autoSaveFileSet_0.getStarUpdate();

    starUpdate_0.setEnabled(true);

    IterationUpdateFrequency iterationUpdateFrequency_0 = 
      starUpdate_0.getIterationUpdateFrequency();

    IntegerValue integerValue_0 = 
      iterationUpdateFrequency_0.getIterationFrequencyQuantity();

    integerValue_0.getQuantity().setValue(10000.0);
  }
}
