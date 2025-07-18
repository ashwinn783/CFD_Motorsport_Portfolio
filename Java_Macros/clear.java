// Simcenter STAR-CCM+ macro: clear.java
// Written by Simcenter STAR-CCM+ 18.06.006
package macro;

import java.util.*;
import java.io.File;
import star.common.*;
import star.meshing.*;

public class clear extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    MeshPipelineController meshPipelineController_0 = 
      simulation_0.get(MeshPipelineController.class);

    meshPipelineController_0.clearGeneratedMeshes();

    Solution solution_0 = 
      simulation_0.getSolution();

    solution_0.clearSolution();

    String FileName = simulation_0.getPresentationName();
    simulation_0.saveState(resolvePath(FileName + ".sim"));
  }
}
