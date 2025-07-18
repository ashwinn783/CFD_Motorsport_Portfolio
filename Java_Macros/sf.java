// Simcenter STAR-CCM+ macro: sf.java
// Written by Simcenter STAR-CCM+ 18.06.006
package macro;

import java.util.*;

import star.base.neo.*;
import star.common.*;
import star.vis.*;

public class sf extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    simulation_0.get(LookupTableManager.class).importLookupTables(resolvePath("byuignite_inferno_starccm.colormap"));

    simulation_0.get(LookupTableManager.class).importLookupTables(resolvePath("byuignite_jet_starccm.colormap"));

    simulation_0.get(LookupTableManager.class).importLookupTables(resolvePath("byuignite_viridis_starccm.colormap"));

    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("Continuity-Residual");

    scene_0.initializeAndWait();

    Scene scene_1 = 
      simulation_0.getSceneManager().getScene("Dissipation-Residual");

    scene_1.initializeAndWait();

    Scene scene_2 = 
      simulation_0.getSceneManager().getScene("TKE-Residual");

    scene_2.initializeAndWait();

    Scene scene_3 = 
      simulation_0.getSceneManager().getScene("X-Momentum-Residual");

    scene_3.initializeAndWait();

    Scene scene_4 = 
      simulation_0.getSceneManager().getScene("Y-Momentum-Residual");

    scene_4.initializeAndWait();

    Scene scene_5 = 
      simulation_0.getSceneManager().getScene("Z-Momentum-Residual");

    scene_5.initializeAndWait();

    Scene scene_6 = 
      simulation_0.getSceneManager().getScene("Cp");

    scene_6.initializeAndWait();

    ScalarDisplayer scalarDisplayer_0 = 
      ((ScalarDisplayer) scene_6.getDisplayerManager().getObject("3D"));

    Legend legend_0 = 
      scalarDisplayer_0.getLegend();

    HighContrastLookupTable highContrastLookupTable_0 = 
      ((HighContrastLookupTable) simulation_0.get(LookupTableManager.class).getObject("high-contrast"));

    legend_0.setLookupTable(highContrastLookupTable_0);

    ScalarDisplayer scalarDisplayer_1 = 
      ((ScalarDisplayer) scene_6.getDisplayerManager().getObject("x-Section"));

    Legend legend_1 = 
      scalarDisplayer_1.getLegend();

    legend_1.setLookupTable(highContrastLookupTable_0);

    ScalarDisplayer scalarDisplayer_2 = 
      ((ScalarDisplayer) scene_6.getDisplayerManager().getObject("y-Section"));

    Legend legend_2 = 
      scalarDisplayer_2.getLegend();

    legend_2.setLookupTable(highContrastLookupTable_0);

    ScalarDisplayer scalarDisplayer_3 = 
      ((ScalarDisplayer) scene_6.getDisplayerManager().getObject("z-Section"));

    Legend legend_3 = 
      scalarDisplayer_3.getLegend();

    legend_3.setLookupTable(highContrastLookupTable_0);

    Scene scene_7 = 
      simulation_0.getSceneManager().getScene("Cp_Mean");

    scene_7.initializeAndWait();

    ScalarDisplayer scalarDisplayer_4 = 
      ((ScalarDisplayer) scene_7.getDisplayerManager().getObject("3D"));

    Legend legend_4 = 
      scalarDisplayer_4.getLegend();

    legend_4.setLookupTable(highContrastLookupTable_0);

    ScalarDisplayer scalarDisplayer_5 = 
      ((ScalarDisplayer) scene_7.getDisplayerManager().getObject("x-Section"));

    Legend legend_5 = 
      scalarDisplayer_5.getLegend();

    legend_5.setLookupTable(highContrastLookupTable_0);

    ScalarDisplayer scalarDisplayer_6 = 
      ((ScalarDisplayer) scene_7.getDisplayerManager().getObject("y-Section"));

    Legend legend_6 = 
      scalarDisplayer_6.getLegend();

    legend_6.setLookupTable(highContrastLookupTable_0);

    ScalarDisplayer scalarDisplayer_7 = 
      ((ScalarDisplayer) scene_7.getDisplayerManager().getObject("z-Section"));

    Legend legend_7 = 
      scalarDisplayer_7.getLegend();

    legend_7.setLookupTable(highContrastLookupTable_0);

    Scene scene_8 = 
      simulation_0.getSceneManager().getScene("CpT");

    scene_8.initializeAndWait();

    ScalarDisplayer scalarDisplayer_8 = 
      ((ScalarDisplayer) scene_8.getDisplayerManager().getObject("3D"));

    Legend legend_8 = 
      scalarDisplayer_8.getLegend();

    PredefinedLookupTable predefinedLookupTable_0 = 
      ((PredefinedLookupTable) simulation_0.get(LookupTableManager.class).getObject("turbo"));

    legend_8.setLookupTable(predefinedLookupTable_0);

    ScalarDisplayer scalarDisplayer_9 = 
      ((ScalarDisplayer) scene_8.getDisplayerManager().getObject("x-Section"));

    Legend legend_9 = 
      scalarDisplayer_9.getLegend();

    legend_9.setLookupTable(predefinedLookupTable_0);

    ScalarDisplayer scalarDisplayer_10 = 
      ((ScalarDisplayer) scene_8.getDisplayerManager().getObject("y-Section"));

    Legend legend_10 = 
      scalarDisplayer_10.getLegend();

    legend_10.setLookupTable(predefinedLookupTable_0);

    ScalarDisplayer scalarDisplayer_11 = 
      ((ScalarDisplayer) scene_8.getDisplayerManager().getObject("z-Section"));

    Legend legend_11 = 
      scalarDisplayer_11.getLegend();

    legend_11.setLookupTable(predefinedLookupTable_0);

    Scene scene_9 = 
      simulation_0.getSceneManager().getScene("CpT_Mean");

    scene_9.initializeAndWait();

    ScalarDisplayer scalarDisplayer_12 = 
      ((ScalarDisplayer) scene_9.getDisplayerManager().getObject("3D"));

    Legend legend_12 = 
      scalarDisplayer_12.getLegend();

    legend_12.setLookupTable(predefinedLookupTable_0);

    ScalarDisplayer scalarDisplayer_13 = 
      ((ScalarDisplayer) scene_9.getDisplayerManager().getObject("x-Section"));

    Legend legend_13 = 
      scalarDisplayer_13.getLegend();

    legend_13.setLookupTable(predefinedLookupTable_0);

    ScalarDisplayer scalarDisplayer_14 = 
      ((ScalarDisplayer) scene_9.getDisplayerManager().getObject("y-Section"));

    Legend legend_14 = 
      scalarDisplayer_14.getLegend();

    legend_14.setLookupTable(predefinedLookupTable_0);

    ScalarDisplayer scalarDisplayer_15 = 
      ((ScalarDisplayer) scene_9.getDisplayerManager().getObject("z-Section"));

    Legend legend_15 = 
      scalarDisplayer_15.getLegend();

    legend_15.setLookupTable(predefinedLookupTable_0);

    Scene scene_10 = 
      simulation_0.getSceneManager().getScene("TKE");

    scene_10.initializeAndWait();

    ScalarDisplayer scalarDisplayer_16 = 
      ((ScalarDisplayer) scene_10.getDisplayerManager().getObject("x-Section"));

    Legend legend_16 = 
      scalarDisplayer_16.getLegend();

    UserLookupTable userLookupTable_1 = 
      ((UserLookupTable) simulation_0.get(LookupTableManager.class).getObject("byu_jet"));

    legend_16.setLookupTable(userLookupTable_1);

    ScalarDisplayer scalarDisplayer_17 = 
      ((ScalarDisplayer) scene_10.getDisplayerManager().getObject("y-Section"));

    Legend legend_17 = 
      scalarDisplayer_17.getLegend();

    legend_17.setLookupTable(userLookupTable_1);

    ScalarDisplayer scalarDisplayer_18 = 
      ((ScalarDisplayer) scene_10.getDisplayerManager().getObject("z-Section"));

    Legend legend_18 = 
      scalarDisplayer_18.getLegend();

    legend_18.setLookupTable(userLookupTable_1);

    Scene scene_11 = 
      simulation_0.getSceneManager().getScene("Total pressure");

    scene_11.initializeAndWait();

    ScalarDisplayer scalarDisplayer_19 = 
      ((ScalarDisplayer) scene_11.getDisplayerManager().getObject("3D"));

    Legend legend_19 = 
      scalarDisplayer_19.getLegend();

    UserLookupTable userLookupTable_2 = 
      ((UserLookupTable) simulation_0.get(LookupTableManager.class).getObject("byu_viridis"));

    legend_19.setLookupTable(userLookupTable_2);

    ScalarDisplayer scalarDisplayer_20 = 
      ((ScalarDisplayer) scene_11.getDisplayerManager().getObject("x-Section"));

    Legend legend_20 = 
      scalarDisplayer_20.getLegend();

    legend_20.setLookupTable(userLookupTable_2);

    ScalarDisplayer scalarDisplayer_21 = 
      ((ScalarDisplayer) scene_11.getDisplayerManager().getObject("y-Section"));

    Legend legend_21 = 
      scalarDisplayer_21.getLegend();

    legend_21.setLookupTable(userLookupTable_2);

    ScalarDisplayer scalarDisplayer_22 = 
      ((ScalarDisplayer) scene_11.getDisplayerManager().getObject("z-Section"));

    Legend legend_22 = 
      scalarDisplayer_22.getLegend();

    legend_22.setLookupTable(userLookupTable_2);

    Scene scene_12 = 
      simulation_0.getSceneManager().getScene("Total pressure_Mean");

    scene_12.initializeAndWait();

    ScalarDisplayer scalarDisplayer_23 = 
      ((ScalarDisplayer) scene_12.getDisplayerManager().getObject("3D"));

    Legend legend_23 = 
      scalarDisplayer_23.getLegend();

    legend_23.setLookupTable(userLookupTable_2);

    ScalarDisplayer scalarDisplayer_24 = 
      ((ScalarDisplayer) scene_12.getDisplayerManager().getObject("x-Section"));

    Legend legend_24 = 
      scalarDisplayer_24.getLegend();

    legend_24.setLookupTable(userLookupTable_2);

    ScalarDisplayer scalarDisplayer_25 = 
      ((ScalarDisplayer) scene_12.getDisplayerManager().getObject("y-Section"));

    Legend legend_25 = 
      scalarDisplayer_25.getLegend();

    legend_25.setLookupTable(userLookupTable_2);

    ScalarDisplayer scalarDisplayer_26 = 
      ((ScalarDisplayer) scene_12.getDisplayerManager().getObject("z-Section"));

    Legend legend_26 = 
      scalarDisplayer_26.getLegend();

    legend_26.setLookupTable(userLookupTable_2);

    Scene scene_13 = 
      simulation_0.getSceneManager().getScene("Velocity");

    scene_13.initializeAndWait();
  }
}
