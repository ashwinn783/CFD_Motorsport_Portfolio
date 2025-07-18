// Simcenter STAR-CCM+ macro: shed.java
// Written by Simcenter STAR-CCM+ 19.06.009
package macro;

import java.util.*;
import java.io.File;
import star.common.*;
import star.base.neo.*;
import star.vis.*;

public class shed extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    MonitorPlot monitorPlot_0 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("CFL"));

    PlotUpdate plotUpdate_0 = 
      monitorPlot_0.getPlotUpdate();

    plotUpdate_0.setSaveAnimation(false);

    MonitorPlot monitorPlot_1 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Coefficients"));

    PlotUpdate plotUpdate_1 = 
      monitorPlot_1.getPlotUpdate();

    plotUpdate_1.setSaveAnimation(false);

    MonitorPlot monitorPlot_2 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Forces"));

    PlotUpdate plotUpdate_2 = 
      monitorPlot_2.getPlotUpdate();

    plotUpdate_2.setSaveAnimation(false);

    MonitorPlot monitorPlot_3 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Moments"));

    PlotUpdate plotUpdate_3 = 
      monitorPlot_3.getPlotUpdate();

    plotUpdate_3.setSaveAnimation(false);

    ResidualPlot residualPlot_0 = 
      ((ResidualPlot) simulation_0.getPlotManager().getPlot("Residuals"));

    PlotUpdate plotUpdate_4 = 
      residualPlot_0.getPlotUpdate();

    plotUpdate_4.setSaveAnimation(false);

    MonitorPlot monitorPlot_4 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("x-planes vel"));

    PlotUpdate plotUpdate_5 = 
      monitorPlot_4.getPlotUpdate();

    plotUpdate_5.setSaveAnimation(false);

    MonitorPlot monitorPlot_5 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("y-planes vel"));

    PlotUpdate plotUpdate_6 = 
      monitorPlot_5.getPlotUpdate();

    plotUpdate_6.setSaveAnimation(false);

    MonitorPlot monitorPlot_6 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("z-planes vel"));

    PlotUpdate plotUpdate_7 = 
      monitorPlot_6.getPlotUpdate();

    plotUpdate_7.setSaveAnimation(false);

    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("x=-500");

    SceneUpdate sceneUpdate_0 = 
      scene_0.getSceneUpdate();

    sceneUpdate_0.setSaveAnimation(false);

    Scene scene_1 = 
      simulation_0.getSceneManager().getScene("x=1350");

    SceneUpdate sceneUpdate_1 = 
      scene_1.getSceneUpdate();

    sceneUpdate_1.setSaveAnimation(false);

    Scene scene_2 = 
      simulation_0.getSceneManager().getScene("y=0");

    SceneUpdate sceneUpdate_2 = 
      scene_2.getSceneUpdate();

    sceneUpdate_2.setSaveAnimation(false);

    Scene scene_3 = 
      simulation_0.getSceneManager().getScene("y=600");

    SceneUpdate sceneUpdate_3 = 
      scene_3.getSceneUpdate();

    sceneUpdate_3.setSaveAnimation(false);

    Scene scene_4 = 
      simulation_0.getSceneManager().getScene("z=0");

    SceneUpdate sceneUpdate_4 = 
      scene_4.getSceneUpdate();

    sceneUpdate_4.setSaveAnimation(false);

    Scene scene_5 = 
      simulation_0.getSceneManager().getScene("z=200");

    SceneUpdate sceneUpdate_5 = 
      scene_5.getSceneUpdate();

    sceneUpdate_5.setSaveAnimation(false);

    Scene scene_6 = 
      simulation_0.getSceneManager().getScene("y=0 copy copy");

    SceneUpdate sceneUpdate_6 = 
      scene_6.getSceneUpdate();

    sceneUpdate_6.setSaveAnimation(false);

    Scene scene_7 = 
      simulation_0.getSceneManager().getScene("y=600 copy copy");

    SceneUpdate sceneUpdate_7 = 
      scene_7.getSceneUpdate();

    sceneUpdate_7.setSaveAnimation(false);

    Scene scene_8 = 
      simulation_0.getSceneManager().getScene("z=200 copy copy");

    SceneUpdate sceneUpdate_8 = 
      scene_8.getSceneUpdate();

    sceneUpdate_8.setSaveAnimation(false);

    Scene scene_9 = 
      simulation_0.getSceneManager().getScene("x=-500 copy");

    SceneUpdate sceneUpdate_9 = 
      scene_9.getSceneUpdate();

    sceneUpdate_9.setSaveAnimation(false);

    Scene scene_10 = 
      simulation_0.getSceneManager().getScene("x=1350 copy");

    SceneUpdate sceneUpdate_10 = 
      scene_10.getSceneUpdate();

    sceneUpdate_10.setSaveAnimation(false);

    Scene scene_11 = 
      simulation_0.getSceneManager().getScene("y=0 copy");

    SceneUpdate sceneUpdate_11 = 
      scene_11.getSceneUpdate();

    sceneUpdate_11.setSaveAnimation(false);

    Scene scene_12 = 
      simulation_0.getSceneManager().getScene("y=600 copy");

    SceneUpdate sceneUpdate_12 = 
      scene_12.getSceneUpdate();

    sceneUpdate_12.setSaveAnimation(false);

    Scene scene_13 = 
      simulation_0.getSceneManager().getScene("z=200 copy");

    SceneUpdate sceneUpdate_13 = 
      scene_13.getSceneUpdate();

    sceneUpdate_13.setSaveAnimation(false);

    Scene scene_14 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 1");

    SceneUpdate sceneUpdate_14 = 
      scene_14.getSceneUpdate();

    sceneUpdate_14.setSaveAnimation(false);

    XyzInternalTable xyzInternalTable_0 = 
      ((XyzInternalTable) simulation_0.getTableManager().getTable("Validation"));

    TableUpdate tableUpdate_0 = 
      xyzInternalTable_0.getTableUpdate();

    tableUpdate_0.setSaveToFile(false);

    tableUpdate_0.setAutoExtract(false);

    tableUpdate_0.setEnabled(false);

    PointPart pointPart_0 = 
      simulation_0.getPartManager().createPointPart(new ArrayList<>(Collections.<NamedObject>emptyList()), new DoubleVector(new double[] {0.0, 0.0, 0.0}), null);

    pointPart_0.getInputParts().setQuery(null);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Air");

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("floor");

    Boundary boundary_1 = 
      region_0.getBoundaryManager().getBoundary("Frontwing");

    Boundary boundary_2 = 
      region_0.getBoundaryManager().getBoundary("inlet");

    Boundary boundary_3 = 
      region_0.getBoundaryManager().getBoundary("mono");

    Boundary boundary_4 = 
      region_0.getBoundaryManager().getBoundary("outlet");

    Boundary boundary_5 = 
      region_0.getBoundaryManager().getBoundary("Rearwing");

    Boundary boundary_6 = 
      region_0.getBoundaryManager().getBoundary("Remaining");

    Boundary boundary_7 = 
      region_0.getBoundaryManager().getBoundary("Undertray");

    Boundary boundary_8 = 
      region_0.getBoundaryManager().getBoundary("Walls");

    Boundary boundary_9 = 
      region_0.getBoundaryManager().getBoundary("wheel-fl");

    Boundary boundary_10 = 
      region_0.getBoundaryManager().getBoundary("wheel-fr");

    Boundary boundary_11 = 
      region_0.getBoundaryManager().getBoundary("wheel-rl");

    Boundary boundary_12 = 
      region_0.getBoundaryManager().getBoundary("wheel-rr");

    Region region_1 = 
      simulation_0.getRegionManager().getRegion("MRF-FL");

    Boundary boundary_13 = 
      region_1.getBoundaryManager().getBoundary("Default");

    Boundary boundary_14 = 
      region_1.getBoundaryManager().getBoundary("wheelhub");

    Region region_2 = 
      simulation_0.getRegionManager().getRegion("MRF-FR");

    Boundary boundary_15 = 
      region_2.getBoundaryManager().getBoundary("Default");

    Boundary boundary_16 = 
      region_2.getBoundaryManager().getBoundary("wheelhub");

    Region region_3 = 
      simulation_0.getRegionManager().getRegion("MRF-RL");

    Boundary boundary_17 = 
      region_3.getBoundaryManager().getBoundary("Default");

    Boundary boundary_18 = 
      region_3.getBoundaryManager().getBoundary("wheelhub");

    Region region_4 = 
      simulation_0.getRegionManager().getRegion("MRF-RR");

    Boundary boundary_19 = 
      region_4.getBoundaryManager().getBoundary("Default");

    Boundary boundary_20 = 
      region_4.getBoundaryManager().getBoundary("wheelhub");

    pointPart_0.getInputParts().setObjects(region_0, boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, boundary_5, boundary_6, boundary_7, boundary_8, boundary_9, boundary_10, boundary_11, boundary_12, region_1, boundary_13, boundary_14, region_2, boundary_15, boundary_16, region_3, boundary_17, boundary_18, region_4, boundary_19, boundary_20);

    Units units_0 = 
      ((Units) simulation_0.getUnitsManager().getObject("mm"));

    pointPart_0.getPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {250.0, -100.0, 735.0}));

    pointPart_0.setPresentationName("1");

    PointPart pointPart_1 = 
      simulation_0.getPartManager().createPointPart(new ArrayList<>(Collections.<NamedObject>emptyList()), new DoubleVector(new double[] {0.0, 0.0, 0.0}), null);

    pointPart_1.setPresentationName("1 copy");

    pointPart_1.copyProperties(pointPart_0);

    simulation_0.getPartManager().getGroupsManager().groupObjects("", new ArrayList<>(Arrays.<ClientServerObject>asList(pointPart_1)));

    pointPart_1.setPresentationName("2");

    pointPart_1.getPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {250.0, 175.0, 810.0}));

    PointPart pointPart_2 = 
      simulation_0.getPartManager().createPointPart(new ArrayList<>(Collections.<NamedObject>emptyList()), new DoubleVector(new double[] {0.0, 0.0, 0.0}), null);

    pointPart_2.setPresentationName("2 copy");

    pointPart_2.copyProperties(pointPart_1);

    simulation_0.getPartManager().getGroupsManager().groupObjects("", new ArrayList<>(Arrays.<ClientServerObject>asList(pointPart_2)));

    pointPart_2.setPresentationName("3");

    pointPart_2.getPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {250.0, 0.0, 735.0}));

    PointPart pointPart_3 = 
      simulation_0.getPartManager().createPointPart(new ArrayList<>(Collections.<NamedObject>emptyList()), new DoubleVector(new double[] {0.0, 0.0, 0.0}), null);

    pointPart_3.setPresentationName("3 copy");

    pointPart_3.copyProperties(pointPart_2);

    simulation_0.getPartManager().getGroupsManager().groupObjects("", new ArrayList<>(Arrays.<ClientServerObject>asList(pointPart_3)));

    pointPart_3.setPresentationName("4");

    pointPart_3.getPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {-500.0, 650.0, 800.0}));

    PointPart pointPart_4 = 
      simulation_0.getPartManager().createPointPart(new ArrayList<>(Collections.<NamedObject>emptyList()), new DoubleVector(new double[] {0.0, 0.0, 0.0}), null);

    pointPart_4.setPresentationName("4 copy");

    pointPart_4.copyProperties(pointPart_3);

    simulation_0.getPartManager().getGroupsManager().groupObjects("", new ArrayList<>(Arrays.<ClientServerObject>asList(pointPart_4)));

    pointPart_4.setPresentationName("5");

    pointPart_4.getPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1900.0, 0.0, 70.0}));

    PointPart pointPart_5 = 
      simulation_0.getPartManager().createPointPart(new ArrayList<>(Collections.<NamedObject>emptyList()), new DoubleVector(new double[] {0.0, 0.0, 0.0}), null);

    pointPart_5.setPresentationName("5 copy");

    pointPart_5.copyProperties(pointPart_4);

    simulation_0.getPartManager().getGroupsManager().groupObjects("", new ArrayList<>(Arrays.<ClientServerObject>asList(pointPart_5)));

    pointPart_5.setPresentationName("6");

    pointPart_5.getPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {400.0, 0.0, 1075.0}));

    PointPart pointPart_6 = 
      simulation_0.getPartManager().createPointPart(new ArrayList<>(Collections.<NamedObject>emptyList()), new DoubleVector(new double[] {0.0, 0.0, 0.0}), null);

    pointPart_6.setPresentationName("6 copy");

    pointPart_6.copyProperties(pointPart_5);

    simulation_0.getPartManager().getGroupsManager().groupObjects("", new ArrayList<>(Arrays.<ClientServerObject>asList(pointPart_6)));

    pointPart_6.setPresentationName("7");

    pointPart_6.getPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1400.0, 600.0, 650.0}));

    PointPart pointPart_7 = 
      simulation_0.getPartManager().createPointPart(new ArrayList<>(Collections.<NamedObject>emptyList()), new DoubleVector(new double[] {0.0, 0.0, 0.0}), null);

    pointPart_7.setPresentationName("7 copy");

    pointPart_7.copyProperties(pointPart_6);

    simulation_0.getPartManager().getGroupsManager().groupObjects("", new ArrayList<>(Arrays.<ClientServerObject>asList(pointPart_7)));

    pointPart_7.setPresentationName("8");

    pointPart_7.getPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {-400.0, 600.0, 200.0}));

    PointPart pointPart_8 = 
      simulation_0.getPartManager().createPointPart(new ArrayList<>(Collections.<NamedObject>emptyList()), new DoubleVector(new double[] {0.0, 0.0, 0.0}), null);

    pointPart_8.setPresentationName("8 copy");

    pointPart_8.copyProperties(pointPart_7);

    simulation_0.getPartManager().getGroupsManager().groupObjects("", new ArrayList<>(Arrays.<ClientServerObject>asList(pointPart_8)));

    pointPart_8.setPresentationName("9");

    pointPart_8.getPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1600.0, 850.0, 200.0}));

    PointPart pointPart_9 = 
      simulation_0.getPartManager().createPointPart(new ArrayList<>(Collections.<NamedObject>emptyList()), new DoubleVector(new double[] {0.0, 0.0, 0.0}), null);

    pointPart_9.setPresentationName("9 copy");

    pointPart_9.copyProperties(pointPart_8);

    simulation_0.getPartManager().getGroupsManager().groupObjects("", new ArrayList<>(Arrays.<ClientServerObject>asList(pointPart_9)));

    pointPart_9.setPresentationName("10");

    pointPart_9.getPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {-1400.0, 0.0, 200.0}));

    XyzInternalTable xyzInternalTable_1 = 
      ((XyzInternalTable) simulation_0.getTableManager().getTable("Probes"));

    xyzInternalTable_1.getParts().setQuery(null);

    xyzInternalTable_1.getParts().setObjects(pointPart_0, pointPart_1, pointPart_2, pointPart_3, pointPart_4, pointPart_5, pointPart_6, pointPart_7, pointPart_8, pointPart_9);

    TableUpdate tableUpdate_1 = 
      xyzInternalTable_1.getTableUpdate();

    DeltaTimeUpdateFrequency deltaTimeUpdateFrequency_0 = 
      tableUpdate_1.getDeltaTimeUpdateFrequency();

    FilePathProperty filePathProperty_0 = 
      tableUpdate_1.getFilePathCso();

    filePathProperty_0.setFilePath("Shedding");

    Units units_1 = 
      ((Units) simulation_0.getUnitsManager().getObject("s"));

    deltaTimeUpdateFrequency_0.setDeltaTime("0.02", units_1);

    String FileName = simulation_0.getPresentationName();
    simulation_0.saveState(resolvePath(FileName + ".sim"));

    simulation_0.getSimulationIterator().run();

  }
}
