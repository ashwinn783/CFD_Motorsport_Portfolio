// Simcenter STAR-CCM+ macro: les_post.java
// Written by Simcenter STAR-CCM+ 19.06.009
package macro;

import java.util.*;

import javax.swing.plaf.synth.Region;

import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.meshing.*;

public class les_post extends StarMacro {

  public void execute() {
    //execute0();
    //l1();
    probe();
    p1();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("x=-500");

    SceneUpdate sceneUpdate_0 = 
      scene_0.getSceneUpdate();

    sceneUpdate_0.setSaveAnimation(true);

    scene_0.setExportWidth(1048);

    scene_0.setExportResolution(ExportResolution.FULL_HD);

    sceneUpdate_0.getUpdateModeOption().setSelected(StarUpdateModeOption.Type.DELTATIME);

    DeltaTimeUpdateFrequency deltaTimeUpdateFrequency_0 = 
      sceneUpdate_0.getDeltaTimeUpdateFrequency();

    Units units_0 = 
      ((Units) simulation_0.getUnitsManager().getObject("s"));

    deltaTimeUpdateFrequency_0.setDeltaTime("0.05", units_0);

    Scene scene_1 = 
      simulation_0.getSceneManager().getScene("x=1350");

    scene_1.setExportResolution(ExportResolution.FULL_HD);

    SceneUpdate sceneUpdate_1 = 
      scene_1.getSceneUpdate();

    sceneUpdate_1.setSaveAnimation(true);

    sceneUpdate_1.getUpdateModeOption().setSelected(StarUpdateModeOption.Type.DELTATIME);

    DeltaTimeUpdateFrequency deltaTimeUpdateFrequency_1 = 
      sceneUpdate_1.getDeltaTimeUpdateFrequency();

    deltaTimeUpdateFrequency_1.setDeltaTime("0.05", units_0);

    Scene scene_2 = 
      simulation_0.getSceneManager().getScene("y=0");

    scene_2.setExportResolution(ExportResolution.FULL_HD);

    SceneUpdate sceneUpdate_2 = 
      scene_2.getSceneUpdate();

    sceneUpdate_2.getUpdateModeOption().setSelected(StarUpdateModeOption.Type.DELTATIME);

    sceneUpdate_2.setSaveAnimation(true);

    DeltaTimeUpdateFrequency deltaTimeUpdateFrequency_2 = 
      sceneUpdate_2.getDeltaTimeUpdateFrequency();

    deltaTimeUpdateFrequency_2.setDeltaTime("0.05", units_0);

    Scene scene_3 = 
      simulation_0.getSceneManager().getScene("y=600");

    scene_3.setExportResolution(ExportResolution.FULL_HD);

    SceneUpdate sceneUpdate_3 = 
      scene_3.getSceneUpdate();

    sceneUpdate_3.getUpdateModeOption().setSelected(StarUpdateModeOption.Type.DELTATIME);

    sceneUpdate_3.setSaveAnimation(true);

    DeltaTimeUpdateFrequency deltaTimeUpdateFrequency_3 = 
      sceneUpdate_3.getDeltaTimeUpdateFrequency();

    deltaTimeUpdateFrequency_3.setDeltaTime("0.05", units_0);

    Scene scene_4 = 
      simulation_0.getSceneManager().getScene("z=0");

    scene_4.setExportResolution(ExportResolution.FOUR_K);

    SceneUpdate sceneUpdate_4 = 
      scene_4.getSceneUpdate();

    sceneUpdate_4.getUpdateModeOption().setSelected(StarUpdateModeOption.Type.DELTATIME);

    sceneUpdate_4.setSaveAnimation(true);

    DeltaTimeUpdateFrequency deltaTimeUpdateFrequency_4 = 
      sceneUpdate_4.getDeltaTimeUpdateFrequency();

    deltaTimeUpdateFrequency_4.setDeltaTime("0.05", units_0);

    Scene scene_5 = 
      simulation_0.getSceneManager().getScene("z=200");

    scene_5.setExportResolution(ExportResolution.FOUR_K);

    scene_5.setExportResolution(ExportResolution.FULL_HD);

    SceneUpdate sceneUpdate_5 = 
      scene_5.getSceneUpdate();

    sceneUpdate_5.getUpdateModeOption().setSelected(StarUpdateModeOption.Type.DELTATIME);

    sceneUpdate_5.setSaveAnimation(true);

    DeltaTimeUpdateFrequency deltaTimeUpdateFrequency_5 = 
      sceneUpdate_5.getDeltaTimeUpdateFrequency();

    deltaTimeUpdateFrequency_5.setDeltaTime("0.05", units_0);

    Scene scene_6 = 
      simulation_0.getSceneManager().getScene("y=0 copy copy");

    scene_6.setExportResolution(ExportResolution.FULL_HD);

    SceneUpdate sceneUpdate_6 = 
      scene_6.getSceneUpdate();

    sceneUpdate_6.getUpdateModeOption().setSelected(StarUpdateModeOption.Type.DELTATIME);

    sceneUpdate_6.setSaveAnimation(true);

    DeltaTimeUpdateFrequency deltaTimeUpdateFrequency_6 = 
      sceneUpdate_6.getDeltaTimeUpdateFrequency();

    deltaTimeUpdateFrequency_6.setDeltaTime("0.05", units_0);

    Scene scene_7 = 
      simulation_0.getSceneManager().getScene("y=600 copy copy");

    scene_7.setExportResolution(ExportResolution.FULL_HD);

    SceneUpdate sceneUpdate_7 = 
      scene_7.getSceneUpdate();

    sceneUpdate_7.getUpdateModeOption().setSelected(StarUpdateModeOption.Type.DELTATIME);

    sceneUpdate_7.setSaveAnimation(true);

    DeltaTimeUpdateFrequency deltaTimeUpdateFrequency_7 = 
      sceneUpdate_7.getDeltaTimeUpdateFrequency();

    deltaTimeUpdateFrequency_7.setDeltaTime("0.05", units_0);

    Scene scene_8 = 
      simulation_0.getSceneManager().getScene("z=200 copy copy");

    scene_8.setExportResolution(ExportResolution.FULL_HD);

    SceneUpdate sceneUpdate_8 = 
      scene_8.getSceneUpdate();

    sceneUpdate_8.getUpdateModeOption().setSelected(StarUpdateModeOption.Type.DELTATIME);

    sceneUpdate_8.setSaveAnimation(true);

    DeltaTimeUpdateFrequency deltaTimeUpdateFrequency_8 = 
      sceneUpdate_8.getDeltaTimeUpdateFrequency();

    deltaTimeUpdateFrequency_8.setDeltaTime("0.05", units_0);

    Scene scene_9 = 
      simulation_0.getSceneManager().getScene("x=-500 copy");

    scene_9.setExportResolution(ExportResolution.FULL_HD);

    SceneUpdate sceneUpdate_9 = 
      scene_9.getSceneUpdate();

    sceneUpdate_9.getUpdateModeOption().setSelected(StarUpdateModeOption.Type.DELTATIME);

    sceneUpdate_9.setSaveAnimation(true);

    DeltaTimeUpdateFrequency deltaTimeUpdateFrequency_9 = 
      sceneUpdate_9.getDeltaTimeUpdateFrequency();

    deltaTimeUpdateFrequency_9.setDeltaTime("0.05", units_0);

    Scene scene_10 = 
      simulation_0.getSceneManager().getScene("x=1350 copy");

    scene_10.setExportResolution(ExportResolution.FULL_HD);

    SceneUpdate sceneUpdate_10 = 
      scene_10.getSceneUpdate();

    sceneUpdate_10.getUpdateModeOption().setSelected(StarUpdateModeOption.Type.DELTATIME);

    sceneUpdate_10.setSaveAnimation(true);

    DeltaTimeUpdateFrequency deltaTimeUpdateFrequency_10 = 
      sceneUpdate_10.getDeltaTimeUpdateFrequency();

    deltaTimeUpdateFrequency_10.setDeltaTime("0.05", units_0);

    Scene scene_11 = 
      simulation_0.getSceneManager().getScene("y=0 copy");

    scene_11.setExportResolution(ExportResolution.FULL_HD);

    SceneUpdate sceneUpdate_11 = 
      scene_11.getSceneUpdate();

    sceneUpdate_11.setSaveAnimation(true);

    sceneUpdate_11.getUpdateModeOption().setSelected(StarUpdateModeOption.Type.DELTATIME);

    DeltaTimeUpdateFrequency deltaTimeUpdateFrequency_11 = 
      sceneUpdate_11.getDeltaTimeUpdateFrequency();

    deltaTimeUpdateFrequency_11.setDeltaTime("0.05", units_0);

    Scene scene_12 = 
      simulation_0.getSceneManager().getScene("y=600 copy");

    scene_12.setExportResolution(ExportResolution.FULL_HD);

    SceneUpdate sceneUpdate_12 = 
      scene_12.getSceneUpdate();

    sceneUpdate_12.getUpdateModeOption().setSelected(StarUpdateModeOption.Type.DELTATIME);

    sceneUpdate_12.setSaveAnimation(true);

    DeltaTimeUpdateFrequency deltaTimeUpdateFrequency_12 = 
      sceneUpdate_12.getDeltaTimeUpdateFrequency();

    deltaTimeUpdateFrequency_12.setDeltaTime("0.05", units_0);

    Scene scene_13 = 
      simulation_0.getSceneManager().getScene("z=200 copy");

    scene_13.setExportResolution(ExportResolution.FULL_HD);

    SceneUpdate sceneUpdate_13 = 
      scene_13.getSceneUpdate();

    sceneUpdate_13.getUpdateModeOption().setSelected(StarUpdateModeOption.Type.DELTATIME);

    sceneUpdate_13.setSaveAnimation(true);

    DeltaTimeUpdateFrequency deltaTimeUpdateFrequency_13 = 
      sceneUpdate_13.getDeltaTimeUpdateFrequency();

    deltaTimeUpdateFrequency_13.setDeltaTime("0.05", units_0);

    Scene scene_14 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 1");

    AdvancedRenderingProperties advancedRenderingProperties_0 = 
      scene_14.getAdvancedRenderingProperties();

    advancedRenderingProperties_0.setTargetQuality(0.1);

    SceneUpdate sceneUpdate_14 = 
      scene_14.getSceneUpdate();

    sceneUpdate_14.getUpdateModeOption().setSelected(StarUpdateModeOption.Type.DELTATIME);

    sceneUpdate_14.setSaveAnimation(true);

    DeltaTimeUpdateFrequency deltaTimeUpdateFrequency_14 = 
      sceneUpdate_14.getDeltaTimeUpdateFrequency();

    deltaTimeUpdateFrequency_14.setDeltaTime("0.05", units_0);

    MonitorPlot monitorPlot_0 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("CFL"));

