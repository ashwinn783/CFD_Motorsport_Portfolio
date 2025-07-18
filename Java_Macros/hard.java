// Simcenter STAR-CCM+ macro: hard.java
// Written by Simcenter STAR-CCM+ 19.06.008
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.flow.*;

public class hard extends StarMacro {

  public void execute() {
    imp1();
    imp2();
    //execute0();
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

    SimpleAnnotation simpleAnnotation_0 = 
      ((SimpleAnnotation) simulation_0.getAnnotationManager().getObject("simulation name"));

    scene_0.getAnnotationPropManager().getAnnotationGroup().setObjects(simpleAnnotation_0);

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

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("x=-500");

    scene_0.printAndWait(resolvePath("x-500_p.png"), 1, 1920, 1080, true, false);

    Scene scene_1 = 
      simulation_0.getSceneManager().getScene("x=1350");

    scene_1.printAndWait(resolvePath("x1350_p.png"), 1, 1920, 1080, true, false);

    Scene scene_3 = 
      simulation_0.getSceneManager().getScene("y=0");

    scene_3.printAndWait(resolvePath("y0_p.png"), 1, 1920, 1080, true, false);

    Scene scene_4 = 
      simulation_0.getSceneManager().getScene("y=600");

    scene_4.printAndWait(resolvePath("y600_p.png"), 1, 1920, 1080, true, false);

    Scene scene_5 = 
      simulation_0.getSceneManager().getScene("z=0");

    scene_5.printAndWait(resolvePath("z0_p.png"), 1, 1920, 1080, true, false);

    Scene scene_6 = 
      simulation_0.getSceneManager().getScene("z=200");

    scene_6.printAndWait(resolvePath("z200_p.png"), 1, 1920, 1080, true, false);

    Scene scene_7 = 
      simulation_0.getSceneManager().getScene("x=-500 copy copy");

    scene_7.printAndWait(resolvePath("x-500_vel.png"), 1, 1920, 1080, true, false);

    Scene scene_8 = 
      simulation_0.getSceneManager().getScene("x=1350 copy copy");

    scene_8.printAndWait(resolvePath("x1350_vel.png"), 1, 1920, 1080, true, false);

    Scene scene_9 = 
      simulation_0.getSceneManager().getScene("y=-600 copy copy");

    scene_9.printAndWait(resolvePath("y-600_vel.png"), 1, 1920, 1080, true, false);

    Scene scene_10 = 
      simulation_0.getSceneManager().getScene("y=0 copy copy");

    scene_10.printAndWait(resolvePath("y0_vel.png"), 1, 1920, 1080, true, false);

    Scene scene_11 = 
      simulation_0.getSceneManager().getScene("y=600 copy copy");

    scene_11.printAndWait(resolvePath("y600_vel.png"), 1, 1920, 1080, true, false);

    Scene scene_12 = 
      simulation_0.getSceneManager().getScene("z=0 copy copy");

    scene_12.printAndWait(resolvePath("z0_vel.png"), 1, 1920, 1080, true, false);

    Scene scene_13 = 
      simulation_0.getSceneManager().getScene("z=200 copy copy");

    scene_13.printAndWait(resolvePath("z200_vel.png"), 1, 1920, 1080, true, false);

    Scene scene_14 = 
      simulation_0.getSceneManager().getScene("x=-500 copy");

    scene_14.printAndWait(resolvePath("x-500_vor.png"), 1, 1920, 1080, true, false);

    Scene scene_15 = 
      simulation_0.getSceneManager().getScene("x=1350 copy");

    scene_15.printAndWait(resolvePath("x1350_vor.png"), 1, 1920, 1080, true, false);

    Scene scene_16 = 
      simulation_0.getSceneManager().getScene("y=-600 copy");

    scene_16.printAndWait(resolvePath("y-600_vor.png"), 1, 1920, 1080, true, false);

    Scene scene_17 = 
      simulation_0.getSceneManager().getScene("y=0 copy");

    scene_17.printAndWait(resolvePath("y0_vor.png"), 1, 1920, 1080, true, false);

    Scene scene_18 = 
      simulation_0.getSceneManager().getScene("y=600 copy");

    scene_18.printAndWait(resolvePath("y600_vor.png"), 1, 1920, 1080, true, false);

    Scene scene_19 = 
      simulation_0.getSceneManager().getScene("z=0 copy");

    scene_19.printAndWait(resolvePath("z0_vor.png"), 1, 1920, 1080, true, false);

    Scene scene_20 = 
      simulation_0.getSceneManager().getScene("z=200 copy");

    scene_20.printAndWait(resolvePath("z200_vor.png"), 1, 1920, 1080, true, false);



}
}
