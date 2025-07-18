// Simcenter STAR-CCM+ macro: scenes.java
// Written by Simcenter STAR-CCM+ 19.06.009
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.cadmodeler.*;
import star.meshing.*;

public class scenes extends StarMacro {

  public void execute() {
    execute0();
    execute1();
    execute2();
    execute3();
    execute4();
    execute5();
    execute6();
    execute7();
    execute8();
    execute9();
    execute10();
    execute11();
	execute12();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    simulation_0.getSceneManager().createGeometryScene("Geometry Scene", "Outline", "Surface", 1, null);

    Scene scene_1 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 2");

    scene_1.resetCamera();

    PartDisplayer partDisplayer_0 = 
      ((PartDisplayer) scene_1.getDisplayerManager().getObject("Outline 1"));

    simulation_0.deleteObjects(new ArrayList<>(Arrays.<ClientServerObject>asList(partDisplayer_0)));

    UserFieldFunction userFieldFunction_0 = 
      simulation_0.getFieldFunctionManager().createFieldFunction();

    userFieldFunction_0.getTypeOption().setSelected(FieldFunctionTypeOption.Type.SCALAR);

    userFieldFunction_0.setPresentationName("topnose");

    userFieldFunction_0.setFunctionName("topnose");

    Units units_0 = 
      simulation_0.getUnitsManager().getPreferredUnits(Dimensions.Builder().length(1).build());

    userFieldFunction_0.setDefinition("$${Position}[2]>(-0.2*$${Position}[0] + 0.85) && $${Position}[0]>1.3");

    UserFieldFunction userFieldFunction_1 = 
      simulation_0.getFieldFunctionManager().createFieldFunction();

    userFieldFunction_1.getTypeOption().setSelected(FieldFunctionTypeOption.Type.SCALAR);

    userFieldFunction_1.setPresentationName("bottomnose");

    userFieldFunction_1.setFunctionName("bottomnose");

    userFieldFunction_1.setDefinition("$${Position}[2]<(-0.2*$${Position}[0]+0.85) && $${Position}[2]<0.588");

    Units units_1 = 
      simulation_0.getUnitsManager().getPreferredUnits(Dimensions.Builder().build());

    scene_1.setTransparencyOverrideMode(SceneTransparencyOverride.MAKE_SCENE_TRANSPARENT);

    scene_1.getCreatorGroup().setQuery(null);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Air");

    Region region_1 = 
      simulation_0.getRegionManager().getRegion("Cells deleted from Air");

    Region region_2 = 
      simulation_0.getRegionManager().getRegion("Cells deleted from MRF-FL");

    Region region_3 = 
      simulation_0.getRegionManager().getRegion("Cells deleted from MRF-FR");

    Region region_4 = 
      simulation_0.getRegionManager().getRegion("Cells deleted from MRF-RL");

    Region region_5 = 
      simulation_0.getRegionManager().getRegion("Cells deleted from MRF-RR");

    Region region_6 = 
      simulation_0.getRegionManager().getRegion("MRF-FL");

    Region region_7 = 
      simulation_0.getRegionManager().getRegion("MRF-FR");

    Region region_8 = 
      simulation_0.getRegionManager().getRegion("MRF-RL");

    Region region_9 = 
      simulation_0.getRegionManager().getRegion("MRF-RR");

    scene_1.getCreatorGroup().setObjects(region_0, region_1, region_2, region_3, region_4, region_5, region_6, region_7, region_8, region_9);

    scene_1.getCreatorGroup().setQuery(null);

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("mono");

    scene_1.getCreatorGroup().setObjects(boundary_0);

    PartDisplayer partDisplayer_1 = 
      scene_1.getDisplayerManager().createPartDisplayer("Threshold Surface", -1, 1);

    scene_1.setTransparencyOverrideMode(SceneTransparencyOverride.MAKE_SCENE_TRANSPARENT);

    ThresholdPart thresholdPart_0 = 
      simulation_0.getPartManager().createThresholdPart(new ArrayList<>(Arrays.<NamedObject>asList(boundary_0)), new DoubleVector(new double[] {0.99, 0.99}), units_1, userFieldFunction_0, 1, null);

    partDisplayer_1.getVisibleParts().addParts(thresholdPart_0);

    partDisplayer_1.getHiddenParts().addParts();

    scene_1.setTransparencyOverrideMode(SceneTransparencyOverride.USE_DISPLAYER_PROPERTY);

    scene_1.setTransparencyOverrideMode(SceneTransparencyOverride.MAKE_SCENE_TRANSPARENT);

    scene_1.getCreatorGroup().setQuery(null);

    scene_1.getCreatorGroup().setObjects(region_0, region_1, region_2, region_3, region_4, region_5, region_6, region_7, region_8, region_9);

    scene_1.getCreatorGroup().setQuery(null);

    scene_1.getCreatorGroup().setObjects(boundary_0);

    PartDisplayer partDisplayer_2 = 
      scene_1.getDisplayerManager().createPartDisplayer("Threshold Surface", -1, 1);

    scene_1.setTransparencyOverrideMode(SceneTransparencyOverride.MAKE_SCENE_TRANSPARENT);

    ThresholdPart thresholdPart_1 = 
      simulation_0.getPartManager().createThresholdPart(new ArrayList<>(Arrays.<NamedObject>asList(boundary_0)), new DoubleVector(new double[] {0.99, 0.99}), units_1, userFieldFunction_1, 1, null);

    partDisplayer_2.getVisibleParts().addParts(thresholdPart_1);

    partDisplayer_2.getHiddenParts().addParts();

    scene_1.setTransparencyOverrideMode(SceneTransparencyOverride.USE_DISPLAYER_PROPERTY);

    PartDisplayer partDisplayer_3 = 
      ((PartDisplayer) scene_1.getDisplayerManager().getObject("Surface 1"));

    simulation_0.deleteObjects(new ArrayList<>(Arrays.<ClientServerObject>asList(partDisplayer_3)));

    CurrentView currentView_0 = 
      scene_1.getCurrentView();

    currentView_0.setInput(new DoubleVector(new double[] {-4.7938779569795775, 0.0012404824747887788, 0.0037113590749484615}), new DoubleVector(new double[] {-4.7938779569795775, 0.0012404824747887788, 26.078306143278837}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 22.852789764052886, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {3.4329155648834226, 1.8071219872739837, 0.03499999048211677}), new DoubleVector(new double[] {3.4329155648834226, 1.8071219872739837, 26.078306143278837}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 22.852789764052886, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {3.6499888214163905, -0.20671986087387706, 2.483972971602679}), new DoubleVector(new double[] {6.391491472920304, -25.640312439646866, 7.369699848648019}), new DoubleVector(new double[] {0.08656332335517718, 0.19693081556116557, 0.9765884726598646}), 22.852789764052886, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {2.0518496923795095, 1.9636925327797348, 2.196385946179152}), new DoubleVector(new double[] {27.867466936037196, -3.905657490935008, 0.9361884868759732}), new DoubleVector(new double[] {0.09128441428741017, 0.19169024533038448, 0.9772011080393791}), 22.852789764052886, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.7689659949111078, 1.8554570618404638, 2.221160134740381}), new DoubleVector(new double[] {26.878776491722014, 8.59209874096115, 0.2045385519188107}), new DoubleVector(new double[] {0.027707168326746343, 0.19047908787738949, 0.981300173191017}), 22.852789764052886, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.16142281004155912, 1.3114161611621986, 1.4688507590815034}), new DoubleVector(new double[] {13.182525002359856, 4.804811690690465, 0.42309871262582255}), new DoubleVector(new double[] {0.027707168326746343, 0.19047908787738949, 0.981300173191017}), 22.852789764052886, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.2535650906268044, 2.166027972059852, 1.565818192278297}), new DoubleVector(new double[] {12.946959468235342, 5.707560232559435, 0.5056563589841533}), new DoubleVector(new double[] {0.027707168326746343, 0.19047908787738949, 0.981300173191017}), 22.852789764052886, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {-1.6587127223169058, 1.410511505311792, 1.594870357389986}), new DoubleVector(new double[] {7.349322190052609, 12.209109937028826, 2.7269583832106354}), new DoubleVector(new double[] {-0.18704396451095492, 0.0531941069899484, 0.9809102621145218}), 22.852789764052886, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.6484983590501083, 0.9560528459628737, 1.230484265284443}), new DoubleVector(new double[] {8.956685733756085, 10.915692215445677, 2.2746187002280154}), new DoubleVector(new double[] {-0.18704396451095492, 0.0531941069899484, 0.9809102621145218}), 22.852789764052886, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.1864848066894842, 0.6112909589882953, 0.8714690103537551}), new DoubleVector(new double[] {5.600750473021364, 5.902998058855085, 1.4262334348103427}), new DoubleVector(new double[] {-0.18704396451095492, 0.0531941069899484, 0.9809102621145218}), 22.852789764052886, 0, 30.0);

    partDisplayer_1.setPresentationName("topnose");

    partDisplayer_1.setColorMode(PartColorMode.PRESET);

    PresetColorSettings presetColorSettings_0 = 
      partDisplayer_1.getPresetColorSettings();

    RayTraceMatteMaterial rayTraceMatteMaterial_0 = 
      ((RayTraceMatteMaterial) simulation_0.get(RayTraceMaterialManager.class).getObject("Matte White"));

    presetColorSettings_0.setRayTraceMaterial(rayTraceMatteMaterial_0);

    partDisplayer_2.setPresentationName("bottomnose");

    partDisplayer_2.setShrinkFactor(1.0);

    partDisplayer_2.setColorMode(PartColorMode.PRESET);

    PresetColorSettings presetColorSettings_1 = 
      partDisplayer_2.getPresetColorSettings();

    RayTraceMatteMaterial rayTraceMatteMaterial_1 = 
      ((RayTraceMatteMaterial) simulation_0.get(RayTraceMaterialManager.class).getObject("Matte Dark Gray"));

    presetColorSettings_1.setRayTraceMaterial(rayTraceMatteMaterial_1);

    PartDisplayer partDisplayer_4 = 
      scene_1.getDisplayerManager().createPartDisplayer("Surface", -1, 1);

    partDisplayer_4.setPresentationName("floor");

    partDisplayer_4.setColorMode(PartColorMode.PRESET);

    PartRepresentation partRepresentation_0 = 
      ((PartRepresentation) simulation_0.getRepresentationManager().getObject("Geometry"));

    partDisplayer_4.setRepresentation(partRepresentation_0);

    partDisplayer_4.getInputParts().setQuery(null);

    SimpleBlockPart simpleBlockPart_0 = 
      ((SimpleBlockPart) simulation_0.get(SimulationPartManager.class).getPart("t_open-road-tunnel"));

    PartSurface partSurface_0 = 
      ((PartSurface) simpleBlockPart_0.getPartSurfaceManager().getPartSurface("floor"));

    partDisplayer_4.getInputParts().setObjects(partSurface_0);

    PresetColorSettings presetColorSettings_2 = 
      partDisplayer_4.getPresetColorSettings();

    RayTraceSimpleMetalMaterial rayTraceSimpleMetalMaterial_0 = 
      ((RayTraceSimpleMetalMaterial) simulation_0.get(RayTraceMaterialManager.class).getObject("Metallic Light Gray"));

    presetColorSettings_2.setRayTraceMaterial(rayTraceSimpleMetalMaterial_0);

    currentView_0.setInput(new DoubleVector(new double[] {-1.0530732374973988, -1.0390825031685549, -0.3554205634320172}), new DoubleVector(new double[] {5.143676664512931, 6.389420430551691, 0.42335820811093805}), new DoubleVector(new double[] {-0.18704396451095492, 0.0531941069899484, 0.9809102621145218}), 22.852789764052886, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {-2.6447634093602126, -3.03544605167365, -0.5277190941079296}), new DoubleVector(new double[] {6.943929744776613, 5.569052416709898, 1.5853727057002043}), new DoubleVector(new double[] {-0.22605948654151362, 0.012714179938683333, 0.9740305221978949}), 22.852789764052886, 0, 30.0);

    RayTraceMetalMaterial rayTraceMetalMaterial_0 = 
      ((RayTraceMetalMaterial) simulation_0.get(RayTraceMaterialManager.class).getObject("Aluminum"));

    presetColorSettings_2.setRayTraceMaterial(rayTraceMetalMaterial_0);

    currentView_0.setInput(new DoubleVector(new double[] {1.4600514878370192, 1.3048453277956584, -0.11939221016421495}), new DoubleVector(new double[] {6.684993031365251, 5.993492757219984, 1.0320453165797785}), new DoubleVector(new double[] {-0.22605948654151362, 0.012714179938683333, 0.9740305221978949}), 22.852789764052886, 0, 30.0);

    currentView_0.setRepresentation(null);

    VisView visView_0 = 
      ((VisView) simulation_0.getViewManager().getObject("View 1"));

    currentView_0.setView(visView_0);

    PartDisplayer partDisplayer_5 = 
      scene_1.getDisplayerManager().createPartDisplayer("Surface", -1, 1);

    partDisplayer_5.setPresentationName("aero");

    partDisplayer_5.setColorMode(PartColorMode.PRESET);

    partDisplayer_5.setRepresentation(partRepresentation_0);

    partDisplayer_5.getInputParts().setQuery(null);

    SolidModelCompositePart solidModelCompositePart_0 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("C_FRONTWING"));

    CompositePart compositePart_0 = 
      ((CompositePart) solidModelCompositePart_0.getChildParts().getPart("A_F000_FRONTWING_ASM"));

    CadPart cadPart_0 = 
      ((CadPart) compositePart_0.getChildParts().getPart("A_F001_MAINELEMENT"));

    PartSurface partSurface_1 = 
      ((PartSurface) cadPart_0.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_0 = 
      ((PartCurve) cadPart_0.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_1 = 
      ((CadPart) compositePart_0.getChildParts().getPart("A_F002_LOWER_TOWERFLAP"));

    PartSurface partSurface_2 = 
      ((PartSurface) cadPart_1.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_1 = 
      ((PartCurve) cadPart_1.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_2 = 
      ((CadPart) compositePart_0.getChildParts().getPart("A_F002_LOWER_TOWERFLAP_MIR"));

    PartSurface partSurface_3 = 
      ((PartSurface) cadPart_2.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_2 = 
      ((PartCurve) cadPart_2.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_3 = 
      ((CadPart) compositePart_0.getChildParts().getPart("A_F003_MIDDLE_TOWERFLAP"));

    PartSurface partSurface_4 = 
      ((PartSurface) cadPart_3.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_3 = 
      ((PartCurve) cadPart_3.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_4 = 
      ((CadPart) compositePart_0.getChildParts().getPart("A_F003_MIDDLE_TOWERFLAP_MIR"));

    PartSurface partSurface_5 = 
      ((PartSurface) cadPart_4.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_4 = 
      ((PartCurve) cadPart_4.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_5 = 
      ((CadPart) compositePart_0.getChildParts().getPart("A_F004_UPPER_TOWERFLAP"));

    PartSurface partSurface_6 = 
      ((PartSurface) cadPart_5.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_5 = 
      ((PartCurve) cadPart_5.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_6 = 
      ((CadPart) compositePart_0.getChildParts().getPart("A_F004_UPPER_TOWERFLAP_MIR"));

    PartSurface partSurface_7 = 
      ((PartSurface) cadPart_6.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_6 = 
      ((PartCurve) cadPart_6.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_1 = 
      ((CompositePart) compositePart_0.getChildParts().getPart("A_F006_OUTER_FLAP_01"));

    CadPart cadPart_7 = 
      ((CadPart) compositePart_1.getChildParts().getPart("A_F006_OUTER_FLAP_01_Body"));

    PartSurface partSurface_8 = 
      ((PartSurface) cadPart_7.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_9 = 
      ((PartSurface) cadPart_7.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_7 = 
      ((PartCurve) cadPart_7.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_8 = 
      ((CadPart) compositePart_0.getChildParts().getPart("A_F006_OUTER_FLAP_01_MIR"));

    PartSurface partSurface_10 = 
      ((PartSurface) cadPart_8.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_8 = 
      ((PartCurve) cadPart_8.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_9 = 
      ((CadPart) compositePart_0.getChildParts().getPart("A_F007_OUTER_FLAP_02"));

    PartSurface partSurface_11 = 
      ((PartSurface) cadPart_9.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_9 = 
      ((PartCurve) cadPart_9.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_10 = 
      ((CadPart) compositePart_0.getChildParts().getPart("A_F007_OUTER_FLAP_02_MIR"));

    PartSurface partSurface_12 = 
      ((PartSurface) cadPart_10.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_10 = 
      ((PartCurve) cadPart_10.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_11 = 
      ((CadPart) compositePart_0.getChildParts().getPart("A_F008_MIDDLE_PLATE"));

    PartSurface partSurface_13 = 
      ((PartSurface) cadPart_11.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_11 = 
      ((PartCurve) cadPart_11.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_12 = 
      ((CadPart) compositePart_0.getChildParts().getPart("A_F008_MIDDLE_PLATE_MIR"));

    PartSurface partSurface_14 = 
      ((PartSurface) cadPart_12.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_12 = 
      ((PartCurve) cadPart_12.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_13 = 
      ((CadPart) compositePart_0.getChildParts().getPart("A_F009_ENDPLATE"));

    PartSurface partSurface_15 = 
      ((PartSurface) cadPart_13.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_13 = 
      ((PartCurve) cadPart_13.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_14 = 
      ((CadPart) compositePart_0.getChildParts().getPart("A_F009_ENDPLATE_MIR"));

    PartSurface partSurface_16 = 
      ((PartSurface) cadPart_14.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_14 = 
      ((PartCurve) cadPart_14.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_15 = 
      ((CadPart) compositePart_0.getChildParts().getPart("A_F010_MIDDLE_TOWERFLAP_EP"));

    PartSurface partSurface_17 = 
      ((PartSurface) cadPart_15.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_15 = 
      ((PartCurve) cadPart_15.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_16 = 
      ((CadPart) compositePart_0.getChildParts().getPart("A_F010_MIDDLE_TOWERFLAP_EP_MIR"));

    PartSurface partSurface_18 = 
      ((PartSurface) cadPart_16.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_16 = 
      ((PartCurve) cadPart_16.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_17 = 
      ((CadPart) compositePart_0.getChildParts().getPart("A_F011_BULLWING"));

    PartSurface partSurface_19 = 
      ((PartSurface) cadPart_17.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_17 = 
      ((PartCurve) cadPart_17.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_18 = 
      ((CadPart) compositePart_0.getChildParts().getPart("A_F011_BULLWING_MIR"));

    PartSurface partSurface_20 = 
      ((PartSurface) cadPart_18.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_18 = 
      ((PartCurve) cadPart_18.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_19 = 
      ((CadPart) compositePart_0.getChildParts().getPart("A_F012_LOWER_TOWERFLAP_EP"));

    PartSurface partSurface_21 = 
      ((PartSurface) cadPart_19.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_19 = 
      ((PartCurve) cadPart_19.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_20 = 
      ((CadPart) compositePart_0.getChildParts().getPart("A_F012_LOWER_TOWERFLAP_EP_MIR"));

    PartSurface partSurface_22 = 
      ((PartSurface) cadPart_20.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_20 = 
      ((PartCurve) cadPart_20.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_2 = 
      ((CompositePart) compositePart_0.getChildParts().getPart("A_FC00_CASCADE"));

    CadPart cadPart_21 = 
      ((CadPart) compositePart_2.getChildParts().getPart("A_FC01_CASCADE_FLAP1"));

    PartSurface partSurface_23 = 
      ((PartSurface) cadPart_21.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_21 = 
      ((PartCurve) cadPart_21.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_22 = 
      ((CadPart) compositePart_2.getChildParts().getPart("A_FC02_CASCADE_FLAP2"));

    PartSurface partSurface_24 = 
      ((PartSurface) cadPart_22.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_22 = 
      ((PartCurve) cadPart_22.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_23 = 
      ((CadPart) compositePart_2.getChildParts().getPart("A_FC03_CASCADE_ENDPLATE"));

    PartSurface partSurface_25 = 
      ((PartSurface) cadPart_23.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_23 = 
      ((PartCurve) cadPart_23.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_3 = 
      ((CompositePart) compositePart_0.getChildParts().getPart("A_FC00_CASCADE_MIR"));

    CadPart cadPart_24 = 
      ((CadPart) compositePart_3.getChildParts().getPart("A_FC01_CASCADE_FLAP1_MIR"));

    PartSurface partSurface_26 = 
      ((PartSurface) cadPart_24.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_24 = 
      ((PartCurve) cadPart_24.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_25 = 
      ((CadPart) compositePart_3.getChildParts().getPart("A_FC02_CASCADE_FLAP2_MIR"));

    PartSurface partSurface_27 = 
      ((PartSurface) cadPart_25.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_25 = 
      ((PartCurve) cadPart_25.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_26 = 
      ((CadPart) compositePart_3.getChildParts().getPart("A_FC03_CASCADE_ENDPLATE_MIR"));

    PartSurface partSurface_28 = 
      ((PartSurface) cadPart_26.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_26 = 
      ((PartCurve) cadPart_26.getPartCurveManager().getPartCurve("Edges"));

    SolidModelCompositePart solidModelCompositePart_1 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("C_REARWING"));

    CompositePart compositePart_4 = 
      ((CompositePart) solidModelCompositePart_1.getChildParts().getPart("A_R000_REARWING_ASM"));

    CadPart cadPart_27 = 
      ((CadPart) compositePart_4.getChildParts().getPart("A_R001_MAINELEMENT"));

    PartSurface partSurface_29 = 
      ((PartSurface) cadPart_27.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_27 = 
      ((PartCurve) cadPart_27.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_28 = 
      ((CadPart) compositePart_4.getChildParts().getPart("A_R002_FLAP1"));

    PartSurface partSurface_30 = 
      ((PartSurface) cadPart_28.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_28 = 
      ((PartCurve) cadPart_28.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_29 = 
      ((CadPart) compositePart_4.getChildParts().getPart("A_R003_FLAP2"));

    PartSurface partSurface_31 = 
      ((PartSurface) cadPart_29.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_29 = 
      ((PartCurve) cadPart_29.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_30 = 
      ((CadPart) compositePart_4.getChildParts().getPart("A_R005_FLAP3"));

    PartSurface partSurface_32 = 
      ((PartSurface) cadPart_30.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_30 = 
      ((PartCurve) cadPart_30.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_31 = 
      ((CadPart) compositePart_4.getChildParts().getPart("A_R006_FLAP4"));

    PartSurface partSurface_33 = 
      ((PartSurface) cadPart_31.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_31 = 
      ((PartCurve) cadPart_31.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_32 = 
      ((CadPart) compositePart_4.getChildParts().getPart("A_R008_ENDPLATE"));

    PartSurface partSurface_34 = 
      ((PartSurface) cadPart_32.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_32 = 
      ((PartCurve) cadPart_32.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_33 = 
      ((CadPart) compositePart_4.getChildParts().getPart("A_R008_ENDPLATE_MIR"));

    PartSurface partSurface_35 = 
      ((PartSurface) cadPart_33.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_33 = 
      ((PartCurve) cadPart_33.getPartCurveManager().getPartCurve("Edges"));

    SolidModelCompositePart solidModelCompositePart_2 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("C_UNDERTRAY"));

    CompositePart compositePart_6 = 
      ((CompositePart) solidModelCompositePart_2.getChildParts().getPart("A_U000_UNDERTRAY_ASM"));

    CompositePart compositePart_5 = 
      ((CompositePart) compositePart_6.getChildParts().getPart("A_U001_UNDERTRAY"));

    CadPart cadPart_34 = 
      ((CadPart) compositePart_5.getChildParts().getPart("A_U001_UNDERTRAY_Body 4"));

    PartSurface partSurface_36 = 
      ((PartSurface) cadPart_34.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_34 = 
      ((PartCurve) cadPart_34.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_35 = 
      ((CadPart) compositePart_5.getChildParts().getPart("A_U001_UNDERTRAY_MIR_Body"));

    PartSurface partSurface_37 = 
      ((PartSurface) cadPart_35.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_35 = 
      ((PartCurve) cadPart_35.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_7 = 
      ((CompositePart) compositePart_6.getChildParts().getPart("A_U001_UNDERTRAY_MIR"));

    CadPart cadPart_36 = 
      ((CadPart) compositePart_7.getChildParts().getPart("A_U001_UNDERTRAY_Body 4"));

    PartSurface partSurface_38 = 
      ((PartSurface) cadPart_36.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_36 = 
      ((PartCurve) cadPart_36.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_37 = 
      ((CadPart) compositePart_7.getChildParts().getPart("A_U001_UNDERTRAY_MIR_Body"));

    PartSurface partSurface_39 = 
      ((PartSurface) cadPart_37.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_37 = 
      ((PartCurve) cadPart_37.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_38 = 
      ((CadPart) compositePart_6.getChildParts().getPart("A_U002_UNDERTRAY_ENDPLATE"));

    PartSurface partSurface_40 = 
      ((PartSurface) cadPart_38.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_38 = 
      ((PartCurve) cadPart_38.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_39 = 
      ((CadPart) compositePart_6.getChildParts().getPart("A_U002_UNDERTRAY_ENDPLATE_MIR"));

    PartSurface partSurface_41 = 
      ((PartSurface) cadPart_39.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_39 = 
      ((PartCurve) cadPart_39.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_8 = 
      ((CompositePart) compositePart_6.getChildParts().getPart("A_UB00_BEAMWING"));

    CadPart cadPart_40 = 
      ((CadPart) compositePart_8.getChildParts().getPart("A_UB01_BEAMWING1"));

    PartSurface partSurface_42 = 
      ((PartSurface) cadPart_40.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_40 = 
      ((PartCurve) cadPart_40.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_41 = 
      ((CadPart) compositePart_8.getChildParts().getPart("A_UB02_BEAMWING2"));

    PartSurface partSurface_43 = 
      ((PartSurface) cadPart_41.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_41 = 
      ((PartCurve) cadPart_41.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_9 = 
      ((CompositePart) compositePart_8.getChildParts().getPart("A_UB03_ENDPLATE_OUTSIDE"));

    CadPart cadPart_42 = 
      ((CadPart) compositePart_9.getChildParts().getPart("A_UB03_ENDPLATE_OUTSIDE_Body"));

    PartSurface partSurface_44 = 
      ((PartSurface) cadPart_42.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_42 = 
      ((PartCurve) cadPart_42.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_43 = 
      ((CadPart) compositePart_9.getChildParts().getPart("A_UB03_ENDPLATE_OUTSIDE_Body 2"));

    PartSurface partSurface_45 = 
      ((PartSurface) cadPart_43.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_43 = 
      ((PartCurve) cadPart_43.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_10 = 
      ((CompositePart) compositePart_8.getChildParts().getPart("A_UB06_SIDETUNNEL_FLAP"));

    CadPart cadPart_44 = 
      ((CadPart) compositePart_10.getChildParts().getPart("A_UB06_SIDETUNNEL_FLAP_Body"));

    PartSurface partSurface_46 = 
      ((PartSurface) cadPart_44.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_44 = 
      ((PartCurve) cadPart_44.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_45 = 
      ((CadPart) compositePart_10.getChildParts().getPart("A_UB06_SIDETUNNEL_FLAP_Body 2"));

    PartSurface partSurface_47 = 
      ((PartSurface) cadPart_45.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_45 = 
      ((PartCurve) cadPart_45.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_11 = 
      ((CompositePart) compositePart_6.getChildParts().getPart("A_UB00_BEAMWING_MIR"));

    CadPart cadPart_46 = 
      ((CadPart) compositePart_11.getChildParts().getPart("A_UB01_BEAMWING1"));

    PartSurface partSurface_48 = 
      ((PartSurface) cadPart_46.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_46 = 
      ((PartCurve) cadPart_46.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_47 = 
      ((CadPart) compositePart_11.getChildParts().getPart("A_UB02_BEAMWING2"));

    PartSurface partSurface_49 = 
      ((PartSurface) cadPart_47.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_47 = 
      ((PartCurve) cadPart_47.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_12 = 
      ((CompositePart) compositePart_11.getChildParts().getPart("A_UB03_ENDPLATE_OUTSIDE"));

    CadPart cadPart_48 = 
      ((CadPart) compositePart_12.getChildParts().getPart("A_UB03_ENDPLATE_OUTSIDE_Body"));

    PartSurface partSurface_50 = 
      ((PartSurface) cadPart_48.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_48 = 
      ((PartCurve) cadPart_48.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_49 = 
      ((CadPart) compositePart_12.getChildParts().getPart("A_UB03_ENDPLATE_OUTSIDE_Body 2"));

    PartSurface partSurface_51 = 
      ((PartSurface) cadPart_49.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_49 = 
      ((PartCurve) cadPart_49.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_13 = 
      ((CompositePart) compositePart_11.getChildParts().getPart("A_UB06_SIDETUNNEL_FLAP"));

    CadPart cadPart_50 = 
      ((CadPart) compositePart_13.getChildParts().getPart("A_UB06_SIDETUNNEL_FLAP_Body"));

    PartSurface partSurface_52 = 
      ((PartSurface) cadPart_50.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_50 = 
      ((PartCurve) cadPart_50.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_51 = 
      ((CadPart) compositePart_13.getChildParts().getPart("A_UB06_SIDETUNNEL_FLAP_Body 2"));

    PartSurface partSurface_53 = 
      ((PartSurface) cadPart_51.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_51 = 
      ((PartCurve) cadPart_51.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_14 = 
      ((CompositePart) compositePart_6.getChildParts().getPart("A_UF00_FENCES"));

    CadPart cadPart_52 = 
      ((CadPart) compositePart_14.getChildParts().getPart("A_UF01_FENCE1_MIR"));

    PartSurface partSurface_54 = 
      ((PartSurface) cadPart_52.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_52 = 
      ((PartCurve) cadPart_52.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_15 = 
      ((CompositePart) compositePart_14.getChildParts().getPart("A_UF02_FENCE2_MIR"));

    CadPart cadPart_53 = 
      ((CadPart) compositePart_15.getChildParts().getPart("A_UF02_FENCE2_MIR_Body"));

    PartSurface partSurface_55 = 
      ((PartSurface) cadPart_53.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_53 = 
      ((PartCurve) cadPart_53.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_16 = 
      ((CompositePart) compositePart_6.getChildParts().getPart("A_UF00_FENCES_MIR"));

    CadPart cadPart_54 = 
      ((CadPart) compositePart_16.getChildParts().getPart("A_UF01_FENCE1_MIR"));

    PartSurface partSurface_56 = 
      ((PartSurface) cadPart_54.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_54 = 
      ((PartCurve) cadPart_54.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_17 = 
      ((CompositePart) compositePart_16.getChildParts().getPart("A_UF02_FENCE2_MIR"));

    CadPart cadPart_55 = 
      ((CadPart) compositePart_17.getChildParts().getPart("A_UF02_FENCE2_MIR_Body"));

    PartSurface partSurface_57 = 
      ((PartSurface) cadPart_55.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_55 = 
      ((PartCurve) cadPart_55.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_18 = 
      ((CompositePart) compositePart_6.getChildParts().getPart("A_US00_SIDEPOD"));

    CadPart cadPart_56 = 
      ((CadPart) compositePart_18.getChildParts().getPart("A_US01_TOPPLATE"));

    PartSurface partSurface_58 = 
      ((PartSurface) cadPart_56.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_56 = 
      ((PartCurve) cadPart_56.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_57 = 
      ((CadPart) compositePart_18.getChildParts().getPart("A_US02_SIDEWALL"));

    PartSurface partSurface_59 = 
      ((PartSurface) cadPart_57.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_57 = 
      ((PartCurve) cadPart_57.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_58 = 
      ((CadPart) compositePart_18.getChildParts().getPart("A_US03_MONOWALL"));

    PartSurface partSurface_60 = 
      ((PartSurface) cadPart_58.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_58 = 
      ((PartCurve) cadPart_58.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_19 = 
      ((CompositePart) compositePart_18.getChildParts().getPart("A_USD0_DUCT"));

    CadPart cadPart_59 = 
      ((CadPart) compositePart_19.getChildParts().getPart("A_USD1_NACA_DUCT"));

    PartSurface partSurface_61 = 
      ((PartSurface) cadPart_59.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_59 = 
      ((PartCurve) cadPart_59.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_60 = 
      ((CadPart) compositePart_19.getChildParts().getPart("A_USD2_DUCT"));

    PartSurface partSurface_62 = 
      ((PartSurface) cadPart_60.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_60 = 
      ((PartCurve) cadPart_60.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_61 = 
      ((CadPart) compositePart_19.getChildParts().getPart("A_USD3_CARBON_DUCT"));

    PartSurface partSurface_63 = 
      ((PartSurface) cadPart_61.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_61 = 
      ((PartCurve) cadPart_61.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_20 = 
      ((CompositePart) compositePart_6.getChildParts().getPart("A_US00_SIDEPOD_MIR"));

    CadPart cadPart_62 = 
      ((CadPart) compositePart_20.getChildParts().getPart("A_US01_TOPPLATE_MIR"));

    PartSurface partSurface_64 = 
      ((PartSurface) cadPart_62.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_62 = 
      ((PartCurve) cadPart_62.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_63 = 
      ((CadPart) compositePart_20.getChildParts().getPart("A_US02_SIDEWALL_MIR"));

    PartSurface partSurface_65 = 
      ((PartSurface) cadPart_63.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_63 = 
      ((PartCurve) cadPart_63.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_64 = 
      ((CadPart) compositePart_20.getChildParts().getPart("A_US03_MONOWALL_MIR"));

    PartSurface partSurface_66 = 
      ((PartSurface) cadPart_64.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_64 = 
      ((PartCurve) cadPart_64.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_21 = 
      ((CompositePart) compositePart_20.getChildParts().getPart("A_USD0_DUCT_MIR"));

    CadPart cadPart_65 = 
      ((CadPart) compositePart_21.getChildParts().getPart("A_USD1_NACA_DUCT_MIR"));

    PartSurface partSurface_67 = 
      ((PartSurface) cadPart_65.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_65 = 
      ((PartCurve) cadPart_65.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_66 = 
      ((CadPart) compositePart_21.getChildParts().getPart("A_USD2_DUCT_MIR"));

    PartSurface partSurface_68 = 
      ((PartSurface) cadPart_66.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_66 = 
      ((PartCurve) cadPart_66.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_67 = 
      ((CadPart) compositePart_21.getChildParts().getPart("A_USD3_CARBON_DUCT_MIR"));

    PartSurface partSurface_69 = 
      ((PartSurface) cadPart_67.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_67 = 
      ((PartCurve) cadPart_67.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_22 = 
      ((CompositePart) compositePart_6.getChildParts().getPart("A_US00_SIDEWINGS"));

    CadPart cadPart_68 = 
      ((CadPart) compositePart_22.getChildParts().getPart("A_US01_SIDEWING1"));

    PartSurface partSurface_70 = 
      ((PartSurface) cadPart_68.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_68 = 
      ((PartCurve) cadPart_68.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_69 = 
      ((CadPart) compositePart_22.getChildParts().getPart("A_US03_SIDEWING_ENDPLATE"));

    PartSurface partSurface_71 = 
      ((PartSurface) cadPart_69.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_69 = 
      ((PartCurve) cadPart_69.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_23 = 
      ((CompositePart) compositePart_6.getChildParts().getPart("A_US00_SIDEWINGS_MIR"));

    CadPart cadPart_70 = 
      ((CadPart) compositePart_23.getChildParts().getPart("A_US01_SIDEWING1_MIR"));

    PartSurface partSurface_72 = 
      ((PartSurface) cadPart_70.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_70 = 
      ((PartCurve) cadPart_70.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_71 = 
      ((CadPart) compositePart_23.getChildParts().getPart("A_US03_SIDEWING_ENDPLATE_MIR"));

    PartSurface partSurface_73 = 
      ((PartSurface) cadPart_71.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_71 = 
      ((PartCurve) cadPart_71.getPartCurveManager().getPartCurve("Edges"));

    partDisplayer_5.getInputParts().setObjects(partSurface_1, partCurve_0, partSurface_2, partCurve_1, partSurface_3, partCurve_2, partSurface_4, partCurve_3, partSurface_5, partCurve_4, partSurface_6, partCurve_5, partSurface_7, partCurve_6, partSurface_8, partSurface_9, partCurve_7, partSurface_10, partCurve_8, partSurface_11, partCurve_9, partSurface_12, partCurve_10, partSurface_13, partCurve_11, partSurface_14, partCurve_12, partSurface_15, partCurve_13, partSurface_16, partCurve_14, partSurface_17, partCurve_15, partSurface_18, partCurve_16, partSurface_19, partCurve_17, partSurface_20, partCurve_18, partSurface_21, partCurve_19, partSurface_22, partCurve_20, partSurface_23, partCurve_21, partSurface_24, partCurve_22, partSurface_25, partCurve_23, partSurface_26, partCurve_24, partSurface_27, partCurve_25, partSurface_28, partCurve_26, partSurface_29, partCurve_27, partSurface_30, partCurve_28, partSurface_31, partCurve_29, partSurface_32, partCurve_30, partSurface_33, partCurve_31, partSurface_34, partCurve_32, partSurface_35, partCurve_33, partSurface_36, partCurve_34, partSurface_37, partCurve_35, partSurface_38, partCurve_36, partSurface_39, partCurve_37, partSurface_40, partCurve_38, partSurface_41, partCurve_39, partSurface_42, partCurve_40, partSurface_43, partCurve_41, partSurface_44, partCurve_42, partSurface_45, partCurve_43, partSurface_46, partCurve_44, partSurface_47, partCurve_45, partSurface_48, partCurve_46, partSurface_49, partCurve_47, partSurface_50, partCurve_48, partSurface_51, partCurve_49, partSurface_52, partCurve_50, partSurface_53, partCurve_51, partSurface_54, partCurve_52, partSurface_55, partCurve_53, partSurface_56, partCurve_54, partSurface_57, partCurve_55, partSurface_58, partCurve_56, partSurface_59, partCurve_57, partSurface_60, partCurve_58, partSurface_61, partCurve_59, partSurface_62, partCurve_60, partSurface_63, partCurve_61, partSurface_64, partCurve_62, partSurface_65, partCurve_63, partSurface_66, partCurve_64, partSurface_67, partCurve_65, partSurface_68, partCurve_66, partSurface_69, partCurve_67, partSurface_70, partCurve_68, partSurface_71, partCurve_69, partSurface_72, partCurve_70, partSurface_73, partCurve_71);
  }

  private void execute1() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Scene scene_1 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 2");

    PartDisplayer partDisplayer_5 = 
      ((PartDisplayer) scene_1.getDisplayerManager().getObject("aero"));

    PresetColorSettings presetColorSettings_3 = 
      partDisplayer_5.getPresetColorSettings();

    RayTraceSimpleMetalMaterial rayTraceSimpleMetalMaterial_1 = 
      ((RayTraceSimpleMetalMaterial) simulation_0.get(RayTraceMaterialManager.class).getObject("Metallic Dark Gray"));

    presetColorSettings_3.setRayTraceMaterial(rayTraceSimpleMetalMaterial_1);

    PartDisplayer partDisplayer_6 = 
      scene_1.getDisplayerManager().createPartDisplayer("Surface", -1, 1);

    partDisplayer_6.setPresentationName("mainhoop");

    partDisplayer_6.setColorMode(PartColorMode.PRESET);

    PartRepresentation partRepresentation_0 = 
      ((PartRepresentation) simulation_0.getRepresentationManager().getObject("Geometry"));

    partDisplayer_6.setRepresentation(partRepresentation_0);

    partDisplayer_6.getInputParts().setQuery(null);

    SolidModelCompositePart solidModelCompositePart_0 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("C_FRONTWING"));

    CompositePart compositePart_0 = 
      ((CompositePart) solidModelCompositePart_0.getChildParts().getPart("A_F000_FRONTWING_ASM"));

    CompositePart compositePart_27 = 
      ((CompositePart) compositePart_0.getChildParts().getPart("A_FA00_FRONTWING_ATTACHMENT"));

    CompositePart compositePart_26 = 
      ((CompositePart) compositePart_27.getChildParts().getPart("A_FA02_ATTACHMENT_B_"));

    CompositePart compositePart_25 = 
      ((CompositePart) compositePart_26.getChildParts().getPart("A_FA02_MAIN_ATTACHMENT"));

    CompositePart compositePart_24 = 
      ((CompositePart) compositePart_25.getChildParts().getPart("A_FA02_MAIN_ATTACHMENT_1"));

    CadPart cadPart_72 = 
      ((CadPart) compositePart_24.getChildParts().getPart("A_FA02_MAIN_ATTACHMENT_1_1"));

    PartSurface partSurface_74 = 
      ((PartSurface) cadPart_72.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_72 = 
      ((PartCurve) cadPart_72.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_73 = 
      ((CadPart) compositePart_24.getChildParts().getPart("A_FA02_MAIN_ATTACHMENT_1_2"));

    PartSurface partSurface_75 = 
      ((PartSurface) cadPart_73.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_73 = 
      ((PartCurve) cadPart_73.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_74 = 
      ((CadPart) compositePart_26.getChildParts().getPart("DIN7985TX_M6X25"));

    PartSurface partSurface_76 = 
      ((PartSurface) cadPart_74.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_74 = 
      ((PartCurve) cadPart_74.getPartCurveManager().getPartCurve("Edges"));

    SolidModelCompositePart solidModelCompositePart_3 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("C_MONOCOQUE"));

    CompositePart compositePart_28 = 
      ((CompositePart) solidModelCompositePart_3.getChildParts().getPart("C_MH00_MAINHOOP_ASM"));

    CadPart cadPart_75 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body"));

    PartSurface partSurface_77 = 
      ((PartSurface) cadPart_75.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_75 = 
      ((PartCurve) cadPart_75.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_76 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 2"));

    PartSurface partSurface_78 = 
      ((PartSurface) cadPart_76.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_76 = 
      ((PartCurve) cadPart_76.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_77 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 3"));

    PartSurface partSurface_79 = 
      ((PartSurface) cadPart_77.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_77 = 
      ((PartCurve) cadPart_77.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_78 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 4"));

    PartSurface partSurface_80 = 
      ((PartSurface) cadPart_78.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_78 = 
      ((PartCurve) cadPart_78.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_79 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 5"));

    PartSurface partSurface_81 = 
      ((PartSurface) cadPart_79.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_79 = 
      ((PartCurve) cadPart_79.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_80 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 6"));

    PartSurface partSurface_82 = 
      ((PartSurface) cadPart_80.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_80 = 
      ((PartCurve) cadPart_80.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_81 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 7"));

    PartSurface partSurface_83 = 
      ((PartSurface) cadPart_81.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_81 = 
      ((PartCurve) cadPart_81.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_82 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 8"));

    PartSurface partSurface_84 = 
      ((PartSurface) cadPart_82.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_82 = 
      ((PartCurve) cadPart_82.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_83 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 9"));

    PartSurface partSurface_85 = 
      ((PartSurface) cadPart_83.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_83 = 
      ((PartCurve) cadPart_83.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_84 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 10"));

    PartSurface partSurface_86 = 
      ((PartSurface) cadPart_84.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_84 = 
      ((PartCurve) cadPart_84.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_85 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 11"));

    PartSurface partSurface_87 = 
      ((PartSurface) cadPart_85.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_85 = 
      ((PartCurve) cadPart_85.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_86 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 12"));

    PartSurface partSurface_88 = 
      ((PartSurface) cadPart_86.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_86 = 
      ((PartCurve) cadPart_86.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_87 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 13"));

    PartSurface partSurface_89 = 
      ((PartSurface) cadPart_87.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_87 = 
      ((PartCurve) cadPart_87.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_88 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 14"));

    PartSurface partSurface_90 = 
      ((PartSurface) cadPart_88.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_88 = 
      ((PartCurve) cadPart_88.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_89 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 15"));

    PartSurface partSurface_91 = 
      ((PartSurface) cadPart_89.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_89 = 
      ((PartCurve) cadPart_89.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_90 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 16"));

    PartSurface partSurface_92 = 
      ((PartSurface) cadPart_90.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_90 = 
      ((PartCurve) cadPart_90.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_91 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 17"));

    PartSurface partSurface_93 = 
      ((PartSurface) cadPart_91.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_91 = 
      ((PartCurve) cadPart_91.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_92 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 22"));

    PartSurface partSurface_94 = 
      ((PartSurface) cadPart_92.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_92 = 
      ((PartCurve) cadPart_92.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_93 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 23"));

    PartSurface partSurface_95 = 
      ((PartSurface) cadPart_93.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_93 = 
      ((PartCurve) cadPart_93.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_94 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 24"));

    PartSurface partSurface_96 = 
      ((PartSurface) cadPart_94.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_94 = 
      ((PartCurve) cadPart_94.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_95 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 25"));

    PartSurface partSurface_97 = 
      ((PartSurface) cadPart_95.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_95 = 
      ((PartCurve) cadPart_95.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_96 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 26"));

    PartSurface partSurface_98 = 
      ((PartSurface) cadPart_96.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_96 = 
      ((PartCurve) cadPart_96.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_97 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 27"));

    PartSurface partSurface_99 = 
      ((PartSurface) cadPart_97.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_97 = 
      ((PartCurve) cadPart_97.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_98 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 28"));

    PartSurface partSurface_100 = 
      ((PartSurface) cadPart_98.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_98 = 
      ((PartCurve) cadPart_98.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_99 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 29"));

    PartSurface partSurface_101 = 
      ((PartSurface) cadPart_99.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_99 = 
      ((PartCurve) cadPart_99.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_100 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 30"));

    PartSurface partSurface_102 = 
      ((PartSurface) cadPart_100.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_100 = 
      ((PartCurve) cadPart_100.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_101 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 33"));

    PartSurface partSurface_103 = 
      ((PartSurface) cadPart_101.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_101 = 
      ((PartCurve) cadPart_101.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_102 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 34"));

    PartSurface partSurface_104 = 
      ((PartSurface) cadPart_102.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_102 = 
      ((PartCurve) cadPart_102.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_103 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 35"));

    PartSurface partSurface_105 = 
      ((PartSurface) cadPart_103.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_103 = 
      ((PartCurve) cadPart_103.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_104 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 36"));

    PartSurface partSurface_106 = 
      ((PartSurface) cadPart_104.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_104 = 
      ((PartCurve) cadPart_104.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_105 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 37"));

    PartSurface partSurface_107 = 
      ((PartSurface) cadPart_105.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_105 = 
      ((PartCurve) cadPart_105.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_106 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 38"));

    PartSurface partSurface_108 = 
      ((PartSurface) cadPart_106.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_106 = 
      ((PartCurve) cadPart_106.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_107 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 39"));

    PartSurface partSurface_109 = 
      ((PartSurface) cadPart_107.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_107 = 
      ((PartCurve) cadPart_107.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_108 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 40"));

    PartSurface partSurface_110 = 
      ((PartSurface) cadPart_108.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_108 = 
      ((PartCurve) cadPart_108.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_109 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 41"));

    PartSurface partSurface_111 = 
      ((PartSurface) cadPart_109.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_109 = 
      ((PartCurve) cadPart_109.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_110 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 42"));

    PartSurface partSurface_112 = 
      ((PartSurface) cadPart_110.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_110 = 
      ((PartCurve) cadPart_110.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_111 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 43"));

    PartSurface partSurface_113 = 
      ((PartSurface) cadPart_111.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_111 = 
      ((PartCurve) cadPart_111.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_112 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 44"));

    PartSurface partSurface_114 = 
      ((PartSurface) cadPart_112.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_112 = 
      ((PartCurve) cadPart_112.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_113 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 48"));

    PartSurface partSurface_115 = 
      ((PartSurface) cadPart_113.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_113 = 
      ((PartCurve) cadPart_113.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_114 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 49"));

    PartSurface partSurface_116 = 
      ((PartSurface) cadPart_114.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_114 = 
      ((PartCurve) cadPart_114.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_115 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 51"));

    PartSurface partSurface_117 = 
      ((PartSurface) cadPart_115.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_115 = 
      ((PartCurve) cadPart_115.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_116 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 52"));

    PartSurface partSurface_118 = 
      ((PartSurface) cadPart_116.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_116 = 
      ((PartCurve) cadPart_116.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_117 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 53"));

    PartSurface partSurface_119 = 
      ((PartSurface) cadPart_117.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_117 = 
      ((PartCurve) cadPart_117.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_118 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 54"));

    PartSurface partSurface_120 = 
      ((PartSurface) cadPart_118.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_118 = 
      ((PartCurve) cadPart_118.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_119 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 55"));

    PartSurface partSurface_121 = 
      ((PartSurface) cadPart_119.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_119 = 
      ((PartCurve) cadPart_119.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_120 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 56"));

    PartSurface partSurface_122 = 
      ((PartSurface) cadPart_120.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_120 = 
      ((PartCurve) cadPart_120.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_121 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 57"));

    PartSurface partSurface_123 = 
      ((PartSurface) cadPart_121.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_121 = 
      ((PartCurve) cadPart_121.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_122 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 58"));

    PartSurface partSurface_124 = 
      ((PartSurface) cadPart_122.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_122 = 
      ((PartCurve) cadPart_122.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_123 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 59"));

    PartSurface partSurface_125 = 
      ((PartSurface) cadPart_123.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_123 = 
      ((PartCurve) cadPart_123.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_124 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 60"));

    PartSurface partSurface_126 = 
      ((PartSurface) cadPart_124.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_124 = 
      ((PartCurve) cadPart_124.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_125 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 61"));

    PartSurface partSurface_127 = 
      ((PartSurface) cadPart_125.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_125 = 
      ((PartCurve) cadPart_125.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_126 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 62"));

    PartSurface partSurface_128 = 
      ((PartSurface) cadPart_126.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_126 = 
      ((PartCurve) cadPart_126.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_127 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 63"));

    PartSurface partSurface_129 = 
      ((PartSurface) cadPart_127.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_127 = 
      ((PartCurve) cadPart_127.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_128 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 64"));

    PartSurface partSurface_130 = 
      ((PartSurface) cadPart_128.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_128 = 
      ((PartCurve) cadPart_128.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_129 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 65"));

    PartSurface partSurface_131 = 
      ((PartSurface) cadPart_129.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_129 = 
      ((PartCurve) cadPart_129.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_130 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 70"));

    PartSurface partSurface_132 = 
      ((PartSurface) cadPart_130.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_130 = 
      ((PartCurve) cadPart_130.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_131 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 71"));

    PartSurface partSurface_133 = 
      ((PartSurface) cadPart_131.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_131 = 
      ((PartCurve) cadPart_131.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_132 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 72"));

    PartSurface partSurface_134 = 
      ((PartSurface) cadPart_132.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_132 = 
      ((PartCurve) cadPart_132.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_133 = 
      ((CadPart) compositePart_28.getChildParts().getPart("C_MH00_MAINHOOP_ASM_Body 73"));

    PartSurface partSurface_135 = 
      ((PartSurface) cadPart_133.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_133 = 
      ((PartCurve) cadPart_133.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_134 = 
      ((CadPart) compositePart_28.getChildParts().getPart("TRM_SRF"));

    PartSurface partSurface_136 = 
      ((PartSurface) cadPart_134.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_134 = 
      ((PartCurve) cadPart_134.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_135 = 
      ((CadPart) compositePart_28.getChildParts().getPart("TRM_SRF 2"));

    PartSurface partSurface_137 = 
      ((PartSurface) cadPart_135.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_135 = 
      ((PartCurve) cadPart_135.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_136 = 
      ((CadPart) compositePart_28.getChildParts().getPart("TRM_SRF 3"));

    PartSurface partSurface_138 = 
      ((PartSurface) cadPart_136.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_136 = 
      ((PartCurve) cadPart_136.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_137 = 
      ((CadPart) compositePart_28.getChildParts().getPart("TRM_SRF 4"));

    PartSurface partSurface_139 = 
      ((PartSurface) cadPart_137.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_137 = 
      ((PartCurve) cadPart_137.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_138 = 
      ((CadPart) compositePart_28.getChildParts().getPart("TRM_SRF 5"));

    PartSurface partSurface_140 = 
      ((PartSurface) cadPart_138.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_138 = 
      ((PartCurve) cadPart_138.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_139 = 
      ((CadPart) compositePart_28.getChildParts().getPart("TRM_SRF 6"));

    PartSurface partSurface_141 = 
      ((PartSurface) cadPart_139.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_139 = 
      ((PartCurve) cadPart_139.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_140 = 
      ((CadPart) compositePart_28.getChildParts().getPart("TRM_SRF 8"));

    PartSurface partSurface_142 = 
      ((PartSurface) cadPart_140.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_140 = 
      ((PartCurve) cadPart_140.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_141 = 
      ((CadPart) compositePart_28.getChildParts().getPart("TRM_SRF 9"));

    PartSurface partSurface_143 = 
      ((PartSurface) cadPart_141.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_141 = 
      ((PartCurve) cadPart_141.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_142 = 
      ((CadPart) compositePart_28.getChildParts().getPart("TRM_SRF 10"));

    PartSurface partSurface_144 = 
      ((PartSurface) cadPart_142.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_142 = 
      ((PartCurve) cadPart_142.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_143 = 
      ((CadPart) compositePart_28.getChildParts().getPart("TRM_SRF 11"));

    PartSurface partSurface_145 = 
      ((PartSurface) cadPart_143.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_143 = 
      ((PartCurve) cadPart_143.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_144 = 
      ((CadPart) compositePart_28.getChildParts().getPart("TRM_SRF 12"));

    PartSurface partSurface_146 = 
      ((PartSurface) cadPart_144.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_144 = 
      ((PartCurve) cadPart_144.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_145 = 
      ((CadPart) compositePart_28.getChildParts().getPart("TRM_SRF 13"));

    PartSurface partSurface_147 = 
      ((PartSurface) cadPart_145.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_145 = 
      ((PartCurve) cadPart_145.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_146 = 
      ((CadPart) compositePart_28.getChildParts().getPart("TRM_SRF 14"));

    PartSurface partSurface_148 = 
      ((PartSurface) cadPart_146.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_146 = 
      ((PartCurve) cadPart_146.getPartCurveManager().getPartCurve("Edges"));

    partDisplayer_6.getInputParts().setObjects(partSurface_74, partCurve_72, partSurface_75, partCurve_73, partSurface_76, partCurve_74, partSurface_77, partCurve_75, partSurface_78, partCurve_76, partSurface_79, partCurve_77, partSurface_80, partCurve_78, partSurface_81, partCurve_79, partSurface_82, partCurve_80, partSurface_83, partCurve_81, partSurface_84, partCurve_82, partSurface_85, partCurve_83, partSurface_86, partCurve_84, partSurface_87, partCurve_85, partSurface_88, partCurve_86, partSurface_89, partCurve_87, partSurface_90, partCurve_88, partSurface_91, partCurve_89, partSurface_92, partCurve_90, partSurface_93, partCurve_91, partSurface_94, partCurve_92, partSurface_95, partCurve_93, partSurface_96, partCurve_94, partSurface_97, partCurve_95, partSurface_98, partCurve_96, partSurface_99, partCurve_97, partSurface_100, partCurve_98, partSurface_101, partCurve_99, partSurface_102, partCurve_100, partSurface_103, partCurve_101, partSurface_104, partCurve_102, partSurface_105, partCurve_103, partSurface_106, partCurve_104, partSurface_107, partCurve_105, partSurface_108, partCurve_106, partSurface_109, partCurve_107, partSurface_110, partCurve_108, partSurface_111, partCurve_109, partSurface_112, partCurve_110, partSurface_113, partCurve_111, partSurface_114, partCurve_112, partSurface_115, partCurve_113, partSurface_116, partCurve_114, partSurface_117, partCurve_115, partSurface_118, partCurve_116, partSurface_119, partCurve_117, partSurface_120, partCurve_118, partSurface_121, partCurve_119, partSurface_122, partCurve_120, partSurface_123, partCurve_121, partSurface_124, partCurve_122, partSurface_125, partCurve_123, partSurface_126, partCurve_124, partSurface_127, partCurve_125, partSurface_128, partCurve_126, partSurface_129, partCurve_127, partSurface_130, partCurve_128, partSurface_131, partCurve_129, partSurface_132, partCurve_130, partSurface_133, partCurve_131, partSurface_134, partCurve_132, partSurface_135, partCurve_133, partSurface_136, partCurve_134, partSurface_137, partCurve_135, partSurface_138, partCurve_136, partSurface_139, partCurve_137, partSurface_140, partCurve_138, partSurface_141, partCurve_139, partSurface_142, partCurve_140, partSurface_143, partCurve_141, partSurface_144, partCurve_142, partSurface_145, partCurve_143, partSurface_146, partCurve_144, partSurface_147, partCurve_145, partSurface_148, partCurve_146);

    PresetColorSettings presetColorSettings_4 = 
      partDisplayer_6.getPresetColorSettings();

    RayTraceSimpleMetalMaterial rayTraceSimpleMetalMaterial_2 = 
      ((RayTraceSimpleMetalMaterial) simulation_0.get(RayTraceMaterialManager.class).getObject("Metallic Red"));

    presetColorSettings_4.setRayTraceMaterial(rayTraceSimpleMetalMaterial_2);

    CurrentView currentView_0 = 
      scene_1.getCurrentView();

    currentView_0.setInput(new DoubleVector(new double[] {1.1734222671075958, 0.5042406264569448, 0.6289891824736226}), new DoubleVector(new double[] {2.942850902145052, 4.4202134081264335, 2.0160614115521773}), new DoubleVector(new double[] {-0.12616804837781387, -0.2800743602728594, 0.9516511841459098}), 1.5102818616783267, 0, 30.0);
  }

  private void execute2() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Scene scene_1 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 2");

    PartDisplayer partDisplayer_7 = 
      scene_1.getDisplayerManager().createPartDisplayer("Surface", -1, 1);

    partDisplayer_7.setPresentationName("rods");

    partDisplayer_7.getInputParts().setQuery(null);

    SolidModelCompositePart solidModelCompositePart_0 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("C_FRONTWING"));

    CompositePart compositePart_0 = 
      ((CompositePart) solidModelCompositePart_0.getChildParts().getPart("A_F000_FRONTWING_ASM"));

    CompositePart compositePart_27 = 
      ((CompositePart) compositePart_0.getChildParts().getPart("A_FA00_FRONTWING_ATTACHMENT"));

    CompositePart compositePart_30 = 
      ((CompositePart) compositePart_27.getChildParts().getPart("A_FA01_ATTACHMENT_A"));

    CompositePart compositePart_29 = 
      ((CompositePart) compositePart_30.getChildParts().getPart("A_FA01_INSERT_BOTTOM"));

    CadPart cadPart_147 = 
      ((CadPart) compositePart_29.getChildParts().getPart("A_FA01_INSERT_BOTTOM_Body"));

    PartSurface partSurface_149 = 
      ((PartSurface) cadPart_147.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_147 = 
      ((PartCurve) cadPart_147.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_31 = 
      ((CompositePart) compositePart_30.getChildParts().getPart("A_FA01_INSERT_TOP"));

    CadPart cadPart_148 = 
      ((CadPart) compositePart_31.getChildParts().getPart("A_FA01_INSERT_TOP_Body"));

    PartSurface partSurface_150 = 
      ((PartSurface) cadPart_148.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_148 = 
      ((PartCurve) cadPart_148.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_149 = 
      ((CadPart) compositePart_30.getChildParts().getPart("A_FA01_MONO_BRACKET"));

    PartSurface partSurface_151 = 
      ((PartSurface) cadPart_149.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_149 = 
      ((PartCurve) cadPart_149.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_150 = 
      ((CadPart) compositePart_30.getChildParts().getPart("A_FA01_ROD"));

    PartSurface partSurface_152 = 
      ((PartSurface) cadPart_150.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_150 = 
      ((PartCurve) cadPart_150.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_151 = 
      ((CadPart) compositePart_30.getChildParts().getPart("A_FA01_WING_BRACKET"));

    PartSurface partSurface_153 = 
      ((PartSurface) cadPart_151.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_151 = 
      ((PartCurve) cadPart_151.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_152 = 
      ((CadPart) compositePart_30.getChildParts().getPart("A_FA01_WING_BRACKET_B"));

    PartSurface partSurface_154 = 
      ((PartSurface) cadPart_152.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_152 = 
      ((PartCurve) cadPart_152.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_32 = 
      ((CompositePart) compositePart_30.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5"));

    CadPart cadPart_153 = 
      ((CadPart) compositePart_32.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_155 = 
      ((PartSurface) cadPart_153.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_156 = 
      ((PartSurface) cadPart_153.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_153 = 
      ((PartCurve) cadPart_153.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_33 = 
      ((CompositePart) compositePart_30.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5 2"));

    CadPart cadPart_154 = 
      ((CadPart) compositePart_33.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_157 = 
      ((PartSurface) cadPart_154.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_158 = 
      ((PartSurface) cadPart_154.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_154 = 
      ((PartCurve) cadPart_154.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_155 = 
      ((CadPart) compositePart_30.getChildParts().getPart("ASKUBAL_BALL_M5"));

    PartSurface partSurface_159 = 
      ((PartSurface) cadPart_155.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_155 = 
      ((PartCurve) cadPart_155.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_156 = 
      ((CadPart) compositePart_30.getChildParts().getPart("D125B_5_3"));

    PartSurface partSurface_160 = 
      ((PartSurface) cadPart_156.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_156 = 
      ((PartCurve) cadPart_156.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_34 = 
      ((CompositePart) compositePart_30.getChildParts().getPart("D439_M5"));

    CadPart cadPart_157 = 
      ((CadPart) compositePart_34.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_161 = 
      ((PartSurface) cadPart_157.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_157 = 
      ((PartCurve) cadPart_157.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_35 = 
      ((CompositePart) compositePart_30.getChildParts().getPart("D439_M5 2"));

    CadPart cadPart_158 = 
      ((CadPart) compositePart_35.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_162 = 
      ((PartSurface) cadPart_158.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_158 = 
      ((PartCurve) cadPart_158.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_36 = 
      ((CompositePart) compositePart_30.getChildParts().getPart("DIN985_M5"));

    CadPart cadPart_159 = 
      ((CadPart) compositePart_36.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_163 = 
      ((PartSurface) cadPart_159.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_159 = 
      ((PartCurve) cadPart_159.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_37 = 
      ((CompositePart) compositePart_30.getChildParts().getPart("DIN985_M5 2"));

    CadPart cadPart_160 = 
      ((CadPart) compositePart_37.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_164 = 
      ((PartSurface) cadPart_160.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_160 = 
      ((PartCurve) cadPart_160.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_161 = 
      ((CadPart) compositePart_30.getChildParts().getPart("DIN7985TX_M4X30"));

    PartSurface partSurface_165 = 
      ((PartSurface) cadPart_161.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_161 = 
      ((PartCurve) cadPart_161.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_162 = 
      ((CadPart) compositePart_30.getChildParts().getPart("DIN7985TX_M5X20"));

    PartSurface partSurface_166 = 
      ((PartSurface) cadPart_162.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_162 = 
      ((PartCurve) cadPart_162.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_38 = 
      ((CompositePart) compositePart_27.getChildParts().getPart("A_FA01_ATTACHMENT_A_MIR"));

    CadPart cadPart_163 = 
      ((CadPart) compositePart_38.getChildParts().getPart("A_FA01_INSERT_BOTTOM_MIR"));

    PartSurface partSurface_167 = 
      ((PartSurface) cadPart_163.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_163 = 
      ((PartCurve) cadPart_163.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_39 = 
      ((CompositePart) compositePart_38.getChildParts().getPart("A_FA01_INSERT_TOP_MIR"));

    CadPart cadPart_164 = 
      ((CadPart) compositePart_39.getChildParts().getPart("A_FA01_INSERT_TOP_MIR_Body"));

    PartSurface partSurface_168 = 
      ((PartSurface) cadPart_164.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_164 = 
      ((PartCurve) cadPart_164.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_165 = 
      ((CadPart) compositePart_38.getChildParts().getPart("A_FA01_MONO_BRACKET_MIR"));

    PartSurface partSurface_169 = 
      ((PartSurface) cadPart_165.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_165 = 
      ((PartCurve) cadPart_165.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_166 = 
      ((CadPart) compositePart_38.getChildParts().getPart("A_FA01_ROD_MIR"));

    PartSurface partSurface_170 = 
      ((PartSurface) cadPart_166.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_166 = 
      ((PartCurve) cadPart_166.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_167 = 
      ((CadPart) compositePart_38.getChildParts().getPart("A_FA01_WING_BRACKET_B_MIR"));

    PartSurface partSurface_171 = 
      ((PartSurface) cadPart_167.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_167 = 
      ((PartCurve) cadPart_167.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_168 = 
      ((CadPart) compositePart_38.getChildParts().getPart("A_FA01_WING_BRACKET_MIR"));

    PartSurface partSurface_172 = 
      ((PartSurface) cadPart_168.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_168 = 
      ((PartCurve) cadPart_168.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_40 = 
      ((CompositePart) compositePart_38.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5"));

    CadPart cadPart_169 = 
      ((CadPart) compositePart_40.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_173 = 
      ((PartSurface) cadPart_169.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_174 = 
      ((PartSurface) cadPart_169.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_169 = 
      ((PartCurve) cadPart_169.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_41 = 
      ((CompositePart) compositePart_38.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5 2"));

    CadPart cadPart_170 = 
      ((CadPart) compositePart_41.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_175 = 
      ((PartSurface) cadPart_170.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_176 = 
      ((PartSurface) cadPart_170.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_170 = 
      ((PartCurve) cadPart_170.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_171 = 
      ((CadPart) compositePart_38.getChildParts().getPart("ASKUBAL_BALL_M5"));

    PartSurface partSurface_177 = 
      ((PartSurface) cadPart_171.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_171 = 
      ((PartCurve) cadPart_171.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_172 = 
      ((CadPart) compositePart_38.getChildParts().getPart("D125B_5_3"));

    PartSurface partSurface_178 = 
      ((PartSurface) cadPart_172.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_172 = 
      ((PartCurve) cadPart_172.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_42 = 
      ((CompositePart) compositePart_38.getChildParts().getPart("D439_M5"));

    CadPart cadPart_173 = 
      ((CadPart) compositePart_42.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_179 = 
      ((PartSurface) cadPart_173.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_173 = 
      ((PartCurve) cadPart_173.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_43 = 
      ((CompositePart) compositePart_38.getChildParts().getPart("D439_M5 2"));

    CadPart cadPart_174 = 
      ((CadPart) compositePart_43.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_180 = 
      ((PartSurface) cadPart_174.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_174 = 
      ((PartCurve) cadPart_174.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_44 = 
      ((CompositePart) compositePart_38.getChildParts().getPart("DIN985_M5"));

    CadPart cadPart_175 = 
      ((CadPart) compositePart_44.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_181 = 
      ((PartSurface) cadPart_175.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_175 = 
      ((PartCurve) cadPart_175.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_45 = 
      ((CompositePart) compositePart_38.getChildParts().getPart("DIN985_M5 2"));

    CadPart cadPart_176 = 
      ((CadPart) compositePart_45.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_182 = 
      ((PartSurface) cadPart_176.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_176 = 
      ((PartCurve) cadPart_176.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_177 = 
      ((CadPart) compositePart_38.getChildParts().getPart("DIN7985TX_M4X30"));

    PartSurface partSurface_183 = 
      ((PartSurface) cadPart_177.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_177 = 
      ((PartCurve) cadPart_177.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_178 = 
      ((CadPart) compositePart_38.getChildParts().getPart("DIN7985TX_M5X20"));

    PartSurface partSurface_184 = 
      ((PartSurface) cadPart_178.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_178 = 
      ((PartCurve) cadPart_178.getPartCurveManager().getPartCurve("Edges"));

    SolidModelCompositePart solidModelCompositePart_1 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("C_REARWING"));

    CompositePart compositePart_4 = 
      ((CompositePart) solidModelCompositePart_1.getChildParts().getPart("A_R000_REARWING_ASM"));

    CompositePart compositePart_47 = 
      ((CompositePart) compositePart_4.getChildParts().getPart("A_RA00_REARWING_ATTACHMENTS"));

    CompositePart compositePart_46 = 
      ((CompositePart) compositePart_47.getChildParts().getPart("A_RA01_RW_ATTACHMENT_A"));

    CadPart cadPart_179 = 
      ((CadPart) compositePart_46.getChildParts().getPart("A_RA01_ENDPLATE_BRACKET"));

    PartSurface partSurface_185 = 
      ((PartSurface) cadPart_179.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_179 = 
      ((PartCurve) cadPart_179.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_48 = 
      ((CompositePart) compositePart_46.getChildParts().getPart("A_RA01_INSERT_ROD_BOTTOM"));

    CadPart cadPart_180 = 
      ((CadPart) compositePart_48.getChildParts().getPart("A_RA01_INSERT_ROD_BOTTOM_Body"));

    PartSurface partSurface_186 = 
      ((PartSurface) cadPart_180.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_180 = 
      ((PartCurve) cadPart_180.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_49 = 
      ((CompositePart) compositePart_46.getChildParts().getPart("A_RA01_INSERT_ROD_TOP"));

    CadPart cadPart_181 = 
      ((CadPart) compositePart_49.getChildParts().getPart("A_RA01_INSERT_ROD_TOP_Body"));

    PartSurface partSurface_187 = 
      ((PartSurface) cadPart_181.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_181 = 
      ((PartCurve) cadPart_181.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_182 = 
      ((CadPart) compositePart_46.getChildParts().getPart("A_RA01_MAIN_HOOP_BRACKET"));

    PartSurface partSurface_188 = 
      ((PartSurface) cadPart_182.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_182 = 
      ((PartCurve) cadPart_182.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_183 = 
      ((CadPart) compositePart_46.getChildParts().getPart("A_RA01_ROD"));

    PartSurface partSurface_189 = 
      ((PartSurface) cadPart_183.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_183 = 
      ((PartCurve) cadPart_183.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_50 = 
      ((CompositePart) compositePart_46.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5"));

    CadPart cadPart_184 = 
      ((CadPart) compositePart_50.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_190 = 
      ((PartSurface) cadPart_184.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_191 = 
      ((PartSurface) cadPart_184.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_184 = 
      ((PartCurve) cadPart_184.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_51 = 
      ((CompositePart) compositePart_46.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5 2"));

    CadPart cadPart_185 = 
      ((CadPart) compositePart_51.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_192 = 
      ((PartSurface) cadPart_185.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_193 = 
      ((PartSurface) cadPart_185.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_185 = 
      ((PartCurve) cadPart_185.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_186 = 
      ((CadPart) compositePart_46.getChildParts().getPart("ASKUBAL_BALL_M5"));

    PartSurface partSurface_194 = 
      ((PartSurface) cadPart_186.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_186 = 
      ((PartCurve) cadPart_186.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_187 = 
      ((CadPart) compositePart_46.getChildParts().getPart("D125B_5_3"));

    PartSurface partSurface_195 = 
      ((PartSurface) cadPart_187.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_187 = 
      ((PartCurve) cadPart_187.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_52 = 
      ((CompositePart) compositePart_46.getChildParts().getPart("D439_M5"));

    CadPart cadPart_188 = 
      ((CadPart) compositePart_52.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_196 = 
      ((PartSurface) cadPart_188.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_188 = 
      ((PartCurve) cadPart_188.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_53 = 
      ((CompositePart) compositePart_46.getChildParts().getPart("D439_M5 2"));

    CadPart cadPart_189 = 
      ((CadPart) compositePart_53.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_197 = 
      ((PartSurface) cadPart_189.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_189 = 
      ((PartCurve) cadPart_189.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_54 = 
      ((CompositePart) compositePart_46.getChildParts().getPart("DIN985_M5"));

    CadPart cadPart_190 = 
      ((CadPart) compositePart_54.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_198 = 
      ((PartSurface) cadPart_190.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_190 = 
      ((PartCurve) cadPart_190.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_55 = 
      ((CompositePart) compositePart_46.getChildParts().getPart("DIN985_M5 2"));

    CadPart cadPart_191 = 
      ((CadPart) compositePart_55.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_199 = 
      ((PartSurface) cadPart_191.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_191 = 
      ((PartCurve) cadPart_191.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_192 = 
      ((CadPart) compositePart_46.getChildParts().getPart("DIN7985TX_M4X10"));

    PartSurface partSurface_200 = 
      ((PartSurface) cadPart_192.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_192 = 
      ((PartCurve) cadPart_192.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_193 = 
      ((CadPart) compositePart_46.getChildParts().getPart("DIN7985TX_M5X25"));

    PartSurface partSurface_201 = 
      ((PartSurface) cadPart_193.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_193 = 
      ((PartCurve) cadPart_193.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_56 = 
      ((CompositePart) compositePart_47.getChildParts().getPart("A_RA01_RW_ATTACHMENT_A_MIR"));

    CadPart cadPart_194 = 
      ((CadPart) compositePart_56.getChildParts().getPart("A_RA01_ENDPLATE_BRACKET_MIR"));

    PartSurface partSurface_202 = 
      ((PartSurface) cadPart_194.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_194 = 
      ((PartCurve) cadPart_194.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_195 = 
      ((CadPart) compositePart_56.getChildParts().getPart("A_RA01_INSERT_ROD_BOTTOM_MIR"));

    PartSurface partSurface_203 = 
      ((PartSurface) cadPart_195.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_195 = 
      ((PartCurve) cadPart_195.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_196 = 
      ((CadPart) compositePart_56.getChildParts().getPart("A_RA01_INSERT_ROD_TOP_MIR"));

    PartSurface partSurface_204 = 
      ((PartSurface) cadPart_196.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_196 = 
      ((PartCurve) cadPart_196.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_197 = 
      ((CadPart) compositePart_56.getChildParts().getPart("A_RA01_MAIN_HOOP_BRACKET_MIR"));

    PartSurface partSurface_205 = 
      ((PartSurface) cadPart_197.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_197 = 
      ((PartCurve) cadPart_197.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_198 = 
      ((CadPart) compositePart_56.getChildParts().getPart("A_RA01_ROD_MIR"));

    PartSurface partSurface_206 = 
      ((PartSurface) cadPart_198.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_198 = 
      ((PartCurve) cadPart_198.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_57 = 
      ((CompositePart) compositePart_56.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5"));

    CadPart cadPart_199 = 
      ((CadPart) compositePart_57.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_207 = 
      ((PartSurface) cadPart_199.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_208 = 
      ((PartSurface) cadPart_199.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_199 = 
      ((PartCurve) cadPart_199.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_58 = 
      ((CompositePart) compositePart_56.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5 2"));

    CadPart cadPart_200 = 
      ((CadPart) compositePart_58.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_209 = 
      ((PartSurface) cadPart_200.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_210 = 
      ((PartSurface) cadPart_200.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_200 = 
      ((PartCurve) cadPart_200.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_201 = 
      ((CadPart) compositePart_56.getChildParts().getPart("ASKUBAL_BALL_M5"));

    PartSurface partSurface_211 = 
      ((PartSurface) cadPart_201.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_201 = 
      ((PartCurve) cadPart_201.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_202 = 
      ((CadPart) compositePart_56.getChildParts().getPart("D125B_5_3"));

    PartSurface partSurface_212 = 
      ((PartSurface) cadPart_202.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_202 = 
      ((PartCurve) cadPart_202.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_59 = 
      ((CompositePart) compositePart_56.getChildParts().getPart("D439_M5"));

    CadPart cadPart_203 = 
      ((CadPart) compositePart_59.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_213 = 
      ((PartSurface) cadPart_203.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_203 = 
      ((PartCurve) cadPart_203.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_60 = 
      ((CompositePart) compositePart_56.getChildParts().getPart("D439_M5 2"));

    CadPart cadPart_204 = 
      ((CadPart) compositePart_60.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_214 = 
      ((PartSurface) cadPart_204.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_204 = 
      ((PartCurve) cadPart_204.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_61 = 
      ((CompositePart) compositePart_56.getChildParts().getPart("DIN985_M5"));

    CadPart cadPart_205 = 
      ((CadPart) compositePart_61.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_215 = 
      ((PartSurface) cadPart_205.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_205 = 
      ((PartCurve) cadPart_205.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_206 = 
      ((CadPart) compositePart_56.getChildParts().getPart("DIN7985TX_M4X10"));

    PartSurface partSurface_216 = 
      ((PartSurface) cadPart_206.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_206 = 
      ((PartCurve) cadPart_206.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_207 = 
      ((CadPart) compositePart_56.getChildParts().getPart("DIN7985TX_M5X25"));

    PartSurface partSurface_217 = 
      ((PartSurface) cadPart_207.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_207 = 
      ((PartCurve) cadPart_207.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_62 = 
      ((CompositePart) compositePart_47.getChildParts().getPart("A_RA02_RW_ATTACHMENT_B"));

    CadPart cadPart_208 = 
      ((CadPart) compositePart_62.getChildParts().getPart("A_RA02_ENDPLATE_BRACKET"));

    PartSurface partSurface_218 = 
      ((PartSurface) cadPart_208.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_208 = 
      ((PartCurve) cadPart_208.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_209 = 
      ((CadPart) compositePart_62.getChildParts().getPart("A_RA02_INSERT_ROD_BOTTOM"));

    PartSurface partSurface_219 = 
      ((PartSurface) cadPart_209.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_209 = 
      ((PartCurve) cadPart_209.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_210 = 
      ((CadPart) compositePart_62.getChildParts().getPart("A_RA02_INSERT_ROD_TOP"));

    PartSurface partSurface_220 = 
      ((PartSurface) cadPart_210.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_210 = 
      ((PartCurve) cadPart_210.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_211 = 
      ((CadPart) compositePart_62.getChildParts().getPart("A_RA02_MONO_BRACKET"));

    PartSurface partSurface_221 = 
      ((PartSurface) cadPart_211.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_211 = 
      ((PartCurve) cadPart_211.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_212 = 
      ((CadPart) compositePart_62.getChildParts().getPart("A_RA02_ROD"));

    PartSurface partSurface_222 = 
      ((PartSurface) cadPart_212.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_212 = 
      ((PartCurve) cadPart_212.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_63 = 
      ((CompositePart) compositePart_62.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5"));

    CadPart cadPart_213 = 
      ((CadPart) compositePart_63.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_223 = 
      ((PartSurface) cadPart_213.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_224 = 
      ((PartSurface) cadPart_213.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_213 = 
      ((PartCurve) cadPart_213.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_64 = 
      ((CompositePart) compositePart_62.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5 2"));

    CadPart cadPart_214 = 
      ((CadPart) compositePart_64.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_225 = 
      ((PartSurface) cadPart_214.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_226 = 
      ((PartSurface) cadPart_214.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_214 = 
      ((PartCurve) cadPart_214.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_215 = 
      ((CadPart) compositePart_62.getChildParts().getPart("ASKUBAL_BALL_M5"));

    PartSurface partSurface_227 = 
      ((PartSurface) cadPart_215.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_215 = 
      ((PartCurve) cadPart_215.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_216 = 
      ((CadPart) compositePart_62.getChildParts().getPart("D125B_5_3"));

    PartSurface partSurface_228 = 
      ((PartSurface) cadPart_216.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_216 = 
      ((PartCurve) cadPart_216.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_65 = 
      ((CompositePart) compositePart_62.getChildParts().getPart("D439_M5"));

    CadPart cadPart_217 = 
      ((CadPart) compositePart_65.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_229 = 
      ((PartSurface) cadPart_217.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_217 = 
      ((PartCurve) cadPart_217.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_66 = 
      ((CompositePart) compositePart_62.getChildParts().getPart("D439_M5 2"));

    CadPart cadPart_218 = 
      ((CadPart) compositePart_66.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_230 = 
      ((PartSurface) cadPart_218.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_218 = 
      ((PartCurve) cadPart_218.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_67 = 
      ((CompositePart) compositePart_62.getChildParts().getPart("DIN985_M5"));

    CadPart cadPart_219 = 
      ((CadPart) compositePart_67.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_231 = 
      ((PartSurface) cadPart_219.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_219 = 
      ((PartCurve) cadPart_219.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_68 = 
      ((CompositePart) compositePart_62.getChildParts().getPart("DIN985_M5 2"));

    CadPart cadPart_220 = 
      ((CadPart) compositePart_68.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_232 = 
      ((PartSurface) cadPart_220.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_220 = 
      ((PartCurve) cadPart_220.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_221 = 
      ((CadPart) compositePart_62.getChildParts().getPart("DIN7985TX_M4X10"));

    PartSurface partSurface_233 = 
      ((PartSurface) cadPart_221.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_221 = 
      ((PartCurve) cadPart_221.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_222 = 
      ((CadPart) compositePart_62.getChildParts().getPart("DIN7985TX_M4X20"));

    PartSurface partSurface_234 = 
      ((PartSurface) cadPart_222.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_222 = 
      ((PartCurve) cadPart_222.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_223 = 
      ((CadPart) compositePart_62.getChildParts().getPart("DIN7985TX_M5X25"));

    PartSurface partSurface_235 = 
      ((PartSurface) cadPart_223.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_223 = 
      ((PartCurve) cadPart_223.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_69 = 
      ((CompositePart) compositePart_47.getChildParts().getPart("A_RA02_RW_ATTACHMENT_B_MIR"));

    CadPart cadPart_224 = 
      ((CadPart) compositePart_69.getChildParts().getPart("A_RA02_ENDPLATE_BRACKET_MIR"));

    PartSurface partSurface_236 = 
      ((PartSurface) cadPart_224.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_224 = 
      ((PartCurve) cadPart_224.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_225 = 
      ((CadPart) compositePart_69.getChildParts().getPart("A_RA02_INSERT_ROD_BOTTOM_MIR"));

    PartSurface partSurface_237 = 
      ((PartSurface) cadPart_225.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_225 = 
      ((PartCurve) cadPart_225.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_226 = 
      ((CadPart) compositePart_69.getChildParts().getPart("A_RA02_INSERT_ROD_TOP_MIR"));

    PartSurface partSurface_238 = 
      ((PartSurface) cadPart_226.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_226 = 
      ((PartCurve) cadPart_226.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_227 = 
      ((CadPart) compositePart_69.getChildParts().getPart("A_RA02_MONO_BRACKET_MIR"));

    PartSurface partSurface_239 = 
      ((PartSurface) cadPart_227.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_227 = 
      ((PartCurve) cadPart_227.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_228 = 
      ((CadPart) compositePart_69.getChildParts().getPart("A_RA02_ROD_MIR"));

    PartSurface partSurface_240 = 
      ((PartSurface) cadPart_228.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_228 = 
      ((PartCurve) cadPart_228.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_70 = 
      ((CompositePart) compositePart_69.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5"));

    CadPart cadPart_229 = 
      ((CadPart) compositePart_70.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_241 = 
      ((PartSurface) cadPart_229.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_242 = 
      ((PartSurface) cadPart_229.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_229 = 
      ((PartCurve) cadPart_229.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_71 = 
      ((CompositePart) compositePart_69.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5 2"));

    CadPart cadPart_230 = 
      ((CadPart) compositePart_71.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_243 = 
      ((PartSurface) cadPart_230.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_244 = 
      ((PartSurface) cadPart_230.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_230 = 
      ((PartCurve) cadPart_230.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_231 = 
      ((CadPart) compositePart_69.getChildParts().getPart("ASKUBAL_BALL_M5"));

    PartSurface partSurface_245 = 
      ((PartSurface) cadPart_231.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_231 = 
      ((PartCurve) cadPart_231.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_232 = 
      ((CadPart) compositePart_69.getChildParts().getPart("D125B_5_3"));

    PartSurface partSurface_246 = 
      ((PartSurface) cadPart_232.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_232 = 
      ((PartCurve) cadPart_232.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_72 = 
      ((CompositePart) compositePart_69.getChildParts().getPart("D439_M5"));

    CadPart cadPart_233 = 
      ((CadPart) compositePart_72.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_247 = 
      ((PartSurface) cadPart_233.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_233 = 
      ((PartCurve) cadPart_233.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_73 = 
      ((CompositePart) compositePart_69.getChildParts().getPart("D439_M5 2"));

    CadPart cadPart_234 = 
      ((CadPart) compositePart_73.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_248 = 
      ((PartSurface) cadPart_234.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_234 = 
      ((PartCurve) cadPart_234.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_74 = 
      ((CompositePart) compositePart_69.getChildParts().getPart("DIN985_M5"));

    CadPart cadPart_235 = 
      ((CadPart) compositePart_74.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_249 = 
      ((PartSurface) cadPart_235.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_235 = 
      ((PartCurve) cadPart_235.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_75 = 
      ((CompositePart) compositePart_69.getChildParts().getPart("DIN985_M5 2"));

    CadPart cadPart_236 = 
      ((CadPart) compositePart_75.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_250 = 
      ((PartSurface) cadPart_236.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_236 = 
      ((PartCurve) cadPart_236.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_237 = 
      ((CadPart) compositePart_69.getChildParts().getPart("DIN7985TX_M4X10"));

    PartSurface partSurface_251 = 
      ((PartSurface) cadPart_237.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_237 = 
      ((PartCurve) cadPart_237.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_238 = 
      ((CadPart) compositePart_69.getChildParts().getPart("DIN7985TX_M4X20"));

    PartSurface partSurface_252 = 
      ((PartSurface) cadPart_238.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_238 = 
      ((PartCurve) cadPart_238.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_239 = 
      ((CadPart) compositePart_69.getChildParts().getPart("DIN7985TX_M5X25"));

    PartSurface partSurface_253 = 
      ((PartSurface) cadPart_239.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_239 = 
      ((PartCurve) cadPart_239.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_76 = 
      ((CompositePart) compositePart_47.getChildParts().getPart("A_RA03_RW_ATTACHMENT_C"));

    CadPart cadPart_240 = 
      ((CadPart) compositePart_76.getChildParts().getPart("A_RA03_ENDPLATE_BRACKET"));

    PartSurface partSurface_254 = 
      ((PartSurface) cadPart_240.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_240 = 
      ((PartCurve) cadPart_240.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_241 = 
      ((CadPart) compositePart_76.getChildParts().getPart("A_RA03_INSERT_ROD_BOTTOM"));

    PartSurface partSurface_255 = 
      ((PartSurface) cadPart_241.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_241 = 
      ((PartCurve) cadPart_241.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_242 = 
      ((CadPart) compositePart_76.getChildParts().getPart("A_RA03_INSERT_ROD_TOP"));

    PartSurface partSurface_256 = 
      ((PartSurface) cadPart_242.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_242 = 
      ((PartCurve) cadPart_242.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_243 = 
      ((CadPart) compositePart_76.getChildParts().getPart("A_RA03_MONO_BRACKET_TYPE_A"));

    PartSurface partSurface_257 = 
      ((PartSurface) cadPart_243.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_243 = 
      ((PartCurve) cadPart_243.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_244 = 
      ((CadPart) compositePart_76.getChildParts().getPart("A_RA03_ROD"));

    PartSurface partSurface_258 = 
      ((PartSurface) cadPart_244.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_244 = 
      ((PartCurve) cadPart_244.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_77 = 
      ((CompositePart) compositePart_76.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5"));

    CadPart cadPart_245 = 
      ((CadPart) compositePart_77.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_259 = 
      ((PartSurface) cadPart_245.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_260 = 
      ((PartSurface) cadPart_245.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_245 = 
      ((PartCurve) cadPart_245.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_78 = 
      ((CompositePart) compositePart_76.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5 2"));

    CadPart cadPart_246 = 
      ((CadPart) compositePart_78.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_261 = 
      ((PartSurface) cadPart_246.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_262 = 
      ((PartSurface) cadPart_246.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_246 = 
      ((PartCurve) cadPart_246.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_247 = 
      ((CadPart) compositePart_76.getChildParts().getPart("ASKUBAL_BALL_M5"));

    PartSurface partSurface_263 = 
      ((PartSurface) cadPart_247.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_247 = 
      ((PartCurve) cadPart_247.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_248 = 
      ((CadPart) compositePart_76.getChildParts().getPart("D125B_5_3"));

    PartSurface partSurface_264 = 
      ((PartSurface) cadPart_248.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_248 = 
      ((PartCurve) cadPart_248.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_79 = 
      ((CompositePart) compositePart_76.getChildParts().getPart("D439_M5"));

    CadPart cadPart_249 = 
      ((CadPart) compositePart_79.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_265 = 
      ((PartSurface) cadPart_249.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_249 = 
      ((PartCurve) cadPart_249.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_80 = 
      ((CompositePart) compositePart_76.getChildParts().getPart("D439_M5 2"));

    CadPart cadPart_250 = 
      ((CadPart) compositePart_80.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_266 = 
      ((PartSurface) cadPart_250.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_250 = 
      ((PartCurve) cadPart_250.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_81 = 
      ((CompositePart) compositePart_76.getChildParts().getPart("DIN985_M5"));

    CadPart cadPart_251 = 
      ((CadPart) compositePart_81.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_267 = 
      ((PartSurface) cadPart_251.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_251 = 
      ((PartCurve) cadPart_251.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_82 = 
      ((CompositePart) compositePart_76.getChildParts().getPart("DIN985_M5 2"));

    CadPart cadPart_252 = 
      ((CadPart) compositePart_82.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_268 = 
      ((PartSurface) cadPart_252.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_252 = 
      ((PartCurve) cadPart_252.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_253 = 
      ((CadPart) compositePart_76.getChildParts().getPart("DIN7985TX_M4X10"));

    PartSurface partSurface_269 = 
      ((PartSurface) cadPart_253.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_253 = 
      ((PartCurve) cadPart_253.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_254 = 
      ((CadPart) compositePart_76.getChildParts().getPart("DIN7985TX_M4X30"));

    PartSurface partSurface_270 = 
      ((PartSurface) cadPart_254.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_254 = 
      ((PartCurve) cadPart_254.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_255 = 
      ((CadPart) compositePart_76.getChildParts().getPart("DIN7985TX_M5X25"));

    PartSurface partSurface_271 = 
      ((PartSurface) cadPart_255.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_255 = 
      ((PartCurve) cadPart_255.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_83 = 
      ((CompositePart) compositePart_47.getChildParts().getPart("A_RA03_RW_ATTACHMENT_C_MIR"));

    CadPart cadPart_256 = 
      ((CadPart) compositePart_83.getChildParts().getPart("A_RA03_ENDPLATE_BRACKET_MIR"));

    PartSurface partSurface_272 = 
      ((PartSurface) cadPart_256.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_256 = 
      ((PartCurve) cadPart_256.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_257 = 
      ((CadPart) compositePart_83.getChildParts().getPart("A_RA03_INSERT_ROD_BOTTOM_MIR"));

    PartSurface partSurface_273 = 
      ((PartSurface) cadPart_257.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_257 = 
      ((PartCurve) cadPart_257.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_258 = 
      ((CadPart) compositePart_83.getChildParts().getPart("A_RA03_INSERT_ROD_TOP_MIR"));

    PartSurface partSurface_274 = 
      ((PartSurface) cadPart_258.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_258 = 
      ((PartCurve) cadPart_258.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_259 = 
      ((CadPart) compositePart_83.getChildParts().getPart("A_RA03_MONO_BRACKET_TYPE_A_MIR"));

    PartSurface partSurface_275 = 
      ((PartSurface) cadPart_259.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_259 = 
      ((PartCurve) cadPart_259.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_260 = 
      ((CadPart) compositePart_83.getChildParts().getPart("A_RA03_ROD_MIR"));

    PartSurface partSurface_276 = 
      ((PartSurface) cadPart_260.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_260 = 
      ((PartCurve) cadPart_260.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_84 = 
      ((CompositePart) compositePart_83.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5"));

    CadPart cadPart_261 = 
      ((CadPart) compositePart_84.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_277 = 
      ((PartSurface) cadPart_261.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_278 = 
      ((PartSurface) cadPart_261.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_261 = 
      ((PartCurve) cadPart_261.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_85 = 
      ((CompositePart) compositePart_83.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5 2"));

    CadPart cadPart_262 = 
      ((CadPart) compositePart_85.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_279 = 
      ((PartSurface) cadPart_262.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_280 = 
      ((PartSurface) cadPart_262.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_262 = 
      ((PartCurve) cadPart_262.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_263 = 
      ((CadPart) compositePart_83.getChildParts().getPart("ASKUBAL_BALL_M5"));

    PartSurface partSurface_281 = 
      ((PartSurface) cadPart_263.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_263 = 
      ((PartCurve) cadPart_263.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_264 = 
      ((CadPart) compositePart_83.getChildParts().getPart("D125B_5_3"));

    PartSurface partSurface_282 = 
      ((PartSurface) cadPart_264.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_264 = 
      ((PartCurve) cadPart_264.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_86 = 
      ((CompositePart) compositePart_83.getChildParts().getPart("D439_M5"));

    CadPart cadPart_265 = 
      ((CadPart) compositePart_86.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_283 = 
      ((PartSurface) cadPart_265.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_265 = 
      ((PartCurve) cadPart_265.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_87 = 
      ((CompositePart) compositePart_83.getChildParts().getPart("D439_M5 2"));

    CadPart cadPart_266 = 
      ((CadPart) compositePart_87.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_284 = 
      ((PartSurface) cadPart_266.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_266 = 
      ((PartCurve) cadPart_266.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_88 = 
      ((CompositePart) compositePart_83.getChildParts().getPart("DIN985_M5"));

    CadPart cadPart_267 = 
      ((CadPart) compositePart_88.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_285 = 
      ((PartSurface) cadPart_267.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_267 = 
      ((PartCurve) cadPart_267.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_89 = 
      ((CompositePart) compositePart_83.getChildParts().getPart("DIN985_M5 2"));

    CadPart cadPart_268 = 
      ((CadPart) compositePart_89.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_286 = 
      ((PartSurface) cadPart_268.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_268 = 
      ((PartCurve) cadPart_268.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_269 = 
      ((CadPart) compositePart_83.getChildParts().getPart("DIN7985TX_M4X10"));

    PartSurface partSurface_287 = 
      ((PartSurface) cadPart_269.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_269 = 
      ((PartCurve) cadPart_269.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_270 = 
      ((CadPart) compositePart_83.getChildParts().getPart("DIN7985TX_M4X30"));

    PartSurface partSurface_288 = 
      ((PartSurface) cadPart_270.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_270 = 
      ((PartCurve) cadPart_270.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_271 = 
      ((CadPart) compositePart_83.getChildParts().getPart("DIN7985TX_M5X25"));

    PartSurface partSurface_289 = 
      ((PartSurface) cadPart_271.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_271 = 
      ((PartCurve) cadPart_271.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_90 = 
      ((CompositePart) compositePart_47.getChildParts().getPart("A_RA04_RW_ATTACHMENT_D"));

    CadPart cadPart_272 = 
      ((CadPart) compositePart_90.getChildParts().getPart("A_RA04_ENDPLATE_BRACKET"));

    PartSurface partSurface_290 = 
      ((PartSurface) cadPart_272.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_272 = 
      ((PartCurve) cadPart_272.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_273 = 
      ((CadPart) compositePart_90.getChildParts().getPart("A_RA04_INSERT_ROD_BOTTOM"));

    PartSurface partSurface_291 = 
      ((PartSurface) cadPart_273.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_273 = 
      ((PartCurve) cadPart_273.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_274 = 
      ((CadPart) compositePart_90.getChildParts().getPart("A_RA04_INSERT_ROD_TOP"));

    PartSurface partSurface_292 = 
      ((PartSurface) cadPart_274.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_274 = 
      ((PartCurve) cadPart_274.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_275 = 
      ((CadPart) compositePart_90.getChildParts().getPart("A_RA04_MONO_BRACKET_TYPE_A"));

    PartSurface partSurface_293 = 
      ((PartSurface) cadPart_275.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_275 = 
      ((PartCurve) cadPart_275.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_276 = 
      ((CadPart) compositePart_90.getChildParts().getPart("A_RA04_ROD"));

    PartSurface partSurface_294 = 
      ((PartSurface) cadPart_276.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_276 = 
      ((PartCurve) cadPart_276.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_91 = 
      ((CompositePart) compositePart_90.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5"));

    CadPart cadPart_277 = 
      ((CadPart) compositePart_91.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_295 = 
      ((PartSurface) cadPart_277.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_296 = 
      ((PartSurface) cadPart_277.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_277 = 
      ((PartCurve) cadPart_277.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_92 = 
      ((CompositePart) compositePart_90.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5 2"));

    CadPart cadPart_278 = 
      ((CadPart) compositePart_92.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_297 = 
      ((PartSurface) cadPart_278.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_298 = 
      ((PartSurface) cadPart_278.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_278 = 
      ((PartCurve) cadPart_278.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_279 = 
      ((CadPart) compositePart_90.getChildParts().getPart("ASKUBAL_BALL_M5"));

    PartSurface partSurface_299 = 
      ((PartSurface) cadPart_279.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_279 = 
      ((PartCurve) cadPart_279.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_280 = 
      ((CadPart) compositePart_90.getChildParts().getPart("D125B_5_3"));

    PartSurface partSurface_300 = 
      ((PartSurface) cadPart_280.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_280 = 
      ((PartCurve) cadPart_280.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_93 = 
      ((CompositePart) compositePart_90.getChildParts().getPart("D439_M5"));

    CadPart cadPart_281 = 
      ((CadPart) compositePart_93.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_301 = 
      ((PartSurface) cadPart_281.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_281 = 
      ((PartCurve) cadPart_281.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_94 = 
      ((CompositePart) compositePart_90.getChildParts().getPart("D439_M5 2"));

    CadPart cadPart_282 = 
      ((CadPart) compositePart_94.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_302 = 
      ((PartSurface) cadPart_282.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_282 = 
      ((PartCurve) cadPart_282.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_95 = 
      ((CompositePart) compositePart_90.getChildParts().getPart("DIN985_M5"));

    CadPart cadPart_283 = 
      ((CadPart) compositePart_95.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_303 = 
      ((PartSurface) cadPart_283.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_283 = 
      ((PartCurve) cadPart_283.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_96 = 
      ((CompositePart) compositePart_90.getChildParts().getPart("DIN985_M5 2"));

    CadPart cadPart_284 = 
      ((CadPart) compositePart_96.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_304 = 
      ((PartSurface) cadPart_284.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_284 = 
      ((PartCurve) cadPart_284.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_285 = 
      ((CadPart) compositePart_90.getChildParts().getPart("DIN7985TX_M4X10"));

    PartSurface partSurface_305 = 
      ((PartSurface) cadPart_285.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_285 = 
      ((PartCurve) cadPart_285.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_286 = 
      ((CadPart) compositePart_90.getChildParts().getPart("DIN7985TX_M4X20"));

    PartSurface partSurface_306 = 
      ((PartSurface) cadPart_286.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_286 = 
      ((PartCurve) cadPart_286.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_287 = 
      ((CadPart) compositePart_90.getChildParts().getPart("DIN7985TX_M5X25"));

    PartSurface partSurface_307 = 
      ((PartSurface) cadPart_287.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_287 = 
      ((PartCurve) cadPart_287.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_97 = 
      ((CompositePart) compositePart_47.getChildParts().getPart("A_RA04_RW_ATTACHMENT_D_MIR"));

    CadPart cadPart_288 = 
      ((CadPart) compositePart_97.getChildParts().getPart("A_RA04_ENDPLATE_BRACKET_MIR"));

    PartSurface partSurface_308 = 
      ((PartSurface) cadPart_288.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_288 = 
      ((PartCurve) cadPart_288.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_289 = 
      ((CadPart) compositePart_97.getChildParts().getPart("A_RA04_INSERT_ROD_BOTTOM_MIR"));

    PartSurface partSurface_309 = 
      ((PartSurface) cadPart_289.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_289 = 
      ((PartCurve) cadPart_289.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_290 = 
      ((CadPart) compositePart_97.getChildParts().getPart("A_RA04_INSERT_ROD_TOP_MIR"));

    PartSurface partSurface_310 = 
      ((PartSurface) cadPart_290.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_290 = 
      ((PartCurve) cadPart_290.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_291 = 
      ((CadPart) compositePart_97.getChildParts().getPart("A_RA04_MONO_BRACKET_TYPE_A_MIR"));

    PartSurface partSurface_311 = 
      ((PartSurface) cadPart_291.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_291 = 
      ((PartCurve) cadPart_291.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_292 = 
      ((CadPart) compositePart_97.getChildParts().getPart("A_RA04_ROD_MIR"));

    PartSurface partSurface_312 = 
      ((PartSurface) cadPart_292.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_292 = 
      ((PartCurve) cadPart_292.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_98 = 
      ((CompositePart) compositePart_97.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5"));

    CadPart cadPart_293 = 
      ((CadPart) compositePart_98.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_313 = 
      ((PartSurface) cadPart_293.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_314 = 
      ((PartSurface) cadPart_293.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_293 = 
      ((PartCurve) cadPart_293.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_99 = 
      ((CompositePart) compositePart_97.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5 2"));

    CadPart cadPart_294 = 
      ((CadPart) compositePart_99.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_315 = 
      ((PartSurface) cadPart_294.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_316 = 
      ((PartSurface) cadPart_294.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_294 = 
      ((PartCurve) cadPart_294.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_295 = 
      ((CadPart) compositePart_97.getChildParts().getPart("ASKUBAL_BALL_M5"));

    PartSurface partSurface_317 = 
      ((PartSurface) cadPart_295.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_295 = 
      ((PartCurve) cadPart_295.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_296 = 
      ((CadPart) compositePart_97.getChildParts().getPart("D125B_5_3"));

    PartSurface partSurface_318 = 
      ((PartSurface) cadPart_296.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_296 = 
      ((PartCurve) cadPart_296.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_100 = 
      ((CompositePart) compositePart_97.getChildParts().getPart("D439_M5"));

    CadPart cadPart_297 = 
      ((CadPart) compositePart_100.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_319 = 
      ((PartSurface) cadPart_297.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_297 = 
      ((PartCurve) cadPart_297.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_101 = 
      ((CompositePart) compositePart_97.getChildParts().getPart("D439_M5 2"));

    CadPart cadPart_298 = 
      ((CadPart) compositePart_101.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_320 = 
      ((PartSurface) cadPart_298.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_298 = 
      ((PartCurve) cadPart_298.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_102 = 
      ((CompositePart) compositePart_97.getChildParts().getPart("DIN985_M5"));

    CadPart cadPart_299 = 
      ((CadPart) compositePart_102.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_321 = 
      ((PartSurface) cadPart_299.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_299 = 
      ((PartCurve) cadPart_299.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_103 = 
      ((CompositePart) compositePart_97.getChildParts().getPart("DIN985_M5 2"));

    CadPart cadPart_300 = 
      ((CadPart) compositePart_103.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_322 = 
      ((PartSurface) cadPart_300.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_300 = 
      ((PartCurve) cadPart_300.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_301 = 
      ((CadPart) compositePart_97.getChildParts().getPart("DIN7985TX_M4X10"));

    PartSurface partSurface_323 = 
      ((PartSurface) cadPart_301.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_301 = 
      ((PartCurve) cadPart_301.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_302 = 
      ((CadPart) compositePart_97.getChildParts().getPart("DIN7985TX_M4X20"));

    PartSurface partSurface_324 = 
      ((PartSurface) cadPart_302.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_302 = 
      ((PartCurve) cadPart_302.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_303 = 
      ((CadPart) compositePart_97.getChildParts().getPart("DIN7985TX_M5X25"));

    PartSurface partSurface_325 = 
      ((PartSurface) cadPart_303.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_303 = 
      ((PartCurve) cadPart_303.getPartCurveManager().getPartCurve("Edges"));

    SolidModelCompositePart solidModelCompositePart_4 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("z_000_remaining-parts"));

    CompositePart compositePart_104 = 
      ((CompositePart) solidModelCompositePart_4.getChildParts().getPart("Suspension_Front_Left"));

    CadPart cadPart_304 = 
      ((CadPart) compositePart_104.getChildParts().getPart("S_FL02_U"));

    PartSurface partSurface_326 = 
      ((PartSurface) cadPart_304.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_304 = 
      ((PartCurve) cadPart_304.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_305 = 
      ((CadPart) compositePart_104.getChildParts().getPart("S_FL03_L"));

    PartSurface partSurface_327 = 
      ((PartSurface) cadPart_305.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_305 = 
      ((PartCurve) cadPart_305.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_306 = 
      ((CadPart) compositePart_104.getChildParts().getPart("S_FL03_L 2"));

    PartSurface partSurface_328 = 
      ((PartSurface) cadPart_306.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_306 = 
      ((PartCurve) cadPart_306.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_307 = 
      ((CadPart) compositePart_104.getChildParts().getPart("S_FL04_T"));

    PartSurface partSurface_329 = 
      ((PartSurface) cadPart_307.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_307 = 
      ((PartCurve) cadPart_307.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_308 = 
      ((CadPart) compositePart_104.getChildParts().getPart("S_FL06_P"));

    PartSurface partSurface_330 = 
      ((PartSurface) cadPart_308.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_308 = 
      ((PartCurve) cadPart_308.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_105 = 
      ((CompositePart) solidModelCompositePart_4.getChildParts().getPart("Suspension_Front_Right"));

    CadPart cadPart_309 = 
      ((CadPart) compositePart_105.getChildParts().getPart("S_FL02_U"));

    PartSurface partSurface_331 = 
      ((PartSurface) cadPart_309.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_309 = 
      ((PartCurve) cadPart_309.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_310 = 
      ((CadPart) compositePart_105.getChildParts().getPart("S_FL03_L"));

    PartSurface partSurface_332 = 
      ((PartSurface) cadPart_310.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_310 = 
      ((PartCurve) cadPart_310.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_311 = 
      ((CadPart) compositePart_105.getChildParts().getPart("S_FL03_L 2"));

    PartSurface partSurface_333 = 
      ((PartSurface) cadPart_311.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_311 = 
      ((PartCurve) cadPart_311.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_312 = 
      ((CadPart) compositePart_105.getChildParts().getPart("S_FL04_T"));

    PartSurface partSurface_334 = 
      ((PartSurface) cadPart_312.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_312 = 
      ((PartCurve) cadPart_312.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_313 = 
      ((CadPart) compositePart_105.getChildParts().getPart("S_FL06_P"));

    PartSurface partSurface_335 = 
      ((PartSurface) cadPart_313.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_313 = 
      ((PartCurve) cadPart_313.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_106 = 
      ((CompositePart) solidModelCompositePart_4.getChildParts().getPart("Suspension_Rear_Left"));

    CadPart cadPart_314 = 
      ((CadPart) compositePart_106.getChildParts().getPart("S_RL02_U"));

    PartSurface partSurface_336 = 
      ((PartSurface) cadPart_314.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_314 = 
      ((PartCurve) cadPart_314.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_315 = 
      ((CadPart) compositePart_106.getChildParts().getPart("S_RL02_U 2"));

    PartSurface partSurface_337 = 
      ((PartSurface) cadPart_315.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_315 = 
      ((PartCurve) cadPart_315.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_316 = 
      ((CadPart) compositePart_106.getChildParts().getPart("S_RL03_L"));

    PartSurface partSurface_338 = 
      ((PartSurface) cadPart_316.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_316 = 
      ((PartCurve) cadPart_316.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_317 = 
      ((CadPart) compositePart_106.getChildParts().getPart("S_RL03_L 2"));

    PartSurface partSurface_339 = 
      ((PartSurface) cadPart_317.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_317 = 
      ((PartCurve) cadPart_317.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_318 = 
      ((CadPart) compositePart_106.getChildParts().getPart("S_RL04_T"));

    PartSurface partSurface_340 = 
      ((PartSurface) cadPart_318.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_318 = 
      ((PartCurve) cadPart_318.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_319 = 
      ((CadPart) compositePart_106.getChildParts().getPart("S_RL06_P"));

    PartSurface partSurface_341 = 
      ((PartSurface) cadPart_319.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_319 = 
      ((PartCurve) cadPart_319.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_320 = 
      ((CadPart) compositePart_106.getChildParts().getPart("S_RL06_P 2"));

    PartSurface partSurface_342 = 
      ((PartSurface) cadPart_320.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_320 = 
      ((PartCurve) cadPart_320.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_321 = 
      ((CadPart) compositePart_106.getChildParts().getPart("S_RL08_D"));

    PartSurface partSurface_343 = 
      ((PartSurface) cadPart_321.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_321 = 
      ((PartCurve) cadPart_321.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_322 = 
      ((CadPart) compositePart_106.getChildParts().getPart("S_RL08_D 2"));

    PartSurface partSurface_344 = 
      ((PartSurface) cadPart_322.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_322 = 
      ((PartCurve) cadPart_322.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_107 = 
      ((CompositePart) solidModelCompositePart_4.getChildParts().getPart("Suspension_Rear_Right"));

    CadPart cadPart_323 = 
      ((CadPart) compositePart_107.getChildParts().getPart("S_RL02_U"));

    PartSurface partSurface_345 = 
      ((PartSurface) cadPart_323.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_323 = 
      ((PartCurve) cadPart_323.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_324 = 
      ((CadPart) compositePart_107.getChildParts().getPart("S_RL02_U 2"));

    PartSurface partSurface_346 = 
      ((PartSurface) cadPart_324.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_324 = 
      ((PartCurve) cadPart_324.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_325 = 
      ((CadPart) compositePart_107.getChildParts().getPart("S_RL03_L"));

    PartSurface partSurface_347 = 
      ((PartSurface) cadPart_325.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_325 = 
      ((PartCurve) cadPart_325.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_326 = 
      ((CadPart) compositePart_107.getChildParts().getPart("S_RL03_L 2"));

    PartSurface partSurface_348 = 
      ((PartSurface) cadPart_326.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_326 = 
      ((PartCurve) cadPart_326.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_327 = 
      ((CadPart) compositePart_107.getChildParts().getPart("S_RL04_T"));

    PartSurface partSurface_349 = 
      ((PartSurface) cadPart_327.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_327 = 
      ((PartCurve) cadPart_327.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_328 = 
      ((CadPart) compositePart_107.getChildParts().getPart("S_RL06_P"));

    PartSurface partSurface_350 = 
      ((PartSurface) cadPart_328.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_328 = 
      ((PartCurve) cadPart_328.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_329 = 
      ((CadPart) compositePart_107.getChildParts().getPart("S_RL06_P 2"));

    PartSurface partSurface_351 = 
      ((PartSurface) cadPart_329.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_329 = 
      ((PartCurve) cadPart_329.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_330 = 
      ((CadPart) compositePart_107.getChildParts().getPart("S_RL08_D"));

    PartSurface partSurface_352 = 
      ((PartSurface) cadPart_330.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_330 = 
      ((PartCurve) cadPart_330.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_331 = 
      ((CadPart) compositePart_107.getChildParts().getPart("S_RL08_D 2"));

    PartSurface partSurface_353 = 
      ((PartSurface) cadPart_331.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_331 = 
      ((PartCurve) cadPart_331.getPartCurveManager().getPartCurve("Edges"));

    partDisplayer_7.getInputParts().setObjects(partSurface_149, partCurve_147, partSurface_150, partCurve_148, partSurface_151, partCurve_149, partSurface_152, partCurve_150, partSurface_153, partCurve_151, partSurface_154, partCurve_152, partSurface_155, partSurface_156, partCurve_153, partSurface_157, partSurface_158, partCurve_154, partSurface_159, partCurve_155, partSurface_160, partCurve_156, partSurface_161, partCurve_157, partSurface_162, partCurve_158, partSurface_163, partCurve_159, partSurface_164, partCurve_160, partSurface_165, partCurve_161, partSurface_166, partCurve_162, partSurface_167, partCurve_163, partSurface_168, partCurve_164, partSurface_169, partCurve_165, partSurface_170, partCurve_166, partSurface_171, partCurve_167, partSurface_172, partCurve_168, partSurface_173, partSurface_174, partCurve_169, partSurface_175, partSurface_176, partCurve_170, partSurface_177, partCurve_171, partSurface_178, partCurve_172, partSurface_179, partCurve_173, partSurface_180, partCurve_174, partSurface_181, partCurve_175, partSurface_182, partCurve_176, partSurface_183, partCurve_177, partSurface_184, partCurve_178, partSurface_185, partCurve_179, partSurface_186, partCurve_180, partSurface_187, partCurve_181, partSurface_188, partCurve_182, partSurface_189, partCurve_183, partSurface_190, partSurface_191, partCurve_184, partSurface_192, partSurface_193, partCurve_185, partSurface_194, partCurve_186, partSurface_195, partCurve_187, partSurface_196, partCurve_188, partSurface_197, partCurve_189, partSurface_198, partCurve_190, partSurface_199, partCurve_191, partSurface_200, partCurve_192, partSurface_201, partCurve_193, partSurface_202, partCurve_194, partSurface_203, partCurve_195, partSurface_204, partCurve_196, partSurface_205, partCurve_197, partSurface_206, partCurve_198, partSurface_207, partSurface_208, partCurve_199, partSurface_209, partSurface_210, partCurve_200, partSurface_211, partCurve_201, partSurface_212, partCurve_202, partSurface_213, partCurve_203, partSurface_214, partCurve_204, partSurface_215, partCurve_205, partSurface_216, partCurve_206, partSurface_217, partCurve_207, partSurface_218, partCurve_208, partSurface_219, partCurve_209, partSurface_220, partCurve_210, partSurface_221, partCurve_211, partSurface_222, partCurve_212, partSurface_223, partSurface_224, partCurve_213, partSurface_225, partSurface_226, partCurve_214, partSurface_227, partCurve_215, partSurface_228, partCurve_216, partSurface_229, partCurve_217, partSurface_230, partCurve_218, partSurface_231, partCurve_219, partSurface_232, partCurve_220, partSurface_233, partCurve_221, partSurface_234, partCurve_222, partSurface_235, partCurve_223, partSurface_236, partCurve_224, partSurface_237, partCurve_225, partSurface_238, partCurve_226, partSurface_239, partCurve_227, partSurface_240, partCurve_228, partSurface_241, partSurface_242, partCurve_229, partSurface_243, partSurface_244, partCurve_230, partSurface_245, partCurve_231, partSurface_246, partCurve_232, partSurface_247, partCurve_233, partSurface_248, partCurve_234, partSurface_249, partCurve_235, partSurface_250, partCurve_236, partSurface_251, partCurve_237, partSurface_252, partCurve_238, partSurface_253, partCurve_239, partSurface_254, partCurve_240, partSurface_255, partCurve_241, partSurface_256, partCurve_242, partSurface_257, partCurve_243, partSurface_258, partCurve_244, partSurface_259, partSurface_260, partCurve_245, partSurface_261, partSurface_262, partCurve_246, partSurface_263, partCurve_247, partSurface_264, partCurve_248, partSurface_265, partCurve_249, partSurface_266, partCurve_250, partSurface_267, partCurve_251, partSurface_268, partCurve_252, partSurface_269, partCurve_253, partSurface_270, partCurve_254, partSurface_271, partCurve_255, partSurface_272, partCurve_256, partSurface_273, partCurve_257, partSurface_274, partCurve_258, partSurface_275, partCurve_259, partSurface_276, partCurve_260, partSurface_277, partSurface_278, partCurve_261, partSurface_279, partSurface_280, partCurve_262, partSurface_281, partCurve_263, partSurface_282, partCurve_264, partSurface_283, partCurve_265, partSurface_284, partCurve_266, partSurface_285, partCurve_267, partSurface_286, partCurve_268, partSurface_287, partCurve_269, partSurface_288, partCurve_270, partSurface_289, partCurve_271, partSurface_290, partCurve_272, partSurface_291, partCurve_273, partSurface_292, partCurve_274, partSurface_293, partCurve_275, partSurface_294, partCurve_276, partSurface_295, partSurface_296, partCurve_277, partSurface_297, partSurface_298, partCurve_278, partSurface_299, partCurve_279, partSurface_300, partCurve_280, partSurface_301, partCurve_281, partSurface_302, partCurve_282, partSurface_303, partCurve_283, partSurface_304, partCurve_284, partSurface_305, partCurve_285, partSurface_306, partCurve_286, partSurface_307, partCurve_287, partSurface_308, partCurve_288, partSurface_309, partCurve_289, partSurface_310, partCurve_290, partSurface_311, partCurve_291, partSurface_312, partCurve_292, partSurface_313, partSurface_314, partCurve_293, partSurface_315, partSurface_316, partCurve_294, partSurface_317, partCurve_295, partSurface_318, partCurve_296, partSurface_319, partCurve_297, partSurface_320, partCurve_298, partSurface_321, partCurve_299, partSurface_322, partCurve_300, partSurface_323, partCurve_301, partSurface_324, partCurve_302, partSurface_325, partCurve_303, partSurface_326, partCurve_304, partSurface_327, partCurve_305, partSurface_328, partCurve_306, partSurface_329, partCurve_307, partSurface_330, partCurve_308, partSurface_331, partCurve_309, partSurface_332, partCurve_310, partSurface_333, partCurve_311, partSurface_334, partCurve_312, partSurface_335, partCurve_313, partSurface_336, partCurve_314, partSurface_337, partCurve_315, partSurface_338, partCurve_316, partSurface_339, partCurve_317, partSurface_340, partCurve_318, partSurface_341, partCurve_319, partSurface_342, partCurve_320, partSurface_343, partCurve_321, partSurface_344, partCurve_322, partSurface_345, partCurve_323, partSurface_346, partCurve_324, partSurface_347, partCurve_325, partSurface_348, partCurve_326, partSurface_349, partCurve_327, partSurface_350, partCurve_328, partSurface_351, partCurve_329, partSurface_352, partCurve_330, partSurface_353, partCurve_331);
  }

  private void execute3() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Scene scene_1 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 2");

    PartDisplayer partDisplayer_7 = 
      ((PartDisplayer) scene_1.getDisplayerManager().getObject("rods"));

    PartRepresentation partRepresentation_0 = 
      ((PartRepresentation) simulation_0.getRepresentationManager().getObject("Geometry"));

    partDisplayer_7.setRepresentation(partRepresentation_0);

    CurrentView currentView_0 = 
      scene_1.getCurrentView();

    currentView_0.setInput(new DoubleVector(new double[] {1.3887331545993051, 0.769562916894998, 0.7614088185598851}), new DoubleVector(new double[] {4.765932249315707, 3.1812772826564175, 2.5371196147705737}), new DoubleVector(new double[] {-0.20531272848552118, -0.37737168320920605, 0.9030156677675713}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.4524067700462927, 0.10423457480776974, 0.2726677798577285}), new DoubleVector(new double[] {4.090061873321499, 3.5962178026216254, 3.1485151757235728}), new DoubleVector(new double[] {-0.2688196173028339, -0.4298391621456298, 0.8619595744808075}), 1.5102818616783267, 0, 30.0);

    partDisplayer_7.getInputParts().setQuery(null);

    SolidModelCompositePart solidModelCompositePart_0 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("C_FRONTWING"));

    CompositePart compositePart_0 = 
      ((CompositePart) solidModelCompositePart_0.getChildParts().getPart("A_F000_FRONTWING_ASM"));

    CompositePart compositePart_27 = 
      ((CompositePart) compositePart_0.getChildParts().getPart("A_FA00_FRONTWING_ATTACHMENT"));

    CompositePart compositePart_30 = 
      ((CompositePart) compositePart_27.getChildParts().getPart("A_FA01_ATTACHMENT_A"));

    CompositePart compositePart_29 = 
      ((CompositePart) compositePart_30.getChildParts().getPart("A_FA01_INSERT_BOTTOM"));

    CadPart cadPart_147 = 
      ((CadPart) compositePart_29.getChildParts().getPart("A_FA01_INSERT_BOTTOM_Body"));

    PartSurface partSurface_149 = 
      ((PartSurface) cadPart_147.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_147 = 
      ((PartCurve) cadPart_147.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_31 = 
      ((CompositePart) compositePart_30.getChildParts().getPart("A_FA01_INSERT_TOP"));

    CadPart cadPart_148 = 
      ((CadPart) compositePart_31.getChildParts().getPart("A_FA01_INSERT_TOP_Body"));

    PartSurface partSurface_150 = 
      ((PartSurface) cadPart_148.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_148 = 
      ((PartCurve) cadPart_148.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_149 = 
      ((CadPart) compositePart_30.getChildParts().getPart("A_FA01_MONO_BRACKET"));

    PartSurface partSurface_151 = 
      ((PartSurface) cadPart_149.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_149 = 
      ((PartCurve) cadPart_149.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_150 = 
      ((CadPart) compositePart_30.getChildParts().getPart("A_FA01_ROD"));

    PartSurface partSurface_152 = 
      ((PartSurface) cadPart_150.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_150 = 
      ((PartCurve) cadPart_150.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_151 = 
      ((CadPart) compositePart_30.getChildParts().getPart("A_FA01_WING_BRACKET"));

    PartSurface partSurface_153 = 
      ((PartSurface) cadPart_151.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_151 = 
      ((PartCurve) cadPart_151.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_152 = 
      ((CadPart) compositePart_30.getChildParts().getPart("A_FA01_WING_BRACKET_B"));

    PartSurface partSurface_154 = 
      ((PartSurface) cadPart_152.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_152 = 
      ((PartCurve) cadPart_152.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_32 = 
      ((CompositePart) compositePart_30.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5"));

    CadPart cadPart_153 = 
      ((CadPart) compositePart_32.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_155 = 
      ((PartSurface) cadPart_153.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_156 = 
      ((PartSurface) cadPart_153.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_153 = 
      ((PartCurve) cadPart_153.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_33 = 
      ((CompositePart) compositePart_30.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5 2"));

    CadPart cadPart_154 = 
      ((CadPart) compositePart_33.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_157 = 
      ((PartSurface) cadPart_154.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_158 = 
      ((PartSurface) cadPart_154.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_154 = 
      ((PartCurve) cadPart_154.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_155 = 
      ((CadPart) compositePart_30.getChildParts().getPart("ASKUBAL_BALL_M5"));

    PartSurface partSurface_159 = 
      ((PartSurface) cadPart_155.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_155 = 
      ((PartCurve) cadPart_155.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_156 = 
      ((CadPart) compositePart_30.getChildParts().getPart("D125B_5_3"));

    PartSurface partSurface_160 = 
      ((PartSurface) cadPart_156.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_156 = 
      ((PartCurve) cadPart_156.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_34 = 
      ((CompositePart) compositePart_30.getChildParts().getPart("D439_M5"));

    CadPart cadPart_157 = 
      ((CadPart) compositePart_34.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_161 = 
      ((PartSurface) cadPart_157.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_157 = 
      ((PartCurve) cadPart_157.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_35 = 
      ((CompositePart) compositePart_30.getChildParts().getPart("D439_M5 2"));

    CadPart cadPart_158 = 
      ((CadPart) compositePart_35.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_162 = 
      ((PartSurface) cadPart_158.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_158 = 
      ((PartCurve) cadPart_158.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_36 = 
      ((CompositePart) compositePart_30.getChildParts().getPart("DIN985_M5"));

    CadPart cadPart_159 = 
      ((CadPart) compositePart_36.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_163 = 
      ((PartSurface) cadPart_159.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_159 = 
      ((PartCurve) cadPart_159.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_37 = 
      ((CompositePart) compositePart_30.getChildParts().getPart("DIN985_M5 2"));

    CadPart cadPart_160 = 
      ((CadPart) compositePart_37.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_164 = 
      ((PartSurface) cadPart_160.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_160 = 
      ((PartCurve) cadPart_160.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_161 = 
      ((CadPart) compositePart_30.getChildParts().getPart("DIN7985TX_M4X30"));

    PartSurface partSurface_165 = 
      ((PartSurface) cadPart_161.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_161 = 
      ((PartCurve) cadPart_161.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_162 = 
      ((CadPart) compositePart_30.getChildParts().getPart("DIN7985TX_M5X20"));

    PartSurface partSurface_166 = 
      ((PartSurface) cadPart_162.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_162 = 
      ((PartCurve) cadPart_162.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_38 = 
      ((CompositePart) compositePart_27.getChildParts().getPart("A_FA01_ATTACHMENT_A_MIR"));

    CadPart cadPart_163 = 
      ((CadPart) compositePart_38.getChildParts().getPart("A_FA01_INSERT_BOTTOM_MIR"));

    PartSurface partSurface_167 = 
      ((PartSurface) cadPart_163.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_163 = 
      ((PartCurve) cadPart_163.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_39 = 
      ((CompositePart) compositePart_38.getChildParts().getPart("A_FA01_INSERT_TOP_MIR"));

    CadPart cadPart_164 = 
      ((CadPart) compositePart_39.getChildParts().getPart("A_FA01_INSERT_TOP_MIR_Body"));

    PartSurface partSurface_168 = 
      ((PartSurface) cadPart_164.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_164 = 
      ((PartCurve) cadPart_164.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_165 = 
      ((CadPart) compositePart_38.getChildParts().getPart("A_FA01_MONO_BRACKET_MIR"));

    PartSurface partSurface_169 = 
      ((PartSurface) cadPart_165.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_165 = 
      ((PartCurve) cadPart_165.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_166 = 
      ((CadPart) compositePart_38.getChildParts().getPart("A_FA01_ROD_MIR"));

    PartSurface partSurface_170 = 
      ((PartSurface) cadPart_166.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_166 = 
      ((PartCurve) cadPart_166.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_167 = 
      ((CadPart) compositePart_38.getChildParts().getPart("A_FA01_WING_BRACKET_B_MIR"));

    PartSurface partSurface_171 = 
      ((PartSurface) cadPart_167.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_167 = 
      ((PartCurve) cadPart_167.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_168 = 
      ((CadPart) compositePart_38.getChildParts().getPart("A_FA01_WING_BRACKET_MIR"));

    PartSurface partSurface_172 = 
      ((PartSurface) cadPart_168.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_168 = 
      ((PartCurve) cadPart_168.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_40 = 
      ((CompositePart) compositePart_38.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5"));

    CadPart cadPart_169 = 
      ((CadPart) compositePart_40.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_173 = 
      ((PartSurface) cadPart_169.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_174 = 
      ((PartSurface) cadPart_169.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_169 = 
      ((PartCurve) cadPart_169.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_41 = 
      ((CompositePart) compositePart_38.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5 2"));

    CadPart cadPart_170 = 
      ((CadPart) compositePart_41.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_175 = 
      ((PartSurface) cadPart_170.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_176 = 
      ((PartSurface) cadPart_170.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_170 = 
      ((PartCurve) cadPart_170.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_171 = 
      ((CadPart) compositePart_38.getChildParts().getPart("ASKUBAL_BALL_M5"));

    PartSurface partSurface_177 = 
      ((PartSurface) cadPart_171.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_171 = 
      ((PartCurve) cadPart_171.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_172 = 
      ((CadPart) compositePart_38.getChildParts().getPart("D125B_5_3"));

    PartSurface partSurface_178 = 
      ((PartSurface) cadPart_172.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_172 = 
      ((PartCurve) cadPart_172.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_42 = 
      ((CompositePart) compositePart_38.getChildParts().getPart("D439_M5"));

    CadPart cadPart_173 = 
      ((CadPart) compositePart_42.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_179 = 
      ((PartSurface) cadPart_173.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_173 = 
      ((PartCurve) cadPart_173.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_43 = 
      ((CompositePart) compositePart_38.getChildParts().getPart("D439_M5 2"));

    CadPart cadPart_174 = 
      ((CadPart) compositePart_43.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_180 = 
      ((PartSurface) cadPart_174.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_174 = 
      ((PartCurve) cadPart_174.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_44 = 
      ((CompositePart) compositePart_38.getChildParts().getPart("DIN985_M5"));

    CadPart cadPart_175 = 
      ((CadPart) compositePart_44.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_181 = 
      ((PartSurface) cadPart_175.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_175 = 
      ((PartCurve) cadPart_175.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_45 = 
      ((CompositePart) compositePart_38.getChildParts().getPart("DIN985_M5 2"));

    CadPart cadPart_176 = 
      ((CadPart) compositePart_45.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_182 = 
      ((PartSurface) cadPart_176.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_176 = 
      ((PartCurve) cadPart_176.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_177 = 
      ((CadPart) compositePart_38.getChildParts().getPart("DIN7985TX_M4X30"));

    PartSurface partSurface_183 = 
      ((PartSurface) cadPart_177.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_177 = 
      ((PartCurve) cadPart_177.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_178 = 
      ((CadPart) compositePart_38.getChildParts().getPart("DIN7985TX_M5X20"));

    PartSurface partSurface_184 = 
      ((PartSurface) cadPart_178.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_178 = 
      ((PartCurve) cadPart_178.getPartCurveManager().getPartCurve("Edges"));

    SolidModelCompositePart solidModelCompositePart_1 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("C_REARWING"));

    CompositePart compositePart_4 = 
      ((CompositePart) solidModelCompositePart_1.getChildParts().getPart("A_R000_REARWING_ASM"));

    CompositePart compositePart_47 = 
      ((CompositePart) compositePart_4.getChildParts().getPart("A_RA00_REARWING_ATTACHMENTS"));

    CompositePart compositePart_46 = 
      ((CompositePart) compositePart_47.getChildParts().getPart("A_RA01_RW_ATTACHMENT_A"));

    CadPart cadPart_179 = 
      ((CadPart) compositePart_46.getChildParts().getPart("A_RA01_ENDPLATE_BRACKET"));

    PartSurface partSurface_185 = 
      ((PartSurface) cadPart_179.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_179 = 
      ((PartCurve) cadPart_179.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_48 = 
      ((CompositePart) compositePart_46.getChildParts().getPart("A_RA01_INSERT_ROD_BOTTOM"));

    CadPart cadPart_180 = 
      ((CadPart) compositePart_48.getChildParts().getPart("A_RA01_INSERT_ROD_BOTTOM_Body"));

    PartSurface partSurface_186 = 
      ((PartSurface) cadPart_180.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_180 = 
      ((PartCurve) cadPart_180.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_49 = 
      ((CompositePart) compositePart_46.getChildParts().getPart("A_RA01_INSERT_ROD_TOP"));

    CadPart cadPart_181 = 
      ((CadPart) compositePart_49.getChildParts().getPart("A_RA01_INSERT_ROD_TOP_Body"));

    PartSurface partSurface_187 = 
      ((PartSurface) cadPart_181.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_181 = 
      ((PartCurve) cadPart_181.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_182 = 
      ((CadPart) compositePart_46.getChildParts().getPart("A_RA01_MAIN_HOOP_BRACKET"));

    PartSurface partSurface_188 = 
      ((PartSurface) cadPart_182.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_182 = 
      ((PartCurve) cadPart_182.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_183 = 
      ((CadPart) compositePart_46.getChildParts().getPart("A_RA01_ROD"));

    PartSurface partSurface_189 = 
      ((PartSurface) cadPart_183.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_183 = 
      ((PartCurve) cadPart_183.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_50 = 
      ((CompositePart) compositePart_46.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5"));

    CadPart cadPart_184 = 
      ((CadPart) compositePart_50.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_190 = 
      ((PartSurface) cadPart_184.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_191 = 
      ((PartSurface) cadPart_184.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_184 = 
      ((PartCurve) cadPart_184.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_51 = 
      ((CompositePart) compositePart_46.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5 2"));

    CadPart cadPart_185 = 
      ((CadPart) compositePart_51.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_192 = 
      ((PartSurface) cadPart_185.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_193 = 
      ((PartSurface) cadPart_185.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_185 = 
      ((PartCurve) cadPart_185.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_186 = 
      ((CadPart) compositePart_46.getChildParts().getPart("ASKUBAL_BALL_M5"));

    PartSurface partSurface_194 = 
      ((PartSurface) cadPart_186.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_186 = 
      ((PartCurve) cadPart_186.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_187 = 
      ((CadPart) compositePart_46.getChildParts().getPart("D125B_5_3"));

    PartSurface partSurface_195 = 
      ((PartSurface) cadPart_187.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_187 = 
      ((PartCurve) cadPart_187.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_52 = 
      ((CompositePart) compositePart_46.getChildParts().getPart("D439_M5"));

    CadPart cadPart_188 = 
      ((CadPart) compositePart_52.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_196 = 
      ((PartSurface) cadPart_188.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_188 = 
      ((PartCurve) cadPart_188.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_53 = 
      ((CompositePart) compositePart_46.getChildParts().getPart("D439_M5 2"));

    CadPart cadPart_189 = 
      ((CadPart) compositePart_53.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_197 = 
      ((PartSurface) cadPart_189.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_189 = 
      ((PartCurve) cadPart_189.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_54 = 
      ((CompositePart) compositePart_46.getChildParts().getPart("DIN985_M5"));

    CadPart cadPart_190 = 
      ((CadPart) compositePart_54.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_198 = 
      ((PartSurface) cadPart_190.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_190 = 
      ((PartCurve) cadPart_190.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_55 = 
      ((CompositePart) compositePart_46.getChildParts().getPart("DIN985_M5 2"));

    CadPart cadPart_191 = 
      ((CadPart) compositePart_55.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_199 = 
      ((PartSurface) cadPart_191.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_191 = 
      ((PartCurve) cadPart_191.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_192 = 
      ((CadPart) compositePart_46.getChildParts().getPart("DIN7985TX_M4X10"));

    PartSurface partSurface_200 = 
      ((PartSurface) cadPart_192.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_192 = 
      ((PartCurve) cadPart_192.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_193 = 
      ((CadPart) compositePart_46.getChildParts().getPart("DIN7985TX_M5X25"));

    PartSurface partSurface_201 = 
      ((PartSurface) cadPart_193.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_193 = 
      ((PartCurve) cadPart_193.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_56 = 
      ((CompositePart) compositePart_47.getChildParts().getPart("A_RA01_RW_ATTACHMENT_A_MIR"));

    CadPart cadPart_194 = 
      ((CadPart) compositePart_56.getChildParts().getPart("A_RA01_ENDPLATE_BRACKET_MIR"));

    PartSurface partSurface_202 = 
      ((PartSurface) cadPart_194.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_194 = 
      ((PartCurve) cadPart_194.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_195 = 
      ((CadPart) compositePart_56.getChildParts().getPart("A_RA01_INSERT_ROD_BOTTOM_MIR"));

    PartSurface partSurface_203 = 
      ((PartSurface) cadPart_195.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_195 = 
      ((PartCurve) cadPart_195.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_196 = 
      ((CadPart) compositePart_56.getChildParts().getPart("A_RA01_INSERT_ROD_TOP_MIR"));

    PartSurface partSurface_204 = 
      ((PartSurface) cadPart_196.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_196 = 
      ((PartCurve) cadPart_196.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_197 = 
      ((CadPart) compositePart_56.getChildParts().getPart("A_RA01_MAIN_HOOP_BRACKET_MIR"));

    PartSurface partSurface_205 = 
      ((PartSurface) cadPart_197.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_197 = 
      ((PartCurve) cadPart_197.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_198 = 
      ((CadPart) compositePart_56.getChildParts().getPart("A_RA01_ROD_MIR"));

    PartSurface partSurface_206 = 
      ((PartSurface) cadPart_198.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_198 = 
      ((PartCurve) cadPart_198.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_57 = 
      ((CompositePart) compositePart_56.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5"));

    CadPart cadPart_199 = 
      ((CadPart) compositePart_57.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_207 = 
      ((PartSurface) cadPart_199.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_208 = 
      ((PartSurface) cadPart_199.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_199 = 
      ((PartCurve) cadPart_199.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_58 = 
      ((CompositePart) compositePart_56.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5 2"));

    CadPart cadPart_200 = 
      ((CadPart) compositePart_58.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_209 = 
      ((PartSurface) cadPart_200.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_210 = 
      ((PartSurface) cadPart_200.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_200 = 
      ((PartCurve) cadPart_200.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_201 = 
      ((CadPart) compositePart_56.getChildParts().getPart("ASKUBAL_BALL_M5"));

    PartSurface partSurface_211 = 
      ((PartSurface) cadPart_201.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_201 = 
      ((PartCurve) cadPart_201.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_202 = 
      ((CadPart) compositePart_56.getChildParts().getPart("D125B_5_3"));

    PartSurface partSurface_212 = 
      ((PartSurface) cadPart_202.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_202 = 
      ((PartCurve) cadPart_202.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_59 = 
      ((CompositePart) compositePart_56.getChildParts().getPart("D439_M5"));

    CadPart cadPart_203 = 
      ((CadPart) compositePart_59.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_213 = 
      ((PartSurface) cadPart_203.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_203 = 
      ((PartCurve) cadPart_203.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_60 = 
      ((CompositePart) compositePart_56.getChildParts().getPart("D439_M5 2"));

    CadPart cadPart_204 = 
      ((CadPart) compositePart_60.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_214 = 
      ((PartSurface) cadPart_204.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_204 = 
      ((PartCurve) cadPart_204.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_61 = 
      ((CompositePart) compositePart_56.getChildParts().getPart("DIN985_M5"));

    CadPart cadPart_205 = 
      ((CadPart) compositePart_61.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_215 = 
      ((PartSurface) cadPart_205.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_205 = 
      ((PartCurve) cadPart_205.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_206 = 
      ((CadPart) compositePart_56.getChildParts().getPart("DIN7985TX_M4X10"));

    PartSurface partSurface_216 = 
      ((PartSurface) cadPart_206.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_206 = 
      ((PartCurve) cadPart_206.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_207 = 
      ((CadPart) compositePart_56.getChildParts().getPart("DIN7985TX_M5X25"));

    PartSurface partSurface_217 = 
      ((PartSurface) cadPart_207.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_207 = 
      ((PartCurve) cadPart_207.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_62 = 
      ((CompositePart) compositePart_47.getChildParts().getPart("A_RA02_RW_ATTACHMENT_B"));

    CadPart cadPart_208 = 
      ((CadPart) compositePart_62.getChildParts().getPart("A_RA02_ENDPLATE_BRACKET"));

    PartSurface partSurface_218 = 
      ((PartSurface) cadPart_208.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_208 = 
      ((PartCurve) cadPart_208.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_209 = 
      ((CadPart) compositePart_62.getChildParts().getPart("A_RA02_INSERT_ROD_BOTTOM"));

    PartSurface partSurface_219 = 
      ((PartSurface) cadPart_209.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_209 = 
      ((PartCurve) cadPart_209.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_210 = 
      ((CadPart) compositePart_62.getChildParts().getPart("A_RA02_INSERT_ROD_TOP"));

    PartSurface partSurface_220 = 
      ((PartSurface) cadPart_210.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_210 = 
      ((PartCurve) cadPart_210.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_211 = 
      ((CadPart) compositePart_62.getChildParts().getPart("A_RA02_MONO_BRACKET"));

    PartSurface partSurface_221 = 
      ((PartSurface) cadPart_211.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_211 = 
      ((PartCurve) cadPart_211.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_212 = 
      ((CadPart) compositePart_62.getChildParts().getPart("A_RA02_ROD"));

    PartSurface partSurface_222 = 
      ((PartSurface) cadPart_212.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_212 = 
      ((PartCurve) cadPart_212.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_63 = 
      ((CompositePart) compositePart_62.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5"));

    CadPart cadPart_213 = 
      ((CadPart) compositePart_63.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_223 = 
      ((PartSurface) cadPart_213.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_224 = 
      ((PartSurface) cadPart_213.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_213 = 
      ((PartCurve) cadPart_213.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_64 = 
      ((CompositePart) compositePart_62.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5 2"));

    CadPart cadPart_214 = 
      ((CadPart) compositePart_64.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_225 = 
      ((PartSurface) cadPart_214.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_226 = 
      ((PartSurface) cadPart_214.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_214 = 
      ((PartCurve) cadPart_214.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_215 = 
      ((CadPart) compositePart_62.getChildParts().getPart("ASKUBAL_BALL_M5"));

    PartSurface partSurface_227 = 
      ((PartSurface) cadPart_215.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_215 = 
      ((PartCurve) cadPart_215.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_216 = 
      ((CadPart) compositePart_62.getChildParts().getPart("D125B_5_3"));

    PartSurface partSurface_228 = 
      ((PartSurface) cadPart_216.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_216 = 
      ((PartCurve) cadPart_216.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_65 = 
      ((CompositePart) compositePart_62.getChildParts().getPart("D439_M5"));

    CadPart cadPart_217 = 
      ((CadPart) compositePart_65.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_229 = 
      ((PartSurface) cadPart_217.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_217 = 
      ((PartCurve) cadPart_217.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_66 = 
      ((CompositePart) compositePart_62.getChildParts().getPart("D439_M5 2"));

    CadPart cadPart_218 = 
      ((CadPart) compositePart_66.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_230 = 
      ((PartSurface) cadPart_218.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_218 = 
      ((PartCurve) cadPart_218.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_67 = 
      ((CompositePart) compositePart_62.getChildParts().getPart("DIN985_M5"));

    CadPart cadPart_219 = 
      ((CadPart) compositePart_67.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_231 = 
      ((PartSurface) cadPart_219.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_219 = 
      ((PartCurve) cadPart_219.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_68 = 
      ((CompositePart) compositePart_62.getChildParts().getPart("DIN985_M5 2"));

    CadPart cadPart_220 = 
      ((CadPart) compositePart_68.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_232 = 
      ((PartSurface) cadPart_220.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_220 = 
      ((PartCurve) cadPart_220.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_221 = 
      ((CadPart) compositePart_62.getChildParts().getPart("DIN7985TX_M4X10"));

    PartSurface partSurface_233 = 
      ((PartSurface) cadPart_221.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_221 = 
      ((PartCurve) cadPart_221.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_222 = 
      ((CadPart) compositePart_62.getChildParts().getPart("DIN7985TX_M4X20"));

    PartSurface partSurface_234 = 
      ((PartSurface) cadPart_222.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_222 = 
      ((PartCurve) cadPart_222.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_223 = 
      ((CadPart) compositePart_62.getChildParts().getPart("DIN7985TX_M5X25"));

    PartSurface partSurface_235 = 
      ((PartSurface) cadPart_223.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_223 = 
      ((PartCurve) cadPart_223.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_69 = 
      ((CompositePart) compositePart_47.getChildParts().getPart("A_RA02_RW_ATTACHMENT_B_MIR"));

    CadPart cadPart_224 = 
      ((CadPart) compositePart_69.getChildParts().getPart("A_RA02_ENDPLATE_BRACKET_MIR"));

    PartSurface partSurface_236 = 
      ((PartSurface) cadPart_224.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_224 = 
      ((PartCurve) cadPart_224.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_225 = 
      ((CadPart) compositePart_69.getChildParts().getPart("A_RA02_INSERT_ROD_BOTTOM_MIR"));

    PartSurface partSurface_237 = 
      ((PartSurface) cadPart_225.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_225 = 
      ((PartCurve) cadPart_225.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_226 = 
      ((CadPart) compositePart_69.getChildParts().getPart("A_RA02_INSERT_ROD_TOP_MIR"));

    PartSurface partSurface_238 = 
      ((PartSurface) cadPart_226.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_226 = 
      ((PartCurve) cadPart_226.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_227 = 
      ((CadPart) compositePart_69.getChildParts().getPart("A_RA02_MONO_BRACKET_MIR"));

    PartSurface partSurface_239 = 
      ((PartSurface) cadPart_227.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_227 = 
      ((PartCurve) cadPart_227.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_228 = 
      ((CadPart) compositePart_69.getChildParts().getPart("A_RA02_ROD_MIR"));

    PartSurface partSurface_240 = 
      ((PartSurface) cadPart_228.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_228 = 
      ((PartCurve) cadPart_228.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_70 = 
      ((CompositePart) compositePart_69.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5"));

    CadPart cadPart_229 = 
      ((CadPart) compositePart_70.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_241 = 
      ((PartSurface) cadPart_229.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_242 = 
      ((PartSurface) cadPart_229.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_229 = 
      ((PartCurve) cadPart_229.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_71 = 
      ((CompositePart) compositePart_69.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5 2"));

    CadPart cadPart_230 = 
      ((CadPart) compositePart_71.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_243 = 
      ((PartSurface) cadPart_230.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_244 = 
      ((PartSurface) cadPart_230.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_230 = 
      ((PartCurve) cadPart_230.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_231 = 
      ((CadPart) compositePart_69.getChildParts().getPart("ASKUBAL_BALL_M5"));

    PartSurface partSurface_245 = 
      ((PartSurface) cadPart_231.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_231 = 
      ((PartCurve) cadPart_231.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_232 = 
      ((CadPart) compositePart_69.getChildParts().getPart("D125B_5_3"));

    PartSurface partSurface_246 = 
      ((PartSurface) cadPart_232.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_232 = 
      ((PartCurve) cadPart_232.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_72 = 
      ((CompositePart) compositePart_69.getChildParts().getPart("D439_M5"));

    CadPart cadPart_233 = 
      ((CadPart) compositePart_72.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_247 = 
      ((PartSurface) cadPart_233.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_233 = 
      ((PartCurve) cadPart_233.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_73 = 
      ((CompositePart) compositePart_69.getChildParts().getPart("D439_M5 2"));

    CadPart cadPart_234 = 
      ((CadPart) compositePart_73.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_248 = 
      ((PartSurface) cadPart_234.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_234 = 
      ((PartCurve) cadPart_234.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_74 = 
      ((CompositePart) compositePart_69.getChildParts().getPart("DIN985_M5"));

    CadPart cadPart_235 = 
      ((CadPart) compositePart_74.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_249 = 
      ((PartSurface) cadPart_235.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_235 = 
      ((PartCurve) cadPart_235.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_75 = 
      ((CompositePart) compositePart_69.getChildParts().getPart("DIN985_M5 2"));

    CadPart cadPart_236 = 
      ((CadPart) compositePart_75.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_250 = 
      ((PartSurface) cadPart_236.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_236 = 
      ((PartCurve) cadPart_236.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_237 = 
      ((CadPart) compositePart_69.getChildParts().getPart("DIN7985TX_M4X10"));

    PartSurface partSurface_251 = 
      ((PartSurface) cadPart_237.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_237 = 
      ((PartCurve) cadPart_237.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_238 = 
      ((CadPart) compositePart_69.getChildParts().getPart("DIN7985TX_M4X20"));

    PartSurface partSurface_252 = 
      ((PartSurface) cadPart_238.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_238 = 
      ((PartCurve) cadPart_238.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_239 = 
      ((CadPart) compositePart_69.getChildParts().getPart("DIN7985TX_M5X25"));

    PartSurface partSurface_253 = 
      ((PartSurface) cadPart_239.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_239 = 
      ((PartCurve) cadPart_239.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_76 = 
      ((CompositePart) compositePart_47.getChildParts().getPart("A_RA03_RW_ATTACHMENT_C"));

    CadPart cadPart_240 = 
      ((CadPart) compositePart_76.getChildParts().getPart("A_RA03_ENDPLATE_BRACKET"));

    PartSurface partSurface_254 = 
      ((PartSurface) cadPart_240.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_240 = 
      ((PartCurve) cadPart_240.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_241 = 
      ((CadPart) compositePart_76.getChildParts().getPart("A_RA03_INSERT_ROD_BOTTOM"));

    PartSurface partSurface_255 = 
      ((PartSurface) cadPart_241.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_241 = 
      ((PartCurve) cadPart_241.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_242 = 
      ((CadPart) compositePart_76.getChildParts().getPart("A_RA03_INSERT_ROD_TOP"));

    PartSurface partSurface_256 = 
      ((PartSurface) cadPart_242.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_242 = 
      ((PartCurve) cadPart_242.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_243 = 
      ((CadPart) compositePart_76.getChildParts().getPart("A_RA03_MONO_BRACKET_TYPE_A"));

    PartSurface partSurface_257 = 
      ((PartSurface) cadPart_243.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_243 = 
      ((PartCurve) cadPart_243.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_244 = 
      ((CadPart) compositePart_76.getChildParts().getPart("A_RA03_ROD"));

    PartSurface partSurface_258 = 
      ((PartSurface) cadPart_244.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_244 = 
      ((PartCurve) cadPart_244.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_77 = 
      ((CompositePart) compositePart_76.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5"));

    CadPart cadPart_245 = 
      ((CadPart) compositePart_77.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_259 = 
      ((PartSurface) cadPart_245.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_260 = 
      ((PartSurface) cadPart_245.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_245 = 
      ((PartCurve) cadPart_245.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_78 = 
      ((CompositePart) compositePart_76.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5 2"));

    CadPart cadPart_246 = 
      ((CadPart) compositePart_78.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_261 = 
      ((PartSurface) cadPart_246.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_262 = 
      ((PartSurface) cadPart_246.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_246 = 
      ((PartCurve) cadPart_246.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_247 = 
      ((CadPart) compositePart_76.getChildParts().getPart("ASKUBAL_BALL_M5"));

    PartSurface partSurface_263 = 
      ((PartSurface) cadPart_247.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_247 = 
      ((PartCurve) cadPart_247.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_248 = 
      ((CadPart) compositePart_76.getChildParts().getPart("D125B_5_3"));

    PartSurface partSurface_264 = 
      ((PartSurface) cadPart_248.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_248 = 
      ((PartCurve) cadPart_248.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_79 = 
      ((CompositePart) compositePart_76.getChildParts().getPart("D439_M5"));

    CadPart cadPart_249 = 
      ((CadPart) compositePart_79.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_265 = 
      ((PartSurface) cadPart_249.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_249 = 
      ((PartCurve) cadPart_249.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_80 = 
      ((CompositePart) compositePart_76.getChildParts().getPart("D439_M5 2"));

    CadPart cadPart_250 = 
      ((CadPart) compositePart_80.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_266 = 
      ((PartSurface) cadPart_250.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_250 = 
      ((PartCurve) cadPart_250.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_81 = 
      ((CompositePart) compositePart_76.getChildParts().getPart("DIN985_M5"));

    CadPart cadPart_251 = 
      ((CadPart) compositePart_81.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_267 = 
      ((PartSurface) cadPart_251.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_251 = 
      ((PartCurve) cadPart_251.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_82 = 
      ((CompositePart) compositePart_76.getChildParts().getPart("DIN985_M5 2"));

    CadPart cadPart_252 = 
      ((CadPart) compositePart_82.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_268 = 
      ((PartSurface) cadPart_252.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_252 = 
      ((PartCurve) cadPart_252.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_253 = 
      ((CadPart) compositePart_76.getChildParts().getPart("DIN7985TX_M4X10"));

    PartSurface partSurface_269 = 
      ((PartSurface) cadPart_253.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_253 = 
      ((PartCurve) cadPart_253.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_254 = 
      ((CadPart) compositePart_76.getChildParts().getPart("DIN7985TX_M4X30"));

    PartSurface partSurface_270 = 
      ((PartSurface) cadPart_254.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_254 = 
      ((PartCurve) cadPart_254.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_255 = 
      ((CadPart) compositePart_76.getChildParts().getPart("DIN7985TX_M5X25"));

    PartSurface partSurface_271 = 
      ((PartSurface) cadPart_255.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_255 = 
      ((PartCurve) cadPart_255.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_83 = 
      ((CompositePart) compositePart_47.getChildParts().getPart("A_RA03_RW_ATTACHMENT_C_MIR"));

    CadPart cadPart_256 = 
      ((CadPart) compositePart_83.getChildParts().getPart("A_RA03_ENDPLATE_BRACKET_MIR"));

    PartSurface partSurface_272 = 
      ((PartSurface) cadPart_256.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_256 = 
      ((PartCurve) cadPart_256.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_257 = 
      ((CadPart) compositePart_83.getChildParts().getPart("A_RA03_INSERT_ROD_BOTTOM_MIR"));

    PartSurface partSurface_273 = 
      ((PartSurface) cadPart_257.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_257 = 
      ((PartCurve) cadPart_257.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_258 = 
      ((CadPart) compositePart_83.getChildParts().getPart("A_RA03_INSERT_ROD_TOP_MIR"));

    PartSurface partSurface_274 = 
      ((PartSurface) cadPart_258.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_258 = 
      ((PartCurve) cadPart_258.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_259 = 
      ((CadPart) compositePart_83.getChildParts().getPart("A_RA03_MONO_BRACKET_TYPE_A_MIR"));

    PartSurface partSurface_275 = 
      ((PartSurface) cadPart_259.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_259 = 
      ((PartCurve) cadPart_259.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_260 = 
      ((CadPart) compositePart_83.getChildParts().getPart("A_RA03_ROD_MIR"));

    PartSurface partSurface_276 = 
      ((PartSurface) cadPart_260.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_260 = 
      ((PartCurve) cadPart_260.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_84 = 
      ((CompositePart) compositePart_83.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5"));

    CadPart cadPart_261 = 
      ((CadPart) compositePart_84.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_277 = 
      ((PartSurface) cadPart_261.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_278 = 
      ((PartSurface) cadPart_261.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_261 = 
      ((PartCurve) cadPart_261.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_85 = 
      ((CompositePart) compositePart_83.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5 2"));

    CadPart cadPart_262 = 
      ((CadPart) compositePart_85.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_279 = 
      ((PartSurface) cadPart_262.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_280 = 
      ((PartSurface) cadPart_262.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_262 = 
      ((PartCurve) cadPart_262.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_263 = 
      ((CadPart) compositePart_83.getChildParts().getPart("ASKUBAL_BALL_M5"));

    PartSurface partSurface_281 = 
      ((PartSurface) cadPart_263.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_263 = 
      ((PartCurve) cadPart_263.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_264 = 
      ((CadPart) compositePart_83.getChildParts().getPart("D125B_5_3"));

    PartSurface partSurface_282 = 
      ((PartSurface) cadPart_264.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_264 = 
      ((PartCurve) cadPart_264.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_86 = 
      ((CompositePart) compositePart_83.getChildParts().getPart("D439_M5"));

    CadPart cadPart_265 = 
      ((CadPart) compositePart_86.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_283 = 
      ((PartSurface) cadPart_265.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_265 = 
      ((PartCurve) cadPart_265.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_87 = 
      ((CompositePart) compositePart_83.getChildParts().getPart("D439_M5 2"));

    CadPart cadPart_266 = 
      ((CadPart) compositePart_87.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_284 = 
      ((PartSurface) cadPart_266.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_266 = 
      ((PartCurve) cadPart_266.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_88 = 
      ((CompositePart) compositePart_83.getChildParts().getPart("DIN985_M5"));

    CadPart cadPart_267 = 
      ((CadPart) compositePart_88.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_285 = 
      ((PartSurface) cadPart_267.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_267 = 
      ((PartCurve) cadPart_267.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_89 = 
      ((CompositePart) compositePart_83.getChildParts().getPart("DIN985_M5 2"));

    CadPart cadPart_268 = 
      ((CadPart) compositePart_89.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_286 = 
      ((PartSurface) cadPart_268.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_268 = 
      ((PartCurve) cadPart_268.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_269 = 
      ((CadPart) compositePart_83.getChildParts().getPart("DIN7985TX_M4X10"));

    PartSurface partSurface_287 = 
      ((PartSurface) cadPart_269.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_269 = 
      ((PartCurve) cadPart_269.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_270 = 
      ((CadPart) compositePart_83.getChildParts().getPart("DIN7985TX_M4X30"));

    PartSurface partSurface_288 = 
      ((PartSurface) cadPart_270.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_270 = 
      ((PartCurve) cadPart_270.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_271 = 
      ((CadPart) compositePart_83.getChildParts().getPart("DIN7985TX_M5X25"));

    PartSurface partSurface_289 = 
      ((PartSurface) cadPart_271.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_271 = 
      ((PartCurve) cadPart_271.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_90 = 
      ((CompositePart) compositePart_47.getChildParts().getPart("A_RA04_RW_ATTACHMENT_D"));

    CadPart cadPart_272 = 
      ((CadPart) compositePart_90.getChildParts().getPart("A_RA04_ENDPLATE_BRACKET"));

    PartSurface partSurface_290 = 
      ((PartSurface) cadPart_272.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_272 = 
      ((PartCurve) cadPart_272.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_273 = 
      ((CadPart) compositePart_90.getChildParts().getPart("A_RA04_INSERT_ROD_BOTTOM"));

    PartSurface partSurface_291 = 
      ((PartSurface) cadPart_273.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_273 = 
      ((PartCurve) cadPart_273.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_274 = 
      ((CadPart) compositePart_90.getChildParts().getPart("A_RA04_INSERT_ROD_TOP"));

    PartSurface partSurface_292 = 
      ((PartSurface) cadPart_274.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_274 = 
      ((PartCurve) cadPart_274.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_275 = 
      ((CadPart) compositePart_90.getChildParts().getPart("A_RA04_MONO_BRACKET_TYPE_A"));

    PartSurface partSurface_293 = 
      ((PartSurface) cadPart_275.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_275 = 
      ((PartCurve) cadPart_275.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_276 = 
      ((CadPart) compositePart_90.getChildParts().getPart("A_RA04_ROD"));

    PartSurface partSurface_294 = 
      ((PartSurface) cadPart_276.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_276 = 
      ((PartCurve) cadPart_276.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_91 = 
      ((CompositePart) compositePart_90.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5"));

    CadPart cadPart_277 = 
      ((CadPart) compositePart_91.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_295 = 
      ((PartSurface) cadPart_277.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_296 = 
      ((PartSurface) cadPart_277.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_277 = 
      ((PartCurve) cadPart_277.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_92 = 
      ((CompositePart) compositePart_90.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5 2"));

    CadPart cadPart_278 = 
      ((CadPart) compositePart_92.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_297 = 
      ((PartSurface) cadPart_278.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_298 = 
      ((PartSurface) cadPart_278.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_278 = 
      ((PartCurve) cadPart_278.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_279 = 
      ((CadPart) compositePart_90.getChildParts().getPart("ASKUBAL_BALL_M5"));

    PartSurface partSurface_299 = 
      ((PartSurface) cadPart_279.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_279 = 
      ((PartCurve) cadPart_279.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_280 = 
      ((CadPart) compositePart_90.getChildParts().getPart("D125B_5_3"));

    PartSurface partSurface_300 = 
      ((PartSurface) cadPart_280.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_280 = 
      ((PartCurve) cadPart_280.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_93 = 
      ((CompositePart) compositePart_90.getChildParts().getPart("D439_M5"));

    CadPart cadPart_281 = 
      ((CadPart) compositePart_93.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_301 = 
      ((PartSurface) cadPart_281.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_281 = 
      ((PartCurve) cadPart_281.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_94 = 
      ((CompositePart) compositePart_90.getChildParts().getPart("D439_M5 2"));

    CadPart cadPart_282 = 
      ((CadPart) compositePart_94.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_302 = 
      ((PartSurface) cadPart_282.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_282 = 
      ((PartCurve) cadPart_282.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_95 = 
      ((CompositePart) compositePart_90.getChildParts().getPart("DIN985_M5"));

    CadPart cadPart_283 = 
      ((CadPart) compositePart_95.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_303 = 
      ((PartSurface) cadPart_283.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_283 = 
      ((PartCurve) cadPart_283.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_96 = 
      ((CompositePart) compositePart_90.getChildParts().getPart("DIN985_M5 2"));

    CadPart cadPart_284 = 
      ((CadPart) compositePart_96.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_304 = 
      ((PartSurface) cadPart_284.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_284 = 
      ((PartCurve) cadPart_284.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_285 = 
      ((CadPart) compositePart_90.getChildParts().getPart("DIN7985TX_M4X10"));

    PartSurface partSurface_305 = 
      ((PartSurface) cadPart_285.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_285 = 
      ((PartCurve) cadPart_285.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_286 = 
      ((CadPart) compositePart_90.getChildParts().getPart("DIN7985TX_M4X20"));

    PartSurface partSurface_306 = 
      ((PartSurface) cadPart_286.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_286 = 
      ((PartCurve) cadPart_286.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_287 = 
      ((CadPart) compositePart_90.getChildParts().getPart("DIN7985TX_M5X25"));

    PartSurface partSurface_307 = 
      ((PartSurface) cadPart_287.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_287 = 
      ((PartCurve) cadPart_287.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_97 = 
      ((CompositePart) compositePart_47.getChildParts().getPart("A_RA04_RW_ATTACHMENT_D_MIR"));

    CadPart cadPart_288 = 
      ((CadPart) compositePart_97.getChildParts().getPart("A_RA04_ENDPLATE_BRACKET_MIR"));

    PartSurface partSurface_308 = 
      ((PartSurface) cadPart_288.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_288 = 
      ((PartCurve) cadPart_288.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_289 = 
      ((CadPart) compositePart_97.getChildParts().getPart("A_RA04_INSERT_ROD_BOTTOM_MIR"));

    PartSurface partSurface_309 = 
      ((PartSurface) cadPart_289.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_289 = 
      ((PartCurve) cadPart_289.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_290 = 
      ((CadPart) compositePart_97.getChildParts().getPart("A_RA04_INSERT_ROD_TOP_MIR"));

    PartSurface partSurface_310 = 
      ((PartSurface) cadPart_290.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_290 = 
      ((PartCurve) cadPart_290.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_291 = 
      ((CadPart) compositePart_97.getChildParts().getPart("A_RA04_MONO_BRACKET_TYPE_A_MIR"));

    PartSurface partSurface_311 = 
      ((PartSurface) cadPart_291.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_291 = 
      ((PartCurve) cadPart_291.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_292 = 
      ((CadPart) compositePart_97.getChildParts().getPart("A_RA04_ROD_MIR"));

    PartSurface partSurface_312 = 
      ((PartSurface) cadPart_292.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_292 = 
      ((PartCurve) cadPart_292.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_98 = 
      ((CompositePart) compositePart_97.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5"));

    CadPart cadPart_293 = 
      ((CadPart) compositePart_98.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_313 = 
      ((PartSurface) cadPart_293.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_314 = 
      ((PartSurface) cadPart_293.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_293 = 
      ((PartCurve) cadPart_293.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_99 = 
      ((CompositePart) compositePart_97.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5 2"));

    CadPart cadPart_294 = 
      ((CadPart) compositePart_99.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_315 = 
      ((PartSurface) cadPart_294.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_316 = 
      ((PartSurface) cadPart_294.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_294 = 
      ((PartCurve) cadPart_294.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_295 = 
      ((CadPart) compositePart_97.getChildParts().getPart("ASKUBAL_BALL_M5"));

    PartSurface partSurface_317 = 
      ((PartSurface) cadPart_295.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_295 = 
      ((PartCurve) cadPart_295.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_296 = 
      ((CadPart) compositePart_97.getChildParts().getPart("D125B_5_3"));

    PartSurface partSurface_318 = 
      ((PartSurface) cadPart_296.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_296 = 
      ((PartCurve) cadPart_296.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_100 = 
      ((CompositePart) compositePart_97.getChildParts().getPart("D439_M5"));

    CadPart cadPart_297 = 
      ((CadPart) compositePart_100.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_319 = 
      ((PartSurface) cadPart_297.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_297 = 
      ((PartCurve) cadPart_297.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_101 = 
      ((CompositePart) compositePart_97.getChildParts().getPart("D439_M5 2"));

    CadPart cadPart_298 = 
      ((CadPart) compositePart_101.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_320 = 
      ((PartSurface) cadPart_298.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_298 = 
      ((PartCurve) cadPart_298.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_102 = 
      ((CompositePart) compositePart_97.getChildParts().getPart("DIN985_M5"));

    CadPart cadPart_299 = 
      ((CadPart) compositePart_102.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_321 = 
      ((PartSurface) cadPart_299.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_299 = 
      ((PartCurve) cadPart_299.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_103 = 
      ((CompositePart) compositePart_97.getChildParts().getPart("DIN985_M5 2"));

    CadPart cadPart_300 = 
      ((CadPart) compositePart_103.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_322 = 
      ((PartSurface) cadPart_300.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_300 = 
      ((PartCurve) cadPart_300.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_301 = 
      ((CadPart) compositePart_97.getChildParts().getPart("DIN7985TX_M4X10"));

    PartSurface partSurface_323 = 
      ((PartSurface) cadPart_301.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_301 = 
      ((PartCurve) cadPart_301.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_302 = 
      ((CadPart) compositePart_97.getChildParts().getPart("DIN7985TX_M4X20"));

    PartSurface partSurface_324 = 
      ((PartSurface) cadPart_302.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_302 = 
      ((PartCurve) cadPart_302.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_303 = 
      ((CadPart) compositePart_97.getChildParts().getPart("DIN7985TX_M5X25"));

    PartSurface partSurface_325 = 
      ((PartSurface) cadPart_303.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_303 = 
      ((PartCurve) cadPart_303.getPartCurveManager().getPartCurve("Edges"));

    SolidModelCompositePart solidModelCompositePart_4 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("z_000_remaining-parts"));

    CompositePart compositePart_104 = 
      ((CompositePart) solidModelCompositePart_4.getChildParts().getPart("Suspension_Front_Left"));

    CadPart cadPart_304 = 
      ((CadPart) compositePart_104.getChildParts().getPart("S_FL02_U"));

    PartSurface partSurface_326 = 
      ((PartSurface) cadPart_304.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_304 = 
      ((PartCurve) cadPart_304.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_305 = 
      ((CadPart) compositePart_104.getChildParts().getPart("S_FL03_L"));

    PartSurface partSurface_327 = 
      ((PartSurface) cadPart_305.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_305 = 
      ((PartCurve) cadPart_305.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_306 = 
      ((CadPart) compositePart_104.getChildParts().getPart("S_FL03_L 2"));

    PartSurface partSurface_328 = 
      ((PartSurface) cadPart_306.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_306 = 
      ((PartCurve) cadPart_306.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_307 = 
      ((CadPart) compositePart_104.getChildParts().getPart("S_FL04_T"));

    PartSurface partSurface_329 = 
      ((PartSurface) cadPart_307.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_307 = 
      ((PartCurve) cadPart_307.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_308 = 
      ((CadPart) compositePart_104.getChildParts().getPart("S_FL06_P"));

    PartSurface partSurface_330 = 
      ((PartSurface) cadPart_308.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_308 = 
      ((PartCurve) cadPart_308.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_105 = 
      ((CompositePart) solidModelCompositePart_4.getChildParts().getPart("Suspension_Front_Right"));

    CadPart cadPart_309 = 
      ((CadPart) compositePart_105.getChildParts().getPart("S_FL02_U"));

    PartSurface partSurface_331 = 
      ((PartSurface) cadPart_309.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_309 = 
      ((PartCurve) cadPart_309.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_310 = 
      ((CadPart) compositePart_105.getChildParts().getPart("S_FL03_L"));

    PartSurface partSurface_332 = 
      ((PartSurface) cadPart_310.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_310 = 
      ((PartCurve) cadPart_310.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_311 = 
      ((CadPart) compositePart_105.getChildParts().getPart("S_FL03_L 2"));

    PartSurface partSurface_333 = 
      ((PartSurface) cadPart_311.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_311 = 
      ((PartCurve) cadPart_311.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_312 = 
      ((CadPart) compositePart_105.getChildParts().getPart("S_FL04_T"));

    PartSurface partSurface_334 = 
      ((PartSurface) cadPart_312.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_312 = 
      ((PartCurve) cadPart_312.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_313 = 
      ((CadPart) compositePart_105.getChildParts().getPart("S_FL06_P"));

    PartSurface partSurface_335 = 
      ((PartSurface) cadPart_313.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_313 = 
      ((PartCurve) cadPart_313.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_106 = 
      ((CompositePart) solidModelCompositePart_4.getChildParts().getPart("Suspension_Rear_Left"));

    CadPart cadPart_314 = 
      ((CadPart) compositePart_106.getChildParts().getPart("S_RL02_U"));

    PartSurface partSurface_336 = 
      ((PartSurface) cadPart_314.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_314 = 
      ((PartCurve) cadPart_314.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_315 = 
      ((CadPart) compositePart_106.getChildParts().getPart("S_RL02_U 2"));

    PartSurface partSurface_337 = 
      ((PartSurface) cadPart_315.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_315 = 
      ((PartCurve) cadPart_315.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_316 = 
      ((CadPart) compositePart_106.getChildParts().getPart("S_RL03_L"));

    PartSurface partSurface_338 = 
      ((PartSurface) cadPart_316.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_316 = 
      ((PartCurve) cadPart_316.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_317 = 
      ((CadPart) compositePart_106.getChildParts().getPart("S_RL03_L 2"));

    PartSurface partSurface_339 = 
      ((PartSurface) cadPart_317.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_317 = 
      ((PartCurve) cadPart_317.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_318 = 
      ((CadPart) compositePart_106.getChildParts().getPart("S_RL04_T"));

    PartSurface partSurface_340 = 
      ((PartSurface) cadPart_318.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_318 = 
      ((PartCurve) cadPart_318.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_319 = 
      ((CadPart) compositePart_106.getChildParts().getPart("S_RL06_P"));

    PartSurface partSurface_341 = 
      ((PartSurface) cadPart_319.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_319 = 
      ((PartCurve) cadPart_319.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_320 = 
      ((CadPart) compositePart_106.getChildParts().getPart("S_RL06_P 2"));

    PartSurface partSurface_342 = 
      ((PartSurface) cadPart_320.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_320 = 
      ((PartCurve) cadPart_320.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_321 = 
      ((CadPart) compositePart_106.getChildParts().getPart("S_RL08_D"));

    PartSurface partSurface_343 = 
      ((PartSurface) cadPart_321.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_321 = 
      ((PartCurve) cadPart_321.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_322 = 
      ((CadPart) compositePart_106.getChildParts().getPart("S_RL08_D 2"));

    PartSurface partSurface_344 = 
      ((PartSurface) cadPart_322.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_322 = 
      ((PartCurve) cadPart_322.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_107 = 
      ((CompositePart) solidModelCompositePart_4.getChildParts().getPart("Suspension_Rear_Right"));

    CadPart cadPart_323 = 
      ((CadPart) compositePart_107.getChildParts().getPart("S_RL02_U"));

    PartSurface partSurface_345 = 
      ((PartSurface) cadPart_323.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_323 = 
      ((PartCurve) cadPart_323.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_324 = 
      ((CadPart) compositePart_107.getChildParts().getPart("S_RL02_U 2"));

    PartSurface partSurface_346 = 
      ((PartSurface) cadPart_324.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_324 = 
      ((PartCurve) cadPart_324.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_325 = 
      ((CadPart) compositePart_107.getChildParts().getPart("S_RL03_L"));

    PartSurface partSurface_347 = 
      ((PartSurface) cadPart_325.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_325 = 
      ((PartCurve) cadPart_325.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_326 = 
      ((CadPart) compositePart_107.getChildParts().getPart("S_RL03_L 2"));

    PartSurface partSurface_348 = 
      ((PartSurface) cadPart_326.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_326 = 
      ((PartCurve) cadPart_326.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_327 = 
      ((CadPart) compositePart_107.getChildParts().getPart("S_RL04_T"));

    PartSurface partSurface_349 = 
      ((PartSurface) cadPart_327.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_327 = 
      ((PartCurve) cadPart_327.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_328 = 
      ((CadPart) compositePart_107.getChildParts().getPart("S_RL06_P"));

    PartSurface partSurface_350 = 
      ((PartSurface) cadPart_328.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_328 = 
      ((PartCurve) cadPart_328.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_329 = 
      ((CadPart) compositePart_107.getChildParts().getPart("S_RL06_P 2"));

    PartSurface partSurface_351 = 
      ((PartSurface) cadPart_329.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_329 = 
      ((PartCurve) cadPart_329.getPartCurveManager().getPartCurve("Edges"));

    partDisplayer_7.getInputParts().setObjects(partSurface_149, partCurve_147, partSurface_150, partCurve_148, partSurface_151, partCurve_149, partSurface_152, partCurve_150, partSurface_153, partCurve_151, partSurface_154, partCurve_152, partSurface_155, partSurface_156, partCurve_153, partSurface_157, partSurface_158, partCurve_154, partSurface_159, partCurve_155, partSurface_160, partCurve_156, partSurface_161, partCurve_157, partSurface_162, partCurve_158, partSurface_163, partCurve_159, partSurface_164, partCurve_160, partSurface_165, partCurve_161, partSurface_166, partCurve_162, partSurface_167, partCurve_163, partSurface_168, partCurve_164, partSurface_169, partCurve_165, partSurface_170, partCurve_166, partSurface_171, partCurve_167, partSurface_172, partCurve_168, partSurface_173, partSurface_174, partCurve_169, partSurface_175, partSurface_176, partCurve_170, partSurface_177, partCurve_171, partSurface_178, partCurve_172, partSurface_179, partCurve_173, partSurface_180, partCurve_174, partSurface_181, partCurve_175, partSurface_182, partCurve_176, partSurface_183, partCurve_177, partSurface_184, partCurve_178, partSurface_185, partCurve_179, partSurface_186, partCurve_180, partSurface_187, partCurve_181, partSurface_188, partCurve_182, partSurface_189, partCurve_183, partSurface_190, partSurface_191, partCurve_184, partSurface_192, partSurface_193, partCurve_185, partSurface_194, partCurve_186, partSurface_195, partCurve_187, partSurface_196, partCurve_188, partSurface_197, partCurve_189, partSurface_198, partCurve_190, partSurface_199, partCurve_191, partSurface_200, partCurve_192, partSurface_201, partCurve_193, partSurface_202, partCurve_194, partSurface_203, partCurve_195, partSurface_204, partCurve_196, partSurface_205, partCurve_197, partSurface_206, partCurve_198, partSurface_207, partSurface_208, partCurve_199, partSurface_209, partSurface_210, partCurve_200, partSurface_211, partCurve_201, partSurface_212, partCurve_202, partSurface_213, partCurve_203, partSurface_214, partCurve_204, partSurface_215, partCurve_205, partSurface_216, partCurve_206, partSurface_217, partCurve_207, partSurface_218, partCurve_208, partSurface_219, partCurve_209, partSurface_220, partCurve_210, partSurface_221, partCurve_211, partSurface_222, partCurve_212, partSurface_223, partSurface_224, partCurve_213, partSurface_225, partSurface_226, partCurve_214, partSurface_227, partCurve_215, partSurface_228, partCurve_216, partSurface_229, partCurve_217, partSurface_230, partCurve_218, partSurface_231, partCurve_219, partSurface_232, partCurve_220, partSurface_233, partCurve_221, partSurface_234, partCurve_222, partSurface_235, partCurve_223, partSurface_236, partCurve_224, partSurface_237, partCurve_225, partSurface_238, partCurve_226, partSurface_239, partCurve_227, partSurface_240, partCurve_228, partSurface_241, partSurface_242, partCurve_229, partSurface_243, partSurface_244, partCurve_230, partSurface_245, partCurve_231, partSurface_246, partCurve_232, partSurface_247, partCurve_233, partSurface_248, partCurve_234, partSurface_249, partCurve_235, partSurface_250, partCurve_236, partSurface_251, partCurve_237, partSurface_252, partCurve_238, partSurface_253, partCurve_239, partSurface_254, partCurve_240, partSurface_255, partCurve_241, partSurface_256, partCurve_242, partSurface_257, partCurve_243, partSurface_258, partCurve_244, partSurface_259, partSurface_260, partCurve_245, partSurface_261, partSurface_262, partCurve_246, partSurface_263, partCurve_247, partSurface_264, partCurve_248, partSurface_265, partCurve_249, partSurface_266, partCurve_250, partSurface_267, partCurve_251, partSurface_268, partCurve_252, partSurface_269, partCurve_253, partSurface_270, partCurve_254, partSurface_271, partCurve_255, partSurface_272, partCurve_256, partSurface_273, partCurve_257, partSurface_274, partCurve_258, partSurface_275, partCurve_259, partSurface_276, partCurve_260, partSurface_277, partSurface_278, partCurve_261, partSurface_279, partSurface_280, partCurve_262, partSurface_281, partCurve_263, partSurface_282, partCurve_264, partSurface_283, partCurve_265, partSurface_284, partCurve_266, partSurface_285, partCurve_267, partSurface_286, partCurve_268, partSurface_287, partCurve_269, partSurface_288, partCurve_270, partSurface_289, partCurve_271, partSurface_290, partCurve_272, partSurface_291, partCurve_273, partSurface_292, partCurve_274, partSurface_293, partCurve_275, partSurface_294, partCurve_276, partSurface_295, partSurface_296, partCurve_277, partSurface_297, partSurface_298, partCurve_278, partSurface_299, partCurve_279, partSurface_300, partCurve_280, partSurface_301, partCurve_281, partSurface_302, partCurve_282, partSurface_303, partCurve_283, partSurface_304, partCurve_284, partSurface_305, partCurve_285, partSurface_306, partCurve_286, partSurface_307, partCurve_287, partSurface_308, partCurve_288, partSurface_309, partCurve_289, partSurface_310, partCurve_290, partSurface_311, partCurve_291, partSurface_312, partCurve_292, partSurface_313, partSurface_314, partCurve_293, partSurface_315, partSurface_316, partCurve_294, partSurface_317, partCurve_295, partSurface_318, partCurve_296, partSurface_319, partCurve_297, partSurface_320, partCurve_298, partSurface_321, partCurve_299, partSurface_322, partCurve_300, partSurface_323, partCurve_301, partSurface_324, partCurve_302, partSurface_325, partCurve_303, partSurface_326, partCurve_304, partSurface_327, partCurve_305, partSurface_328, partCurve_306, partSurface_329, partCurve_307, partSurface_330, partCurve_308, partSurface_331, partCurve_309, partSurface_332, partCurve_310, partSurface_333, partCurve_311, partSurface_334, partCurve_312, partSurface_335, partCurve_313, partSurface_336, partCurve_314, partSurface_337, partCurve_315, partSurface_338, partCurve_316, partSurface_339, partCurve_317, partSurface_340, partCurve_318, partSurface_341, partCurve_319, partSurface_342, partCurve_320, partSurface_343, partCurve_321, partSurface_344, partCurve_322, partSurface_345, partCurve_323, partSurface_346, partCurve_324, partSurface_347, partCurve_325, partSurface_348, partCurve_326, partSurface_349, partCurve_327, partSurface_350, partCurve_328, partSurface_351, partCurve_329);
  }

  private void execute4() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Scene scene_1 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 2");

    PartDisplayer partDisplayer_7 = 
      ((PartDisplayer) scene_1.getDisplayerManager().getObject("rods"));

    partDisplayer_7.getInputParts().setQuery(null);

    SolidModelCompositePart solidModelCompositePart_0 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("C_FRONTWING"));

    CompositePart compositePart_0 = 
      ((CompositePart) solidModelCompositePart_0.getChildParts().getPart("A_F000_FRONTWING_ASM"));

    CompositePart compositePart_27 = 
      ((CompositePart) compositePart_0.getChildParts().getPart("A_FA00_FRONTWING_ATTACHMENT"));

    CompositePart compositePart_30 = 
      ((CompositePart) compositePart_27.getChildParts().getPart("A_FA01_ATTACHMENT_A"));

    CompositePart compositePart_29 = 
      ((CompositePart) compositePart_30.getChildParts().getPart("A_FA01_INSERT_BOTTOM"));

    CadPart cadPart_147 = 
      ((CadPart) compositePart_29.getChildParts().getPart("A_FA01_INSERT_BOTTOM_Body"));

    PartSurface partSurface_149 = 
      ((PartSurface) cadPart_147.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_147 = 
      ((PartCurve) cadPart_147.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_31 = 
      ((CompositePart) compositePart_30.getChildParts().getPart("A_FA01_INSERT_TOP"));

    CadPart cadPart_148 = 
      ((CadPart) compositePart_31.getChildParts().getPart("A_FA01_INSERT_TOP_Body"));

    PartSurface partSurface_150 = 
      ((PartSurface) cadPart_148.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_148 = 
      ((PartCurve) cadPart_148.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_149 = 
      ((CadPart) compositePart_30.getChildParts().getPart("A_FA01_MONO_BRACKET"));

    PartSurface partSurface_151 = 
      ((PartSurface) cadPart_149.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_149 = 
      ((PartCurve) cadPart_149.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_150 = 
      ((CadPart) compositePart_30.getChildParts().getPart("A_FA01_ROD"));

    PartSurface partSurface_152 = 
      ((PartSurface) cadPart_150.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_150 = 
      ((PartCurve) cadPart_150.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_151 = 
      ((CadPart) compositePart_30.getChildParts().getPart("A_FA01_WING_BRACKET"));

    PartSurface partSurface_153 = 
      ((PartSurface) cadPart_151.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_151 = 
      ((PartCurve) cadPart_151.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_152 = 
      ((CadPart) compositePart_30.getChildParts().getPart("A_FA01_WING_BRACKET_B"));

    PartSurface partSurface_154 = 
      ((PartSurface) cadPart_152.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_152 = 
      ((PartCurve) cadPart_152.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_32 = 
      ((CompositePart) compositePart_30.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5"));

    CadPart cadPart_153 = 
      ((CadPart) compositePart_32.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_155 = 
      ((PartSurface) cadPart_153.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_156 = 
      ((PartSurface) cadPart_153.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_153 = 
      ((PartCurve) cadPart_153.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_33 = 
      ((CompositePart) compositePart_30.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5 2"));

    CadPart cadPart_154 = 
      ((CadPart) compositePart_33.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_157 = 
      ((PartSurface) cadPart_154.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_158 = 
      ((PartSurface) cadPart_154.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_154 = 
      ((PartCurve) cadPart_154.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_155 = 
      ((CadPart) compositePart_30.getChildParts().getPart("ASKUBAL_BALL_M5"));

    PartSurface partSurface_159 = 
      ((PartSurface) cadPart_155.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_155 = 
      ((PartCurve) cadPart_155.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_156 = 
      ((CadPart) compositePart_30.getChildParts().getPart("D125B_5_3"));

    PartSurface partSurface_160 = 
      ((PartSurface) cadPart_156.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_156 = 
      ((PartCurve) cadPart_156.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_34 = 
      ((CompositePart) compositePart_30.getChildParts().getPart("D439_M5"));

    CadPart cadPart_157 = 
      ((CadPart) compositePart_34.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_161 = 
      ((PartSurface) cadPart_157.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_157 = 
      ((PartCurve) cadPart_157.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_35 = 
      ((CompositePart) compositePart_30.getChildParts().getPart("D439_M5 2"));

    CadPart cadPart_158 = 
      ((CadPart) compositePart_35.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_162 = 
      ((PartSurface) cadPart_158.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_158 = 
      ((PartCurve) cadPart_158.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_36 = 
      ((CompositePart) compositePart_30.getChildParts().getPart("DIN985_M5"));

    CadPart cadPart_159 = 
      ((CadPart) compositePart_36.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_163 = 
      ((PartSurface) cadPart_159.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_159 = 
      ((PartCurve) cadPart_159.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_37 = 
      ((CompositePart) compositePart_30.getChildParts().getPart("DIN985_M5 2"));

    CadPart cadPart_160 = 
      ((CadPart) compositePart_37.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_164 = 
      ((PartSurface) cadPart_160.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_160 = 
      ((PartCurve) cadPart_160.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_161 = 
      ((CadPart) compositePart_30.getChildParts().getPart("DIN7985TX_M4X30"));

    PartSurface partSurface_165 = 
      ((PartSurface) cadPart_161.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_161 = 
      ((PartCurve) cadPart_161.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_162 = 
      ((CadPart) compositePart_30.getChildParts().getPart("DIN7985TX_M5X20"));

    PartSurface partSurface_166 = 
      ((PartSurface) cadPart_162.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_162 = 
      ((PartCurve) cadPart_162.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_38 = 
      ((CompositePart) compositePart_27.getChildParts().getPart("A_FA01_ATTACHMENT_A_MIR"));

    CadPart cadPart_163 = 
      ((CadPart) compositePart_38.getChildParts().getPart("A_FA01_INSERT_BOTTOM_MIR"));

    PartSurface partSurface_167 = 
      ((PartSurface) cadPart_163.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_163 = 
      ((PartCurve) cadPart_163.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_39 = 
      ((CompositePart) compositePart_38.getChildParts().getPart("A_FA01_INSERT_TOP_MIR"));

    CadPart cadPart_164 = 
      ((CadPart) compositePart_39.getChildParts().getPart("A_FA01_INSERT_TOP_MIR_Body"));

    PartSurface partSurface_168 = 
      ((PartSurface) cadPart_164.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_164 = 
      ((PartCurve) cadPart_164.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_165 = 
      ((CadPart) compositePart_38.getChildParts().getPart("A_FA01_MONO_BRACKET_MIR"));

    PartSurface partSurface_169 = 
      ((PartSurface) cadPart_165.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_165 = 
      ((PartCurve) cadPart_165.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_166 = 
      ((CadPart) compositePart_38.getChildParts().getPart("A_FA01_ROD_MIR"));

    PartSurface partSurface_170 = 
      ((PartSurface) cadPart_166.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_166 = 
      ((PartCurve) cadPart_166.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_167 = 
      ((CadPart) compositePart_38.getChildParts().getPart("A_FA01_WING_BRACKET_B_MIR"));

    PartSurface partSurface_171 = 
      ((PartSurface) cadPart_167.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_167 = 
      ((PartCurve) cadPart_167.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_168 = 
      ((CadPart) compositePart_38.getChildParts().getPart("A_FA01_WING_BRACKET_MIR"));

    PartSurface partSurface_172 = 
      ((PartSurface) cadPart_168.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_168 = 
      ((PartCurve) cadPart_168.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_40 = 
      ((CompositePart) compositePart_38.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5"));

    CadPart cadPart_169 = 
      ((CadPart) compositePart_40.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_173 = 
      ((PartSurface) cadPart_169.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_174 = 
      ((PartSurface) cadPart_169.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_169 = 
      ((PartCurve) cadPart_169.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_41 = 
      ((CompositePart) compositePart_38.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5 2"));

    CadPart cadPart_170 = 
      ((CadPart) compositePart_41.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_175 = 
      ((PartSurface) cadPart_170.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_176 = 
      ((PartSurface) cadPart_170.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_170 = 
      ((PartCurve) cadPart_170.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_171 = 
      ((CadPart) compositePart_38.getChildParts().getPart("ASKUBAL_BALL_M5"));

    PartSurface partSurface_177 = 
      ((PartSurface) cadPart_171.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_171 = 
      ((PartCurve) cadPart_171.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_172 = 
      ((CadPart) compositePart_38.getChildParts().getPart("D125B_5_3"));

    PartSurface partSurface_178 = 
      ((PartSurface) cadPart_172.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_172 = 
      ((PartCurve) cadPart_172.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_42 = 
      ((CompositePart) compositePart_38.getChildParts().getPart("D439_M5"));

    CadPart cadPart_173 = 
      ((CadPart) compositePart_42.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_179 = 
      ((PartSurface) cadPart_173.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_173 = 
      ((PartCurve) cadPart_173.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_43 = 
      ((CompositePart) compositePart_38.getChildParts().getPart("D439_M5 2"));

    CadPart cadPart_174 = 
      ((CadPart) compositePart_43.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_180 = 
      ((PartSurface) cadPart_174.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_174 = 
      ((PartCurve) cadPart_174.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_44 = 
      ((CompositePart) compositePart_38.getChildParts().getPart("DIN985_M5"));

    CadPart cadPart_175 = 
      ((CadPart) compositePart_44.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_181 = 
      ((PartSurface) cadPart_175.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_175 = 
      ((PartCurve) cadPart_175.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_45 = 
      ((CompositePart) compositePart_38.getChildParts().getPart("DIN985_M5 2"));

    CadPart cadPart_176 = 
      ((CadPart) compositePart_45.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_182 = 
      ((PartSurface) cadPart_176.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_176 = 
      ((PartCurve) cadPart_176.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_177 = 
      ((CadPart) compositePart_38.getChildParts().getPart("DIN7985TX_M4X30"));

    PartSurface partSurface_183 = 
      ((PartSurface) cadPart_177.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_177 = 
      ((PartCurve) cadPart_177.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_178 = 
      ((CadPart) compositePart_38.getChildParts().getPart("DIN7985TX_M5X20"));

    PartSurface partSurface_184 = 
      ((PartSurface) cadPart_178.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_178 = 
      ((PartCurve) cadPart_178.getPartCurveManager().getPartCurve("Edges"));

    SolidModelCompositePart solidModelCompositePart_1 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("C_REARWING"));

    CompositePart compositePart_4 = 
      ((CompositePart) solidModelCompositePart_1.getChildParts().getPart("A_R000_REARWING_ASM"));

    CompositePart compositePart_47 = 
      ((CompositePart) compositePart_4.getChildParts().getPart("A_RA00_REARWING_ATTACHMENTS"));

    CompositePart compositePart_46 = 
      ((CompositePart) compositePart_47.getChildParts().getPart("A_RA01_RW_ATTACHMENT_A"));

    CadPart cadPart_179 = 
      ((CadPart) compositePart_46.getChildParts().getPart("A_RA01_ENDPLATE_BRACKET"));

    PartSurface partSurface_185 = 
      ((PartSurface) cadPart_179.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_179 = 
      ((PartCurve) cadPart_179.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_48 = 
      ((CompositePart) compositePart_46.getChildParts().getPart("A_RA01_INSERT_ROD_BOTTOM"));

    CadPart cadPart_180 = 
      ((CadPart) compositePart_48.getChildParts().getPart("A_RA01_INSERT_ROD_BOTTOM_Body"));

    PartSurface partSurface_186 = 
      ((PartSurface) cadPart_180.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_180 = 
      ((PartCurve) cadPart_180.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_49 = 
      ((CompositePart) compositePart_46.getChildParts().getPart("A_RA01_INSERT_ROD_TOP"));

    CadPart cadPart_181 = 
      ((CadPart) compositePart_49.getChildParts().getPart("A_RA01_INSERT_ROD_TOP_Body"));

    PartSurface partSurface_187 = 
      ((PartSurface) cadPart_181.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_181 = 
      ((PartCurve) cadPart_181.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_182 = 
      ((CadPart) compositePart_46.getChildParts().getPart("A_RA01_MAIN_HOOP_BRACKET"));

    PartSurface partSurface_188 = 
      ((PartSurface) cadPart_182.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_182 = 
      ((PartCurve) cadPart_182.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_183 = 
      ((CadPart) compositePart_46.getChildParts().getPart("A_RA01_ROD"));

    PartSurface partSurface_189 = 
      ((PartSurface) cadPart_183.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_183 = 
      ((PartCurve) cadPart_183.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_50 = 
      ((CompositePart) compositePart_46.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5"));

    CadPart cadPart_184 = 
      ((CadPart) compositePart_50.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_190 = 
      ((PartSurface) cadPart_184.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_191 = 
      ((PartSurface) cadPart_184.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_184 = 
      ((PartCurve) cadPart_184.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_51 = 
      ((CompositePart) compositePart_46.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5 2"));

    CadPart cadPart_185 = 
      ((CadPart) compositePart_51.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_192 = 
      ((PartSurface) cadPart_185.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_193 = 
      ((PartSurface) cadPart_185.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_185 = 
      ((PartCurve) cadPart_185.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_186 = 
      ((CadPart) compositePart_46.getChildParts().getPart("ASKUBAL_BALL_M5"));

    PartSurface partSurface_194 = 
      ((PartSurface) cadPart_186.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_186 = 
      ((PartCurve) cadPart_186.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_187 = 
      ((CadPart) compositePart_46.getChildParts().getPart("D125B_5_3"));

    PartSurface partSurface_195 = 
      ((PartSurface) cadPart_187.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_187 = 
      ((PartCurve) cadPart_187.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_52 = 
      ((CompositePart) compositePart_46.getChildParts().getPart("D439_M5"));

    CadPart cadPart_188 = 
      ((CadPart) compositePart_52.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_196 = 
      ((PartSurface) cadPart_188.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_188 = 
      ((PartCurve) cadPart_188.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_53 = 
      ((CompositePart) compositePart_46.getChildParts().getPart("D439_M5 2"));

    CadPart cadPart_189 = 
      ((CadPart) compositePart_53.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_197 = 
      ((PartSurface) cadPart_189.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_189 = 
      ((PartCurve) cadPart_189.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_54 = 
      ((CompositePart) compositePart_46.getChildParts().getPart("DIN985_M5"));

    CadPart cadPart_190 = 
      ((CadPart) compositePart_54.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_198 = 
      ((PartSurface) cadPart_190.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_190 = 
      ((PartCurve) cadPart_190.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_55 = 
      ((CompositePart) compositePart_46.getChildParts().getPart("DIN985_M5 2"));

    CadPart cadPart_191 = 
      ((CadPart) compositePart_55.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_199 = 
      ((PartSurface) cadPart_191.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_191 = 
      ((PartCurve) cadPart_191.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_192 = 
      ((CadPart) compositePart_46.getChildParts().getPart("DIN7985TX_M4X10"));

    PartSurface partSurface_200 = 
      ((PartSurface) cadPart_192.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_192 = 
      ((PartCurve) cadPart_192.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_193 = 
      ((CadPart) compositePart_46.getChildParts().getPart("DIN7985TX_M5X25"));

    PartSurface partSurface_201 = 
      ((PartSurface) cadPart_193.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_193 = 
      ((PartCurve) cadPart_193.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_56 = 
      ((CompositePart) compositePart_47.getChildParts().getPart("A_RA01_RW_ATTACHMENT_A_MIR"));

    CadPart cadPart_194 = 
      ((CadPart) compositePart_56.getChildParts().getPart("A_RA01_ENDPLATE_BRACKET_MIR"));

    PartSurface partSurface_202 = 
      ((PartSurface) cadPart_194.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_194 = 
      ((PartCurve) cadPart_194.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_195 = 
      ((CadPart) compositePart_56.getChildParts().getPart("A_RA01_INSERT_ROD_BOTTOM_MIR"));

    PartSurface partSurface_203 = 
      ((PartSurface) cadPart_195.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_195 = 
      ((PartCurve) cadPart_195.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_196 = 
      ((CadPart) compositePart_56.getChildParts().getPart("A_RA01_INSERT_ROD_TOP_MIR"));

    PartSurface partSurface_204 = 
      ((PartSurface) cadPart_196.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_196 = 
      ((PartCurve) cadPart_196.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_197 = 
      ((CadPart) compositePart_56.getChildParts().getPart("A_RA01_MAIN_HOOP_BRACKET_MIR"));

    PartSurface partSurface_205 = 
      ((PartSurface) cadPart_197.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_197 = 
      ((PartCurve) cadPart_197.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_198 = 
      ((CadPart) compositePart_56.getChildParts().getPart("A_RA01_ROD_MIR"));

    PartSurface partSurface_206 = 
      ((PartSurface) cadPart_198.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_198 = 
      ((PartCurve) cadPart_198.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_57 = 
      ((CompositePart) compositePart_56.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5"));

    CadPart cadPart_199 = 
      ((CadPart) compositePart_57.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_207 = 
      ((PartSurface) cadPart_199.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_208 = 
      ((PartSurface) cadPart_199.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_199 = 
      ((PartCurve) cadPart_199.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_58 = 
      ((CompositePart) compositePart_56.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5 2"));

    CadPart cadPart_200 = 
      ((CadPart) compositePart_58.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_209 = 
      ((PartSurface) cadPart_200.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_210 = 
      ((PartSurface) cadPart_200.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_200 = 
      ((PartCurve) cadPart_200.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_201 = 
      ((CadPart) compositePart_56.getChildParts().getPart("ASKUBAL_BALL_M5"));

    PartSurface partSurface_211 = 
      ((PartSurface) cadPart_201.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_201 = 
      ((PartCurve) cadPart_201.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_202 = 
      ((CadPart) compositePart_56.getChildParts().getPart("D125B_5_3"));

    PartSurface partSurface_212 = 
      ((PartSurface) cadPart_202.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_202 = 
      ((PartCurve) cadPart_202.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_59 = 
      ((CompositePart) compositePart_56.getChildParts().getPart("D439_M5"));

    CadPart cadPart_203 = 
      ((CadPart) compositePart_59.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_213 = 
      ((PartSurface) cadPart_203.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_203 = 
      ((PartCurve) cadPart_203.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_60 = 
      ((CompositePart) compositePart_56.getChildParts().getPart("D439_M5 2"));

    CadPart cadPart_204 = 
      ((CadPart) compositePart_60.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_214 = 
      ((PartSurface) cadPart_204.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_204 = 
      ((PartCurve) cadPart_204.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_61 = 
      ((CompositePart) compositePart_56.getChildParts().getPart("DIN985_M5"));

    CadPart cadPart_205 = 
      ((CadPart) compositePart_61.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_215 = 
      ((PartSurface) cadPart_205.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_205 = 
      ((PartCurve) cadPart_205.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_206 = 
      ((CadPart) compositePart_56.getChildParts().getPart("DIN7985TX_M4X10"));

    PartSurface partSurface_216 = 
      ((PartSurface) cadPart_206.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_206 = 
      ((PartCurve) cadPart_206.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_207 = 
      ((CadPart) compositePart_56.getChildParts().getPart("DIN7985TX_M5X25"));

    PartSurface partSurface_217 = 
      ((PartSurface) cadPart_207.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_207 = 
      ((PartCurve) cadPart_207.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_62 = 
      ((CompositePart) compositePart_47.getChildParts().getPart("A_RA02_RW_ATTACHMENT_B"));

    CadPart cadPart_208 = 
      ((CadPart) compositePart_62.getChildParts().getPart("A_RA02_ENDPLATE_BRACKET"));

    PartSurface partSurface_218 = 
      ((PartSurface) cadPart_208.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_208 = 
      ((PartCurve) cadPart_208.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_209 = 
      ((CadPart) compositePart_62.getChildParts().getPart("A_RA02_INSERT_ROD_BOTTOM"));

    PartSurface partSurface_219 = 
      ((PartSurface) cadPart_209.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_209 = 
      ((PartCurve) cadPart_209.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_210 = 
      ((CadPart) compositePart_62.getChildParts().getPart("A_RA02_INSERT_ROD_TOP"));

    PartSurface partSurface_220 = 
      ((PartSurface) cadPart_210.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_210 = 
      ((PartCurve) cadPart_210.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_211 = 
      ((CadPart) compositePart_62.getChildParts().getPart("A_RA02_MONO_BRACKET"));

    PartSurface partSurface_221 = 
      ((PartSurface) cadPart_211.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_211 = 
      ((PartCurve) cadPart_211.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_212 = 
      ((CadPart) compositePart_62.getChildParts().getPart("A_RA02_ROD"));

    PartSurface partSurface_222 = 
      ((PartSurface) cadPart_212.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_212 = 
      ((PartCurve) cadPart_212.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_63 = 
      ((CompositePart) compositePart_62.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5"));

    CadPart cadPart_213 = 
      ((CadPart) compositePart_63.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_223 = 
      ((PartSurface) cadPart_213.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_224 = 
      ((PartSurface) cadPart_213.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_213 = 
      ((PartCurve) cadPart_213.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_64 = 
      ((CompositePart) compositePart_62.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5 2"));

    CadPart cadPart_214 = 
      ((CadPart) compositePart_64.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_225 = 
      ((PartSurface) cadPart_214.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_226 = 
      ((PartSurface) cadPart_214.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_214 = 
      ((PartCurve) cadPart_214.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_215 = 
      ((CadPart) compositePart_62.getChildParts().getPart("ASKUBAL_BALL_M5"));

    PartSurface partSurface_227 = 
      ((PartSurface) cadPart_215.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_215 = 
      ((PartCurve) cadPart_215.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_216 = 
      ((CadPart) compositePart_62.getChildParts().getPart("D125B_5_3"));

    PartSurface partSurface_228 = 
      ((PartSurface) cadPart_216.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_216 = 
      ((PartCurve) cadPart_216.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_65 = 
      ((CompositePart) compositePart_62.getChildParts().getPart("D439_M5"));

    CadPart cadPart_217 = 
      ((CadPart) compositePart_65.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_229 = 
      ((PartSurface) cadPart_217.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_217 = 
      ((PartCurve) cadPart_217.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_66 = 
      ((CompositePart) compositePart_62.getChildParts().getPart("D439_M5 2"));

    CadPart cadPart_218 = 
      ((CadPart) compositePart_66.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_230 = 
      ((PartSurface) cadPart_218.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_218 = 
      ((PartCurve) cadPart_218.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_67 = 
      ((CompositePart) compositePart_62.getChildParts().getPart("DIN985_M5"));

    CadPart cadPart_219 = 
      ((CadPart) compositePart_67.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_231 = 
      ((PartSurface) cadPart_219.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_219 = 
      ((PartCurve) cadPart_219.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_68 = 
      ((CompositePart) compositePart_62.getChildParts().getPart("DIN985_M5 2"));

    CadPart cadPart_220 = 
      ((CadPart) compositePart_68.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_232 = 
      ((PartSurface) cadPart_220.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_220 = 
      ((PartCurve) cadPart_220.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_221 = 
      ((CadPart) compositePart_62.getChildParts().getPart("DIN7985TX_M4X10"));

    PartSurface partSurface_233 = 
      ((PartSurface) cadPart_221.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_221 = 
      ((PartCurve) cadPart_221.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_222 = 
      ((CadPart) compositePart_62.getChildParts().getPart("DIN7985TX_M4X20"));

    PartSurface partSurface_234 = 
      ((PartSurface) cadPart_222.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_222 = 
      ((PartCurve) cadPart_222.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_223 = 
      ((CadPart) compositePart_62.getChildParts().getPart("DIN7985TX_M5X25"));

    PartSurface partSurface_235 = 
      ((PartSurface) cadPart_223.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_223 = 
      ((PartCurve) cadPart_223.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_69 = 
      ((CompositePart) compositePart_47.getChildParts().getPart("A_RA02_RW_ATTACHMENT_B_MIR"));

    CadPart cadPart_224 = 
      ((CadPart) compositePart_69.getChildParts().getPart("A_RA02_ENDPLATE_BRACKET_MIR"));

    PartSurface partSurface_236 = 
      ((PartSurface) cadPart_224.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_224 = 
      ((PartCurve) cadPart_224.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_225 = 
      ((CadPart) compositePart_69.getChildParts().getPart("A_RA02_INSERT_ROD_BOTTOM_MIR"));

    PartSurface partSurface_237 = 
      ((PartSurface) cadPart_225.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_225 = 
      ((PartCurve) cadPart_225.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_226 = 
      ((CadPart) compositePart_69.getChildParts().getPart("A_RA02_INSERT_ROD_TOP_MIR"));

    PartSurface partSurface_238 = 
      ((PartSurface) cadPart_226.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_226 = 
      ((PartCurve) cadPart_226.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_227 = 
      ((CadPart) compositePart_69.getChildParts().getPart("A_RA02_MONO_BRACKET_MIR"));

    PartSurface partSurface_239 = 
      ((PartSurface) cadPart_227.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_227 = 
      ((PartCurve) cadPart_227.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_228 = 
      ((CadPart) compositePart_69.getChildParts().getPart("A_RA02_ROD_MIR"));

    PartSurface partSurface_240 = 
      ((PartSurface) cadPart_228.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_228 = 
      ((PartCurve) cadPart_228.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_70 = 
      ((CompositePart) compositePart_69.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5"));

    CadPart cadPart_229 = 
      ((CadPart) compositePart_70.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_241 = 
      ((PartSurface) cadPart_229.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_242 = 
      ((PartSurface) cadPart_229.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_229 = 
      ((PartCurve) cadPart_229.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_71 = 
      ((CompositePart) compositePart_69.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5 2"));

    CadPart cadPart_230 = 
      ((CadPart) compositePart_71.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_243 = 
      ((PartSurface) cadPart_230.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_244 = 
      ((PartSurface) cadPart_230.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_230 = 
      ((PartCurve) cadPart_230.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_231 = 
      ((CadPart) compositePart_69.getChildParts().getPart("ASKUBAL_BALL_M5"));

    PartSurface partSurface_245 = 
      ((PartSurface) cadPart_231.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_231 = 
      ((PartCurve) cadPart_231.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_232 = 
      ((CadPart) compositePart_69.getChildParts().getPart("D125B_5_3"));

    PartSurface partSurface_246 = 
      ((PartSurface) cadPart_232.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_232 = 
      ((PartCurve) cadPart_232.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_72 = 
      ((CompositePart) compositePart_69.getChildParts().getPart("D439_M5"));

    CadPart cadPart_233 = 
      ((CadPart) compositePart_72.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_247 = 
      ((PartSurface) cadPart_233.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_233 = 
      ((PartCurve) cadPart_233.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_73 = 
      ((CompositePart) compositePart_69.getChildParts().getPart("D439_M5 2"));

    CadPart cadPart_234 = 
      ((CadPart) compositePart_73.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_248 = 
      ((PartSurface) cadPart_234.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_234 = 
      ((PartCurve) cadPart_234.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_74 = 
      ((CompositePart) compositePart_69.getChildParts().getPart("DIN985_M5"));

    CadPart cadPart_235 = 
      ((CadPart) compositePart_74.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_249 = 
      ((PartSurface) cadPart_235.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_235 = 
      ((PartCurve) cadPart_235.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_75 = 
      ((CompositePart) compositePart_69.getChildParts().getPart("DIN985_M5 2"));

    CadPart cadPart_236 = 
      ((CadPart) compositePart_75.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_250 = 
      ((PartSurface) cadPart_236.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_236 = 
      ((PartCurve) cadPart_236.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_237 = 
      ((CadPart) compositePart_69.getChildParts().getPart("DIN7985TX_M4X10"));

    PartSurface partSurface_251 = 
      ((PartSurface) cadPart_237.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_237 = 
      ((PartCurve) cadPart_237.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_238 = 
      ((CadPart) compositePart_69.getChildParts().getPart("DIN7985TX_M4X20"));

    PartSurface partSurface_252 = 
      ((PartSurface) cadPart_238.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_238 = 
      ((PartCurve) cadPart_238.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_239 = 
      ((CadPart) compositePart_69.getChildParts().getPart("DIN7985TX_M5X25"));

    PartSurface partSurface_253 = 
      ((PartSurface) cadPart_239.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_239 = 
      ((PartCurve) cadPart_239.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_76 = 
      ((CompositePart) compositePart_47.getChildParts().getPart("A_RA03_RW_ATTACHMENT_C"));

    CadPart cadPart_240 = 
      ((CadPart) compositePart_76.getChildParts().getPart("A_RA03_ENDPLATE_BRACKET"));

    PartSurface partSurface_254 = 
      ((PartSurface) cadPart_240.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_240 = 
      ((PartCurve) cadPart_240.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_241 = 
      ((CadPart) compositePart_76.getChildParts().getPart("A_RA03_INSERT_ROD_BOTTOM"));

    PartSurface partSurface_255 = 
      ((PartSurface) cadPart_241.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_241 = 
      ((PartCurve) cadPart_241.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_242 = 
      ((CadPart) compositePart_76.getChildParts().getPart("A_RA03_INSERT_ROD_TOP"));

    PartSurface partSurface_256 = 
      ((PartSurface) cadPart_242.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_242 = 
      ((PartCurve) cadPart_242.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_243 = 
      ((CadPart) compositePart_76.getChildParts().getPart("A_RA03_MONO_BRACKET_TYPE_A"));

    PartSurface partSurface_257 = 
      ((PartSurface) cadPart_243.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_243 = 
      ((PartCurve) cadPart_243.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_244 = 
      ((CadPart) compositePart_76.getChildParts().getPart("A_RA03_ROD"));

    PartSurface partSurface_258 = 
      ((PartSurface) cadPart_244.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_244 = 
      ((PartCurve) cadPart_244.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_77 = 
      ((CompositePart) compositePart_76.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5"));

    CadPart cadPart_245 = 
      ((CadPart) compositePart_77.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_259 = 
      ((PartSurface) cadPart_245.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_260 = 
      ((PartSurface) cadPart_245.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_245 = 
      ((PartCurve) cadPart_245.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_78 = 
      ((CompositePart) compositePart_76.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5 2"));

    CadPart cadPart_246 = 
      ((CadPart) compositePart_78.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_261 = 
      ((PartSurface) cadPart_246.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_262 = 
      ((PartSurface) cadPart_246.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_246 = 
      ((PartCurve) cadPart_246.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_247 = 
      ((CadPart) compositePart_76.getChildParts().getPart("ASKUBAL_BALL_M5"));

    PartSurface partSurface_263 = 
      ((PartSurface) cadPart_247.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_247 = 
      ((PartCurve) cadPart_247.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_248 = 
      ((CadPart) compositePart_76.getChildParts().getPart("D125B_5_3"));

    PartSurface partSurface_264 = 
      ((PartSurface) cadPart_248.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_248 = 
      ((PartCurve) cadPart_248.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_79 = 
      ((CompositePart) compositePart_76.getChildParts().getPart("D439_M5"));

    CadPart cadPart_249 = 
      ((CadPart) compositePart_79.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_265 = 
      ((PartSurface) cadPart_249.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_249 = 
      ((PartCurve) cadPart_249.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_80 = 
      ((CompositePart) compositePart_76.getChildParts().getPart("D439_M5 2"));

    CadPart cadPart_250 = 
      ((CadPart) compositePart_80.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_266 = 
      ((PartSurface) cadPart_250.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_250 = 
      ((PartCurve) cadPart_250.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_81 = 
      ((CompositePart) compositePart_76.getChildParts().getPart("DIN985_M5"));

    CadPart cadPart_251 = 
      ((CadPart) compositePart_81.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_267 = 
      ((PartSurface) cadPart_251.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_251 = 
      ((PartCurve) cadPart_251.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_82 = 
      ((CompositePart) compositePart_76.getChildParts().getPart("DIN985_M5 2"));

    CadPart cadPart_252 = 
      ((CadPart) compositePart_82.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_268 = 
      ((PartSurface) cadPart_252.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_252 = 
      ((PartCurve) cadPart_252.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_253 = 
      ((CadPart) compositePart_76.getChildParts().getPart("DIN7985TX_M4X10"));

    PartSurface partSurface_269 = 
      ((PartSurface) cadPart_253.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_253 = 
      ((PartCurve) cadPart_253.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_254 = 
      ((CadPart) compositePart_76.getChildParts().getPart("DIN7985TX_M4X30"));

    PartSurface partSurface_270 = 
      ((PartSurface) cadPart_254.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_254 = 
      ((PartCurve) cadPart_254.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_255 = 
      ((CadPart) compositePart_76.getChildParts().getPart("DIN7985TX_M5X25"));

    PartSurface partSurface_271 = 
      ((PartSurface) cadPart_255.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_255 = 
      ((PartCurve) cadPart_255.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_83 = 
      ((CompositePart) compositePart_47.getChildParts().getPart("A_RA03_RW_ATTACHMENT_C_MIR"));

    CadPart cadPart_256 = 
      ((CadPart) compositePart_83.getChildParts().getPart("A_RA03_ENDPLATE_BRACKET_MIR"));

    PartSurface partSurface_272 = 
      ((PartSurface) cadPart_256.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_256 = 
      ((PartCurve) cadPart_256.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_257 = 
      ((CadPart) compositePart_83.getChildParts().getPart("A_RA03_INSERT_ROD_BOTTOM_MIR"));

    PartSurface partSurface_273 = 
      ((PartSurface) cadPart_257.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_257 = 
      ((PartCurve) cadPart_257.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_258 = 
      ((CadPart) compositePart_83.getChildParts().getPart("A_RA03_INSERT_ROD_TOP_MIR"));

    PartSurface partSurface_274 = 
      ((PartSurface) cadPart_258.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_258 = 
      ((PartCurve) cadPart_258.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_259 = 
      ((CadPart) compositePart_83.getChildParts().getPart("A_RA03_MONO_BRACKET_TYPE_A_MIR"));

    PartSurface partSurface_275 = 
      ((PartSurface) cadPart_259.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_259 = 
      ((PartCurve) cadPart_259.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_260 = 
      ((CadPart) compositePart_83.getChildParts().getPart("A_RA03_ROD_MIR"));

    PartSurface partSurface_276 = 
      ((PartSurface) cadPart_260.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_260 = 
      ((PartCurve) cadPart_260.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_84 = 
      ((CompositePart) compositePart_83.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5"));

    CadPart cadPart_261 = 
      ((CadPart) compositePart_84.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_277 = 
      ((PartSurface) cadPart_261.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_278 = 
      ((PartSurface) cadPart_261.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_261 = 
      ((PartCurve) cadPart_261.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_85 = 
      ((CompositePart) compositePart_83.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5 2"));

    CadPart cadPart_262 = 
      ((CadPart) compositePart_85.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_279 = 
      ((PartSurface) cadPart_262.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_280 = 
      ((PartSurface) cadPart_262.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_262 = 
      ((PartCurve) cadPart_262.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_263 = 
      ((CadPart) compositePart_83.getChildParts().getPart("ASKUBAL_BALL_M5"));

    PartSurface partSurface_281 = 
      ((PartSurface) cadPart_263.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_263 = 
      ((PartCurve) cadPart_263.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_264 = 
      ((CadPart) compositePart_83.getChildParts().getPart("D125B_5_3"));

    PartSurface partSurface_282 = 
      ((PartSurface) cadPart_264.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_264 = 
      ((PartCurve) cadPart_264.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_86 = 
      ((CompositePart) compositePart_83.getChildParts().getPart("D439_M5"));

    CadPart cadPart_265 = 
      ((CadPart) compositePart_86.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_283 = 
      ((PartSurface) cadPart_265.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_265 = 
      ((PartCurve) cadPart_265.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_87 = 
      ((CompositePart) compositePart_83.getChildParts().getPart("D439_M5 2"));

    CadPart cadPart_266 = 
      ((CadPart) compositePart_87.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_284 = 
      ((PartSurface) cadPart_266.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_266 = 
      ((PartCurve) cadPart_266.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_88 = 
      ((CompositePart) compositePart_83.getChildParts().getPart("DIN985_M5"));

    CadPart cadPart_267 = 
      ((CadPart) compositePart_88.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_285 = 
      ((PartSurface) cadPart_267.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_267 = 
      ((PartCurve) cadPart_267.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_89 = 
      ((CompositePart) compositePart_83.getChildParts().getPart("DIN985_M5 2"));

    CadPart cadPart_268 = 
      ((CadPart) compositePart_89.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_286 = 
      ((PartSurface) cadPart_268.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_268 = 
      ((PartCurve) cadPart_268.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_269 = 
      ((CadPart) compositePart_83.getChildParts().getPart("DIN7985TX_M4X10"));

    PartSurface partSurface_287 = 
      ((PartSurface) cadPart_269.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_269 = 
      ((PartCurve) cadPart_269.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_270 = 
      ((CadPart) compositePart_83.getChildParts().getPart("DIN7985TX_M4X30"));

    PartSurface partSurface_288 = 
      ((PartSurface) cadPart_270.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_270 = 
      ((PartCurve) cadPart_270.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_271 = 
      ((CadPart) compositePart_83.getChildParts().getPart("DIN7985TX_M5X25"));

    PartSurface partSurface_289 = 
      ((PartSurface) cadPart_271.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_271 = 
      ((PartCurve) cadPart_271.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_90 = 
      ((CompositePart) compositePart_47.getChildParts().getPart("A_RA04_RW_ATTACHMENT_D"));

    CadPart cadPart_272 = 
      ((CadPart) compositePart_90.getChildParts().getPart("A_RA04_ENDPLATE_BRACKET"));

    PartSurface partSurface_290 = 
      ((PartSurface) cadPart_272.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_272 = 
      ((PartCurve) cadPart_272.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_273 = 
      ((CadPart) compositePart_90.getChildParts().getPart("A_RA04_INSERT_ROD_BOTTOM"));

    PartSurface partSurface_291 = 
      ((PartSurface) cadPart_273.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_273 = 
      ((PartCurve) cadPart_273.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_274 = 
      ((CadPart) compositePart_90.getChildParts().getPart("A_RA04_INSERT_ROD_TOP"));

    PartSurface partSurface_292 = 
      ((PartSurface) cadPart_274.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_274 = 
      ((PartCurve) cadPart_274.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_275 = 
      ((CadPart) compositePart_90.getChildParts().getPart("A_RA04_MONO_BRACKET_TYPE_A"));

    PartSurface partSurface_293 = 
      ((PartSurface) cadPart_275.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_275 = 
      ((PartCurve) cadPart_275.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_276 = 
      ((CadPart) compositePart_90.getChildParts().getPart("A_RA04_ROD"));

    PartSurface partSurface_294 = 
      ((PartSurface) cadPart_276.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_276 = 
      ((PartCurve) cadPart_276.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_91 = 
      ((CompositePart) compositePart_90.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5"));

    CadPart cadPart_277 = 
      ((CadPart) compositePart_91.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_295 = 
      ((PartSurface) cadPart_277.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_296 = 
      ((PartSurface) cadPart_277.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_277 = 
      ((PartCurve) cadPart_277.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_92 = 
      ((CompositePart) compositePart_90.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5 2"));

    CadPart cadPart_278 = 
      ((CadPart) compositePart_92.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_297 = 
      ((PartSurface) cadPart_278.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_298 = 
      ((PartSurface) cadPart_278.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_278 = 
      ((PartCurve) cadPart_278.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_279 = 
      ((CadPart) compositePart_90.getChildParts().getPart("ASKUBAL_BALL_M5"));

    PartSurface partSurface_299 = 
      ((PartSurface) cadPart_279.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_279 = 
      ((PartCurve) cadPart_279.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_280 = 
      ((CadPart) compositePart_90.getChildParts().getPart("D125B_5_3"));

    PartSurface partSurface_300 = 
      ((PartSurface) cadPart_280.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_280 = 
      ((PartCurve) cadPart_280.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_93 = 
      ((CompositePart) compositePart_90.getChildParts().getPart("D439_M5"));

    CadPart cadPart_281 = 
      ((CadPart) compositePart_93.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_301 = 
      ((PartSurface) cadPart_281.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_281 = 
      ((PartCurve) cadPart_281.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_94 = 
      ((CompositePart) compositePart_90.getChildParts().getPart("D439_M5 2"));

    CadPart cadPart_282 = 
      ((CadPart) compositePart_94.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_302 = 
      ((PartSurface) cadPart_282.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_282 = 
      ((PartCurve) cadPart_282.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_95 = 
      ((CompositePart) compositePart_90.getChildParts().getPart("DIN985_M5"));

    CadPart cadPart_283 = 
      ((CadPart) compositePart_95.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_303 = 
      ((PartSurface) cadPart_283.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_283 = 
      ((PartCurve) cadPart_283.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_96 = 
      ((CompositePart) compositePart_90.getChildParts().getPart("DIN985_M5 2"));

    CadPart cadPart_284 = 
      ((CadPart) compositePart_96.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_304 = 
      ((PartSurface) cadPart_284.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_284 = 
      ((PartCurve) cadPart_284.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_285 = 
      ((CadPart) compositePart_90.getChildParts().getPart("DIN7985TX_M4X10"));

    PartSurface partSurface_305 = 
      ((PartSurface) cadPart_285.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_285 = 
      ((PartCurve) cadPart_285.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_286 = 
      ((CadPart) compositePart_90.getChildParts().getPart("DIN7985TX_M4X20"));

    PartSurface partSurface_306 = 
      ((PartSurface) cadPart_286.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_286 = 
      ((PartCurve) cadPart_286.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_287 = 
      ((CadPart) compositePart_90.getChildParts().getPart("DIN7985TX_M5X25"));

    PartSurface partSurface_307 = 
      ((PartSurface) cadPart_287.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_287 = 
      ((PartCurve) cadPart_287.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_97 = 
      ((CompositePart) compositePart_47.getChildParts().getPart("A_RA04_RW_ATTACHMENT_D_MIR"));

    CadPart cadPart_288 = 
      ((CadPart) compositePart_97.getChildParts().getPart("A_RA04_ENDPLATE_BRACKET_MIR"));

    PartSurface partSurface_308 = 
      ((PartSurface) cadPart_288.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_288 = 
      ((PartCurve) cadPart_288.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_289 = 
      ((CadPart) compositePart_97.getChildParts().getPart("A_RA04_INSERT_ROD_BOTTOM_MIR"));

    PartSurface partSurface_309 = 
      ((PartSurface) cadPart_289.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_289 = 
      ((PartCurve) cadPart_289.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_290 = 
      ((CadPart) compositePart_97.getChildParts().getPart("A_RA04_INSERT_ROD_TOP_MIR"));

    PartSurface partSurface_310 = 
      ((PartSurface) cadPart_290.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_290 = 
      ((PartCurve) cadPart_290.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_291 = 
      ((CadPart) compositePart_97.getChildParts().getPart("A_RA04_MONO_BRACKET_TYPE_A_MIR"));

    PartSurface partSurface_311 = 
      ((PartSurface) cadPart_291.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_291 = 
      ((PartCurve) cadPart_291.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_292 = 
      ((CadPart) compositePart_97.getChildParts().getPart("A_RA04_ROD_MIR"));

    PartSurface partSurface_312 = 
      ((PartSurface) cadPart_292.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_292 = 
      ((PartCurve) cadPart_292.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_98 = 
      ((CompositePart) compositePart_97.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5"));

    CadPart cadPart_293 = 
      ((CadPart) compositePart_98.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_313 = 
      ((PartSurface) cadPart_293.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_314 = 
      ((PartSurface) cadPart_293.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_293 = 
      ((PartCurve) cadPart_293.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_99 = 
      ((CompositePart) compositePart_97.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5 2"));

    CadPart cadPart_294 = 
      ((CadPart) compositePart_99.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_315 = 
      ((PartSurface) cadPart_294.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_316 = 
      ((PartSurface) cadPart_294.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_294 = 
      ((PartCurve) cadPart_294.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_295 = 
      ((CadPart) compositePart_97.getChildParts().getPart("ASKUBAL_BALL_M5"));

    PartSurface partSurface_317 = 
      ((PartSurface) cadPart_295.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_295 = 
      ((PartCurve) cadPart_295.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_296 = 
      ((CadPart) compositePart_97.getChildParts().getPart("D125B_5_3"));

    PartSurface partSurface_318 = 
      ((PartSurface) cadPart_296.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_296 = 
      ((PartCurve) cadPart_296.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_100 = 
      ((CompositePart) compositePart_97.getChildParts().getPart("D439_M5"));

    CadPart cadPart_297 = 
      ((CadPart) compositePart_100.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_319 = 
      ((PartSurface) cadPart_297.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_297 = 
      ((PartCurve) cadPart_297.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_101 = 
      ((CompositePart) compositePart_97.getChildParts().getPart("D439_M5 2"));

    CadPart cadPart_298 = 
      ((CadPart) compositePart_101.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_320 = 
      ((PartSurface) cadPart_298.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_298 = 
      ((PartCurve) cadPart_298.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_102 = 
      ((CompositePart) compositePart_97.getChildParts().getPart("DIN985_M5"));

    CadPart cadPart_299 = 
      ((CadPart) compositePart_102.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_321 = 
      ((PartSurface) cadPart_299.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_299 = 
      ((PartCurve) cadPart_299.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_103 = 
      ((CompositePart) compositePart_97.getChildParts().getPart("DIN985_M5 2"));

    CadPart cadPart_300 = 
      ((CadPart) compositePart_103.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_322 = 
      ((PartSurface) cadPart_300.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_300 = 
      ((PartCurve) cadPart_300.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_301 = 
      ((CadPart) compositePart_97.getChildParts().getPart("DIN7985TX_M4X10"));

    PartSurface partSurface_323 = 
      ((PartSurface) cadPart_301.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_301 = 
      ((PartCurve) cadPart_301.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_302 = 
      ((CadPart) compositePart_97.getChildParts().getPart("DIN7985TX_M4X20"));

    PartSurface partSurface_324 = 
      ((PartSurface) cadPart_302.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_302 = 
      ((PartCurve) cadPart_302.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_303 = 
      ((CadPart) compositePart_97.getChildParts().getPart("DIN7985TX_M5X25"));

    PartSurface partSurface_325 = 
      ((PartSurface) cadPart_303.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_303 = 
      ((PartCurve) cadPart_303.getPartCurveManager().getPartCurve("Edges"));

    SolidModelCompositePart solidModelCompositePart_4 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("z_000_remaining-parts"));

    CompositePart compositePart_104 = 
      ((CompositePart) solidModelCompositePart_4.getChildParts().getPart("Suspension_Front_Left"));

    CadPart cadPart_304 = 
      ((CadPart) compositePart_104.getChildParts().getPart("S_FL02_U"));

    PartSurface partSurface_326 = 
      ((PartSurface) cadPart_304.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_304 = 
      ((PartCurve) cadPart_304.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_305 = 
      ((CadPart) compositePart_104.getChildParts().getPart("S_FL03_L"));

    PartSurface partSurface_327 = 
      ((PartSurface) cadPart_305.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_305 = 
      ((PartCurve) cadPart_305.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_306 = 
      ((CadPart) compositePart_104.getChildParts().getPart("S_FL03_L 2"));

    PartSurface partSurface_328 = 
      ((PartSurface) cadPart_306.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_306 = 
      ((PartCurve) cadPart_306.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_307 = 
      ((CadPart) compositePart_104.getChildParts().getPart("S_FL04_T"));

    PartSurface partSurface_329 = 
      ((PartSurface) cadPart_307.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_307 = 
      ((PartCurve) cadPart_307.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_308 = 
      ((CadPart) compositePart_104.getChildParts().getPart("S_FL06_P"));

    PartSurface partSurface_330 = 
      ((PartSurface) cadPart_308.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_308 = 
      ((PartCurve) cadPart_308.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_105 = 
      ((CompositePart) solidModelCompositePart_4.getChildParts().getPart("Suspension_Front_Right"));

    CadPart cadPart_309 = 
      ((CadPart) compositePart_105.getChildParts().getPart("S_FL02_U"));

    PartSurface partSurface_331 = 
      ((PartSurface) cadPart_309.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_309 = 
      ((PartCurve) cadPart_309.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_310 = 
      ((CadPart) compositePart_105.getChildParts().getPart("S_FL03_L"));

    PartSurface partSurface_332 = 
      ((PartSurface) cadPart_310.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_310 = 
      ((PartCurve) cadPart_310.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_311 = 
      ((CadPart) compositePart_105.getChildParts().getPart("S_FL03_L 2"));

    PartSurface partSurface_333 = 
      ((PartSurface) cadPart_311.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_311 = 
      ((PartCurve) cadPart_311.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_312 = 
      ((CadPart) compositePart_105.getChildParts().getPart("S_FL04_T"));

    PartSurface partSurface_334 = 
      ((PartSurface) cadPart_312.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_312 = 
      ((PartCurve) cadPart_312.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_313 = 
      ((CadPart) compositePart_105.getChildParts().getPart("S_FL06_P"));

    PartSurface partSurface_335 = 
      ((PartSurface) cadPart_313.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_313 = 
      ((PartCurve) cadPart_313.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_106 = 
      ((CompositePart) solidModelCompositePart_4.getChildParts().getPart("Suspension_Rear_Left"));

    CadPart cadPart_314 = 
      ((CadPart) compositePart_106.getChildParts().getPart("S_RL02_U"));

    PartSurface partSurface_336 = 
      ((PartSurface) cadPart_314.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_314 = 
      ((PartCurve) cadPart_314.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_315 = 
      ((CadPart) compositePart_106.getChildParts().getPart("S_RL02_U 2"));

    PartSurface partSurface_337 = 
      ((PartSurface) cadPart_315.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_315 = 
      ((PartCurve) cadPart_315.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_316 = 
      ((CadPart) compositePart_106.getChildParts().getPart("S_RL03_L"));

    PartSurface partSurface_338 = 
      ((PartSurface) cadPart_316.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_316 = 
      ((PartCurve) cadPart_316.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_317 = 
      ((CadPart) compositePart_106.getChildParts().getPart("S_RL03_L 2"));

    PartSurface partSurface_339 = 
      ((PartSurface) cadPart_317.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_317 = 
      ((PartCurve) cadPart_317.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_318 = 
      ((CadPart) compositePart_106.getChildParts().getPart("S_RL04_T"));

    PartSurface partSurface_340 = 
      ((PartSurface) cadPart_318.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_318 = 
      ((PartCurve) cadPart_318.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_319 = 
      ((CadPart) compositePart_106.getChildParts().getPart("S_RL06_P"));

    PartSurface partSurface_341 = 
      ((PartSurface) cadPart_319.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_319 = 
      ((PartCurve) cadPart_319.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_320 = 
      ((CadPart) compositePart_106.getChildParts().getPart("S_RL06_P 2"));

    PartSurface partSurface_342 = 
      ((PartSurface) cadPart_320.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_320 = 
      ((PartCurve) cadPart_320.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_107 = 
      ((CompositePart) solidModelCompositePart_4.getChildParts().getPart("Suspension_Rear_Right"));

    CadPart cadPart_323 = 
      ((CadPart) compositePart_107.getChildParts().getPart("S_RL02_U"));

    PartSurface partSurface_345 = 
      ((PartSurface) cadPart_323.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_323 = 
      ((PartCurve) cadPart_323.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_324 = 
      ((CadPart) compositePart_107.getChildParts().getPart("S_RL02_U 2"));

    PartSurface partSurface_346 = 
      ((PartSurface) cadPart_324.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_324 = 
      ((PartCurve) cadPart_324.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_325 = 
      ((CadPart) compositePart_107.getChildParts().getPart("S_RL03_L"));

    PartSurface partSurface_347 = 
      ((PartSurface) cadPart_325.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_325 = 
      ((PartCurve) cadPart_325.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_326 = 
      ((CadPart) compositePart_107.getChildParts().getPart("S_RL03_L 2"));

    PartSurface partSurface_348 = 
      ((PartSurface) cadPart_326.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_326 = 
      ((PartCurve) cadPart_326.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_327 = 
      ((CadPart) compositePart_107.getChildParts().getPart("S_RL04_T"));

    PartSurface partSurface_349 = 
      ((PartSurface) cadPart_327.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_327 = 
      ((PartCurve) cadPart_327.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_328 = 
      ((CadPart) compositePart_107.getChildParts().getPart("S_RL06_P"));

    PartSurface partSurface_350 = 
      ((PartSurface) cadPart_328.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_328 = 
      ((PartCurve) cadPart_328.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_329 = 
      ((CadPart) compositePart_107.getChildParts().getPart("S_RL06_P 2"));

    PartSurface partSurface_351 = 
      ((PartSurface) cadPart_329.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_329 = 
      ((PartCurve) cadPart_329.getPartCurveManager().getPartCurve("Edges"));

    partDisplayer_7.getInputParts().setObjects(partSurface_149, partCurve_147, partSurface_150, partCurve_148, partSurface_151, partCurve_149, partSurface_152, partCurve_150, partSurface_153, partCurve_151, partSurface_154, partCurve_152, partSurface_155, partSurface_156, partCurve_153, partSurface_157, partSurface_158, partCurve_154, partSurface_159, partCurve_155, partSurface_160, partCurve_156, partSurface_161, partCurve_157, partSurface_162, partCurve_158, partSurface_163, partCurve_159, partSurface_164, partCurve_160, partSurface_165, partCurve_161, partSurface_166, partCurve_162, partSurface_167, partCurve_163, partSurface_168, partCurve_164, partSurface_169, partCurve_165, partSurface_170, partCurve_166, partSurface_171, partCurve_167, partSurface_172, partCurve_168, partSurface_173, partSurface_174, partCurve_169, partSurface_175, partSurface_176, partCurve_170, partSurface_177, partCurve_171, partSurface_178, partCurve_172, partSurface_179, partCurve_173, partSurface_180, partCurve_174, partSurface_181, partCurve_175, partSurface_182, partCurve_176, partSurface_183, partCurve_177, partSurface_184, partCurve_178, partSurface_185, partCurve_179, partSurface_186, partCurve_180, partSurface_187, partCurve_181, partSurface_188, partCurve_182, partSurface_189, partCurve_183, partSurface_190, partSurface_191, partCurve_184, partSurface_192, partSurface_193, partCurve_185, partSurface_194, partCurve_186, partSurface_195, partCurve_187, partSurface_196, partCurve_188, partSurface_197, partCurve_189, partSurface_198, partCurve_190, partSurface_199, partCurve_191, partSurface_200, partCurve_192, partSurface_201, partCurve_193, partSurface_202, partCurve_194, partSurface_203, partCurve_195, partSurface_204, partCurve_196, partSurface_205, partCurve_197, partSurface_206, partCurve_198, partSurface_207, partSurface_208, partCurve_199, partSurface_209, partSurface_210, partCurve_200, partSurface_211, partCurve_201, partSurface_212, partCurve_202, partSurface_213, partCurve_203, partSurface_214, partCurve_204, partSurface_215, partCurve_205, partSurface_216, partCurve_206, partSurface_217, partCurve_207, partSurface_218, partCurve_208, partSurface_219, partCurve_209, partSurface_220, partCurve_210, partSurface_221, partCurve_211, partSurface_222, partCurve_212, partSurface_223, partSurface_224, partCurve_213, partSurface_225, partSurface_226, partCurve_214, partSurface_227, partCurve_215, partSurface_228, partCurve_216, partSurface_229, partCurve_217, partSurface_230, partCurve_218, partSurface_231, partCurve_219, partSurface_232, partCurve_220, partSurface_233, partCurve_221, partSurface_234, partCurve_222, partSurface_235, partCurve_223, partSurface_236, partCurve_224, partSurface_237, partCurve_225, partSurface_238, partCurve_226, partSurface_239, partCurve_227, partSurface_240, partCurve_228, partSurface_241, partSurface_242, partCurve_229, partSurface_243, partSurface_244, partCurve_230, partSurface_245, partCurve_231, partSurface_246, partCurve_232, partSurface_247, partCurve_233, partSurface_248, partCurve_234, partSurface_249, partCurve_235, partSurface_250, partCurve_236, partSurface_251, partCurve_237, partSurface_252, partCurve_238, partSurface_253, partCurve_239, partSurface_254, partCurve_240, partSurface_255, partCurve_241, partSurface_256, partCurve_242, partSurface_257, partCurve_243, partSurface_258, partCurve_244, partSurface_259, partSurface_260, partCurve_245, partSurface_261, partSurface_262, partCurve_246, partSurface_263, partCurve_247, partSurface_264, partCurve_248, partSurface_265, partCurve_249, partSurface_266, partCurve_250, partSurface_267, partCurve_251, partSurface_268, partCurve_252, partSurface_269, partCurve_253, partSurface_270, partCurve_254, partSurface_271, partCurve_255, partSurface_272, partCurve_256, partSurface_273, partCurve_257, partSurface_274, partCurve_258, partSurface_275, partCurve_259, partSurface_276, partCurve_260, partSurface_277, partSurface_278, partCurve_261, partSurface_279, partSurface_280, partCurve_262, partSurface_281, partCurve_263, partSurface_282, partCurve_264, partSurface_283, partCurve_265, partSurface_284, partCurve_266, partSurface_285, partCurve_267, partSurface_286, partCurve_268, partSurface_287, partCurve_269, partSurface_288, partCurve_270, partSurface_289, partCurve_271, partSurface_290, partCurve_272, partSurface_291, partCurve_273, partSurface_292, partCurve_274, partSurface_293, partCurve_275, partSurface_294, partCurve_276, partSurface_295, partSurface_296, partCurve_277, partSurface_297, partSurface_298, partCurve_278, partSurface_299, partCurve_279, partSurface_300, partCurve_280, partSurface_301, partCurve_281, partSurface_302, partCurve_282, partSurface_303, partCurve_283, partSurface_304, partCurve_284, partSurface_305, partCurve_285, partSurface_306, partCurve_286, partSurface_307, partCurve_287, partSurface_308, partCurve_288, partSurface_309, partCurve_289, partSurface_310, partCurve_290, partSurface_311, partCurve_291, partSurface_312, partCurve_292, partSurface_313, partSurface_314, partCurve_293, partSurface_315, partSurface_316, partCurve_294, partSurface_317, partCurve_295, partSurface_318, partCurve_296, partSurface_319, partCurve_297, partSurface_320, partCurve_298, partSurface_321, partCurve_299, partSurface_322, partCurve_300, partSurface_323, partCurve_301, partSurface_324, partCurve_302, partSurface_325, partCurve_303, partSurface_326, partCurve_304, partSurface_327, partCurve_305, partSurface_328, partCurve_306, partSurface_329, partCurve_307, partSurface_330, partCurve_308, partSurface_331, partCurve_309, partSurface_332, partCurve_310, partSurface_333, partCurve_311, partSurface_334, partCurve_312, partSurface_335, partCurve_313, partSurface_336, partCurve_314, partSurface_337, partCurve_315, partSurface_338, partCurve_316, partSurface_339, partCurve_317, partSurface_340, partCurve_318, partSurface_341, partCurve_319, partSurface_342, partCurve_320, partSurface_345, partCurve_323, partSurface_346, partCurve_324, partSurface_347, partCurve_325, partSurface_348, partCurve_326, partSurface_349, partCurve_327, partSurface_350, partCurve_328, partSurface_351, partCurve_329);
  }

  private void execute5() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Scene scene_1 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 2");

    PartDisplayer partDisplayer_7 = 
      ((PartDisplayer) scene_1.getDisplayerManager().getObject("rods"));

    partDisplayer_7.setColorMode(PartColorMode.PRESET);

    PresetColorSettings presetColorSettings_5 = 
      partDisplayer_7.getPresetColorSettings();

    RayTraceMatteMaterial rayTraceMatteMaterial_2 = 
      ((RayTraceMatteMaterial) simulation_0.get(RayTraceMaterialManager.class).getObject("Matte Black"));

    presetColorSettings_5.setRayTraceMaterial(rayTraceMatteMaterial_2);

    CurrentView currentView_0 = 
      scene_1.getCurrentView();

    currentView_0.setInput(new DoubleVector(new double[] {0.9089511459074806, 0.5340463896987252, 0.6403085081186078}), new DoubleVector(new double[] {3.8531053982957397, 4.1781476951713366, 2.318728886928127}), new DoubleVector(new double[] {-0.1560761229715739, -0.3064014622741314, 0.9390199080714277}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.433522521188003, 0.44520341780190353, 0.6043416583082458}), new DoubleVector(new double[] {2.9290458809515956, 2.2962744421065766, 1.4569182113121248}), new DoubleVector(new double[] {-0.1560761229715739, -0.3064014622741314, 0.9390199080714277}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.7388919317314468, 0.31553227840762677, 0.5004502881435675}), new DoubleVector(new double[] {2.5356283742162544, 1.3016858767869584, 0.9546583788106694}), new DoubleVector(new double[] {-0.1560761229715739, -0.3064014622741314, 0.9390199080714277}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.7936361910266085, 0.38169669591038624, 0.5314324399587577}), new DoubleVector(new double[] {2.62197077033115, 1.2496546403846083, 0.9812864749637848}), new DoubleVector(new double[] {-0.16923488001396758, -0.3213837974091914, 0.931703821044839}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.3891603117676414, 0.328046021002097, 0.7157068268265931}), new DoubleVector(new double[] {3.8303421224906815, 2.8860017063750076, 2.041470008965689}), new DoubleVector(new double[] {-0.16923488001396758, -0.3213837974091914, 0.931703821044839}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.316586968722128, 0.34760168540396885, 0.531263348875411}), new DoubleVector(new double[] {3.821394701690493, 2.9722268375202505, 1.8915806575330523}), new DoubleVector(new double[] {-0.16923488001396758, -0.3213837974091914, 0.931703821044839}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.1957086120053626, 0.2135536344537867, 0.4637352987234196}), new DoubleVector(new double[] {3.0598065508414685, 3.5120176024290894, 1.8186314084551547}), new DoubleVector(new double[] {-0.15341370182209813, -0.3000395532524875, 0.941509693299725}), 1.5102818616783267, 0, 30.0);

    PartDisplayer partDisplayer_8 = 
      scene_1.getDisplayerManager().createPartDisplayer("Surface", -1, 1);

    partDisplayer_8.setPresentationName("tires");

    partDisplayer_8.setColorMode(PartColorMode.PRESET);

    PartRepresentation partRepresentation_0 = 
      ((PartRepresentation) simulation_0.getRepresentationManager().getObject("Geometry"));

    partDisplayer_8.setRepresentation(partRepresentation_0);

    partDisplayer_8.getInputParts().setQuery(null);

    SolidModelCompositePart solidModelCompositePart_5 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("W_wheel_front-left"));

    SolidModelPart solidModelPart_0 = 
      ((SolidModelPart) solidModelCompositePart_5.getChildParts().getPart("tire"));

    PartSurface partSurface_354 = 
      ((PartSurface) solidModelPart_0.getPartSurfaceManager().getPartSurface("contact_surface"));

    PartSurface partSurface_355 = 
      ((PartSurface) solidModelPart_0.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_332 = 
      ((PartCurve) solidModelPart_0.getPartCurveManager().getPartCurve("Default"));

    PartCurve partCurve_333 = 
      ((PartCurve) solidModelPart_0.getPartCurveManager().getPartCurve("Default 2"));

    PartCurve partCurve_334 = 
      ((PartCurve) solidModelPart_0.getPartCurveManager().getPartCurve("Default 3"));

    SolidModelCompositePart solidModelCompositePart_6 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("W_wheel_front-right"));

    SolidModelPart solidModelPart_1 = 
      ((SolidModelPart) solidModelCompositePart_6.getChildParts().getPart("Rim"));

    PartSurface partSurface_356 = 
      ((PartSurface) solidModelPart_1.getPartSurfaceManager().getPartSurface("Default"));

    PartSurface partSurface_357 = 
      ((PartSurface) solidModelPart_1.getPartSurfaceManager().getPartSurface("Default 2"));

    PartCurve partCurve_335 = 
      ((PartCurve) solidModelPart_1.getPartCurveManager().getPartCurve("Default"));

    PartCurve partCurve_336 = 
      ((PartCurve) solidModelPart_1.getPartCurveManager().getPartCurve("Default 2"));

    SolidModelCompositePart solidModelCompositePart_7 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("W_wheel_rear-left"));

    SolidModelPart solidModelPart_2 = 
      ((SolidModelPart) solidModelCompositePart_7.getChildParts().getPart("tire"));

    PartSurface partSurface_358 = 
      ((PartSurface) solidModelPart_2.getPartSurfaceManager().getPartSurface("contact_surface"));

    PartSurface partSurface_359 = 
      ((PartSurface) solidModelPart_2.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_337 = 
      ((PartCurve) solidModelPart_2.getPartCurveManager().getPartCurve("Default"));

    PartCurve partCurve_338 = 
      ((PartCurve) solidModelPart_2.getPartCurveManager().getPartCurve("Default 2"));

    PartCurve partCurve_339 = 
      ((PartCurve) solidModelPart_2.getPartCurveManager().getPartCurve("Default 3"));

    SolidModelCompositePart solidModelCompositePart_8 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("W_wheel_rear-right"));

    SolidModelPart solidModelPart_3 = 
      ((SolidModelPart) solidModelCompositePart_8.getChildParts().getPart("tire"));

    PartSurface partSurface_360 = 
      ((PartSurface) solidModelPart_3.getPartSurfaceManager().getPartSurface("contact_surface"));

    PartSurface partSurface_361 = 
      ((PartSurface) solidModelPart_3.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_340 = 
      ((PartCurve) solidModelPart_3.getPartCurveManager().getPartCurve("Default"));

    PartCurve partCurve_341 = 
      ((PartCurve) solidModelPart_3.getPartCurveManager().getPartCurve("Default 2"));

    PartCurve partCurve_342 = 
      ((PartCurve) solidModelPart_3.getPartCurveManager().getPartCurve("Default 3"));

    partDisplayer_8.getInputParts().setObjects(partSurface_354, partSurface_355, partCurve_332, partCurve_333, partCurve_334, partSurface_356, partSurface_357, partCurve_335, partCurve_336, partSurface_358, partSurface_359, partCurve_337, partCurve_338, partCurve_339, partSurface_360, partSurface_361, partCurve_340, partCurve_341, partCurve_342);

    PresetColorSettings presetColorSettings_6 = 
      partDisplayer_8.getPresetColorSettings();

    RayTraceMatteMaterial rayTraceMatteMaterial_3 = 
      ((RayTraceMatteMaterial) simulation_0.get(RayTraceMaterialManager.class).getObject("Dark Rubber"));

    presetColorSettings_6.setRayTraceMaterial(rayTraceMatteMaterial_3);

    PartDisplayer partDisplayer_9 = 
      scene_1.getDisplayerManager().createPartDisplayer("Surface", -1, 1);

    partDisplayer_9.setPresentationName("wheelhub");

    partDisplayer_9.setColorMode(PartColorMode.PRESET);

    partDisplayer_9.setRepresentation(partRepresentation_0);

    partDisplayer_9.getInputParts().setQuery(null);

    SolidModelCompositePart solidModelCompositePart_9 = 
      ((SolidModelCompositePart) solidModelCompositePart_5.getChildParts().getPart("wheelhub"));

    SolidModelPart solidModelPart_4 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 14"));

    PartSurface partSurface_362 = 
      ((PartSurface) solidModelPart_4.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_343 = 
      ((PartCurve) solidModelPart_4.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_5 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 15"));

    PartSurface partSurface_363 = 
      ((PartSurface) solidModelPart_5.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_344 = 
      ((PartCurve) solidModelPart_5.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_6 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 16"));

    PartSurface partSurface_364 = 
      ((PartSurface) solidModelPart_6.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_345 = 
      ((PartCurve) solidModelPart_6.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_7 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 17"));

    PartSurface partSurface_365 = 
      ((PartSurface) solidModelPart_7.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_346 = 
      ((PartCurve) solidModelPart_7.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_8 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 18"));

    PartSurface partSurface_366 = 
      ((PartSurface) solidModelPart_8.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_347 = 
      ((PartCurve) solidModelPart_8.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_9 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 19"));

    PartSurface partSurface_367 = 
      ((PartSurface) solidModelPart_9.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_348 = 
      ((PartCurve) solidModelPart_9.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_10 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 20"));

    PartSurface partSurface_368 = 
      ((PartSurface) solidModelPart_10.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_349 = 
      ((PartCurve) solidModelPart_10.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_11 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 21"));

    PartSurface partSurface_369 = 
      ((PartSurface) solidModelPart_11.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_350 = 
      ((PartCurve) solidModelPart_11.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_12 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 22"));

    PartSurface partSurface_370 = 
      ((PartSurface) solidModelPart_12.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_351 = 
      ((PartCurve) solidModelPart_12.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_13 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 23"));

    PartSurface partSurface_371 = 
      ((PartSurface) solidModelPart_13.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_352 = 
      ((PartCurve) solidModelPart_13.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_14 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 24"));

    PartSurface partSurface_372 = 
      ((PartSurface) solidModelPart_14.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_353 = 
      ((PartCurve) solidModelPart_14.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_15 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 25"));

    PartSurface partSurface_373 = 
      ((PartSurface) solidModelPart_15.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_354 = 
      ((PartCurve) solidModelPart_15.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_16 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 26"));

    PartSurface partSurface_374 = 
      ((PartSurface) solidModelPart_16.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_355 = 
      ((PartCurve) solidModelPart_16.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_17 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("Body 37 2"));

    PartSurface partSurface_375 = 
      ((PartSurface) solidModelPart_17.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_356 = 
      ((PartCurve) solidModelPart_17.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_18 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("TRM_SRF 2 8"));

    PartSurface partSurface_376 = 
      ((PartSurface) solidModelPart_18.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_357 = 
      ((PartCurve) solidModelPart_18.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_19 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("TRM_SRF 3 10"));

    PartSurface partSurface_377 = 
      ((PartSurface) solidModelPart_19.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_358 = 
      ((PartCurve) solidModelPart_19.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_20 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("TRM_SRF 4 9"));

    PartSurface partSurface_378 = 
      ((PartSurface) solidModelPart_20.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_359 = 
      ((PartCurve) solidModelPart_20.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_21 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("TRM_SRF 5 9"));

    PartSurface partSurface_379 = 
      ((PartSurface) solidModelPart_21.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_360 = 
      ((PartCurve) solidModelPart_21.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_22 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("TRM_SRF 6 9"));

    PartSurface partSurface_380 = 
      ((PartSurface) solidModelPart_22.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_361 = 
      ((PartCurve) solidModelPart_22.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_23 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("TRM_SRF 7 9"));

    PartSurface partSurface_381 = 
      ((PartSurface) solidModelPart_23.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_362 = 
      ((PartCurve) solidModelPart_23.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_24 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("TRM_SRF 8 9"));

    PartSurface partSurface_382 = 
      ((PartSurface) solidModelPart_24.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_363 = 
      ((PartCurve) solidModelPart_24.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_25 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("TRM_SRF 9 8"));

    PartSurface partSurface_383 = 
      ((PartSurface) solidModelPart_25.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_364 = 
      ((PartCurve) solidModelPart_25.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_26 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("TRM_SRF 10 6"));

    PartSurface partSurface_384 = 
      ((PartSurface) solidModelPart_26.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_365 = 
      ((PartCurve) solidModelPart_26.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_27 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("TRM_SRF 11 7"));

    PartSurface partSurface_385 = 
      ((PartSurface) solidModelPart_27.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_366 = 
      ((PartCurve) solidModelPart_27.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_28 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("TRM_SRF 12 5"));

    PartSurface partSurface_386 = 
      ((PartSurface) solidModelPart_28.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_367 = 
      ((PartCurve) solidModelPart_28.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_29 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("TRM_SRF 13 6"));

    PartSurface partSurface_387 = 
      ((PartSurface) solidModelPart_29.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_368 = 
      ((PartCurve) solidModelPart_29.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_30 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("TRM_SRF 14 7"));

    PartSurface partSurface_388 = 
      ((PartSurface) solidModelPart_30.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_369 = 
      ((PartCurve) solidModelPart_30.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_31 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("TRM_SRF 15 7"));

    PartSurface partSurface_389 = 
      ((PartSurface) solidModelPart_31.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_370 = 
      ((PartCurve) solidModelPart_31.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_32 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("TRM_SRF 16 7"));

    PartSurface partSurface_390 = 
      ((PartSurface) solidModelPart_32.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_371 = 
      ((PartCurve) solidModelPart_32.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_33 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("TRM_SRF 17 7"));

    PartSurface partSurface_391 = 
      ((PartSurface) solidModelPart_33.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_372 = 
      ((PartCurve) solidModelPart_33.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_34 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("TRM_SRF 18 7"));

    PartSurface partSurface_392 = 
      ((PartSurface) solidModelPart_34.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_373 = 
      ((PartCurve) solidModelPart_34.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_35 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("TRM_SRF 19 7"));

    PartSurface partSurface_393 = 
      ((PartSurface) solidModelPart_35.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_374 = 
      ((PartCurve) solidModelPart_35.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_36 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("TRM_SRF 20 6"));

    PartSurface partSurface_394 = 
      ((PartSurface) solidModelPart_36.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_375 = 
      ((PartCurve) solidModelPart_36.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_37 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("TRM_SRF 21 6"));

    PartSurface partSurface_395 = 
      ((PartSurface) solidModelPart_37.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_376 = 
      ((PartCurve) solidModelPart_37.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_38 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("TRM_SRF 22 6"));

    PartSurface partSurface_396 = 
      ((PartSurface) solidModelPart_38.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_377 = 
      ((PartCurve) solidModelPart_38.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_39 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("TRM_SRF 23 6"));

    PartSurface partSurface_397 = 
      ((PartSurface) solidModelPart_39.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_378 = 
      ((PartCurve) solidModelPart_39.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_40 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("TRM_SRF 88"));

    PartSurface partSurface_398 = 
      ((PartSurface) solidModelPart_40.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_379 = 
      ((PartCurve) solidModelPart_40.getPartCurveManager().getPartCurve("Default"));

    SolidModelCompositePart solidModelCompositePart_10 = 
      ((SolidModelCompositePart) solidModelCompositePart_6.getChildParts().getPart("wheelhub"));

    SolidModelPart solidModelPart_41 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body"));

    PartSurface partSurface_399 = 
      ((PartSurface) solidModelPart_41.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_380 = 
      ((PartCurve) solidModelPart_41.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_42 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 2"));

    PartSurface partSurface_400 = 
      ((PartSurface) solidModelPart_42.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_381 = 
      ((PartCurve) solidModelPart_42.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_43 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 3"));

    PartSurface partSurface_401 = 
      ((PartSurface) solidModelPart_43.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_382 = 
      ((PartCurve) solidModelPart_43.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_44 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 4"));

    PartSurface partSurface_402 = 
      ((PartSurface) solidModelPart_44.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_383 = 
      ((PartCurve) solidModelPart_44.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_45 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 5"));

    PartSurface partSurface_403 = 
      ((PartSurface) solidModelPart_45.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_384 = 
      ((PartCurve) solidModelPart_45.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_46 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 6"));

    PartSurface partSurface_404 = 
      ((PartSurface) solidModelPart_46.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_385 = 
      ((PartCurve) solidModelPart_46.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_47 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 7"));

    PartSurface partSurface_405 = 
      ((PartSurface) solidModelPart_47.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_386 = 
      ((PartCurve) solidModelPart_47.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_48 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 8"));

    PartSurface partSurface_406 = 
      ((PartSurface) solidModelPart_48.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_387 = 
      ((PartCurve) solidModelPart_48.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_49 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 9"));

    PartSurface partSurface_407 = 
      ((PartSurface) solidModelPart_49.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_388 = 
      ((PartCurve) solidModelPart_49.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_50 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 10"));

    PartSurface partSurface_408 = 
      ((PartSurface) solidModelPart_50.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_389 = 
      ((PartCurve) solidModelPart_50.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_51 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 11"));

    PartSurface partSurface_409 = 
      ((PartSurface) solidModelPart_51.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_390 = 
      ((PartCurve) solidModelPart_51.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_52 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 12"));

    PartSurface partSurface_410 = 
      ((PartSurface) solidModelPart_52.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_391 = 
      ((PartCurve) solidModelPart_52.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_53 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 13"));

    PartSurface partSurface_411 = 
      ((PartSurface) solidModelPart_53.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_392 = 
      ((PartCurve) solidModelPart_53.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_54 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("Body 37"));

    PartSurface partSurface_412 = 
      ((PartSurface) solidModelPart_54.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_393 = 
      ((PartCurve) solidModelPart_54.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_55 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("TRM_SRF 2 6"));

    PartSurface partSurface_413 = 
      ((PartSurface) solidModelPart_55.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_394 = 
      ((PartCurve) solidModelPart_55.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_56 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("TRM_SRF 3 8"));

    PartSurface partSurface_414 = 
      ((PartSurface) solidModelPart_56.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_395 = 
      ((PartCurve) solidModelPart_56.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_57 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("TRM_SRF 4 7"));

    PartSurface partSurface_415 = 
      ((PartSurface) solidModelPart_57.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_396 = 
      ((PartCurve) solidModelPart_57.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_58 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("TRM_SRF 5 7"));

    PartSurface partSurface_416 = 
      ((PartSurface) solidModelPart_58.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_397 = 
      ((PartCurve) solidModelPart_58.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_59 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("TRM_SRF 6 7"));

    PartSurface partSurface_417 = 
      ((PartSurface) solidModelPart_59.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_398 = 
      ((PartCurve) solidModelPart_59.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_60 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("TRM_SRF 7 7"));

    PartSurface partSurface_418 = 
      ((PartSurface) solidModelPart_60.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_399 = 
      ((PartCurve) solidModelPart_60.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_61 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("TRM_SRF 8 7"));

    PartSurface partSurface_419 = 
      ((PartSurface) solidModelPart_61.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_400 = 
      ((PartCurve) solidModelPart_61.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_62 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("TRM_SRF 9 6"));

    PartSurface partSurface_420 = 
      ((PartSurface) solidModelPart_62.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_401 = 
      ((PartCurve) solidModelPart_62.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_63 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("TRM_SRF 10 4"));

    PartSurface partSurface_421 = 
      ((PartSurface) solidModelPart_63.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_402 = 
      ((PartCurve) solidModelPart_63.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_64 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("TRM_SRF 11 5"));

    PartSurface partSurface_422 = 
      ((PartSurface) solidModelPart_64.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_403 = 
      ((PartCurve) solidModelPart_64.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_65 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("TRM_SRF 12 3"));

    PartSurface partSurface_423 = 
      ((PartSurface) solidModelPart_65.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_404 = 
      ((PartCurve) solidModelPart_65.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_66 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("TRM_SRF 13 5"));

    PartSurface partSurface_424 = 
      ((PartSurface) solidModelPart_66.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_405 = 
      ((PartCurve) solidModelPart_66.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_67 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("TRM_SRF 14 5"));

    PartSurface partSurface_425 = 
      ((PartSurface) solidModelPart_67.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_406 = 
      ((PartCurve) solidModelPart_67.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_68 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("TRM_SRF 15 5"));

    PartSurface partSurface_426 = 
      ((PartSurface) solidModelPart_68.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_407 = 
      ((PartCurve) solidModelPart_68.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_69 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("TRM_SRF 16 5"));

    PartSurface partSurface_427 = 
      ((PartSurface) solidModelPart_69.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_408 = 
      ((PartCurve) solidModelPart_69.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_70 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("TRM_SRF 17 5"));

    PartSurface partSurface_428 = 
      ((PartSurface) solidModelPart_70.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_409 = 
      ((PartCurve) solidModelPart_70.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_71 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("TRM_SRF 18 5"));

    PartSurface partSurface_429 = 
      ((PartSurface) solidModelPart_71.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_410 = 
      ((PartCurve) solidModelPart_71.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_72 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("TRM_SRF 19 5"));

    PartSurface partSurface_430 = 
      ((PartSurface) solidModelPart_72.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_411 = 
      ((PartCurve) solidModelPart_72.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_73 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("TRM_SRF 20 5"));

    PartSurface partSurface_431 = 
      ((PartSurface) solidModelPart_73.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_412 = 
      ((PartCurve) solidModelPart_73.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_74 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("TRM_SRF 21 5"));

    PartSurface partSurface_432 = 
      ((PartSurface) solidModelPart_74.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_413 = 
      ((PartCurve) solidModelPart_74.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_75 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("TRM_SRF 22 5"));

    PartSurface partSurface_433 = 
      ((PartSurface) solidModelPart_75.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_414 = 
      ((PartCurve) solidModelPart_75.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_76 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("TRM_SRF 23 5"));

    PartSurface partSurface_434 = 
      ((PartSurface) solidModelPart_76.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_415 = 
      ((PartCurve) solidModelPart_76.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_77 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("TRM_SRF 86"));

    PartSurface partSurface_435 = 
      ((PartSurface) solidModelPart_77.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_416 = 
      ((PartCurve) solidModelPart_77.getPartCurveManager().getPartCurve("Default"));

    SolidModelCompositePart solidModelCompositePart_11 = 
      ((SolidModelCompositePart) solidModelCompositePart_7.getChildParts().getPart("wheelhub"));

    SolidModelPart solidModelPart_78 = 
      ((SolidModelPart) solidModelCompositePart_11.getChildParts().getPart("Body 1 10"));

    PartSurface partSurface_436 = 
      ((PartSurface) solidModelPart_78.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_417 = 
      ((PartCurve) solidModelPart_78.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_79 = 
      ((SolidModelPart) solidModelCompositePart_11.getChildParts().getPart("de255532-0c4a-485e-9789-59152b929c88_Body 3"));

    PartSurface partSurface_437 = 
      ((PartSurface) solidModelPart_79.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_418 = 
      ((PartCurve) solidModelPart_79.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_80 = 
      ((SolidModelPart) solidModelCompositePart_11.getChildParts().getPart("de255532-0c4a-485e-9789-59152b929c88_Body 4"));

    PartSurface partSurface_438 = 
      ((PartSurface) solidModelPart_80.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_419 = 
      ((PartCurve) solidModelPart_80.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_81 = 
      ((SolidModelPart) solidModelCompositePart_11.getChildParts().getPart("TRM_SRF 2 9"));

    PartSurface partSurface_439 = 
      ((PartSurface) solidModelPart_81.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_420 = 
      ((PartCurve) solidModelPart_81.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_82 = 
      ((SolidModelPart) solidModelCompositePart_11.getChildParts().getPart("TRM_SRF 3 11"));

    PartSurface partSurface_440 = 
      ((PartSurface) solidModelPart_82.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_421 = 
      ((PartCurve) solidModelPart_82.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_83 = 
      ((SolidModelPart) solidModelCompositePart_11.getChildParts().getPart("TRM_SRF 4 10"));

    PartSurface partSurface_441 = 
      ((PartSurface) solidModelPart_83.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_422 = 
      ((PartCurve) solidModelPart_83.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_84 = 
      ((SolidModelPart) solidModelCompositePart_11.getChildParts().getPart("TRM_SRF 5 10"));

    PartSurface partSurface_442 = 
      ((PartSurface) solidModelPart_84.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_423 = 
      ((PartCurve) solidModelPart_84.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_85 = 
      ((SolidModelPart) solidModelCompositePart_11.getChildParts().getPart("TRM_SRF 6 10"));

    PartSurface partSurface_443 = 
      ((PartSurface) solidModelPart_85.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_424 = 
      ((PartCurve) solidModelPart_85.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_86 = 
      ((SolidModelPart) solidModelCompositePart_11.getChildParts().getPart("TRM_SRF 7 10"));

    PartSurface partSurface_444 = 
      ((PartSurface) solidModelPart_86.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_425 = 
      ((PartCurve) solidModelPart_86.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_87 = 
      ((SolidModelPart) solidModelCompositePart_11.getChildParts().getPart("TRM_SRF 8 10"));

    PartSurface partSurface_445 = 
      ((PartSurface) solidModelPart_87.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_426 = 
      ((PartCurve) solidModelPart_87.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_88 = 
      ((SolidModelPart) solidModelCompositePart_11.getChildParts().getPart("TRM_SRF 9 9"));

    PartSurface partSurface_446 = 
      ((PartSurface) solidModelPart_88.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_427 = 
      ((PartCurve) solidModelPart_88.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_89 = 
      ((SolidModelPart) solidModelCompositePart_11.getChildParts().getPart("TRM_SRF 10 7"));

    PartSurface partSurface_447 = 
      ((PartSurface) solidModelPart_89.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_428 = 
      ((PartCurve) solidModelPart_89.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_90 = 
      ((SolidModelPart) solidModelCompositePart_11.getChildParts().getPart("TRM_SRF 11 8"));

    PartSurface partSurface_448 = 
      ((PartSurface) solidModelPart_90.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_429 = 
      ((PartCurve) solidModelPart_90.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_91 = 
      ((SolidModelPart) solidModelCompositePart_11.getChildParts().getPart("TRM_SRF 12 6"));

    PartSurface partSurface_449 = 
      ((PartSurface) solidModelPart_91.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_430 = 
      ((PartCurve) solidModelPart_91.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_92 = 
      ((SolidModelPart) solidModelCompositePart_11.getChildParts().getPart("TRM_SRF 14 8"));

    PartSurface partSurface_450 = 
      ((PartSurface) solidModelPart_92.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_431 = 
      ((PartCurve) solidModelPart_92.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_93 = 
      ((SolidModelPart) solidModelCompositePart_11.getChildParts().getPart("TRM_SRF 15 8"));

    PartSurface partSurface_451 = 
      ((PartSurface) solidModelPart_93.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_432 = 
      ((PartCurve) solidModelPart_93.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_94 = 
      ((SolidModelPart) solidModelCompositePart_11.getChildParts().getPart("TRM_SRF 16 8"));

    PartSurface partSurface_452 = 
      ((PartSurface) solidModelPart_94.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_433 = 
      ((PartCurve) solidModelPart_94.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_95 = 
      ((SolidModelPart) solidModelCompositePart_11.getChildParts().getPart("TRM_SRF 17 8"));

    PartSurface partSurface_453 = 
      ((PartSurface) solidModelPart_95.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_434 = 
      ((PartCurve) solidModelPart_95.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_96 = 
      ((SolidModelPart) solidModelCompositePart_11.getChildParts().getPart("TRM_SRF 18 8"));

    PartSurface partSurface_454 = 
      ((PartSurface) solidModelPart_96.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_435 = 
      ((PartCurve) solidModelPart_96.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_97 = 
      ((SolidModelPart) solidModelCompositePart_11.getChildParts().getPart("TRM_SRF 19 8"));

    PartSurface partSurface_455 = 
      ((PartSurface) solidModelPart_97.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_436 = 
      ((PartCurve) solidModelPart_97.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_98 = 
      ((SolidModelPart) solidModelCompositePart_11.getChildParts().getPart("TRM_SRF 89"));

    PartSurface partSurface_456 = 
      ((PartSurface) solidModelPart_98.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_437 = 
      ((PartCurve) solidModelPart_98.getPartCurveManager().getPartCurve("Default"));

    SolidModelCompositePart solidModelCompositePart_12 = 
      ((SolidModelCompositePart) solidModelCompositePart_8.getChildParts().getPart("wheelhub"));

    SolidModelPart solidModelPart_99 = 
      ((SolidModelPart) solidModelCompositePart_12.getChildParts().getPart("Body 1 7"));

    PartSurface partSurface_457 = 
      ((PartSurface) solidModelPart_99.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_438 = 
      ((PartCurve) solidModelPart_99.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_100 = 
      ((SolidModelPart) solidModelCompositePart_12.getChildParts().getPart("de255532-0c4a-485e-9789-59152b929c88_Body"));

    PartSurface partSurface_458 = 
      ((PartSurface) solidModelPart_100.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_439 = 
      ((PartCurve) solidModelPart_100.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_101 = 
      ((SolidModelPart) solidModelCompositePart_12.getChildParts().getPart("de255532-0c4a-485e-9789-59152b929c88_Body 2"));

    PartSurface partSurface_459 = 
      ((PartSurface) solidModelPart_101.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_440 = 
      ((PartCurve) solidModelPart_101.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_102 = 
      ((SolidModelPart) solidModelCompositePart_12.getChildParts().getPart("TRM_SRF 2 7"));

    PartSurface partSurface_460 = 
      ((PartSurface) solidModelPart_102.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_441 = 
      ((PartCurve) solidModelPart_102.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_103 = 
      ((SolidModelPart) solidModelCompositePart_12.getChildParts().getPart("TRM_SRF 3 9"));

    PartSurface partSurface_461 = 
      ((PartSurface) solidModelPart_103.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_442 = 
      ((PartCurve) solidModelPart_103.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_104 = 
      ((SolidModelPart) solidModelCompositePart_12.getChildParts().getPart("TRM_SRF 4 8"));

    PartSurface partSurface_462 = 
      ((PartSurface) solidModelPart_104.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_443 = 
      ((PartCurve) solidModelPart_104.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_105 = 
      ((SolidModelPart) solidModelCompositePart_12.getChildParts().getPart("TRM_SRF 5 8"));

    PartSurface partSurface_463 = 
      ((PartSurface) solidModelPart_105.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_444 = 
      ((PartCurve) solidModelPart_105.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_106 = 
      ((SolidModelPart) solidModelCompositePart_12.getChildParts().getPart("TRM_SRF 6 8"));

    PartSurface partSurface_464 = 
      ((PartSurface) solidModelPart_106.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_445 = 
      ((PartCurve) solidModelPart_106.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_107 = 
      ((SolidModelPart) solidModelCompositePart_12.getChildParts().getPart("TRM_SRF 7 8"));

    PartSurface partSurface_465 = 
      ((PartSurface) solidModelPart_107.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_446 = 
      ((PartCurve) solidModelPart_107.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_108 = 
      ((SolidModelPart) solidModelCompositePart_12.getChildParts().getPart("TRM_SRF 8 8"));

    PartSurface partSurface_466 = 
      ((PartSurface) solidModelPart_108.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_447 = 
      ((PartCurve) solidModelPart_108.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_109 = 
      ((SolidModelPart) solidModelCompositePart_12.getChildParts().getPart("TRM_SRF 9 7"));

    PartSurface partSurface_467 = 
      ((PartSurface) solidModelPart_109.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_448 = 
      ((PartCurve) solidModelPart_109.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_110 = 
      ((SolidModelPart) solidModelCompositePart_12.getChildParts().getPart("TRM_SRF 10 5"));

    PartSurface partSurface_468 = 
      ((PartSurface) solidModelPart_110.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_449 = 
      ((PartCurve) solidModelPart_110.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_111 = 
      ((SolidModelPart) solidModelCompositePart_12.getChildParts().getPart("TRM_SRF 11 6"));

    PartSurface partSurface_469 = 
      ((PartSurface) solidModelPart_111.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_450 = 
      ((PartCurve) solidModelPart_111.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_112 = 
      ((SolidModelPart) solidModelCompositePart_12.getChildParts().getPart("TRM_SRF 12 4"));

    PartSurface partSurface_470 = 
      ((PartSurface) solidModelPart_112.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_451 = 
      ((PartCurve) solidModelPart_112.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_113 = 
      ((SolidModelPart) solidModelCompositePart_12.getChildParts().getPart("TRM_SRF 14 6"));

    PartSurface partSurface_471 = 
      ((PartSurface) solidModelPart_113.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_452 = 
      ((PartCurve) solidModelPart_113.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_114 = 
      ((SolidModelPart) solidModelCompositePart_12.getChildParts().getPart("TRM_SRF 15 6"));

    PartSurface partSurface_472 = 
      ((PartSurface) solidModelPart_114.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_453 = 
      ((PartCurve) solidModelPart_114.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_115 = 
      ((SolidModelPart) solidModelCompositePart_12.getChildParts().getPart("TRM_SRF 16 6"));

    PartSurface partSurface_473 = 
      ((PartSurface) solidModelPart_115.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_454 = 
      ((PartCurve) solidModelPart_115.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_116 = 
      ((SolidModelPart) solidModelCompositePart_12.getChildParts().getPart("TRM_SRF 17 6"));

    PartSurface partSurface_474 = 
      ((PartSurface) solidModelPart_116.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_455 = 
      ((PartCurve) solidModelPart_116.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_117 = 
      ((SolidModelPart) solidModelCompositePart_12.getChildParts().getPart("TRM_SRF 18 6"));

    PartSurface partSurface_475 = 
      ((PartSurface) solidModelPart_117.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_456 = 
      ((PartCurve) solidModelPart_117.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_118 = 
      ((SolidModelPart) solidModelCompositePart_12.getChildParts().getPart("TRM_SRF 19 6"));

    PartSurface partSurface_476 = 
      ((PartSurface) solidModelPart_118.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_457 = 
      ((PartCurve) solidModelPart_118.getPartCurveManager().getPartCurve("Default"));

    SolidModelPart solidModelPart_119 = 
      ((SolidModelPart) solidModelCompositePart_12.getChildParts().getPart("TRM_SRF 87"));

    PartSurface partSurface_477 = 
      ((PartSurface) solidModelPart_119.getPartSurfaceManager().getPartSurface("Default"));

    PartCurve partCurve_458 = 
      ((PartCurve) solidModelPart_119.getPartCurveManager().getPartCurve("Default"));

    partDisplayer_9.getInputParts().setObjects(partSurface_362, partCurve_343, partSurface_363, partCurve_344, partSurface_364, partCurve_345, partSurface_365, partCurve_346, partSurface_366, partCurve_347, partSurface_367, partCurve_348, partSurface_368, partCurve_349, partSurface_369, partCurve_350, partSurface_370, partCurve_351, partSurface_371, partCurve_352, partSurface_372, partCurve_353, partSurface_373, partCurve_354, partSurface_374, partCurve_355, partSurface_375, partCurve_356, partSurface_376, partCurve_357, partSurface_377, partCurve_358, partSurface_378, partCurve_359, partSurface_379, partCurve_360, partSurface_380, partCurve_361, partSurface_381, partCurve_362, partSurface_382, partCurve_363, partSurface_383, partCurve_364, partSurface_384, partCurve_365, partSurface_385, partCurve_366, partSurface_386, partCurve_367, partSurface_387, partCurve_368, partSurface_388, partCurve_369, partSurface_389, partCurve_370, partSurface_390, partCurve_371, partSurface_391, partCurve_372, partSurface_392, partCurve_373, partSurface_393, partCurve_374, partSurface_394, partCurve_375, partSurface_395, partCurve_376, partSurface_396, partCurve_377, partSurface_397, partCurve_378, partSurface_398, partCurve_379, partSurface_399, partCurve_380, partSurface_400, partCurve_381, partSurface_401, partCurve_382, partSurface_402, partCurve_383, partSurface_403, partCurve_384, partSurface_404, partCurve_385, partSurface_405, partCurve_386, partSurface_406, partCurve_387, partSurface_407, partCurve_388, partSurface_408, partCurve_389, partSurface_409, partCurve_390, partSurface_410, partCurve_391, partSurface_411, partCurve_392, partSurface_412, partCurve_393, partSurface_413, partCurve_394, partSurface_414, partCurve_395, partSurface_415, partCurve_396, partSurface_416, partCurve_397, partSurface_417, partCurve_398, partSurface_418, partCurve_399, partSurface_419, partCurve_400, partSurface_420, partCurve_401, partSurface_421, partCurve_402, partSurface_422, partCurve_403, partSurface_423, partCurve_404, partSurface_424, partCurve_405, partSurface_425, partCurve_406, partSurface_426, partCurve_407, partSurface_427, partCurve_408, partSurface_428, partCurve_409, partSurface_429, partCurve_410, partSurface_430, partCurve_411, partSurface_431, partCurve_412, partSurface_432, partCurve_413, partSurface_433, partCurve_414, partSurface_434, partCurve_415, partSurface_435, partCurve_416, partSurface_436, partCurve_417, partSurface_437, partCurve_418, partSurface_438, partCurve_419, partSurface_439, partCurve_420, partSurface_440, partCurve_421, partSurface_441, partCurve_422, partSurface_442, partCurve_423, partSurface_443, partCurve_424, partSurface_444, partCurve_425, partSurface_445, partCurve_426, partSurface_446, partCurve_427, partSurface_447, partCurve_428, partSurface_448, partCurve_429, partSurface_449, partCurve_430, partSurface_450, partCurve_431, partSurface_451, partCurve_432, partSurface_452, partCurve_433, partSurface_453, partCurve_434, partSurface_454, partCurve_435, partSurface_455, partCurve_436, partSurface_456, partCurve_437, partSurface_457, partCurve_438, partSurface_458, partCurve_439, partSurface_459, partCurve_440, partSurface_460, partCurve_441, partSurface_461, partCurve_442, partSurface_462, partCurve_443, partSurface_463, partCurve_444, partSurface_464, partCurve_445, partSurface_465, partCurve_446, partSurface_466, partCurve_447, partSurface_467, partCurve_448, partSurface_468, partCurve_449, partSurface_469, partCurve_450, partSurface_470, partCurve_451, partSurface_471, partCurve_452, partSurface_472, partCurve_453, partSurface_473, partCurve_454, partSurface_474, partCurve_455, partSurface_475, partCurve_456, partSurface_476, partCurve_457, partSurface_477, partCurve_458);
  }

  private void execute6() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Scene scene_1 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 2");

    PartDisplayer partDisplayer_9 = 
      ((PartDisplayer) scene_1.getDisplayerManager().getObject("wheelhub"));

    PresetColorSettings presetColorSettings_7 = 
      partDisplayer_9.getPresetColorSettings();

    RayTraceSimpleMetalMaterial rayTraceSimpleMetalMaterial_3 = 
      ((RayTraceSimpleMetalMaterial) simulation_0.get(RayTraceMaterialManager.class).getObject("Dark Metal"));

    presetColorSettings_7.setRayTraceMaterial(rayTraceSimpleMetalMaterial_3);

    PartDisplayer partDisplayer_10 = 
      scene_1.getDisplayerManager().createPartDisplayer("Surface", -1, 1);

    partDisplayer_10.setPresentationName("rim");

    partDisplayer_10.setColorMode(PartColorMode.PRESET);

    PartRepresentation partRepresentation_0 = 
      ((PartRepresentation) simulation_0.getRepresentationManager().getObject("Geometry"));

    partDisplayer_10.setRepresentation(partRepresentation_0);

    partDisplayer_10.getInputParts().setQuery(null);

    SolidModelCompositePart solidModelCompositePart_5 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("W_wheel_front-left"));

    SolidModelPart solidModelPart_120 = 
      ((SolidModelPart) solidModelCompositePart_5.getChildParts().getPart("Rim"));

    PartSurface partSurface_478 = 
      ((PartSurface) solidModelPart_120.getPartSurfaceManager().getPartSurface("Default"));

    PartSurface partSurface_479 = 
      ((PartSurface) solidModelPart_120.getPartSurfaceManager().getPartSurface("Default 2"));

    PartCurve partCurve_459 = 
      ((PartCurve) solidModelPart_120.getPartCurveManager().getPartCurve("Default"));

    PartCurve partCurve_460 = 
      ((PartCurve) solidModelPart_120.getPartCurveManager().getPartCurve("Default 2"));

    SolidModelCompositePart solidModelCompositePart_6 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("W_wheel_front-right"));

    SolidModelPart solidModelPart_1 = 
      ((SolidModelPart) solidModelCompositePart_6.getChildParts().getPart("Rim"));

    PartSurface partSurface_356 = 
      ((PartSurface) solidModelPart_1.getPartSurfaceManager().getPartSurface("Default"));

    PartSurface partSurface_357 = 
      ((PartSurface) solidModelPart_1.getPartSurfaceManager().getPartSurface("Default 2"));

    PartCurve partCurve_335 = 
      ((PartCurve) solidModelPart_1.getPartCurveManager().getPartCurve("Default"));

    PartCurve partCurve_336 = 
      ((PartCurve) solidModelPart_1.getPartCurveManager().getPartCurve("Default 2"));

    SolidModelCompositePart solidModelCompositePart_7 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("W_wheel_rear-left"));

    SolidModelPart solidModelPart_121 = 
      ((SolidModelPart) solidModelCompositePart_7.getChildParts().getPart("RIm"));

    PartSurface partSurface_480 = 
      ((PartSurface) solidModelPart_121.getPartSurfaceManager().getPartSurface("Default"));

    PartSurface partSurface_481 = 
      ((PartSurface) solidModelPart_121.getPartSurfaceManager().getPartSurface("Default 2"));

    PartCurve partCurve_461 = 
      ((PartCurve) solidModelPart_121.getPartCurveManager().getPartCurve("Default"));

    PartCurve partCurve_462 = 
      ((PartCurve) solidModelPart_121.getPartCurveManager().getPartCurve("Default 2"));

    SolidModelCompositePart solidModelCompositePart_8 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("W_wheel_rear-right"));

    SolidModelPart solidModelPart_122 = 
      ((SolidModelPart) solidModelCompositePart_8.getChildParts().getPart("Rim"));

    PartSurface partSurface_482 = 
      ((PartSurface) solidModelPart_122.getPartSurfaceManager().getPartSurface("Default"));

    PartSurface partSurface_483 = 
      ((PartSurface) solidModelPart_122.getPartSurfaceManager().getPartSurface("Default 2"));

    PartCurve partCurve_463 = 
      ((PartCurve) solidModelPart_122.getPartCurveManager().getPartCurve("Default"));

    PartCurve partCurve_464 = 
      ((PartCurve) solidModelPart_122.getPartCurveManager().getPartCurve("Default 2"));

    partDisplayer_10.getInputParts().setObjects(partSurface_478, partSurface_479, partCurve_459, partCurve_460, partSurface_356, partSurface_357, partCurve_335, partCurve_336, partSurface_480, partSurface_481, partCurve_461, partCurve_462, partSurface_482, partSurface_483, partCurve_463, partCurve_464);

    PresetColorSettings presetColorSettings_8 = 
      partDisplayer_10.getPresetColorSettings();

    RayTraceSimpleMetalMaterial rayTraceSimpleMetalMaterial_1 = 
      ((RayTraceSimpleMetalMaterial) simulation_0.get(RayTraceMaterialManager.class).getObject("Metallic Dark Gray"));

    presetColorSettings_8.setRayTraceMaterial(rayTraceSimpleMetalMaterial_1);

    PartDisplayer partDisplayer_11 = 
      scene_1.getDisplayerManager().createPartDisplayer("Surface", -1, 1);

    partDisplayer_11.setPresentationName("headrest");

    partDisplayer_11.getInputParts().setQuery(null);

    SolidModelCompositePart solidModelCompositePart_3 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("C_MONOCOQUE"));

    CompositePart compositePart_108 = 
      ((CompositePart) solidModelCompositePart_3.getChildParts().getPart("C_HR00_HEAD_RESTRAINT_ASM"));

    CadPart cadPart_332 = 
      ((CadPart) compositePart_108.getChildParts().getPart("C_HR01_PADDING"));

    PartSurface partSurface_484 = 
      ((PartSurface) cadPart_332.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_465 = 
      ((PartCurve) cadPart_332.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_333 = 
      ((CadPart) compositePart_108.getChildParts().getPart("C_HR02_SUPPORT_PLATE"));

    PartSurface partSurface_485 = 
      ((PartSurface) cadPart_333.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_466 = 
      ((PartCurve) cadPart_333.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_334 = 
      ((CadPart) compositePart_108.getChildParts().getPart("C_HR04_SUPPORT_TUBE_2"));

    PartSurface partSurface_486 = 
      ((PartSurface) cadPart_334.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_467 = 
      ((PartCurve) cadPart_334.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_335 = 
      ((CadPart) compositePart_108.getChildParts().getPart("C_HR05_SAFETY_FLANGE"));

    PartSurface partSurface_487 = 
      ((PartSurface) cadPart_335.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_468 = 
      ((PartCurve) cadPart_335.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_336 = 
      ((CadPart) compositePart_108.getChildParts().getPart("C_HR06_SIDE_PADDING_LEFT"));

    PartSurface partSurface_488 = 
      ((PartSurface) cadPart_336.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_469 = 
      ((PartCurve) cadPart_336.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_337 = 
      ((CadPart) compositePart_108.getChildParts().getPart("C_HR06_SIDE_PADDING_RIGHT"));

    PartSurface partSurface_489 = 
      ((PartSurface) cadPart_337.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_470 = 
      ((PartCurve) cadPart_337.getPartCurveManager().getPartCurve("Edges"));

    partDisplayer_11.getInputParts().setObjects(partSurface_484, partCurve_465, partSurface_485, partCurve_466, partSurface_486, partCurve_467, partSurface_487, partCurve_468, partSurface_488, partCurve_469, partSurface_489, partCurve_470);

    partDisplayer_11.setRepresentation(partRepresentation_0);

    PartDisplayer partDisplayer_7 = 
      ((PartDisplayer) scene_1.getDisplayerManager().getObject("rods"));

    partDisplayer_7.getInputParts().setQuery(null);

    SolidModelCompositePart solidModelCompositePart_0 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("C_FRONTWING"));

    CompositePart compositePart_0 = 
      ((CompositePart) solidModelCompositePart_0.getChildParts().getPart("A_F000_FRONTWING_ASM"));

    CompositePart compositePart_27 = 
      ((CompositePart) compositePart_0.getChildParts().getPart("A_FA00_FRONTWING_ATTACHMENT"));

    CompositePart compositePart_30 = 
      ((CompositePart) compositePart_27.getChildParts().getPart("A_FA01_ATTACHMENT_A"));

    CompositePart compositePart_29 = 
      ((CompositePart) compositePart_30.getChildParts().getPart("A_FA01_INSERT_BOTTOM"));

    CadPart cadPart_147 = 
      ((CadPart) compositePart_29.getChildParts().getPart("A_FA01_INSERT_BOTTOM_Body"));

    PartSurface partSurface_149 = 
      ((PartSurface) cadPart_147.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_147 = 
      ((PartCurve) cadPart_147.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_31 = 
      ((CompositePart) compositePart_30.getChildParts().getPart("A_FA01_INSERT_TOP"));

    CadPart cadPart_148 = 
      ((CadPart) compositePart_31.getChildParts().getPart("A_FA01_INSERT_TOP_Body"));

    PartSurface partSurface_150 = 
      ((PartSurface) cadPart_148.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_148 = 
      ((PartCurve) cadPart_148.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_149 = 
      ((CadPart) compositePart_30.getChildParts().getPart("A_FA01_MONO_BRACKET"));

    PartSurface partSurface_151 = 
      ((PartSurface) cadPart_149.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_149 = 
      ((PartCurve) cadPart_149.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_150 = 
      ((CadPart) compositePart_30.getChildParts().getPart("A_FA01_ROD"));

    PartSurface partSurface_152 = 
      ((PartSurface) cadPart_150.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_150 = 
      ((PartCurve) cadPart_150.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_151 = 
      ((CadPart) compositePart_30.getChildParts().getPart("A_FA01_WING_BRACKET"));

    PartSurface partSurface_153 = 
      ((PartSurface) cadPart_151.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_151 = 
      ((PartCurve) cadPart_151.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_152 = 
      ((CadPart) compositePart_30.getChildParts().getPart("A_FA01_WING_BRACKET_B"));

    PartSurface partSurface_154 = 
      ((PartSurface) cadPart_152.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_152 = 
      ((PartCurve) cadPart_152.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_32 = 
      ((CompositePart) compositePart_30.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5"));

    CadPart cadPart_153 = 
      ((CadPart) compositePart_32.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_155 = 
      ((PartSurface) cadPart_153.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_156 = 
      ((PartSurface) cadPart_153.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_153 = 
      ((PartCurve) cadPart_153.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_33 = 
      ((CompositePart) compositePart_30.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5 2"));

    CadPart cadPart_154 = 
      ((CadPart) compositePart_33.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_157 = 
      ((PartSurface) cadPart_154.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_158 = 
      ((PartSurface) cadPart_154.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_154 = 
      ((PartCurve) cadPart_154.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_155 = 
      ((CadPart) compositePart_30.getChildParts().getPart("ASKUBAL_BALL_M5"));

    PartSurface partSurface_159 = 
      ((PartSurface) cadPart_155.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_155 = 
      ((PartCurve) cadPart_155.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_156 = 
      ((CadPart) compositePart_30.getChildParts().getPart("D125B_5_3"));

    PartSurface partSurface_160 = 
      ((PartSurface) cadPart_156.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_156 = 
      ((PartCurve) cadPart_156.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_34 = 
      ((CompositePart) compositePart_30.getChildParts().getPart("D439_M5"));

    CadPart cadPart_157 = 
      ((CadPart) compositePart_34.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_161 = 
      ((PartSurface) cadPart_157.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_157 = 
      ((PartCurve) cadPart_157.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_35 = 
      ((CompositePart) compositePart_30.getChildParts().getPart("D439_M5 2"));

    CadPart cadPart_158 = 
      ((CadPart) compositePart_35.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_162 = 
      ((PartSurface) cadPart_158.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_158 = 
      ((PartCurve) cadPart_158.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_36 = 
      ((CompositePart) compositePart_30.getChildParts().getPart("DIN985_M5"));

    CadPart cadPart_159 = 
      ((CadPart) compositePart_36.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_163 = 
      ((PartSurface) cadPart_159.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_159 = 
      ((PartCurve) cadPart_159.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_37 = 
      ((CompositePart) compositePart_30.getChildParts().getPart("DIN985_M5 2"));

    CadPart cadPart_160 = 
      ((CadPart) compositePart_37.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_164 = 
      ((PartSurface) cadPart_160.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_160 = 
      ((PartCurve) cadPart_160.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_161 = 
      ((CadPart) compositePart_30.getChildParts().getPart("DIN7985TX_M4X30"));

    PartSurface partSurface_165 = 
      ((PartSurface) cadPart_161.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_161 = 
      ((PartCurve) cadPart_161.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_162 = 
      ((CadPart) compositePart_30.getChildParts().getPart("DIN7985TX_M5X20"));

    PartSurface partSurface_166 = 
      ((PartSurface) cadPart_162.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_162 = 
      ((PartCurve) cadPart_162.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_38 = 
      ((CompositePart) compositePart_27.getChildParts().getPart("A_FA01_ATTACHMENT_A_MIR"));

    CadPart cadPart_163 = 
      ((CadPart) compositePart_38.getChildParts().getPart("A_FA01_INSERT_BOTTOM_MIR"));

    PartSurface partSurface_167 = 
      ((PartSurface) cadPart_163.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_163 = 
      ((PartCurve) cadPart_163.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_39 = 
      ((CompositePart) compositePart_38.getChildParts().getPart("A_FA01_INSERT_TOP_MIR"));

    CadPart cadPart_164 = 
      ((CadPart) compositePart_39.getChildParts().getPart("A_FA01_INSERT_TOP_MIR_Body"));

    PartSurface partSurface_168 = 
      ((PartSurface) cadPart_164.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_164 = 
      ((PartCurve) cadPart_164.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_165 = 
      ((CadPart) compositePart_38.getChildParts().getPart("A_FA01_MONO_BRACKET_MIR"));

    PartSurface partSurface_169 = 
      ((PartSurface) cadPart_165.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_165 = 
      ((PartCurve) cadPart_165.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_166 = 
      ((CadPart) compositePart_38.getChildParts().getPart("A_FA01_ROD_MIR"));

    PartSurface partSurface_170 = 
      ((PartSurface) cadPart_166.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_166 = 
      ((PartCurve) cadPart_166.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_167 = 
      ((CadPart) compositePart_38.getChildParts().getPart("A_FA01_WING_BRACKET_B_MIR"));

    PartSurface partSurface_171 = 
      ((PartSurface) cadPart_167.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_167 = 
      ((PartCurve) cadPart_167.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_168 = 
      ((CadPart) compositePart_38.getChildParts().getPart("A_FA01_WING_BRACKET_MIR"));

    PartSurface partSurface_172 = 
      ((PartSurface) cadPart_168.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_168 = 
      ((PartCurve) cadPart_168.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_40 = 
      ((CompositePart) compositePart_38.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5"));

    CadPart cadPart_169 = 
      ((CadPart) compositePart_40.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_173 = 
      ((PartSurface) cadPart_169.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_174 = 
      ((PartSurface) cadPart_169.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_169 = 
      ((PartCurve) cadPart_169.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_41 = 
      ((CompositePart) compositePart_38.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5 2"));

    CadPart cadPart_170 = 
      ((CadPart) compositePart_41.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_175 = 
      ((PartSurface) cadPart_170.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_176 = 
      ((PartSurface) cadPart_170.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_170 = 
      ((PartCurve) cadPart_170.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_171 = 
      ((CadPart) compositePart_38.getChildParts().getPart("ASKUBAL_BALL_M5"));

    PartSurface partSurface_177 = 
      ((PartSurface) cadPart_171.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_171 = 
      ((PartCurve) cadPart_171.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_172 = 
      ((CadPart) compositePart_38.getChildParts().getPart("D125B_5_3"));

    PartSurface partSurface_178 = 
      ((PartSurface) cadPart_172.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_172 = 
      ((PartCurve) cadPart_172.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_42 = 
      ((CompositePart) compositePart_38.getChildParts().getPart("D439_M5"));

    CadPart cadPart_173 = 
      ((CadPart) compositePart_42.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_179 = 
      ((PartSurface) cadPart_173.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_173 = 
      ((PartCurve) cadPart_173.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_43 = 
      ((CompositePart) compositePart_38.getChildParts().getPart("D439_M5 2"));

    CadPart cadPart_174 = 
      ((CadPart) compositePart_43.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_180 = 
      ((PartSurface) cadPart_174.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_174 = 
      ((PartCurve) cadPart_174.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_44 = 
      ((CompositePart) compositePart_38.getChildParts().getPart("DIN985_M5"));

    CadPart cadPart_175 = 
      ((CadPart) compositePart_44.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_181 = 
      ((PartSurface) cadPart_175.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_175 = 
      ((PartCurve) cadPart_175.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_45 = 
      ((CompositePart) compositePart_38.getChildParts().getPart("DIN985_M5 2"));

    CadPart cadPart_176 = 
      ((CadPart) compositePart_45.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_182 = 
      ((PartSurface) cadPart_176.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_176 = 
      ((PartCurve) cadPart_176.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_177 = 
      ((CadPart) compositePart_38.getChildParts().getPart("DIN7985TX_M4X30"));

    PartSurface partSurface_183 = 
      ((PartSurface) cadPart_177.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_177 = 
      ((PartCurve) cadPart_177.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_178 = 
      ((CadPart) compositePart_38.getChildParts().getPart("DIN7985TX_M5X20"));

    PartSurface partSurface_184 = 
      ((PartSurface) cadPart_178.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_178 = 
      ((PartCurve) cadPart_178.getPartCurveManager().getPartCurve("Edges"));

    SolidModelCompositePart solidModelCompositePart_1 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("C_REARWING"));

    CompositePart compositePart_4 = 
      ((CompositePart) solidModelCompositePart_1.getChildParts().getPart("A_R000_REARWING_ASM"));

    CompositePart compositePart_47 = 
      ((CompositePart) compositePart_4.getChildParts().getPart("A_RA00_REARWING_ATTACHMENTS"));

    CompositePart compositePart_46 = 
      ((CompositePart) compositePart_47.getChildParts().getPart("A_RA01_RW_ATTACHMENT_A"));

    CadPart cadPart_179 = 
      ((CadPart) compositePart_46.getChildParts().getPart("A_RA01_ENDPLATE_BRACKET"));

    PartSurface partSurface_185 = 
      ((PartSurface) cadPart_179.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_179 = 
      ((PartCurve) cadPart_179.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_48 = 
      ((CompositePart) compositePart_46.getChildParts().getPart("A_RA01_INSERT_ROD_BOTTOM"));

    CadPart cadPart_180 = 
      ((CadPart) compositePart_48.getChildParts().getPart("A_RA01_INSERT_ROD_BOTTOM_Body"));

    PartSurface partSurface_186 = 
      ((PartSurface) cadPart_180.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_180 = 
      ((PartCurve) cadPart_180.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_49 = 
      ((CompositePart) compositePart_46.getChildParts().getPart("A_RA01_INSERT_ROD_TOP"));

    CadPart cadPart_181 = 
      ((CadPart) compositePart_49.getChildParts().getPart("A_RA01_INSERT_ROD_TOP_Body"));

    PartSurface partSurface_187 = 
      ((PartSurface) cadPart_181.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_181 = 
      ((PartCurve) cadPart_181.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_182 = 
      ((CadPart) compositePart_46.getChildParts().getPart("A_RA01_MAIN_HOOP_BRACKET"));

    PartSurface partSurface_188 = 
      ((PartSurface) cadPart_182.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_182 = 
      ((PartCurve) cadPart_182.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_183 = 
      ((CadPart) compositePart_46.getChildParts().getPart("A_RA01_ROD"));

    PartSurface partSurface_189 = 
      ((PartSurface) cadPart_183.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_183 = 
      ((PartCurve) cadPart_183.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_50 = 
      ((CompositePart) compositePart_46.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5"));

    CadPart cadPart_184 = 
      ((CadPart) compositePart_50.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_190 = 
      ((PartSurface) cadPart_184.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_191 = 
      ((PartSurface) cadPart_184.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_184 = 
      ((PartCurve) cadPart_184.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_51 = 
      ((CompositePart) compositePart_46.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5 2"));

    CadPart cadPart_185 = 
      ((CadPart) compositePart_51.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_192 = 
      ((PartSurface) cadPart_185.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_193 = 
      ((PartSurface) cadPart_185.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_185 = 
      ((PartCurve) cadPart_185.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_186 = 
      ((CadPart) compositePart_46.getChildParts().getPart("ASKUBAL_BALL_M5"));

    PartSurface partSurface_194 = 
      ((PartSurface) cadPart_186.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_186 = 
      ((PartCurve) cadPart_186.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_187 = 
      ((CadPart) compositePart_46.getChildParts().getPart("D125B_5_3"));

    PartSurface partSurface_195 = 
      ((PartSurface) cadPart_187.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_187 = 
      ((PartCurve) cadPart_187.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_52 = 
      ((CompositePart) compositePart_46.getChildParts().getPart("D439_M5"));

    CadPart cadPart_188 = 
      ((CadPart) compositePart_52.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_196 = 
      ((PartSurface) cadPart_188.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_188 = 
      ((PartCurve) cadPart_188.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_53 = 
      ((CompositePart) compositePart_46.getChildParts().getPart("D439_M5 2"));

    CadPart cadPart_189 = 
      ((CadPart) compositePart_53.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_197 = 
      ((PartSurface) cadPart_189.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_189 = 
      ((PartCurve) cadPart_189.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_54 = 
      ((CompositePart) compositePart_46.getChildParts().getPart("DIN985_M5"));

    CadPart cadPart_190 = 
      ((CadPart) compositePart_54.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_198 = 
      ((PartSurface) cadPart_190.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_190 = 
      ((PartCurve) cadPart_190.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_55 = 
      ((CompositePart) compositePart_46.getChildParts().getPart("DIN985_M5 2"));

    CadPart cadPart_191 = 
      ((CadPart) compositePart_55.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_199 = 
      ((PartSurface) cadPart_191.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_191 = 
      ((PartCurve) cadPart_191.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_192 = 
      ((CadPart) compositePart_46.getChildParts().getPart("DIN7985TX_M4X10"));

    PartSurface partSurface_200 = 
      ((PartSurface) cadPart_192.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_192 = 
      ((PartCurve) cadPart_192.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_193 = 
      ((CadPart) compositePart_46.getChildParts().getPart("DIN7985TX_M5X25"));

    PartSurface partSurface_201 = 
      ((PartSurface) cadPart_193.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_193 = 
      ((PartCurve) cadPart_193.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_56 = 
      ((CompositePart) compositePart_47.getChildParts().getPart("A_RA01_RW_ATTACHMENT_A_MIR"));

    CadPart cadPart_194 = 
      ((CadPart) compositePart_56.getChildParts().getPart("A_RA01_ENDPLATE_BRACKET_MIR"));

    PartSurface partSurface_202 = 
      ((PartSurface) cadPart_194.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_194 = 
      ((PartCurve) cadPart_194.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_195 = 
      ((CadPart) compositePart_56.getChildParts().getPart("A_RA01_INSERT_ROD_BOTTOM_MIR"));

    PartSurface partSurface_203 = 
      ((PartSurface) cadPart_195.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_195 = 
      ((PartCurve) cadPart_195.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_196 = 
      ((CadPart) compositePart_56.getChildParts().getPart("A_RA01_INSERT_ROD_TOP_MIR"));

    PartSurface partSurface_204 = 
      ((PartSurface) cadPart_196.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_196 = 
      ((PartCurve) cadPart_196.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_197 = 
      ((CadPart) compositePart_56.getChildParts().getPart("A_RA01_MAIN_HOOP_BRACKET_MIR"));

    PartSurface partSurface_205 = 
      ((PartSurface) cadPart_197.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_197 = 
      ((PartCurve) cadPart_197.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_198 = 
      ((CadPart) compositePart_56.getChildParts().getPart("A_RA01_ROD_MIR"));

    PartSurface partSurface_206 = 
      ((PartSurface) cadPart_198.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_198 = 
      ((PartCurve) cadPart_198.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_57 = 
      ((CompositePart) compositePart_56.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5"));

    CadPart cadPart_199 = 
      ((CadPart) compositePart_57.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_207 = 
      ((PartSurface) cadPart_199.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_208 = 
      ((PartSurface) cadPart_199.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_199 = 
      ((PartCurve) cadPart_199.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_58 = 
      ((CompositePart) compositePart_56.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5 2"));

    CadPart cadPart_200 = 
      ((CadPart) compositePart_58.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_209 = 
      ((PartSurface) cadPart_200.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_210 = 
      ((PartSurface) cadPart_200.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_200 = 
      ((PartCurve) cadPart_200.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_201 = 
      ((CadPart) compositePart_56.getChildParts().getPart("ASKUBAL_BALL_M5"));

    PartSurface partSurface_211 = 
      ((PartSurface) cadPart_201.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_201 = 
      ((PartCurve) cadPart_201.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_202 = 
      ((CadPart) compositePart_56.getChildParts().getPart("D125B_5_3"));

    PartSurface partSurface_212 = 
      ((PartSurface) cadPart_202.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_202 = 
      ((PartCurve) cadPart_202.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_59 = 
      ((CompositePart) compositePart_56.getChildParts().getPart("D439_M5"));

    CadPart cadPart_203 = 
      ((CadPart) compositePart_59.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_213 = 
      ((PartSurface) cadPart_203.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_203 = 
      ((PartCurve) cadPart_203.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_60 = 
      ((CompositePart) compositePart_56.getChildParts().getPart("D439_M5 2"));

    CadPart cadPart_204 = 
      ((CadPart) compositePart_60.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_214 = 
      ((PartSurface) cadPart_204.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_204 = 
      ((PartCurve) cadPart_204.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_61 = 
      ((CompositePart) compositePart_56.getChildParts().getPart("DIN985_M5"));

    CadPart cadPart_205 = 
      ((CadPart) compositePart_61.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_215 = 
      ((PartSurface) cadPart_205.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_205 = 
      ((PartCurve) cadPart_205.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_206 = 
      ((CadPart) compositePart_56.getChildParts().getPart("DIN7985TX_M4X10"));

    PartSurface partSurface_216 = 
      ((PartSurface) cadPart_206.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_206 = 
      ((PartCurve) cadPart_206.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_207 = 
      ((CadPart) compositePart_56.getChildParts().getPart("DIN7985TX_M5X25"));

    PartSurface partSurface_217 = 
      ((PartSurface) cadPart_207.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_207 = 
      ((PartCurve) cadPart_207.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_62 = 
      ((CompositePart) compositePart_47.getChildParts().getPart("A_RA02_RW_ATTACHMENT_B"));

    CadPart cadPart_208 = 
      ((CadPart) compositePart_62.getChildParts().getPart("A_RA02_ENDPLATE_BRACKET"));

    PartSurface partSurface_218 = 
      ((PartSurface) cadPart_208.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_208 = 
      ((PartCurve) cadPart_208.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_209 = 
      ((CadPart) compositePart_62.getChildParts().getPart("A_RA02_INSERT_ROD_BOTTOM"));

    PartSurface partSurface_219 = 
      ((PartSurface) cadPart_209.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_209 = 
      ((PartCurve) cadPart_209.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_210 = 
      ((CadPart) compositePart_62.getChildParts().getPart("A_RA02_INSERT_ROD_TOP"));

    PartSurface partSurface_220 = 
      ((PartSurface) cadPart_210.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_210 = 
      ((PartCurve) cadPart_210.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_211 = 
      ((CadPart) compositePart_62.getChildParts().getPart("A_RA02_MONO_BRACKET"));

    PartSurface partSurface_221 = 
      ((PartSurface) cadPart_211.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_211 = 
      ((PartCurve) cadPart_211.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_212 = 
      ((CadPart) compositePart_62.getChildParts().getPart("A_RA02_ROD"));

    PartSurface partSurface_222 = 
      ((PartSurface) cadPart_212.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_212 = 
      ((PartCurve) cadPart_212.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_63 = 
      ((CompositePart) compositePart_62.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5"));

    CadPart cadPart_213 = 
      ((CadPart) compositePart_63.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_223 = 
      ((PartSurface) cadPart_213.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_224 = 
      ((PartSurface) cadPart_213.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_213 = 
      ((PartCurve) cadPart_213.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_64 = 
      ((CompositePart) compositePart_62.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5 2"));

    CadPart cadPart_214 = 
      ((CadPart) compositePart_64.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_225 = 
      ((PartSurface) cadPart_214.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_226 = 
      ((PartSurface) cadPart_214.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_214 = 
      ((PartCurve) cadPart_214.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_215 = 
      ((CadPart) compositePart_62.getChildParts().getPart("ASKUBAL_BALL_M5"));

    PartSurface partSurface_227 = 
      ((PartSurface) cadPart_215.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_215 = 
      ((PartCurve) cadPart_215.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_216 = 
      ((CadPart) compositePart_62.getChildParts().getPart("D125B_5_3"));

    PartSurface partSurface_228 = 
      ((PartSurface) cadPart_216.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_216 = 
      ((PartCurve) cadPart_216.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_65 = 
      ((CompositePart) compositePart_62.getChildParts().getPart("D439_M5"));

    CadPart cadPart_217 = 
      ((CadPart) compositePart_65.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_229 = 
      ((PartSurface) cadPart_217.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_217 = 
      ((PartCurve) cadPart_217.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_66 = 
      ((CompositePart) compositePart_62.getChildParts().getPart("D439_M5 2"));

    CadPart cadPart_218 = 
      ((CadPart) compositePart_66.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_230 = 
      ((PartSurface) cadPart_218.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_218 = 
      ((PartCurve) cadPart_218.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_67 = 
      ((CompositePart) compositePart_62.getChildParts().getPart("DIN985_M5"));

    CadPart cadPart_219 = 
      ((CadPart) compositePart_67.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_231 = 
      ((PartSurface) cadPart_219.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_219 = 
      ((PartCurve) cadPart_219.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_68 = 
      ((CompositePart) compositePart_62.getChildParts().getPart("DIN985_M5 2"));

    CadPart cadPart_220 = 
      ((CadPart) compositePart_68.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_232 = 
      ((PartSurface) cadPart_220.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_220 = 
      ((PartCurve) cadPart_220.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_221 = 
      ((CadPart) compositePart_62.getChildParts().getPart("DIN7985TX_M4X10"));

    PartSurface partSurface_233 = 
      ((PartSurface) cadPart_221.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_221 = 
      ((PartCurve) cadPart_221.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_222 = 
      ((CadPart) compositePart_62.getChildParts().getPart("DIN7985TX_M4X20"));

    PartSurface partSurface_234 = 
      ((PartSurface) cadPart_222.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_222 = 
      ((PartCurve) cadPart_222.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_223 = 
      ((CadPart) compositePart_62.getChildParts().getPart("DIN7985TX_M5X25"));

    PartSurface partSurface_235 = 
      ((PartSurface) cadPart_223.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_223 = 
      ((PartCurve) cadPart_223.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_69 = 
      ((CompositePart) compositePart_47.getChildParts().getPart("A_RA02_RW_ATTACHMENT_B_MIR"));

    CadPart cadPart_224 = 
      ((CadPart) compositePart_69.getChildParts().getPart("A_RA02_ENDPLATE_BRACKET_MIR"));

    PartSurface partSurface_236 = 
      ((PartSurface) cadPart_224.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_224 = 
      ((PartCurve) cadPart_224.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_225 = 
      ((CadPart) compositePart_69.getChildParts().getPart("A_RA02_INSERT_ROD_BOTTOM_MIR"));

    PartSurface partSurface_237 = 
      ((PartSurface) cadPart_225.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_225 = 
      ((PartCurve) cadPart_225.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_226 = 
      ((CadPart) compositePart_69.getChildParts().getPart("A_RA02_INSERT_ROD_TOP_MIR"));

    PartSurface partSurface_238 = 
      ((PartSurface) cadPart_226.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_226 = 
      ((PartCurve) cadPart_226.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_227 = 
      ((CadPart) compositePart_69.getChildParts().getPart("A_RA02_MONO_BRACKET_MIR"));

    PartSurface partSurface_239 = 
      ((PartSurface) cadPart_227.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_227 = 
      ((PartCurve) cadPart_227.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_228 = 
      ((CadPart) compositePart_69.getChildParts().getPart("A_RA02_ROD_MIR"));

    PartSurface partSurface_240 = 
      ((PartSurface) cadPart_228.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_228 = 
      ((PartCurve) cadPart_228.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_70 = 
      ((CompositePart) compositePart_69.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5"));

    CadPart cadPart_229 = 
      ((CadPart) compositePart_70.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_241 = 
      ((PartSurface) cadPart_229.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_242 = 
      ((PartSurface) cadPart_229.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_229 = 
      ((PartCurve) cadPart_229.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_71 = 
      ((CompositePart) compositePart_69.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5 2"));

    CadPart cadPart_230 = 
      ((CadPart) compositePart_71.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_243 = 
      ((PartSurface) cadPart_230.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_244 = 
      ((PartSurface) cadPart_230.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_230 = 
      ((PartCurve) cadPart_230.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_231 = 
      ((CadPart) compositePart_69.getChildParts().getPart("ASKUBAL_BALL_M5"));

    PartSurface partSurface_245 = 
      ((PartSurface) cadPart_231.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_231 = 
      ((PartCurve) cadPart_231.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_232 = 
      ((CadPart) compositePart_69.getChildParts().getPart("D125B_5_3"));

    PartSurface partSurface_246 = 
      ((PartSurface) cadPart_232.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_232 = 
      ((PartCurve) cadPart_232.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_72 = 
      ((CompositePart) compositePart_69.getChildParts().getPart("D439_M5"));

    CadPart cadPart_233 = 
      ((CadPart) compositePart_72.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_247 = 
      ((PartSurface) cadPart_233.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_233 = 
      ((PartCurve) cadPart_233.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_73 = 
      ((CompositePart) compositePart_69.getChildParts().getPart("D439_M5 2"));

    CadPart cadPart_234 = 
      ((CadPart) compositePart_73.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_248 = 
      ((PartSurface) cadPart_234.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_234 = 
      ((PartCurve) cadPart_234.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_74 = 
      ((CompositePart) compositePart_69.getChildParts().getPart("DIN985_M5"));

    CadPart cadPart_235 = 
      ((CadPart) compositePart_74.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_249 = 
      ((PartSurface) cadPart_235.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_235 = 
      ((PartCurve) cadPart_235.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_75 = 
      ((CompositePart) compositePart_69.getChildParts().getPart("DIN985_M5 2"));

    CadPart cadPart_236 = 
      ((CadPart) compositePart_75.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_250 = 
      ((PartSurface) cadPart_236.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_236 = 
      ((PartCurve) cadPart_236.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_237 = 
      ((CadPart) compositePart_69.getChildParts().getPart("DIN7985TX_M4X10"));

    PartSurface partSurface_251 = 
      ((PartSurface) cadPart_237.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_237 = 
      ((PartCurve) cadPart_237.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_238 = 
      ((CadPart) compositePart_69.getChildParts().getPart("DIN7985TX_M4X20"));

    PartSurface partSurface_252 = 
      ((PartSurface) cadPart_238.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_238 = 
      ((PartCurve) cadPart_238.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_239 = 
      ((CadPart) compositePart_69.getChildParts().getPart("DIN7985TX_M5X25"));

    PartSurface partSurface_253 = 
      ((PartSurface) cadPart_239.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_239 = 
      ((PartCurve) cadPart_239.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_76 = 
      ((CompositePart) compositePart_47.getChildParts().getPart("A_RA03_RW_ATTACHMENT_C"));

    CadPart cadPart_240 = 
      ((CadPart) compositePart_76.getChildParts().getPart("A_RA03_ENDPLATE_BRACKET"));

    PartSurface partSurface_254 = 
      ((PartSurface) cadPart_240.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_240 = 
      ((PartCurve) cadPart_240.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_241 = 
      ((CadPart) compositePart_76.getChildParts().getPart("A_RA03_INSERT_ROD_BOTTOM"));

    PartSurface partSurface_255 = 
      ((PartSurface) cadPart_241.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_241 = 
      ((PartCurve) cadPart_241.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_242 = 
      ((CadPart) compositePart_76.getChildParts().getPart("A_RA03_INSERT_ROD_TOP"));

    PartSurface partSurface_256 = 
      ((PartSurface) cadPart_242.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_242 = 
      ((PartCurve) cadPart_242.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_243 = 
      ((CadPart) compositePart_76.getChildParts().getPart("A_RA03_MONO_BRACKET_TYPE_A"));

    PartSurface partSurface_257 = 
      ((PartSurface) cadPart_243.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_243 = 
      ((PartCurve) cadPart_243.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_244 = 
      ((CadPart) compositePart_76.getChildParts().getPart("A_RA03_ROD"));

    PartSurface partSurface_258 = 
      ((PartSurface) cadPart_244.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_244 = 
      ((PartCurve) cadPart_244.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_77 = 
      ((CompositePart) compositePart_76.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5"));

    CadPart cadPart_245 = 
      ((CadPart) compositePart_77.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_259 = 
      ((PartSurface) cadPart_245.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_260 = 
      ((PartSurface) cadPart_245.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_245 = 
      ((PartCurve) cadPart_245.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_78 = 
      ((CompositePart) compositePart_76.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5 2"));

    CadPart cadPart_246 = 
      ((CadPart) compositePart_78.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_261 = 
      ((PartSurface) cadPart_246.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_262 = 
      ((PartSurface) cadPart_246.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_246 = 
      ((PartCurve) cadPart_246.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_247 = 
      ((CadPart) compositePart_76.getChildParts().getPart("ASKUBAL_BALL_M5"));

    PartSurface partSurface_263 = 
      ((PartSurface) cadPart_247.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_247 = 
      ((PartCurve) cadPart_247.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_248 = 
      ((CadPart) compositePart_76.getChildParts().getPart("D125B_5_3"));

    PartSurface partSurface_264 = 
      ((PartSurface) cadPart_248.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_248 = 
      ((PartCurve) cadPart_248.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_79 = 
      ((CompositePart) compositePart_76.getChildParts().getPart("D439_M5"));

    CadPart cadPart_249 = 
      ((CadPart) compositePart_79.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_265 = 
      ((PartSurface) cadPart_249.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_249 = 
      ((PartCurve) cadPart_249.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_80 = 
      ((CompositePart) compositePart_76.getChildParts().getPart("D439_M5 2"));

    CadPart cadPart_250 = 
      ((CadPart) compositePart_80.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_266 = 
      ((PartSurface) cadPart_250.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_250 = 
      ((PartCurve) cadPart_250.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_81 = 
      ((CompositePart) compositePart_76.getChildParts().getPart("DIN985_M5"));

    CadPart cadPart_251 = 
      ((CadPart) compositePart_81.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_267 = 
      ((PartSurface) cadPart_251.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_251 = 
      ((PartCurve) cadPart_251.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_82 = 
      ((CompositePart) compositePart_76.getChildParts().getPart("DIN985_M5 2"));

    CadPart cadPart_252 = 
      ((CadPart) compositePart_82.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_268 = 
      ((PartSurface) cadPart_252.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_252 = 
      ((PartCurve) cadPart_252.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_253 = 
      ((CadPart) compositePart_76.getChildParts().getPart("DIN7985TX_M4X10"));

    PartSurface partSurface_269 = 
      ((PartSurface) cadPart_253.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_253 = 
      ((PartCurve) cadPart_253.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_254 = 
      ((CadPart) compositePart_76.getChildParts().getPart("DIN7985TX_M4X30"));

    PartSurface partSurface_270 = 
      ((PartSurface) cadPart_254.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_254 = 
      ((PartCurve) cadPart_254.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_255 = 
      ((CadPart) compositePart_76.getChildParts().getPart("DIN7985TX_M5X25"));

    PartSurface partSurface_271 = 
      ((PartSurface) cadPart_255.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_255 = 
      ((PartCurve) cadPart_255.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_83 = 
      ((CompositePart) compositePart_47.getChildParts().getPart("A_RA03_RW_ATTACHMENT_C_MIR"));

    CadPart cadPart_256 = 
      ((CadPart) compositePart_83.getChildParts().getPart("A_RA03_ENDPLATE_BRACKET_MIR"));

    PartSurface partSurface_272 = 
      ((PartSurface) cadPart_256.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_256 = 
      ((PartCurve) cadPart_256.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_257 = 
      ((CadPart) compositePart_83.getChildParts().getPart("A_RA03_INSERT_ROD_BOTTOM_MIR"));

    PartSurface partSurface_273 = 
      ((PartSurface) cadPart_257.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_257 = 
      ((PartCurve) cadPart_257.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_258 = 
      ((CadPart) compositePart_83.getChildParts().getPart("A_RA03_INSERT_ROD_TOP_MIR"));

    PartSurface partSurface_274 = 
      ((PartSurface) cadPart_258.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_258 = 
      ((PartCurve) cadPart_258.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_259 = 
      ((CadPart) compositePart_83.getChildParts().getPart("A_RA03_MONO_BRACKET_TYPE_A_MIR"));

    PartSurface partSurface_275 = 
      ((PartSurface) cadPart_259.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_259 = 
      ((PartCurve) cadPart_259.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_260 = 
      ((CadPart) compositePart_83.getChildParts().getPart("A_RA03_ROD_MIR"));

    PartSurface partSurface_276 = 
      ((PartSurface) cadPart_260.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_260 = 
      ((PartCurve) cadPart_260.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_84 = 
      ((CompositePart) compositePart_83.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5"));

    CadPart cadPart_261 = 
      ((CadPart) compositePart_84.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_277 = 
      ((PartSurface) cadPart_261.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_278 = 
      ((PartSurface) cadPart_261.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_261 = 
      ((PartCurve) cadPart_261.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_85 = 
      ((CompositePart) compositePart_83.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5 2"));

    CadPart cadPart_262 = 
      ((CadPart) compositePart_85.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_279 = 
      ((PartSurface) cadPart_262.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_280 = 
      ((PartSurface) cadPart_262.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_262 = 
      ((PartCurve) cadPart_262.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_263 = 
      ((CadPart) compositePart_83.getChildParts().getPart("ASKUBAL_BALL_M5"));

    PartSurface partSurface_281 = 
      ((PartSurface) cadPart_263.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_263 = 
      ((PartCurve) cadPart_263.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_264 = 
      ((CadPart) compositePart_83.getChildParts().getPart("D125B_5_3"));

    PartSurface partSurface_282 = 
      ((PartSurface) cadPart_264.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_264 = 
      ((PartCurve) cadPart_264.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_86 = 
      ((CompositePart) compositePart_83.getChildParts().getPart("D439_M5"));

    CadPart cadPart_265 = 
      ((CadPart) compositePart_86.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_283 = 
      ((PartSurface) cadPart_265.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_265 = 
      ((PartCurve) cadPart_265.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_87 = 
      ((CompositePart) compositePart_83.getChildParts().getPart("D439_M5 2"));

    CadPart cadPart_266 = 
      ((CadPart) compositePart_87.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_284 = 
      ((PartSurface) cadPart_266.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_266 = 
      ((PartCurve) cadPart_266.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_88 = 
      ((CompositePart) compositePart_83.getChildParts().getPart("DIN985_M5"));

    CadPart cadPart_267 = 
      ((CadPart) compositePart_88.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_285 = 
      ((PartSurface) cadPart_267.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_267 = 
      ((PartCurve) cadPart_267.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_89 = 
      ((CompositePart) compositePart_83.getChildParts().getPart("DIN985_M5 2"));

    CadPart cadPart_268 = 
      ((CadPart) compositePart_89.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_286 = 
      ((PartSurface) cadPart_268.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_268 = 
      ((PartCurve) cadPart_268.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_269 = 
      ((CadPart) compositePart_83.getChildParts().getPart("DIN7985TX_M4X10"));

    PartSurface partSurface_287 = 
      ((PartSurface) cadPart_269.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_269 = 
      ((PartCurve) cadPart_269.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_270 = 
      ((CadPart) compositePart_83.getChildParts().getPart("DIN7985TX_M4X30"));

    PartSurface partSurface_288 = 
      ((PartSurface) cadPart_270.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_270 = 
      ((PartCurve) cadPart_270.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_271 = 
      ((CadPart) compositePart_83.getChildParts().getPart("DIN7985TX_M5X25"));

    PartSurface partSurface_289 = 
      ((PartSurface) cadPart_271.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_271 = 
      ((PartCurve) cadPart_271.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_90 = 
      ((CompositePart) compositePart_47.getChildParts().getPart("A_RA04_RW_ATTACHMENT_D"));

    CadPart cadPart_272 = 
      ((CadPart) compositePart_90.getChildParts().getPart("A_RA04_ENDPLATE_BRACKET"));

    PartSurface partSurface_290 = 
      ((PartSurface) cadPart_272.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_272 = 
      ((PartCurve) cadPart_272.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_273 = 
      ((CadPart) compositePart_90.getChildParts().getPart("A_RA04_INSERT_ROD_BOTTOM"));

    PartSurface partSurface_291 = 
      ((PartSurface) cadPart_273.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_273 = 
      ((PartCurve) cadPart_273.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_274 = 
      ((CadPart) compositePart_90.getChildParts().getPart("A_RA04_INSERT_ROD_TOP"));

    PartSurface partSurface_292 = 
      ((PartSurface) cadPart_274.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_274 = 
      ((PartCurve) cadPart_274.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_275 = 
      ((CadPart) compositePart_90.getChildParts().getPart("A_RA04_MONO_BRACKET_TYPE_A"));

    PartSurface partSurface_293 = 
      ((PartSurface) cadPart_275.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_275 = 
      ((PartCurve) cadPart_275.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_276 = 
      ((CadPart) compositePart_90.getChildParts().getPart("A_RA04_ROD"));

    PartSurface partSurface_294 = 
      ((PartSurface) cadPart_276.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_276 = 
      ((PartCurve) cadPart_276.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_91 = 
      ((CompositePart) compositePart_90.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5"));

    CadPart cadPart_277 = 
      ((CadPart) compositePart_91.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_295 = 
      ((PartSurface) cadPart_277.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_296 = 
      ((PartSurface) cadPart_277.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_277 = 
      ((PartCurve) cadPart_277.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_92 = 
      ((CompositePart) compositePart_90.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5 2"));

    CadPart cadPart_278 = 
      ((CadPart) compositePart_92.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_297 = 
      ((PartSurface) cadPart_278.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_298 = 
      ((PartSurface) cadPart_278.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_278 = 
      ((PartCurve) cadPart_278.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_279 = 
      ((CadPart) compositePart_90.getChildParts().getPart("ASKUBAL_BALL_M5"));

    PartSurface partSurface_299 = 
      ((PartSurface) cadPart_279.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_279 = 
      ((PartCurve) cadPart_279.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_280 = 
      ((CadPart) compositePart_90.getChildParts().getPart("D125B_5_3"));

    PartSurface partSurface_300 = 
      ((PartSurface) cadPart_280.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_280 = 
      ((PartCurve) cadPart_280.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_93 = 
      ((CompositePart) compositePart_90.getChildParts().getPart("D439_M5"));

    CadPart cadPart_281 = 
      ((CadPart) compositePart_93.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_301 = 
      ((PartSurface) cadPart_281.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_281 = 
      ((PartCurve) cadPart_281.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_94 = 
      ((CompositePart) compositePart_90.getChildParts().getPart("D439_M5 2"));

    CadPart cadPart_282 = 
      ((CadPart) compositePart_94.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_302 = 
      ((PartSurface) cadPart_282.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_282 = 
      ((PartCurve) cadPart_282.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_95 = 
      ((CompositePart) compositePart_90.getChildParts().getPart("DIN985_M5"));

    CadPart cadPart_283 = 
      ((CadPart) compositePart_95.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_303 = 
      ((PartSurface) cadPart_283.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_283 = 
      ((PartCurve) cadPart_283.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_96 = 
      ((CompositePart) compositePart_90.getChildParts().getPart("DIN985_M5 2"));

    CadPart cadPart_284 = 
      ((CadPart) compositePart_96.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_304 = 
      ((PartSurface) cadPart_284.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_284 = 
      ((PartCurve) cadPart_284.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_285 = 
      ((CadPart) compositePart_90.getChildParts().getPart("DIN7985TX_M4X10"));

    PartSurface partSurface_305 = 
      ((PartSurface) cadPart_285.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_285 = 
      ((PartCurve) cadPart_285.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_286 = 
      ((CadPart) compositePart_90.getChildParts().getPart("DIN7985TX_M4X20"));

    PartSurface partSurface_306 = 
      ((PartSurface) cadPart_286.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_286 = 
      ((PartCurve) cadPart_286.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_287 = 
      ((CadPart) compositePart_90.getChildParts().getPart("DIN7985TX_M5X25"));

    PartSurface partSurface_307 = 
      ((PartSurface) cadPart_287.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_287 = 
      ((PartCurve) cadPart_287.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_97 = 
      ((CompositePart) compositePart_47.getChildParts().getPart("A_RA04_RW_ATTACHMENT_D_MIR"));

    CadPart cadPart_288 = 
      ((CadPart) compositePart_97.getChildParts().getPart("A_RA04_ENDPLATE_BRACKET_MIR"));

    PartSurface partSurface_308 = 
      ((PartSurface) cadPart_288.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_288 = 
      ((PartCurve) cadPart_288.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_289 = 
      ((CadPart) compositePart_97.getChildParts().getPart("A_RA04_INSERT_ROD_BOTTOM_MIR"));

    PartSurface partSurface_309 = 
      ((PartSurface) cadPart_289.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_289 = 
      ((PartCurve) cadPart_289.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_290 = 
      ((CadPart) compositePart_97.getChildParts().getPart("A_RA04_INSERT_ROD_TOP_MIR"));

    PartSurface partSurface_310 = 
      ((PartSurface) cadPart_290.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_290 = 
      ((PartCurve) cadPart_290.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_291 = 
      ((CadPart) compositePart_97.getChildParts().getPart("A_RA04_MONO_BRACKET_TYPE_A_MIR"));

    PartSurface partSurface_311 = 
      ((PartSurface) cadPart_291.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_291 = 
      ((PartCurve) cadPart_291.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_292 = 
      ((CadPart) compositePart_97.getChildParts().getPart("A_RA04_ROD_MIR"));

    PartSurface partSurface_312 = 
      ((PartSurface) cadPart_292.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_292 = 
      ((PartCurve) cadPart_292.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_98 = 
      ((CompositePart) compositePart_97.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5"));

    CadPart cadPart_293 = 
      ((CadPart) compositePart_98.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_313 = 
      ((PartSurface) cadPart_293.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_314 = 
      ((PartSurface) cadPart_293.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_293 = 
      ((PartCurve) cadPart_293.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_99 = 
      ((CompositePart) compositePart_97.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5 2"));

    CadPart cadPart_294 = 
      ((CadPart) compositePart_99.getChildParts().getPart("ASKUBAL_BALL_HEAD_M5_Body"));

    PartSurface partSurface_315 = 
      ((PartSurface) cadPart_294.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_316 = 
      ((PartSurface) cadPart_294.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_294 = 
      ((PartCurve) cadPart_294.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_295 = 
      ((CadPart) compositePart_97.getChildParts().getPart("ASKUBAL_BALL_M5"));

    PartSurface partSurface_317 = 
      ((PartSurface) cadPart_295.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_295 = 
      ((PartCurve) cadPart_295.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_296 = 
      ((CadPart) compositePart_97.getChildParts().getPart("D125B_5_3"));

    PartSurface partSurface_318 = 
      ((PartSurface) cadPart_296.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_296 = 
      ((PartCurve) cadPart_296.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_100 = 
      ((CompositePart) compositePart_97.getChildParts().getPart("D439_M5"));

    CadPart cadPart_297 = 
      ((CadPart) compositePart_100.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_319 = 
      ((PartSurface) cadPart_297.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_297 = 
      ((PartCurve) cadPart_297.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_101 = 
      ((CompositePart) compositePart_97.getChildParts().getPart("D439_M5 2"));

    CadPart cadPart_298 = 
      ((CadPart) compositePart_101.getChildParts().getPart("D439_M5_Body"));

    PartSurface partSurface_320 = 
      ((PartSurface) cadPart_298.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_298 = 
      ((PartCurve) cadPart_298.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_102 = 
      ((CompositePart) compositePart_97.getChildParts().getPart("DIN985_M5"));

    CadPart cadPart_299 = 
      ((CadPart) compositePart_102.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_321 = 
      ((PartSurface) cadPart_299.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_299 = 
      ((PartCurve) cadPart_299.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_103 = 
      ((CompositePart) compositePart_97.getChildParts().getPart("DIN985_M5 2"));

    CadPart cadPart_300 = 
      ((CadPart) compositePart_103.getChildParts().getPart("DIN985_M5_Body"));

    PartSurface partSurface_322 = 
      ((PartSurface) cadPart_300.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_300 = 
      ((PartCurve) cadPart_300.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_301 = 
      ((CadPart) compositePart_97.getChildParts().getPart("DIN7985TX_M4X10"));

    PartSurface partSurface_323 = 
      ((PartSurface) cadPart_301.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_301 = 
      ((PartCurve) cadPart_301.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_302 = 
      ((CadPart) compositePart_97.getChildParts().getPart("DIN7985TX_M4X20"));

    PartSurface partSurface_324 = 
      ((PartSurface) cadPart_302.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_302 = 
      ((PartCurve) cadPart_302.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_303 = 
      ((CadPart) compositePart_97.getChildParts().getPart("DIN7985TX_M5X25"));

    PartSurface partSurface_325 = 
      ((PartSurface) cadPart_303.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_303 = 
      ((PartCurve) cadPart_303.getPartCurveManager().getPartCurve("Edges"));

    SolidModelCompositePart solidModelCompositePart_4 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("z_000_remaining-parts"));

    CompositePart compositePart_104 = 
      ((CompositePart) solidModelCompositePart_4.getChildParts().getPart("Suspension_Front_Left"));

    CadPart cadPart_304 = 
      ((CadPart) compositePart_104.getChildParts().getPart("S_FL02_U"));

    PartSurface partSurface_326 = 
      ((PartSurface) cadPart_304.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_304 = 
      ((PartCurve) cadPart_304.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_305 = 
      ((CadPart) compositePart_104.getChildParts().getPart("S_FL03_L"));

    PartSurface partSurface_327 = 
      ((PartSurface) cadPart_305.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_305 = 
      ((PartCurve) cadPart_305.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_306 = 
      ((CadPart) compositePart_104.getChildParts().getPart("S_FL03_L 2"));

    PartSurface partSurface_328 = 
      ((PartSurface) cadPart_306.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_306 = 
      ((PartCurve) cadPart_306.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_307 = 
      ((CadPart) compositePart_104.getChildParts().getPart("S_FL04_T"));

    PartSurface partSurface_329 = 
      ((PartSurface) cadPart_307.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_307 = 
      ((PartCurve) cadPart_307.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_308 = 
      ((CadPart) compositePart_104.getChildParts().getPart("S_FL06_P"));

    PartSurface partSurface_330 = 
      ((PartSurface) cadPart_308.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_308 = 
      ((PartCurve) cadPart_308.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_105 = 
      ((CompositePart) solidModelCompositePart_4.getChildParts().getPart("Suspension_Front_Right"));

    CadPart cadPart_309 = 
      ((CadPart) compositePart_105.getChildParts().getPart("S_FL02_U"));

    PartSurface partSurface_331 = 
      ((PartSurface) cadPart_309.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_309 = 
      ((PartCurve) cadPart_309.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_310 = 
      ((CadPart) compositePart_105.getChildParts().getPart("S_FL03_L"));

    PartSurface partSurface_332 = 
      ((PartSurface) cadPart_310.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_310 = 
      ((PartCurve) cadPart_310.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_311 = 
      ((CadPart) compositePart_105.getChildParts().getPart("S_FL03_L 2"));

    PartSurface partSurface_333 = 
      ((PartSurface) cadPart_311.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_311 = 
      ((PartCurve) cadPart_311.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_312 = 
      ((CadPart) compositePart_105.getChildParts().getPart("S_FL04_T"));

    PartSurface partSurface_334 = 
      ((PartSurface) cadPart_312.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_312 = 
      ((PartCurve) cadPart_312.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_313 = 
      ((CadPart) compositePart_105.getChildParts().getPart("S_FL06_P"));

    PartSurface partSurface_335 = 
      ((PartSurface) cadPart_313.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_313 = 
      ((PartCurve) cadPart_313.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_106 = 
      ((CompositePart) solidModelCompositePart_4.getChildParts().getPart("Suspension_Rear_Left"));

    CadPart cadPart_314 = 
      ((CadPart) compositePart_106.getChildParts().getPart("S_RL02_U"));

    PartSurface partSurface_336 = 
      ((PartSurface) cadPart_314.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_314 = 
      ((PartCurve) cadPart_314.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_315 = 
      ((CadPart) compositePart_106.getChildParts().getPart("S_RL02_U 2"));

    PartSurface partSurface_337 = 
      ((PartSurface) cadPart_315.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_315 = 
      ((PartCurve) cadPart_315.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_316 = 
      ((CadPart) compositePart_106.getChildParts().getPart("S_RL03_L"));

    PartSurface partSurface_338 = 
      ((PartSurface) cadPart_316.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_316 = 
      ((PartCurve) cadPart_316.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_317 = 
      ((CadPart) compositePart_106.getChildParts().getPart("S_RL03_L 2"));

    PartSurface partSurface_339 = 
      ((PartSurface) cadPart_317.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_317 = 
      ((PartCurve) cadPart_317.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_318 = 
      ((CadPart) compositePart_106.getChildParts().getPart("S_RL04_T"));

    PartSurface partSurface_340 = 
      ((PartSurface) cadPart_318.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_318 = 
      ((PartCurve) cadPart_318.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_319 = 
      ((CadPart) compositePart_106.getChildParts().getPart("S_RL06_P"));

    PartSurface partSurface_341 = 
      ((PartSurface) cadPart_319.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_319 = 
      ((PartCurve) cadPart_319.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_320 = 
      ((CadPart) compositePart_106.getChildParts().getPart("S_RL06_P 2"));

    PartSurface partSurface_342 = 
      ((PartSurface) cadPart_320.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_320 = 
      ((PartCurve) cadPart_320.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_107 = 
      ((CompositePart) solidModelCompositePart_4.getChildParts().getPart("Suspension_Rear_Right"));

    CadPart cadPart_323 = 
      ((CadPart) compositePart_107.getChildParts().getPart("S_RL02_U"));

    PartSurface partSurface_345 = 
      ((PartSurface) cadPart_323.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_323 = 
      ((PartCurve) cadPart_323.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_324 = 
      ((CadPart) compositePart_107.getChildParts().getPart("S_RL02_U 2"));

    PartSurface partSurface_346 = 
      ((PartSurface) cadPart_324.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_324 = 
      ((PartCurve) cadPart_324.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_325 = 
      ((CadPart) compositePart_107.getChildParts().getPart("S_RL03_L"));

    PartSurface partSurface_347 = 
      ((PartSurface) cadPart_325.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_325 = 
      ((PartCurve) cadPart_325.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_326 = 
      ((CadPart) compositePart_107.getChildParts().getPart("S_RL03_L 2"));

    PartSurface partSurface_348 = 
      ((PartSurface) cadPart_326.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_326 = 
      ((PartCurve) cadPart_326.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_327 = 
      ((CadPart) compositePart_107.getChildParts().getPart("S_RL04_T"));

    PartSurface partSurface_349 = 
      ((PartSurface) cadPart_327.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_327 = 
      ((PartCurve) cadPart_327.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_328 = 
      ((CadPart) compositePart_107.getChildParts().getPart("S_RL06_P"));

    PartSurface partSurface_350 = 
      ((PartSurface) cadPart_328.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_328 = 
      ((PartCurve) cadPart_328.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_329 = 
      ((CadPart) compositePart_107.getChildParts().getPart("S_RL06_P 2"));

    PartSurface partSurface_351 = 
      ((PartSurface) cadPart_329.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_329 = 
      ((PartCurve) cadPart_329.getPartCurveManager().getPartCurve("Edges"));

    partDisplayer_7.getInputParts().setObjects(partSurface_149, partCurve_147, partSurface_150, partCurve_148, partSurface_151, partCurve_149, partSurface_152, partCurve_150, partSurface_153, partCurve_151, partSurface_154, partCurve_152, partSurface_155, partSurface_156, partCurve_153, partSurface_157, partSurface_158, partCurve_154, partSurface_159, partCurve_155, partSurface_160, partCurve_156, partSurface_161, partCurve_157, partSurface_162, partCurve_158, partSurface_163, partCurve_159, partSurface_164, partCurve_160, partSurface_165, partCurve_161, partSurface_166, partCurve_162, partSurface_167, partCurve_163, partSurface_168, partCurve_164, partSurface_169, partCurve_165, partSurface_170, partCurve_166, partSurface_171, partCurve_167, partSurface_172, partCurve_168, partSurface_173, partSurface_174, partCurve_169, partSurface_175, partSurface_176, partCurve_170, partSurface_177, partCurve_171, partSurface_178, partCurve_172, partSurface_179, partCurve_173, partSurface_180, partCurve_174, partSurface_181, partCurve_175, partSurface_182, partCurve_176, partSurface_183, partCurve_177, partSurface_184, partCurve_178, partSurface_486, partCurve_467, partSurface_185, partCurve_179, partSurface_186, partCurve_180, partSurface_187, partCurve_181, partSurface_188, partCurve_182, partSurface_189, partCurve_183, partSurface_190, partSurface_191, partCurve_184, partSurface_192, partSurface_193, partCurve_185, partSurface_194, partCurve_186, partSurface_195, partCurve_187, partSurface_196, partCurve_188, partSurface_197, partCurve_189, partSurface_198, partCurve_190, partSurface_199, partCurve_191, partSurface_200, partCurve_192, partSurface_201, partCurve_193, partSurface_202, partCurve_194, partSurface_203, partCurve_195, partSurface_204, partCurve_196, partSurface_205, partCurve_197, partSurface_206, partCurve_198, partSurface_207, partSurface_208, partCurve_199, partSurface_209, partSurface_210, partCurve_200, partSurface_211, partCurve_201, partSurface_212, partCurve_202, partSurface_213, partCurve_203, partSurface_214, partCurve_204, partSurface_215, partCurve_205, partSurface_216, partCurve_206, partSurface_217, partCurve_207, partSurface_218, partCurve_208, partSurface_219, partCurve_209, partSurface_220, partCurve_210, partSurface_221, partCurve_211, partSurface_222, partCurve_212, partSurface_223, partSurface_224, partCurve_213, partSurface_225, partSurface_226, partCurve_214, partSurface_227, partCurve_215, partSurface_228, partCurve_216, partSurface_229, partCurve_217, partSurface_230, partCurve_218, partSurface_231, partCurve_219, partSurface_232, partCurve_220, partSurface_233, partCurve_221, partSurface_234, partCurve_222, partSurface_235, partCurve_223, partSurface_236, partCurve_224, partSurface_237, partCurve_225, partSurface_238, partCurve_226, partSurface_239, partCurve_227, partSurface_240, partCurve_228, partSurface_241, partSurface_242, partCurve_229, partSurface_243, partSurface_244, partCurve_230, partSurface_245, partCurve_231, partSurface_246, partCurve_232, partSurface_247, partCurve_233, partSurface_248, partCurve_234, partSurface_249, partCurve_235, partSurface_250, partCurve_236, partSurface_251, partCurve_237, partSurface_252, partCurve_238, partSurface_253, partCurve_239, partSurface_254, partCurve_240, partSurface_255, partCurve_241, partSurface_256, partCurve_242, partSurface_257, partCurve_243, partSurface_258, partCurve_244, partSurface_259, partSurface_260, partCurve_245, partSurface_261, partSurface_262, partCurve_246, partSurface_263, partCurve_247, partSurface_264, partCurve_248, partSurface_265, partCurve_249, partSurface_266, partCurve_250, partSurface_267, partCurve_251, partSurface_268, partCurve_252, partSurface_269, partCurve_253, partSurface_270, partCurve_254, partSurface_271, partCurve_255, partSurface_272, partCurve_256, partSurface_273, partCurve_257, partSurface_274, partCurve_258, partSurface_275, partCurve_259, partSurface_276, partCurve_260, partSurface_277, partSurface_278, partCurve_261, partSurface_279, partSurface_280, partCurve_262, partSurface_281, partCurve_263, partSurface_282, partCurve_264, partSurface_283, partCurve_265, partSurface_284, partCurve_266, partSurface_285, partCurve_267, partSurface_286, partCurve_268, partSurface_287, partCurve_269, partSurface_288, partCurve_270, partSurface_289, partCurve_271, partSurface_290, partCurve_272, partSurface_291, partCurve_273, partSurface_292, partCurve_274, partSurface_293, partCurve_275, partSurface_294, partCurve_276, partSurface_295, partSurface_296, partCurve_277, partSurface_297, partSurface_298, partCurve_278, partSurface_299, partCurve_279, partSurface_300, partCurve_280, partSurface_301, partCurve_281, partSurface_302, partCurve_282, partSurface_303, partCurve_283, partSurface_304, partCurve_284, partSurface_305, partCurve_285, partSurface_306, partCurve_286, partSurface_307, partCurve_287, partSurface_308, partCurve_288, partSurface_309, partCurve_289, partSurface_310, partCurve_290, partSurface_311, partCurve_291, partSurface_312, partCurve_292, partSurface_313, partSurface_314, partCurve_293, partSurface_315, partSurface_316, partCurve_294, partSurface_317, partCurve_295, partSurface_318, partCurve_296, partSurface_319, partCurve_297, partSurface_320, partCurve_298, partSurface_321, partCurve_299, partSurface_322, partCurve_300, partSurface_323, partCurve_301, partSurface_324, partCurve_302, partSurface_325, partCurve_303, partSurface_326, partCurve_304, partSurface_327, partCurve_305, partSurface_328, partCurve_306, partSurface_329, partCurve_307, partSurface_330, partCurve_308, partSurface_331, partCurve_309, partSurface_332, partCurve_310, partSurface_333, partCurve_311, partSurface_334, partCurve_312, partSurface_335, partCurve_313, partSurface_336, partCurve_314, partSurface_337, partCurve_315, partSurface_338, partCurve_316, partSurface_339, partCurve_317, partSurface_340, partCurve_318, partSurface_341, partCurve_319, partSurface_342, partCurve_320, partSurface_345, partCurve_323, partSurface_346, partCurve_324, partSurface_347, partCurve_325, partSurface_348, partCurve_326, partSurface_349, partCurve_327, partSurface_350, partCurve_328, partSurface_351, partCurve_329);
  }

  private void execute7() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Scene scene_1 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 2");

    PartDisplayer partDisplayer_11 = 
      ((PartDisplayer) scene_1.getDisplayerManager().getObject("headrest"));

    partDisplayer_11.getInputParts().setQuery(null);

    SolidModelCompositePart solidModelCompositePart_3 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("C_MONOCOQUE"));

    CompositePart compositePart_108 = 
      ((CompositePart) solidModelCompositePart_3.getChildParts().getPart("C_HR00_HEAD_RESTRAINT_ASM"));

    CadPart cadPart_332 = 
      ((CadPart) compositePart_108.getChildParts().getPart("C_HR01_PADDING"));

    PartSurface partSurface_484 = 
      ((PartSurface) cadPart_332.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_465 = 
      ((PartCurve) cadPart_332.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_333 = 
      ((CadPart) compositePart_108.getChildParts().getPart("C_HR02_SUPPORT_PLATE"));

    PartSurface partSurface_485 = 
      ((PartSurface) cadPart_333.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_466 = 
      ((PartCurve) cadPart_333.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_335 = 
      ((CadPart) compositePart_108.getChildParts().getPart("C_HR05_SAFETY_FLANGE"));

    PartSurface partSurface_487 = 
      ((PartSurface) cadPart_335.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_468 = 
      ((PartCurve) cadPart_335.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_336 = 
      ((CadPart) compositePart_108.getChildParts().getPart("C_HR06_SIDE_PADDING_LEFT"));

    PartSurface partSurface_488 = 
      ((PartSurface) cadPart_336.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_469 = 
      ((PartCurve) cadPart_336.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_337 = 
      ((CadPart) compositePart_108.getChildParts().getPart("C_HR06_SIDE_PADDING_RIGHT"));

    PartSurface partSurface_489 = 
      ((PartSurface) cadPart_337.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_470 = 
      ((PartCurve) cadPart_337.getPartCurveManager().getPartCurve("Edges"));

    partDisplayer_11.getInputParts().setObjects(partSurface_484, partCurve_465, partSurface_485, partCurve_466, partSurface_487, partCurve_468, partSurface_488, partCurve_469, partSurface_489, partCurve_470);

    partDisplayer_11.getInputParts().setQuery(null);

    partDisplayer_11.getInputParts().setObjects(partSurface_484, partCurve_465, partSurface_488, partCurve_469, partSurface_489, partCurve_470);

    partDisplayer_11.setColorMode(PartColorMode.PRESET);

    PresetColorSettings presetColorSettings_9 = 
      partDisplayer_11.getPresetColorSettings();

    RayTraceMatteMaterial rayTraceMatteMaterial_2 = 
      ((RayTraceMatteMaterial) simulation_0.get(RayTraceMaterialManager.class).getObject("Matte Black"));

    presetColorSettings_9.setRayTraceMaterial(rayTraceMatteMaterial_2);

    PartDisplayer partDisplayer_5 = 
      ((PartDisplayer) scene_1.getDisplayerManager().getObject("aero"));

    partDisplayer_5.getInputParts().setQuery(null);

    SolidModelCompositePart solidModelCompositePart_0 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("C_FRONTWING"));

    CompositePart compositePart_0 = 
      ((CompositePart) solidModelCompositePart_0.getChildParts().getPart("A_F000_FRONTWING_ASM"));

    CadPart cadPart_0 = 
      ((CadPart) compositePart_0.getChildParts().getPart("A_F001_MAINELEMENT"));

    PartSurface partSurface_1 = 
      ((PartSurface) cadPart_0.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_0 = 
      ((PartCurve) cadPart_0.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_1 = 
      ((CadPart) compositePart_0.getChildParts().getPart("A_F002_LOWER_TOWERFLAP"));

    PartSurface partSurface_2 = 
      ((PartSurface) cadPart_1.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_1 = 
      ((PartCurve) cadPart_1.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_2 = 
      ((CadPart) compositePart_0.getChildParts().getPart("A_F002_LOWER_TOWERFLAP_MIR"));

    PartSurface partSurface_3 = 
      ((PartSurface) cadPart_2.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_2 = 
      ((PartCurve) cadPart_2.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_3 = 
      ((CadPart) compositePart_0.getChildParts().getPart("A_F003_MIDDLE_TOWERFLAP"));

    PartSurface partSurface_4 = 
      ((PartSurface) cadPart_3.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_3 = 
      ((PartCurve) cadPart_3.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_4 = 
      ((CadPart) compositePart_0.getChildParts().getPart("A_F003_MIDDLE_TOWERFLAP_MIR"));

    PartSurface partSurface_5 = 
      ((PartSurface) cadPart_4.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_4 = 
      ((PartCurve) cadPart_4.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_5 = 
      ((CadPart) compositePart_0.getChildParts().getPart("A_F004_UPPER_TOWERFLAP"));

    PartSurface partSurface_6 = 
      ((PartSurface) cadPart_5.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_5 = 
      ((PartCurve) cadPart_5.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_6 = 
      ((CadPart) compositePart_0.getChildParts().getPart("A_F004_UPPER_TOWERFLAP_MIR"));

    PartSurface partSurface_7 = 
      ((PartSurface) cadPart_6.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_6 = 
      ((PartCurve) cadPart_6.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_1 = 
      ((CompositePart) compositePart_0.getChildParts().getPart("A_F006_OUTER_FLAP_01"));

    CadPart cadPart_7 = 
      ((CadPart) compositePart_1.getChildParts().getPart("A_F006_OUTER_FLAP_01_Body"));

    PartSurface partSurface_8 = 
      ((PartSurface) cadPart_7.getPartSurfaceManager().getPartSurface("Faces"));

    PartSurface partSurface_9 = 
      ((PartSurface) cadPart_7.getPartSurfaceManager().getPartSurface("Faces 2"));

    PartCurve partCurve_7 = 
      ((PartCurve) cadPart_7.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_8 = 
      ((CadPart) compositePart_0.getChildParts().getPart("A_F006_OUTER_FLAP_01_MIR"));

    PartSurface partSurface_10 = 
      ((PartSurface) cadPart_8.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_8 = 
      ((PartCurve) cadPart_8.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_9 = 
      ((CadPart) compositePart_0.getChildParts().getPart("A_F007_OUTER_FLAP_02"));

    PartSurface partSurface_11 = 
      ((PartSurface) cadPart_9.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_9 = 
      ((PartCurve) cadPart_9.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_10 = 
      ((CadPart) compositePart_0.getChildParts().getPart("A_F007_OUTER_FLAP_02_MIR"));

    PartSurface partSurface_12 = 
      ((PartSurface) cadPart_10.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_10 = 
      ((PartCurve) cadPart_10.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_11 = 
      ((CadPart) compositePart_0.getChildParts().getPart("A_F008_MIDDLE_PLATE"));

    PartSurface partSurface_13 = 
      ((PartSurface) cadPart_11.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_11 = 
      ((PartCurve) cadPart_11.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_12 = 
      ((CadPart) compositePart_0.getChildParts().getPart("A_F008_MIDDLE_PLATE_MIR"));

    PartSurface partSurface_14 = 
      ((PartSurface) cadPart_12.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_12 = 
      ((PartCurve) cadPart_12.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_13 = 
      ((CadPart) compositePart_0.getChildParts().getPart("A_F009_ENDPLATE"));

    PartSurface partSurface_15 = 
      ((PartSurface) cadPart_13.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_13 = 
      ((PartCurve) cadPart_13.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_14 = 
      ((CadPart) compositePart_0.getChildParts().getPart("A_F009_ENDPLATE_MIR"));

    PartSurface partSurface_16 = 
      ((PartSurface) cadPart_14.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_14 = 
      ((PartCurve) cadPart_14.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_15 = 
      ((CadPart) compositePart_0.getChildParts().getPart("A_F010_MIDDLE_TOWERFLAP_EP"));

    PartSurface partSurface_17 = 
      ((PartSurface) cadPart_15.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_15 = 
      ((PartCurve) cadPart_15.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_16 = 
      ((CadPart) compositePart_0.getChildParts().getPart("A_F010_MIDDLE_TOWERFLAP_EP_MIR"));

    PartSurface partSurface_18 = 
      ((PartSurface) cadPart_16.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_16 = 
      ((PartCurve) cadPart_16.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_17 = 
      ((CadPart) compositePart_0.getChildParts().getPart("A_F011_BULLWING"));

    PartSurface partSurface_19 = 
      ((PartSurface) cadPart_17.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_17 = 
      ((PartCurve) cadPart_17.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_18 = 
      ((CadPart) compositePart_0.getChildParts().getPart("A_F011_BULLWING_MIR"));

    PartSurface partSurface_20 = 
      ((PartSurface) cadPart_18.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_18 = 
      ((PartCurve) cadPart_18.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_19 = 
      ((CadPart) compositePart_0.getChildParts().getPart("A_F012_LOWER_TOWERFLAP_EP"));

    PartSurface partSurface_21 = 
      ((PartSurface) cadPart_19.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_19 = 
      ((PartCurve) cadPart_19.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_20 = 
      ((CadPart) compositePart_0.getChildParts().getPart("A_F012_LOWER_TOWERFLAP_EP_MIR"));

    PartSurface partSurface_22 = 
      ((PartSurface) cadPart_20.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_20 = 
      ((PartCurve) cadPart_20.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_2 = 
      ((CompositePart) compositePart_0.getChildParts().getPart("A_FC00_CASCADE"));

    CadPart cadPart_21 = 
      ((CadPart) compositePart_2.getChildParts().getPart("A_FC01_CASCADE_FLAP1"));

    PartSurface partSurface_23 = 
      ((PartSurface) cadPart_21.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_21 = 
      ((PartCurve) cadPart_21.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_22 = 
      ((CadPart) compositePart_2.getChildParts().getPart("A_FC02_CASCADE_FLAP2"));

    PartSurface partSurface_24 = 
      ((PartSurface) cadPart_22.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_22 = 
      ((PartCurve) cadPart_22.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_23 = 
      ((CadPart) compositePart_2.getChildParts().getPart("A_FC03_CASCADE_ENDPLATE"));

    PartSurface partSurface_25 = 
      ((PartSurface) cadPart_23.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_23 = 
      ((PartCurve) cadPart_23.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_3 = 
      ((CompositePart) compositePart_0.getChildParts().getPart("A_FC00_CASCADE_MIR"));

    CadPart cadPart_24 = 
      ((CadPart) compositePart_3.getChildParts().getPart("A_FC01_CASCADE_FLAP1_MIR"));

    PartSurface partSurface_26 = 
      ((PartSurface) cadPart_24.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_24 = 
      ((PartCurve) cadPart_24.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_25 = 
      ((CadPart) compositePart_3.getChildParts().getPart("A_FC02_CASCADE_FLAP2_MIR"));

    PartSurface partSurface_27 = 
      ((PartSurface) cadPart_25.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_25 = 
      ((PartCurve) cadPart_25.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_26 = 
      ((CadPart) compositePart_3.getChildParts().getPart("A_FC03_CASCADE_ENDPLATE_MIR"));

    PartSurface partSurface_28 = 
      ((PartSurface) cadPart_26.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_26 = 
      ((PartCurve) cadPart_26.getPartCurveManager().getPartCurve("Edges"));

    SolidModelCompositePart solidModelCompositePart_1 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("C_REARWING"));

    CompositePart compositePart_4 = 
      ((CompositePart) solidModelCompositePart_1.getChildParts().getPart("A_R000_REARWING_ASM"));

    CadPart cadPart_27 = 
      ((CadPart) compositePart_4.getChildParts().getPart("A_R001_MAINELEMENT"));

    PartSurface partSurface_29 = 
      ((PartSurface) cadPart_27.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_27 = 
      ((PartCurve) cadPart_27.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_28 = 
      ((CadPart) compositePart_4.getChildParts().getPart("A_R002_FLAP1"));

    PartSurface partSurface_30 = 
      ((PartSurface) cadPart_28.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_28 = 
      ((PartCurve) cadPart_28.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_29 = 
      ((CadPart) compositePart_4.getChildParts().getPart("A_R003_FLAP2"));

    PartSurface partSurface_31 = 
      ((PartSurface) cadPart_29.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_29 = 
      ((PartCurve) cadPart_29.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_30 = 
      ((CadPart) compositePart_4.getChildParts().getPart("A_R005_FLAP3"));

    PartSurface partSurface_32 = 
      ((PartSurface) cadPart_30.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_30 = 
      ((PartCurve) cadPart_30.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_31 = 
      ((CadPart) compositePart_4.getChildParts().getPart("A_R006_FLAP4"));

    PartSurface partSurface_33 = 
      ((PartSurface) cadPart_31.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_31 = 
      ((PartCurve) cadPart_31.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_32 = 
      ((CadPart) compositePart_4.getChildParts().getPart("A_R008_ENDPLATE"));

    PartSurface partSurface_34 = 
      ((PartSurface) cadPart_32.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_32 = 
      ((PartCurve) cadPart_32.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_33 = 
      ((CadPart) compositePart_4.getChildParts().getPart("A_R008_ENDPLATE_MIR"));

    PartSurface partSurface_35 = 
      ((PartSurface) cadPart_33.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_33 = 
      ((PartCurve) cadPart_33.getPartCurveManager().getPartCurve("Edges"));

    SolidModelCompositePart solidModelCompositePart_2 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("C_UNDERTRAY"));

    CompositePart compositePart_6 = 
      ((CompositePart) solidModelCompositePart_2.getChildParts().getPart("A_U000_UNDERTRAY_ASM"));

    CompositePart compositePart_5 = 
      ((CompositePart) compositePart_6.getChildParts().getPart("A_U001_UNDERTRAY"));

    CadPart cadPart_34 = 
      ((CadPart) compositePart_5.getChildParts().getPart("A_U001_UNDERTRAY_Body 4"));

    PartSurface partSurface_36 = 
      ((PartSurface) cadPart_34.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_34 = 
      ((PartCurve) cadPart_34.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_35 = 
      ((CadPart) compositePart_5.getChildParts().getPart("A_U001_UNDERTRAY_MIR_Body"));

    PartSurface partSurface_37 = 
      ((PartSurface) cadPart_35.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_35 = 
      ((PartCurve) cadPart_35.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_7 = 
      ((CompositePart) compositePart_6.getChildParts().getPart("A_U001_UNDERTRAY_MIR"));

    CadPart cadPart_36 = 
      ((CadPart) compositePart_7.getChildParts().getPart("A_U001_UNDERTRAY_Body 4"));

    PartSurface partSurface_38 = 
      ((PartSurface) cadPart_36.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_36 = 
      ((PartCurve) cadPart_36.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_37 = 
      ((CadPart) compositePart_7.getChildParts().getPart("A_U001_UNDERTRAY_MIR_Body"));

    PartSurface partSurface_39 = 
      ((PartSurface) cadPart_37.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_37 = 
      ((PartCurve) cadPart_37.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_38 = 
      ((CadPart) compositePart_6.getChildParts().getPart("A_U002_UNDERTRAY_ENDPLATE"));

    PartSurface partSurface_40 = 
      ((PartSurface) cadPart_38.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_38 = 
      ((PartCurve) cadPart_38.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_39 = 
      ((CadPart) compositePart_6.getChildParts().getPart("A_U002_UNDERTRAY_ENDPLATE_MIR"));

    PartSurface partSurface_41 = 
      ((PartSurface) cadPart_39.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_39 = 
      ((PartCurve) cadPart_39.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_8 = 
      ((CompositePart) compositePart_6.getChildParts().getPart("A_UB00_BEAMWING"));

    CadPart cadPart_40 = 
      ((CadPart) compositePart_8.getChildParts().getPart("A_UB01_BEAMWING1"));

    PartSurface partSurface_42 = 
      ((PartSurface) cadPart_40.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_40 = 
      ((PartCurve) cadPart_40.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_41 = 
      ((CadPart) compositePart_8.getChildParts().getPart("A_UB02_BEAMWING2"));

    PartSurface partSurface_43 = 
      ((PartSurface) cadPart_41.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_41 = 
      ((PartCurve) cadPart_41.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_9 = 
      ((CompositePart) compositePart_8.getChildParts().getPart("A_UB03_ENDPLATE_OUTSIDE"));

    CadPart cadPart_42 = 
      ((CadPart) compositePart_9.getChildParts().getPart("A_UB03_ENDPLATE_OUTSIDE_Body"));

    PartSurface partSurface_44 = 
      ((PartSurface) cadPart_42.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_42 = 
      ((PartCurve) cadPart_42.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_43 = 
      ((CadPart) compositePart_9.getChildParts().getPart("A_UB03_ENDPLATE_OUTSIDE_Body 2"));

    PartSurface partSurface_45 = 
      ((PartSurface) cadPart_43.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_43 = 
      ((PartCurve) cadPart_43.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_10 = 
      ((CompositePart) compositePart_8.getChildParts().getPart("A_UB06_SIDETUNNEL_FLAP"));

    CadPart cadPart_44 = 
      ((CadPart) compositePart_10.getChildParts().getPart("A_UB06_SIDETUNNEL_FLAP_Body"));

    PartSurface partSurface_46 = 
      ((PartSurface) cadPart_44.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_44 = 
      ((PartCurve) cadPart_44.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_45 = 
      ((CadPart) compositePart_10.getChildParts().getPart("A_UB06_SIDETUNNEL_FLAP_Body 2"));

    PartSurface partSurface_47 = 
      ((PartSurface) cadPart_45.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_45 = 
      ((PartCurve) cadPart_45.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_11 = 
      ((CompositePart) compositePart_6.getChildParts().getPart("A_UB00_BEAMWING_MIR"));

    CadPart cadPart_46 = 
      ((CadPart) compositePart_11.getChildParts().getPart("A_UB01_BEAMWING1"));

    PartSurface partSurface_48 = 
      ((PartSurface) cadPart_46.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_46 = 
      ((PartCurve) cadPart_46.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_47 = 
      ((CadPart) compositePart_11.getChildParts().getPart("A_UB02_BEAMWING2"));

    PartSurface partSurface_49 = 
      ((PartSurface) cadPart_47.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_47 = 
      ((PartCurve) cadPart_47.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_12 = 
      ((CompositePart) compositePart_11.getChildParts().getPart("A_UB03_ENDPLATE_OUTSIDE"));

    CadPart cadPart_48 = 
      ((CadPart) compositePart_12.getChildParts().getPart("A_UB03_ENDPLATE_OUTSIDE_Body"));

    PartSurface partSurface_50 = 
      ((PartSurface) cadPart_48.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_48 = 
      ((PartCurve) cadPart_48.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_49 = 
      ((CadPart) compositePart_12.getChildParts().getPart("A_UB03_ENDPLATE_OUTSIDE_Body 2"));

    PartSurface partSurface_51 = 
      ((PartSurface) cadPart_49.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_49 = 
      ((PartCurve) cadPart_49.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_13 = 
      ((CompositePart) compositePart_11.getChildParts().getPart("A_UB06_SIDETUNNEL_FLAP"));

    CadPart cadPart_50 = 
      ((CadPart) compositePart_13.getChildParts().getPart("A_UB06_SIDETUNNEL_FLAP_Body"));

    PartSurface partSurface_52 = 
      ((PartSurface) cadPart_50.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_50 = 
      ((PartCurve) cadPart_50.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_51 = 
      ((CadPart) compositePart_13.getChildParts().getPart("A_UB06_SIDETUNNEL_FLAP_Body 2"));

    PartSurface partSurface_53 = 
      ((PartSurface) cadPart_51.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_51 = 
      ((PartCurve) cadPart_51.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_14 = 
      ((CompositePart) compositePart_6.getChildParts().getPart("A_UF00_FENCES"));

    CadPart cadPart_52 = 
      ((CadPart) compositePart_14.getChildParts().getPart("A_UF01_FENCE1_MIR"));

    PartSurface partSurface_54 = 
      ((PartSurface) cadPart_52.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_52 = 
      ((PartCurve) cadPart_52.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_15 = 
      ((CompositePart) compositePart_14.getChildParts().getPart("A_UF02_FENCE2_MIR"));

    CadPart cadPart_53 = 
      ((CadPart) compositePart_15.getChildParts().getPart("A_UF02_FENCE2_MIR_Body"));

    PartSurface partSurface_55 = 
      ((PartSurface) cadPart_53.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_53 = 
      ((PartCurve) cadPart_53.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_16 = 
      ((CompositePart) compositePart_6.getChildParts().getPart("A_UF00_FENCES_MIR"));

    CadPart cadPart_54 = 
      ((CadPart) compositePart_16.getChildParts().getPart("A_UF01_FENCE1_MIR"));

    PartSurface partSurface_56 = 
      ((PartSurface) cadPart_54.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_54 = 
      ((PartCurve) cadPart_54.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_17 = 
      ((CompositePart) compositePart_16.getChildParts().getPart("A_UF02_FENCE2_MIR"));

    CadPart cadPart_55 = 
      ((CadPart) compositePart_17.getChildParts().getPart("A_UF02_FENCE2_MIR_Body"));

    PartSurface partSurface_57 = 
      ((PartSurface) cadPart_55.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_55 = 
      ((PartCurve) cadPart_55.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_18 = 
      ((CompositePart) compositePart_6.getChildParts().getPart("A_US00_SIDEPOD"));

    CadPart cadPart_56 = 
      ((CadPart) compositePart_18.getChildParts().getPart("A_US01_TOPPLATE"));

    PartSurface partSurface_58 = 
      ((PartSurface) cadPart_56.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_56 = 
      ((PartCurve) cadPart_56.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_57 = 
      ((CadPart) compositePart_18.getChildParts().getPart("A_US02_SIDEWALL"));

    PartSurface partSurface_59 = 
      ((PartSurface) cadPart_57.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_57 = 
      ((PartCurve) cadPart_57.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_58 = 
      ((CadPart) compositePart_18.getChildParts().getPart("A_US03_MONOWALL"));

    PartSurface partSurface_60 = 
      ((PartSurface) cadPart_58.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_58 = 
      ((PartCurve) cadPart_58.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_19 = 
      ((CompositePart) compositePart_18.getChildParts().getPart("A_USD0_DUCT"));

    CadPart cadPart_59 = 
      ((CadPart) compositePart_19.getChildParts().getPart("A_USD1_NACA_DUCT"));

    PartSurface partSurface_61 = 
      ((PartSurface) cadPart_59.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_59 = 
      ((PartCurve) cadPart_59.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_60 = 
      ((CadPart) compositePart_19.getChildParts().getPart("A_USD2_DUCT"));

    PartSurface partSurface_62 = 
      ((PartSurface) cadPart_60.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_60 = 
      ((PartCurve) cadPart_60.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_61 = 
      ((CadPart) compositePart_19.getChildParts().getPart("A_USD3_CARBON_DUCT"));

    PartSurface partSurface_63 = 
      ((PartSurface) cadPart_61.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_61 = 
      ((PartCurve) cadPart_61.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_20 = 
      ((CompositePart) compositePart_6.getChildParts().getPart("A_US00_SIDEPOD_MIR"));

    CadPart cadPart_62 = 
      ((CadPart) compositePart_20.getChildParts().getPart("A_US01_TOPPLATE_MIR"));

    PartSurface partSurface_64 = 
      ((PartSurface) cadPart_62.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_62 = 
      ((PartCurve) cadPart_62.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_63 = 
      ((CadPart) compositePart_20.getChildParts().getPart("A_US02_SIDEWALL_MIR"));

    PartSurface partSurface_65 = 
      ((PartSurface) cadPart_63.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_63 = 
      ((PartCurve) cadPart_63.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_64 = 
      ((CadPart) compositePart_20.getChildParts().getPart("A_US03_MONOWALL_MIR"));

    PartSurface partSurface_66 = 
      ((PartSurface) cadPart_64.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_64 = 
      ((PartCurve) cadPart_64.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_21 = 
      ((CompositePart) compositePart_20.getChildParts().getPart("A_USD0_DUCT_MIR"));

    CadPart cadPart_65 = 
      ((CadPart) compositePart_21.getChildParts().getPart("A_USD1_NACA_DUCT_MIR"));

    PartSurface partSurface_67 = 
      ((PartSurface) cadPart_65.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_65 = 
      ((PartCurve) cadPart_65.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_66 = 
      ((CadPart) compositePart_21.getChildParts().getPart("A_USD2_DUCT_MIR"));

    PartSurface partSurface_68 = 
      ((PartSurface) cadPart_66.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_66 = 
      ((PartCurve) cadPart_66.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_67 = 
      ((CadPart) compositePart_21.getChildParts().getPart("A_USD3_CARBON_DUCT_MIR"));

    PartSurface partSurface_69 = 
      ((PartSurface) cadPart_67.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_67 = 
      ((PartCurve) cadPart_67.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_22 = 
      ((CompositePart) compositePart_6.getChildParts().getPart("A_US00_SIDEWINGS"));

    CadPart cadPart_68 = 
      ((CadPart) compositePart_22.getChildParts().getPart("A_US01_SIDEWING1"));

    PartSurface partSurface_70 = 
      ((PartSurface) cadPart_68.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_68 = 
      ((PartCurve) cadPart_68.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_69 = 
      ((CadPart) compositePart_22.getChildParts().getPart("A_US03_SIDEWING_ENDPLATE"));

    PartSurface partSurface_71 = 
      ((PartSurface) cadPart_69.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_69 = 
      ((PartCurve) cadPart_69.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_23 = 
      ((CompositePart) compositePart_6.getChildParts().getPart("A_US00_SIDEWINGS_MIR"));

    CadPart cadPart_70 = 
      ((CadPart) compositePart_23.getChildParts().getPart("A_US01_SIDEWING1_MIR"));

    PartSurface partSurface_72 = 
      ((PartSurface) cadPart_70.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_70 = 
      ((PartCurve) cadPart_70.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_71 = 
      ((CadPart) compositePart_23.getChildParts().getPart("A_US03_SIDEWING_ENDPLATE_MIR"));

    PartSurface partSurface_73 = 
      ((PartSurface) cadPart_71.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_71 = 
      ((PartCurve) cadPart_71.getPartCurveManager().getPartCurve("Edges"));

    partDisplayer_5.getInputParts().setObjects(partSurface_1, partCurve_0, partSurface_2, partCurve_1, partSurface_3, partCurve_2, partSurface_4, partCurve_3, partSurface_5, partCurve_4, partSurface_6, partCurve_5, partSurface_7, partCurve_6, partSurface_8, partSurface_9, partCurve_7, partSurface_10, partCurve_8, partSurface_11, partCurve_9, partSurface_12, partCurve_10, partSurface_13, partCurve_11, partSurface_14, partCurve_12, partSurface_15, partCurve_13, partSurface_16, partCurve_14, partSurface_17, partCurve_15, partSurface_18, partCurve_16, partSurface_19, partCurve_17, partSurface_20, partCurve_18, partSurface_21, partCurve_19, partSurface_22, partCurve_20, partSurface_23, partCurve_21, partSurface_24, partCurve_22, partSurface_25, partCurve_23, partSurface_26, partCurve_24, partSurface_27, partCurve_25, partSurface_28, partCurve_26, partSurface_485, partCurve_466, partSurface_487, partCurve_468, partSurface_29, partCurve_27, partSurface_30, partCurve_28, partSurface_31, partCurve_29, partSurface_32, partCurve_30, partSurface_33, partCurve_31, partSurface_34, partCurve_32, partSurface_35, partCurve_33, partSurface_36, partCurve_34, partSurface_37, partCurve_35, partSurface_38, partCurve_36, partSurface_39, partCurve_37, partSurface_40, partCurve_38, partSurface_41, partCurve_39, partSurface_42, partCurve_40, partSurface_43, partCurve_41, partSurface_44, partCurve_42, partSurface_45, partCurve_43, partSurface_46, partCurve_44, partSurface_47, partCurve_45, partSurface_48, partCurve_46, partSurface_49, partCurve_47, partSurface_50, partCurve_48, partSurface_51, partCurve_49, partSurface_52, partCurve_50, partSurface_53, partCurve_51, partSurface_54, partCurve_52, partSurface_55, partCurve_53, partSurface_56, partCurve_54, partSurface_57, partCurve_55, partSurface_58, partCurve_56, partSurface_59, partCurve_57, partSurface_60, partCurve_58, partSurface_61, partCurve_59, partSurface_62, partCurve_60, partSurface_63, partCurve_61, partSurface_64, partCurve_62, partSurface_65, partCurve_63, partSurface_66, partCurve_64, partSurface_67, partCurve_65, partSurface_68, partCurve_66, partSurface_69, partCurve_67, partSurface_70, partCurve_68, partSurface_71, partCurve_69, partSurface_72, partCurve_70, partSurface_73, partCurve_71);
  }

  private void execute8() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Scene scene_1 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 2");

    CurrentView currentView_0 = 
      scene_1.getCurrentView();

    currentView_0.setInput(new DoubleVector(new double[] {0.7224706124270631, -0.6223833438541261, 0.11926282669764582}), new DoubleVector(new double[] {3.3677339985877337, 2.9875984735139136, 2.416921082139277}), new DoubleVector(new double[] {-0.22018121183760597, -0.40381533774837863, 0.8879489889362683}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.2978197181787907, -1.2953027119329408, -0.26067124932219254}), new DoubleVector(new double[] {1.6430147305587541, 1.3533473646982184, 1.42512469709192}), new DoubleVector(new double[] {-0.22018121183760597, -0.40381533774837863, 0.8879489889362683}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.130555667466011, -1.0658278918481525, -0.11032576704886526}), new DoubleVector(new double[] {1.3840114305028897, 1.1829632203819131, 1.9658135187114054}), new DoubleVector(new double[] {-0.3063262382818046, -0.5261101282700376, 0.7933299242256393}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.15018856947512116, -0.0010171664529995406, 0.44282530225238526}), new DoubleVector(new double[] {0.41118326300529995, 0.3865011864393645, 0.8005917804359042}), new DoubleVector(new double[] {-0.3063262382818046, -0.5261101282700376, 0.7933299242256393}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.1561861977296897, 0.007844642848293434, 0.4509606096139962}), new DoubleVector(new double[] {0.4577815202251546, 0.3975745115920254, 0.7489240474640826}), new DoubleVector(new double[] {-0.254868913085727, -0.4550723089170248, 0.8532004634313577}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.2664436680526969, -0.19055169446138698, 0.5325172911402423}), new DoubleVector(new double[] {1.4614519111255573, 1.3536712128002688, 1.7131349526443767}), new DoubleVector(new double[] {-0.254868913085727, -0.4550723089170248, 0.8532004634313577}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.40308617024268134, -0.0720863165204304, 0.8385679996896387}), new DoubleVector(new double[] {2.4119601896417597, 2.5238365957617006, 2.823250666765389}), new DoubleVector(new double[] {-0.254868913085727, -0.4550723089170248, 0.8532004634313577}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.6793428405280779, -0.013618440091348855, 0.6748649717626095}), new DoubleVector(new double[] {2.636082100741205, 2.514934485526509, 2.6080406991749774}), new DoubleVector(new double[] {-0.254868913085727, -0.4550723089170248, 0.8532004634313577}), 1.5102818616783267, 0, 30.0);

    PartDisplayer partDisplayer_12 = 
      scene_1.getDisplayerManager().createPartDisplayer("Surface", -1, 1);

    partDisplayer_12.setPresentationName("susp1");

    partDisplayer_12.setColorMode(PartColorMode.PRESET);

    PartRepresentation partRepresentation_0 = 
      ((PartRepresentation) simulation_0.getRepresentationManager().getObject("Geometry"));

    partDisplayer_12.setRepresentation(partRepresentation_0);

    partDisplayer_12.getInputParts().setQuery(null);

    SolidModelCompositePart solidModelCompositePart_4 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("z_000_remaining-parts"));

    CompositePart compositePart_106 = 
      ((CompositePart) solidModelCompositePart_4.getChildParts().getPart("Suspension_Rear_Left"));

    CadPart cadPart_321 = 
      ((CadPart) compositePart_106.getChildParts().getPart("S_RL08_D"));

    PartSurface partSurface_343 = 
      ((PartSurface) cadPart_321.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_321 = 
      ((PartCurve) cadPart_321.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_107 = 
      ((CompositePart) solidModelCompositePart_4.getChildParts().getPart("Suspension_Rear_Right"));

    CadPart cadPart_330 = 
      ((CadPart) compositePart_107.getChildParts().getPart("S_RL08_D"));

    PartSurface partSurface_352 = 
      ((PartSurface) cadPart_330.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_330 = 
      ((PartCurve) cadPart_330.getPartCurveManager().getPartCurve("Edges"));

    partDisplayer_12.getInputParts().setObjects(partSurface_343, partCurve_321, partSurface_352, partCurve_330);

    currentView_0.setInput(new DoubleVector(new double[] {0.3522767915373415, -0.4443718666722293, 0.3452590737192756}), new DoubleVector(new double[] {3.0211656451714903, 2.442426927117552, 2.5330353525202582}), new DoubleVector(new double[] {-0.23903940095573523, -0.43638732872659564, 0.867425076947658}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.4853501072142037, -0.8237976644964673, -0.025390596770474172}), new DoubleVector(new double[] {0.5649395612063715, 0.312246252730671, 0.8355665087723201}), new DoubleVector(new double[] {-0.23903940095573523, -0.43638732872659564, 0.867425076947658}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.4654247990129658, -0.8022458994163627, -0.009048389168545773}), new DoubleVector(new double[] {0.5249804274394732, 0.2625791584313326, 0.941281492465131}), new DoubleVector(new double[] {-0.2802468718528778, -0.48082789785373303, 0.8308226185307552}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.28474954027154253, -0.8467913489812671, 0.20638616738035198}), new DoubleVector(new double[] {1.620997832484058, 1.2021553874029292, 2.0350201717279566}), new DoubleVector(new double[] {-0.2802468718528778, -0.48082789785373303, 0.8308226185307552}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.1419807493673907, -0.3899923142542848, 0.6129564508571141}), new DoubleVector(new double[] {2.2216883160248777, 0.9913351626296976, 1.3698604901817577}), new DoubleVector(new double[] {-0.11305536695008248, -0.3411318441219704, 0.9331921286261439}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.9680259064999674, -1.1366183086680146, 0.20465825422240255}), new DoubleVector(new double[] {1.7751841586586017, 1.3051915434690338, 1.4884965816980307}), new DoubleVector(new double[] {-0.12371791375579144, -0.34934454210438903, 0.9287907561543982}), 1.5102818616783267, 0, 30.0);

    partDisplayer_12.getInputParts().setQuery(null);

    CadPart cadPart_338 = 
      ((CadPart) compositePart_106.getChildParts().getPart("Body 1"));

    PartSurface partSurface_490 = 
      ((PartSurface) cadPart_338.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_471 = 
      ((PartCurve) cadPart_338.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_339 = 
      ((CadPart) compositePart_106.getChildParts().getPart("Body 93"));

    PartSurface partSurface_491 = 
      ((PartSurface) cadPart_339.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_472 = 
      ((PartCurve) cadPart_339.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_340 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body"));

    PartSurface partSurface_492 = 
      ((PartSurface) cadPart_340.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_473 = 
      ((PartCurve) cadPart_340.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_341 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 2"));

    PartSurface partSurface_493 = 
      ((PartSurface) cadPart_341.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_474 = 
      ((PartCurve) cadPart_341.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_342 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 3"));

    PartSurface partSurface_494 = 
      ((PartSurface) cadPart_342.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_475 = 
      ((PartCurve) cadPart_342.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_343 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 4"));

    PartSurface partSurface_495 = 
      ((PartSurface) cadPart_343.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_476 = 
      ((PartCurve) cadPart_343.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_344 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 5"));

    PartSurface partSurface_496 = 
      ((PartSurface) cadPart_344.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_477 = 
      ((PartCurve) cadPart_344.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_345 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 6"));

    PartSurface partSurface_497 = 
      ((PartSurface) cadPart_345.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_478 = 
      ((PartCurve) cadPart_345.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_346 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 7"));

    PartSurface partSurface_498 = 
      ((PartSurface) cadPart_346.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_479 = 
      ((PartCurve) cadPart_346.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_347 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 8"));

    PartSurface partSurface_499 = 
      ((PartSurface) cadPart_347.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_480 = 
      ((PartCurve) cadPart_347.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_348 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 9"));

    PartSurface partSurface_500 = 
      ((PartSurface) cadPart_348.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_481 = 
      ((PartCurve) cadPart_348.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_349 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 10"));

    PartSurface partSurface_501 = 
      ((PartSurface) cadPart_349.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_482 = 
      ((PartCurve) cadPart_349.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_350 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 11"));

    PartSurface partSurface_502 = 
      ((PartSurface) cadPart_350.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_483 = 
      ((PartCurve) cadPart_350.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_351 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 12"));

    PartSurface partSurface_503 = 
      ((PartSurface) cadPart_351.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_484 = 
      ((PartCurve) cadPart_351.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_352 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 13"));

    PartSurface partSurface_504 = 
      ((PartSurface) cadPart_352.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_485 = 
      ((PartCurve) cadPart_352.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_353 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 14"));

    PartSurface partSurface_505 = 
      ((PartSurface) cadPart_353.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_486 = 
      ((PartCurve) cadPart_353.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_354 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 15"));

    PartSurface partSurface_506 = 
      ((PartSurface) cadPart_354.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_487 = 
      ((PartCurve) cadPart_354.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_355 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 16"));

    PartSurface partSurface_507 = 
      ((PartSurface) cadPart_355.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_488 = 
      ((PartCurve) cadPart_355.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_356 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 17"));

    PartSurface partSurface_508 = 
      ((PartSurface) cadPart_356.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_489 = 
      ((PartCurve) cadPart_356.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_357 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 18"));

    PartSurface partSurface_509 = 
      ((PartSurface) cadPart_357.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_490 = 
      ((PartCurve) cadPart_357.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_358 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 19"));

    PartSurface partSurface_510 = 
      ((PartSurface) cadPart_358.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_491 = 
      ((PartCurve) cadPart_358.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_359 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 20"));

    PartSurface partSurface_511 = 
      ((PartSurface) cadPart_359.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_492 = 
      ((PartCurve) cadPart_359.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_360 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 21"));

    PartSurface partSurface_512 = 
      ((PartSurface) cadPart_360.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_493 = 
      ((PartCurve) cadPart_360.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_361 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 22"));

    PartSurface partSurface_513 = 
      ((PartSurface) cadPart_361.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_494 = 
      ((PartCurve) cadPart_361.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_362 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 23"));

    PartSurface partSurface_514 = 
      ((PartSurface) cadPart_362.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_495 = 
      ((PartCurve) cadPart_362.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_363 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 24"));

    PartSurface partSurface_515 = 
      ((PartSurface) cadPart_363.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_496 = 
      ((PartCurve) cadPart_363.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_364 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 25"));

    PartSurface partSurface_516 = 
      ((PartSurface) cadPart_364.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_497 = 
      ((PartCurve) cadPart_364.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_365 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 26"));

    PartSurface partSurface_517 = 
      ((PartSurface) cadPart_365.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_498 = 
      ((PartCurve) cadPart_365.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_366 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 26 copy"));

    PartSurface partSurface_518 = 
      ((PartSurface) cadPart_366.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_499 = 
      ((PartCurve) cadPart_366.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_367 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 27"));

    PartSurface partSurface_519 = 
      ((PartSurface) cadPart_367.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_500 = 
      ((PartCurve) cadPart_367.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_368 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 28"));

    PartSurface partSurface_520 = 
      ((PartSurface) cadPart_368.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_501 = 
      ((PartCurve) cadPart_368.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_369 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 29"));

    PartSurface partSurface_521 = 
      ((PartSurface) cadPart_369.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_502 = 
      ((PartCurve) cadPart_369.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_370 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 30"));

    PartSurface partSurface_522 = 
      ((PartSurface) cadPart_370.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_503 = 
      ((PartCurve) cadPart_370.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_371 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 31"));

    PartSurface partSurface_523 = 
      ((PartSurface) cadPart_371.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_504 = 
      ((PartCurve) cadPart_371.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_372 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 32"));

    PartSurface partSurface_524 = 
      ((PartSurface) cadPart_372.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_505 = 
      ((PartCurve) cadPart_372.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_373 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 33"));

    PartSurface partSurface_525 = 
      ((PartSurface) cadPart_373.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_506 = 
      ((PartCurve) cadPart_373.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_374 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 34"));

    PartSurface partSurface_526 = 
      ((PartSurface) cadPart_374.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_507 = 
      ((PartCurve) cadPart_374.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_375 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 35"));

    PartSurface partSurface_527 = 
      ((PartSurface) cadPart_375.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_508 = 
      ((PartCurve) cadPart_375.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_376 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 36"));

    PartSurface partSurface_528 = 
      ((PartSurface) cadPart_376.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_509 = 
      ((PartCurve) cadPart_376.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_377 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 37"));

    PartSurface partSurface_529 = 
      ((PartSurface) cadPart_377.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_510 = 
      ((PartCurve) cadPart_377.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_378 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 38"));

    PartSurface partSurface_530 = 
      ((PartSurface) cadPart_378.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_511 = 
      ((PartCurve) cadPart_378.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_379 = 
      ((CadPart) compositePart_106.getChildParts().getPart("DE    54825"));

    PartSurface partSurface_531 = 
      ((PartSurface) cadPart_379.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_512 = 
      ((PartCurve) cadPart_379.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_380 = 
      ((CadPart) compositePart_106.getChildParts().getPart("DE    82055"));

    PartSurface partSurface_532 = 
      ((PartSurface) cadPart_380.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_513 = 
      ((PartCurve) cadPart_380.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_381 = 
      ((CadPart) compositePart_106.getChildParts().getPart("DE    82073"));

    PartSurface partSurface_533 = 
      ((PartSurface) cadPart_381.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_514 = 
      ((PartCurve) cadPart_381.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_382 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 3"));

    PartSurface partSurface_534 = 
      ((PartSurface) cadPart_382.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_515 = 
      ((PartCurve) cadPart_382.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_383 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 4"));

    PartSurface partSurface_535 = 
      ((PartSurface) cadPart_383.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_516 = 
      ((PartCurve) cadPart_383.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_384 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 5"));

    PartSurface partSurface_536 = 
      ((PartSurface) cadPart_384.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_517 = 
      ((PartCurve) cadPart_384.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_385 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 6"));

    PartSurface partSurface_537 = 
      ((PartSurface) cadPart_385.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_518 = 
      ((PartCurve) cadPart_385.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_386 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 7"));

    PartSurface partSurface_538 = 
      ((PartSurface) cadPart_386.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_519 = 
      ((PartCurve) cadPart_386.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_387 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 8"));

    PartSurface partSurface_539 = 
      ((PartSurface) cadPart_387.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_520 = 
      ((PartCurve) cadPart_387.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_388 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 9"));

    PartSurface partSurface_540 = 
      ((PartSurface) cadPart_388.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_521 = 
      ((PartCurve) cadPart_388.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_389 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 10"));

    PartSurface partSurface_541 = 
      ((PartSurface) cadPart_389.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_522 = 
      ((PartCurve) cadPart_389.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_390 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 11"));

    PartSurface partSurface_542 = 
      ((PartSurface) cadPart_390.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_523 = 
      ((PartCurve) cadPart_390.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_391 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 12"));

    PartSurface partSurface_543 = 
      ((PartSurface) cadPart_391.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_524 = 
      ((PartCurve) cadPart_391.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_392 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 13"));

    PartSurface partSurface_544 = 
      ((PartSurface) cadPart_392.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_525 = 
      ((PartCurve) cadPart_392.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_393 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 14"));

    PartSurface partSurface_545 = 
      ((PartSurface) cadPart_393.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_526 = 
      ((PartCurve) cadPart_393.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_394 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 15"));

    PartSurface partSurface_546 = 
      ((PartSurface) cadPart_394.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_527 = 
      ((PartCurve) cadPart_394.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_395 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 16"));

    PartSurface partSurface_547 = 
      ((PartSurface) cadPart_395.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_528 = 
      ((PartCurve) cadPart_395.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_396 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 17"));

    PartSurface partSurface_548 = 
      ((PartSurface) cadPart_396.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_529 = 
      ((PartCurve) cadPart_396.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_397 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 18"));

    PartSurface partSurface_549 = 
      ((PartSurface) cadPart_397.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_530 = 
      ((PartCurve) cadPart_397.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_398 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 19"));

    PartSurface partSurface_550 = 
      ((PartSurface) cadPart_398.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_531 = 
      ((PartCurve) cadPart_398.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_399 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 20"));

    PartSurface partSurface_551 = 
      ((PartSurface) cadPart_399.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_532 = 
      ((PartCurve) cadPart_399.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_400 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 21"));

    PartSurface partSurface_552 = 
      ((PartSurface) cadPart_400.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_533 = 
      ((PartCurve) cadPart_400.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_401 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 22"));

    PartSurface partSurface_553 = 
      ((PartSurface) cadPart_401.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_534 = 
      ((PartCurve) cadPart_401.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_402 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 23"));

    PartSurface partSurface_554 = 
      ((PartSurface) cadPart_402.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_535 = 
      ((PartCurve) cadPart_402.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_403 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 24"));

    PartSurface partSurface_555 = 
      ((PartSurface) cadPart_403.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_536 = 
      ((PartCurve) cadPart_403.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_404 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 25"));

    PartSurface partSurface_556 = 
      ((PartSurface) cadPart_404.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_537 = 
      ((PartCurve) cadPart_404.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_405 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 27"));

    PartSurface partSurface_557 = 
      ((PartSurface) cadPart_405.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_538 = 
      ((PartCurve) cadPart_405.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_406 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 28"));

    PartSurface partSurface_558 = 
      ((PartSurface) cadPart_406.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_539 = 
      ((PartCurve) cadPart_406.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_407 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 29"));

    PartSurface partSurface_559 = 
      ((PartSurface) cadPart_407.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_540 = 
      ((PartCurve) cadPart_407.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_408 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 30"));

    PartSurface partSurface_560 = 
      ((PartSurface) cadPart_408.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_541 = 
      ((PartCurve) cadPart_408.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_409 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 31"));

    PartSurface partSurface_561 = 
      ((PartSurface) cadPart_409.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_542 = 
      ((PartCurve) cadPart_409.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_410 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 32"));

    PartSurface partSurface_562 = 
      ((PartSurface) cadPart_410.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_543 = 
      ((PartCurve) cadPart_410.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_411 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 33"));

    PartSurface partSurface_563 = 
      ((PartSurface) cadPart_411.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_544 = 
      ((PartCurve) cadPart_411.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_412 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 34"));

    PartSurface partSurface_564 = 
      ((PartSurface) cadPart_412.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_545 = 
      ((PartCurve) cadPart_412.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_413 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 35"));

    PartSurface partSurface_565 = 
      ((PartSurface) cadPart_413.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_546 = 
      ((PartCurve) cadPart_413.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_414 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 36"));

    PartSurface partSurface_566 = 
      ((PartSurface) cadPart_414.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_547 = 
      ((PartCurve) cadPart_414.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_415 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 37"));

    PartSurface partSurface_567 = 
      ((PartSurface) cadPart_415.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_548 = 
      ((PartCurve) cadPart_415.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_416 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 38"));

    PartSurface partSurface_568 = 
      ((PartSurface) cadPart_416.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_549 = 
      ((PartCurve) cadPart_416.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_417 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 39"));

    PartSurface partSurface_569 = 
      ((PartSurface) cadPart_417.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_550 = 
      ((PartCurve) cadPart_417.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_418 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 40"));

    PartSurface partSurface_570 = 
      ((PartSurface) cadPart_418.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_551 = 
      ((PartCurve) cadPart_418.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_419 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 41"));

    PartSurface partSurface_571 = 
      ((PartSurface) cadPart_419.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_552 = 
      ((PartCurve) cadPart_419.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_420 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 42"));

    PartSurface partSurface_572 = 
      ((PartSurface) cadPart_420.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_553 = 
      ((PartCurve) cadPart_420.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_421 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 43"));

    PartSurface partSurface_573 = 
      ((PartSurface) cadPart_421.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_554 = 
      ((PartCurve) cadPart_421.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_422 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 44"));

    PartSurface partSurface_574 = 
      ((PartSurface) cadPart_422.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_555 = 
      ((PartCurve) cadPart_422.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_423 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 45"));

    PartSurface partSurface_575 = 
      ((PartSurface) cadPart_423.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_556 = 
      ((PartCurve) cadPart_423.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_424 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 46"));

    PartSurface partSurface_576 = 
      ((PartSurface) cadPart_424.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_557 = 
      ((PartCurve) cadPart_424.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_425 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 47"));

    PartSurface partSurface_577 = 
      ((PartSurface) cadPart_425.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_558 = 
      ((PartCurve) cadPart_425.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_426 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 48"));

    PartSurface partSurface_578 = 
      ((PartSurface) cadPart_426.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_559 = 
      ((PartCurve) cadPart_426.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_427 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 49"));

    PartSurface partSurface_579 = 
      ((PartSurface) cadPart_427.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_560 = 
      ((PartCurve) cadPart_427.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_428 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 50"));

    PartSurface partSurface_580 = 
      ((PartSurface) cadPart_428.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_561 = 
      ((PartCurve) cadPart_428.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_429 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 51"));

    PartSurface partSurface_581 = 
      ((PartSurface) cadPart_429.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_562 = 
      ((PartCurve) cadPart_429.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_430 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 52"));

    PartSurface partSurface_582 = 
      ((PartSurface) cadPart_430.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_563 = 
      ((PartCurve) cadPart_430.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_431 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 53"));

    PartSurface partSurface_583 = 
      ((PartSurface) cadPart_431.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_564 = 
      ((PartCurve) cadPart_431.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_432 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 54"));

    PartSurface partSurface_584 = 
      ((PartSurface) cadPart_432.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_565 = 
      ((PartCurve) cadPart_432.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_433 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 55"));

    PartSurface partSurface_585 = 
      ((PartSurface) cadPart_433.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_566 = 
      ((PartCurve) cadPart_433.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_434 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 56"));

    PartSurface partSurface_586 = 
      ((PartSurface) cadPart_434.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_567 = 
      ((PartCurve) cadPart_434.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_435 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 57"));

    PartSurface partSurface_587 = 
      ((PartSurface) cadPart_435.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_568 = 
      ((PartCurve) cadPart_435.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_436 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 58"));

    PartSurface partSurface_588 = 
      ((PartSurface) cadPart_436.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_569 = 
      ((PartCurve) cadPart_436.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_437 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 59"));

    PartSurface partSurface_589 = 
      ((PartSurface) cadPart_437.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_570 = 
      ((PartCurve) cadPart_437.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_438 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 61"));

    PartSurface partSurface_590 = 
      ((PartSurface) cadPart_438.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_571 = 
      ((PartCurve) cadPart_438.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_439 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 64"));

    PartSurface partSurface_591 = 
      ((PartSurface) cadPart_439.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_572 = 
      ((PartCurve) cadPart_439.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_440 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 65"));

    PartSurface partSurface_592 = 
      ((PartSurface) cadPart_440.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_573 = 
      ((PartCurve) cadPart_440.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_441 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 66"));

    PartSurface partSurface_593 = 
      ((PartSurface) cadPart_441.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_574 = 
      ((PartCurve) cadPart_441.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_442 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 67"));

    PartSurface partSurface_594 = 
      ((PartSurface) cadPart_442.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_575 = 
      ((PartCurve) cadPart_442.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_443 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 68"));

    PartSurface partSurface_595 = 
      ((PartSurface) cadPart_443.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_576 = 
      ((PartCurve) cadPart_443.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_444 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 69"));

    PartSurface partSurface_596 = 
      ((PartSurface) cadPart_444.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_577 = 
      ((PartCurve) cadPart_444.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_445 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 70"));

    PartSurface partSurface_597 = 
      ((PartSurface) cadPart_445.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_578 = 
      ((PartCurve) cadPart_445.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_446 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 71"));

    PartSurface partSurface_598 = 
      ((PartSurface) cadPart_446.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_579 = 
      ((PartCurve) cadPart_446.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_447 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 72"));

    PartSurface partSurface_599 = 
      ((PartSurface) cadPart_447.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_580 = 
      ((PartCurve) cadPart_447.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_448 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 73"));

    PartSurface partSurface_600 = 
      ((PartSurface) cadPart_448.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_581 = 
      ((PartCurve) cadPart_448.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_449 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 74"));

    PartSurface partSurface_601 = 
      ((PartSurface) cadPart_449.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_582 = 
      ((PartCurve) cadPart_449.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_450 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 75"));

    PartSurface partSurface_602 = 
      ((PartSurface) cadPart_450.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_583 = 
      ((PartCurve) cadPart_450.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_451 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 76"));

    PartSurface partSurface_603 = 
      ((PartSurface) cadPart_451.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_584 = 
      ((PartCurve) cadPart_451.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_452 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 77"));

    PartSurface partSurface_604 = 
      ((PartSurface) cadPart_452.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_585 = 
      ((PartCurve) cadPart_452.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_453 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 78"));

    PartSurface partSurface_605 = 
      ((PartSurface) cadPart_453.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_586 = 
      ((PartCurve) cadPart_453.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_454 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 79"));

    PartSurface partSurface_606 = 
      ((PartSurface) cadPart_454.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_587 = 
      ((PartCurve) cadPart_454.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_455 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 80"));

    PartSurface partSurface_607 = 
      ((PartSurface) cadPart_455.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_588 = 
      ((PartCurve) cadPart_455.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_456 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 81"));

    PartSurface partSurface_608 = 
      ((PartSurface) cadPart_456.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_589 = 
      ((PartCurve) cadPart_456.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_457 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 82"));

    PartSurface partSurface_609 = 
      ((PartSurface) cadPart_457.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_590 = 
      ((PartCurve) cadPart_457.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_458 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 83"));

    PartSurface partSurface_610 = 
      ((PartSurface) cadPart_458.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_591 = 
      ((PartCurve) cadPart_458.getPartCurveManager().getPartCurve("Edges"));

    partDisplayer_12.getInputParts().setObjects(partSurface_490, partCurve_471, partSurface_491, partCurve_472, partSurface_492, partCurve_473, partSurface_493, partCurve_474, partSurface_494, partCurve_475, partSurface_495, partCurve_476, partSurface_496, partCurve_477, partSurface_497, partCurve_478, partSurface_498, partCurve_479, partSurface_499, partCurve_480, partSurface_500, partCurve_481, partSurface_501, partCurve_482, partSurface_502, partCurve_483, partSurface_503, partCurve_484, partSurface_504, partCurve_485, partSurface_505, partCurve_486, partSurface_506, partCurve_487, partSurface_507, partCurve_488, partSurface_508, partCurve_489, partSurface_509, partCurve_490, partSurface_510, partCurve_491, partSurface_511, partCurve_492, partSurface_512, partCurve_493, partSurface_513, partCurve_494, partSurface_514, partCurve_495, partSurface_515, partCurve_496, partSurface_516, partCurve_497, partSurface_517, partCurve_498, partSurface_518, partCurve_499, partSurface_519, partCurve_500, partSurface_520, partCurve_501, partSurface_521, partCurve_502, partSurface_522, partCurve_503, partSurface_523, partCurve_504, partSurface_524, partCurve_505, partSurface_525, partCurve_506, partSurface_526, partCurve_507, partSurface_527, partCurve_508, partSurface_528, partCurve_509, partSurface_529, partCurve_510, partSurface_530, partCurve_511, partSurface_531, partCurve_512, partSurface_532, partCurve_513, partSurface_533, partCurve_514, partSurface_534, partCurve_515, partSurface_535, partCurve_516, partSurface_536, partCurve_517, partSurface_537, partCurve_518, partSurface_538, partCurve_519, partSurface_539, partCurve_520, partSurface_540, partCurve_521, partSurface_541, partCurve_522, partSurface_542, partCurve_523, partSurface_543, partCurve_524, partSurface_544, partCurve_525, partSurface_545, partCurve_526, partSurface_546, partCurve_527, partSurface_547, partCurve_528, partSurface_548, partCurve_529, partSurface_549, partCurve_530, partSurface_550, partCurve_531, partSurface_551, partCurve_532, partSurface_552, partCurve_533, partSurface_553, partCurve_534, partSurface_554, partCurve_535, partSurface_555, partCurve_536, partSurface_556, partCurve_537, partSurface_557, partCurve_538, partSurface_558, partCurve_539, partSurface_559, partCurve_540, partSurface_560, partCurve_541, partSurface_561, partCurve_542, partSurface_562, partCurve_543, partSurface_563, partCurve_544, partSurface_564, partCurve_545, partSurface_565, partCurve_546, partSurface_566, partCurve_547, partSurface_567, partCurve_548, partSurface_568, partCurve_549, partSurface_569, partCurve_550, partSurface_570, partCurve_551, partSurface_571, partCurve_552, partSurface_572, partCurve_553, partSurface_573, partCurve_554, partSurface_574, partCurve_555, partSurface_575, partCurve_556, partSurface_576, partCurve_557, partSurface_577, partCurve_558, partSurface_578, partCurve_559, partSurface_579, partCurve_560, partSurface_580, partCurve_561, partSurface_581, partCurve_562, partSurface_582, partCurve_563, partSurface_583, partCurve_564, partSurface_584, partCurve_565, partSurface_585, partCurve_566, partSurface_586, partCurve_567, partSurface_587, partCurve_568, partSurface_588, partCurve_569, partSurface_589, partCurve_570, partSurface_590, partCurve_571, partSurface_591, partCurve_572, partSurface_592, partCurve_573, partSurface_593, partCurve_574, partSurface_594, partCurve_575, partSurface_595, partCurve_576, partSurface_596, partCurve_577, partSurface_597, partCurve_578, partSurface_598, partCurve_579, partSurface_599, partCurve_580, partSurface_600, partCurve_581, partSurface_601, partCurve_582, partSurface_602, partCurve_583, partSurface_603, partCurve_584, partSurface_604, partCurve_585, partSurface_605, partCurve_586, partSurface_606, partCurve_587, partSurface_607, partCurve_588, partSurface_608, partCurve_589, partSurface_609, partCurve_590, partSurface_610, partCurve_591, partSurface_352, partCurve_330);
  }

  private void execute9() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Scene scene_1 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 2");

    CurrentView currentView_0 = 
      scene_1.getCurrentView();

    currentView_0.setInput(new DoubleVector(new double[] {0.34473444886476445, 0.032022574785271686, 0.8189989239202762}), new DoubleVector(new double[] {1.8318686237205741, 1.1826250167294619, 1.5733171471904126}), new DoubleVector(new double[] {-0.16450678845791808, -0.38322974036555985, 0.908885296751292}), 1.5102818616783267, 0, 30.0);

    PartDisplayer partDisplayer_12 = 
      ((PartDisplayer) scene_1.getDisplayerManager().getObject("susp1"));

    partDisplayer_12.getInputParts().setQuery(null);

    SolidModelCompositePart solidModelCompositePart_4 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("z_000_remaining-parts"));

    CompositePart compositePart_106 = 
      ((CompositePart) solidModelCompositePart_4.getChildParts().getPart("Suspension_Rear_Left"));

    CadPart cadPart_338 = 
      ((CadPart) compositePart_106.getChildParts().getPart("Body 1"));

    PartSurface partSurface_490 = 
      ((PartSurface) cadPart_338.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_471 = 
      ((PartCurve) cadPart_338.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_339 = 
      ((CadPart) compositePart_106.getChildParts().getPart("Body 93"));

    PartSurface partSurface_491 = 
      ((PartSurface) cadPart_339.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_472 = 
      ((PartCurve) cadPart_339.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_340 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body"));

    PartSurface partSurface_492 = 
      ((PartSurface) cadPart_340.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_473 = 
      ((PartCurve) cadPart_340.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_341 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 2"));

    PartSurface partSurface_493 = 
      ((PartSurface) cadPart_341.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_474 = 
      ((PartCurve) cadPart_341.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_342 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 3"));

    PartSurface partSurface_494 = 
      ((PartSurface) cadPart_342.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_475 = 
      ((PartCurve) cadPart_342.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_343 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 4"));

    PartSurface partSurface_495 = 
      ((PartSurface) cadPart_343.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_476 = 
      ((PartCurve) cadPart_343.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_344 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 5"));

    PartSurface partSurface_496 = 
      ((PartSurface) cadPart_344.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_477 = 
      ((PartCurve) cadPart_344.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_345 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 6"));

    PartSurface partSurface_497 = 
      ((PartSurface) cadPart_345.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_478 = 
      ((PartCurve) cadPart_345.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_346 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 7"));

    PartSurface partSurface_498 = 
      ((PartSurface) cadPart_346.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_479 = 
      ((PartCurve) cadPart_346.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_347 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 8"));

    PartSurface partSurface_499 = 
      ((PartSurface) cadPart_347.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_480 = 
      ((PartCurve) cadPart_347.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_348 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 9"));

    PartSurface partSurface_500 = 
      ((PartSurface) cadPart_348.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_481 = 
      ((PartCurve) cadPart_348.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_349 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 10"));

    PartSurface partSurface_501 = 
      ((PartSurface) cadPart_349.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_482 = 
      ((PartCurve) cadPart_349.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_350 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 11"));

    PartSurface partSurface_502 = 
      ((PartSurface) cadPart_350.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_483 = 
      ((PartCurve) cadPart_350.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_351 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 12"));

    PartSurface partSurface_503 = 
      ((PartSurface) cadPart_351.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_484 = 
      ((PartCurve) cadPart_351.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_352 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 13"));

    PartSurface partSurface_504 = 
      ((PartSurface) cadPart_352.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_485 = 
      ((PartCurve) cadPart_352.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_353 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 14"));

    PartSurface partSurface_505 = 
      ((PartSurface) cadPart_353.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_486 = 
      ((PartCurve) cadPart_353.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_354 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 15"));

    PartSurface partSurface_506 = 
      ((PartSurface) cadPart_354.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_487 = 
      ((PartCurve) cadPart_354.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_355 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 16"));

    PartSurface partSurface_507 = 
      ((PartSurface) cadPart_355.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_488 = 
      ((PartCurve) cadPart_355.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_356 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 17"));

    PartSurface partSurface_508 = 
      ((PartSurface) cadPart_356.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_489 = 
      ((PartCurve) cadPart_356.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_357 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 18"));

    PartSurface partSurface_509 = 
      ((PartSurface) cadPart_357.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_490 = 
      ((PartCurve) cadPart_357.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_358 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 19"));

    PartSurface partSurface_510 = 
      ((PartSurface) cadPart_358.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_491 = 
      ((PartCurve) cadPart_358.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_359 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 20"));

    PartSurface partSurface_511 = 
      ((PartSurface) cadPart_359.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_492 = 
      ((PartCurve) cadPart_359.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_360 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 21"));

    PartSurface partSurface_512 = 
      ((PartSurface) cadPart_360.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_493 = 
      ((PartCurve) cadPart_360.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_361 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 22"));

    PartSurface partSurface_513 = 
      ((PartSurface) cadPart_361.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_494 = 
      ((PartCurve) cadPart_361.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_362 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 23"));

    PartSurface partSurface_514 = 
      ((PartSurface) cadPart_362.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_495 = 
      ((PartCurve) cadPart_362.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_363 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 24"));

    PartSurface partSurface_515 = 
      ((PartSurface) cadPart_363.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_496 = 
      ((PartCurve) cadPart_363.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_364 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 25"));

    PartSurface partSurface_516 = 
      ((PartSurface) cadPart_364.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_497 = 
      ((PartCurve) cadPart_364.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_365 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 26"));

    PartSurface partSurface_517 = 
      ((PartSurface) cadPart_365.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_498 = 
      ((PartCurve) cadPart_365.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_366 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 26 copy"));

    PartSurface partSurface_518 = 
      ((PartSurface) cadPart_366.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_499 = 
      ((PartCurve) cadPart_366.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_367 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 27"));

    PartSurface partSurface_519 = 
      ((PartSurface) cadPart_367.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_500 = 
      ((PartCurve) cadPart_367.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_368 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 28"));

    PartSurface partSurface_520 = 
      ((PartSurface) cadPart_368.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_501 = 
      ((PartCurve) cadPart_368.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_369 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 29"));

    PartSurface partSurface_521 = 
      ((PartSurface) cadPart_369.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_502 = 
      ((PartCurve) cadPart_369.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_370 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 30"));

    PartSurface partSurface_522 = 
      ((PartSurface) cadPart_370.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_503 = 
      ((PartCurve) cadPart_370.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_371 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 31"));

    PartSurface partSurface_523 = 
      ((PartSurface) cadPart_371.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_504 = 
      ((PartCurve) cadPart_371.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_372 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 32"));

    PartSurface partSurface_524 = 
      ((PartSurface) cadPart_372.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_505 = 
      ((PartCurve) cadPart_372.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_373 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 33"));

    PartSurface partSurface_525 = 
      ((PartSurface) cadPart_373.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_506 = 
      ((PartCurve) cadPart_373.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_374 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 34"));

    PartSurface partSurface_526 = 
      ((PartSurface) cadPart_374.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_507 = 
      ((PartCurve) cadPart_374.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_375 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 35"));

    PartSurface partSurface_527 = 
      ((PartSurface) cadPart_375.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_508 = 
      ((PartCurve) cadPart_375.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_376 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 36"));

    PartSurface partSurface_528 = 
      ((PartSurface) cadPart_376.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_509 = 
      ((PartCurve) cadPart_376.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_377 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 37"));

    PartSurface partSurface_529 = 
      ((PartSurface) cadPart_377.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_510 = 
      ((PartCurve) cadPart_377.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_378 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 38"));

    PartSurface partSurface_530 = 
      ((PartSurface) cadPart_378.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_511 = 
      ((PartCurve) cadPart_378.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_379 = 
      ((CadPart) compositePart_106.getChildParts().getPart("DE    54825"));

    PartSurface partSurface_531 = 
      ((PartSurface) cadPart_379.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_512 = 
      ((PartCurve) cadPart_379.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_380 = 
      ((CadPart) compositePart_106.getChildParts().getPart("DE    82055"));

    PartSurface partSurface_532 = 
      ((PartSurface) cadPart_380.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_513 = 
      ((PartCurve) cadPart_380.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_381 = 
      ((CadPart) compositePart_106.getChildParts().getPart("DE    82073"));

    PartSurface partSurface_533 = 
      ((PartSurface) cadPart_381.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_514 = 
      ((PartCurve) cadPart_381.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_382 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 3"));

    PartSurface partSurface_534 = 
      ((PartSurface) cadPart_382.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_515 = 
      ((PartCurve) cadPart_382.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_383 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 4"));

    PartSurface partSurface_535 = 
      ((PartSurface) cadPart_383.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_516 = 
      ((PartCurve) cadPart_383.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_384 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 5"));

    PartSurface partSurface_536 = 
      ((PartSurface) cadPart_384.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_517 = 
      ((PartCurve) cadPart_384.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_385 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 6"));

    PartSurface partSurface_537 = 
      ((PartSurface) cadPart_385.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_518 = 
      ((PartCurve) cadPart_385.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_386 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 7"));

    PartSurface partSurface_538 = 
      ((PartSurface) cadPart_386.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_519 = 
      ((PartCurve) cadPart_386.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_387 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 8"));

    PartSurface partSurface_539 = 
      ((PartSurface) cadPart_387.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_520 = 
      ((PartCurve) cadPart_387.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_388 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 9"));

    PartSurface partSurface_540 = 
      ((PartSurface) cadPart_388.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_521 = 
      ((PartCurve) cadPart_388.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_389 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 10"));

    PartSurface partSurface_541 = 
      ((PartSurface) cadPart_389.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_522 = 
      ((PartCurve) cadPart_389.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_390 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 11"));

    PartSurface partSurface_542 = 
      ((PartSurface) cadPart_390.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_523 = 
      ((PartCurve) cadPart_390.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_391 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 12"));

    PartSurface partSurface_543 = 
      ((PartSurface) cadPart_391.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_524 = 
      ((PartCurve) cadPart_391.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_392 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 13"));

    PartSurface partSurface_544 = 
      ((PartSurface) cadPart_392.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_525 = 
      ((PartCurve) cadPart_392.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_393 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 14"));

    PartSurface partSurface_545 = 
      ((PartSurface) cadPart_393.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_526 = 
      ((PartCurve) cadPart_393.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_394 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 15"));

    PartSurface partSurface_546 = 
      ((PartSurface) cadPart_394.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_527 = 
      ((PartCurve) cadPart_394.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_395 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 16"));

    PartSurface partSurface_547 = 
      ((PartSurface) cadPart_395.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_528 = 
      ((PartCurve) cadPart_395.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_396 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 17"));

    PartSurface partSurface_548 = 
      ((PartSurface) cadPart_396.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_529 = 
      ((PartCurve) cadPart_396.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_397 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 18"));

    PartSurface partSurface_549 = 
      ((PartSurface) cadPart_397.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_530 = 
      ((PartCurve) cadPart_397.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_398 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 19"));

    PartSurface partSurface_550 = 
      ((PartSurface) cadPart_398.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_531 = 
      ((PartCurve) cadPart_398.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_399 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 20"));

    PartSurface partSurface_551 = 
      ((PartSurface) cadPart_399.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_532 = 
      ((PartCurve) cadPart_399.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_400 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 21"));

    PartSurface partSurface_552 = 
      ((PartSurface) cadPart_400.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_533 = 
      ((PartCurve) cadPart_400.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_401 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 22"));

    PartSurface partSurface_553 = 
      ((PartSurface) cadPart_401.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_534 = 
      ((PartCurve) cadPart_401.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_402 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 23"));

    PartSurface partSurface_554 = 
      ((PartSurface) cadPart_402.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_535 = 
      ((PartCurve) cadPart_402.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_403 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 24"));

    PartSurface partSurface_555 = 
      ((PartSurface) cadPart_403.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_536 = 
      ((PartCurve) cadPart_403.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_404 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 25"));

    PartSurface partSurface_556 = 
      ((PartSurface) cadPart_404.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_537 = 
      ((PartCurve) cadPart_404.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_405 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 27"));

    PartSurface partSurface_557 = 
      ((PartSurface) cadPart_405.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_538 = 
      ((PartCurve) cadPart_405.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_406 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 28"));

    PartSurface partSurface_558 = 
      ((PartSurface) cadPart_406.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_539 = 
      ((PartCurve) cadPart_406.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_407 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 29"));

    PartSurface partSurface_559 = 
      ((PartSurface) cadPart_407.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_540 = 
      ((PartCurve) cadPart_407.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_408 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 30"));

    PartSurface partSurface_560 = 
      ((PartSurface) cadPart_408.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_541 = 
      ((PartCurve) cadPart_408.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_409 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 31"));

    PartSurface partSurface_561 = 
      ((PartSurface) cadPart_409.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_542 = 
      ((PartCurve) cadPart_409.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_410 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 32"));

    PartSurface partSurface_562 = 
      ((PartSurface) cadPart_410.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_543 = 
      ((PartCurve) cadPart_410.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_411 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 33"));

    PartSurface partSurface_563 = 
      ((PartSurface) cadPart_411.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_544 = 
      ((PartCurve) cadPart_411.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_412 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 34"));

    PartSurface partSurface_564 = 
      ((PartSurface) cadPart_412.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_545 = 
      ((PartCurve) cadPart_412.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_413 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 35"));

    PartSurface partSurface_565 = 
      ((PartSurface) cadPart_413.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_546 = 
      ((PartCurve) cadPart_413.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_414 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 36"));

    PartSurface partSurface_566 = 
      ((PartSurface) cadPart_414.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_547 = 
      ((PartCurve) cadPart_414.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_415 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 37"));

    PartSurface partSurface_567 = 
      ((PartSurface) cadPart_415.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_548 = 
      ((PartCurve) cadPart_415.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_416 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 38"));

    PartSurface partSurface_568 = 
      ((PartSurface) cadPart_416.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_549 = 
      ((PartCurve) cadPart_416.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_417 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 39"));

    PartSurface partSurface_569 = 
      ((PartSurface) cadPart_417.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_550 = 
      ((PartCurve) cadPart_417.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_418 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 40"));

    PartSurface partSurface_570 = 
      ((PartSurface) cadPart_418.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_551 = 
      ((PartCurve) cadPart_418.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_419 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 41"));

    PartSurface partSurface_571 = 
      ((PartSurface) cadPart_419.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_552 = 
      ((PartCurve) cadPart_419.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_420 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 42"));

    PartSurface partSurface_572 = 
      ((PartSurface) cadPart_420.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_553 = 
      ((PartCurve) cadPart_420.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_421 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 43"));

    PartSurface partSurface_573 = 
      ((PartSurface) cadPart_421.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_554 = 
      ((PartCurve) cadPart_421.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_422 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 44"));

    PartSurface partSurface_574 = 
      ((PartSurface) cadPart_422.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_555 = 
      ((PartCurve) cadPart_422.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_423 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 45"));

    PartSurface partSurface_575 = 
      ((PartSurface) cadPart_423.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_556 = 
      ((PartCurve) cadPart_423.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_424 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 46"));

    PartSurface partSurface_576 = 
      ((PartSurface) cadPart_424.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_557 = 
      ((PartCurve) cadPart_424.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_425 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 47"));

    PartSurface partSurface_577 = 
      ((PartSurface) cadPart_425.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_558 = 
      ((PartCurve) cadPart_425.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_426 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 48"));

    PartSurface partSurface_578 = 
      ((PartSurface) cadPart_426.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_559 = 
      ((PartCurve) cadPart_426.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_427 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 49"));

    PartSurface partSurface_579 = 
      ((PartSurface) cadPart_427.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_560 = 
      ((PartCurve) cadPart_427.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_428 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 50"));

    PartSurface partSurface_580 = 
      ((PartSurface) cadPart_428.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_561 = 
      ((PartCurve) cadPart_428.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_429 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 51"));

    PartSurface partSurface_581 = 
      ((PartSurface) cadPart_429.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_562 = 
      ((PartCurve) cadPart_429.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_430 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 52"));

    PartSurface partSurface_582 = 
      ((PartSurface) cadPart_430.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_563 = 
      ((PartCurve) cadPart_430.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_431 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 53"));

    PartSurface partSurface_583 = 
      ((PartSurface) cadPart_431.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_564 = 
      ((PartCurve) cadPart_431.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_432 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 54"));

    PartSurface partSurface_584 = 
      ((PartSurface) cadPart_432.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_565 = 
      ((PartCurve) cadPart_432.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_433 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 55"));

    PartSurface partSurface_585 = 
      ((PartSurface) cadPart_433.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_566 = 
      ((PartCurve) cadPart_433.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_434 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 56"));

    PartSurface partSurface_586 = 
      ((PartSurface) cadPart_434.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_567 = 
      ((PartCurve) cadPart_434.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_435 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 57"));

    PartSurface partSurface_587 = 
      ((PartSurface) cadPart_435.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_568 = 
      ((PartCurve) cadPart_435.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_436 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 58"));

    PartSurface partSurface_588 = 
      ((PartSurface) cadPart_436.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_569 = 
      ((PartCurve) cadPart_436.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_437 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 59"));

    PartSurface partSurface_589 = 
      ((PartSurface) cadPart_437.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_570 = 
      ((PartCurve) cadPart_437.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_438 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 61"));

    PartSurface partSurface_590 = 
      ((PartSurface) cadPart_438.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_571 = 
      ((PartCurve) cadPart_438.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_439 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 64"));

    PartSurface partSurface_591 = 
      ((PartSurface) cadPart_439.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_572 = 
      ((PartCurve) cadPart_439.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_440 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 65"));

    PartSurface partSurface_592 = 
      ((PartSurface) cadPart_440.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_573 = 
      ((PartCurve) cadPart_440.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_441 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 66"));

    PartSurface partSurface_593 = 
      ((PartSurface) cadPart_441.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_574 = 
      ((PartCurve) cadPart_441.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_442 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 67"));

    PartSurface partSurface_594 = 
      ((PartSurface) cadPart_442.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_575 = 
      ((PartCurve) cadPart_442.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_443 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 68"));

    PartSurface partSurface_595 = 
      ((PartSurface) cadPart_443.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_576 = 
      ((PartCurve) cadPart_443.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_444 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 69"));

    PartSurface partSurface_596 = 
      ((PartSurface) cadPart_444.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_577 = 
      ((PartCurve) cadPart_444.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_445 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 70"));

    PartSurface partSurface_597 = 
      ((PartSurface) cadPart_445.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_578 = 
      ((PartCurve) cadPart_445.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_446 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 71"));

    PartSurface partSurface_598 = 
      ((PartSurface) cadPart_446.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_579 = 
      ((PartCurve) cadPart_446.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_447 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 72"));

    PartSurface partSurface_599 = 
      ((PartSurface) cadPart_447.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_580 = 
      ((PartCurve) cadPart_447.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_448 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 73"));

    PartSurface partSurface_600 = 
      ((PartSurface) cadPart_448.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_581 = 
      ((PartCurve) cadPart_448.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_449 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 74"));

    PartSurface partSurface_601 = 
      ((PartSurface) cadPart_449.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_582 = 
      ((PartCurve) cadPart_449.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_450 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 75"));

    PartSurface partSurface_602 = 
      ((PartSurface) cadPart_450.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_583 = 
      ((PartCurve) cadPart_450.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_451 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 76"));

    PartSurface partSurface_603 = 
      ((PartSurface) cadPart_451.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_584 = 
      ((PartCurve) cadPart_451.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_452 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 77"));

    PartSurface partSurface_604 = 
      ((PartSurface) cadPart_452.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_585 = 
      ((PartCurve) cadPart_452.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_453 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 78"));

    PartSurface partSurface_605 = 
      ((PartSurface) cadPart_453.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_586 = 
      ((PartCurve) cadPart_453.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_454 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 79"));

    PartSurface partSurface_606 = 
      ((PartSurface) cadPart_454.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_587 = 
      ((PartCurve) cadPart_454.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_455 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 80"));

    PartSurface partSurface_607 = 
      ((PartSurface) cadPart_455.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_588 = 
      ((PartCurve) cadPart_455.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_456 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 81"));

    PartSurface partSurface_608 = 
      ((PartSurface) cadPart_456.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_589 = 
      ((PartCurve) cadPart_456.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_457 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 82"));

    PartSurface partSurface_609 = 
      ((PartSurface) cadPart_457.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_590 = 
      ((PartCurve) cadPart_457.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_458 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 83"));

    PartSurface partSurface_610 = 
      ((PartSurface) cadPart_458.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_591 = 
      ((PartCurve) cadPart_458.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_107 = 
      ((CompositePart) solidModelCompositePart_4.getChildParts().getPart("Suspension_Rear_Right"));

    CadPart cadPart_459 = 
      ((CadPart) compositePart_107.getChildParts().getPart("Body 1"));

    PartSurface partSurface_611 = 
      ((PartSurface) cadPart_459.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_592 = 
      ((PartCurve) cadPart_459.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_460 = 
      ((CadPart) compositePart_107.getChildParts().getPart("Body 93"));

    PartSurface partSurface_612 = 
      ((PartSurface) cadPart_460.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_593 = 
      ((PartCurve) cadPart_460.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_461 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body"));

    PartSurface partSurface_613 = 
      ((PartSurface) cadPart_461.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_594 = 
      ((PartCurve) cadPart_461.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_462 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 2"));

    PartSurface partSurface_614 = 
      ((PartSurface) cadPart_462.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_595 = 
      ((PartCurve) cadPart_462.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_463 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 3"));

    PartSurface partSurface_615 = 
      ((PartSurface) cadPart_463.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_596 = 
      ((PartCurve) cadPart_463.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_464 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 4"));

    PartSurface partSurface_616 = 
      ((PartSurface) cadPart_464.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_597 = 
      ((PartCurve) cadPart_464.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_465 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 5"));

    PartSurface partSurface_617 = 
      ((PartSurface) cadPart_465.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_598 = 
      ((PartCurve) cadPart_465.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_466 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 6"));

    PartSurface partSurface_618 = 
      ((PartSurface) cadPart_466.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_599 = 
      ((PartCurve) cadPart_466.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_467 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 7"));

    PartSurface partSurface_619 = 
      ((PartSurface) cadPart_467.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_600 = 
      ((PartCurve) cadPart_467.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_468 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 8"));

    PartSurface partSurface_620 = 
      ((PartSurface) cadPart_468.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_601 = 
      ((PartCurve) cadPart_468.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_469 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 9"));

    PartSurface partSurface_621 = 
      ((PartSurface) cadPart_469.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_602 = 
      ((PartCurve) cadPart_469.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_470 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 10"));

    PartSurface partSurface_622 = 
      ((PartSurface) cadPart_470.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_603 = 
      ((PartCurve) cadPart_470.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_471 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 11"));

    PartSurface partSurface_623 = 
      ((PartSurface) cadPart_471.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_604 = 
      ((PartCurve) cadPart_471.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_472 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 12"));

    PartSurface partSurface_624 = 
      ((PartSurface) cadPart_472.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_605 = 
      ((PartCurve) cadPart_472.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_473 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 13"));

    PartSurface partSurface_625 = 
      ((PartSurface) cadPart_473.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_606 = 
      ((PartCurve) cadPart_473.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_474 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 14"));

    PartSurface partSurface_626 = 
      ((PartSurface) cadPart_474.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_607 = 
      ((PartCurve) cadPart_474.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_475 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 15"));

    PartSurface partSurface_627 = 
      ((PartSurface) cadPart_475.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_608 = 
      ((PartCurve) cadPart_475.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_476 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 16"));

    PartSurface partSurface_628 = 
      ((PartSurface) cadPart_476.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_609 = 
      ((PartCurve) cadPart_476.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_477 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 17"));

    PartSurface partSurface_629 = 
      ((PartSurface) cadPart_477.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_610 = 
      ((PartCurve) cadPart_477.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_478 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 18"));

    PartSurface partSurface_630 = 
      ((PartSurface) cadPart_478.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_611 = 
      ((PartCurve) cadPart_478.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_479 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 19"));

    PartSurface partSurface_631 = 
      ((PartSurface) cadPart_479.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_612 = 
      ((PartCurve) cadPart_479.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_480 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 20"));

    PartSurface partSurface_632 = 
      ((PartSurface) cadPart_480.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_613 = 
      ((PartCurve) cadPart_480.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_481 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 21"));

    PartSurface partSurface_633 = 
      ((PartSurface) cadPart_481.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_614 = 
      ((PartCurve) cadPart_481.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_482 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 22"));

    PartSurface partSurface_634 = 
      ((PartSurface) cadPart_482.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_615 = 
      ((PartCurve) cadPart_482.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_483 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 23"));

    PartSurface partSurface_635 = 
      ((PartSurface) cadPart_483.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_616 = 
      ((PartCurve) cadPart_483.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_484 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 24"));

    PartSurface partSurface_636 = 
      ((PartSurface) cadPart_484.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_617 = 
      ((PartCurve) cadPart_484.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_485 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 25"));

    PartSurface partSurface_637 = 
      ((PartSurface) cadPart_485.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_618 = 
      ((PartCurve) cadPart_485.getPartCurveManager().getPartCurve("Edges"));

    SolidModelPart solidModelPart_123 = 
      ((SolidModelPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 26"));

    PartSurface partSurface_638 = 
      ((PartSurface) solidModelPart_123.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_619 = 
      ((PartCurve) solidModelPart_123.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_486 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 27"));

    PartSurface partSurface_639 = 
      ((PartSurface) cadPart_486.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_620 = 
      ((PartCurve) cadPart_486.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_487 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 28"));

    PartSurface partSurface_640 = 
      ((PartSurface) cadPart_487.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_621 = 
      ((PartCurve) cadPart_487.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_488 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 29"));

    PartSurface partSurface_641 = 
      ((PartSurface) cadPart_488.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_622 = 
      ((PartCurve) cadPart_488.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_489 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 30"));

    PartSurface partSurface_642 = 
      ((PartSurface) cadPart_489.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_623 = 
      ((PartCurve) cadPart_489.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_490 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 31"));

    PartSurface partSurface_643 = 
      ((PartSurface) cadPart_490.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_624 = 
      ((PartCurve) cadPart_490.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_491 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 32"));

    PartSurface partSurface_644 = 
      ((PartSurface) cadPart_491.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_625 = 
      ((PartCurve) cadPart_491.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_492 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 33"));

    PartSurface partSurface_645 = 
      ((PartSurface) cadPart_492.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_626 = 
      ((PartCurve) cadPart_492.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_493 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 34"));

    PartSurface partSurface_646 = 
      ((PartSurface) cadPart_493.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_627 = 
      ((PartCurve) cadPart_493.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_494 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 35"));

    PartSurface partSurface_647 = 
      ((PartSurface) cadPart_494.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_628 = 
      ((PartCurve) cadPart_494.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_495 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 36"));

    PartSurface partSurface_648 = 
      ((PartSurface) cadPart_495.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_629 = 
      ((PartCurve) cadPart_495.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_496 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 37"));

    PartSurface partSurface_649 = 
      ((PartSurface) cadPart_496.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_630 = 
      ((PartCurve) cadPart_496.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_497 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 38"));

    PartSurface partSurface_650 = 
      ((PartSurface) cadPart_497.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_631 = 
      ((PartCurve) cadPart_497.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_498 = 
      ((CadPart) compositePart_107.getChildParts().getPart("DE    54825"));

    PartSurface partSurface_651 = 
      ((PartSurface) cadPart_498.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_632 = 
      ((PartCurve) cadPart_498.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_499 = 
      ((CadPart) compositePart_107.getChildParts().getPart("DE    82055"));

    PartSurface partSurface_652 = 
      ((PartSurface) cadPart_499.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_633 = 
      ((PartCurve) cadPart_499.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_500 = 
      ((CadPart) compositePart_107.getChildParts().getPart("DE    82073"));

    PartSurface partSurface_653 = 
      ((PartSurface) cadPart_500.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_634 = 
      ((PartCurve) cadPart_500.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_501 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 3"));

    PartSurface partSurface_654 = 
      ((PartSurface) cadPart_501.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_635 = 
      ((PartCurve) cadPart_501.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_502 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 4"));

    PartSurface partSurface_655 = 
      ((PartSurface) cadPart_502.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_636 = 
      ((PartCurve) cadPart_502.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_503 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 5"));

    PartSurface partSurface_656 = 
      ((PartSurface) cadPart_503.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_637 = 
      ((PartCurve) cadPart_503.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_504 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 6"));

    PartSurface partSurface_657 = 
      ((PartSurface) cadPart_504.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_638 = 
      ((PartCurve) cadPart_504.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_505 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 7"));

    PartSurface partSurface_658 = 
      ((PartSurface) cadPart_505.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_639 = 
      ((PartCurve) cadPart_505.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_506 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 8"));

    PartSurface partSurface_659 = 
      ((PartSurface) cadPart_506.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_640 = 
      ((PartCurve) cadPart_506.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_507 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 9"));

    PartSurface partSurface_660 = 
      ((PartSurface) cadPart_507.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_641 = 
      ((PartCurve) cadPart_507.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_508 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 10"));

    PartSurface partSurface_661 = 
      ((PartSurface) cadPart_508.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_642 = 
      ((PartCurve) cadPart_508.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_509 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 11"));

    PartSurface partSurface_662 = 
      ((PartSurface) cadPart_509.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_643 = 
      ((PartCurve) cadPart_509.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_510 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 12"));

    PartSurface partSurface_663 = 
      ((PartSurface) cadPart_510.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_644 = 
      ((PartCurve) cadPart_510.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_511 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 13"));

    PartSurface partSurface_664 = 
      ((PartSurface) cadPart_511.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_645 = 
      ((PartCurve) cadPart_511.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_512 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 14"));

    PartSurface partSurface_665 = 
      ((PartSurface) cadPart_512.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_646 = 
      ((PartCurve) cadPart_512.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_513 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 15"));

    PartSurface partSurface_666 = 
      ((PartSurface) cadPart_513.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_647 = 
      ((PartCurve) cadPart_513.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_514 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 16"));

    PartSurface partSurface_667 = 
      ((PartSurface) cadPart_514.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_648 = 
      ((PartCurve) cadPart_514.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_515 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 17"));

    PartSurface partSurface_668 = 
      ((PartSurface) cadPart_515.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_649 = 
      ((PartCurve) cadPart_515.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_516 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 18"));

    PartSurface partSurface_669 = 
      ((PartSurface) cadPart_516.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_650 = 
      ((PartCurve) cadPart_516.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_517 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 19"));

    PartSurface partSurface_670 = 
      ((PartSurface) cadPart_517.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_651 = 
      ((PartCurve) cadPart_517.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_518 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 20"));

    PartSurface partSurface_671 = 
      ((PartSurface) cadPart_518.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_652 = 
      ((PartCurve) cadPart_518.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_519 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 21"));

    PartSurface partSurface_672 = 
      ((PartSurface) cadPart_519.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_653 = 
      ((PartCurve) cadPart_519.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_520 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 22"));

    PartSurface partSurface_673 = 
      ((PartSurface) cadPart_520.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_654 = 
      ((PartCurve) cadPart_520.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_521 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 23"));

    PartSurface partSurface_674 = 
      ((PartSurface) cadPart_521.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_655 = 
      ((PartCurve) cadPart_521.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_522 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 24"));

    PartSurface partSurface_675 = 
      ((PartSurface) cadPart_522.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_656 = 
      ((PartCurve) cadPart_522.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_523 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 25"));

    PartSurface partSurface_676 = 
      ((PartSurface) cadPart_523.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_657 = 
      ((PartCurve) cadPart_523.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_524 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 27"));

    PartSurface partSurface_677 = 
      ((PartSurface) cadPart_524.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_658 = 
      ((PartCurve) cadPart_524.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_525 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 28"));

    PartSurface partSurface_678 = 
      ((PartSurface) cadPart_525.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_659 = 
      ((PartCurve) cadPart_525.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_526 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 29"));

    PartSurface partSurface_679 = 
      ((PartSurface) cadPart_526.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_660 = 
      ((PartCurve) cadPart_526.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_527 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 30"));

    PartSurface partSurface_680 = 
      ((PartSurface) cadPart_527.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_661 = 
      ((PartCurve) cadPart_527.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_528 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 31"));

    PartSurface partSurface_681 = 
      ((PartSurface) cadPart_528.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_662 = 
      ((PartCurve) cadPart_528.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_529 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 32"));

    PartSurface partSurface_682 = 
      ((PartSurface) cadPart_529.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_663 = 
      ((PartCurve) cadPart_529.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_530 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 33"));

    PartSurface partSurface_683 = 
      ((PartSurface) cadPart_530.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_664 = 
      ((PartCurve) cadPart_530.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_531 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 34"));

    PartSurface partSurface_684 = 
      ((PartSurface) cadPart_531.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_665 = 
      ((PartCurve) cadPart_531.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_532 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 35"));

    PartSurface partSurface_685 = 
      ((PartSurface) cadPart_532.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_666 = 
      ((PartCurve) cadPart_532.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_533 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 36"));

    PartSurface partSurface_686 = 
      ((PartSurface) cadPart_533.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_667 = 
      ((PartCurve) cadPart_533.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_534 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 37"));

    PartSurface partSurface_687 = 
      ((PartSurface) cadPart_534.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_668 = 
      ((PartCurve) cadPart_534.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_535 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 38"));

    PartSurface partSurface_688 = 
      ((PartSurface) cadPart_535.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_669 = 
      ((PartCurve) cadPart_535.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_536 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 39"));

    PartSurface partSurface_689 = 
      ((PartSurface) cadPart_536.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_670 = 
      ((PartCurve) cadPart_536.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_537 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 40"));

    PartSurface partSurface_690 = 
      ((PartSurface) cadPart_537.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_671 = 
      ((PartCurve) cadPart_537.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_538 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 41"));

    PartSurface partSurface_691 = 
      ((PartSurface) cadPart_538.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_672 = 
      ((PartCurve) cadPart_538.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_539 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 42"));

    PartSurface partSurface_692 = 
      ((PartSurface) cadPart_539.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_673 = 
      ((PartCurve) cadPart_539.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_540 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 43"));

    PartSurface partSurface_693 = 
      ((PartSurface) cadPart_540.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_674 = 
      ((PartCurve) cadPart_540.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_541 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 44"));

    PartSurface partSurface_694 = 
      ((PartSurface) cadPart_541.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_675 = 
      ((PartCurve) cadPart_541.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_542 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 45"));

    PartSurface partSurface_695 = 
      ((PartSurface) cadPart_542.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_676 = 
      ((PartCurve) cadPart_542.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_543 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 46"));

    PartSurface partSurface_696 = 
      ((PartSurface) cadPart_543.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_677 = 
      ((PartCurve) cadPart_543.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_544 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 47"));

    PartSurface partSurface_697 = 
      ((PartSurface) cadPart_544.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_678 = 
      ((PartCurve) cadPart_544.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_545 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 48"));

    PartSurface partSurface_698 = 
      ((PartSurface) cadPart_545.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_679 = 
      ((PartCurve) cadPart_545.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_546 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 49"));

    PartSurface partSurface_699 = 
      ((PartSurface) cadPart_546.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_680 = 
      ((PartCurve) cadPart_546.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_547 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 50"));

    PartSurface partSurface_700 = 
      ((PartSurface) cadPart_547.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_681 = 
      ((PartCurve) cadPart_547.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_548 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 51"));

    PartSurface partSurface_701 = 
      ((PartSurface) cadPart_548.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_682 = 
      ((PartCurve) cadPart_548.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_549 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 52"));

    PartSurface partSurface_702 = 
      ((PartSurface) cadPart_549.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_683 = 
      ((PartCurve) cadPart_549.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_550 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 53"));

    PartSurface partSurface_703 = 
      ((PartSurface) cadPart_550.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_684 = 
      ((PartCurve) cadPart_550.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_551 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 54"));

    PartSurface partSurface_704 = 
      ((PartSurface) cadPart_551.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_685 = 
      ((PartCurve) cadPart_551.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_552 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 55"));

    PartSurface partSurface_705 = 
      ((PartSurface) cadPart_552.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_686 = 
      ((PartCurve) cadPart_552.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_553 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 56"));

    PartSurface partSurface_706 = 
      ((PartSurface) cadPart_553.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_687 = 
      ((PartCurve) cadPart_553.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_554 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 57"));

    PartSurface partSurface_707 = 
      ((PartSurface) cadPart_554.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_688 = 
      ((PartCurve) cadPart_554.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_555 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 58"));

    PartSurface partSurface_708 = 
      ((PartSurface) cadPart_555.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_689 = 
      ((PartCurve) cadPart_555.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_556 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 59"));

    PartSurface partSurface_709 = 
      ((PartSurface) cadPart_556.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_690 = 
      ((PartCurve) cadPart_556.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_557 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 61"));

    PartSurface partSurface_710 = 
      ((PartSurface) cadPart_557.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_691 = 
      ((PartCurve) cadPart_557.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_558 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 64"));

    PartSurface partSurface_711 = 
      ((PartSurface) cadPart_558.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_692 = 
      ((PartCurve) cadPart_558.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_559 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 65"));

    PartSurface partSurface_712 = 
      ((PartSurface) cadPart_559.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_693 = 
      ((PartCurve) cadPart_559.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_560 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 66"));

    PartSurface partSurface_713 = 
      ((PartSurface) cadPart_560.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_694 = 
      ((PartCurve) cadPart_560.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_561 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 67"));

    PartSurface partSurface_714 = 
      ((PartSurface) cadPart_561.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_695 = 
      ((PartCurve) cadPart_561.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_562 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 68"));

    PartSurface partSurface_715 = 
      ((PartSurface) cadPart_562.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_696 = 
      ((PartCurve) cadPart_562.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_563 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 69"));

    PartSurface partSurface_716 = 
      ((PartSurface) cadPart_563.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_697 = 
      ((PartCurve) cadPart_563.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_564 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 70"));

    PartSurface partSurface_717 = 
      ((PartSurface) cadPart_564.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_698 = 
      ((PartCurve) cadPart_564.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_565 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 71"));

    PartSurface partSurface_718 = 
      ((PartSurface) cadPart_565.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_699 = 
      ((PartCurve) cadPart_565.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_566 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 72"));

    PartSurface partSurface_719 = 
      ((PartSurface) cadPart_566.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_700 = 
      ((PartCurve) cadPart_566.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_567 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 73"));

    PartSurface partSurface_720 = 
      ((PartSurface) cadPart_567.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_701 = 
      ((PartCurve) cadPart_567.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_568 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 74"));

    PartSurface partSurface_721 = 
      ((PartSurface) cadPart_568.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_702 = 
      ((PartCurve) cadPart_568.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_569 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 75"));

    PartSurface partSurface_722 = 
      ((PartSurface) cadPart_569.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_703 = 
      ((PartCurve) cadPart_569.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_570 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 76"));

    PartSurface partSurface_723 = 
      ((PartSurface) cadPart_570.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_704 = 
      ((PartCurve) cadPart_570.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_571 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 77"));

    PartSurface partSurface_724 = 
      ((PartSurface) cadPart_571.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_705 = 
      ((PartCurve) cadPart_571.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_572 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 78"));

    PartSurface partSurface_725 = 
      ((PartSurface) cadPart_572.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_706 = 
      ((PartCurve) cadPart_572.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_573 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 79"));

    PartSurface partSurface_726 = 
      ((PartSurface) cadPart_573.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_707 = 
      ((PartCurve) cadPart_573.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_574 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 80"));

    PartSurface partSurface_727 = 
      ((PartSurface) cadPart_574.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_708 = 
      ((PartCurve) cadPart_574.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_575 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 81"));

    PartSurface partSurface_728 = 
      ((PartSurface) cadPart_575.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_709 = 
      ((PartCurve) cadPart_575.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_576 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 82"));

    PartSurface partSurface_729 = 
      ((PartSurface) cadPart_576.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_710 = 
      ((PartCurve) cadPart_576.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_577 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 83"));

    PartSurface partSurface_730 = 
      ((PartSurface) cadPart_577.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_711 = 
      ((PartCurve) cadPart_577.getPartCurveManager().getPartCurve("Edges"));

    partDisplayer_12.getInputParts().setObjects(partSurface_490, partCurve_471, partSurface_491, partCurve_472, partSurface_492, partCurve_473, partSurface_493, partCurve_474, partSurface_494, partCurve_475, partSurface_495, partCurve_476, partSurface_496, partCurve_477, partSurface_497, partCurve_478, partSurface_498, partCurve_479, partSurface_499, partCurve_480, partSurface_500, partCurve_481, partSurface_501, partCurve_482, partSurface_502, partCurve_483, partSurface_503, partCurve_484, partSurface_504, partCurve_485, partSurface_505, partCurve_486, partSurface_506, partCurve_487, partSurface_507, partCurve_488, partSurface_508, partCurve_489, partSurface_509, partCurve_490, partSurface_510, partCurve_491, partSurface_511, partCurve_492, partSurface_512, partCurve_493, partSurface_513, partCurve_494, partSurface_514, partCurve_495, partSurface_515, partCurve_496, partSurface_516, partCurve_497, partSurface_517, partCurve_498, partSurface_518, partCurve_499, partSurface_519, partCurve_500, partSurface_520, partCurve_501, partSurface_521, partCurve_502, partSurface_522, partCurve_503, partSurface_523, partCurve_504, partSurface_524, partCurve_505, partSurface_525, partCurve_506, partSurface_526, partCurve_507, partSurface_527, partCurve_508, partSurface_528, partCurve_509, partSurface_529, partCurve_510, partSurface_530, partCurve_511, partSurface_531, partCurve_512, partSurface_532, partCurve_513, partSurface_533, partCurve_514, partSurface_534, partCurve_515, partSurface_535, partCurve_516, partSurface_536, partCurve_517, partSurface_537, partCurve_518, partSurface_538, partCurve_519, partSurface_539, partCurve_520, partSurface_540, partCurve_521, partSurface_541, partCurve_522, partSurface_542, partCurve_523, partSurface_543, partCurve_524, partSurface_544, partCurve_525, partSurface_545, partCurve_526, partSurface_546, partCurve_527, partSurface_547, partCurve_528, partSurface_548, partCurve_529, partSurface_549, partCurve_530, partSurface_550, partCurve_531, partSurface_551, partCurve_532, partSurface_552, partCurve_533, partSurface_553, partCurve_534, partSurface_554, partCurve_535, partSurface_555, partCurve_536, partSurface_556, partCurve_537, partSurface_557, partCurve_538, partSurface_558, partCurve_539, partSurface_559, partCurve_540, partSurface_560, partCurve_541, partSurface_561, partCurve_542, partSurface_562, partCurve_543, partSurface_563, partCurve_544, partSurface_564, partCurve_545, partSurface_565, partCurve_546, partSurface_566, partCurve_547, partSurface_567, partCurve_548, partSurface_568, partCurve_549, partSurface_569, partCurve_550, partSurface_570, partCurve_551, partSurface_571, partCurve_552, partSurface_572, partCurve_553, partSurface_573, partCurve_554, partSurface_574, partCurve_555, partSurface_575, partCurve_556, partSurface_576, partCurve_557, partSurface_577, partCurve_558, partSurface_578, partCurve_559, partSurface_579, partCurve_560, partSurface_580, partCurve_561, partSurface_581, partCurve_562, partSurface_582, partCurve_563, partSurface_583, partCurve_564, partSurface_584, partCurve_565, partSurface_585, partCurve_566, partSurface_586, partCurve_567, partSurface_587, partCurve_568, partSurface_588, partCurve_569, partSurface_589, partCurve_570, partSurface_590, partCurve_571, partSurface_591, partCurve_572, partSurface_592, partCurve_573, partSurface_593, partCurve_574, partSurface_594, partCurve_575, partSurface_595, partCurve_576, partSurface_596, partCurve_577, partSurface_597, partCurve_578, partSurface_598, partCurve_579, partSurface_599, partCurve_580, partSurface_600, partCurve_581, partSurface_601, partCurve_582, partSurface_602, partCurve_583, partSurface_603, partCurve_584, partSurface_604, partCurve_585, partSurface_605, partCurve_586, partSurface_606, partCurve_587, partSurface_607, partCurve_588, partSurface_608, partCurve_589, partSurface_609, partCurve_590, partSurface_610, partCurve_591, partSurface_611, partCurve_592, partSurface_612, partCurve_593, partSurface_613, partCurve_594, partSurface_614, partCurve_595, partSurface_615, partCurve_596, partSurface_616, partCurve_597, partSurface_617, partCurve_598, partSurface_618, partCurve_599, partSurface_619, partCurve_600, partSurface_620, partCurve_601, partSurface_621, partCurve_602, partSurface_622, partCurve_603, partSurface_623, partCurve_604, partSurface_624, partCurve_605, partSurface_625, partCurve_606, partSurface_626, partCurve_607, partSurface_627, partCurve_608, partSurface_628, partCurve_609, partSurface_629, partCurve_610, partSurface_630, partCurve_611, partSurface_631, partCurve_612, partSurface_632, partCurve_613, partSurface_633, partCurve_614, partSurface_634, partCurve_615, partSurface_635, partCurve_616, partSurface_636, partCurve_617, partSurface_637, partCurve_618, partSurface_638, partCurve_619, partSurface_639, partCurve_620, partSurface_640, partCurve_621, partSurface_641, partCurve_622, partSurface_642, partCurve_623, partSurface_643, partCurve_624, partSurface_644, partCurve_625, partSurface_645, partCurve_626, partSurface_646, partCurve_627, partSurface_647, partCurve_628, partSurface_648, partCurve_629, partSurface_649, partCurve_630, partSurface_650, partCurve_631, partSurface_651, partCurve_632, partSurface_652, partCurve_633, partSurface_653, partCurve_634, partSurface_654, partCurve_635, partSurface_655, partCurve_636, partSurface_656, partCurve_637, partSurface_657, partCurve_638, partSurface_658, partCurve_639, partSurface_659, partCurve_640, partSurface_660, partCurve_641, partSurface_661, partCurve_642, partSurface_662, partCurve_643, partSurface_663, partCurve_644, partSurface_664, partCurve_645, partSurface_665, partCurve_646, partSurface_666, partCurve_647, partSurface_667, partCurve_648, partSurface_668, partCurve_649, partSurface_669, partCurve_650, partSurface_670, partCurve_651, partSurface_671, partCurve_652, partSurface_672, partCurve_653, partSurface_673, partCurve_654, partSurface_674, partCurve_655, partSurface_675, partCurve_656, partSurface_676, partCurve_657, partSurface_677, partCurve_658, partSurface_678, partCurve_659, partSurface_679, partCurve_660, partSurface_680, partCurve_661, partSurface_681, partCurve_662, partSurface_682, partCurve_663, partSurface_683, partCurve_664, partSurface_684, partCurve_665, partSurface_685, partCurve_666, partSurface_686, partCurve_667, partSurface_687, partCurve_668, partSurface_688, partCurve_669, partSurface_689, partCurve_670, partSurface_690, partCurve_671, partSurface_691, partCurve_672, partSurface_692, partCurve_673, partSurface_693, partCurve_674, partSurface_694, partCurve_675, partSurface_695, partCurve_676, partSurface_696, partCurve_677, partSurface_697, partCurve_678, partSurface_698, partCurve_679, partSurface_699, partCurve_680, partSurface_700, partCurve_681, partSurface_701, partCurve_682, partSurface_702, partCurve_683, partSurface_703, partCurve_684, partSurface_704, partCurve_685, partSurface_705, partCurve_686, partSurface_706, partCurve_687, partSurface_707, partCurve_688, partSurface_708, partCurve_689, partSurface_709, partCurve_690, partSurface_710, partCurve_691, partSurface_711, partCurve_692, partSurface_712, partCurve_693, partSurface_713, partCurve_694, partSurface_714, partCurve_695, partSurface_715, partCurve_696, partSurface_716, partCurve_697, partSurface_717, partCurve_698, partSurface_718, partCurve_699, partSurface_719, partCurve_700, partSurface_720, partCurve_701, partSurface_721, partCurve_702, partSurface_722, partCurve_703, partSurface_723, partCurve_704, partSurface_724, partCurve_705, partSurface_725, partCurve_706, partSurface_726, partCurve_707, partSurface_727, partCurve_708, partSurface_728, partCurve_709, partSurface_729, partCurve_710, partSurface_730, partCurve_711);
  }

  private void execute10() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Scene scene_1 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 2");

    CurrentView currentView_0 = 
      scene_1.getCurrentView();

    currentView_0.setInput(new DoubleVector(new double[] {-0.4344599246409401, -0.5727298777370078, 0.42678717448883524}), new DoubleVector(new double[] {1.7471510844123537, 1.5244094645612454, 0.8784897172440769}), new DoubleVector(new double[] {0.016256136542941377, -0.22666553399597247, 0.9738369851895611}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.46090594229569626, 0.7627799579304095, 0.7634588213519067}), new DoubleVector(new double[] {2.050344664276122, 2.2906758395540887, 1.0925520965933784}), new DoubleVector(new double[] {0.016256136542941377, -0.22666553399597247, 0.9738369851895611}), 1.5102818616783267, 0, 30.0);

    PartDisplayer partDisplayer_12 = 
      ((PartDisplayer) scene_1.getDisplayerManager().getObject("susp1"));

    PresetColorSettings presetColorSettings_10 = 
      partDisplayer_12.getPresetColorSettings();

    RayTraceSimpleMetalMaterial rayTraceSimpleMetalMaterial_0 = 
      ((RayTraceSimpleMetalMaterial) simulation_0.get(RayTraceMaterialManager.class).getObject("Metallic Light Gray"));

    presetColorSettings_10.setRayTraceMaterial(rayTraceSimpleMetalMaterial_0);

    currentView_0.setInput(new DoubleVector(new double[] {0.5359327571205553, 0.831075054430802, 0.7772551498851485}), new DoubleVector(new double[] {1.8842877553076978, 2.3289210652571235, 1.1480379845830444}), new DoubleVector(new double[] {0.0016843269686221932, -0.24171927499608398, 0.9703447609680329}), 1.5102818616783267, 0, 30.0);

    PartDisplayer partDisplayer_13 = 
      scene_1.getDisplayerManager().createPartDisplayer("Surface", -1, 1);

    partDisplayer_13.setPresentationName("susp2");

    partDisplayer_13.setColorMode(PartColorMode.PRESET);

    PartRepresentation partRepresentation_0 = 
      ((PartRepresentation) simulation_0.getRepresentationManager().getObject("Geometry"));

    partDisplayer_13.setRepresentation(partRepresentation_0);

    partDisplayer_13.getInputParts().setQuery(null);

    SolidModelCompositePart solidModelCompositePart_4 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("z_000_remaining-parts"));

    CompositePart compositePart_106 = 
      ((CompositePart) solidModelCompositePart_4.getChildParts().getPart("Suspension_Rear_Left"));

    CadPart cadPart_321 = 
      ((CadPart) compositePart_106.getChildParts().getPart("S_RL08_D"));

    PartSurface partSurface_343 = 
      ((PartSurface) cadPart_321.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_321 = 
      ((PartCurve) cadPart_321.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_322 = 
      ((CadPart) compositePart_106.getChildParts().getPart("S_RL08_D 2"));

    PartSurface partSurface_344 = 
      ((PartSurface) cadPart_322.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_322 = 
      ((PartCurve) cadPart_322.getPartCurveManager().getPartCurve("Edges"));

    CompositePart compositePart_107 = 
      ((CompositePart) solidModelCompositePart_4.getChildParts().getPart("Suspension_Rear_Right"));

    CadPart cadPart_330 = 
      ((CadPart) compositePart_107.getChildParts().getPart("S_RL08_D"));

    PartSurface partSurface_352 = 
      ((PartSurface) cadPart_330.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_330 = 
      ((PartCurve) cadPart_330.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_331 = 
      ((CadPart) compositePart_107.getChildParts().getPart("S_RL08_D 2"));

    PartSurface partSurface_353 = 
      ((PartSurface) cadPart_331.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_331 = 
      ((PartCurve) cadPart_331.getPartCurveManager().getPartCurve("Edges"));

    partDisplayer_13.getInputParts().setObjects(partSurface_343, partCurve_321, partSurface_344, partCurve_322, partSurface_352, partCurve_330, partSurface_353, partCurve_331);

    PresetColorSettings presetColorSettings_11 = 
      partDisplayer_13.getPresetColorSettings();

    RayTraceSimpleMetalMaterial rayTraceSimpleMetalMaterial_2 = 
      ((RayTraceSimpleMetalMaterial) simulation_0.get(RayTraceMaterialManager.class).getObject("Metallic Red"));

    presetColorSettings_11.setRayTraceMaterial(rayTraceSimpleMetalMaterial_2);

    currentView_0.setInput(new DoubleVector(new double[] {0.643855009168939, 0.933893636700505, 0.8152878707274747}), new DoubleVector(new double[] {2.16417798074313, 2.068870266532162, 1.5044972460884383}), new DoubleVector(new double[] {-0.1393126210824652, -0.3709313050576178, 0.9181513821453773}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.12963493304328022, 1.1576804595086339, 0.9700511388706983}), new DoubleVector(new double[] {2.9181461094017576, 3.4329603314146406, 2.35170445055193}), new DoubleVector(new double[] {-0.1393126210824652, -0.3709313050576178, 0.9181513821453773}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.8491104114842836, 0.5538924120647146, 0.7249801903635975}), new DoubleVector(new double[] {3.6603976908055085, 2.6526210515911, 1.9994235724398344}), new DoubleVector(new double[] {-0.1393126210824652, -0.3709313050576178, 0.9181513821453773}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.8608391574446834, 0.5593461840618636, 0.7275363394516116}), new DoubleVector(new double[] {3.35086732089502, 2.8094214430937092, 2.18339694889156}), new DoubleVector(new double[] {-0.16981062475213757, -0.3959736222916607, 0.9024240921931279}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.5886712881679719, 0.4474396943738608, 0.7415045338906847}), new DoubleVector(new double[] {3.7945486158664488, 3.3443809275806564, 2.615905228871381}), new DoubleVector(new double[] {-0.16981062475213757, -0.3959736222916607, 0.9024240921931279}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.5851104854725355, 0.5837800266262021, 0.7391767252266438}), new DoubleVector(new double[] {3.7361880018450417, 3.431202261825633, 2.581537265848736}), new DoubleVector(new double[] {-0.16981062475213757, -0.3959736222916607, 0.9024240921931279}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.48540602065356964, 0.4779730630600836, 0.6716896260185768}), new DoubleVector(new double[] {3.0278380925934285, 3.76776257545624, 2.7388194972826594}), new DoubleVector(new double[] {-0.18726512657847644, -0.4147833504488849, 0.8904417693246569}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.22114548970737988, 0.1357267310125527, 0.456923510792197}), new DoubleVector(new double[] {2.9005587625960856, 3.97475715723597, 2.5240103797736237}), new DoubleVector(new double[] {-0.1607091454032873, -0.37861899275418504, 0.911493405850879}), 1.5102818616783267, 0, 30.0);

    PartDisplayer partDisplayer_14 = 
      scene_1.getDisplayerManager().createPartDisplayer("Surface", -1, 1);

    partDisplayer_14.setPresentationName("driver");

    partDisplayer_14.setColorMode(PartColorMode.PRESET);

    partDisplayer_14.setRepresentation(partRepresentation_0);

    partDisplayer_14.getInputParts().setQuery(null);

    CompositePart compositePart_109 = 
      ((CompositePart) solidModelCompositePart_4.getChildParts().getPart("C_P002_FAHRER_GERADEAUS"));

    SimpleBlockPart simpleBlockPart_1 = 
      ((SimpleBlockPart) compositePart_109.getChildParts().getPart("Block"));

    PartSurface partSurface_731 = 
      ((PartSurface) simpleBlockPart_1.getPartSurfaceManager().getPartSurface("Block Surface"));

    PartCurve partCurve_712 = 
      ((PartCurve) simpleBlockPart_1.getPartCurveManager().getPartCurve("Block Curve"));

    MeshPart meshPart_0 = 
      ((MeshPart) compositePart_109.getChildParts().getPart("driver"));

    PartSurface partSurface_732 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface"));

    PartCurve partCurve_713 = 
      ((PartCurve) meshPart_0.getPartCurveManager().getPartCurve("Surface Repair Edges"));

    partDisplayer_14.getInputParts().setObjects(partSurface_731, partCurve_712, partSurface_732, partCurve_713);

    currentView_0.setInput(new DoubleVector(new double[] {0.6617168058909682, 0.7505113014309821, 0.7936772900456193}), new DoubleVector(new double[] {2.4384610397016044, 4.150279031534656, 2.3269795360484347}), new DoubleVector(new double[] {-0.14041499497506194, -0.3451422544218328, 0.9279873131669708}), 1.5102818616783267, 0, 30.0);

    partDisplayer_14.getInputParts().setQuery(null);

    partDisplayer_14.getInputParts().setObjects(partSurface_732, partCurve_713);

    currentView_0.setInput(new DoubleVector(new double[] {0.3567121259362174, 0.14666065179447385, 0.5046127364113455}), new DoubleVector(new double[] {1.9064817655735782, 3.8482583580221945, 2.782708748048518}), new DoubleVector(new double[] {-0.1920898646263083, -0.45478400098650895, 0.8696395784200701}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.46318192261866575, 0.07210524405461635, 0.5712101867988517}), new DoubleVector(new double[] {0.04498876497988902, 4.089792305522662, 1.327992875876388}), new DoubleVector(new double[] {-0.15840359585828614, -0.19866880961647268, 0.9671809576831167}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.4272393569810015, 0.23248525415283244, 0.6204707479766463}), new DoubleVector(new double[] {-1.2685234205024762, 3.350728783597101, 2.5649190716124384}), new DoubleVector(new double[] {-0.0539460403376989, -0.5493157172742232, 0.8338717332344816}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.056691017522893516, 0.17422318792653257, 0.24265572255150336}), new DoubleVector(new double[] {-0.4221275617239807, 1.054695950001186, 0.791693592768187}), new DoubleVector(new double[] {-0.0539460403376989, -0.5493157172742232, 0.8338717332344816}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.023708611809044017, 0.21707365957361852, 0.27103597061465856}), new DoubleVector(new double[] {-0.7688838941276773, 0.8650587044714727, 0.7505908115485992}), new DoubleVector(new double[] {-0.009650516655634498, -0.6024522086972331, 0.798096613051452}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.0692503168257659, 0.30764642130086994, 0.33624298271307235}), new DoubleVector(new double[] {-0.32370287167785544, 1.1461111427713035, 0.8778972404121825}), new DoubleVector(new double[] {-0.04442817211845537, -0.5515707128869863, 0.8329441074932061}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.0692503168257659, 0.30764642130086994, 0.33624298271307235}), new DoubleVector(new double[] {-0.32370287167785544, 1.1461111427713035, 0.8778972404121825}), new DoubleVector(new double[] {-0.04442817211845537, -0.5515707128869863, 0.8329441074932061}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.0692503168257659, 0.30764642130086994, 0.33624298271307235}), new DoubleVector(new double[] {-0.32370287167785544, 1.1461111427713035, 0.8778972404121825}), new DoubleVector(new double[] {-0.04442817211845537, -0.5515707128869863, 0.8329441074932061}), 1.5102818616783267, 0, 30.0);

    partDisplayer_12.getInputParts().setQuery(null);

    CadPart cadPart_338 = 
      ((CadPart) compositePart_106.getChildParts().getPart("Body 1"));

    PartSurface partSurface_490 = 
      ((PartSurface) cadPart_338.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_471 = 
      ((PartCurve) cadPart_338.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_339 = 
      ((CadPart) compositePart_106.getChildParts().getPart("Body 93"));

    PartSurface partSurface_491 = 
      ((PartSurface) cadPart_339.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_472 = 
      ((PartCurve) cadPart_339.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_340 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body"));

    PartSurface partSurface_492 = 
      ((PartSurface) cadPart_340.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_473 = 
      ((PartCurve) cadPart_340.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_341 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 2"));

    PartSurface partSurface_493 = 
      ((PartSurface) cadPart_341.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_474 = 
      ((PartCurve) cadPart_341.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_342 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 3"));

    PartSurface partSurface_494 = 
      ((PartSurface) cadPart_342.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_475 = 
      ((PartCurve) cadPart_342.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_343 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 4"));

    PartSurface partSurface_495 = 
      ((PartSurface) cadPart_343.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_476 = 
      ((PartCurve) cadPart_343.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_344 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 5"));

    PartSurface partSurface_496 = 
      ((PartSurface) cadPart_344.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_477 = 
      ((PartCurve) cadPart_344.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_345 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 6"));

    PartSurface partSurface_497 = 
      ((PartSurface) cadPart_345.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_478 = 
      ((PartCurve) cadPart_345.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_346 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 7"));

    PartSurface partSurface_498 = 
      ((PartSurface) cadPart_346.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_479 = 
      ((PartCurve) cadPart_346.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_347 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 8"));

    PartSurface partSurface_499 = 
      ((PartSurface) cadPart_347.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_480 = 
      ((PartCurve) cadPart_347.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_348 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 9"));

    PartSurface partSurface_500 = 
      ((PartSurface) cadPart_348.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_481 = 
      ((PartCurve) cadPart_348.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_349 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 10"));

    PartSurface partSurface_501 = 
      ((PartSurface) cadPart_349.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_482 = 
      ((PartCurve) cadPart_349.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_350 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 11"));

    PartSurface partSurface_502 = 
      ((PartSurface) cadPart_350.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_483 = 
      ((PartCurve) cadPart_350.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_351 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 12"));

    PartSurface partSurface_503 = 
      ((PartSurface) cadPart_351.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_484 = 
      ((PartCurve) cadPart_351.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_352 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 13"));

    PartSurface partSurface_504 = 
      ((PartSurface) cadPart_352.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_485 = 
      ((PartCurve) cadPart_352.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_353 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 14"));

    PartSurface partSurface_505 = 
      ((PartSurface) cadPart_353.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_486 = 
      ((PartCurve) cadPart_353.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_354 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 15"));

    PartSurface partSurface_506 = 
      ((PartSurface) cadPart_354.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_487 = 
      ((PartCurve) cadPart_354.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_355 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 16"));

    PartSurface partSurface_507 = 
      ((PartSurface) cadPart_355.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_488 = 
      ((PartCurve) cadPart_355.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_356 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 17"));

    PartSurface partSurface_508 = 
      ((PartSurface) cadPart_356.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_489 = 
      ((PartCurve) cadPart_356.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_357 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 18"));

    PartSurface partSurface_509 = 
      ((PartSurface) cadPart_357.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_490 = 
      ((PartCurve) cadPart_357.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_358 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 19"));

    PartSurface partSurface_510 = 
      ((PartSurface) cadPart_358.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_491 = 
      ((PartCurve) cadPart_358.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_359 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 20"));

    PartSurface partSurface_511 = 
      ((PartSurface) cadPart_359.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_492 = 
      ((PartCurve) cadPart_359.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_360 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 21"));

    PartSurface partSurface_512 = 
      ((PartSurface) cadPart_360.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_493 = 
      ((PartCurve) cadPart_360.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_361 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 22"));

    PartSurface partSurface_513 = 
      ((PartSurface) cadPart_361.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_494 = 
      ((PartCurve) cadPart_361.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_362 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 23"));

    PartSurface partSurface_514 = 
      ((PartSurface) cadPart_362.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_495 = 
      ((PartCurve) cadPart_362.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_363 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 24"));

    PartSurface partSurface_515 = 
      ((PartSurface) cadPart_363.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_496 = 
      ((PartCurve) cadPart_363.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_364 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 25"));

    PartSurface partSurface_516 = 
      ((PartSurface) cadPart_364.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_497 = 
      ((PartCurve) cadPart_364.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_365 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 26"));

    PartSurface partSurface_517 = 
      ((PartSurface) cadPart_365.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_498 = 
      ((PartCurve) cadPart_365.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_367 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 27"));

    PartSurface partSurface_519 = 
      ((PartSurface) cadPart_367.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_500 = 
      ((PartCurve) cadPart_367.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_368 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 28"));

    PartSurface partSurface_520 = 
      ((PartSurface) cadPart_368.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_501 = 
      ((PartCurve) cadPart_368.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_369 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 29"));

    PartSurface partSurface_521 = 
      ((PartSurface) cadPart_369.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_502 = 
      ((PartCurve) cadPart_369.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_370 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 30"));

    PartSurface partSurface_522 = 
      ((PartSurface) cadPart_370.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_503 = 
      ((PartCurve) cadPart_370.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_371 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 31"));

    PartSurface partSurface_523 = 
      ((PartSurface) cadPart_371.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_504 = 
      ((PartCurve) cadPart_371.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_372 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 32"));

    PartSurface partSurface_524 = 
      ((PartSurface) cadPart_372.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_505 = 
      ((PartCurve) cadPart_372.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_373 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 33"));

    PartSurface partSurface_525 = 
      ((PartSurface) cadPart_373.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_506 = 
      ((PartCurve) cadPart_373.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_374 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 34"));

    PartSurface partSurface_526 = 
      ((PartSurface) cadPart_374.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_507 = 
      ((PartCurve) cadPart_374.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_375 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 35"));

    PartSurface partSurface_527 = 
      ((PartSurface) cadPart_375.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_508 = 
      ((PartCurve) cadPart_375.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_376 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 36"));

    PartSurface partSurface_528 = 
      ((PartSurface) cadPart_376.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_509 = 
      ((PartCurve) cadPart_376.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_377 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 37"));

    PartSurface partSurface_529 = 
      ((PartSurface) cadPart_377.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_510 = 
      ((PartCurve) cadPart_377.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_378 = 
      ((CadPart) compositePart_106.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 38"));

    PartSurface partSurface_530 = 
      ((PartSurface) cadPart_378.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_511 = 
      ((PartCurve) cadPart_378.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_379 = 
      ((CadPart) compositePart_106.getChildParts().getPart("DE    54825"));

    PartSurface partSurface_531 = 
      ((PartSurface) cadPart_379.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_512 = 
      ((PartCurve) cadPart_379.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_380 = 
      ((CadPart) compositePart_106.getChildParts().getPart("DE    82055"));

    PartSurface partSurface_532 = 
      ((PartSurface) cadPart_380.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_513 = 
      ((PartCurve) cadPart_380.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_381 = 
      ((CadPart) compositePart_106.getChildParts().getPart("DE    82073"));

    PartSurface partSurface_533 = 
      ((PartSurface) cadPart_381.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_514 = 
      ((PartCurve) cadPart_381.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_382 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 3"));

    PartSurface partSurface_534 = 
      ((PartSurface) cadPart_382.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_515 = 
      ((PartCurve) cadPart_382.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_383 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 4"));

    PartSurface partSurface_535 = 
      ((PartSurface) cadPart_383.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_516 = 
      ((PartCurve) cadPart_383.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_384 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 5"));

    PartSurface partSurface_536 = 
      ((PartSurface) cadPart_384.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_517 = 
      ((PartCurve) cadPart_384.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_385 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 6"));

    PartSurface partSurface_537 = 
      ((PartSurface) cadPart_385.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_518 = 
      ((PartCurve) cadPart_385.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_386 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 7"));

    PartSurface partSurface_538 = 
      ((PartSurface) cadPart_386.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_519 = 
      ((PartCurve) cadPart_386.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_387 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 8"));

    PartSurface partSurface_539 = 
      ((PartSurface) cadPart_387.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_520 = 
      ((PartCurve) cadPart_387.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_388 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 9"));

    PartSurface partSurface_540 = 
      ((PartSurface) cadPart_388.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_521 = 
      ((PartCurve) cadPart_388.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_389 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 10"));

    PartSurface partSurface_541 = 
      ((PartSurface) cadPart_389.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_522 = 
      ((PartCurve) cadPart_389.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_390 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 11"));

    PartSurface partSurface_542 = 
      ((PartSurface) cadPart_390.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_523 = 
      ((PartCurve) cadPart_390.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_391 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 12"));

    PartSurface partSurface_543 = 
      ((PartSurface) cadPart_391.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_524 = 
      ((PartCurve) cadPart_391.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_392 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 13"));

    PartSurface partSurface_544 = 
      ((PartSurface) cadPart_392.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_525 = 
      ((PartCurve) cadPart_392.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_393 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 14"));

    PartSurface partSurface_545 = 
      ((PartSurface) cadPart_393.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_526 = 
      ((PartCurve) cadPart_393.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_394 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 15"));

    PartSurface partSurface_546 = 
      ((PartSurface) cadPart_394.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_527 = 
      ((PartCurve) cadPart_394.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_395 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 16"));

    PartSurface partSurface_547 = 
      ((PartSurface) cadPart_395.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_528 = 
      ((PartCurve) cadPart_395.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_396 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 17"));

    PartSurface partSurface_548 = 
      ((PartSurface) cadPart_396.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_529 = 
      ((PartCurve) cadPart_396.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_397 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 18"));

    PartSurface partSurface_549 = 
      ((PartSurface) cadPart_397.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_530 = 
      ((PartCurve) cadPart_397.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_398 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 19"));

    PartSurface partSurface_550 = 
      ((PartSurface) cadPart_398.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_531 = 
      ((PartCurve) cadPart_398.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_399 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 20"));

    PartSurface partSurface_551 = 
      ((PartSurface) cadPart_399.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_532 = 
      ((PartCurve) cadPart_399.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_400 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 21"));

    PartSurface partSurface_552 = 
      ((PartSurface) cadPart_400.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_533 = 
      ((PartCurve) cadPart_400.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_401 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 22"));

    PartSurface partSurface_553 = 
      ((PartSurface) cadPart_401.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_534 = 
      ((PartCurve) cadPart_401.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_402 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 23"));

    PartSurface partSurface_554 = 
      ((PartSurface) cadPart_402.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_535 = 
      ((PartCurve) cadPart_402.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_403 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 24"));

    PartSurface partSurface_555 = 
      ((PartSurface) cadPart_403.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_536 = 
      ((PartCurve) cadPart_403.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_404 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 25"));

    PartSurface partSurface_556 = 
      ((PartSurface) cadPart_404.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_537 = 
      ((PartCurve) cadPart_404.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_405 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 27"));

    PartSurface partSurface_557 = 
      ((PartSurface) cadPart_405.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_538 = 
      ((PartCurve) cadPart_405.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_406 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 28"));

    PartSurface partSurface_558 = 
      ((PartSurface) cadPart_406.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_539 = 
      ((PartCurve) cadPart_406.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_407 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 29"));

    PartSurface partSurface_559 = 
      ((PartSurface) cadPart_407.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_540 = 
      ((PartCurve) cadPart_407.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_408 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 30"));

    PartSurface partSurface_560 = 
      ((PartSurface) cadPart_408.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_541 = 
      ((PartCurve) cadPart_408.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_409 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 31"));

    PartSurface partSurface_561 = 
      ((PartSurface) cadPart_409.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_542 = 
      ((PartCurve) cadPart_409.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_410 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 32"));

    PartSurface partSurface_562 = 
      ((PartSurface) cadPart_410.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_543 = 
      ((PartCurve) cadPart_410.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_411 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 33"));

    PartSurface partSurface_563 = 
      ((PartSurface) cadPart_411.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_544 = 
      ((PartCurve) cadPart_411.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_412 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 34"));

    PartSurface partSurface_564 = 
      ((PartSurface) cadPart_412.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_545 = 
      ((PartCurve) cadPart_412.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_413 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 35"));

    PartSurface partSurface_565 = 
      ((PartSurface) cadPart_413.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_546 = 
      ((PartCurve) cadPart_413.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_414 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 36"));

    PartSurface partSurface_566 = 
      ((PartSurface) cadPart_414.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_547 = 
      ((PartCurve) cadPart_414.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_415 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 37"));

    PartSurface partSurface_567 = 
      ((PartSurface) cadPart_415.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_548 = 
      ((PartCurve) cadPart_415.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_416 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 38"));

    PartSurface partSurface_568 = 
      ((PartSurface) cadPart_416.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_549 = 
      ((PartCurve) cadPart_416.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_417 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 39"));

    PartSurface partSurface_569 = 
      ((PartSurface) cadPart_417.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_550 = 
      ((PartCurve) cadPart_417.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_418 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 40"));

    PartSurface partSurface_570 = 
      ((PartSurface) cadPart_418.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_551 = 
      ((PartCurve) cadPart_418.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_419 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 41"));

    PartSurface partSurface_571 = 
      ((PartSurface) cadPart_419.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_552 = 
      ((PartCurve) cadPart_419.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_420 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 42"));

    PartSurface partSurface_572 = 
      ((PartSurface) cadPart_420.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_553 = 
      ((PartCurve) cadPart_420.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_421 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 43"));

    PartSurface partSurface_573 = 
      ((PartSurface) cadPart_421.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_554 = 
      ((PartCurve) cadPart_421.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_422 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 44"));

    PartSurface partSurface_574 = 
      ((PartSurface) cadPart_422.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_555 = 
      ((PartCurve) cadPart_422.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_423 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 45"));

    PartSurface partSurface_575 = 
      ((PartSurface) cadPart_423.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_556 = 
      ((PartCurve) cadPart_423.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_424 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 46"));

    PartSurface partSurface_576 = 
      ((PartSurface) cadPart_424.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_557 = 
      ((PartCurve) cadPart_424.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_425 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 47"));

    PartSurface partSurface_577 = 
      ((PartSurface) cadPart_425.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_558 = 
      ((PartCurve) cadPart_425.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_426 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 48"));

    PartSurface partSurface_578 = 
      ((PartSurface) cadPart_426.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_559 = 
      ((PartCurve) cadPart_426.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_427 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 49"));

    PartSurface partSurface_579 = 
      ((PartSurface) cadPart_427.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_560 = 
      ((PartCurve) cadPart_427.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_428 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 50"));

    PartSurface partSurface_580 = 
      ((PartSurface) cadPart_428.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_561 = 
      ((PartCurve) cadPart_428.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_429 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 51"));

    PartSurface partSurface_581 = 
      ((PartSurface) cadPart_429.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_562 = 
      ((PartCurve) cadPart_429.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_430 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 52"));

    PartSurface partSurface_582 = 
      ((PartSurface) cadPart_430.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_563 = 
      ((PartCurve) cadPart_430.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_431 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 53"));

    PartSurface partSurface_583 = 
      ((PartSurface) cadPart_431.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_564 = 
      ((PartCurve) cadPart_431.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_432 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 54"));

    PartSurface partSurface_584 = 
      ((PartSurface) cadPart_432.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_565 = 
      ((PartCurve) cadPart_432.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_433 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 55"));

    PartSurface partSurface_585 = 
      ((PartSurface) cadPart_433.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_566 = 
      ((PartCurve) cadPart_433.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_434 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 56"));

    PartSurface partSurface_586 = 
      ((PartSurface) cadPart_434.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_567 = 
      ((PartCurve) cadPart_434.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_435 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 57"));

    PartSurface partSurface_587 = 
      ((PartSurface) cadPart_435.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_568 = 
      ((PartCurve) cadPart_435.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_436 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 58"));

    PartSurface partSurface_588 = 
      ((PartSurface) cadPart_436.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_569 = 
      ((PartCurve) cadPart_436.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_437 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 59"));

    PartSurface partSurface_589 = 
      ((PartSurface) cadPart_437.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_570 = 
      ((PartCurve) cadPart_437.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_438 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 61"));

    PartSurface partSurface_590 = 
      ((PartSurface) cadPart_438.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_571 = 
      ((PartCurve) cadPart_438.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_439 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 64"));

    PartSurface partSurface_591 = 
      ((PartSurface) cadPart_439.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_572 = 
      ((PartCurve) cadPart_439.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_440 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 65"));

    PartSurface partSurface_592 = 
      ((PartSurface) cadPart_440.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_573 = 
      ((PartCurve) cadPart_440.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_441 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 66"));

    PartSurface partSurface_593 = 
      ((PartSurface) cadPart_441.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_574 = 
      ((PartCurve) cadPart_441.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_442 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 67"));

    PartSurface partSurface_594 = 
      ((PartSurface) cadPart_442.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_575 = 
      ((PartCurve) cadPart_442.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_443 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 68"));

    PartSurface partSurface_595 = 
      ((PartSurface) cadPart_443.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_576 = 
      ((PartCurve) cadPart_443.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_444 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 69"));

    PartSurface partSurface_596 = 
      ((PartSurface) cadPart_444.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_577 = 
      ((PartCurve) cadPart_444.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_445 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 70"));

    PartSurface partSurface_597 = 
      ((PartSurface) cadPart_445.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_578 = 
      ((PartCurve) cadPart_445.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_446 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 71"));

    PartSurface partSurface_598 = 
      ((PartSurface) cadPart_446.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_579 = 
      ((PartCurve) cadPart_446.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_447 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 72"));

    PartSurface partSurface_599 = 
      ((PartSurface) cadPart_447.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_580 = 
      ((PartCurve) cadPart_447.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_448 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 73"));

    PartSurface partSurface_600 = 
      ((PartSurface) cadPart_448.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_581 = 
      ((PartCurve) cadPart_448.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_449 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 74"));

    PartSurface partSurface_601 = 
      ((PartSurface) cadPart_449.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_582 = 
      ((PartCurve) cadPart_449.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_450 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 75"));

    PartSurface partSurface_602 = 
      ((PartSurface) cadPart_450.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_583 = 
      ((PartCurve) cadPart_450.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_451 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 76"));

    PartSurface partSurface_603 = 
      ((PartSurface) cadPart_451.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_584 = 
      ((PartCurve) cadPart_451.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_452 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 77"));

    PartSurface partSurface_604 = 
      ((PartSurface) cadPart_452.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_585 = 
      ((PartCurve) cadPart_452.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_453 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 78"));

    PartSurface partSurface_605 = 
      ((PartSurface) cadPart_453.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_586 = 
      ((PartCurve) cadPart_453.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_454 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 79"));

    PartSurface partSurface_606 = 
      ((PartSurface) cadPart_454.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_587 = 
      ((PartCurve) cadPart_454.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_455 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 80"));

    PartSurface partSurface_607 = 
      ((PartSurface) cadPart_455.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_588 = 
      ((PartCurve) cadPart_455.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_456 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 81"));

    PartSurface partSurface_608 = 
      ((PartSurface) cadPart_456.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_589 = 
      ((PartCurve) cadPart_456.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_457 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 82"));

    PartSurface partSurface_609 = 
      ((PartSurface) cadPart_457.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_590 = 
      ((PartCurve) cadPart_457.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_458 = 
      ((CadPart) compositePart_106.getChildParts().getPart("TRM_SRF 83"));

    PartSurface partSurface_610 = 
      ((PartSurface) cadPart_458.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_591 = 
      ((PartCurve) cadPart_458.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_459 = 
      ((CadPart) compositePart_107.getChildParts().getPart("Body 1"));

    PartSurface partSurface_611 = 
      ((PartSurface) cadPart_459.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_592 = 
      ((PartCurve) cadPart_459.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_460 = 
      ((CadPart) compositePart_107.getChildParts().getPart("Body 93"));

    PartSurface partSurface_612 = 
      ((PartSurface) cadPart_460.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_593 = 
      ((PartCurve) cadPart_460.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_461 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body"));

    PartSurface partSurface_613 = 
      ((PartSurface) cadPart_461.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_594 = 
      ((PartCurve) cadPart_461.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_462 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 2"));

    PartSurface partSurface_614 = 
      ((PartSurface) cadPart_462.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_595 = 
      ((PartCurve) cadPart_462.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_463 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 3"));

    PartSurface partSurface_615 = 
      ((PartSurface) cadPart_463.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_596 = 
      ((PartCurve) cadPart_463.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_464 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 4"));

    PartSurface partSurface_616 = 
      ((PartSurface) cadPart_464.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_597 = 
      ((PartCurve) cadPart_464.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_465 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 5"));

    PartSurface partSurface_617 = 
      ((PartSurface) cadPart_465.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_598 = 
      ((PartCurve) cadPart_465.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_466 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 6"));

    PartSurface partSurface_618 = 
      ((PartSurface) cadPart_466.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_599 = 
      ((PartCurve) cadPart_466.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_467 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 7"));

    PartSurface partSurface_619 = 
      ((PartSurface) cadPart_467.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_600 = 
      ((PartCurve) cadPart_467.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_468 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 8"));

    PartSurface partSurface_620 = 
      ((PartSurface) cadPart_468.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_601 = 
      ((PartCurve) cadPart_468.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_469 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 9"));

    PartSurface partSurface_621 = 
      ((PartSurface) cadPart_469.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_602 = 
      ((PartCurve) cadPart_469.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_470 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 10"));

    PartSurface partSurface_622 = 
      ((PartSurface) cadPart_470.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_603 = 
      ((PartCurve) cadPart_470.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_471 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 11"));

    PartSurface partSurface_623 = 
      ((PartSurface) cadPart_471.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_604 = 
      ((PartCurve) cadPart_471.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_472 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 12"));

    PartSurface partSurface_624 = 
      ((PartSurface) cadPart_472.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_605 = 
      ((PartCurve) cadPart_472.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_473 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 13"));

    PartSurface partSurface_625 = 
      ((PartSurface) cadPart_473.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_606 = 
      ((PartCurve) cadPart_473.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_474 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 14"));

    PartSurface partSurface_626 = 
      ((PartSurface) cadPart_474.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_607 = 
      ((PartCurve) cadPart_474.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_475 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 15"));

    PartSurface partSurface_627 = 
      ((PartSurface) cadPart_475.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_608 = 
      ((PartCurve) cadPart_475.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_476 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 16"));

    PartSurface partSurface_628 = 
      ((PartSurface) cadPart_476.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_609 = 
      ((PartCurve) cadPart_476.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_477 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 17"));

    PartSurface partSurface_629 = 
      ((PartSurface) cadPart_477.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_610 = 
      ((PartCurve) cadPart_477.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_478 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 18"));

    PartSurface partSurface_630 = 
      ((PartSurface) cadPart_478.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_611 = 
      ((PartCurve) cadPart_478.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_479 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 19"));

    PartSurface partSurface_631 = 
      ((PartSurface) cadPart_479.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_612 = 
      ((PartCurve) cadPart_479.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_480 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 20"));

    PartSurface partSurface_632 = 
      ((PartSurface) cadPart_480.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_613 = 
      ((PartCurve) cadPart_480.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_481 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 21"));

    PartSurface partSurface_633 = 
      ((PartSurface) cadPart_481.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_614 = 
      ((PartCurve) cadPart_481.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_482 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 22"));

    PartSurface partSurface_634 = 
      ((PartSurface) cadPart_482.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_615 = 
      ((PartCurve) cadPart_482.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_483 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 23"));

    PartSurface partSurface_635 = 
      ((PartSurface) cadPart_483.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_616 = 
      ((PartCurve) cadPart_483.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_484 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 24"));

    PartSurface partSurface_636 = 
      ((PartSurface) cadPart_484.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_617 = 
      ((PartCurve) cadPart_484.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_485 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 25"));

    PartSurface partSurface_637 = 
      ((PartSurface) cadPart_485.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_618 = 
      ((PartCurve) cadPart_485.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_486 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 27"));

    PartSurface partSurface_639 = 
      ((PartSurface) cadPart_486.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_620 = 
      ((PartCurve) cadPart_486.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_487 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 28"));

    PartSurface partSurface_640 = 
      ((PartSurface) cadPart_487.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_621 = 
      ((PartCurve) cadPart_487.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_488 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 29"));

    PartSurface partSurface_641 = 
      ((PartSurface) cadPart_488.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_622 = 
      ((PartCurve) cadPart_488.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_489 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 30"));

    PartSurface partSurface_642 = 
      ((PartSurface) cadPart_489.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_623 = 
      ((PartCurve) cadPart_489.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_490 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 31"));

    PartSurface partSurface_643 = 
      ((PartSurface) cadPart_490.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_624 = 
      ((PartCurve) cadPart_490.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_491 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 32"));

    PartSurface partSurface_644 = 
      ((PartSurface) cadPart_491.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_625 = 
      ((PartCurve) cadPart_491.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_492 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 33"));

    PartSurface partSurface_645 = 
      ((PartSurface) cadPart_492.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_626 = 
      ((PartCurve) cadPart_492.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_493 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 34"));

    PartSurface partSurface_646 = 
      ((PartSurface) cadPart_493.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_627 = 
      ((PartCurve) cadPart_493.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_494 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 35"));

    PartSurface partSurface_647 = 
      ((PartSurface) cadPart_494.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_628 = 
      ((PartCurve) cadPart_494.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_495 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 36"));

    PartSurface partSurface_648 = 
      ((PartSurface) cadPart_495.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_629 = 
      ((PartCurve) cadPart_495.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_496 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 37"));

    PartSurface partSurface_649 = 
      ((PartSurface) cadPart_496.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_630 = 
      ((PartCurve) cadPart_496.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_497 = 
      ((CadPart) compositePart_107.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 38"));

    PartSurface partSurface_650 = 
      ((PartSurface) cadPart_497.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_631 = 
      ((PartCurve) cadPart_497.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_498 = 
      ((CadPart) compositePart_107.getChildParts().getPart("DE    54825"));

    PartSurface partSurface_651 = 
      ((PartSurface) cadPart_498.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_632 = 
      ((PartCurve) cadPart_498.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_499 = 
      ((CadPart) compositePart_107.getChildParts().getPart("DE    82055"));

    PartSurface partSurface_652 = 
      ((PartSurface) cadPart_499.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_633 = 
      ((PartCurve) cadPart_499.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_500 = 
      ((CadPart) compositePart_107.getChildParts().getPart("DE    82073"));

    PartSurface partSurface_653 = 
      ((PartSurface) cadPart_500.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_634 = 
      ((PartCurve) cadPart_500.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_501 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 3"));

    PartSurface partSurface_654 = 
      ((PartSurface) cadPart_501.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_635 = 
      ((PartCurve) cadPart_501.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_502 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 4"));

    PartSurface partSurface_655 = 
      ((PartSurface) cadPart_502.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_636 = 
      ((PartCurve) cadPart_502.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_503 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 5"));

    PartSurface partSurface_656 = 
      ((PartSurface) cadPart_503.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_637 = 
      ((PartCurve) cadPart_503.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_504 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 6"));

    PartSurface partSurface_657 = 
      ((PartSurface) cadPart_504.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_638 = 
      ((PartCurve) cadPart_504.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_505 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 7"));

    PartSurface partSurface_658 = 
      ((PartSurface) cadPart_505.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_639 = 
      ((PartCurve) cadPart_505.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_506 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 8"));

    PartSurface partSurface_659 = 
      ((PartSurface) cadPart_506.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_640 = 
      ((PartCurve) cadPart_506.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_507 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 9"));

    PartSurface partSurface_660 = 
      ((PartSurface) cadPart_507.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_641 = 
      ((PartCurve) cadPart_507.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_508 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 10"));

    PartSurface partSurface_661 = 
      ((PartSurface) cadPart_508.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_642 = 
      ((PartCurve) cadPart_508.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_509 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 11"));

    PartSurface partSurface_662 = 
      ((PartSurface) cadPart_509.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_643 = 
      ((PartCurve) cadPart_509.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_510 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 12"));

    PartSurface partSurface_663 = 
      ((PartSurface) cadPart_510.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_644 = 
      ((PartCurve) cadPart_510.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_511 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 13"));

    PartSurface partSurface_664 = 
      ((PartSurface) cadPart_511.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_645 = 
      ((PartCurve) cadPart_511.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_512 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 14"));

    PartSurface partSurface_665 = 
      ((PartSurface) cadPart_512.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_646 = 
      ((PartCurve) cadPart_512.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_513 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 15"));

    PartSurface partSurface_666 = 
      ((PartSurface) cadPart_513.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_647 = 
      ((PartCurve) cadPart_513.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_514 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 16"));

    PartSurface partSurface_667 = 
      ((PartSurface) cadPart_514.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_648 = 
      ((PartCurve) cadPart_514.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_515 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 17"));

    PartSurface partSurface_668 = 
      ((PartSurface) cadPart_515.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_649 = 
      ((PartCurve) cadPart_515.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_516 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 18"));

    PartSurface partSurface_669 = 
      ((PartSurface) cadPart_516.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_650 = 
      ((PartCurve) cadPart_516.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_517 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 19"));

    PartSurface partSurface_670 = 
      ((PartSurface) cadPart_517.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_651 = 
      ((PartCurve) cadPart_517.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_518 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 20"));

    PartSurface partSurface_671 = 
      ((PartSurface) cadPart_518.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_652 = 
      ((PartCurve) cadPart_518.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_519 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 21"));

    PartSurface partSurface_672 = 
      ((PartSurface) cadPart_519.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_653 = 
      ((PartCurve) cadPart_519.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_520 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 22"));

    PartSurface partSurface_673 = 
      ((PartSurface) cadPart_520.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_654 = 
      ((PartCurve) cadPart_520.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_521 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 23"));

    PartSurface partSurface_674 = 
      ((PartSurface) cadPart_521.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_655 = 
      ((PartCurve) cadPart_521.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_522 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 24"));

    PartSurface partSurface_675 = 
      ((PartSurface) cadPart_522.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_656 = 
      ((PartCurve) cadPart_522.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_523 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 25"));

    PartSurface partSurface_676 = 
      ((PartSurface) cadPart_523.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_657 = 
      ((PartCurve) cadPart_523.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_524 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 27"));

    PartSurface partSurface_677 = 
      ((PartSurface) cadPart_524.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_658 = 
      ((PartCurve) cadPart_524.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_525 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 28"));

    PartSurface partSurface_678 = 
      ((PartSurface) cadPart_525.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_659 = 
      ((PartCurve) cadPart_525.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_526 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 29"));

    PartSurface partSurface_679 = 
      ((PartSurface) cadPart_526.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_660 = 
      ((PartCurve) cadPart_526.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_527 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 30"));

    PartSurface partSurface_680 = 
      ((PartSurface) cadPart_527.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_661 = 
      ((PartCurve) cadPart_527.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_528 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 31"));

    PartSurface partSurface_681 = 
      ((PartSurface) cadPart_528.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_662 = 
      ((PartCurve) cadPart_528.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_529 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 32"));

    PartSurface partSurface_682 = 
      ((PartSurface) cadPart_529.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_663 = 
      ((PartCurve) cadPart_529.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_530 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 33"));

    PartSurface partSurface_683 = 
      ((PartSurface) cadPart_530.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_664 = 
      ((PartCurve) cadPart_530.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_531 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 34"));

    PartSurface partSurface_684 = 
      ((PartSurface) cadPart_531.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_665 = 
      ((PartCurve) cadPart_531.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_532 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 35"));

    PartSurface partSurface_685 = 
      ((PartSurface) cadPart_532.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_666 = 
      ((PartCurve) cadPart_532.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_533 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 36"));

    PartSurface partSurface_686 = 
      ((PartSurface) cadPart_533.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_667 = 
      ((PartCurve) cadPart_533.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_534 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 37"));

    PartSurface partSurface_687 = 
      ((PartSurface) cadPart_534.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_668 = 
      ((PartCurve) cadPart_534.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_535 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 38"));

    PartSurface partSurface_688 = 
      ((PartSurface) cadPart_535.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_669 = 
      ((PartCurve) cadPart_535.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_536 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 39"));

    PartSurface partSurface_689 = 
      ((PartSurface) cadPart_536.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_670 = 
      ((PartCurve) cadPart_536.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_537 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 40"));

    PartSurface partSurface_690 = 
      ((PartSurface) cadPart_537.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_671 = 
      ((PartCurve) cadPart_537.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_538 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 41"));

    PartSurface partSurface_691 = 
      ((PartSurface) cadPart_538.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_672 = 
      ((PartCurve) cadPart_538.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_539 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 42"));

    PartSurface partSurface_692 = 
      ((PartSurface) cadPart_539.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_673 = 
      ((PartCurve) cadPart_539.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_540 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 43"));

    PartSurface partSurface_693 = 
      ((PartSurface) cadPart_540.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_674 = 
      ((PartCurve) cadPart_540.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_541 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 44"));

    PartSurface partSurface_694 = 
      ((PartSurface) cadPart_541.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_675 = 
      ((PartCurve) cadPart_541.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_542 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 45"));

    PartSurface partSurface_695 = 
      ((PartSurface) cadPart_542.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_676 = 
      ((PartCurve) cadPart_542.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_543 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 46"));

    PartSurface partSurface_696 = 
      ((PartSurface) cadPart_543.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_677 = 
      ((PartCurve) cadPart_543.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_544 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 47"));

    PartSurface partSurface_697 = 
      ((PartSurface) cadPart_544.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_678 = 
      ((PartCurve) cadPart_544.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_545 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 48"));

    PartSurface partSurface_698 = 
      ((PartSurface) cadPart_545.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_679 = 
      ((PartCurve) cadPart_545.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_546 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 49"));

    PartSurface partSurface_699 = 
      ((PartSurface) cadPart_546.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_680 = 
      ((PartCurve) cadPart_546.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_547 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 50"));

    PartSurface partSurface_700 = 
      ((PartSurface) cadPart_547.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_681 = 
      ((PartCurve) cadPart_547.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_548 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 51"));

    PartSurface partSurface_701 = 
      ((PartSurface) cadPart_548.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_682 = 
      ((PartCurve) cadPart_548.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_549 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 52"));

    PartSurface partSurface_702 = 
      ((PartSurface) cadPart_549.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_683 = 
      ((PartCurve) cadPart_549.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_550 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 53"));

    PartSurface partSurface_703 = 
      ((PartSurface) cadPart_550.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_684 = 
      ((PartCurve) cadPart_550.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_551 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 54"));

    PartSurface partSurface_704 = 
      ((PartSurface) cadPart_551.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_685 = 
      ((PartCurve) cadPart_551.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_552 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 55"));

    PartSurface partSurface_705 = 
      ((PartSurface) cadPart_552.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_686 = 
      ((PartCurve) cadPart_552.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_553 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 56"));

    PartSurface partSurface_706 = 
      ((PartSurface) cadPart_553.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_687 = 
      ((PartCurve) cadPart_553.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_554 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 57"));

    PartSurface partSurface_707 = 
      ((PartSurface) cadPart_554.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_688 = 
      ((PartCurve) cadPart_554.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_555 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 58"));

    PartSurface partSurface_708 = 
      ((PartSurface) cadPart_555.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_689 = 
      ((PartCurve) cadPart_555.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_556 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 59"));

    PartSurface partSurface_709 = 
      ((PartSurface) cadPart_556.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_690 = 
      ((PartCurve) cadPart_556.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_557 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 61"));

    PartSurface partSurface_710 = 
      ((PartSurface) cadPart_557.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_691 = 
      ((PartCurve) cadPart_557.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_558 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 64"));

    PartSurface partSurface_711 = 
      ((PartSurface) cadPart_558.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_692 = 
      ((PartCurve) cadPart_558.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_559 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 65"));

    PartSurface partSurface_712 = 
      ((PartSurface) cadPart_559.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_693 = 
      ((PartCurve) cadPart_559.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_560 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 66"));

    PartSurface partSurface_713 = 
      ((PartSurface) cadPart_560.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_694 = 
      ((PartCurve) cadPart_560.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_561 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 67"));

    PartSurface partSurface_714 = 
      ((PartSurface) cadPart_561.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_695 = 
      ((PartCurve) cadPart_561.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_562 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 68"));

    PartSurface partSurface_715 = 
      ((PartSurface) cadPart_562.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_696 = 
      ((PartCurve) cadPart_562.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_563 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 69"));

    PartSurface partSurface_716 = 
      ((PartSurface) cadPart_563.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_697 = 
      ((PartCurve) cadPart_563.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_564 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 70"));

    PartSurface partSurface_717 = 
      ((PartSurface) cadPart_564.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_698 = 
      ((PartCurve) cadPart_564.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_565 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 71"));

    PartSurface partSurface_718 = 
      ((PartSurface) cadPart_565.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_699 = 
      ((PartCurve) cadPart_565.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_566 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 72"));

    PartSurface partSurface_719 = 
      ((PartSurface) cadPart_566.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_700 = 
      ((PartCurve) cadPart_566.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_567 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 73"));

    PartSurface partSurface_720 = 
      ((PartSurface) cadPart_567.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_701 = 
      ((PartCurve) cadPart_567.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_568 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 74"));

    PartSurface partSurface_721 = 
      ((PartSurface) cadPart_568.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_702 = 
      ((PartCurve) cadPart_568.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_569 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 75"));

    PartSurface partSurface_722 = 
      ((PartSurface) cadPart_569.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_703 = 
      ((PartCurve) cadPart_569.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_570 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 76"));

    PartSurface partSurface_723 = 
      ((PartSurface) cadPart_570.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_704 = 
      ((PartCurve) cadPart_570.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_571 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 77"));

    PartSurface partSurface_724 = 
      ((PartSurface) cadPart_571.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_705 = 
      ((PartCurve) cadPart_571.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_572 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 78"));

    PartSurface partSurface_725 = 
      ((PartSurface) cadPart_572.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_706 = 
      ((PartCurve) cadPart_572.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_573 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 79"));

    PartSurface partSurface_726 = 
      ((PartSurface) cadPart_573.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_707 = 
      ((PartCurve) cadPart_573.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_574 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 80"));

    PartSurface partSurface_727 = 
      ((PartSurface) cadPart_574.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_708 = 
      ((PartCurve) cadPart_574.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_575 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 81"));

    PartSurface partSurface_728 = 
      ((PartSurface) cadPart_575.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_709 = 
      ((PartCurve) cadPart_575.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_576 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 82"));

    PartSurface partSurface_729 = 
      ((PartSurface) cadPart_576.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_710 = 
      ((PartCurve) cadPart_576.getPartCurveManager().getPartCurve("Edges"));

    CadPart cadPart_577 = 
      ((CadPart) compositePart_107.getChildParts().getPart("TRM_SRF 83"));

    PartSurface partSurface_730 = 
      ((PartSurface) cadPart_577.getPartSurfaceManager().getPartSurface("Faces"));

    PartCurve partCurve_711 = 
      ((PartCurve) cadPart_577.getPartCurveManager().getPartCurve("Edges"));

    partDisplayer_12.getInputParts().setObjects(partSurface_490, partCurve_471, partSurface_491, partCurve_472, partSurface_492, partCurve_473, partSurface_493, partCurve_474, partSurface_494, partCurve_475, partSurface_495, partCurve_476, partSurface_496, partCurve_477, partSurface_497, partCurve_478, partSurface_498, partCurve_479, partSurface_499, partCurve_480, partSurface_500, partCurve_481, partSurface_501, partCurve_482, partSurface_502, partCurve_483, partSurface_503, partCurve_484, partSurface_504, partCurve_485, partSurface_505, partCurve_486, partSurface_506, partCurve_487, partSurface_507, partCurve_488, partSurface_508, partCurve_489, partSurface_509, partCurve_490, partSurface_510, partCurve_491, partSurface_511, partCurve_492, partSurface_512, partCurve_493, partSurface_513, partCurve_494, partSurface_514, partCurve_495, partSurface_515, partCurve_496, partSurface_516, partCurve_497, partSurface_517, partCurve_498, partSurface_519, partCurve_500, partSurface_520, partCurve_501, partSurface_521, partCurve_502, partSurface_522, partCurve_503, partSurface_523, partCurve_504, partSurface_524, partCurve_505, partSurface_525, partCurve_506, partSurface_526, partCurve_507, partSurface_527, partCurve_508, partSurface_528, partCurve_509, partSurface_529, partCurve_510, partSurface_530, partCurve_511, partSurface_531, partCurve_512, partSurface_532, partCurve_513, partSurface_533, partCurve_514, partSurface_534, partCurve_515, partSurface_535, partCurve_516, partSurface_536, partCurve_517, partSurface_537, partCurve_518, partSurface_538, partCurve_519, partSurface_539, partCurve_520, partSurface_540, partCurve_521, partSurface_541, partCurve_522, partSurface_542, partCurve_523, partSurface_543, partCurve_524, partSurface_544, partCurve_525, partSurface_545, partCurve_526, partSurface_546, partCurve_527, partSurface_547, partCurve_528, partSurface_548, partCurve_529, partSurface_549, partCurve_530, partSurface_550, partCurve_531, partSurface_551, partCurve_532, partSurface_552, partCurve_533, partSurface_553, partCurve_534, partSurface_554, partCurve_535, partSurface_555, partCurve_536, partSurface_556, partCurve_537, partSurface_557, partCurve_538, partSurface_558, partCurve_539, partSurface_559, partCurve_540, partSurface_560, partCurve_541, partSurface_561, partCurve_542, partSurface_562, partCurve_543, partSurface_563, partCurve_544, partSurface_564, partCurve_545, partSurface_565, partCurve_546, partSurface_566, partCurve_547, partSurface_567, partCurve_548, partSurface_568, partCurve_549, partSurface_569, partCurve_550, partSurface_570, partCurve_551, partSurface_571, partCurve_552, partSurface_572, partCurve_553, partSurface_573, partCurve_554, partSurface_574, partCurve_555, partSurface_575, partCurve_556, partSurface_576, partCurve_557, partSurface_577, partCurve_558, partSurface_578, partCurve_559, partSurface_579, partCurve_560, partSurface_580, partCurve_561, partSurface_581, partCurve_562, partSurface_582, partCurve_563, partSurface_583, partCurve_564, partSurface_584, partCurve_565, partSurface_585, partCurve_566, partSurface_586, partCurve_567, partSurface_587, partCurve_568, partSurface_588, partCurve_569, partSurface_589, partCurve_570, partSurface_590, partCurve_571, partSurface_591, partCurve_572, partSurface_592, partCurve_573, partSurface_593, partCurve_574, partSurface_594, partCurve_575, partSurface_595, partCurve_576, partSurface_596, partCurve_577, partSurface_597, partCurve_578, partSurface_598, partCurve_579, partSurface_599, partCurve_580, partSurface_600, partCurve_581, partSurface_601, partCurve_582, partSurface_602, partCurve_583, partSurface_603, partCurve_584, partSurface_604, partCurve_585, partSurface_605, partCurve_586, partSurface_606, partCurve_587, partSurface_607, partCurve_588, partSurface_608, partCurve_589, partSurface_609, partCurve_590, partSurface_610, partCurve_591, partSurface_611, partCurve_592, partSurface_612, partCurve_593, partSurface_613, partCurve_594, partSurface_614, partCurve_595, partSurface_615, partCurve_596, partSurface_616, partCurve_597, partSurface_617, partCurve_598, partSurface_618, partCurve_599, partSurface_619, partCurve_600, partSurface_620, partCurve_601, partSurface_621, partCurve_602, partSurface_622, partCurve_603, partSurface_623, partCurve_604, partSurface_624, partCurve_605, partSurface_625, partCurve_606, partSurface_626, partCurve_607, partSurface_627, partCurve_608, partSurface_628, partCurve_609, partSurface_629, partCurve_610, partSurface_630, partCurve_611, partSurface_631, partCurve_612, partSurface_632, partCurve_613, partSurface_633, partCurve_614, partSurface_634, partCurve_615, partSurface_635, partCurve_616, partSurface_636, partCurve_617, partSurface_637, partCurve_618, partSurface_639, partCurve_620, partSurface_640, partCurve_621, partSurface_641, partCurve_622, partSurface_642, partCurve_623, partSurface_643, partCurve_624, partSurface_644, partCurve_625, partSurface_645, partCurve_626, partSurface_646, partCurve_627, partSurface_647, partCurve_628, partSurface_648, partCurve_629, partSurface_649, partCurve_630, partSurface_650, partCurve_631, partSurface_651, partCurve_632, partSurface_652, partCurve_633, partSurface_653, partCurve_634, partSurface_654, partCurve_635, partSurface_655, partCurve_636, partSurface_656, partCurve_637, partSurface_657, partCurve_638, partSurface_658, partCurve_639, partSurface_659, partCurve_640, partSurface_660, partCurve_641, partSurface_661, partCurve_642, partSurface_662, partCurve_643, partSurface_663, partCurve_644, partSurface_664, partCurve_645, partSurface_665, partCurve_646, partSurface_666, partCurve_647, partSurface_667, partCurve_648, partSurface_668, partCurve_649, partSurface_669, partCurve_650, partSurface_670, partCurve_651, partSurface_671, partCurve_652, partSurface_672, partCurve_653, partSurface_673, partCurve_654, partSurface_674, partCurve_655, partSurface_675, partCurve_656, partSurface_676, partCurve_657, partSurface_677, partCurve_658, partSurface_678, partCurve_659, partSurface_679, partCurve_660, partSurface_680, partCurve_661, partSurface_681, partCurve_662, partSurface_682, partCurve_663, partSurface_683, partCurve_664, partSurface_684, partCurve_665, partSurface_685, partCurve_666, partSurface_686, partCurve_667, partSurface_687, partCurve_668, partSurface_688, partCurve_669, partSurface_689, partCurve_670, partSurface_690, partCurve_671, partSurface_691, partCurve_672, partSurface_692, partCurve_673, partSurface_693, partCurve_674, partSurface_694, partCurve_675, partSurface_695, partCurve_676, partSurface_696, partCurve_677, partSurface_697, partCurve_678, partSurface_698, partCurve_679, partSurface_699, partCurve_680, partSurface_700, partCurve_681, partSurface_701, partCurve_682, partSurface_702, partCurve_683, partSurface_703, partCurve_684, partSurface_704, partCurve_685, partSurface_705, partCurve_686, partSurface_706, partCurve_687, partSurface_707, partCurve_688, partSurface_708, partCurve_689, partSurface_709, partCurve_690, partSurface_710, partCurve_691, partSurface_711, partCurve_692, partSurface_712, partCurve_693, partSurface_713, partCurve_694, partSurface_714, partCurve_695, partSurface_715, partCurve_696, partSurface_716, partCurve_697, partSurface_717, partCurve_698, partSurface_718, partCurve_699, partSurface_719, partCurve_700, partSurface_720, partCurve_701, partSurface_721, partCurve_702, partSurface_722, partCurve_703, partSurface_723, partCurve_704, partSurface_724, partCurve_705, partSurface_725, partCurve_706, partSurface_726, partCurve_707, partSurface_727, partCurve_708, partSurface_728, partCurve_709, partSurface_729, partCurve_710, partSurface_730, partCurve_711);
  }

  private void execute11() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Scene scene_1 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 2");

    CurrentView currentView_0 = 
      scene_1.getCurrentView();

    currentView_0.setInput(new DoubleVector(new double[] {0.046669231492960095, 0.4893718823651316, 0.39425940987488045}), new DoubleVector(new double[] {0.7058873538262117, 1.50002656510811, 0.711867527538246}), new DoubleVector(new double[] {-7.381958866814132E-4, -0.2993657423761401, 0.9541381489902392}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.3263866246069327, 0.6997305940921845, 0.6828936972434596}), new DoubleVector(new double[] {1.6302172614648913, 3.699421914368033, 1.6255760298659048}), new DoubleVector(new double[] {-7.381958866814132E-4, -0.2993657423761401, 0.9541381489902392}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.67651328884423, 0.15750131161798353, 0.5527956948508719}), new DoubleVector(new double[] {2.602713875368978, 3.1105809930187744, 1.480829864122278}), new DoubleVector(new double[] {-7.381958866814132E-4, -0.2993657423761401, 0.9541381489902392}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.04313594460092, 0.7177384913226235, 0.7294699868732336}), new DoubleVector(new double[] {1.862340204501359, 3.5247606582836277, 1.092681376776066}), new DoubleVector(new double[] {0.06864461058538943, -0.1476993958725843, 0.9866472550494217}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.338993454062199, 0.6146328589134615, 0.44329442378732664}), new DoubleVector(new double[] {1.7460798777305642, 2.0095238171768575, 0.6237847275964522}), new DoubleVector(new double[] {0.06864461058538943, -0.1476993958725843, 0.9866472550494217}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.142298590323375, -0.016399574562809528, 0.34124582283428473}), new DoubleVector(new double[] {2.1565984336479023, 1.321869023004308, 1.5294580344930913}), new DoubleVector(new double[] {-0.14549619533463184, -0.5929247743636655, 0.7920044627961683}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.2186739366356967, 0.20218149229950844, 0.7923672103949966}), new DoubleVector(new double[] {2.609415842605244, 2.0371282610768313, 2.421566432710109}), new DoubleVector(new double[] {-0.14549619533463184, -0.5929247743636655, 0.7920044627961683}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.115731583169921, 0.37332716822944084, 0.723018300562261}), new DoubleVector(new double[] {2.4963527592790573, 2.1949206322164816, 2.340361487514473}), new DoubleVector(new double[] {-0.14549619533463184, -0.5929247743636655, 0.7920044627961683}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.0065389512455245, 0.2280665148755535, 0.5949529328129559}), new DoubleVector(new double[] {2.118741234255892, 2.6423580145732606, 2.0174364000956917}), new DoubleVector(new double[] {-0.07794748619796399, -0.4791896087782977, 0.8742433918734671}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.0945630722158484, 0.37689267432517687, 0.6896770095391542}), new DoubleVector(new double[] {2.785004045970559, 2.3382785686497805, 2.129794225108851}), new DoubleVector(new double[] {-0.10810632101575399, -0.5261490170070612, 0.8434928780132366}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.8526317866881253, 0.3783114886923635, 0.3618446513430853}), new DoubleVector(new double[] {2.7122032129741944, 2.5359361686628947, 1.9460471559876826}), new DoubleVector(new double[] {-0.10810632101575399, -0.5261490170070612, 0.8434928780132366}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.8417345136728902, 0.36629853093553744, 0.3501307070907363}), new DoubleVector(new double[] {2.6176107938602127, 2.342083091104546, 2.189411644568917}), new DoubleVector(new double[] {-0.16369059419736806, -0.5893411398580322, 0.7911273034362175}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.8506861381983968, -0.08022508216875313, 0.7592330286879672}), new DoubleVector(new double[] {4.65245073710339, 4.149499634420901, 4.696733198918156}), new DoubleVector(new double[] {-0.16369059419736806, -0.5893411398580322, 0.7911273034362175}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.111017993516282, 0.226469550348174, 1.0309678742749897}), new DoubleVector(new double[] {3.834442504425385, 5.314084716098489, 4.105945762090277}), new DoubleVector(new double[] {-0.08792392476917814, -0.48036713578345497, 0.8726492985801885}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.7657657052900719, 0.028174776797982304, 0.8580366137995397}), new DoubleVector(new double[] {2.1086862718287454, 2.5368777033349432, 2.3743081427725796}), new DoubleVector(new double[] {-0.08792392476917814, -0.48036713578345497, 0.8726492985801885}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.7590085566010316, 0.015166382012723828, 0.8497039690450214}), new DoubleVector(new double[] {2.337828074483817, 2.6138082690815176, 1.9923171828131214}), new DoubleVector(new double[] {-0.033475805644825884, -0.38516690875345044, 0.9222395691130684}), 1.5102818616783267, 0, 30.0);

    SolidModelCompositePart solidModelCompositePart_4 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("z_000_remaining-parts"));

    CompositePart compositePart_109 = 
      ((CompositePart) solidModelCompositePart_4.getChildParts().getPart("C_P002_FAHRER_GERADEAUS"));

    MeshPart meshPart_0 = 
      ((MeshPart) compositePart_109.getChildParts().getPart("driver"));

    PartSurface partSurface_732 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface"));

    meshPart_0.getPartSurfaceManager().splitNonContiguousPartSurfaces(new ArrayList<>(Arrays.<PartSurface>asList(partSurface_732)));

    PartSurface partSurface_733 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 5"));

    partSurface_733.setPresentationName("face");

    meshPart_0.getPartSurfaceManager().splitPartSurfacesByAngle(new ArrayList<>(Arrays.<PartSurface>asList(partSurface_732)), 89.0);

    PartSurface partSurface_734 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 104"));

    partSurface_734.setPresentationName("visor");

    partSurface_732.setPresentationName("helmet");

    PartDisplayer partDisplayer_14 = 
      ((PartDisplayer) scene_1.getDisplayerManager().getObject("driver"));

    partDisplayer_14.setPresentationName("helmet");

    partDisplayer_14.getInputParts().setQuery(null);

    partDisplayer_14.getInputParts().setObjects(partSurface_732);

    currentView_0.setInput(new DoubleVector(new double[] {0.6836866989837653, -0.10451571684564102, 0.7896049353527202}), new DoubleVector(new double[] {2.3415158955746698, 1.9433070261703198, 2.875551445466364}), new DoubleVector(new double[] {-0.19517204228321688, -0.6178585865815133, 0.761681456317939}), 1.5102818616783267, 0, 30.0);

    PresetColorSettings presetColorSettings_12 = 
      partDisplayer_14.getPresetColorSettings();

    RayTraceSimpleMetalMaterial rayTraceSimpleMetalMaterial_4 = 
      ((RayTraceSimpleMetalMaterial) simulation_0.get(RayTraceMaterialManager.class).getObject("Metallic White"));

    presetColorSettings_12.setRayTraceMaterial(rayTraceSimpleMetalMaterial_4);

    PartDisplayer partDisplayer_15 = 
      scene_1.getDisplayerManager().createPartDisplayer("Surface", -1, 1);

    partDisplayer_15.setPresentationName("visor");

    partDisplayer_15.setColorMode(PartColorMode.PRESET);

    PartRepresentation partRepresentation_0 = 
      ((PartRepresentation) simulation_0.getRepresentationManager().getObject("Geometry"));

    partDisplayer_15.setRepresentation(partRepresentation_0);

    partDisplayer_15.getInputParts().setQuery(null);

    partDisplayer_15.getInputParts().setObjects(partSurface_734);

    PresetColorSettings presetColorSettings_13 = 
      partDisplayer_15.getPresetColorSettings();

    RayTraceThinFresnelMaterial rayTraceThinFresnelMaterial_0 = 
      ((RayTraceThinFresnelMaterial) simulation_0.get(RayTraceMaterialManager.class).getObject("Tinted Glass Sheet"));

    presetColorSettings_13.setRayTraceMaterial(rayTraceThinFresnelMaterial_0);

    currentView_0.setInput(new DoubleVector(new double[] {1.068396052090334, 0.3290786608473572, 1.1527531934025856}), new DoubleVector(new double[] {3.2739108695571484, 2.263806084811157, 1.6336737347912682}), new DoubleVector(new double[] {0.08572220953822014, -0.3312860147708, 0.9396282665018644}), 1.5102818616783267, 0, 30.0);

    PartDisplayer partDisplayer_16 = 
      scene_1.getDisplayerManager().createPartDisplayer("Surface", -1, 1);

    partDisplayer_16.setPresentationName("face");

    partDisplayer_16.setColorMode(PartColorMode.PRESET);

    partDisplayer_16.setRepresentation(partRepresentation_0);

    partDisplayer_16.getInputParts().setQuery(null);

    partDisplayer_16.getInputParts().setObjects(partSurface_733);

    PresetColorSettings presetColorSettings_14 = 
      partDisplayer_16.getPresetColorSettings();

    RayTraceSimpleMaterial rayTraceSimpleMaterial_0 = 
      ((RayTraceSimpleMaterial) simulation_0.get(RayTraceMaterialManager.class).getObject("Non-Physical Yellow"));

    presetColorSettings_14.setRayTraceMaterial(rayTraceSimpleMaterial_0);

    RayTraceSimpleMaterial rayTraceSimpleMaterial_1 = 
      ((RayTraceSimpleMaterial) simulation_0.get(RayTraceMaterialManager.class).getObject("Non-Physical Blue"));

    presetColorSettings_14.setRayTraceMaterial(rayTraceSimpleMaterial_1);

    currentView_0.setInput(new DoubleVector(new double[] {0.006006817503462658, -0.6620275036834735, 0.9134898079381153}), new DoubleVector(new double[] {2.3295073987466335, 2.5963213182759253, 1.5770100639999105}), new DoubleVector(new double[] {0.12788061607974702, -0.2846581469477107, 0.9500612019272738}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.6386623188312257, 0.22551752376458709, 1.0938181193102043}), new DoubleVector(new double[] {2.3682034582345213, 2.5146463992794637, 1.7219122416803}), new DoubleVector(new double[] {0.09496830258176141, -0.32949786827781136, 0.939367966403611}), 1.5102818616783267, 0, 30.0);

    PartDisplayer partDisplayer_17 = 
      scene_1.getDisplayerManager().createPartDisplayer("Surface", -1, 1);

    partDisplayer_17.setPresentationName("driver");

    partDisplayer_17.setColorMode(PartColorMode.PRESET);

    partDisplayer_17.setRepresentation(partRepresentation_0);

    partDisplayer_17.getInputParts().setQuery(null);

    PartSurface partSurface_735 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 2"));

    PartSurface partSurface_736 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 3"));

    PartSurface partSurface_737 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 4"));

    PartSurface partSurface_738 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 5"));

    PartSurface partSurface_739 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 6"));

    PartSurface partSurface_740 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 7"));

    PartSurface partSurface_741 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 8"));

    PartSurface partSurface_742 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 9"));

    PartSurface partSurface_743 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 10"));

    PartSurface partSurface_744 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 11"));

    PartSurface partSurface_745 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 12"));

    PartSurface partSurface_746 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 13"));

    PartSurface partSurface_747 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 14"));

    PartSurface partSurface_748 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 15"));

    PartSurface partSurface_749 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 16"));

    PartSurface partSurface_750 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 17"));

    PartSurface partSurface_751 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 18"));

    PartSurface partSurface_752 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 19"));

    PartSurface partSurface_753 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 20"));

    PartSurface partSurface_754 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 21"));

    PartSurface partSurface_755 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 22"));

    PartSurface partSurface_756 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 23"));

    PartSurface partSurface_757 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 24"));

    PartSurface partSurface_758 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 25"));

    PartSurface partSurface_759 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 26"));

    PartSurface partSurface_760 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 27"));

    PartSurface partSurface_761 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 28"));

    PartSurface partSurface_762 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 29"));

    PartSurface partSurface_763 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 30"));

    PartSurface partSurface_764 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 31"));

    PartSurface partSurface_765 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 32"));

    PartSurface partSurface_766 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 33"));

    PartSurface partSurface_767 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 34"));

    PartSurface partSurface_768 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 35"));

    PartSurface partSurface_769 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 36"));

    PartSurface partSurface_770 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 37"));

    PartSurface partSurface_771 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 38"));

    PartSurface partSurface_772 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 39"));

    PartSurface partSurface_773 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 40"));

    PartSurface partSurface_774 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 41"));

    PartSurface partSurface_775 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 42"));

    PartSurface partSurface_776 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 43"));

    PartSurface partSurface_777 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 44"));

    PartSurface partSurface_778 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 45"));

    PartSurface partSurface_779 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 46"));

    PartSurface partSurface_780 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 47"));

    PartSurface partSurface_781 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 48"));

    PartSurface partSurface_782 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 49"));

    PartSurface partSurface_783 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 50"));

    PartSurface partSurface_784 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 51"));

    PartSurface partSurface_785 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 52"));

    PartSurface partSurface_786 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 53"));

    PartSurface partSurface_787 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 54"));

    PartSurface partSurface_788 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 55"));

    PartSurface partSurface_789 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 56"));

    PartSurface partSurface_790 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 57"));

    PartSurface partSurface_791 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 58"));

    PartSurface partSurface_792 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 59"));

    PartSurface partSurface_793 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 60"));

    PartSurface partSurface_794 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 61"));

    PartSurface partSurface_795 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 62"));

    PartSurface partSurface_796 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 63"));

    PartSurface partSurface_797 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 64"));

    PartSurface partSurface_798 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 65"));

    PartSurface partSurface_799 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 66"));

    PartSurface partSurface_800 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 67"));

    PartSurface partSurface_801 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 68"));

    PartSurface partSurface_802 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 69"));

    PartSurface partSurface_803 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 70"));

    PartSurface partSurface_804 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 71"));

    PartSurface partSurface_805 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 72"));

    PartSurface partSurface_806 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 73"));

    PartSurface partSurface_807 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 74"));

    PartSurface partSurface_808 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 75"));

    PartSurface partSurface_809 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 76"));

    PartSurface partSurface_810 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 77"));

    PartSurface partSurface_811 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 78"));

    PartSurface partSurface_812 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 79"));

    PartSurface partSurface_813 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 80"));

    PartSurface partSurface_814 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 81"));

    PartSurface partSurface_815 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 82"));

    PartSurface partSurface_816 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 83"));

    PartSurface partSurface_817 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 84"));

    PartSurface partSurface_818 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 85"));

    PartSurface partSurface_819 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 86"));

    PartSurface partSurface_820 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 87"));

    PartSurface partSurface_821 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 88"));

    PartSurface partSurface_822 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 89"));

    PartSurface partSurface_823 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 90"));

    PartSurface partSurface_824 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 91"));

    PartSurface partSurface_825 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 92"));

    PartSurface partSurface_826 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 93"));

    PartSurface partSurface_827 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 94"));

    PartSurface partSurface_828 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 95"));

    PartSurface partSurface_829 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 96"));

    PartSurface partSurface_830 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 97"));

    PartSurface partSurface_831 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 98"));

    PartSurface partSurface_832 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 99"));

    PartSurface partSurface_833 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 100"));

    PartSurface partSurface_834 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 101"));

    PartSurface partSurface_835 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 102"));

    PartSurface partSurface_836 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 103"));

    PartSurface partSurface_837 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 105"));

    PartSurface partSurface_838 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 106"));

    PartSurface partSurface_839 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 107"));

    PartSurface partSurface_840 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 108"));

    PartSurface partSurface_841 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 109"));

    PartSurface partSurface_842 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 110"));

    PartSurface partSurface_843 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 111"));

    PartSurface partSurface_844 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 112"));

    PartSurface partSurface_845 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 113"));

    PartSurface partSurface_846 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 114"));

    partDisplayer_17.getInputParts().setObjects(partSurface_735, partSurface_736, partSurface_737, partSurface_738, partSurface_739, partSurface_740, partSurface_741, partSurface_742, partSurface_743, partSurface_744, partSurface_745, partSurface_746, partSurface_747, partSurface_748, partSurface_749, partSurface_750, partSurface_751, partSurface_752, partSurface_753, partSurface_754, partSurface_755, partSurface_756, partSurface_757, partSurface_758, partSurface_759, partSurface_760, partSurface_761, partSurface_762, partSurface_763, partSurface_764, partSurface_765, partSurface_766, partSurface_767, partSurface_768, partSurface_769, partSurface_770, partSurface_771, partSurface_772, partSurface_773, partSurface_774, partSurface_775, partSurface_776, partSurface_777, partSurface_778, partSurface_779, partSurface_780, partSurface_781, partSurface_782, partSurface_783, partSurface_784, partSurface_785, partSurface_786, partSurface_787, partSurface_788, partSurface_789, partSurface_790, partSurface_791, partSurface_792, partSurface_793, partSurface_794, partSurface_795, partSurface_796, partSurface_797, partSurface_798, partSurface_799, partSurface_800, partSurface_801, partSurface_802, partSurface_803, partSurface_804, partSurface_805, partSurface_806, partSurface_807, partSurface_808, partSurface_809, partSurface_810, partSurface_811, partSurface_812, partSurface_813, partSurface_814, partSurface_815, partSurface_816, partSurface_817, partSurface_818, partSurface_819, partSurface_820, partSurface_821, partSurface_822, partSurface_823, partSurface_824, partSurface_825, partSurface_826, partSurface_827, partSurface_828, partSurface_829, partSurface_830, partSurface_831, partSurface_832, partSurface_833, partSurface_834, partSurface_835, partSurface_836, partSurface_837, partSurface_838, partSurface_839, partSurface_840, partSurface_841, partSurface_842, partSurface_843, partSurface_844, partSurface_845, partSurface_846);

    PresetColorSettings presetColorSettings_15 = 
      partDisplayer_17.getPresetColorSettings();

    RayTraceMatteMaterial rayTraceMatteMaterial_0 = 
      ((RayTraceMatteMaterial) simulation_0.get(RayTraceMaterialManager.class).getObject("Matte White"));

    presetColorSettings_15.setRayTraceMaterial(rayTraceMatteMaterial_0);

    currentView_0.setInput(new DoubleVector(new double[] {0.9202448337824514, 0.5963079315474199, 1.1967406782046974}), new DoubleVector(new double[] {2.48804700615201, 2.4296096811473338, 1.8507125637249477}), new DoubleVector(new double[] {0.05619224107750923, -0.3777357232040344, 0.9242067709437916}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.07811564660200254, 0.7471747088796277, 1.5786044263787469}), new DoubleVector(new double[] {3.0055215893926617, 4.17032243203653, 2.7997031197148643}), new DoubleVector(new double[] {0.05619224107750923, -0.3777357232040344, 0.9242067709437916}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.4128392821679376, 0.32050576855228774, 0.9887446404127498}), new DoubleVector(new double[] {4.108182992605202, 3.472292663099966, 2.113044019189418}), new DoubleVector(new double[] {0.05619224107750923, -0.3777357232040344, 0.9242067709437916}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.3663068609144704, 0.24687061274533548, 0.965588778547703}), new DoubleVector(new double[] {2.9675850002655473, 4.100880006661629, 2.019674292239034}), new DoubleVector(new double[] {0.10271614500891874, -0.3019007959028739, 0.9477896934382951}), 1.5102818616783267, 0, 30.0);

    currentView_0.setRepresentation(null);

    VisView visView_0 = 
      ((VisView) simulation_0.getViewManager().getObject("View 1"));

    currentView_0.setView(visView_0);

    ScalarDisplayer scalarDisplayer_0 = 
      scene_1.getDisplayerManager().createScalarDisplayer("Scalar", ClipMode.NONE);

    scalarDisplayer_0.setFillMode(ScalarFillMode.NODE_FILLED);

    scalarDisplayer_0.getInputParts().setQuery(null);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Air");

    Boundary boundary_1 = 
      region_0.getBoundaryManager().getBoundary("floor");

    Boundary boundary_2 = 
      region_0.getBoundaryManager().getBoundary("Frontwing");

    Boundary boundary_3 = 
      region_0.getBoundaryManager().getBoundary("inlet");

    Boundary boundary_0 = 
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

    Region region_6 = 
      simulation_0.getRegionManager().getRegion("MRF-FL");

    Boundary boundary_13 = 
      region_6.getBoundaryManager().getBoundary("Default");

    Boundary boundary_14 = 
      region_6.getBoundaryManager().getBoundary("wheelhub");

    Region region_7 = 
      simulation_0.getRegionManager().getRegion("MRF-FR");

    Boundary boundary_15 = 
      region_7.getBoundaryManager().getBoundary("Default");

    Boundary boundary_16 = 
      region_7.getBoundaryManager().getBoundary("wheelhub");

    Region region_8 = 
      simulation_0.getRegionManager().getRegion("MRF-RL");

    Boundary boundary_17 = 
      region_8.getBoundaryManager().getBoundary("Default");

    Boundary boundary_18 = 
      region_8.getBoundaryManager().getBoundary("wheelhub");

    Region region_9 = 
      simulation_0.getRegionManager().getRegion("MRF-RR");

    Boundary boundary_19 = 
      region_9.getBoundaryManager().getBoundary("Default");

    Boundary boundary_20 = 
      region_9.getBoundaryManager().getBoundary("wheelhub");

    scalarDisplayer_0.getInputParts().setObjects(boundary_1, boundary_2, boundary_3, boundary_0, boundary_4, boundary_5, boundary_6, boundary_7, boundary_8, boundary_9, boundary_10, boundary_11, boundary_12, boundary_13, boundary_14, boundary_15, boundary_16, boundary_17, boundary_18, boundary_19, boundary_20);

    PrimitiveFieldFunction primitiveFieldFunction_0 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Velocity"));

    VectorMagnitudeFieldFunction vectorMagnitudeFieldFunction_0 = 
      ((VectorMagnitudeFieldFunction) primitiveFieldFunction_0.getMagnitudeFunction());

    scalarDisplayer_0.getScalarDisplayQuantity().setFieldFunction(vectorMagnitudeFieldFunction_0);

    scalarDisplayer_0.getInputParts().setQuery(null);

    scalarDisplayer_0.getInputParts().setObjects(boundary_2, boundary_0, boundary_5, boundary_6, boundary_7, boundary_9, boundary_10, boundary_11, boundary_12, boundary_13, boundary_14, boundary_15, boundary_16, boundary_17, boundary_18, boundary_19, boundary_20);

    currentView_0.setInput(new DoubleVector(new double[] {1.2695248782665969, 0.6683626459655075, 0.682119038889656}), new DoubleVector(new double[] {3.622450891238794, 4.577022911596859, 1.2827212749555301}), new DoubleVector(new double[] {-0.023924221498414805, -0.13774831566139165, 0.9901782835217848}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.2520771270982216, -1.2528456055509944, 0.4481229993003083}), new DoubleVector(new double[] {5.874686275874793, 3.2620205500886894, 2.420426097026682}), new DoubleVector(new double[] {-0.1285892145080412, -0.25814569578526103, 0.9575101115182826}), 1.5102818616783267, 0, 30.0);

    simulation_0.deleteObjects(new ArrayList<>(Arrays.<ClientServerObject>asList(scalarDisplayer_0)));

    currentView_0.setInput(new DoubleVector(new double[] {1.9511008418151348, 0.08626331173820365, 1.0338785440593437}), new DoubleVector(new double[] {4.586180920810295, 4.11233647947911, 2.7341962314955506}), new DoubleVector(new double[] {-0.16040029674549602, -0.2930762801933863, 0.9425380834703553}), 1.5102818616783267, 0, 30.0);
  }
  
    private void execute12() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 2");

    scene_0.closeInteractive();

    Units units_0 = 
      simulation_0.getUnitsManager().getPreferredUnits(Dimensions.Builder().length(1).build());

    Units units_1 = 
      simulation_0.getUnitsManager().getPreferredUnits(Dimensions.Builder().angle(1).build());

    ResampledVolumePart resampledVolumePart_0 = 
      simulation_0.getPartManager().createResampledVolumePart(new ArrayList<>(Collections.<NamedObject>emptyList()), 0.1, units_0, 0.001, units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 0.0, 0.0}), units_0, units_0, units_0, new DoubleVector(new double[] {1.0, 1.0, 1.0}), units_0, units_0, units_0, new DoubleVector(new double[] {1.0, 0.0, 0.0}), units_1, 0.0, RefinementMetric.DIAGONAL, null);

    resampledVolumePart_0.getOriginCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {-3.0, 0.0, 1.5775701245293021}));

    resampledVolumePart_0.getSizeCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {42.0, 15.0, 3.18538442440331}));

    resampledVolumePart_0.getInputParts().setQuery(null);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Air");

    resampledVolumePart_0.getInputParts().setObjects(region_0);

    ScalarDisplayer scalarDisplayer_0 = 
      scene_0.getDisplayerManager().createScalarDisplayer("Scalar", ClipMode.NONE);

    scalarDisplayer_0.setFillMode(ScalarFillMode.NODE_FILLED);

    scalarDisplayer_0.getInputParts().setQuery(null);

    scalarDisplayer_0.getInputParts().setObjects(resampledVolumePart_0);

    PrimitiveFieldFunction primitiveFieldFunction_0 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Velocity"));

    VectorMagnitudeFieldFunction vectorMagnitudeFieldFunction_0 = 
      ((VectorMagnitudeFieldFunction) primitiveFieldFunction_0.getMagnitudeFunction());

    scalarDisplayer_0.getScalarDisplayQuantity().setFieldFunction(vectorMagnitudeFieldFunction_0);

    scalarDisplayer_0.getScalarDisplayQuantity().setAutoRange(AutoRangeMode.NONE);

    Units units_2 = 
      ((Units) simulation_0.getUnitsManager().getObject("m/s"));

    scalarDisplayer_0.getScalarDisplayQuantity().getMinimumValue().setValueAndUnits(5.0, units_2);

    scalarDisplayer_0.getScalarDisplayQuantity().getMaximumValue().setValueAndUnits(14.0, units_2);

    Legend legend_0 = 
      scalarDisplayer_0.getLegend();

    CoolWarmBandLookupTable coolWarmBandLookupTable_0 = 
      ((CoolWarmBandLookupTable) simulation_0.get(LookupTableManager.class).getObject("cool-warm-band"));

    legend_0.setLookupTable(coolWarmBandLookupTable_0);

    simulation_0.get(LookupTableManager.class).importLookupTables(resolvePath("byuignite_inferno_starccm.colormap"));

    UserLookupTable userLookupTable_0 = 
      ((UserLookupTable) simulation_0.get(LookupTableManager.class).getObject("byu_inferno"));

    userLookupTable_0.setColorMap(new ColorMap(new DoubleVector(new double[] {0.0, 0.001369, 1.649E-4, 0.01265, 0.003876, 0.002159, 9.22E-4, 0.01699, 0.007752, 0.003208, 0.001853, 0.02241, 0.01163, 0.004497, 0.002952, 0.02888, 0.0155, 0.006021, 0.004211, 0.0364, 0.01938, 0.00778, 0.005617, 0.0448, 0.02326, 0.009777, 0.007157, 0.05329, 0.02713, 0.01202, 0.00882, 0.06182, 0.03101, 0.01452, 0.01059, 0.07041, 0.03488, 0.01728, 0.01245, 0.07904, 0.03876, 0.02033, 0.0144, 0.08773, 0.04264, 0.02368, 0.01641, 0.09648, 0.04651, 0.02734, 0.01847, 0.1053, 0.05039, 0.03135, 0.02056, 0.1142, 0.05426, 0.03572, 0.02267, 0.1231, 0.05814, 0.04049, 0.02478, 0.1321, 0.06202, 0.04541, 0.02687, 0.1412, 0.06589, 0.05041, 0.02892, 0.1503, 0.06977, 0.05551, 0.03091, 0.1595, 0.07364, 0.0607, 0.03281, 0.1688, 0.07752, 0.066, 0.03462, 0.1781, 0.0814, 0.07141, 0.03631, 0.1874, 0.08527, 0.07695, 0.03785, 0.1967, 0.08915, 0.08262, 0.03924, 0.2061, 0.09302, 0.08843, 0.04046, 0.2154, 0.0969, 0.09438, 0.04146, 0.2246, 0.1008, 0.1005, 0.04225, 0.2338, 0.1047, 0.1067, 0.04285, 0.2429, 0.1085, 0.1131, 0.04326, 0.2519, 0.1124, 0.1196, 0.04348, 0.2607, 0.1163, 0.1262, 0.04354, 0.2692, 0.1202, 0.1329, 0.04346, 0.2775, 0.124, 0.1397, 0.04326, 0.2855, 0.1279, 0.1466, 0.04299, 0.2932, 0.1318, 0.1536, 0.04268, 0.3004, 0.1357, 0.1606, 0.04238, 0.3073, 0.1395, 0.1676, 0.04212, 0.3138, 0.1434, 0.1746, 0.04194, 0.3198, 0.1473, 0.1816, 0.04189, 0.3254, 0.1512, 0.1886, 0.04199, 0.3306, 0.155, 0.1956, 0.04226, 0.3354, 0.1589, 0.2025, 0.04273, 0.3398, 0.1628, 0.2093, 0.04341, 0.3438, 0.1667, 0.2162, 0.04429, 0.3474, 0.1705, 0.2229, 0.04537, 0.3507, 0.1744, 0.2296, 0.04664, 0.3537, 0.1783, 0.2363, 0.0481, 0.3564, 0.1822, 0.2429, 0.04972, 0.3588, 0.186, 0.2495, 0.0515, 0.361, 0.1899, 0.256, 0.05342, 0.3629, 0.1938, 0.2625, 0.05546, 0.3647, 0.1977, 0.269, 0.0576, 0.3662, 0.2016, 0.2754, 0.05984, 0.3675, 0.2054, 0.2817, 0.06217, 0.3687, 0.2093, 0.2881, 0.06456, 0.3697, 0.2132, 0.2944, 0.06701, 0.3706, 0.2171, 0.3007, 0.0695, 0.3713, 0.2209, 0.3069, 0.07204, 0.3719, 0.2248, 0.3131, 0.07462, 0.3723, 0.2287, 0.3193, 0.07722, 0.3727, 0.2326, 0.3255, 0.07985, 0.3729, 0.2364, 0.3317, 0.0825, 0.373, 0.2403, 0.3378, 0.08516, 0.3731, 0.2442, 0.3439, 0.08784, 0.373, 0.2481, 0.35, 0.09052, 0.3728, 0.2519, 0.3561, 0.09321, 0.3726, 0.2558, 0.3622, 0.09591, 0.3722, 0.2597, 0.3682, 0.09862, 0.3718, 0.2636, 0.3743, 0.1013, 0.3713, 0.2674, 0.3803, 0.104, 0.3707, 0.2713, 0.3863, 0.1068, 0.3701, 0.2752, 0.3923, 0.1095, 0.3693, 0.2791, 0.3983, 0.1122, 0.3685, 0.2829, 0.4043, 0.1149, 0.3676, 0.2868, 0.4102, 0.1177, 0.3667, 0.2907, 0.4162, 0.1204, 0.3657, 0.2946, 0.4221, 0.1231, 0.3646, 0.2984, 0.428, 0.1259, 0.3634, 0.3023, 0.434, 0.1286, 0.3622, 0.3062, 0.4399, 0.1314, 0.3609, 0.3101, 0.4457, 0.1341, 0.3595, 0.314, 0.4516, 0.1369, 0.358, 0.3178, 0.4575, 0.1397, 0.3565, 0.3217, 0.4633, 0.1425, 0.355, 0.3256, 0.4692, 0.1453, 0.3533, 0.3295, 0.475, 0.1481, 0.3516, 0.3333, 0.4808, 0.1509, 0.3499, 0.3372, 0.4866, 0.1537, 0.348, 0.3411, 0.4924, 0.1566, 0.3461, 0.345, 0.4981, 0.1595, 0.3442, 0.3488, 0.5038, 0.1623, 0.3422, 0.3527, 0.5096, 0.1652, 0.3401, 0.3566, 0.5153, 0.1682, 0.3379, 0.3605, 0.5209, 0.1711, 0.3357, 0.3643, 0.5266, 0.1741, 0.3335, 0.3682, 0.5322, 0.1771, 0.3311, 0.3721, 0.5378, 0.1801, 0.3288, 0.376, 0.5434, 0.1832, 0.3263, 0.3798, 0.549, 0.1863, 0.3238, 0.3837, 0.5545, 0.1894, 0.3213, 0.3876, 0.56, 0.1925, 0.3187, 0.3915, 0.5655, 0.1957, 0.316, 0.3953, 0.571, 0.1989, 0.3133, 0.3992, 0.5764, 0.2021, 0.3105, 0.4031, 0.5818, 0.2054, 0.3077, 0.407, 0.5872, 0.2087, 0.3048, 0.4109, 0.5925, 0.2121, 0.3019, 0.4147, 0.5978, 0.2154, 0.2989, 0.4186, 0.603, 0.2189, 0.2959, 0.4225, 0.6083, 0.2223, 0.2928, 0.4264, 0.6134, 0.2258, 0.2897, 0.4302, 0.6186, 0.2294, 0.2865, 0.4341, 0.6237, 0.233, 0.2833, 0.438, 0.6288, 0.2366, 0.2801, 0.4419, 0.6338, 0.2403, 0.2768, 0.4457, 0.6388, 0.2441, 0.2735, 0.4496, 0.6437, 0.2478, 0.2701, 0.4535, 0.6486, 0.2517, 0.2667, 0.4574, 0.6534, 0.2555, 0.2633, 0.4612, 0.6582, 0.2595, 0.2598, 0.4651, 0.663, 0.2634, 0.2563, 0.469, 0.6677, 0.2675, 0.2527, 0.4729, 0.6723, 0.2715, 0.2491, 0.4767, 0.6769, 0.2757, 0.2455, 0.4806, 0.6814, 0.2798, 0.2419, 0.4845, 0.6859, 0.2841, 0.2382, 0.4884, 0.6904, 0.2884, 0.2345, 0.4922, 0.6947, 0.2927, 0.2308, 0.4961, 0.699, 0.2971, 0.227, 0.5, 0.7033, 0.3015, 0.2232, 0.5039, 0.7075, 0.306, 0.2194, 0.5078, 0.7116, 0.3106, 0.2155, 0.5116, 0.7157, 0.3152, 0.2117, 0.5155, 0.7197, 0.3198, 0.2078, 0.5194, 0.7237, 0.3245, 0.2038, 0.5233, 0.7275, 0.3293, 0.1999, 0.5271, 0.7314, 0.3341, 0.1959, 0.531, 0.7351, 0.339, 0.1919, 0.5349, 0.7388, 0.3439, 0.1879, 0.5388, 0.7424, 0.3489, 0.1838, 0.5426, 0.7459, 0.3539, 0.1797, 0.5465, 0.7494, 0.359, 0.1756, 0.5504, 0.7528, 0.3641, 0.1715, 0.5543, 0.7562, 0.3693, 0.1673, 0.5581, 0.7594, 0.3745, 0.1631, 0.562, 0.7626, 0.3798, 0.1589, 0.5659, 0.7657, 0.3851, 0.1546, 0.5698, 0.7687, 0.3905, 0.1503, 0.5736, 0.7717, 0.396, 0.146, 0.5775, 0.7746, 0.4014, 0.1417, 0.5814, 0.7774, 0.407, 0.1373, 0.5853, 0.7801, 0.4126, 0.1329, 0.5891, 0.7827, 0.4182, 0.1284, 0.593, 0.7853, 0.4239, 0.124, 0.5969, 0.7878, 0.4296, 0.1195, 0.6008, 0.7901, 0.4354, 0.115, 0.6047, 0.7924, 0.4412, 0.1104, 0.6085, 0.7947, 0.4471, 0.1058, 0.6124, 0.7968, 0.453, 0.1012, 0.6163, 0.7988, 0.459, 0.09663, 0.6202, 0.8008, 0.465, 0.09201, 0.624, 0.8026, 0.471, 0.08739, 0.6279, 0.8044, 0.4771, 0.08278, 0.6318, 0.8061, 0.4833, 0.0782, 0.6357, 0.8077, 0.4895, 0.07366, 0.6395, 0.8091, 0.4957, 0.06918, 0.6434, 0.8105, 0.502, 0.0648, 0.6473, 0.8118, 0.5083, 0.06056, 0.6512, 0.813, 0.5147, 0.05649, 0.655, 0.814, 0.5211, 0.05266, 0.6589, 0.815, 0.5275, 0.04913, 0.6628, 0.8159, 0.534, 0.04599, 0.6667, 0.8166, 0.5405, 0.04332, 0.6705, 0.8173, 0.5471, 0.04124, 0.6744, 0.8178, 0.5537, 0.03983, 0.6783, 0.8182, 0.5604, 0.03921, 0.6822, 0.8185, 0.5671, 0.03947, 0.686, 0.8187, 0.5738, 0.04067, 0.6899, 0.8187, 0.5806, 0.04281, 0.6938, 0.8186, 0.5874, 0.04592, 0.6977, 0.8184, 0.5942, 0.04994, 0.7016, 0.8181, 0.6011, 0.05484, 0.7054, 0.8176, 0.608, 0.06055, 0.7093, 0.817, 0.6149, 0.067, 0.7132, 0.8163, 0.6219, 0.07415, 0.7171, 0.8154, 0.6289, 0.08194, 0.7209, 0.8144, 0.6359, 0.09032, 0.7248, 0.8133, 0.643, 0.09928, 0.7287, 0.8121, 0.65, 0.1088, 0.7326, 0.8107, 0.6571, 0.1188, 0.7364, 0.8092, 0.6642, 0.1294, 0.7403, 0.8076, 0.6712, 0.1404, 0.7442, 0.8059, 0.6783, 0.152, 0.7481, 0.8041, 0.6853, 0.1641, 0.7519, 0.8023, 0.6923, 0.1767, 0.7558, 0.8004, 0.6993, 0.1898, 0.7597, 0.7986, 0.7062, 0.2034, 0.7636, 0.7968, 0.713, 0.2174, 0.7674, 0.7951, 0.7197, 0.2318, 0.7713, 0.7936, 0.7262, 0.2466, 0.7752, 0.7923, 0.7327, 0.2616, 0.7791, 0.7913, 0.7389, 0.2769, 0.7829, 0.7905, 0.7451, 0.2924, 0.7868, 0.7901, 0.751, 0.3079, 0.7907, 0.79, 0.7568, 0.3234, 0.7946, 0.7902, 0.7624, 0.3389, 0.7984, 0.7908, 0.7679, 0.3543, 0.8023, 0.7917, 0.7732, 0.3695, 0.8062, 0.7929, 0.7784, 0.3847, 0.8101, 0.7945, 0.7835, 0.3997, 0.814, 0.7963, 0.7885, 0.4145, 0.8178, 0.7984, 0.7933, 0.4292, 0.8217, 0.8007, 0.7981, 0.4436, 0.8256, 0.8033, 0.8028, 0.458, 0.8295, 0.8061, 0.8074, 0.4721, 0.8333, 0.8091, 0.812, 0.4862, 0.8372, 0.8122, 0.8164, 0.5, 0.8411, 0.8155, 0.8209, 0.5138, 0.845, 0.819, 0.8253, 0.5274, 0.8488, 0.8226, 0.8297, 0.5408, 0.8527, 0.8264, 0.834, 0.5542, 0.8566, 0.8302, 0.8383, 0.5674, 0.8605, 0.8342, 0.8426, 0.5805, 0.8643, 0.8382, 0.8469, 0.5936, 0.8682, 0.8423, 0.8511, 0.6065, 0.8721, 0.8465, 0.8554, 0.6193, 0.876, 0.8508, 0.8596, 0.6321, 0.8798, 0.8552, 0.8638, 0.6447, 0.8837, 0.8596, 0.8681, 0.6573, 0.8876, 0.864, 0.8723, 0.6698, 0.8915, 0.8685, 0.8765, 0.6823, 0.8953, 0.873, 0.8807, 0.6946, 0.8992, 0.8776, 0.885, 0.7069, 0.9031, 0.8822, 0.8892, 0.7192, 0.907, 0.8868, 0.8935, 0.7313, 0.9109, 0.8914, 0.8978, 0.7434, 0.9147, 0.8961, 0.9021, 0.7555, 0.9186, 0.9008, 0.9064, 0.7675, 0.9225, 0.9054, 0.9107, 0.7794, 0.9264, 0.9101, 0.9151, 0.7913, 0.9302, 0.9148, 0.9194, 0.8031, 0.9341, 0.9195, 0.9238, 0.8149, 0.938, 0.9243, 0.9282, 0.8266, 0.9419, 0.929, 0.9327, 0.8382, 0.9457, 0.9337, 0.9371, 0.8498, 0.9496, 0.9384, 0.9416, 0.8613, 0.9535, 0.9432, 0.9461, 0.8727, 0.9574, 0.9479, 0.9507, 0.8841, 0.9612, 0.9527, 0.9552, 0.8954, 0.9651, 0.9575, 0.9598, 0.9066, 0.969, 0.9624, 0.9644, 0.9176, 0.9729, 0.9673, 0.969, 0.9286, 0.9767, 0.9722, 0.9736, 0.9393, 0.9806, 0.9773, 0.9783, 0.9499, 0.9845, 0.9825, 0.9829, 0.9602, 0.9884, 0.9878, 0.9876, 0.9701, 0.9922, 0.9931, 0.9922, 0.98, 0.9961, 0.9966, 0.9922, 0.98, 1.0, 1.0, 1.0, 1.0}), new DoubleVector(new double[] {0.0, 0.0, 1.0, 0.0}), 0));

    userLookupTable_0.setColorMap(new ColorMap(new DoubleVector(new double[] {0.0, 0.001369, 1.649E-4, 0.01265, 0.003876, 0.002159, 9.22E-4, 0.01699, 0.007752, 0.003208, 0.001853, 0.02241, 0.01163, 0.004497, 0.002952, 0.02888, 0.0155, 0.006021, 0.004211, 0.0364, 0.01938, 0.00778, 0.005617, 0.0448, 0.02326, 0.009777, 0.007157, 0.05329, 0.02713, 0.01202, 0.00882, 0.06182, 0.03101, 0.01452, 0.01059, 0.07041, 0.03488, 0.01728, 0.01245, 0.07904, 0.03876, 0.02033, 0.0144, 0.08773, 0.04264, 0.02368, 0.01641, 0.09648, 0.04651, 0.02734, 0.01847, 0.1053, 0.05039, 0.03135, 0.02056, 0.1142, 0.05426, 0.03572, 0.02267, 0.1231, 0.05814, 0.04049, 0.02478, 0.1321, 0.06202, 0.04541, 0.02687, 0.1412, 0.06589, 0.05041, 0.02892, 0.1503, 0.06977, 0.05551, 0.03091, 0.1595, 0.07364, 0.0607, 0.03281, 0.1688, 0.07752, 0.066, 0.03462, 0.1781, 0.0814, 0.07141, 0.03631, 0.1874, 0.08527, 0.07695, 0.03785, 0.1967, 0.08915, 0.08262, 0.03924, 0.2061, 0.09302, 0.08843, 0.04046, 0.2154, 0.0969, 0.09438, 0.04146, 0.2246, 0.1008, 0.1005, 0.04225, 0.2338, 0.1047, 0.1067, 0.04285, 0.2429, 0.1085, 0.1131, 0.04326, 0.2519, 0.1124, 0.1196, 0.04348, 0.2607, 0.1163, 0.1262, 0.04354, 0.2692, 0.1202, 0.1329, 0.04346, 0.2775, 0.124, 0.1397, 0.04326, 0.2855, 0.1279, 0.1466, 0.04299, 0.2932, 0.1318, 0.1536, 0.04268, 0.3004, 0.1357, 0.1606, 0.04238, 0.3073, 0.1395, 0.1676, 0.04212, 0.3138, 0.1434, 0.1746, 0.04194, 0.3198, 0.1473, 0.1816, 0.04189, 0.3254, 0.1512, 0.1886, 0.04199, 0.3306, 0.155, 0.1956, 0.04226, 0.3354, 0.1589, 0.2025, 0.04273, 0.3398, 0.1628, 0.2093, 0.04341, 0.3438, 0.1667, 0.2162, 0.04429, 0.3474, 0.1705, 0.2229, 0.04537, 0.3507, 0.1744, 0.2296, 0.04664, 0.3537, 0.1783, 0.2363, 0.0481, 0.3564, 0.1822, 0.2429, 0.04972, 0.3588, 0.186, 0.2495, 0.0515, 0.361, 0.1899, 0.256, 0.05342, 0.3629, 0.1938, 0.2625, 0.05546, 0.3647, 0.1977, 0.269, 0.0576, 0.3662, 0.2016, 0.2754, 0.05984, 0.3675, 0.2054, 0.2817, 0.06217, 0.3687, 0.2093, 0.2881, 0.06456, 0.3697, 0.2132, 0.2944, 0.06701, 0.3706, 0.2171, 0.3007, 0.0695, 0.3713, 0.2209, 0.3069, 0.07204, 0.3719, 0.2248, 0.3131, 0.07462, 0.3723, 0.2287, 0.3193, 0.07722, 0.3727, 0.2326, 0.3255, 0.07985, 0.3729, 0.2364, 0.3317, 0.0825, 0.373, 0.2403, 0.3378, 0.08516, 0.3731, 0.2442, 0.3439, 0.08784, 0.373, 0.2481, 0.35, 0.09052, 0.3728, 0.2519, 0.3561, 0.09321, 0.3726, 0.2558, 0.3622, 0.09591, 0.3722, 0.2597, 0.3682, 0.09862, 0.3718, 0.2636, 0.3743, 0.1013, 0.3713, 0.2674, 0.3803, 0.104, 0.3707, 0.2713, 0.3863, 0.1068, 0.3701, 0.2752, 0.3923, 0.1095, 0.3693, 0.2791, 0.3983, 0.1122, 0.3685, 0.2829, 0.4043, 0.1149, 0.3676, 0.2868, 0.4102, 0.1177, 0.3667, 0.2907, 0.4162, 0.1204, 0.3657, 0.2946, 0.4221, 0.1231, 0.3646, 0.2984, 0.428, 0.1259, 0.3634, 0.3023, 0.434, 0.1286, 0.3622, 0.3062, 0.4399, 0.1314, 0.3609, 0.3101, 0.4457, 0.1341, 0.3595, 0.314, 0.4516, 0.1369, 0.358, 0.3178, 0.4575, 0.1397, 0.3565, 0.3217, 0.4633, 0.1425, 0.355, 0.3256, 0.4692, 0.1453, 0.3533, 0.3295, 0.475, 0.1481, 0.3516, 0.3333, 0.4808, 0.1509, 0.3499, 0.3372, 0.4866, 0.1537, 0.348, 0.3411, 0.4924, 0.1566, 0.3461, 0.345, 0.4981, 0.1595, 0.3442, 0.3488, 0.5038, 0.1623, 0.3422, 0.3527, 0.5096, 0.1652, 0.3401, 0.3566, 0.5153, 0.1682, 0.3379, 0.3605, 0.5209, 0.1711, 0.3357, 0.3643, 0.5266, 0.1741, 0.3335, 0.3682, 0.5322, 0.1771, 0.3311, 0.3721, 0.5378, 0.1801, 0.3288, 0.376, 0.5434, 0.1832, 0.3263, 0.3798, 0.549, 0.1863, 0.3238, 0.3837, 0.5545, 0.1894, 0.3213, 0.3876, 0.56, 0.1925, 0.3187, 0.3915, 0.5655, 0.1957, 0.316, 0.3953, 0.571, 0.1989, 0.3133, 0.3992, 0.5764, 0.2021, 0.3105, 0.4031, 0.5818, 0.2054, 0.3077, 0.407, 0.5872, 0.2087, 0.3048, 0.4109, 0.5925, 0.2121, 0.3019, 0.4147, 0.5978, 0.2154, 0.2989, 0.4186, 0.603, 0.2189, 0.2959, 0.4225, 0.6083, 0.2223, 0.2928, 0.4264, 0.6134, 0.2258, 0.2897, 0.4302, 0.6186, 0.2294, 0.2865, 0.4341, 0.6237, 0.233, 0.2833, 0.438, 0.6288, 0.2366, 0.2801, 0.4419, 0.6338, 0.2403, 0.2768, 0.4457, 0.6388, 0.2441, 0.2735, 0.4496, 0.6437, 0.2478, 0.2701, 0.4535, 0.6486, 0.2517, 0.2667, 0.4574, 0.6534, 0.2555, 0.2633, 0.4612, 0.6582, 0.2595, 0.2598, 0.4651, 0.663, 0.2634, 0.2563, 0.469, 0.6677, 0.2675, 0.2527, 0.4729, 0.6723, 0.2715, 0.2491, 0.4767, 0.6769, 0.2757, 0.2455, 0.4806, 0.6814, 0.2798, 0.2419, 0.4845, 0.6859, 0.2841, 0.2382, 0.4884, 0.6904, 0.2884, 0.2345, 0.4922, 0.6947, 0.2927, 0.2308, 0.4961, 0.699, 0.2971, 0.227, 0.5, 0.7033, 0.3015, 0.2232, 0.5039, 0.7075, 0.306, 0.2194, 0.5078, 0.7116, 0.3106, 0.2155, 0.5116, 0.7157, 0.3152, 0.2117, 0.5155, 0.7197, 0.3198, 0.2078, 0.5194, 0.7237, 0.3245, 0.2038, 0.5233, 0.7275, 0.3293, 0.1999, 0.5271, 0.7314, 0.3341, 0.1959, 0.531, 0.7351, 0.339, 0.1919, 0.5349, 0.7388, 0.3439, 0.1879, 0.5388, 0.7424, 0.3489, 0.1838, 0.5426, 0.7459, 0.3539, 0.1797, 0.5465, 0.7494, 0.359, 0.1756, 0.5504, 0.7528, 0.3641, 0.1715, 0.5543, 0.7562, 0.3693, 0.1673, 0.5581, 0.7594, 0.3745, 0.1631, 0.562, 0.7626, 0.3798, 0.1589, 0.5659, 0.7657, 0.3851, 0.1546, 0.5698, 0.7687, 0.3905, 0.1503, 0.5736, 0.7717, 0.396, 0.146, 0.5775, 0.7746, 0.4014, 0.1417, 0.5814, 0.7774, 0.407, 0.1373, 0.5853, 0.7801, 0.4126, 0.1329, 0.5891, 0.7827, 0.4182, 0.1284, 0.593, 0.7853, 0.4239, 0.124, 0.5969, 0.7878, 0.4296, 0.1195, 0.6008, 0.7901, 0.4354, 0.115, 0.6047, 0.7924, 0.4412, 0.1104, 0.6085, 0.7947, 0.4471, 0.1058, 0.6124, 0.7968, 0.453, 0.1012, 0.6163, 0.7988, 0.459, 0.09663, 0.6202, 0.8008, 0.465, 0.09201, 0.624, 0.8026, 0.471, 0.08739, 0.6279, 0.8044, 0.4771, 0.08278, 0.6318, 0.8061, 0.4833, 0.0782, 0.6357, 0.8077, 0.4895, 0.07366, 0.6395, 0.8091, 0.4957, 0.06918, 0.6434, 0.8105, 0.502, 0.0648, 0.6473, 0.8118, 0.5083, 0.06056, 0.6512, 0.813, 0.5147, 0.05649, 0.655, 0.814, 0.5211, 0.05266, 0.6589, 0.815, 0.5275, 0.04913, 0.6628, 0.8159, 0.534, 0.04599, 0.6667, 0.8166, 0.5405, 0.04332, 0.6705, 0.8173, 0.5471, 0.04124, 0.6744, 0.8178, 0.5537, 0.03983, 0.6783, 0.8182, 0.5604, 0.03921, 0.6822, 0.8185, 0.5671, 0.03947, 0.686, 0.8187, 0.5738, 0.04067, 0.6899, 0.8187, 0.5806, 0.04281, 0.6938, 0.8186, 0.5874, 0.04592, 0.6977, 0.8184, 0.5942, 0.04994, 0.7016, 0.8181, 0.6011, 0.05484, 0.7054, 0.8176, 0.608, 0.06055, 0.7093, 0.817, 0.6149, 0.067, 0.7132, 0.8163, 0.6219, 0.07415, 0.7171, 0.8154, 0.6289, 0.08194, 0.7209, 0.8144, 0.6359, 0.09032, 0.7248, 0.8133, 0.643, 0.09928, 0.7287, 0.8121, 0.65, 0.1088, 0.7326, 0.8107, 0.6571, 0.1188, 0.7364, 0.8092, 0.6642, 0.1294, 0.7403, 0.8076, 0.6712, 0.1404, 0.7442, 0.8059, 0.6783, 0.152, 0.7481, 0.8041, 0.6853, 0.1641, 0.7519, 0.8023, 0.6923, 0.1767, 0.7558, 0.8004, 0.6993, 0.1898, 0.7597, 0.7986, 0.7062, 0.2034, 0.7636, 0.7968, 0.713, 0.2174, 0.7674, 0.7951, 0.7197, 0.2318, 0.7713, 0.7936, 0.7262, 0.2466, 0.7752, 0.7923, 0.7327, 0.2616, 0.7791, 0.7913, 0.7389, 0.2769, 0.7829, 0.7905, 0.7451, 0.2924, 0.7868, 0.7901, 0.751, 0.3079, 0.7907, 0.79, 0.7568, 0.3234, 0.7946, 0.7902, 0.7624, 0.3389, 0.7984, 0.7908, 0.7679, 0.3543, 0.8023, 0.7917, 0.7732, 0.3695, 0.8062, 0.7929, 0.7784, 0.3847, 0.8101, 0.7945, 0.7835, 0.3997, 0.814, 0.7963, 0.7885, 0.4145, 0.8178, 0.7984, 0.7933, 0.4292, 0.8217, 0.8007, 0.7981, 0.4436, 0.8256, 0.8033, 0.8028, 0.458, 0.8295, 0.8061, 0.8074, 0.4721, 0.8333, 0.8091, 0.812, 0.4862, 0.8372, 0.8122, 0.8164, 0.5, 0.8411, 0.8155, 0.8209, 0.5138, 0.845, 0.819, 0.8253, 0.5274, 0.8488, 0.8226, 0.8297, 0.5408, 0.8527, 0.8264, 0.834, 0.5542, 0.8566, 0.8302, 0.8383, 0.5674, 0.8605, 0.8342, 0.8426, 0.5805, 0.8643, 0.8382, 0.8469, 0.5936, 0.8682, 0.8423, 0.8511, 0.6065, 0.8721, 0.8465, 0.8554, 0.6193, 0.876, 0.8508, 0.8596, 0.6321, 0.8798, 0.8552, 0.8638, 0.6447, 0.8837, 0.8596, 0.8681, 0.6573, 0.8876, 0.864, 0.8723, 0.6698, 0.8915, 0.8685, 0.8765, 0.6823, 0.8953, 0.873, 0.8807, 0.6946, 0.8992, 0.8776, 0.885, 0.7069, 0.9031, 0.8822, 0.8892, 0.7192, 0.907, 0.8868, 0.8935, 0.7313, 0.9109, 0.8914, 0.8978, 0.7434, 0.9147, 0.8961, 0.9021, 0.7555, 0.9186, 0.9008, 0.9064, 0.7675, 0.9225, 0.9054, 0.9107, 0.7794, 0.9264, 0.9101, 0.9151, 0.7913, 0.9302, 0.9148, 0.9194, 0.8031, 0.9341, 0.9195, 0.9238, 0.8149, 0.938, 0.9243, 0.9282, 0.8266, 0.9419, 0.929, 0.9327, 0.8382, 0.9457, 0.9337, 0.9371, 0.8498, 0.9496, 0.9384, 0.9416, 0.8613, 0.9535, 0.9432, 0.9461, 0.8727, 0.9574, 0.9479, 0.9507, 0.8841, 0.9612, 0.9527, 0.9552, 0.8954, 0.9651, 0.9575, 0.9598, 0.9066, 0.969, 0.9624, 0.9644, 0.9176, 0.9729, 0.9673, 0.969, 0.9286, 0.9767, 0.9722, 0.9736, 0.9393, 0.9806, 0.9773, 0.9783, 0.9499, 0.9845, 0.9825, 0.9829, 0.9602, 0.9884, 0.9878, 0.9876, 0.9701, 0.9922, 0.9931, 0.9922, 0.98, 0.9961, 0.9966, 0.9922, 0.98, 1.0, 1.0, 1.0, 1.0}), new DoubleVector(new double[] {0.0, 1.0, 1.0, 1.0}), 0));

    legend_0.setLookupTable(userLookupTable_0);

    legend_0.setLevels(512);

    scene_0.openInteractive();

    CurrentView currentView_0 = 
      scene_0.getCurrentView();

    currentView_0.setInput(new DoubleVector(new double[] {0.7880686914682049, -1.5422664176797691, 0.0773706693207121}), new DoubleVector(new double[] {4.561161912210625, 4.222548661947293, 2.5120052714009637}), new DoubleVector(new double[] {-0.16040029674549602, -0.2930762801933863, 0.9425380834703553}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.9552120094001255, -1.2887823096525122, 0.18744554437954453}), new DoubleVector(new double[] {4.358144988294807, 4.610138009032465, 1.5600691782148657}), new DoubleVector(new double[] {-0.08895844130773435, -0.17677108049933404, 0.9802236381659054}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {-2.1332735906663327, 0.004729786766901611, 0.5901560718688676}), new DoubleVector(new double[] {9.81797150872944, 20.721988395048143, 5.410868551054285}), new DoubleVector(new double[] {-0.08895844130773435, -0.17677108049933404, 0.9802236381659054}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {-5.857718516159977, 1.4891184709189673, 1.0366865762432518}), new DoubleVector(new double[] {15.385570485290547, 38.31396042447891, 9.605483177478746}), new DoubleVector(new double[] {-0.08895844130773435, -0.17677108049933404, 0.9802236381659054}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {-2.5521784371884957, 2.9260308880102195, 1.8778043436156504}), new DoubleVector(new double[] {17.218898891811364, 37.1988215958106, 9.852762468411214}), new DoubleVector(new double[] {-0.08895844130773435, -0.17677108049933404, 0.9802236381659054}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.5352090572667629, -3.2029195339457397, 0.21869891110231476}), new DoubleVector(new double[] {5.083811831677337, 6.537547498018546, 2.48521456657204}), new DoubleVector(new double[] {-0.08895844130773435, -0.17677108049933404, 0.9802236381659054}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {-1.6559004313870151, -2.2911283297942218, 0.19298960097183482}), new DoubleVector(new double[] {3.855263466246198, 7.262370636239283, 2.415999534681568}), new DoubleVector(new double[] {-0.08895844130773435, -0.17677108049933404, 0.9802236381659054}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {-1.4989976903101583, -2.049095149387498, 0.2615841595177907}), new DoubleVector(new double[] {4.875622804101993, 6.732039035670873, 3.234787674645502}), new DoubleVector(new double[] {-0.12642685370905477, -0.23456866233935472, 0.9638432410457437}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.2810817481411574, 0.6286573372691364, 0.4356461065085683}), new DoubleVector(new double[] {1.428465299035779, 2.2091951796342197, 0.9708002870138963}), new DoubleVector(new double[] {-0.12642685370905477, -0.23456866233935472, 0.9638432410457437}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.27935883920039706, 0.5370070248281709, 0.31072760075551076}), new DoubleVector(new double[] {0.8585013043201316, 1.3347843517984173, 0.580846961517945}), new DoubleVector(new double[] {-0.12642685370905477, -0.23456866233935472, 0.9638432410457437}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.3236231576996845, 0.5343810391752787, 0.24354672425927698}), new DoubleVector(new double[] {0.4560080887685898, 0.7167432432962573, 0.30529272823693127}), new DoubleVector(new double[] {-0.12642685370905477, -0.23456866233935472, 0.9638432410457437}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.2215475068071011, 0.5432474090864061, 0.4212486567824951}), new DoubleVector(new double[] {1.3945713536089377, 2.159105138980988, 0.9683617951563075}), new DoubleVector(new double[] {-0.12642685370905477, -0.23456866233935472, 0.9638432410457437}), 1.5102818616783267, 0, 30.0);

    Units units_3 = 
      ((Units) simulation_0.getUnitsManager().getObject("m"));

    resampledVolumePart_0.getSizeCoordinate().setCoordinate(units_3, units_3, units_3, new DoubleVector(new double[] {42.0, 15.0, 3.18538442440331}));

    currentView_0.setInput(new DoubleVector(new double[] {-0.9197666967188782, 1.1282753988360508, 0.6204511233611469}), new DoubleVector(new double[] {3.098187041391842, 6.663066207894369, 2.494475496771784}), new DoubleVector(new double[] {-0.12642685370905477, -0.23456866233935472, 0.9638432410457437}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.9197666967188782, 1.1282753988360508, 0.6204511233611468}), new DoubleVector(new double[] {3.098187041391842, 6.663066207894369, 2.494475496771784}), new DoubleVector(new double[] {-0.12642685370905477, -0.23456866233935472, 0.9638432410457437}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {-2.533690688076854, 1.3555867026026363, -0.2669553031584959}), new DoubleVector(new double[] {6.198415465495929, 13.384192314483478, 3.805809300323225}), new DoubleVector(new double[] {-0.12642685370905477, -0.23456866233935472, 0.9638432410457437}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {-4.174800857551155, 3.161304063307991, -0.6408017818080465}), new DoubleVector(new double[] {10.666237445991808, 23.605054229021945, 6.281245937098259}), new DoubleVector(new double[] {-0.12642685370905477, -0.23456866233935472, 0.9638432410457437}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {-4.193306899848778, 3.1380465321824493, -0.649746690415526}), new DoubleVector(new double[] {12.255340483570302, 21.789060166971723, 7.584168449542642}), new DoubleVector(new double[] {-0.16030188353763095, -0.27689381963061144, 0.9474350208772473}), 1.5102818616783267, 0, 30.0);

    legend_0.updateLayout(new DoubleVector(new double[] {0.73, 0.08}), 0.19999999999999996, 0.035, 0);

    scalarDisplayer_0.getScalarDisplayQuantity().setClip(ClipMode.MAX);

    currentView_0.setInput(new DoubleVector(new double[] {-3.4896171860341756, 3.933899987747022, -0.29972594999102403}), new DoubleVector(new double[] {13.07543384396622, 21.534075230534445, 6.706785228516559}), new DoubleVector(new double[] {-0.13752946599968133, -0.2519045443356219, 0.9579299277739045}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.14027634492990426, 1.6374782109858295, 0.2518959062208532}), new DoubleVector(new double[] {4.424249305484981, 6.487233952879146, 2.182550990608826}), new DoubleVector(new double[] {-0.13752946599968133, -0.2519045443356219, 0.9579299277739045}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.4783198578102641, 1.1745143559435398, 0.3833808124053842}), new DoubleVector(new double[] {4.96384483371504, 5.940332794344211, 2.2806210218218133}), new DoubleVector(new double[] {-0.13752946599968133, -0.2519045443356219, 0.9579299277739045}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.6233824067809844, 1.3282864202647593, 0.4380209060057684}), new DoubleVector(new double[] {4.569139829380365, 5.590167511365631, 3.422282202689113}), new DoubleVector(new double[] {-0.2587659918896664, -0.38173988016003946, 0.8873076272278863}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.1519240618299524, 1.2959068835754999, 0.713713304967276}), new DoubleVector(new double[] {4.841323992142797, 5.280891796852476, 3.5040859104797546}), new DoubleVector(new double[] {-0.2587659918896664, -0.38173988016003946, 0.8873076272278863}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.2662117073247239, 1.4279652838951309, 0.7722577255182721}), new DoubleVector(new double[] {5.063358263959374, 6.093621030016928, 1.8169061680969338}), new DoubleVector(new double[] {-0.06986961529976078, -0.1634717269347033, 0.9840707450945161}), 1.5102818616783267, 0, 30.0);

    resampledVolumePart_0.getSizeCoordinate().setCoordinate(units_3, units_3, units_3, new DoubleVector(new double[] {42.0, 15.0, 5.0}));

    currentView_0.setInput(new DoubleVector(new double[] {1.2662117073247239, 1.4279652838951309, 0.7722577255182721}), new DoubleVector(new double[] {5.063358263959374, 6.093621030016928, 1.8169061680969338}), new DoubleVector(new double[] {-0.06986961529976078, -0.1634717269347033, 0.9840707450945161}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.2662117073247239, 1.4279652838951309, 0.7722577255182721}), new DoubleVector(new double[] {5.063358263959374, 6.093621030016928, 1.8169061680969338}), new DoubleVector(new double[] {-0.06986961529976078, -0.1634717269347033, 0.9840707450945161}), 1.5102818616783267, 0, 30.0);

    legend_0.updateLayout(new DoubleVector(new double[] {0.73, 0.08}), 0.19999999999999996, 0.035, 0);

    scalarDisplayer_0.getScalarDisplayQuantity().getMinimumValue().setValueAndUnits(10.0, units_2);

    scalarDisplayer_0.getScalarDisplayQuantity().setFieldFunction(vectorMagnitudeFieldFunction_0);

    scalarDisplayer_0.getScalarDisplayQuantity().getMaximumValue().setValueAndUnits(14.0, units_2);

    scalarDisplayer_0.getScalarDisplayQuantity().setClip(ClipMode.MAX);

    scalarDisplayer_0.getScalarDisplayQuantity().setAutoRange(AutoRangeMode.NONE);

    legend_0.setLookupTable(userLookupTable_0);

    LatestMeshProxyRepresentation latestMeshProxyRepresentation_0 = 
      ((LatestMeshProxyRepresentation) simulation_0.getRepresentationManager().getObject("Latest Surface/Volume"));

    scalarDisplayer_0.setRepresentation(latestMeshProxyRepresentation_0);

    scene_0.setTransparencyOverrideMode(SceneTransparencyOverride.MAKE_SCENE_TRANSPARENT);

    scene_0.getCreatorGroup().setQuery(null);

    Region region_1 = 
      simulation_0.getRegionManager().getRegion("Cells deleted from Air");

    Region region_2 = 
      simulation_0.getRegionManager().getRegion("Cells deleted from MRF-FL");

    Region region_3 = 
      simulation_0.getRegionManager().getRegion("Cells deleted from MRF-FR");

    Region region_4 = 
      simulation_0.getRegionManager().getRegion("Cells deleted from MRF-RL");

    Region region_5 = 
      simulation_0.getRegionManager().getRegion("Cells deleted from MRF-RR");

    Region region_6 = 
      simulation_0.getRegionManager().getRegion("MRF-FL");

    Region region_7 = 
      simulation_0.getRegionManager().getRegion("MRF-FR");

    Region region_8 = 
      simulation_0.getRegionManager().getRegion("MRF-RL");

    Region region_9 = 
      simulation_0.getRegionManager().getRegion("MRF-RR");

    scene_0.getCreatorGroup().setObjects(region_0, region_1, region_2, region_3, region_4, region_5, region_6, region_7, region_8, region_9);

    scene_0.getCreatorGroup().setQuery(null);

    scene_0.getCreatorGroup().setObjects(region_0);

    ScalarDisplayer scalarDisplayer_1 = 
      scene_0.getDisplayerManager().createScalarDisplayer("Resampled Volume Scalar", ClipMode.NONE);

    scene_0.setTransparencyOverrideMode(SceneTransparencyOverride.MAKE_SCENE_TRANSPARENT);

    ResampledVolumePart resampledVolumePart_1 = 
      simulation_0.getPartManager().createResampledVolumePart(new ArrayList<>(Arrays.<NamedObject>asList(region_0)), 0.1, units_0, 1.0, units_0, units_0, units_0, new DoubleVector(new double[] {-3.0, 0.0, 1.5775701245290819}), units_0, units_0, units_0, new DoubleVector(new double[] {44.997, 15.0, 5.0}), units_0, units_0, units_0, new DoubleVector(new double[] {1.0, 0.0, 0.0}), units_1, 0.0, RefinementMetric.DIAGONAL, null);

    scalarDisplayer_1.getVisibleParts().addParts(resampledVolumePart_1);

    scalarDisplayer_1.getHiddenParts().addParts();

    scene_0.setTransparencyOverrideMode(SceneTransparencyOverride.USE_DISPLAYER_PROPERTY);

    scalarDisplayer_1.setVisibilityOverrideMode(DisplayerVisibilityOverride.HIDE_ALL_PARTS);

    scene_0.setAdvancedRenderingEnabled(true);

    AdvancedRenderingEffects advancedRenderingEffects_0 = 
      scalarDisplayer_1.getAdvancedRenderingEffects();

    advancedRenderingEffects_0.setEnableSurfaceShadows(true);

    AdvancedRenderingMaterials advancedRenderingMaterials_0 = 
      advancedRenderingEffects_0.getAdvancedRenderingMaterials();

    advancedRenderingMaterials_0.setAdvancedRenderingEffectMode(AdvancedRenderingMaterials.AdvancedRenderingEffectsMode.EMISSIVE);

    currentView_0.setRepresentation(null);

    VisView visView_0 = 
      ((VisView) simulation_0.getViewManager().getObject("View 1"));

    currentView_0.setView(visView_0);

    currentView_0.setInput(new DoubleVector(new double[] {0.2728655051256613, -0.858089777437181, -0.27066771008157436}), new DoubleVector(new double[] {3.8391417543777084, 4.356467850742882, 0.6312814959922622}), new DoubleVector(new double[] {-0.022548853818007548, -0.15540040069857056, 0.9875941801439592}), 1.5102818616783267, 0, 30.0);

    scene_0.setAdvancedRenderingEnabled(false);

    currentView_0.setInput(new DoubleVector(new double[] {0.9900526994820309, 0.1416820680220502, -0.14113578578495417}), new DoubleVector(new double[] {2.7405419882481956, 4.176066970500429, 1.8658250465947932}), new DoubleVector(new double[] {-0.1515496040707358, -0.3867583922023137, 0.9096431517727639}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.9334764741736039, 0.8702103674727617, 0.01755092971788476}), new DoubleVector(new double[] {2.447359356221275, 4.359284126820652, 1.7532391561916354}), new DoubleVector(new double[] {-0.1515496040707358, -0.3867583922023137, 0.9096431517727639}), 1.5102818616783267, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.9613055918676772, 0.9070034946318655, 0.038202869678762116}), new DoubleVector(new double[] {3.326726872606395, 3.95608910419788, 1.7613685019637744}), new DoubleVector(new double[] {-0.15483421478241363, -0.3923028802096315, 0.9067109881941153}), 1.5102818616783267, 0, 30.0);

    currentView_0.setRepresentation(null);

    VisView visView_1 = 
      ((VisView) simulation_0.getViewManager().getObject("View 8"));

    currentView_0.setView(visView_1);

    currentView_0.setInput(new DoubleVector(new double[] {1.9856801260706378, -0.5146138897673075, 0.6174649449838606}), new DoubleVector(new double[] {3.55552810588192, 2.16108029968599, 0.8302445273877105}), new DoubleVector(new double[] {-0.23183772354080007, 0.058805767388210264, 0.9709753609980573}), 1.246750717409963, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.817275458498179, 0.4097743765483709, 0.28425391677463163}), new DoubleVector(new double[] {3.0399836233513047, 2.493793449839725, 0.4499816407740609}), new DoubleVector(new double[] {-0.23183772354080007, 0.058805767388210264, 0.9709753609980573}), 1.246750717409963, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.4865582510303503, 0.5281219078956161, 0.21356264246120088}), new DoubleVector(new double[] {3.4814027602629745, 3.928192443934526, 0.4839469007421567}), new DoubleVector(new double[] {-0.23183772354080007, 0.058805767388210264, 0.9709753609980573}), 1.246750717409963, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.6834322725003321, 0.863679670224208, 0.24024724671159786}), new DoubleVector(new double[] {3.4814027602629745, 3.928192443934526, 0.4839469007421567}), new DoubleVector(new double[] {0.015488052326770375, -0.08828994937604662, 0.9959743998087022}), 1.246750717409963, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.6855648691721368, 0.869088903499692, 0.23363483729797993}), new DoubleVector(new double[] {3.455281448614816, 3.6188685455726164, 1.5103592383227393}), new DoubleVector(new double[] {-0.13992118714496984, -0.3414775321305265, 0.929416567766036}), 1.246750717409963, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.5956136722526328, 0.6814112437577332, 0.366565219661238}), new DoubleVector(new double[] {3.4379307457388846, 3.5439972881916066, 1.6956657035845781}), new DoubleVector(new double[] {-0.13992118714496984, -0.3414775321305265, 0.929416567766036}), 1.246750717409963, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.4721850604203595, 0.6149959516320629, 0.3467845921391075}), new DoubleVector(new double[] {3.562481907748472, 3.862892130850874, 1.8547848117049819}), new DoubleVector(new double[] {-0.13992118714496984, -0.3414775321305265, 0.929416567766036}), 1.246750717409963, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.399920228216005, 0.6406309314239893, 0.37084992447959375}), new DoubleVector(new double[] {3.6995034828762408, 4.213715623272144, 2.0298353730632557}), new DoubleVector(new double[] {-0.13992118714496984, -0.3414775321305265, 0.929416567766036}), 1.246750717409963, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.383531809656953, 0.6746140796281805, 0.424718600687493}), new DoubleVector(new double[] {3.8904008153212004, 4.569778671062363, 2.2332459473161554}), new DoubleVector(new double[] {-0.13992118714496984, -0.3414775321305265, 0.929416567766036}), 1.246750717409963, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.467894125332244, 0.9308401838437508, 0.5926882200586827}), new DoubleVector(new double[] {4.052084201000253, 4.946145992617151, 2.4569972087501855}), new DoubleVector(new double[] {-0.13992118714496984, -0.3414775321305265, 0.929416567766036}), 1.246750717409963, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.6728976572056793, 1.1754939878577007, 0.7134393650909098}), new DoubleVector(new double[] {5.217943833638368, 4.43684415113679, 2.4453913557137468}), new DoubleVector(new double[] {-0.13992118714496998, -0.3414775321305259, 0.9294165677660357}), 1.246750717409963, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.5190102855817549, 1.0339216134528892, 0.6382568353434492}), new DoubleVector(new double[] {5.217943833638368, 4.43684415113679, 2.4453913557137468}), new DoubleVector(new double[] {-0.22484895689153073, -0.2550117943456665, 0.9404317792000669}), 1.246750717409963, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.2562295413047107, 0.7915975571612173, 0.5072125199685267}), new DoubleVector(new double[] {5.406657025826362, 4.510375240679542, 2.0724489465407996}), new DoubleVector(new double[] {-0.174917035873771, -0.20968469224227834, 0.9619960293059446}), 1.246750717409963, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.6354031908585949, 0.2795667371728987, 0.2344714107442616}), new DoubleVector(new double[] {5.867899516285488, 4.967876709255643, 2.207784733530256}), new DoubleVector(new double[] {-0.174917035873771, -0.20968469224227834, 0.9619960293059446}), 1.246750717409963, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.2916623416595062, 0.5579602569670947, 0.42787787002622624}), new DoubleVector(new double[] {5.535141434675857, 5.256110774672488, 2.4053330861375954}), new DoubleVector(new double[] {-0.174917035873771, -0.20968469224227834, 0.9619960293059446}), 1.246750717409963, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.28620103454748447, 0.5524926071517606, 0.4242525262115329}), new DoubleVector(new double[] {5.855863333002983, 5.198663937521107, 1.586248026417433}), new DoubleVector(new double[] {-0.09120684378618521, -0.13733961250760332, 0.9863159445547027}), 1.246750717409963, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {-3.8568471629472114, -1.7300506967849545, 0.1597470933530868}), new DoubleVector(new double[] {5.221093842593058, 5.842700931338279, 2.0536727991355703}), new DoubleVector(new double[] {-0.09120684378618521, -0.13733961250760332, 0.9863159445547027}), 1.246750717409963, 0, 30.0);

    resampledVolumePart_0.getSizeCoordinate().setCoordinate(units_3, units_3, units_3, new DoubleVector(new double[] {42.0, 15.0, 50.0}));

    scene_0.setBackgroundColorMode(BackgroundColorMode.GRADIENT);

    GradientBackgroundColor gradientBackgroundColor_0 = 
      scene_0.getGradientBackgroundColor();

    gradientBackgroundColor_0.setMode(GradientMode.BOTTOM_TOP);

    scene_0.setExportResolution(ExportResolution.FULL_HD);

    scene_0.setAdvancedRenderingEnabled(true);

    LogoAnnotationProp logoAnnotationProp_0 = 
      ((LogoAnnotationProp) scene_0.getAnnotationPropManager().getObject("Logo"));

    logoAnnotationProp_0.setVisible(false);

    scene_0.setAdvancedRenderingEnabled(false);

    scalarDisplayer_0.setOpacity(0.5);

    scalarDisplayer_0.setOpacity(0.2);

    scalarDisplayer_0.setOpacity(0.3);

    scalarDisplayer_0.setOpacity(0.3);

    scalarDisplayer_0.setOpacity(1.0);

    scalarDisplayer_0.setOpacity(0.8);

    currentView_0.setInput(new DoubleVector(new double[] {1.5658930992813178, 2.698164327645676, 1.254342222055964}), new DoubleVector(new double[] {6.487498617556767, 5.19968691668023, 1.6632233084143164}), new DoubleVector(new double[] {-0.032474614724855355, -0.09867654473070515, 0.9945895328820304}), 1.246750717409963, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.2584928786758134, 2.541920883740337, 1.2288037802443945}), new DoubleVector(new double[] {6.487498617556767, 5.19968691668023, 1.6632233084143164}), new DoubleVector(new double[] {-0.06497303824544849, -0.03517533520664163, 0.9972668650337632}), 1.246750717409963, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.500905551679315, 2.367170873516918, 1.1940278205132446}), new DoubleVector(new double[] {6.6108017208549565, 4.9643966461532125, 1.6185518684225197}), new DoubleVector(new double[] {-0.06497303824544849, -0.03517533520664163, 0.9972668650337632}), 1.246750717409963, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.2561935819976435, 2.028699383889675, 1.0691338036885096}), new DoubleVector(new double[] {6.193664600008878, 4.538285988991348, 1.4793329767450945}), new DoubleVector(new double[] {-0.06497303824544849, -0.03517533520664163, 0.9972668650337632}), 1.246750717409963, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.5487720588078577, 2.1219528616154135, 1.0914848269533899}), new DoubleVector(new double[] {6.216070999244745, 4.4942181083780195, 1.4792384276917365}), new DoubleVector(new double[] {-0.06497303824544849, -0.03517533520664163, 0.9972668650337632}), 1.246750717409963, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.5487720588091953, 2.1219528616160934, 1.0914848269535011}), new DoubleVector(new double[] {6.216070999244745, 4.4942181083780195, 1.4792384276917365}), new DoubleVector(new double[] {-0.04170892590062566, -0.08071687398998975, 0.9958640227227384}), 1.246750717409963, 0, 30.0);

    legend_0.updateLayout(new DoubleVector(new double[] {0.02952021932830764, 0.8416000000000002}), 0.19999999999999954, 0.035000000000000364, 0);

    scalarDisplayer_0.setSmoothShade(false);

    scalarDisplayer_0.setSmoothShade(true);

    scalarDisplayer_0.getScalarDisplayQuantity().setClip(ClipMode.NONE);

    scalarDisplayer_0.getScalarDisplayQuantity().setClip(ClipMode.MAX);

 //   scene_0.printAndWait(resolvePath("C:\\Users\\Ashwin\\Desktop\\lageb_Geometry Scene 1.png"), 1, 3840, 2160, true, false);

    currentView_0.setInput(new DoubleVector(new double[] {1.3853895093391138, 1.4941843637912817, 1.0288744201246005}), new DoubleVector(new double[] {6.43811787553606, 4.062353246356714, 1.4486490354960888}), new DoubleVector(new double[] {-0.04170892590062566, -0.08071687398998975, 0.9958640227227384}), 1.246750717409963, 0, 30.0);

 //   scene_0.printAndWait(resolvePath("C:\\Users\\Ashwin\\Desktop\\lageb_Geometry Scene 1.png"), 1, 3840, 2160, true, false);

    userLookupTable_0.setColorMap(new ColorMap(new DoubleVector(new double[] {0.0, 0.001369, 1.649E-4, 0.01265, 0.003876, 0.002159, 9.22E-4, 0.01699, 0.007752, 0.003208, 0.001853, 0.02241, 0.01163, 0.004497, 0.002952, 0.02888, 0.0155, 0.006021, 0.004211, 0.0364, 0.01938, 0.00778, 0.005617, 0.0448, 0.02326, 0.009777, 0.007157, 0.05329, 0.02713, 0.01202, 0.00882, 0.06182, 0.03101, 0.01452, 0.01059, 0.07041, 0.03488, 0.01728, 0.01245, 0.07904, 0.03876, 0.02033, 0.0144, 0.08773, 0.04264, 0.02368, 0.01641, 0.09648, 0.04651, 0.02734, 0.01847, 0.1053, 0.05039, 0.03135, 0.02056, 0.1142, 0.05426, 0.03572, 0.02267, 0.1231, 0.05814, 0.04049, 0.02478, 0.1321, 0.06202, 0.04541, 0.02687, 0.1412, 0.06589, 0.05041, 0.02892, 0.1503, 0.06977, 0.05551, 0.03091, 0.1595, 0.07364, 0.0607, 0.03281, 0.1688, 0.07752, 0.066, 0.03462, 0.1781, 0.0814, 0.07141, 0.03631, 0.1874, 0.08527, 0.07695, 0.03785, 0.1967, 0.08915, 0.08262, 0.03924, 0.2061, 0.09302, 0.08843, 0.04046, 0.2154, 0.0969, 0.09438, 0.04146, 0.2246, 0.1008, 0.1005, 0.04225, 0.2338, 0.1047, 0.1067, 0.04285, 0.2429, 0.1085, 0.1131, 0.04326, 0.2519, 0.1124, 0.1196, 0.04348, 0.2607, 0.1163, 0.1262, 0.04354, 0.2692, 0.1202, 0.1329, 0.04346, 0.2775, 0.124, 0.1397, 0.04326, 0.2855, 0.1279, 0.1466, 0.04299, 0.2932, 0.1318, 0.1536, 0.04268, 0.3004, 0.1357, 0.1606, 0.04238, 0.3073, 0.1395, 0.1676, 0.04212, 0.3138, 0.1434, 0.1746, 0.04194, 0.3198, 0.1473, 0.1816, 0.04189, 0.3254, 0.1512, 0.1886, 0.04199, 0.3306, 0.155, 0.1956, 0.04226, 0.3354, 0.1589, 0.2025, 0.04273, 0.3398, 0.1628, 0.2093, 0.04341, 0.3438, 0.1667, 0.2162, 0.04429, 0.3474, 0.1705, 0.2229, 0.04537, 0.3507, 0.1744, 0.2296, 0.04664, 0.3537, 0.1783, 0.2363, 0.0481, 0.3564, 0.1822, 0.2429, 0.04972, 0.3588, 0.186, 0.2495, 0.0515, 0.361, 0.1899, 0.256, 0.05342, 0.3629, 0.1938, 0.2625, 0.05546, 0.3647, 0.1977, 0.269, 0.0576, 0.3662, 0.2016, 0.2754, 0.05984, 0.3675, 0.2054, 0.2817, 0.06217, 0.3687, 0.2093, 0.2881, 0.06456, 0.3697, 0.2132, 0.2944, 0.06701, 0.3706, 0.2171, 0.3007, 0.0695, 0.3713, 0.2209, 0.3069, 0.07204, 0.3719, 0.2248, 0.3131, 0.07462, 0.3723, 0.2287, 0.3193, 0.07722, 0.3727, 0.2326, 0.3255, 0.07985, 0.3729, 0.2364, 0.3317, 0.0825, 0.373, 0.2403, 0.3378, 0.08516, 0.3731, 0.2442, 0.3439, 0.08784, 0.373, 0.2481, 0.35, 0.09052, 0.3728, 0.2519, 0.3561, 0.09321, 0.3726, 0.2558, 0.3622, 0.09591, 0.3722, 0.2597, 0.3682, 0.09862, 0.3718, 0.2636, 0.3743, 0.1013, 0.3713, 0.2674, 0.3803, 0.104, 0.3707, 0.2713, 0.3863, 0.1068, 0.3701, 0.2752, 0.3923, 0.1095, 0.3693, 0.2791, 0.3983, 0.1122, 0.3685, 0.2829, 0.4043, 0.1149, 0.3676, 0.2868, 0.4102, 0.1177, 0.3667, 0.2907, 0.4162, 0.1204, 0.3657, 0.2946, 0.4221, 0.1231, 0.3646, 0.2984, 0.428, 0.1259, 0.3634, 0.3023, 0.434, 0.1286, 0.3622, 0.3062, 0.4399, 0.1314, 0.3609, 0.3101, 0.4457, 0.1341, 0.3595, 0.314, 0.4516, 0.1369, 0.358, 0.3178, 0.4575, 0.1397, 0.3565, 0.3217, 0.4633, 0.1425, 0.355, 0.3256, 0.4692, 0.1453, 0.3533, 0.3295, 0.475, 0.1481, 0.3516, 0.3333, 0.4808, 0.1509, 0.3499, 0.3372, 0.4866, 0.1537, 0.348, 0.3411, 0.4924, 0.1566, 0.3461, 0.345, 0.4981, 0.1595, 0.3442, 0.3488, 0.5038, 0.1623, 0.3422, 0.3527, 0.5096, 0.1652, 0.3401, 0.3566, 0.5153, 0.1682, 0.3379, 0.3605, 0.5209, 0.1711, 0.3357, 0.3643, 0.5266, 0.1741, 0.3335, 0.3682, 0.5322, 0.1771, 0.3311, 0.3721, 0.5378, 0.1801, 0.3288, 0.376, 0.5434, 0.1832, 0.3263, 0.3798, 0.549, 0.1863, 0.3238, 0.3837, 0.5545, 0.1894, 0.3213, 0.3876, 0.56, 0.1925, 0.3187, 0.3915, 0.5655, 0.1957, 0.316, 0.3953, 0.571, 0.1989, 0.3133, 0.3992, 0.5764, 0.2021, 0.3105, 0.4031, 0.5818, 0.2054, 0.3077, 0.407, 0.5872, 0.2087, 0.3048, 0.4109, 0.5925, 0.2121, 0.3019, 0.4147, 0.5978, 0.2154, 0.2989, 0.4186, 0.603, 0.2189, 0.2959, 0.4225, 0.6083, 0.2223, 0.2928, 0.4264, 0.6134, 0.2258, 0.2897, 0.4302, 0.6186, 0.2294, 0.2865, 0.4341, 0.6237, 0.233, 0.2833, 0.438, 0.6288, 0.2366, 0.2801, 0.4419, 0.6338, 0.2403, 0.2768, 0.4457, 0.6388, 0.2441, 0.2735, 0.4496, 0.6437, 0.2478, 0.2701, 0.4535, 0.6486, 0.2517, 0.2667, 0.4574, 0.6534, 0.2555, 0.2633, 0.4612, 0.6582, 0.2595, 0.2598, 0.4651, 0.663, 0.2634, 0.2563, 0.469, 0.6677, 0.2675, 0.2527, 0.4729, 0.6723, 0.2715, 0.2491, 0.4767, 0.6769, 0.2757, 0.2455, 0.4806, 0.6814, 0.2798, 0.2419, 0.4845, 0.6859, 0.2841, 0.2382, 0.4884, 0.6904, 0.2884, 0.2345, 0.4922, 0.6947, 0.2927, 0.2308, 0.4961, 0.699, 0.2971, 0.227, 0.5, 0.7033, 0.3015, 0.2232, 0.5039, 0.7075, 0.306, 0.2194, 0.5078, 0.7116, 0.3106, 0.2155, 0.5116, 0.7157, 0.3152, 0.2117, 0.5155, 0.7197, 0.3198, 0.2078, 0.5194, 0.7237, 0.3245, 0.2038, 0.5233, 0.7275, 0.3293, 0.1999, 0.5271, 0.7314, 0.3341, 0.1959, 0.531, 0.7351, 0.339, 0.1919, 0.5349, 0.7388, 0.3439, 0.1879, 0.5388, 0.7424, 0.3489, 0.1838, 0.5426, 0.7459, 0.3539, 0.1797, 0.5465, 0.7494, 0.359, 0.1756, 0.5504, 0.7528, 0.3641, 0.1715, 0.5543, 0.7562, 0.3693, 0.1673, 0.5581, 0.7594, 0.3745, 0.1631, 0.562, 0.7626, 0.3798, 0.1589, 0.5659, 0.7657, 0.3851, 0.1546, 0.5698, 0.7687, 0.3905, 0.1503, 0.5736, 0.7717, 0.396, 0.146, 0.5775, 0.7746, 0.4014, 0.1417, 0.5814, 0.7774, 0.407, 0.1373, 0.5853, 0.7801, 0.4126, 0.1329, 0.5891, 0.7827, 0.4182, 0.1284, 0.593, 0.7853, 0.4239, 0.124, 0.5969, 0.7878, 0.4296, 0.1195, 0.6008, 0.7901, 0.4354, 0.115, 0.6047, 0.7924, 0.4412, 0.1104, 0.6085, 0.7947, 0.4471, 0.1058, 0.6124, 0.7968, 0.453, 0.1012, 0.6163, 0.7988, 0.459, 0.09663, 0.6202, 0.8008, 0.465, 0.09201, 0.624, 0.8026, 0.471, 0.08739, 0.6279, 0.8044, 0.4771, 0.08278, 0.6318, 0.8061, 0.4833, 0.0782, 0.6357, 0.8077, 0.4895, 0.07366, 0.6395, 0.8091, 0.4957, 0.06918, 0.6434, 0.8105, 0.502, 0.0648, 0.6473, 0.8118, 0.5083, 0.06056, 0.6512, 0.813, 0.5147, 0.05649, 0.655, 0.814, 0.5211, 0.05266, 0.6589, 0.815, 0.5275, 0.04913, 0.6628, 0.8159, 0.534, 0.04599, 0.6667, 0.8166, 0.5405, 0.04332, 0.6705, 0.8173, 0.5471, 0.04124, 0.6744, 0.8178, 0.5537, 0.03983, 0.6783, 0.8182, 0.5604, 0.03921, 0.6822, 0.8185, 0.5671, 0.03947, 0.686, 0.8187, 0.5738, 0.04067, 0.6899, 0.8187, 0.5806, 0.04281, 0.6938, 0.8186, 0.5874, 0.04592, 0.6977, 0.8184, 0.5942, 0.04994, 0.7016, 0.8181, 0.6011, 0.05484, 0.7054, 0.8176, 0.608, 0.06055, 0.7093, 0.817, 0.6149, 0.067, 0.7132, 0.8163, 0.6219, 0.07415, 0.7171, 0.8154, 0.6289, 0.08194, 0.7209, 0.8144, 0.6359, 0.09032, 0.7248, 0.8133, 0.643, 0.09928, 0.7287, 0.8121, 0.65, 0.1088, 0.7326, 0.8107, 0.6571, 0.1188, 0.7364, 0.8092, 0.6642, 0.1294, 0.7403, 0.8076, 0.6712, 0.1404, 0.7442, 0.8059, 0.6783, 0.152, 0.7481, 0.8041, 0.6853, 0.1641, 0.7519, 0.8023, 0.6923, 0.1767, 0.7558, 0.8004, 0.6993, 0.1898, 0.7597, 0.7986, 0.7062, 0.2034, 0.7636, 0.7968, 0.713, 0.2174, 0.7674, 0.7951, 0.7197, 0.2318, 0.7713, 0.7936, 0.7262, 0.2466, 0.7752, 0.7923, 0.7327, 0.2616, 0.7791, 0.7913, 0.7389, 0.2769, 0.7829, 0.7905, 0.7451, 0.2924, 0.7868, 0.7901, 0.751, 0.3079, 0.7907, 0.79, 0.7568, 0.3234, 0.7946, 0.7902, 0.7624, 0.3389, 0.7984, 0.7908, 0.7679, 0.3543, 0.8023, 0.7917, 0.7732, 0.3695, 0.8062, 0.7929, 0.7784, 0.3847, 0.8101, 0.7945, 0.7835, 0.3997, 0.814, 0.7963, 0.7885, 0.4145, 0.8178, 0.7984, 0.7933, 0.4292, 0.8217, 0.8007, 0.7981, 0.4436, 0.8256, 0.8033, 0.8028, 0.458, 0.8295, 0.8061, 0.8074, 0.4721, 0.8333, 0.8091, 0.812, 0.4862, 0.8372, 0.8122, 0.8164, 0.5, 0.8411, 0.8155, 0.8209, 0.5138, 0.845, 0.819, 0.8253, 0.5274, 0.8488, 0.8226, 0.8297, 0.5408, 0.8527, 0.8264, 0.834, 0.5542, 0.8566, 0.8302, 0.8383, 0.5674, 0.8605, 0.8342, 0.8426, 0.5805, 0.8643, 0.8382, 0.8469, 0.5936, 0.8682, 0.8423, 0.8511, 0.6065, 0.8721, 0.8465, 0.8554, 0.6193, 0.876, 0.8508, 0.8596, 0.6321, 0.8798, 0.8552, 0.8638, 0.6447, 0.8837, 0.8596, 0.8681, 0.6573, 0.8876, 0.864, 0.8723, 0.6698, 0.8915, 0.8685, 0.8765, 0.6823, 0.8953, 0.873, 0.8807, 0.6946, 0.8992, 0.8776, 0.885, 0.7069, 0.9031, 0.8822, 0.8892, 0.7192, 0.907, 0.8868, 0.8935, 0.7313, 0.9109, 0.8914, 0.8978, 0.7434, 0.9147, 0.8961, 0.9021, 0.7555, 0.9186, 0.9008, 0.9064, 0.7675, 0.9225, 0.9054, 0.9107, 0.7794, 0.9264, 0.9101, 0.9151, 0.7913, 0.9302, 0.9148, 0.9194, 0.8031, 0.9341, 0.9195, 0.9238, 0.8149, 0.938, 0.9243, 0.9282, 0.8266, 0.9419, 0.929, 0.9327, 0.8382, 0.9457, 0.9337, 0.9371, 0.8498, 0.9496, 0.9384, 0.9416, 0.8613, 0.9535, 0.9432, 0.9461, 0.8727, 0.9574, 0.9479, 0.9507, 0.8841, 0.9612, 0.9527, 0.9552, 0.8954, 0.9651, 0.9575, 0.9598, 0.9066, 0.969, 0.9624, 0.9644, 0.9176, 0.9729, 0.9673, 0.969, 0.9286, 0.9767, 0.9722, 0.9736, 0.9393, 0.9806, 0.9773, 0.9783, 0.9499, 0.9845, 0.9825, 0.9829, 0.9602, 0.9884, 0.9878, 0.9876, 0.9701, 0.9922, 0.9931, 0.9922, 0.98, 0.9961, 0.9966, 0.9922, 0.98, 1.0, 1.0, 1.0, 1.0}), new DoubleVector(new double[] {0.0, 1.0, 1.0, 0.0}), 0));

    currentView_0.setInput(new DoubleVector(new double[] {1.2598102459839156, 1.4223308615298231, 1.0188315524783604}), new DoubleVector(new double[] {6.038990589248467, 4.473813514176233, 1.3856262288152632}), new DoubleVector(new double[] {-0.029444806598008366, -0.07370694367608152, 0.9968451684280518}), 1.246750717409963, 0, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {-2.155803249728447, -1.182148840865866, 0.6996684077866061}), new DoubleVector(new double[] {6.23343520051829, 4.17433778678787, 1.3435294427458844}), new DoubleVector(new double[] {-0.029444806598008366, -0.07370694367608152, 0.9968451684280518}), 1.246750717409963, 0, 30.0);

//    scene_0.printAndWait(resolvePath("C:\\Users\\Ashwin\\Desktop\\lageb_Geometry Scene 1.png"), 1, 3840, 2160, true, false);

    currentView_0.setInput(new DoubleVector(new double[] {-2.1558032497262225, -1.1821488408644454, 0.6996684077867769}), new DoubleVector(new double[] {6.23343520051829, 4.17433778678787, 1.3435294427458844}), new DoubleVector(new double[] {-0.04885078293953928, -0.04343575968935782, 0.9978611806190363}), 1.246750717409963, 0, 30.0);

    scene_0.setAdvancedRenderingEnabled(true);

   // scene_0.printAndWait(resolvePath("scene.png"), 1, 1920, 1080, true, false);
  }
}