    PlotUpdate plotUpdate_0 = 
      monitorPlot_0.getPlotUpdate();

    plotUpdate_0.setSaveAnimation(true);

    MonitorPlot monitorPlot_1 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Coefficients"));

    PlotUpdate plotUpdate_1 = 
      monitorPlot_1.getPlotUpdate();

    plotUpdate_1.setSaveAnimation(true);

    MonitorPlot monitorPlot_2 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Forces"));

    PlotUpdate plotUpdate_2 = 
      monitorPlot_2.getPlotUpdate();

    plotUpdate_2.setSaveAnimation(true);

    MonitorPlot monitorPlot_3 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Moments"));

    PlotUpdate plotUpdate_3 = 
      monitorPlot_3.getPlotUpdate();

    plotUpdate_3.setSaveAnimation(true);

    ResidualPlot residualPlot_0 = 
      ((ResidualPlot) simulation_0.getPlotManager().getPlot("Residuals"));

    PlotUpdate plotUpdate_4 = 
      residualPlot_0.getPlotUpdate();

    plotUpdate_4.setSaveAnimation(true);

    XyzInternalTable xyzInternalTable_0 = 
      simulation_0.getTableManager().create("star.common.XyzInternalTable");

    xyzInternalTable_0.setPresentationName("x planes");

