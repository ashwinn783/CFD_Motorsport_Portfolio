// Simcenter STAR-CCM+ macro: des_post.java
// Written by Simcenter STAR-CCM+ 19.06.009
package macro;

import java.util.*;
import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.flow.*;
import star.base.report.*;
import star.meshing.*;
import star.cadmodeler.*;

public class des_post extends StarMacro {

  public void execute() {
    imp1();
    imp2();
    d1();
    probe();
    p1();
    a();
  }

  private void imp1() {

    Simulation simulation_0 = 
      getActiveSimulation();

    PlaneSection planeSection_0 = 
      (PlaneSection) simulation_0.getPartManager().createImplicitPart(new ArrayList<>(Collections.<NamedObject>emptyList()), new DoubleVector(new double[] {0.0, 0.0, 1.0}), new DoubleVector(new double[] {0.0, 0.0, 0.0}), 0, 1, new DoubleVector(new double[] {0.0}), null);

    planeSection_0.setPresentationName("x=-500");

    Units units_0 = 
      ((Units) simulation_0.getUnitsManager().getObject("mm"));

    planeSection_0.getOriginCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {-500.0, 0.0, 582.4389299377799}));

    planeSection_0.getOrientationCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1000.0, 0.0, 0.0}));

    planeSection_0.getInputParts().setQuery(null);

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

    planeSection_0.getInputParts().setObjects(region_0, boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, boundary_5, boundary_6, boundary_7, boundary_8, boundary_9, boundary_10, boundary_11, boundary_12, region_1, boundary_13, boundary_14, region_2, boundary_15, boundary_16, region_3, boundary_17, boundary_18, region_4, boundary_19, boundary_20);

    PlaneSection planeSection_1 = 
      (PlaneSection) simulation_0.getPartManager().createImplicitPart(new ArrayList<>(Collections.<NamedObject>emptyList()), new DoubleVector(new double[] {0.0, 0.0, 1.0}), new DoubleVector(new double[] {0.0, 0.0, 0.0}), 0, 1, new DoubleVector(new double[] {0.0}), null);

    planeSection_1.setPresentationName("x=-500 copy");

    planeSection_1.copyProperties(planeSection_0);

    simulation_0.getPartManager().getGroupsManager().groupObjects("", new ArrayList<>(Arrays.<ClientServerObject>asList(planeSection_1)));

    planeSection_1.setPresentationName("x=1350");

    planeSection_1.getOriginCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1350.0, 0.0, 582.4389299377799}));

    PlaneSection planeSection_2 = 
      (PlaneSection) simulation_0.getPartManager().createImplicitPart(new ArrayList<>(Collections.<NamedObject>emptyList()), new DoubleVector(new double[] {0.0, 0.0, 1.0}), new DoubleVector(new double[] {0.0, 0.0, 0.0}), 0, 1, new DoubleVector(new double[] {0.0}), null);

    planeSection_2.setPresentationName("x=1350 copy");

    planeSection_2.copyProperties(planeSection_1);

    simulation_0.getPartManager().getGroupsManager().groupObjects("", new ArrayList<>(Arrays.<ClientServerObject>asList(planeSection_2)));

    planeSection_2.setPresentationName("y=-600");

    planeSection_2.getOriginCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, -600.0, 500.0}));

    planeSection_2.getOrientationCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 1.0, 0.0}));

    PlaneSection planeSection_3 = 
      (PlaneSection) simulation_0.getPartManager().createImplicitPart(new ArrayList<>(Collections.<NamedObject>emptyList()), new DoubleVector(new double[] {0.0, 0.0, 1.0}), new DoubleVector(new double[] {0.0, 0.0, 0.0}), 0, 1, new DoubleVector(new double[] {0.0}), null);

    planeSection_3.setPresentationName("y=-600 copy");

    planeSection_3.copyProperties(planeSection_2);

    simulation_0.getPartManager().getGroupsManager().groupObjects("", new ArrayList<>(Arrays.<ClientServerObject>asList(planeSection_3)));

    planeSection_3.setPresentationName("y=0");

    planeSection_3.getOriginCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 0.0, 500.0}));

    PlaneSection planeSection_4 = 
      (PlaneSection) simulation_0.getPartManager().createImplicitPart(new ArrayList<>(Collections.<NamedObject>emptyList()), new DoubleVector(new double[] {0.0, 0.0, 1.0}), new DoubleVector(new double[] {0.0, 0.0, 0.0}), 0, 1, new DoubleVector(new double[] {0.0}), null);

    planeSection_4.setPresentationName("y=-600 copy");

    planeSection_4.copyProperties(planeSection_2);

    simulation_0.getPartManager().getGroupsManager().groupObjects("", new ArrayList<>(Arrays.<ClientServerObject>asList(planeSection_4)));

    planeSection_4.setPresentationName("y=600");

    planeSection_4.getOriginCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 600.0, 500.0}));

    PlaneSection planeSection_5 = 
      (PlaneSection) simulation_0.getPartManager().createImplicitPart(new ArrayList<>(Collections.<NamedObject>emptyList()), new DoubleVector(new double[] {0.0, 0.0, 1.0}), new DoubleVector(new double[] {0.0, 0.0, 0.0}), 0, 1, new DoubleVector(new double[] {0.0}), null);

    planeSection_5.setPresentationName("y=600 copy");

    planeSection_5.copyProperties(planeSection_4);

    simulation_0.getPartManager().getGroupsManager().groupObjects("", new ArrayList<>(Arrays.<ClientServerObject>asList(planeSection_5)));

    planeSection_5.setPresentationName("z=0");

    planeSection_5.getOriginCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 0.0, 0.0}));

    planeSection_5.getOrientationCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 0.0, 1.0}));

    PlaneSection planeSection_6 = 
      (PlaneSection) simulation_0.getPartManager().createImplicitPart(new ArrayList<>(Collections.<NamedObject>emptyList()), new DoubleVector(new double[] {0.0, 0.0, 1.0}), new DoubleVector(new double[] {0.0, 0.0, 0.0}), 0, 1, new DoubleVector(new double[] {0.0}), null);

    planeSection_6.setPresentationName("z=0 copy");

    planeSection_6.copyProperties(planeSection_5);

    simulation_0.getPartManager().getGroupsManager().groupObjects("", new ArrayList<>(Arrays.<ClientServerObject>asList(planeSection_6)));

    planeSection_6.setPresentationName("z=200");

    planeSection_6.getOriginCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 0.0, 200.0}));

    simulation_0.getPartManager().getGroupsManager().createGroup("New Group");

    ((ClientServerObjectGroup) simulation_0.getPartManager().getGroupsManager().getObject("New Group")).setPresentationName("x planes");

    ((ClientServerObjectGroup) simulation_0.getPartManager().getGroupsManager().getObject("x planes")).getGroupsManager().groupObjects("x planes", new ArrayList<>(Arrays.<ClientServerObject>asList(planeSection_0, planeSection_1)));

    simulation_0.getPartManager().getGroupsManager().createGroup("New Group");

    simulation_0.getPartManager().getGroupsManager().createGroup("New Group");

    ((ClientServerObjectGroup) simulation_0.getPartManager().getGroupsManager().getObject("New Group")).setPresentationName("y planes");

    ((ClientServerObjectGroup) simulation_0.getPartManager().getGroupsManager().getObject("New Group 2")).setPresentationName("z planes");

    ((ClientServerObjectGroup) simulation_0.getPartManager().getGroupsManager().getObject("y planes")).getGroupsManager().groupObjects("y planes", new ArrayList<>(Arrays.<ClientServerObject>asList(planeSection_2, planeSection_4, planeSection_3)));

    ((ClientServerObjectGroup) simulation_0.getPartManager().getGroupsManager().getObject("z planes")).getGroupsManager().groupObjects("z planes", new ArrayList<>(Arrays.<ClientServerObject>asList(planeSection_5, planeSection_6)));

    simulation_0.getSceneManager().createScalarScene("Scalar Scene", "Outline", "Scalar", null);

    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("Scalar Scene 1");

    scene_0.resetCamera();

    scene_0.setPresentationName("x=-500");

    PartDisplayer partDisplayer_0 = 
      ((PartDisplayer) scene_0.getDisplayerManager().getObject("Outline 1"));

    simulation_0.deleteObjects(new ArrayList<>(Arrays.<ClientServerObject>asList(partDisplayer_0)));

    ScalarDisplayer scalarDisplayer_0 = 
      ((ScalarDisplayer) scene_0.getDisplayerManager().getObject("Scalar 1"));

    scalarDisplayer_0.getInputParts().setQuery(null);

    scalarDisplayer_0.getInputParts().setObjects(planeSection_0);

    PrimitiveFieldFunction primitiveFieldFunction_0 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("TotalPressure"));

    scalarDisplayer_0.getScalarDisplayQuantity().setFieldFunction(primitiveFieldFunction_0);

    scalarDisplayer_0.getScalarDisplayQuantity().setAutoRange(AutoRangeMode.NONE);

    Units units_1 = 
      ((Units) simulation_0.getUnitsManager().getObject("Pa"));

    scalarDisplayer_0.getScalarDisplayQuantity().getMaximumValue().setValueAndUnits(150.0, units_1);

    Legend legend_0 = 
      scalarDisplayer_0.getLegend();

    legend_0.setLevels(512);

    PredefinedLookupTable predefinedLookupTable_0 = 
      ((PredefinedLookupTable) simulation_0.get(LookupTableManager.class).getObject("casting"));

    legend_0.setLookupTable(predefinedLookupTable_0);

    CurrentView currentView_0 = 
      scene_0.getCurrentView();

    currentView_0.getFocalPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {-348.2093040584715, 23.26351156970985, 721.6747444480852}));

    currentView_0.getPositionCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {100562.35308548197, 23.26351156970985, 721.6747444480852}));

    currentView_0.getViewUpCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 0.0, 1000.0}));

    currentView_0.setInput(new DoubleVector(new double[] {-0.3482093040584715, 0.02326351156970985, 0.7216747444480852}), new DoubleVector(new double[] {100.56235308548197, 0.02326351156970985, 0.7216747444480852}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 26.342942926981326, 1, 30.0);

    ParallelScale parallelScale_0 = 
      currentView_0.getParallelScale();

    parallelScale_0.setValue(1.0);

    scene_0.getAnnotationPropManager().getAnnotationGroup().setQuery(null);

    PhysicalTimeAnnotation physicalTimeAnnotation_0 = 
      ((PhysicalTimeAnnotation) simulation_0.getAnnotationManager().getObject("Solution Time"));

    scene_0.getAnnotationPropManager().getAnnotationGroup().setObjects(physicalTimeAnnotation_0);

    Scene scene_1 = 
      simulation_0.getSceneManager().createScene("Scene");

    scene_1.setPresentationName("x=-500 copy");

    scene_1.copyProperties(scene_0);

    simulation_0.getSceneManager().getGroupsManager().groupObjects("", new ArrayList<>(Arrays.<ClientServerObject>asList(scene_1)));

    scene_1.openInteractive();

    scene_1.setPresentationName("x=1350");

    ScalarDisplayer scalarDisplayer_1 = 
      ((ScalarDisplayer) scene_1.getDisplayerManager().getObject("Scalar 1"));

    scalarDisplayer_1.getInputParts().setQuery(null);

    scalarDisplayer_1.getInputParts().setObjects(planeSection_1);

    CurrentView currentView_1 = 
      scene_1.getCurrentView();

    currentView_1.getFocalPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {408.46572891602176, 25.0, 585.0020025736011}));

    currentView_1.getPositionCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {100562.35308548197, 25.0, 585.0020025736011}));

    ParallelScale parallelScale_1 = 
      currentView_1.getParallelScale();

    parallelScale_1.setValue(0.7021488832392445);

    Scene scene_2 = 
      simulation_0.getSceneManager().createScene("Scene");

    scene_2.setPresentationName("x=1350 copy");

    scene_2.copyProperties(scene_1);

    simulation_0.getSceneManager().getGroupsManager().groupObjects("", new ArrayList<>(Arrays.<ClientServerObject>asList(scene_2)));

    scene_2.openInteractive();

    scene_2.setPresentationName("y=0");

    ScalarDisplayer scalarDisplayer_2 = 
      ((ScalarDisplayer) scene_2.getDisplayerManager().getObject("Scalar 1"));

    scalarDisplayer_2.getInputParts().setQuery(null);

    scalarDisplayer_2.getInputParts().setObjects(planeSection_3);

    CurrentView currentView_2 = 
      scene_2.getCurrentView();

    currentView_2.getFocalPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {559.5396907140924, -353.60701986216725, 695.8596532730216}));

    currentView_2.getPositionCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {559.5396907140924, -99969.03212128211, 695.8596532730216}));

    ParallelScale parallelScale_2 = 
      currentView_2.getParallelScale();

    parallelScale_2.setValue(1.1307592858318884);

    Scene scene_3 = 
      simulation_0.getSceneManager().createScene("Scene");

    scene_3.setPresentationName("y=0 copy");

    scene_3.copyProperties(scene_2);

    simulation_0.getSceneManager().getGroupsManager().groupObjects("", new ArrayList<>(Arrays.<ClientServerObject>asList(scene_3)));

    scene_3.openInteractive();

    scene_3.setPresentationName("y=600");

    ScalarDisplayer scalarDisplayer_3 = 
      ((ScalarDisplayer) scene_3.getDisplayerManager().getObject("Scalar 1"));

    scalarDisplayer_3.getInputParts().setQuery(null);

    scalarDisplayer_3.getInputParts().setObjects(planeSection_4);

    Scene scene_4 = 
      simulation_0.getSceneManager().createScene("Scene");

    scene_4.setPresentationName("y=600 copy");

    scene_4.copyProperties(scene_3);

    simulation_0.getSceneManager().getGroupsManager().groupObjects("", new ArrayList<>(Arrays.<ClientServerObject>asList(scene_4)));

    scene_4.openInteractive();

    scene_4.setPresentationName("z=0");

    ScalarDisplayer scalarDisplayer_4 = 
      ((ScalarDisplayer) scene_4.getDisplayerManager().getObject("Scalar 1"));

    scalarDisplayer_4.getInputParts().setQuery(null);

    scalarDisplayer_4.getInputParts().setObjects(planeSection_5);

    CurrentView currentView_3 = 
      scene_4.getCurrentView();

    currentView_3.getFocalPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {537.542168087163, -85.6286664932772, 881.0686011772333}));

    currentView_3.getPositionCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {537.542168087163, -85.6286664932772, 100920.0662378315}));

    currentView_3.getViewUpCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 1000.0, 0.0}));

    Scene scene_5 = 
      simulation_0.getSceneManager().createScene("Scene");

    scene_5.setPresentationName("z=0 copy");

    scene_5.copyProperties(scene_4);

    simulation_0.getSceneManager().getGroupsManager().groupObjects("", new ArrayList<>(Arrays.<ClientServerObject>asList(scene_5)));

    scene_5.openInteractive();

    scene_5.setPresentationName("z=200");

    ScalarDisplayer scalarDisplayer_5 = 
      ((ScalarDisplayer) scene_5.getDisplayerManager().getObject("Scalar 1"));

    scalarDisplayer_5.getInputParts().setQuery(null);

    scalarDisplayer_5.getInputParts().setObjects(planeSection_6);

    simulation_0.getSceneManager().getGroupsManager().createGroup("New Group");

    ((ClientServerObjectGroup) simulation_0.getSceneManager().getGroupsManager().getObject("New Group")).setPresentationName("Pressure");

    ((ClientServerObjectGroup) simulation_0.getSceneManager().getGroupsManager().getObject("Pressure")).getGroupsManager().groupObjects("Pressure", new ArrayList<>(Arrays.<ClientServerObject>asList(scene_0, scene_4, scene_1, scene_5, scene_2, scene_3)));

    Scene scene_6 = 
      simulation_0.getSceneManager().createScene("Scene");

    scene_6.setPresentationName("y=0 copy");

    scene_6.copyProperties(scene_2);

    simulation_0.getSceneManager().getGroupsManager().groupObjects("", new ArrayList<>(Arrays.<ClientServerObject>asList(scene_6)));

    scene_6.setPresentationName("y=0 copy copy");

    VectorDisplayer vectorDisplayer_0 = 
      scene_6.getDisplayerManager().createVectorDisplayer("Vector", ClipMode.NONE);

    ScalarDisplayer scalarDisplayer_6 = 
      ((ScalarDisplayer) scene_6.getDisplayerManager().getObject("Scalar 1"));

    simulation_0.deleteObjects(new ArrayList<>(Arrays.<ClientServerObject>asList(scalarDisplayer_6)));

    vectorDisplayer_0.setDisplayMode(VectorDisplayMode.VECTOR_DISPLAY_MODE_LIC);

    vectorDisplayer_0.getInputParts().setQuery(null);

    vectorDisplayer_0.getInputParts().setObjects(planeSection_3);

    vectorDisplayer_0.getVectorDisplayQuantity().setAutoRange(AutoRangeMode.NONE);

    Units units_2 = 
      ((Units) simulation_0.getUnitsManager().getObject("m/s"));

    vectorDisplayer_0.getVectorDisplayQuantity().getMaximumValue().setValueAndUnits(35.0, units_2);

    Legend legend_1 = 
      vectorDisplayer_0.getLegend();

    PredefinedLookupTable predefinedLookupTable_1 = 
      ((PredefinedLookupTable) simulation_0.get(LookupTableManager.class).getObject("tropical"));

    legend_1.setLookupTable(predefinedLookupTable_1);

    Scene scene_7 = 
      simulation_0.getSceneManager().createScene("Scene");

    scene_7.setPresentationName("y=0 copy copy copy");

    scene_7.copyProperties(scene_6);

    simulation_0.getSceneManager().getGroupsManager().groupObjects("", new ArrayList<>(Arrays.<ClientServerObject>asList(scene_7)));

    scene_7.setPresentationName("y=600 copy copy");

    VectorDisplayer vectorDisplayer_1 = 
      ((VectorDisplayer) scene_7.getDisplayerManager().getObject("Vector 1"));

    vectorDisplayer_1.getInputParts().setQuery(null);

    vectorDisplayer_1.getInputParts().setObjects(planeSection_4);

    Scene scene_8 = 
      simulation_0.getSceneManager().createScene("Scene");

    scene_8.setPresentationName("y=600 copy copy copy");

    scene_8.copyProperties(scene_7);

    simulation_0.getSceneManager().getGroupsManager().groupObjects("", new ArrayList<>(Arrays.<ClientServerObject>asList(scene_8)));

    scene_8.setPresentationName("z-200 copy copy");

    scene_8.setPresentationName("z=200 copy copy");

    VectorDisplayer vectorDisplayer_2 = 
      ((VectorDisplayer) scene_8.getDisplayerManager().getObject("Vector 1"));

    vectorDisplayer_2.getInputParts().setQuery(null);

    vectorDisplayer_2.getInputParts().setObjects(planeSection_6);

    CurrentView currentView_4 = 
      scene_8.getCurrentView();

    currentView_4.getFocalPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {537.542168087163, -85.6286664932772, 881.0686011772333}));

    currentView_4.getPositionCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {537.542168087163, -85.6286664932772, 100920.0662378315}));

    currentView_4.getViewUpCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 1000.0, 0.0}));

    simulation_0.getSceneManager().getGroupsManager().createGroup("New Group");

    ((ClientServerObjectGroup) simulation_0.getSceneManager().getGroupsManager().getObject("New Group")).setPresentationName("Velocity");

    ((ClientServerObjectGroup) simulation_0.getSceneManager().getGroupsManager().getObject("Velocity")).getGroupsManager().groupObjects("Velocity", new ArrayList<>(Arrays.<ClientServerObject>asList(scene_6, scene_8, scene_7)));

    Scene scene_9 = 
      simulation_0.getSceneManager().createScene("Scene");

    scene_9.setPresentationName("x=-500 copy");

    scene_9.copyProperties(scene_0);

    simulation_0.getSceneManager().getGroupsManager().groupObjects("", new ArrayList<>(Arrays.<ClientServerObject>asList(scene_9)));

    ScalarDisplayer scalarDisplayer_7 = 
      ((ScalarDisplayer) scene_9.getDisplayerManager().getObject("Scalar 1"));

    VorticityVectorFunction vorticityVectorFunction_0 = 
      ((VorticityVectorFunction) simulation_0.getFieldFunctionManager().getFunction("VorticityVector"));

    VectorMagnitudeFieldFunction vectorMagnitudeFieldFunction_0 = 
      ((VectorMagnitudeFieldFunction) vorticityVectorFunction_0.getMagnitudeFunction());

    scalarDisplayer_7.getScalarDisplayQuantity().setFieldFunction(vectorMagnitudeFieldFunction_0);

    scalarDisplayer_7.getScalarDisplayQuantity().setAutoRange(AutoRangeMode.NONE);

    Units units_3 = 
      ((Units) simulation_0.getUnitsManager().getObject("/s"));

    scalarDisplayer_7.getScalarDisplayQuantity().getMaximumValue().setValueAndUnits(200.0, units_3);

    Legend legend_2 = 
      scalarDisplayer_7.getLegend();

    PredefinedLookupTable predefinedLookupTable_2 = 
      ((PredefinedLookupTable) simulation_0.get(LookupTableManager.class).getObject("teal-pink divergent isoluminant"));

    legend_2.setLookupTable(predefinedLookupTable_2);

    PredefinedLookupTable predefinedLookupTable_3 = 
      ((PredefinedLookupTable) simulation_0.get(LookupTableManager.class).getObject("turbo"));

    legend_2.setLookupTable(predefinedLookupTable_3);

    Scene scene_10 = 
      simulation_0.getSceneManager().createScene("Scene");

    scene_10.setPresentationName("x=-500 copy copy");

    scene_10.copyProperties(scene_9);

    simulation_0.getSceneManager().getGroupsManager().groupObjects("", new ArrayList<>(Arrays.<ClientServerObject>asList(scene_10)));

    scene_10.setPresentationName("x=1350 copy");

    ScalarDisplayer scalarDisplayer_8 = 
      ((ScalarDisplayer) scene_10.getDisplayerManager().getObject("Scalar 1"));

    scalarDisplayer_8.getInputParts().setQuery(null);

    scalarDisplayer_8.getInputParts().setObjects(planeSection_1);

    CurrentView currentView_5 = 
      scene_10.getCurrentView();

    currentView_5.getFocalPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {408.46572891602176, 25.0, 585.0020025736011}));

    currentView_5.getPositionCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {100562.35308548197, 25.0, 585.0020025736011}));

    ParallelScale parallelScale_3 = 
      currentView_5.getParallelScale();

    parallelScale_3.setValue(0.7021488832392445);

    Scene scene_11 = 
      simulation_0.getSceneManager().createScene("Scene");

    scene_11.setPresentationName("x=-500 copy copy");

    scene_11.copyProperties(scene_9);

    simulation_0.getSceneManager().getGroupsManager().groupObjects("", new ArrayList<>(Arrays.<ClientServerObject>asList(scene_11)));

    scene_11.setPresentationName("y=0 copy");

    ScalarDisplayer scalarDisplayer_9 = 
      ((ScalarDisplayer) scene_11.getDisplayerManager().getObject("Scalar 1"));

    scalarDisplayer_9.getInputParts().setQuery(null);

    scalarDisplayer_9.getInputParts().setObjects(planeSection_3);

    CurrentView currentView_6 = 
      scene_11.getCurrentView();

    currentView_6.getFocalPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {559.5396907140924, -353.60701986216725, 695.8596532730216}));
  }

  private void imp2() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Scene scene_11 = 
      simulation_0.getSceneManager().getScene("y=0 copy");

    CurrentView currentView_6 = 
      scene_11.getCurrentView();

    Units units_0 = 
      ((Units) simulation_0.getUnitsManager().getObject("mm"));

    currentView_6.getPositionCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {559.5396907140924, -99969.03212128211, 695.8596532730216}));

    Scene scene_12 = 
      simulation_0.getSceneManager().createScene("Scene");

    scene_12.setPresentationName("y=0 copy copy");

    scene_12.copyProperties(scene_11);

    simulation_0.getSceneManager().getGroupsManager().groupObjects("", new ArrayList<>(Arrays.<ClientServerObject>asList(scene_12)));

    scene_12.setPresentationName("y=600 copy");

    ScalarDisplayer scalarDisplayer_10 = 
      ((ScalarDisplayer) scene_12.getDisplayerManager().getObject("Scalar 1"));

    scalarDisplayer_10.getInputParts().setQuery(null);

    PlaneSection planeSection_4 = 
      ((PlaneSection) simulation_0.getPartManager().getObject("y=600"));

    scalarDisplayer_10.getInputParts().setObjects(planeSection_4);

    Scene scene_13 = 
      simulation_0.getSceneManager().createScene("Scene");

    scene_13.setPresentationName("y=600 copy copy");

    scene_13.copyProperties(scene_12);

    simulation_0.getSceneManager().getGroupsManager().groupObjects("", new ArrayList<>(Arrays.<ClientServerObject>asList(scene_13)));

    scene_13.setPresentationName("z=200 copy");

    ScalarDisplayer scalarDisplayer_11 = 
      ((ScalarDisplayer) scene_13.getDisplayerManager().getObject("Scalar 1"));

    scalarDisplayer_11.getInputParts().setQuery(null);

    PlaneSection planeSection_6 = 
      ((PlaneSection) simulation_0.getPartManager().getObject("z=200"));

    scalarDisplayer_11.getInputParts().setObjects(planeSection_6);

    CurrentView currentView_7 = 
      scene_13.getCurrentView();

    currentView_7.getFocalPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {537.542168087163, -85.6286664932772, 881.0686011772333}));

    currentView_7.getPositionCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {537.542168087163, -85.6286664932772, 100920.0662378315}));

    currentView_7.getViewUpCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 1000.0, 0.0}));

    ParallelScale parallelScale_4 = 
      currentView_7.getParallelScale();

    parallelScale_4.setValue(1.1307592858318884);

    CurrentView currentView_8 = 
      scene_12.getCurrentView();

    ParallelScale parallelScale_5 = 
      currentView_8.getParallelScale();

    parallelScale_5.setValue(1.1307592858318884);

    ParallelScale parallelScale_6 = 
      currentView_6.getParallelScale();

    parallelScale_6.setValue(1.1307592858318884);

    simulation_0.getSceneManager().getGroupsManager().createGroup("New Group");

    ((ClientServerObjectGroup) simulation_0.getSceneManager().getGroupsManager().getObject("New Group")).setPresentationName("Vorticity");

    Scene scene_9 = 
      simulation_0.getSceneManager().getScene("x=-500 copy");

    Scene scene_10 = 
      simulation_0.getSceneManager().getScene("x=1350 copy");

    ((ClientServerObjectGroup) simulation_0.getSceneManager().getGroupsManager().getObject("Vorticity")).getGroupsManager().groupObjects("Vorticity", new ArrayList<>(Arrays.<ClientServerObject>asList(scene_9, scene_12, scene_11, scene_13, scene_10)));

    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("x=-500");

    ScalarDisplayer scalarDisplayer_0 = 
      ((ScalarDisplayer) scene_0.getDisplayerManager().getObject("Scalar 1"));

    scalarDisplayer_0.setFillMode(ScalarFillMode.NODE_FILLED);

    Scene scene_1 = 
      simulation_0.getSceneManager().getScene("x=1350");

    ScalarDisplayer scalarDisplayer_1 = 
      ((ScalarDisplayer) scene_1.getDisplayerManager().getObject("Scalar 1"));

    scalarDisplayer_1.setFillMode(ScalarFillMode.NODE_FILLED);

    Scene scene_2 = 
      simulation_0.getSceneManager().getScene("y=0");

    ScalarDisplayer scalarDisplayer_2 = 
      ((ScalarDisplayer) scene_2.getDisplayerManager().getObject("Scalar 1"));

    scalarDisplayer_2.setFillMode(ScalarFillMode.NODE_FILLED);

    Scene scene_3 = 
      simulation_0.getSceneManager().getScene("y=600");

    ScalarDisplayer scalarDisplayer_3 = 
      ((ScalarDisplayer) scene_3.getDisplayerManager().getObject("Scalar 1"));

    scalarDisplayer_3.setFillMode(ScalarFillMode.NODE_FILLED);

    Scene scene_4 = 
      simulation_0.getSceneManager().getScene("z=0");

    ScalarDisplayer scalarDisplayer_4 = 
      ((ScalarDisplayer) scene_4.getDisplayerManager().getObject("Scalar 1"));

    scalarDisplayer_4.setFillMode(ScalarFillMode.NODE_FILLED);

    Scene scene_5 = 
      simulation_0.getSceneManager().getScene("z=200");

    ScalarDisplayer scalarDisplayer_5 = 
      ((ScalarDisplayer) scene_5.getDisplayerManager().getObject("Scalar 1"));

    scalarDisplayer_5.setFillMode(ScalarFillMode.NODE_FILLED);

    ScalarDisplayer scalarDisplayer_7 = 
      ((ScalarDisplayer) scene_9.getDisplayerManager().getObject("Scalar 1"));

    scalarDisplayer_7.setFillMode(ScalarFillMode.NODE_FILLED);

    ScalarDisplayer scalarDisplayer_8 = 
      ((ScalarDisplayer) scene_10.getDisplayerManager().getObject("Scalar 1"));

    scalarDisplayer_8.setFillMode(ScalarFillMode.NODE_FILLED);

    ScalarDisplayer scalarDisplayer_9 = 
      ((ScalarDisplayer) scene_11.getDisplayerManager().getObject("Scalar 1"));

    scalarDisplayer_9.setFillMode(ScalarFillMode.NODE_FILLED);

    scalarDisplayer_10.setFillMode(ScalarFillMode.NODE_FILLED);

    scalarDisplayer_11.setFillMode(ScalarFillMode.NODE_FILLED);
  }
  private void d1() {

    Simulation simulation_0 = 
      getActiveSimulation();

    PointPart pointPart_0 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint1 3"));

    PointPart pointPart_1 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint3 3"));

    PointPart pointPart_2 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint8 3"));

    PointPart pointPart_3 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint5 3"));

    PointPart pointPart_4 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint6 3"));

    PointPart pointPart_5 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint2 3"));

    PointPart pointPart_6 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint4 3"));

    PointPart pointPart_7 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint7 3"));

    simulation_0.deleteObjects(new ArrayList<>(Arrays.<ClientServerObject>asList(pointPart_0, pointPart_1, pointPart_2, pointPart_3, pointPart_4, pointPart_5, pointPart_6, pointPart_7)));

    PointPart pointPart_8 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint1"));

    PointPart pointPart_9 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint47"));

    PointPart pointPart_10 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint36"));

    PointPart pointPart_11 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint24"));

    PointPart pointPart_12 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint30"));

    PointPart pointPart_13 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint9"));

    PointPart pointPart_14 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint2"));

    PointPart pointPart_15 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint5"));

    PointPart pointPart_16 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint13"));

    PointPart pointPart_17 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint15"));

    PointPart pointPart_18 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint16"));

    PointPart pointPart_19 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint27"));

    PointPart pointPart_20 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint43"));

    PointPart pointPart_21 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint20"));

    PointPart pointPart_22 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint35"));

    PointPart pointPart_23 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint22"));

    PointPart pointPart_24 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint14"));

    PointPart pointPart_25 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint38"));

    PointPart pointPart_26 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint8"));

    PointPart pointPart_27 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint39"));

    PointPart pointPart_28 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint41"));

    PointPart pointPart_29 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint34"));

    PointPart pointPart_30 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint6"));

    PointPart pointPart_31 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint7"));

    PointPart pointPart_32 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint46"));

    PointPart pointPart_33 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint48"));

    PointPart pointPart_34 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint25"));

    PointPart pointPart_35 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint3"));

    PointPart pointPart_36 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint18"));

    PointPart pointPart_37 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint44"));

    PointPart pointPart_38 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint32"));

    PointPart pointPart_39 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint21"));

    PointPart pointPart_40 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint37"));

    PointPart pointPart_41 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint4"));

    PointPart pointPart_42 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint40"));

    PointPart pointPart_43 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint17"));

    PointPart pointPart_44 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint45"));

    PointPart pointPart_45 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint26"));

    PointPart pointPart_46 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint31"));

    PointPart pointPart_47 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint10"));

    PointPart pointPart_48 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint19"));

    PointPart pointPart_49 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint11"));

    PointPart pointPart_50 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint29"));

    PointPart pointPart_51 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint23"));

    PointPart pointPart_52 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint12"));

    PointPart pointPart_53 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint42"));

    PointPart pointPart_54 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint33"));

    PointPart pointPart_55 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint28"));

    simulation_0.deleteObjects(new ArrayList<>(Arrays.<ClientServerObject>asList(pointPart_8, pointPart_9, pointPart_10, pointPart_11, pointPart_12, pointPart_13, pointPart_14, pointPart_15, pointPart_16, pointPart_17, pointPart_18, pointPart_19, pointPart_20, pointPart_21, pointPart_22, pointPart_23, pointPart_24, pointPart_25, pointPart_26, pointPart_27, pointPart_28, pointPart_29, pointPart_30, pointPart_31, pointPart_32, pointPart_33, pointPart_34, pointPart_35, pointPart_36, pointPart_37, pointPart_38, pointPart_39, pointPart_40, pointPart_41, pointPart_42, pointPart_43, pointPart_44, pointPart_45, pointPart_46, pointPart_47, pointPart_48, pointPart_49, pointPart_50, pointPart_51, pointPart_52, pointPart_53, pointPart_54, pointPart_55)));

    PointPart pointPart_56 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint1 2"));

    PointPart pointPart_57 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint8 2"));

    PointPart pointPart_58 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint4 2"));

    PointPart pointPart_59 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint2 2"));

    PointPart pointPart_60 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint7 2"));

    PointPart pointPart_61 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint5 2"));

    PointPart pointPart_62 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint3 2"));

    PointPart pointPart_63 = 
      ((PointPart) simulation_0.getPartManager().getObject("ProbePoint6 2"));

    simulation_0.deleteObjects(new ArrayList<>(Arrays.<ClientServerObject>asList(pointPart_56, pointPart_57, pointPart_58, pointPart_59, pointPart_60, pointPart_61, pointPart_62, pointPart_63)));

    ((ClientServerObjectGroup) simulation_0.getPartManager().getGroupsManager().getObject("Front_probes")).getGroupsManager().unGroupObjects();

    ((ClientServerObjectGroup) simulation_0.getPartManager().getGroupsManager().getObject("Side_probes")).getGroupsManager().unGroupObjects();

    ((ClientServerObjectGroup) simulation_0.getPartManager().getGroupsManager().getObject("RW_probes")).getGroupsManager().unGroupObjects();
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

    tableUpdate_0.setSaveToFile(false);

    tableUpdate_0.getUpdateModeOption().setSelected(StarUpdateModeOption.Type.DELTATIME);

    FilePathProperty filePathProperty_0 = 
      tableUpdate_0.getFilePathCso();

    filePathProperty_0.setFilePath(".");

    filePathProperty_0.setFilePath("Validation");

    DeltaTimeUpdateFrequency deltaTimeUpdateFrequency_0 = 
      tableUpdate_0.getDeltaTimeUpdateFrequency();

    Units units_1 = 
      ((Units) simulation_0.getUnitsManager().getObject("s"));

    deltaTimeUpdateFrequency_0.setDeltaTime("0.1", units_1);
    
  }

    private void a() {

    Simulation simulation_0 = 
      getActiveSimulation();

    LinePart linePart_0 = 
      simulation_0.getPartManager().createLinePart(new ArrayList<>(Collections.<NamedObject>emptyList()), new DoubleVector(new double[] {0.0, 0.0, 0.0}), new DoubleVector(new double[] {1.0, 0.0, 0.0}), 20, null);

    linePart_0.setPresentationName("Free_probe");

    linePart_0.getInputParts().setQuery(null);

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

    linePart_0.getInputParts().setObjects(region_0, boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, boundary_5, boundary_6, boundary_7, boundary_8, boundary_9, boundary_10, boundary_11, boundary_12, region_1, boundary_13, boundary_14, region_2, boundary_15, boundary_16, region_3, boundary_17, boundary_18, region_4, boundary_19, boundary_20);

    Units units_0 = 
      ((Units) simulation_0.getUnitsManager().getObject("m"));

    linePart_0.getPoint1Coordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {2000.0, 0.0, 700.0}));

    linePart_0.getPoint2Coordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {2000.0, 0.0, 1200.0}));

    linePart_0.setResolution(100);

    LinePart linePart_1 = 
      simulation_0.getPartManager().createLinePart(new ArrayList<>(Collections.<NamedObject>emptyList()), new DoubleVector(new double[] {0.0, 0.0, 0.0}), new DoubleVector(new double[] {1.0, 0.0, 0.0}), 20, null);

    linePart_1.setPresentationName("Free_probe copy");

    linePart_1.copyProperties(linePart_0);

    simulation_0.getPartManager().getGroupsManager().groupObjects("", new ArrayList<>(Arrays.<ClientServerObject>asList(linePart_1)));

    linePart_1.setPresentationName("Wake_probe");

    linePart_1.getPoint1Coordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {-500.0, 0.0, 800.0}));

    linePart_1.getPoint2Coordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {-1000.0, 0.0, 800.0}));

    MaxReport maxReport_0 = 
      simulation_0.getReportManager().create("star.base.report.MaxReport");

    maxReport_0.setPresentationName("Free_probe");

    PrimitiveFieldFunction primitiveFieldFunction_0 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Velocity"));

    VectorMagnitudeFieldFunction vectorMagnitudeFieldFunction_0 = 
      ((VectorMagnitudeFieldFunction) primitiveFieldFunction_0.getMagnitudeFunction());

    maxReport_0.setFieldFunction(vectorMagnitudeFieldFunction_0);

    maxReport_0.getParts().setQuery(null);

    maxReport_0.getParts().setObjects(linePart_0);

    LatestMeshProxyRepresentation latestMeshProxyRepresentation_0 = 
      ((LatestMeshProxyRepresentation) simulation_0.getRepresentationManager().getObject("Latest Surface/Volume"));

    maxReport_0.setRepresentation(latestMeshProxyRepresentation_0);

    MaxReport maxReport_1 = 
      simulation_0.getReportManager().create("star.base.report.MaxReport");

    maxReport_1.setPresentationName("Wake_probe");

    maxReport_1.setFieldFunction(vectorMagnitudeFieldFunction_0);

    maxReport_1.getParts().setQuery(null);

    maxReport_1.getParts().setObjects(linePart_1);

    maxReport_1.setRepresentation(latestMeshProxyRepresentation_0);

    simulation_0.getMonitorManager().createMonitorAndPlot(new ArrayList<>(Arrays.<Report>asList(maxReport_0)), true, "%1$s Plot");

    ReportMonitor reportMonitor_0 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Free_probe Monitor"));

    MonitorPlot monitorPlot_0 = 
      simulation_0.getPlotManager().createMonitorPlot(new ArrayList<>(Arrays.<Monitor>asList(reportMonitor_0)), "Free_probe Monitor Plot");

    monitorPlot_0.openInteractive();

    simulation_0.getMonitorManager().createMonitorAndPlot(new ArrayList<>(Arrays.<Report>asList(maxReport_1)), true, "%1$s Plot");

    ReportMonitor reportMonitor_1 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Wake_probe Monitor"));

    MonitorPlot monitorPlot_1 = 
      simulation_0.getPlotManager().createMonitorPlot(new ArrayList<>(Arrays.<Monitor>asList(reportMonitor_1)), "Wake_probe Monitor Plot");

    monitorPlot_1.openInteractive();

    XyzInternalTable xyzInternalTable_0 = 
      simulation_0.getTableManager().create("star.common.XyzInternalTable");

    xyzInternalTable_0.setPresentationName("Probes");

    VectorComponentFieldFunction vectorComponentFieldFunction_0 = 
      ((VectorComponentFieldFunction) primitiveFieldFunction_0.getComponentFunction(0));

    VectorComponentFieldFunction vectorComponentFieldFunction_1 = 
      ((VectorComponentFieldFunction) primitiveFieldFunction_0.getComponentFunction(1));

    VectorComponentFieldFunction vectorComponentFieldFunction_2 = 
      ((VectorComponentFieldFunction) primitiveFieldFunction_0.getComponentFunction(2));

    xyzInternalTable_0.setFieldFunctions(new ArrayList<>(Arrays.<FieldFunction>asList(vectorComponentFieldFunction_0, vectorComponentFieldFunction_1, vectorComponentFieldFunction_2)));

    xyzInternalTable_0.getParts().setQuery(null);

    xyzInternalTable_0.getParts().setObjects(linePart_0, linePart_1);

    xyzInternalTable_0.setRepresentation(latestMeshProxyRepresentation_0);
  }
}
