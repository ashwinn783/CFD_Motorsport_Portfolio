// Simcenter STAR-CCM+ macro: wally.java
// Written by Simcenter STAR-CCM+ 18.06.006
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;

public class wally extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    simulation_0.getSceneManager().createScalarScene("Scalar Scene", "Outline", "Scalar", null);

    Scene scene_6 = 
      simulation_0.getSceneManager().getScene("Scalar Scene 1");

    scene_6.initializeAndWait();

    ScalarDisplayer scalarDisplayer_0 = 
      ((ScalarDisplayer) scene_6.getDisplayerManager().getObject("Scalar 1"));

    Legend legend_0 = 
      scalarDisplayer_0.getLegend();

    PredefinedLookupTable predefinedLookupTable_0 = 
      ((PredefinedLookupTable) simulation_0.get(LookupTableManager.class).getObject("blue-yellow-red"));

    legend_0.setLookupTable(predefinedLookupTable_0);

    SceneUpdate sceneUpdate_0 = 
      scene_6.getSceneUpdate();

    HardcopyProperties hardcopyProperties_0 = 
      sceneUpdate_0.getHardcopyProperties();

    hardcopyProperties_0.setCurrentResolutionWidth(993);

    hardcopyProperties_0.setCurrentResolutionHeight(466);

    scene_6.resetCamera();

    PartDisplayer partDisplayer_0 = 
      ((PartDisplayer) scene_6.getDisplayerManager().getObject("Outline 1"));

    scene_6.getDisplayerManager().removeObjects(partDisplayer_0);

    scalarDisplayer_0.getInputParts().setQuery(null);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Air");

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("Frontwing");

    Boundary boundary_1 = 
      region_0.getBoundaryManager().getBoundary("mono");

    Boundary boundary_2 = 
      region_0.getBoundaryManager().getBoundary("Rearwing");

    Boundary boundary_3 = 
      region_0.getBoundaryManager().getBoundary("Remaining");

    Boundary boundary_4 = 
      region_0.getBoundaryManager().getBoundary("Undertray");

    Boundary boundary_5 = 
      region_0.getBoundaryManager().getBoundary("wheel-fl");

    Boundary boundary_6 = 
      region_0.getBoundaryManager().getBoundary("wheel-fr");

    Boundary boundary_7 = 
      region_0.getBoundaryManager().getBoundary("wheel-rl");

    Boundary boundary_8 = 
      region_0.getBoundaryManager().getBoundary("wheel-rr");

    Region region_1 = 
      simulation_0.getRegionManager().getRegion("MRF-FL");

    Boundary boundary_9 = 
      region_1.getBoundaryManager().getBoundary("Default");

    Boundary boundary_10 = 
      region_1.getBoundaryManager().getBoundary("wheelhub");

    Region region_2 = 
      simulation_0.getRegionManager().getRegion("MRF-FR");

    Boundary boundary_11 = 
      region_2.getBoundaryManager().getBoundary("Default");

    Boundary boundary_12 = 
      region_2.getBoundaryManager().getBoundary("wheelhub");

    Region region_3 = 
      simulation_0.getRegionManager().getRegion("MRF-RL");

    Boundary boundary_13 = 
      region_3.getBoundaryManager().getBoundary("Default");

    Boundary boundary_14 = 
      region_3.getBoundaryManager().getBoundary("wheelhub");

    Region region_4 = 
      simulation_0.getRegionManager().getRegion("MRF-RR");

    Boundary boundary_15 = 
      region_4.getBoundaryManager().getBoundary("Default");

    Boundary boundary_16 = 
      region_4.getBoundaryManager().getBoundary("wheelhub");

    scalarDisplayer_0.getInputParts().setObjects(boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, boundary_5, boundary_6, boundary_7, boundary_8, boundary_9, boundary_10, boundary_11, boundary_12, boundary_13, boundary_14, boundary_15, boundary_16);

    PrimitiveFieldFunction primitiveFieldFunction_0 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("WallYplus"));

    scalarDisplayer_0.getScalarDisplayQuantity().setFieldFunction(primitiveFieldFunction_0);

    scalarDisplayer_0.getScalarDisplayQuantity().setAutoRange(AutoRangeMode.NONE);

    Units units_0 = 
      ((Units) simulation_0.getUnitsManager().getObject(""));

    scalarDisplayer_0.getScalarDisplayQuantity().getMinimumValue().setValueAndUnits(1.0, units_0);

    scalarDisplayer_0.getScalarDisplayQuantity().getMaximumValue().setValueAndUnits(30.0, units_0);

    scene_6.export3DSceneFileAndWait(resolvePath("wally.sce"), "wally", "", false, SceneFileCompressionLevel.OFF);
  }
}