    PrimitiveFieldFunction primitiveFieldFunction_0 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Velocity"));

    VectorComponentFieldFunction vectorComponentFieldFunction_0 = 
      ((VectorComponentFieldFunction) primitiveFieldFunction_0.getComponentFunction(0));

    VectorComponentFieldFunction vectorComponentFieldFunction_1 = 
      ((VectorComponentFieldFunction) primitiveFieldFunction_0.getComponentFunction(1));

    VectorComponentFieldFunction vectorComponentFieldFunction_2 = 
      ((VectorComponentFieldFunction) primitiveFieldFunction_0.getComponentFunction(2));

    xyzInternalTable_0.setFieldFunctions(new ArrayList<>(Arrays.<FieldFunction>asList(vectorComponentFieldFunction_0, vectorComponentFieldFunction_1, vectorComponentFieldFunction_2)));

    MonitorPlot monitorPlot_4 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("x-planes vel"));

    PlotUpdate plotUpdate_5 = 
      monitorPlot_4.getPlotUpdate();

    plotUpdate_5.setSaveAnimation(true);

    MonitorPlot monitorPlot_5 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("y-planes vel"));

    PlotUpdate plotUpdate_6 = 
      monitorPlot_5.getPlotUpdate();

    plotUpdate_6.setSaveAnimation(true);

    MonitorPlot monitorPlot_6 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("z-planes vel"));

    PlotUpdate plotUpdate_7 = 
      monitorPlot_6.getPlotUpdate();

    plotUpdate_7.setSaveAnimation(true);

    simulation_0.deleteObjects(new ArrayList<>(Arrays.<ClientServerObject>asList(xyzInternalTable_0)));

    XyzInternalTable xyzInternalTable_1 = 
      simulation_0.getTableManager().create("star.common.XyzInternalTable");

    xyzInternalTable_1.setPresentationName("Free-probes");

    xyzInternalTable_1.setFieldFunctions(new ArrayList<>(Arrays.<FieldFunction>asList(vectorComponentFieldFunction_0, vectorComponentFieldFunction_1, vectorComponentFieldFunction_2)));

    xyzInternalTable_1.getParts().setQuery(null);

    LinePart linePart_0 = 
      ((LinePart) simulation_0.getPartManager().getObject("Free_probe"));

    xyzInternalTable_1.getParts().setObjects(linePart_0);

    xyzInternalTable_1.setPresentationName("Probes");

    xyzInternalTable_1.getParts().setQuery(null);

    LinePart linePart_1 = 
      ((LinePart) simulation_0.getPartManager().getObject("Wake_probe"));

    xyzInternalTable_1.getParts().setObjects(linePart_0, linePart_1);

    LatestMeshProxyRepresentation latestMeshProxyRepresentation_0 = 
      ((LatestMeshProxyRepresentation) simulation_0.getRepresentationManager().getObject("Latest Surface/Volume"));

    xyzInternalTable_1.setRepresentation(latestMeshProxyRepresentation_0);

    TableUpdate tableUpdate_0 = 
      xyzInternalTable_1.getTableUpdate();

    tableUpdate_0.setSaveToFile(true);

    tableUpdate_0.getUpdateModeOption().setSelected(StarUpdateModeOption.Type.DELTATIME);

    DeltaTimeUpdateFrequency deltaTimeUpdateFrequency_15 = 
      tableUpdate_0.getDeltaTimeUpdateFrequency();

    deltaTimeUpdateFrequency_15.setDeltaTime("0.05", units_0);

  }

    private void l1() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("x=-500");

    SceneUpdate sceneUpdate_0 = 
      scene_0.getSceneUpdate();

    sceneUpdate_0.setAnimationFilePath("p1");

    Scene scene_1 = 
      simulation_0.getSceneManager().getScene("x=1350");

    SceneUpdate sceneUpdate_1 = 
      scene_1.getSceneUpdate();

    sceneUpdate_1.setAnimationFilePath("p2");

    Scene scene_2 = 
      simulation_0.getSceneManager().getScene("y=0");

    SceneUpdate sceneUpdate_2 = 
      scene_2.getSceneUpdate();

    sceneUpdate_2.setAnimationFilePath("p3");

    Scene scene_3 = 
      simulation_0.getSceneManager().getScene("y=600");

    SceneUpdate sceneUpdate_3 = 
      scene_3.getSceneUpdate();

    sceneUpdate_3.setAnimationFilePath("p4");

    Scene scene_4 = 
      simulation_0.getSceneManager().getScene("z=0");

    SceneUpdate sceneUpdate_4 = 
      scene_4.getSceneUpdate();

    sceneUpdate_4.setAnimationFilePath("p5");

    Scene scene_5 = 
      simulation_0.getSceneManager().getScene("z=200");

    SceneUpdate sceneUpdate_5 = 
      scene_5.getSceneUpdate();

    sceneUpdate_5.setAnimationFilePath("p6");

    Scene scene_6 = 
      simulation_0.getSceneManager().getScene("y=0 copy copy");

    SceneUpdate sceneUpdate_6 = 
      scene_6.getSceneUpdate();

    sceneUpdate_6.setAnimationFilePath("vel1");

    Scene scene_7 = 
      simulation_0.getSceneManager().getScene("y=600 copy copy");

    SceneUpdate sceneUpdate_7 = 
      scene_7.getSceneUpdate();

    sceneUpdate_7.setAnimationFilePath("vel2");

    Scene scene_8 = 
      simulation_0.getSceneManager().getScene("z=200 copy copy");

    SceneUpdate sceneUpdate_8 = 
      scene_8.getSceneUpdate();

    sceneUpdate_8.setAnimationFilePath("vel3");

    Scene scene_9 = 
      simulation_0.getSceneManager().getScene("x=-500 copy");

    SceneUpdate sceneUpdate_9 = 
      scene_9.getSceneUpdate();

    sceneUpdate_9.setAnimationFilePath("vor1");

    Scene scene_10 = 
      simulation_0.getSceneManager().getScene("x=1350 copy");

    SceneUpdate sceneUpdate_10 = 
      scene_10.getSceneUpdate();

    sceneUpdate_10.setAnimationFilePath("vor2");

    Scene scene_11 = 
      simulation_0.getSceneManager().getScene("y=0 copy");

    SceneUpdate sceneUpdate_11 = 
      scene_11.getSceneUpdate();

    sceneUpdate_11.setAnimationFilePath("vor3");

    Scene scene_12 = 
      simulation_0.getSceneManager().getScene("y=600 copy");

    SceneUpdate sceneUpdate_12 = 
      scene_12.getSceneUpdate();

    sceneUpdate_12.setAnimationFilePath("vor4");

    Scene scene_13 = 
      simulation_0.getSceneManager().getScene("z=200 copy");

    SceneUpdate sceneUpdate_13 = 
      scene_13.getSceneUpdate();

    sceneUpdate_13.setAnimationFilePath("vor5");

        simulation_0.saveState("LES_80mill_1e-4_suhartotransfer@240000.sim");

    simulation_0.getSimulationIterator().run();
  }
  private void probe() {

    Simulation simulation_0 = getActiveSimulation();

    // Define probe coordinates
    double[][] coordinates = {
      {250, -400, 885}, {250, -350, 885}, {250, -300, 885}, {250, -250, 885}, {250, -200, 885},
      {250, -150, 885}, {250, -100, 885}, {250, -50, 885}, {250, 0, 885}, {250, 50, 885},
      {250, 100, 885}, {250, 150, 885}, {250, 200, 885}, {250, 250, 885}, {250, 300, 885},
      {250, 350, 885}, {250, 400, 885}, {250, -325, 810}, {250, -275, 810}, {250, -225, 810},
      {250, -175, 810}, {250, -125, 810}, {250, -75, 810}, {250, -25, 810}, {250, 25, 810},
      {250, 75, 810}, {250, 125, 810}, {250, 175, 810}, {250, 225, 810}, {250, 275, 810},
      {250, 325, 810}, {250, -400, 735}, {250, -350, 735}, {250, -300, 735}, {250, -250, 735},
      {250, -200, 735}, {250, -150, 735}, {250, -100, 735}, {250, -50, 735}, {250, 0, 735},
      {250, 50, 735}, {250, 100, 735}, {250, 150, 735}, {250, 200, 735}, {250, 250, 735},
      {250, 300, 735}, {250, 350, 735}, {250, 400, 735}, {1225, 680, 310}, {1225, 680, 160},
      {1225, 605, 235}, {1225, 530, 310}, {1225, 530, 160}, {1225, 455, 235}, {1225, 380, 310},
      {1225, 380, 160}, {2167.85, 150, 690.15}, {2119.05, 150, 548.33}, {2143.47, 75, 619.25},
      {2167.85, 0, 690.15}, {2119.05, 0, 548.33}, {2143.47, -75, 619.25}, {2167.85, -150, 690.15},
      {2119.05, -150, 548.33}
    };

    // Load specific regions and boundaries
    Region region_0 = simulation_0.getRegionManager().getRegion("Air");
    Boundary boundary_0 = region_0.getBoundaryManager().getBoundary("floor");
    Boundary boundary_1 = region_0.getBoundaryManager().getBoundary("Frontwing");
    Boundary boundary_2 = region_0.getBoundaryManager().getBoundary("inlet");
    Boundary boundary_3 = region_0.getBoundaryManager().getBoundary("mono");
    Boundary boundary_4 = region_0.getBoundaryManager().getBoundary("outlet");
    Boundary boundary_5 = region_0.getBoundaryManager().getBoundary("Rearwing");
    Boundary boundary_6 = region_0.getBoundaryManager().getBoundary("Remaining");
    Boundary boundary_7 = region_0.getBoundaryManager().getBoundary("Undertray");
    Boundary boundary_8 = region_0.getBoundaryManager().getBoundary("Walls");
    Boundary boundary_9 = region_0.getBoundaryManager().getBoundary("wheel-fl");
    Boundary boundary_10 = region_0.getBoundaryManager().getBoundary("wheel-fr");
    Boundary boundary_11 = region_0.getBoundaryManager().getBoundary("wheel-rl");
    Boundary boundary_12 = region_0.getBoundaryManager().getBoundary("wheel-rr");

    Region region_1 = simulation_0.getRegionManager().getRegion("MRF-FL");
    Boundary boundary_13 = region_1.getBoundaryManager().getBoundary("Default");
    Boundary boundary_14 = region_1.getBoundaryManager().getBoundary("wheelhub");

    Region region_2 = simulation_0.getRegionManager().getRegion("MRF-FR");
    Boundary boundary_15 = region_2.getBoundaryManager().getBoundary("Default");
    Boundary boundary_16 = region_2.getBoundaryManager().getBoundary("wheelhub");

    Region region_3 = simulation_0.getRegionManager().getRegion("MRF-RL");
    Boundary boundary_17 = region_3.getBoundaryManager().getBoundary("Default");
    Boundary boundary_18 = region_3.getBoundaryManager().getBoundary("wheelhub");

    Region region_4 = simulation_0.getRegionManager().getRegion("MRF-RR");
    Boundary boundary_19 = region_4.getBoundaryManager().getBoundary("Default");
    Boundary boundary_20 = region_4.getBoundaryManager().getBoundary("wheelhub");

    List<NamedObject> inputParts = Arrays.asList(
      region_0, boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, boundary_5, boundary_6,
      boundary_7, boundary_8, boundary_9, boundary_10, boundary_11, boundary_12,
      region_1, boundary_13, boundary_14,
      region_2, boundary_15, boundary_16,
      region_3, boundary_17, boundary_18,
      region_4, boundary_19, boundary_20
    );

    Units units_0 = ((Units) simulation_0.getUnitsManager().getObject("mm"));

    // Create one probe per coordinate
    for (int i = 0; i < coordinates.length; i++) {
      double[] coord = coordinates[i];
      PointPart point = simulation_0.getPartManager().createPointPart(
        new ArrayList<>(inputParts),
        new DoubleVector(coord),
        null
      );
      point.setPresentationName("Probe_" + i);
      point.getInputParts().setQuery(null);
      point.getInputParts().setObjects(inputParts);
      point.getPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(coord));
    }
  }

    private void p1() {

    Simulation simulation_0 = 
      getActiveSimulation();

    simulation_0.getPartManager().getGroupsManager().createGroup("New Group");

    PointPart pointPart_1 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_47"));

    PointPart pointPart_2 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_14"));

    PointPart pointPart_3 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_26"));

    PointPart pointPart_4 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_21"));

    PointPart pointPart_5 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_6"));

    PointPart pointPart_6 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_39"));

    PointPart pointPart_7 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_33"));

    PointPart pointPart_8 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_46"));

    PointPart pointPart_9 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_13"));

    PointPart pointPart_10 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_25"));

    PointPart pointPart_11 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_45"));

    PointPart pointPart_12 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_23"));

    PointPart pointPart_13 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_17"));

    PointPart pointPart_14 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_16"));

    PointPart pointPart_15 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_37"));

    PointPart pointPart_16 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_36"));

    PointPart pointPart_17 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_35"));

    PointPart pointPart_18 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_43"));

    PointPart pointPart_19 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_32"));

    PointPart pointPart_20 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_44"));

    PointPart pointPart_21 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_20"));

    PointPart pointPart_22 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_24"));

    PointPart pointPart_23 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_42"));

    PointPart pointPart_24 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_30"));

    PointPart pointPart_25 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_34"));

    PointPart pointPart_26 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_38"));

    PointPart pointPart_27 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_18"));

    PointPart pointPart_28 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_10"));

    PointPart pointPart_29 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_4"));

    PointPart pointPart_30 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_3"));

    PointPart pointPart_31 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_0"));

    PointPart pointPart_32 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_15"));

    PointPart pointPart_33 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_28"));

    PointPart pointPart_34 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_8"));

    PointPart pointPart_35 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_12"));

    PointPart pointPart_36 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_7"));

    PointPart pointPart_37 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_2"));

    PointPart pointPart_38 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_22"));

    PointPart pointPart_39 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_41"));

    PointPart pointPart_40 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_40"));

    PointPart pointPart_41 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_1"));

    PointPart pointPart_42 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_5"));

    PointPart pointPart_43 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_9"));

    PointPart pointPart_44 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_29"));

    PointPart pointPart_45 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_19"));

    PointPart pointPart_46 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_11"));

    PointPart pointPart_47 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_31"));

    PointPart pointPart_48 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_27"));

    ((ClientServerObjectGroup) simulation_0.getPartManager().getGroupsManager().getObject("New Group")).getGroupsManager().groupObjects("New Group", new ArrayList<>(Arrays.<ClientServerObject>asList(pointPart_1, pointPart_2, pointPart_3, pointPart_4, pointPart_5, pointPart_6, pointPart_7, pointPart_8, pointPart_9, pointPart_10, pointPart_11, pointPart_12, pointPart_13, pointPart_14, pointPart_15, pointPart_16, pointPart_17, pointPart_18, pointPart_19, pointPart_20, pointPart_21, pointPart_22, pointPart_23, pointPart_24, pointPart_25, pointPart_26, pointPart_27, pointPart_28, pointPart_29, pointPart_30, pointPart_31, pointPart_32, pointPart_33, pointPart_34, pointPart_35, pointPart_36, pointPart_37, pointPart_38, pointPart_39, pointPart_40, pointPart_41, pointPart_42, pointPart_43, pointPart_44, pointPart_45, pointPart_46, pointPart_47, pointPart_48)));

    ((ClientServerObjectGroup) simulation_0.getPartManager().getGroupsManager().getObject("New Group")).setPresentationName("Rear_wing");

    simulation_0.getPartManager().getGroupsManager().createGroup("New Group");

    simulation_0.getPartManager().getGroupsManager().createGroup("New Group");

    ((ClientServerObjectGroup) simulation_0.getPartManager().getGroupsManager().getObject("New Group")).setPresentationName("Left");

    ((ClientServerObjectGroup) simulation_0.getPartManager().getGroupsManager().getObject("New Group 2")).setPresentationName("Middle");

    PointPart pointPart_49 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_55"));

    PointPart pointPart_50 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_54"));

    PointPart pointPart_51 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_52"));

    PointPart pointPart_52 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_51"));

    PointPart pointPart_53 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_49"));

    PointPart pointPart_54 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_50"));

    PointPart pointPart_55 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_53"));

    PointPart pointPart_56 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_48"));

    ((ClientServerObjectGroup) simulation_0.getPartManager().getGroupsManager().getObject("Left")).getGroupsManager().groupObjects("Left", new ArrayList<>(Arrays.<ClientServerObject>asList(pointPart_49, pointPart_50, pointPart_51, pointPart_52, pointPart_53, pointPart_54, pointPart_55, pointPart_56)));

    PointPart pointPart_57 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_56"));

    PointPart pointPart_58 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_57"));

    PointPart pointPart_59 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_58"));

    PointPart pointPart_60 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_60"));

    PointPart pointPart_61 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_62"));

    PointPart pointPart_62 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_61"));

    PointPart pointPart_63 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_63"));

    PointPart pointPart_64 = 
      ((PointPart) simulation_0.getPartManager().getObject("Probe_59"));

    ((ClientServerObjectGroup) simulation_0.getPartManager().getGroupsManager().getObject("Middle")).getGroupsManager().groupObjects("Middle", new ArrayList<>(Arrays.<ClientServerObject>asList(pointPart_57, pointPart_58, pointPart_59, pointPart_60, pointPart_61, pointPart_62, pointPart_63, pointPart_64)));

    XyzInternalTable xyzInternalTable_0 = 
      simulation_0.getTableManager().create("star.common.XyzInternalTable");

    xyzInternalTable_0.setPresentationName("Validation");

    PrimitiveFieldFunction primitiveFieldFunction_0 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("TotalPressure"));

    PrimitiveFieldFunction primitiveFieldFunction_1 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Velocity"));

    VectorMagnitudeFieldFunction vectorMagnitudeFieldFunction_0 = 
      ((VectorMagnitudeFieldFunction) primitiveFieldFunction_1.getMagnitudeFunction());

    VectorComponentFieldFunction vectorComponentFieldFunction_0 = 
      ((VectorComponentFieldFunction) primitiveFieldFunction_1.getComponentFunction(0));

    VectorComponentFieldFunction vectorComponentFieldFunction_1 = 
      ((VectorComponentFieldFunction) primitiveFieldFunction_1.getComponentFunction(1));

    VectorComponentFieldFunction vectorComponentFieldFunction_2 = 
      ((VectorComponentFieldFunction) primitiveFieldFunction_1.getComponentFunction(2));

    xyzInternalTable_0.setFieldFunctions(new ArrayList<>(Arrays.<FieldFunction>asList(primitiveFieldFunction_0, vectorMagnitudeFieldFunction_0, vectorComponentFieldFunction_0, vectorComponentFieldFunction_1, vectorComponentFieldFunction_2)));

    xyzInternalTable_0.getParts().setQuery(null);

    xyzInternalTable_0.getParts().setObjects(pointPart_56, pointPart_53, pointPart_54, pointPart_52, pointPart_51, pointPart_55, pointPart_50, pointPart_49, pointPart_57, pointPart_58, pointPart_59, pointPart_64, pointPart_60, pointPart_62, pointPart_61, pointPart_63, pointPart_31, pointPart_41, pointPart_37, pointPart_30, pointPart_29, pointPart_42, pointPart_5, pointPart_36, pointPart_34, pointPart_43, pointPart_28, pointPart_46, pointPart_35, pointPart_9, pointPart_2, pointPart_32, pointPart_14, pointPart_13, pointPart_27, pointPart_45, pointPart_21, pointPart_4, pointPart_38, pointPart_12, pointPart_22, pointPart_10, pointPart_3, pointPart_48, pointPart_33, pointPart_44, pointPart_24, pointPart_47, pointPart_19, pointPart_7, pointPart_25, pointPart_17, pointPart_16, pointPart_15, pointPart_26, pointPart_6, pointPart_40, pointPart_39, pointPart_23, pointPart_18, pointPart_20, pointPart_11, pointPart_8, pointPart_1);

    LatestMeshProxyRepresentation latestMeshProxyRepresentation_0 = 
      ((LatestMeshProxyRepresentation) simulation_0.getRepresentationManager().getObject("Latest Surface/Volume"));

    xyzInternalTable_0.setRepresentation(latestMeshProxyRepresentation_0);

    TableUpdate tableUpdate_0 = 
      xyzInternalTable_0.getTableUpdate();

    tableUpdate_0.setSaveToFile(true);

    tableUpdate_0.getUpdateModeOption().setSelected(StarUpdateModeOption.Type.DELTATIME);

    FilePathProperty filePathProperty_0 = 
      tableUpdate_0.getFilePathCso();

    filePathProperty_0.setFilePath(".");

    filePathProperty_0.setFilePath("Validation");

    DeltaTimeUpdateFrequency deltaTimeUpdateFrequency_0 = 
      tableUpdate_0.getDeltaTimeUpdateFrequency();

    Units units_1 = 
      ((Units) simulation_0.getUnitsManager().getObject("s"));

    deltaTimeUpdateFrequency_0.setDeltaTime("0.05", units_1);

    simulation_0.saveState("LES_80mill_1e-4_suhartotransfer@240000.sim");

    simulation_0.getSimulationIterator().run();
  }

}
