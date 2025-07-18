// Simcenter STAR-CCM+ macro: rem.java
// Written by Simcenter STAR-CCM+ 18.06.006
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.flow.*;

public class rem extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Units units_0 = 
      simulation_0.getUnitsManager().getPreferredUnits(Dimensions.Builder().length(2).build());

    Units units_1 = 
      simulation_0.getUnitsManager().getPreferredUnits(Dimensions.Builder().length(3).build());

    Units units_2 = 
      simulation_0.getUnitsManager().hasPreferredUnits(new IntVector(new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    MeshManager meshManager_0 = 
      simulation_0.getMeshManager();

    CourantNumberFunction courantNumberFunction_0 = 
      ((CourantNumberFunction) simulation_0.getFieldFunctionManager().getFunction("CourantNumber"));

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Air");

    Region region_1 = 
      simulation_0.getRegionManager().getRegion("MRF-FL");

    Region region_2 = 
      simulation_0.getRegionManager().getRegion("MRF-FR");

    Region region_3 = 
      simulation_0.getRegionManager().getRegion("MRF-RL");

    Region region_4 = 
      simulation_0.getRegionManager().getRegion("MRF-RR");

    meshManager_0.removeInvalidCells(courantNumberFunction_0, new NeoObjectVector(new Object[] {region_0, region_1, region_2, region_3, region_4}), NeoProperty.fromString("{\'minimumContiguousFaceArea\': 0.0, \'minimumCellVolumeEnabled\': false, \'minimumVolumeChangeEnabled\': false, \'functionOperator\': 1, \'minimumContiguousFaceAreaEnabled\': false, \'minimumFaceValidityEnabled\': false, \'functionValue\': 50.0, \'functionEnabled\': true, \'function\': \'CourantNumber\', \'minimumVolumeChange\': 0.001, \'minimumCellVolume\': 0.0, \'minimumCellQualityEnabled\': false, \'minimumCellQuality\': 1.0E-8, \'minimumDiscontiguousCells\': 1, \'minimumDiscontiguousCellsEnabled\': false, \'minimumFaceValidity\': 0.91}"));
  }
}
