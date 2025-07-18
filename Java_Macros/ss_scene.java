// Simcenter STAR-CCM+ macro: ss_scene.java
// Written by Simcenter STAR-CCM+ 19.06.009
package macro;

import java.util.*;

import java.io.File;
import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.cadmodeler.*;
import star.flow.*;
import star.meshing.*;

public class ss_scene extends StarMacro {

  public void execute() {
    execute0();
    execute1();
    execute2();
    execute3();
    execute4();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    simulation_0.getSceneManager().createGeometryScene("Geometry Scene", "Outline", "Surface", 1, null);

    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 1");

    scene_0.resetCamera();

    scene_0.setAdvancedRenderingEnabled(true);

    PartDisplayer partDisplayer_0 = 
      ((PartDisplayer) scene_0.getDisplayerManager().getObject("Outline 1"));

    partDisplayer_0.setPresentationName("Brakes");

    partDisplayer_0.setOutline(false);

    partDisplayer_0.setSurface(true);

    partDisplayer_0.setColorMode(PartColorMode.CONSTANT);

    PartRepresentation partRepresentation_0 = 
      ((PartRepresentation) simulation_0.getRepresentationManager().getObject("Geometry"));

    partDisplayer_0.setRepresentation(partRepresentation_0);

    partDisplayer_0.getInputParts().setQuery(null);

    SolidModelCompositePart solidModelCompositePart_1 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("W_wheel_front-left"));

    SolidModelCompositePart solidModelCompositePart_0 = 
      ((SolidModelCompositePart) solidModelCompositePart_1.getChildParts().getPart("wheelhub"));

    SolidModelPart solidModelPart_0 = 
      ((SolidModelPart) solidModelCompositePart_0.getChildParts().getPart("Body 37 2"));

    PartSurface partSurface_0 = 
      ((PartSurface) solidModelPart_0.getPartSurfaceManager().getPartSurface("Default"));

    partDisplayer_0.getInputParts().setObjects(partSurface_0);

    partDisplayer_0.getInputParts().setQuery(null);

    SolidModelCompositePart solidModelCompositePart_3 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("W_wheel_front-right"));

    SolidModelCompositePart solidModelCompositePart_2 = 
      ((SolidModelCompositePart) solidModelCompositePart_3.getChildParts().getPart("wheelhub"));

    SolidModelPart solidModelPart_1 = 
      ((SolidModelPart) solidModelCompositePart_2.getChildParts().getPart("Body 37"));

    PartSurface partSurface_1 = 
      ((PartSurface) solidModelPart_1.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelCompositePart solidModelCompositePart_5 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("W_wheel_rear-left"));

    SolidModelCompositePart solidModelCompositePart_4 = 
      ((SolidModelCompositePart) solidModelCompositePart_5.getChildParts().getPart("wheelhub"));

    SolidModelPart solidModelPart_2 = 
      ((SolidModelPart) solidModelCompositePart_4.getChildParts().getPart("Body 1 10"));

    PartSurface partSurface_2 = 
      ((PartSurface) solidModelPart_2.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelCompositePart solidModelCompositePart_7 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("W_wheel_rear-right"));

    SolidModelCompositePart solidModelCompositePart_6 = 
      ((SolidModelCompositePart) solidModelCompositePart_7.getChildParts().getPart("wheelhub"));

    SolidModelPart solidModelPart_3 = 
      ((SolidModelPart) solidModelCompositePart_6.getChildParts().getPart("Body 1 7"));

    PartSurface partSurface_3 = 
      ((PartSurface) solidModelPart_3.getPartSurfaceManager().getPartSurface("Default"));

    partDisplayer_0.getInputParts().setObjects(partSurface_0, partSurface_1, partSurface_2, partSurface_3);

    partDisplayer_0.setDisplayerColor(new DoubleVector(new double[] {0.8274999856948853, 0.8274999856948853, 0.8274999856948853}));

    AdvancedRenderingEffects advancedRenderingEffects_0 = 
      partDisplayer_0.getAdvancedRenderingEffects();

    advancedRenderingEffects_0.setEnableSurfaceShadows(true);

    AdvancedRenderingMaterials advancedRenderingMaterials_0 = 
      advancedRenderingEffects_0.getAdvancedRenderingMaterials();

    advancedRenderingMaterials_0.setAdvancedRenderingEffectMode(AdvancedRenderingMaterials.AdvancedRenderingEffectsMode.METALLIC);

    PartDisplayer partDisplayer_1 = 
      scene_0.getDisplayerManager().createPartDisplayer("Dummy", -1, 0);

    partDisplayer_1.copyProperties(partDisplayer_0);

    partDisplayer_1.setPresentationName("Brakes copy");

    SimpleTransform simpleTransform_0 = 
      simulation_0.getTransformManager().createSimpleTransform("Simple Transform");

    Units units_0 = 
      ((Units) simulation_0.getUnitsManager().getObject("m"));

    simpleTransform_0.getTranslationCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 5.0, 0.0}));

    partDisplayer_1.setVisTransform(simpleTransform_0);

    PartDisplayer partDisplayer_2 = 
      ((PartDisplayer) scene_0.getDisplayerManager().getObject("Surface 1"));

    partDisplayer_2.setPresentationName("car_notyre");

    partDisplayer_2.setColorMode(PartColorMode.CONSTANT);

    partDisplayer_2.setRepresentation(partRepresentation_0);

    partDisplayer_2.getInputParts().setQuery(null);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Air");

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("Frontwing");

    Boundary boundary_1 = 
      region_0.getBoundaryManager().getBoundary("mono");

    Boundary boundary_2 = 
      region_0.getBoundaryManager().getBoundary("Rearwing");

    Boundary boundary_3 = 
      region_0.getBoundaryManager().getBoundary("Undertray");

    partDisplayer_2.getInputParts().setObjects(boundary_0, boundary_1, boundary_2, boundary_3);

    partDisplayer_2.setDisplayerColor(new DoubleVector(new double[] {0.0, 0.0, 0.0}));

    AdvancedRenderingEffects advancedRenderingEffects_1 = 
      partDisplayer_2.getAdvancedRenderingEffects();

    advancedRenderingEffects_1.setEnableSurfaceShadows(true);

    AdvancedRenderingMaterials advancedRenderingMaterials_1 = 
      advancedRenderingEffects_1.getAdvancedRenderingMaterials();

    advancedRenderingMaterials_1.setAdvancedRenderingEffectMode(AdvancedRenderingMaterials.AdvancedRenderingEffectsMode.METALLIC);

    PartDisplayer partDisplayer_3 = 
      scene_0.getDisplayerManager().createPartDisplayer("Dummy", -1, 0);

    partDisplayer_3.copyProperties(partDisplayer_2);

    partDisplayer_3.setPresentationName("car_notyre copy");

    partDisplayer_3.setVisTransform(simpleTransform_0);

    PartDisplayer partDisplayer_4 = 
      scene_0.getDisplayerManager().createPartDisplayer("Surface", -1, 1);

    partDisplayer_4.setPresentationName("Driver");

    partDisplayer_4.setRepresentation(partRepresentation_0);

    partDisplayer_4.getInputParts().setQuery(null);

    SolidModelCompositePart solidModelCompositePart_8 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("z_000_remaining-parts"));

    CompositePart compositePart_0 = 
      ((CompositePart) solidModelCompositePart_8.getChildParts().getPart("C_P002_FAHRER_GERADEAUS"));

    SimpleBlockPart simpleBlockPart_0 = 
      ((SimpleBlockPart) compositePart_0.getChildParts().getPart("Block"));

    PartSurface partSurface_4 = 
      ((PartSurface) simpleBlockPart_0.getPartSurfaceManager().getPartSurface("Block Surface"));

    MeshPart meshPart_0 = 
      ((MeshPart) compositePart_0.getChildParts().getPart("driver"));

    PartSurface partSurface_5 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface"));

    partDisplayer_4.getInputParts().setObjects(partSurface_4, partSurface_5);

    AdvancedRenderingEffects advancedRenderingEffects_2 = 
      partDisplayer_4.getAdvancedRenderingEffects();

    advancedRenderingEffects_2.setEnableSurfaceShadows(true);

    PartDisplayer partDisplayer_5 = 
      scene_0.getDisplayerManager().createPartDisplayer("Dummy", -1, 0);

    partDisplayer_5.copyProperties(partDisplayer_4);

    partDisplayer_5.setPresentationName("Driver copy");

    partDisplayer_5.setVisTransform(simpleTransform_0);

    PartDisplayer partDisplayer_6 = 
      scene_0.getDisplayerManager().createPartDisplayer("Surface", -1, 1);

    partDisplayer_6.setPresentationName("DriverSheild");

    partDisplayer_6.setColorMode(PartColorMode.CONSTANT);

    partDisplayer_6.setRepresentation(partRepresentation_0);

    meshPart_0.getPartSurfaceManager().splitNonContiguousPartSurfaces(new Vector<>(Arrays.asList(partSurface_5)));

    PartSurface partSurface_6 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 23"));

    PartSurface partSurface_7 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 61"));

    PartSurface partSurface_8 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 13"));

    PartSurface partSurface_9 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 34"));

    PartSurface partSurface_10 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 86"));

    PartSurface partSurface_11 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 35"));

    PartSurface partSurface_12 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 55"));

    PartSurface partSurface_13 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 68"));

    PartSurface partSurface_14 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 74"));

    PartSurface partSurface_15 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 32"));

    PartSurface partSurface_16 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 21"));

    PartSurface partSurface_17 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 12"));

    PartSurface partSurface_18 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 51"));

    PartSurface partSurface_19 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 87"));

    PartSurface partSurface_20 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 92"));

    PartSurface partSurface_21 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 42"));

    PartSurface partSurface_22 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 18"));

    PartSurface partSurface_23 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 97"));

    PartSurface partSurface_24 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 67"));

    PartSurface partSurface_25 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 54"));

    PartSurface partSurface_26 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 57"));

    PartSurface partSurface_27 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 2"));

    PartSurface partSurface_28 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 94"));

    PartSurface partSurface_29 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 99"));

    PartSurface partSurface_30 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 53"));

    PartSurface partSurface_31 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 38"));

    PartSurface partSurface_32 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 93"));

    PartSurface partSurface_33 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 65"));

    PartSurface partSurface_34 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 78"));

    PartSurface partSurface_35 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 9"));

    PartSurface partSurface_36 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 48"));

    PartSurface partSurface_37 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 11"));

    PartSurface partSurface_38 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 41"));

    PartSurface partSurface_39 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 59"));

    PartSurface partSurface_40 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 90"));

    PartSurface partSurface_41 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 83"));

    PartSurface partSurface_42 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 29"));

    PartSurface partSurface_43 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 20"));

    PartSurface partSurface_44 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 26"));

    PartSurface partSurface_45 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 27"));

    PartSurface partSurface_46 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 79"));

    PartSurface partSurface_47 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 85"));

    PartSurface partSurface_48 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 56"));

    PartSurface partSurface_49 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 98"));

    PartSurface partSurface_50 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 19"));

    PartSurface partSurface_51 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 49"));

    PartSurface partSurface_52 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 40"));

    PartSurface partSurface_53 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 75"));

    PartSurface partSurface_54 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 5"));

    PartSurface partSurface_55 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 28"));

    PartSurface partSurface_56 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 4"));

    PartSurface partSurface_57 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 30"));

    PartSurface partSurface_58 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 22"));

    PartSurface partSurface_59 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 76"));

    PartSurface partSurface_60 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 82"));

    PartSurface partSurface_61 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 71"));

    PartSurface partSurface_62 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 37"));

    PartSurface partSurface_63 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 89"));

    PartSurface partSurface_64 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 46"));

    PartSurface partSurface_65 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 100"));

    PartSurface partSurface_66 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 91"));

    PartSurface partSurface_67 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 14"));

    PartSurface partSurface_68 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 88"));

    PartSurface partSurface_69 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 6"));

    PartSurface partSurface_70 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 50"));

    PartSurface partSurface_71 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 45"));

    PartSurface partSurface_72 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 43"));

    PartSurface partSurface_73 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 84"));

    PartSurface partSurface_74 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 64"));

    PartSurface partSurface_75 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 73"));

    PartSurface partSurface_76 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 66"));

    PartSurface partSurface_77 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 25"));

    PartSurface partSurface_78 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 17"));

    PartSurface partSurface_79 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 95"));

    PartSurface partSurface_80 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 60"));

    PartSurface partSurface_81 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 15"));

    PartSurface partSurface_82 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 7"));

    PartSurface partSurface_83 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 80"));

    PartSurface partSurface_84 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 72"));

    PartSurface partSurface_85 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 10"));

    PartSurface partSurface_86 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 77"));

    PartSurface partSurface_87 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 31"));

    PartSurface partSurface_88 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 58"));

    PartSurface partSurface_89 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 36"));

    PartSurface partSurface_90 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 33"));

    PartSurface partSurface_91 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 101"));

    PartSurface partSurface_92 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 52"));

    PartSurface partSurface_93 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 63"));

    PartSurface partSurface_94 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 39"));

    PartSurface partSurface_95 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 96"));

    PartSurface partSurface_96 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 8"));

    PartSurface partSurface_97 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 24"));

    PartSurface partSurface_98 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 16"));

    PartSurface partSurface_99 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 70"));

    PartSurface partSurface_100 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 47"));

    PartSurface partSurface_101 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 69"));

    PartSurface partSurface_102 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 81"));

    PartSurface partSurface_103 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 62"));

    PartSurface partSurface_104 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 44"));

    PartSurface partSurface_105 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 3"));

    meshPart_0.combinePartSurfaces(new ArrayList<>(Arrays.<PartSurface>asList(partSurface_5, partSurface_6, partSurface_7, partSurface_8, partSurface_9, partSurface_10, partSurface_11, partSurface_12, partSurface_13, partSurface_14, partSurface_15, partSurface_16, partSurface_17, partSurface_18, partSurface_19, partSurface_20, partSurface_21, partSurface_22, partSurface_23, partSurface_24, partSurface_25, partSurface_26, partSurface_27, partSurface_28, partSurface_29, partSurface_30, partSurface_31, partSurface_32, partSurface_33, partSurface_34, partSurface_35, partSurface_36, partSurface_37, partSurface_38, partSurface_39, partSurface_40, partSurface_41, partSurface_42, partSurface_43, partSurface_44, partSurface_45, partSurface_46, partSurface_47, partSurface_48, partSurface_49, partSurface_50, partSurface_51, partSurface_52, partSurface_53, partSurface_54, partSurface_55, partSurface_56, partSurface_57, partSurface_58, partSurface_59, partSurface_60, partSurface_61, partSurface_62, partSurface_63, partSurface_64, partSurface_65, partSurface_66, partSurface_67, partSurface_68, partSurface_69, partSurface_70, partSurface_71, partSurface_72, partSurface_73, partSurface_74, partSurface_75, partSurface_76, partSurface_77, partSurface_78, partSurface_79, partSurface_80, partSurface_81, partSurface_82, partSurface_83, partSurface_84, partSurface_85, partSurface_86, partSurface_87, partSurface_88, partSurface_89, partSurface_90, partSurface_91, partSurface_92, partSurface_93, partSurface_94, partSurface_95, partSurface_96, partSurface_97, partSurface_98, partSurface_99, partSurface_100, partSurface_101, partSurface_102, partSurface_103, partSurface_104, partSurface_105)));

    simulation_0.deleteObjects(new ArrayList<>(Arrays.<ClientServerObject>asList(partDisplayer_6)));

    PartDisplayer partDisplayer_7 = 
      scene_0.getDisplayerManager().createPartDisplayer("Surface", -1, 1);

    partDisplayer_7.setPresentationName("Floor");

    partDisplayer_7.setColorMode(PartColorMode.CONSTANT);

    partDisplayer_7.setRepresentation(partRepresentation_0);

    partDisplayer_7.getInputParts().setQuery(null);

    Boundary boundary_4 = 
      region_0.getBoundaryManager().getBoundary("floor");

    partDisplayer_7.getInputParts().setObjects(boundary_4);

    partDisplayer_7.setDisplayerColor(new DoubleVector(new double[] {0.0, 0.0, 0.0}));

    AdvancedRenderingEffects advancedRenderingEffects_3 = 
      partDisplayer_7.getAdvancedRenderingEffects();

    advancedRenderingEffects_3.setEnableSurfaceShadows(true);

    AdvancedRenderingMaterials advancedRenderingMaterials_2 = 
      advancedRenderingEffects_3.getAdvancedRenderingMaterials();

    advancedRenderingMaterials_2.setAdvancedRenderingEffectMode(AdvancedRenderingMaterials.AdvancedRenderingEffectsMode.METALLIC);

    PartDisplayer partDisplayer_8 = 
      scene_0.getDisplayerManager().createPartDisplayer("Dummy", -1, 0);

    partDisplayer_8.copyProperties(partDisplayer_7);

    partDisplayer_8.setPresentationName("Floor copy");

    Units units_1 = 
      simulation_0.getUnitsManager().getPreferredUnits(Dimensions.Builder().build());

    scene_0.setTransparencyOverrideMode(SceneTransparencyOverride.MAKE_SCENE_TRANSPARENT);

    scene_0.getCreatorGroup().setQuery(null);

    Region region_38 = 
      simulation_0.getRegionManager().getRegion("MRF-FL");

    Region region_39 = 
      simulation_0.getRegionManager().getRegion("MRF-FR");

    Region region_40 = 
      simulation_0.getRegionManager().getRegion("MRF-RL");

    Region region_41 = 
      simulation_0.getRegionManager().getRegion("MRF-RR");

    scene_0.getCreatorGroup().setObjects(region_0, region_38, region_39, region_40, region_41);

    Units units_2 = 
      simulation_0.getUnitsManager().getPreferredUnits(Dimensions.Builder().pressure(1).build());

    scene_0.getCreatorGroup().setQuery(null);
  }

  private void execute1() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 1");

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Air");

    Region region_38 = 
      simulation_0.getRegionManager().getRegion("MRF-FL");

    Region region_39 = 
      simulation_0.getRegionManager().getRegion("MRF-FR");

    Region region_40 = 
      simulation_0.getRegionManager().getRegion("MRF-RL");

    Region region_41 = 
      simulation_0.getRegionManager().getRegion("MRF-RR");

    scene_0.getCreatorGroup().setObjects(region_0, region_38, region_39, region_40, region_41);

    PartDisplayer partDisplayer_9 = 
      scene_0.getDisplayerManager().createPartDisplayer("Isosurface Surface", -1, 1);

    scene_0.setTransparencyOverrideMode(SceneTransparencyOverride.MAKE_SCENE_TRANSPARENT);

    PrimitiveFieldFunction primitiveFieldFunction_0 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("TotalPressure"));

    IsoPart isoPart_0 = 
      simulation_0.getPartManager().createIsoPart(new Vector<>(Arrays.asList(region_0, region_38, region_39, region_40, region_41)), primitiveFieldFunction_0, null);

    isoPart_0.setMode(IsoMode.ISOVALUE_SINGLE);

    SingleIsoValue singleIsoValue_0 = 
      isoPart_0.getSingleIsoValue();

    singleIsoValue_0.getValueQuantity().setValue(0.0);

    Units units_2 = 
      ((Units) simulation_0.getUnitsManager().getObject("Pa"));

    singleIsoValue_0.getValueQuantity().setUnits(units_2);

    partDisplayer_9.getVisibleParts().addParts(isoPart_0);

    partDisplayer_9.getHiddenParts().addParts();

    scene_0.setTransparencyOverrideMode(SceneTransparencyOverride.USE_DISPLAYER_PROPERTY);

    singleIsoValue_0.getValueQuantity().setValueAndUnits(51.148, units_2);

    Units units_3 = 
      simulation_0.getUnitsManager().getPreferredUnits(Dimensions.Builder().angle(1).build());

    Units units_0 = 
      simulation_0.getUnitsManager().getPreferredUnits(Dimensions.Builder().length(1).build());

    scene_0.setTransparencyOverrideMode(SceneTransparencyOverride.MAKE_SCENE_TRANSPARENT);

    scene_0.getCreatorGroup().setQuery(null);

    scene_0.getCreatorGroup().setObjects(region_0, region_38, region_39, region_40, region_41);

    scene_0.getCreatorGroup().setQuery(null);

    scene_0.getCreatorGroup().setObjects(region_0, region_38, region_39, region_40, region_41);

    ResampledVolumePart resampledVolumePart_0 = 
      simulation_0.getPartManager().createResampledVolumePart(new Vector<>(Arrays.asList(region_0, region_38, region_39, region_40, region_41)), 0.1, units_0, 0.001, units_0, units_0, units_0, new DoubleVector(new double[] {0.9249105043709278, 2.5, 0.4554840624332428}), units_0, units_0, units_0, new DoubleVector(new double[] {2.0428210124373436, 6.226031184196472, 0.7582506537437439}), units_0, units_0, units_0, new DoubleVector(new double[] {1.0, 0.0, 0.0}), units_3, 0.0, RefinementMetric.DIAGONAL, null);

    scene_0.setTransparencyOverrideMode(SceneTransparencyOverride.USE_DISPLAYER_PROPERTY);

    resampledVolumePart_0.getOriginCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {-3.0, 0.0, 1.5775701245293021}));

    resampledVolumePart_0.getSizeCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {42.0, 15.0, 3.18538442440331}));

    resampledVolumePart_0.getInputParts().setQuery(null);

    resampledVolumePart_0.getInputParts().setObjects(region_0);

    simulation_0.deleteObjects(new ArrayList<>(Arrays.<ClientServerObject>asList(partDisplayer_9)));

    ScalarDisplayer scalarDisplayer_0 = 
      scene_0.getDisplayerManager().createScalarDisplayer("Scalar", ClipMode.NONE);

    scalarDisplayer_0.setPresentationName("Isosurface Scalar 1");

    scalarDisplayer_0.setOpacity(0.391);

    scalarDisplayer_0.setFillMode(ScalarFillMode.NODE_SMOOTH);

    scalarDisplayer_0.setVisibilityOverrideMode(DisplayerVisibilityOverride.HIDE_ALL_PARTS);

    scalarDisplayer_0.getInputParts().setQuery(null);

    scalarDisplayer_0.getInputParts().setObjects(isoPart_0);

    PrimitiveFieldFunction primitiveFieldFunction_1 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Velocity"));

    VectorMagnitudeFieldFunction vectorMagnitudeFieldFunction_0 = 
      ((VectorMagnitudeFieldFunction) primitiveFieldFunction_1.getMagnitudeFunction());

    scalarDisplayer_0.getScalarDisplayQuantity().setFieldFunction(vectorMagnitudeFieldFunction_0);

    scalarDisplayer_0.getScalarDisplayQuantity().setAutoRange(AutoRangeMode.NONE);

    Units units_4 = 
      ((Units) simulation_0.getUnitsManager().getObject("m/s"));

    scalarDisplayer_0.getScalarDisplayQuantity().getMinimumValue().setValueAndUnits(5.0, units_4);

    scalarDisplayer_0.getScalarDisplayQuantity().getMaximumValue().setValueAndUnits(20.0, units_4);

    Legend legend_0 = 
      scalarDisplayer_0.getLegend();

    PredefinedLookupTable predefinedLookupTable_0 = 
      ((PredefinedLookupTable) simulation_0.get(LookupTableManager.class).getObject("tropical"));

    legend_0.setLookupTable(predefinedLookupTable_0);

    legend_0.setLevels(512);

    legend_0.setReverse(true);

    legend_0.setPositionCoordinate(new DoubleVector(new double[] {0.10407889033376662, 0.023056943056943034}));

    ScalarDisplayer scalarDisplayer_1 = 
      scene_0.getDisplayerManager().createScalarDisplayer("Dummy", ClipMode.NONE);

    scalarDisplayer_1.copyProperties(scalarDisplayer_0);

    scalarDisplayer_1.setPresentationName("Isosurface Scalar 1 copy");

    scalarDisplayer_1.setOpacity(0.6);

    SimpleTransform simpleTransform_0 = 
      ((SimpleTransform) simulation_0.getTransformManager().getObject("Simple Transform 1"));

    scalarDisplayer_1.setVisTransform(simpleTransform_0);

    VorticityVectorFunction vorticityVectorFunction_0 = 
      ((VorticityVectorFunction) simulation_0.getFieldFunctionManager().getFunction("VorticityVector"));

    VectorMagnitudeFieldFunction vectorMagnitudeFieldFunction_1 = 
      ((VectorMagnitudeFieldFunction) vorticityVectorFunction_0.getMagnitudeFunction());

    scalarDisplayer_1.getScalarDisplayQuantity().setFieldFunction(vectorMagnitudeFieldFunction_1);

    Units units_5 = 
      ((Units) simulation_0.getUnitsManager().getObject("/s"));

    scalarDisplayer_1.getScalarDisplayQuantity().getMinimumValue().setValueAndUnits(50.0, units_5);

    scalarDisplayer_1.getScalarDisplayQuantity().getMaximumValue().setValueAndUnits(800.0, units_5);

    Legend legend_1 = 
      scalarDisplayer_1.getLegend();

    CoolWarmBandLookupTable coolWarmBandLookupTable_0 = 
      ((CoolWarmBandLookupTable) simulation_0.get(LookupTableManager.class).getObject("cool-warm-band"));

    legend_1.setLookupTable(coolWarmBandLookupTable_0);

    legend_1.setWidth(0.017766651141126633);

    legend_1.setHeight(0.2);

    legend_1.updateLayout(new DoubleVector(new double[] {0.01296221590432993, 0.11417361748637972}), 0.2, 0.017766651141126633, 1);

    legend_1.setHeight(0.2);

    legend_1.setPositionCoordinate(new DoubleVector(new double[] {0.896872323030553, 0.15567532467532488}));

    scalarDisplayer_1.setVisibilityOverrideMode(DisplayerVisibilityOverride.USE_PART_PROPERTY);

    PartDisplayer partDisplayer_10 = 
      scene_0.getDisplayerManager().createPartDisplayer("Surface", -1, 1);

    partDisplayer_10.setPresentationName("Mesh 1");

    partDisplayer_10.setMesh(true);

    partDisplayer_10.setSurface(false);

    partDisplayer_10.setMeshColor(new DoubleVector(new double[] {1.0, 1.0, 1.0}));

    partDisplayer_10.getInputParts().setQuery(null);

    Boundary boundary_5 = 
      region_0.getBoundaryManager().getBoundary("outlet");

    Boundary boundary_6 = 
      region_0.getBoundaryManager().getBoundary("Walls");

    partDisplayer_10.getInputParts().setObjects(boundary_5, boundary_6);

    AdvancedRenderingEffects advancedRenderingEffects_4 = 
      partDisplayer_10.getAdvancedRenderingEffects();

    advancedRenderingEffects_4.setEnableSurfaceShadows(true);

    AdvancedRenderingMaterials advancedRenderingMaterials_3 = 
      advancedRenderingEffects_4.getAdvancedRenderingMaterials();

    advancedRenderingMaterials_3.setAdvancedRenderingEffectMode(AdvancedRenderingMaterials.AdvancedRenderingEffectsMode.METALLIC);

    ScalarDisplayer scalarDisplayer_2 = 
      scene_0.getDisplayerManager().createScalarDisplayer("Scalar", ClipMode.NONE);

    scalarDisplayer_2.setPresentationName("Resampled Volume Scalar 1");

    scalarDisplayer_2.setFillMode(ScalarFillMode.NODE_FILLED);

    scalarDisplayer_2.setVisibilityOverrideMode(DisplayerVisibilityOverride.HIDE_ALL_PARTS);

    scalarDisplayer_2.getInputParts().setQuery(null);

    scalarDisplayer_2.getInputParts().setObjects(resampledVolumePart_0);

    AdvancedRenderingEffects advancedRenderingEffects_5 = 
      scalarDisplayer_2.getAdvancedRenderingEffects();

    advancedRenderingEffects_5.setEnableSurfaceShadows(true);

    scalarDisplayer_2.getScalarDisplayQuantity().setFieldFunction(vectorMagnitudeFieldFunction_0);

    scalarDisplayer_2.getScalarDisplayQuantity().setAutoRange(AutoRangeMode.NONE);

    scalarDisplayer_2.getScalarDisplayQuantity().getMinimumValue().setValueAndUnits(5.0, units_4);

    scalarDisplayer_2.getScalarDisplayQuantity().getMaximumValue().setValueAndUnits(14.0, units_4);

    Legend legend_2 = 
      scalarDisplayer_2.getLegend();

    legend_2.setLookupTable(coolWarmBandLookupTable_0);

    legend_2.setLevels(512);

    legend_2.setWidth(0.034999999999999906);

    legend_2.setHeight(0.2);

    legend_2.setPositionCoordinate(new DoubleVector(new double[] {0.09102817885421517, 0.5220754245754247}));

    scene_0.setBackgroundColorMode(BackgroundColorMode.GRADIENT);

    GradientBackgroundColor gradientBackgroundColor_0 = 
      scene_0.getGradientBackgroundColor();

    gradientBackgroundColor_0.setMode(GradientMode.RADIAL);

    gradientBackgroundColor_0.setColor1(new DoubleVector(new double[] {1.0, 0.6600000262260437, 0.07000000029802322}));

    gradientBackgroundColor_0.setColor2(new DoubleVector(new double[] {1.0, 1.0, 1.0}));

    CurrentView currentView_0 = 
      scene_0.getCurrentView();

    currentView_0.getFocalPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {2.143109776611735, 4.064134985800201, 0.7879091145185235}));

    currentView_0.getPositionCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {7.491477785314779, 7.427935808971645, 0.7007522501401653}));

    currentView_0.getViewUpCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.010250580968754364, 0.009609481424595242, 0.9999012868562142}));

    SceneUpdate sceneUpdate_0 = 
      scene_0.getSceneUpdate();

    sceneUpdate_0.setSaveAnimation(true);

    sceneUpdate_0.setFilenameMode(WindowUpdate.FilenameModeEnum.AUTOMATIC);

    sceneUpdate_0.setAnimationFilenameBase("ss");

    sceneUpdate_0.setAnimationFilePath("plots");

    scene_0.getAnnotationPropManager().getAnnotationGroup().setQuery(null);

    LogoAnnotation logoAnnotation_0 = 
      ((LogoAnnotation) simulation_0.getAnnotationManager().getObject("Logo"));

    PhysicalTimeAnnotation physicalTimeAnnotation_0 = 
      ((PhysicalTimeAnnotation) simulation_0.getAnnotationManager().getObject("Solution Time"));

    scene_0.getAnnotationPropManager().getAnnotationGroup().setObjects(logoAnnotation_0, physicalTimeAnnotation_0);

    legend_1.setWidth(0.017766651141126633);

    ScalarDisplayer scalarDisplayer_3 = 
      scene_0.getDisplayerManager().createScalarDisplayer("Dummy", ClipMode.NONE);

    scalarDisplayer_3.copyProperties(scalarDisplayer_2);

    scalarDisplayer_3.setPresentationName("Resampled Volume Scalar 1 copy");

    scalarDisplayer_3.setVisibilityOverrideMode(DisplayerVisibilityOverride.USE_PART_PROPERTY);

    Legend legend_3 = 
      scalarDisplayer_3.getLegend();

    legend_3.setWidth(0.2);

    legend_3.setHeight(0.35);

    legend_3.setPositionCoordinate(new DoubleVector(new double[] {0.14779226828132278, 0.13604395604395605}));

    legend_3.setHeight(0.035);

    PartDisplayer partDisplayer_11 = 
      scene_0.getDisplayerManager().createPartDisplayer("Surface", -1, 1);

    partDisplayer_11.setColorMode(PartColorMode.CONSTANT);

    PartRepresentation partRepresentation_0 = 
      ((PartRepresentation) simulation_0.getRepresentationManager().getObject("Geometry"));

    partDisplayer_11.setRepresentation(partRepresentation_0);

    partDisplayer_11.getInputParts().setQuery(null);

    SolidModelCompositePart solidModelCompositePart_1 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("W_wheel_front-left"));

    SolidModelCompositePart solidModelCompositePart_9 = 
      ((SolidModelCompositePart) solidModelCompositePart_1.getChildParts().getPart("closeHoles"));

    SolidModelPart solidModelPart_4 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("Body 100"));

    PartSurface partSurface_106 = 
      ((PartSurface) solidModelPart_4.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_5 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("Body 101"));

    PartSurface partSurface_107 = 
      ((PartSurface) solidModelPart_5.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_6 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("Body 102"));

    PartSurface partSurface_108 = 
      ((PartSurface) solidModelPart_6.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_7 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("Body 103"));

    PartSurface partSurface_109 = 
      ((PartSurface) solidModelPart_7.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_8 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("Body 104"));

    PartSurface partSurface_110 = 
      ((PartSurface) solidModelPart_8.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_9 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("Body 105"));

    PartSurface partSurface_111 = 
      ((PartSurface) solidModelPart_9.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_10 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("Body 106"));

    PartSurface partSurface_112 = 
      ((PartSurface) solidModelPart_10.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_11 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("Body 107"));

    PartSurface partSurface_113 = 
      ((PartSurface) solidModelPart_11.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_12 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("Body 108"));

    PartSurface partSurface_114 = 
      ((PartSurface) solidModelPart_12.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_13 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("Body 109"));

    PartSurface partSurface_115 = 
      ((PartSurface) solidModelPart_13.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_14 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("Body 110"));

    PartSurface partSurface_116 = 
      ((PartSurface) solidModelPart_14.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_15 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("Body 111"));

    PartSurface partSurface_117 = 
      ((PartSurface) solidModelPart_15.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_16 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("Body 112"));

    PartSurface partSurface_118 = 
      ((PartSurface) solidModelPart_16.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_17 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("Body 113"));

    PartSurface partSurface_119 = 
      ((PartSurface) solidModelPart_17.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_18 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("Body 116"));

    PartSurface partSurface_120 = 
      ((PartSurface) solidModelPart_18.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_19 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("Body 122"));

    PartSurface partSurface_121 = 
      ((PartSurface) solidModelPart_19.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_20 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("Body 125"));

    PartSurface partSurface_122 = 
      ((PartSurface) solidModelPart_20.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_21 = 
      ((SolidModelPart) solidModelCompositePart_9.getChildParts().getPart("f4cd8729-e3b4-4e0c-8ef1-25bca2369593_Body 5"));

    PartSurface partSurface_123 = 
      ((PartSurface) solidModelPart_21.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_22 = 
      ((SolidModelPart) solidModelCompositePart_1.getChildParts().getPart("contactPatch"));

    PartSurface partSurface_124 = 
      ((PartSurface) solidModelPart_22.getPartSurfaceManager().getPartSurface("ColoredFace1"));

    PartSurface partSurface_125 = 
      ((PartSurface) solidModelPart_22.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_23 = 
      ((SolidModelPart) solidModelCompositePart_1.getChildParts().getPart("Rim"));

    PartSurface partSurface_126 = 
      ((PartSurface) solidModelPart_23.getPartSurfaceManager().getPartSurface("Default"));

    PartSurface partSurface_127 = 
      ((PartSurface) solidModelPart_23.getPartSurfaceManager().getPartSurface("Default 2"));

    SolidModelPart solidModelPart_24 = 
      ((SolidModelPart) solidModelCompositePart_1.getChildParts().getPart("sockel"));

    PartSurface partSurface_128 = 
      ((PartSurface) solidModelPart_24.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_25 = 
      ((SolidModelPart) solidModelCompositePart_1.getChildParts().getPart("tire"));

    PartSurface partSurface_129 = 
      ((PartSurface) solidModelPart_25.getPartSurfaceManager().getPartSurface("contact_surface"));

    PartSurface partSurface_130 = 
      ((PartSurface) solidModelPart_25.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelCompositePart solidModelCompositePart_0 = 
      ((SolidModelCompositePart) solidModelCompositePart_1.getChildParts().getPart("wheelhub"));

    SolidModelPart solidModelPart_26 = 
      ((SolidModelPart) solidModelCompositePart_0.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 14"));

    PartSurface partSurface_131 = 
      ((PartSurface) solidModelPart_26.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_27 = 
      ((SolidModelPart) solidModelCompositePart_0.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 15"));

    PartSurface partSurface_132 = 
      ((PartSurface) solidModelPart_27.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_28 = 
      ((SolidModelPart) solidModelCompositePart_0.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 16"));

    PartSurface partSurface_133 = 
      ((PartSurface) solidModelPart_28.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_29 = 
      ((SolidModelPart) solidModelCompositePart_0.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 17"));

    PartSurface partSurface_134 = 
      ((PartSurface) solidModelPart_29.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_30 = 
      ((SolidModelPart) solidModelCompositePart_0.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 18"));

    PartSurface partSurface_135 = 
      ((PartSurface) solidModelPart_30.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_31 = 
      ((SolidModelPart) solidModelCompositePart_0.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 19"));

    PartSurface partSurface_136 = 
      ((PartSurface) solidModelPart_31.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_32 = 
      ((SolidModelPart) solidModelCompositePart_0.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 20"));

    PartSurface partSurface_137 = 
      ((PartSurface) solidModelPart_32.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_33 = 
      ((SolidModelPart) solidModelCompositePart_0.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 21"));

    PartSurface partSurface_138 = 
      ((PartSurface) solidModelPart_33.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_34 = 
      ((SolidModelPart) solidModelCompositePart_0.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 22"));

    PartSurface partSurface_139 = 
      ((PartSurface) solidModelPart_34.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_35 = 
      ((SolidModelPart) solidModelCompositePart_0.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 23"));

    PartSurface partSurface_140 = 
      ((PartSurface) solidModelPart_35.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_36 = 
      ((SolidModelPart) solidModelCompositePart_0.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 24"));

    PartSurface partSurface_141 = 
      ((PartSurface) solidModelPart_36.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_37 = 
      ((SolidModelPart) solidModelCompositePart_0.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 25"));

    PartSurface partSurface_142 = 
      ((PartSurface) solidModelPart_37.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_38 = 
      ((SolidModelPart) solidModelCompositePart_0.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 26"));

    PartSurface partSurface_143 = 
      ((PartSurface) solidModelPart_38.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_0 = 
      ((SolidModelPart) solidModelCompositePart_0.getChildParts().getPart("Body 37 2"));

    PartSurface partSurface_0 = 
      ((PartSurface) solidModelPart_0.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_39 = 
      ((SolidModelPart) solidModelCompositePart_0.getChildParts().getPart("TRM_SRF 2 8"));

    PartSurface partSurface_144 = 
      ((PartSurface) solidModelPart_39.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_40 = 
      ((SolidModelPart) solidModelCompositePart_0.getChildParts().getPart("TRM_SRF 3 10"));

    PartSurface partSurface_145 = 
      ((PartSurface) solidModelPart_40.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_41 = 
      ((SolidModelPart) solidModelCompositePart_0.getChildParts().getPart("TRM_SRF 4 9"));

    PartSurface partSurface_146 = 
      ((PartSurface) solidModelPart_41.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_42 = 
      ((SolidModelPart) solidModelCompositePart_0.getChildParts().getPart("TRM_SRF 5 9"));

    PartSurface partSurface_147 = 
      ((PartSurface) solidModelPart_42.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_43 = 
      ((SolidModelPart) solidModelCompositePart_0.getChildParts().getPart("TRM_SRF 6 9"));

    PartSurface partSurface_148 = 
      ((PartSurface) solidModelPart_43.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_44 = 
      ((SolidModelPart) solidModelCompositePart_0.getChildParts().getPart("TRM_SRF 7 9"));

    PartSurface partSurface_149 = 
      ((PartSurface) solidModelPart_44.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_45 = 
      ((SolidModelPart) solidModelCompositePart_0.getChildParts().getPart("TRM_SRF 8 9"));

    PartSurface partSurface_150 = 
      ((PartSurface) solidModelPart_45.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_46 = 
      ((SolidModelPart) solidModelCompositePart_0.getChildParts().getPart("TRM_SRF 9 8"));

    PartSurface partSurface_151 = 
      ((PartSurface) solidModelPart_46.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_47 = 
      ((SolidModelPart) solidModelCompositePart_0.getChildParts().getPart("TRM_SRF 10 6"));

    PartSurface partSurface_152 = 
      ((PartSurface) solidModelPart_47.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_48 = 
      ((SolidModelPart) solidModelCompositePart_0.getChildParts().getPart("TRM_SRF 11 7"));

    PartSurface partSurface_153 = 
      ((PartSurface) solidModelPart_48.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_49 = 
      ((SolidModelPart) solidModelCompositePart_0.getChildParts().getPart("TRM_SRF 12 5"));

    PartSurface partSurface_154 = 
      ((PartSurface) solidModelPart_49.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_50 = 
      ((SolidModelPart) solidModelCompositePart_0.getChildParts().getPart("TRM_SRF 13 6"));

    PartSurface partSurface_155 = 
      ((PartSurface) solidModelPart_50.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_51 = 
      ((SolidModelPart) solidModelCompositePart_0.getChildParts().getPart("TRM_SRF 14 7"));

    PartSurface partSurface_156 = 
      ((PartSurface) solidModelPart_51.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_52 = 
      ((SolidModelPart) solidModelCompositePart_0.getChildParts().getPart("TRM_SRF 15 7"));

    PartSurface partSurface_157 = 
      ((PartSurface) solidModelPart_52.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_53 = 
      ((SolidModelPart) solidModelCompositePart_0.getChildParts().getPart("TRM_SRF 16 7"));

    PartSurface partSurface_158 = 
      ((PartSurface) solidModelPart_53.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_54 = 
      ((SolidModelPart) solidModelCompositePart_0.getChildParts().getPart("TRM_SRF 17 7"));

    PartSurface partSurface_159 = 
      ((PartSurface) solidModelPart_54.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_55 = 
      ((SolidModelPart) solidModelCompositePart_0.getChildParts().getPart("TRM_SRF 18 7"));

    PartSurface partSurface_160 = 
      ((PartSurface) solidModelPart_55.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_56 = 
      ((SolidModelPart) solidModelCompositePart_0.getChildParts().getPart("TRM_SRF 19 7"));

    PartSurface partSurface_161 = 
      ((PartSurface) solidModelPart_56.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_57 = 
      ((SolidModelPart) solidModelCompositePart_0.getChildParts().getPart("TRM_SRF 20 6"));

    PartSurface partSurface_162 = 
      ((PartSurface) solidModelPart_57.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_58 = 
      ((SolidModelPart) solidModelCompositePart_0.getChildParts().getPart("TRM_SRF 21 6"));

    PartSurface partSurface_163 = 
      ((PartSurface) solidModelPart_58.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_59 = 
      ((SolidModelPart) solidModelCompositePart_0.getChildParts().getPart("TRM_SRF 22 6"));

    PartSurface partSurface_164 = 
      ((PartSurface) solidModelPart_59.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_60 = 
      ((SolidModelPart) solidModelCompositePart_0.getChildParts().getPart("TRM_SRF 23 6"));

    PartSurface partSurface_165 = 
      ((PartSurface) solidModelPart_60.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_61 = 
      ((SolidModelPart) solidModelCompositePart_0.getChildParts().getPart("TRM_SRF 88"));

    PartSurface partSurface_166 = 
      ((PartSurface) solidModelPart_61.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelCompositePart solidModelCompositePart_3 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("W_wheel_front-right"));

    SolidModelPart solidModelPart_62 = 
      ((SolidModelPart) solidModelCompositePart_3.getChildParts().getPart("Body 23"));

    PartSurface partSurface_167 = 
      ((PartSurface) solidModelPart_62.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelCompositePart solidModelCompositePart_10 = 
      ((SolidModelCompositePart) solidModelCompositePart_3.getChildParts().getPart("closeHoles"));

    SolidModelPart solidModelPart_63 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("Body 6"));

    PartSurface partSurface_168 = 
      ((PartSurface) solidModelPart_63.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_64 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("Body 7"));

    PartSurface partSurface_169 = 
      ((PartSurface) solidModelPart_64.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_65 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("Body 8"));

    PartSurface partSurface_170 = 
      ((PartSurface) solidModelPart_65.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_66 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("Body 9"));

    PartSurface partSurface_171 = 
      ((PartSurface) solidModelPart_66.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_67 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("Body 10"));

    PartSurface partSurface_172 = 
      ((PartSurface) solidModelPart_67.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_68 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("Body 11"));

    PartSurface partSurface_173 = 
      ((PartSurface) solidModelPart_68.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_69 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("Body 12"));

    PartSurface partSurface_174 = 
      ((PartSurface) solidModelPart_69.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_70 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("Body 13"));

    PartSurface partSurface_175 = 
      ((PartSurface) solidModelPart_70.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_71 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("Body 14"));

    PartSurface partSurface_176 = 
      ((PartSurface) solidModelPart_71.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_72 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("Body 15"));

    PartSurface partSurface_177 = 
      ((PartSurface) solidModelPart_72.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_73 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("Body 16"));

    PartSurface partSurface_178 = 
      ((PartSurface) solidModelPart_73.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_74 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("Body 17"));

    PartSurface partSurface_179 = 
      ((PartSurface) solidModelPart_74.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_75 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("Body 18"));

    PartSurface partSurface_180 = 
      ((PartSurface) solidModelPart_75.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_76 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("Body 19"));

    PartSurface partSurface_181 = 
      ((PartSurface) solidModelPart_76.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_77 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("Body 20"));

    PartSurface partSurface_182 = 
      ((PartSurface) solidModelPart_77.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_78 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("Body 21"));

    PartSurface partSurface_183 = 
      ((PartSurface) solidModelPart_78.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_79 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("Body 22"));

    PartSurface partSurface_184 = 
      ((PartSurface) solidModelPart_79.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_80 = 
      ((SolidModelPart) solidModelCompositePart_10.getChildParts().getPart("f4cd8729-e3b4-4e0c-8ef1-25bca2369593_Body"));

    PartSurface partSurface_185 = 
      ((PartSurface) solidModelPart_80.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_81 = 
      ((SolidModelPart) solidModelCompositePart_3.getChildParts().getPart("Rim"));

    PartSurface partSurface_186 = 
      ((PartSurface) solidModelPart_81.getPartSurfaceManager().getPartSurface("Default"));

    PartSurface partSurface_187 = 
      ((PartSurface) solidModelPart_81.getPartSurfaceManager().getPartSurface("Default 2"));

    SolidModelPart solidModelPart_82 = 
      ((SolidModelPart) solidModelCompositePart_3.getChildParts().getPart("sockel 2"));

    PartSurface partSurface_188 = 
      ((PartSurface) solidModelPart_82.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_83 = 
      ((SolidModelPart) solidModelCompositePart_3.getChildParts().getPart("tire"));

    PartSurface partSurface_189 = 
      ((PartSurface) solidModelPart_83.getPartSurfaceManager().getPartSurface("contact_surface"));

    PartSurface partSurface_190 = 
      ((PartSurface) solidModelPart_83.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelCompositePart solidModelCompositePart_2 = 
      ((SolidModelCompositePart) solidModelCompositePart_3.getChildParts().getPart("wheelhub"));

    SolidModelPart solidModelPart_84 = 
      ((SolidModelPart) solidModelCompositePart_2.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body"));

    PartSurface partSurface_191 = 
      ((PartSurface) solidModelPart_84.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_85 = 
      ((SolidModelPart) solidModelCompositePart_2.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 2"));

    PartSurface partSurface_192 = 
      ((PartSurface) solidModelPart_85.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_86 = 
      ((SolidModelPart) solidModelCompositePart_2.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 3"));

    PartSurface partSurface_193 = 
      ((PartSurface) solidModelPart_86.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_87 = 
      ((SolidModelPart) solidModelCompositePart_2.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 4"));

    PartSurface partSurface_194 = 
      ((PartSurface) solidModelPart_87.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_88 = 
      ((SolidModelPart) solidModelCompositePart_2.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 5"));

    PartSurface partSurface_195 = 
      ((PartSurface) solidModelPart_88.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_89 = 
      ((SolidModelPart) solidModelCompositePart_2.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 6"));

    PartSurface partSurface_196 = 
      ((PartSurface) solidModelPart_89.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_90 = 
      ((SolidModelPart) solidModelCompositePart_2.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 7"));

    PartSurface partSurface_197 = 
      ((PartSurface) solidModelPart_90.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_91 = 
      ((SolidModelPart) solidModelCompositePart_2.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 8"));

    PartSurface partSurface_198 = 
      ((PartSurface) solidModelPart_91.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_92 = 
      ((SolidModelPart) solidModelCompositePart_2.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 9"));

    PartSurface partSurface_199 = 
      ((PartSurface) solidModelPart_92.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_93 = 
      ((SolidModelPart) solidModelCompositePart_2.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 10"));

    PartSurface partSurface_200 = 
      ((PartSurface) solidModelPart_93.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_94 = 
      ((SolidModelPart) solidModelCompositePart_2.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 11"));

    PartSurface partSurface_201 = 
      ((PartSurface) solidModelPart_94.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_95 = 
      ((SolidModelPart) solidModelCompositePart_2.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 12"));

    PartSurface partSurface_202 = 
      ((PartSurface) solidModelPart_95.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_96 = 
      ((SolidModelPart) solidModelCompositePart_2.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 13"));

    PartSurface partSurface_203 = 
      ((PartSurface) solidModelPart_96.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_1 = 
      ((SolidModelPart) solidModelCompositePart_2.getChildParts().getPart("Body 37"));

    PartSurface partSurface_1 = 
      ((PartSurface) solidModelPart_1.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_97 = 
      ((SolidModelPart) solidModelCompositePart_2.getChildParts().getPart("TRM_SRF 2 6"));

    PartSurface partSurface_204 = 
      ((PartSurface) solidModelPart_97.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_98 = 
      ((SolidModelPart) solidModelCompositePart_2.getChildParts().getPart("TRM_SRF 3 8"));

    PartSurface partSurface_205 = 
      ((PartSurface) solidModelPart_98.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_99 = 
      ((SolidModelPart) solidModelCompositePart_2.getChildParts().getPart("TRM_SRF 4 7"));

    PartSurface partSurface_206 = 
      ((PartSurface) solidModelPart_99.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_100 = 
      ((SolidModelPart) solidModelCompositePart_2.getChildParts().getPart("TRM_SRF 5 7"));

    PartSurface partSurface_207 = 
      ((PartSurface) solidModelPart_100.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_101 = 
      ((SolidModelPart) solidModelCompositePart_2.getChildParts().getPart("TRM_SRF 6 7"));

    PartSurface partSurface_208 = 
      ((PartSurface) solidModelPart_101.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_102 = 
      ((SolidModelPart) solidModelCompositePart_2.getChildParts().getPart("TRM_SRF 7 7"));

    PartSurface partSurface_209 = 
      ((PartSurface) solidModelPart_102.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_103 = 
      ((SolidModelPart) solidModelCompositePart_2.getChildParts().getPart("TRM_SRF 8 7"));

    PartSurface partSurface_210 = 
      ((PartSurface) solidModelPart_103.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_104 = 
      ((SolidModelPart) solidModelCompositePart_2.getChildParts().getPart("TRM_SRF 9 6"));

    PartSurface partSurface_211 = 
      ((PartSurface) solidModelPart_104.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_105 = 
      ((SolidModelPart) solidModelCompositePart_2.getChildParts().getPart("TRM_SRF 10 4"));

    PartSurface partSurface_212 = 
      ((PartSurface) solidModelPart_105.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_106 = 
      ((SolidModelPart) solidModelCompositePart_2.getChildParts().getPart("TRM_SRF 11 5"));

    PartSurface partSurface_213 = 
      ((PartSurface) solidModelPart_106.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_107 = 
      ((SolidModelPart) solidModelCompositePart_2.getChildParts().getPart("TRM_SRF 12 3"));

    PartSurface partSurface_214 = 
      ((PartSurface) solidModelPart_107.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_108 = 
      ((SolidModelPart) solidModelCompositePart_2.getChildParts().getPart("TRM_SRF 13 5"));

    PartSurface partSurface_215 = 
      ((PartSurface) solidModelPart_108.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_109 = 
      ((SolidModelPart) solidModelCompositePart_2.getChildParts().getPart("TRM_SRF 14 5"));

    PartSurface partSurface_216 = 
      ((PartSurface) solidModelPart_109.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_110 = 
      ((SolidModelPart) solidModelCompositePart_2.getChildParts().getPart("TRM_SRF 15 5"));

    PartSurface partSurface_217 = 
      ((PartSurface) solidModelPart_110.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_111 = 
      ((SolidModelPart) solidModelCompositePart_2.getChildParts().getPart("TRM_SRF 16 5"));

    PartSurface partSurface_218 = 
      ((PartSurface) solidModelPart_111.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_112 = 
      ((SolidModelPart) solidModelCompositePart_2.getChildParts().getPart("TRM_SRF 17 5"));

    PartSurface partSurface_219 = 
      ((PartSurface) solidModelPart_112.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_113 = 
      ((SolidModelPart) solidModelCompositePart_2.getChildParts().getPart("TRM_SRF 18 5"));

    PartSurface partSurface_220 = 
      ((PartSurface) solidModelPart_113.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_114 = 
      ((SolidModelPart) solidModelCompositePart_2.getChildParts().getPart("TRM_SRF 19 5"));

    PartSurface partSurface_221 = 
      ((PartSurface) solidModelPart_114.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_115 = 
      ((SolidModelPart) solidModelCompositePart_2.getChildParts().getPart("TRM_SRF 20 5"));

    PartSurface partSurface_222 = 
      ((PartSurface) solidModelPart_115.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_116 = 
      ((SolidModelPart) solidModelCompositePart_2.getChildParts().getPart("TRM_SRF 21 5"));

    PartSurface partSurface_223 = 
      ((PartSurface) solidModelPart_116.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_117 = 
      ((SolidModelPart) solidModelCompositePart_2.getChildParts().getPart("TRM_SRF 22 5"));

    PartSurface partSurface_224 = 
      ((PartSurface) solidModelPart_117.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_118 = 
      ((SolidModelPart) solidModelCompositePart_2.getChildParts().getPart("TRM_SRF 23 5"));

    PartSurface partSurface_225 = 
      ((PartSurface) solidModelPart_118.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_119 = 
      ((SolidModelPart) solidModelCompositePart_2.getChildParts().getPart("TRM_SRF 86"));

    PartSurface partSurface_226 = 
      ((PartSurface) solidModelPart_119.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelCompositePart solidModelCompositePart_5 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("W_wheel_rear-left"));

    SolidModelCompositePart solidModelCompositePart_11 = 
      ((SolidModelCompositePart) solidModelCompositePart_5.getChildParts().getPart("closeHoles"));

    SolidModelPart solidModelPart_120 = 
      ((SolidModelPart) solidModelCompositePart_11.getChildParts().getPart("Body 156"));

    PartSurface partSurface_227 = 
      ((PartSurface) solidModelPart_120.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_121 = 
      ((SolidModelPart) solidModelCompositePart_11.getChildParts().getPart("Body 157"));

    PartSurface partSurface_228 = 
      ((PartSurface) solidModelPart_121.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_122 = 
      ((SolidModelPart) solidModelCompositePart_11.getChildParts().getPart("Body 158"));

    PartSurface partSurface_229 = 
      ((PartSurface) solidModelPart_122.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_123 = 
      ((SolidModelPart) solidModelCompositePart_11.getChildParts().getPart("Body 159"));

    PartSurface partSurface_230 = 
      ((PartSurface) solidModelPart_123.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_124 = 
      ((SolidModelPart) solidModelCompositePart_11.getChildParts().getPart("Body 160"));

    PartSurface partSurface_231 = 
      ((PartSurface) solidModelPart_124.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_125 = 
      ((SolidModelPart) solidModelCompositePart_11.getChildParts().getPart("Body 161"));

    PartSurface partSurface_232 = 
      ((PartSurface) solidModelPart_125.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_126 = 
      ((SolidModelPart) solidModelCompositePart_11.getChildParts().getPart("Body 162"));

    PartSurface partSurface_233 = 
      ((PartSurface) solidModelPart_126.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_127 = 
      ((SolidModelPart) solidModelCompositePart_11.getChildParts().getPart("Body 163"));

    PartSurface partSurface_234 = 
      ((PartSurface) solidModelPart_127.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_128 = 
      ((SolidModelPart) solidModelCompositePart_11.getChildParts().getPart("Body 164"));

    PartSurface partSurface_235 = 
      ((PartSurface) solidModelPart_128.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_129 = 
      ((SolidModelPart) solidModelCompositePart_11.getChildParts().getPart("Body 165"));

    PartSurface partSurface_236 = 
      ((PartSurface) solidModelPart_129.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_130 = 
      ((SolidModelPart) solidModelCompositePart_11.getChildParts().getPart("Body 166"));

    PartSurface partSurface_237 = 
      ((PartSurface) solidModelPart_130.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_131 = 
      ((SolidModelPart) solidModelCompositePart_11.getChildParts().getPart("Body 167"));

    PartSurface partSurface_238 = 
      ((PartSurface) solidModelPart_131.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_132 = 
      ((SolidModelPart) solidModelCompositePart_11.getChildParts().getPart("Body 168"));

    PartSurface partSurface_239 = 
      ((PartSurface) solidModelPart_132.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_133 = 
      ((SolidModelPart) solidModelCompositePart_11.getChildParts().getPart("Body 169"));

    PartSurface partSurface_240 = 
      ((PartSurface) solidModelPart_133.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_134 = 
      ((SolidModelPart) solidModelCompositePart_11.getChildParts().getPart("Body 173"));

    PartSurface partSurface_241 = 
      ((PartSurface) solidModelPart_134.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_135 = 
      ((SolidModelPart) solidModelCompositePart_11.getChildParts().getPart("Body 176"));

    PartSurface partSurface_242 = 
      ((PartSurface) solidModelPart_135.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_136 = 
      ((SolidModelPart) solidModelCompositePart_11.getChildParts().getPart("Body 180"));

    PartSurface partSurface_243 = 
      ((PartSurface) solidModelPart_136.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_137 = 
      ((SolidModelPart) solidModelCompositePart_11.getChildParts().getPart("Body 184"));

    PartSurface partSurface_244 = 
      ((PartSurface) solidModelPart_137.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_138 = 
      ((SolidModelPart) solidModelCompositePart_11.getChildParts().getPart("f4cd8729-e3b4-4e0c-8ef1-25bca2369593_Body 7"));

    PartSurface partSurface_245 = 
      ((PartSurface) solidModelPart_138.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_139 = 
      ((SolidModelPart) solidModelCompositePart_5.getChildParts().getPart("contactPatch"));

    PartSurface partSurface_246 = 
      ((PartSurface) solidModelPart_139.getPartSurfaceManager().getPartSurface("ColoredFace1"));

    PartSurface partSurface_247 = 
      ((PartSurface) solidModelPart_139.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_140 = 
      ((SolidModelPart) solidModelCompositePart_5.getChildParts().getPart("RIm"));

    PartSurface partSurface_248 = 
      ((PartSurface) solidModelPart_140.getPartSurfaceManager().getPartSurface("Default"));

    PartSurface partSurface_249 = 
      ((PartSurface) solidModelPart_140.getPartSurfaceManager().getPartSurface("Default 2"));

    SolidModelPart solidModelPart_141 = 
      ((SolidModelPart) solidModelCompositePart_5.getChildParts().getPart("sockel 3"));

    PartSurface partSurface_250 = 
      ((PartSurface) solidModelPart_141.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_142 = 
      ((SolidModelPart) solidModelCompositePart_5.getChildParts().getPart("tire"));

    PartSurface partSurface_251 = 
      ((PartSurface) solidModelPart_142.getPartSurfaceManager().getPartSurface("contact_surface"));

    PartSurface partSurface_252 = 
      ((PartSurface) solidModelPart_142.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelCompositePart solidModelCompositePart_4 = 
      ((SolidModelCompositePart) solidModelCompositePart_5.getChildParts().getPart("wheelhub"));

    SolidModelPart solidModelPart_2 = 
      ((SolidModelPart) solidModelCompositePart_4.getChildParts().getPart("Body 1 10"));

    PartSurface partSurface_2 = 
      ((PartSurface) solidModelPart_2.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_143 = 
      ((SolidModelPart) solidModelCompositePart_4.getChildParts().getPart("de255532-0c4a-485e-9789-59152b929c88_Body 3"));

    PartSurface partSurface_253 = 
      ((PartSurface) solidModelPart_143.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_144 = 
      ((SolidModelPart) solidModelCompositePart_4.getChildParts().getPart("de255532-0c4a-485e-9789-59152b929c88_Body 4"));

    PartSurface partSurface_254 = 
      ((PartSurface) solidModelPart_144.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_145 = 
      ((SolidModelPart) solidModelCompositePart_4.getChildParts().getPart("TRM_SRF 2 9"));

    PartSurface partSurface_255 = 
      ((PartSurface) solidModelPart_145.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_146 = 
      ((SolidModelPart) solidModelCompositePart_4.getChildParts().getPart("TRM_SRF 3 11"));

    PartSurface partSurface_256 = 
      ((PartSurface) solidModelPart_146.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_147 = 
      ((SolidModelPart) solidModelCompositePart_4.getChildParts().getPart("TRM_SRF 4 10"));

    PartSurface partSurface_257 = 
      ((PartSurface) solidModelPart_147.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_148 = 
      ((SolidModelPart) solidModelCompositePart_4.getChildParts().getPart("TRM_SRF 5 10"));

    PartSurface partSurface_258 = 
      ((PartSurface) solidModelPart_148.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_149 = 
      ((SolidModelPart) solidModelCompositePart_4.getChildParts().getPart("TRM_SRF 6 10"));

    PartSurface partSurface_259 = 
      ((PartSurface) solidModelPart_149.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_150 = 
      ((SolidModelPart) solidModelCompositePart_4.getChildParts().getPart("TRM_SRF 7 10"));

    PartSurface partSurface_260 = 
      ((PartSurface) solidModelPart_150.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_151 = 
      ((SolidModelPart) solidModelCompositePart_4.getChildParts().getPart("TRM_SRF 8 10"));

    PartSurface partSurface_261 = 
      ((PartSurface) solidModelPart_151.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_152 = 
      ((SolidModelPart) solidModelCompositePart_4.getChildParts().getPart("TRM_SRF 9 9"));

    PartSurface partSurface_262 = 
      ((PartSurface) solidModelPart_152.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_153 = 
      ((SolidModelPart) solidModelCompositePart_4.getChildParts().getPart("TRM_SRF 10 7"));

    PartSurface partSurface_263 = 
      ((PartSurface) solidModelPart_153.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_154 = 
      ((SolidModelPart) solidModelCompositePart_4.getChildParts().getPart("TRM_SRF 11 8"));

    PartSurface partSurface_264 = 
      ((PartSurface) solidModelPart_154.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_155 = 
      ((SolidModelPart) solidModelCompositePart_4.getChildParts().getPart("TRM_SRF 12 6"));

    PartSurface partSurface_265 = 
      ((PartSurface) solidModelPart_155.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_156 = 
      ((SolidModelPart) solidModelCompositePart_4.getChildParts().getPart("TRM_SRF 14 8"));

    PartSurface partSurface_266 = 
      ((PartSurface) solidModelPart_156.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_157 = 
      ((SolidModelPart) solidModelCompositePart_4.getChildParts().getPart("TRM_SRF 15 8"));

    PartSurface partSurface_267 = 
      ((PartSurface) solidModelPart_157.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_158 = 
      ((SolidModelPart) solidModelCompositePart_4.getChildParts().getPart("TRM_SRF 16 8"));

    PartSurface partSurface_268 = 
      ((PartSurface) solidModelPart_158.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_159 = 
      ((SolidModelPart) solidModelCompositePart_4.getChildParts().getPart("TRM_SRF 17 8"));

    PartSurface partSurface_269 = 
      ((PartSurface) solidModelPart_159.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_160 = 
      ((SolidModelPart) solidModelCompositePart_4.getChildParts().getPart("TRM_SRF 18 8"));

    PartSurface partSurface_270 = 
      ((PartSurface) solidModelPart_160.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_161 = 
      ((SolidModelPart) solidModelCompositePart_4.getChildParts().getPart("TRM_SRF 19 8"));

    PartSurface partSurface_271 = 
      ((PartSurface) solidModelPart_161.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_162 = 
      ((SolidModelPart) solidModelCompositePart_4.getChildParts().getPart("TRM_SRF 89"));

    PartSurface partSurface_272 = 
      ((PartSurface) solidModelPart_162.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelCompositePart solidModelCompositePart_7 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("W_wheel_rear-right"));

    SolidModelCompositePart solidModelCompositePart_12 = 
      ((SolidModelCompositePart) solidModelCompositePart_7.getChildParts().getPart("closeHoles"));

    SolidModelPart solidModelPart_163 = 
      ((SolidModelPart) solidModelCompositePart_12.getChildParts().getPart("Body 23"));

    PartSurface partSurface_273 = 
      ((PartSurface) solidModelPart_163.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_164 = 
      ((SolidModelPart) solidModelCompositePart_12.getChildParts().getPart("Body 24"));

    PartSurface partSurface_274 = 
      ((PartSurface) solidModelPart_164.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_165 = 
      ((SolidModelPart) solidModelCompositePart_12.getChildParts().getPart("Body 25"));

    PartSurface partSurface_275 = 
      ((PartSurface) solidModelPart_165.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_166 = 
      ((SolidModelPart) solidModelCompositePart_12.getChildParts().getPart("Body 26"));

    PartSurface partSurface_276 = 
      ((PartSurface) solidModelPart_166.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_167 = 
      ((SolidModelPart) solidModelCompositePart_12.getChildParts().getPart("Body 27"));

    PartSurface partSurface_277 = 
      ((PartSurface) solidModelPart_167.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_168 = 
      ((SolidModelPart) solidModelCompositePart_12.getChildParts().getPart("Body 28"));

    PartSurface partSurface_278 = 
      ((PartSurface) solidModelPart_168.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_169 = 
      ((SolidModelPart) solidModelCompositePart_12.getChildParts().getPart("Body 29"));

    PartSurface partSurface_279 = 
      ((PartSurface) solidModelPart_169.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_170 = 
      ((SolidModelPart) solidModelCompositePart_12.getChildParts().getPart("Body 30"));

    PartSurface partSurface_280 = 
      ((PartSurface) solidModelPart_170.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_171 = 
      ((SolidModelPart) solidModelCompositePart_12.getChildParts().getPart("Body 31"));

    PartSurface partSurface_281 = 
      ((PartSurface) solidModelPart_171.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_172 = 
      ((SolidModelPart) solidModelCompositePart_12.getChildParts().getPart("Body 32"));

    PartSurface partSurface_282 = 
      ((PartSurface) solidModelPart_172.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_173 = 
      ((SolidModelPart) solidModelCompositePart_12.getChildParts().getPart("Body 33"));

    PartSurface partSurface_283 = 
      ((PartSurface) solidModelPart_173.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_174 = 
      ((SolidModelPart) solidModelCompositePart_12.getChildParts().getPart("Body 34"));

    PartSurface partSurface_284 = 
      ((PartSurface) solidModelPart_174.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_175 = 
      ((SolidModelPart) solidModelCompositePart_12.getChildParts().getPart("Body 35"));

    PartSurface partSurface_285 = 
      ((PartSurface) solidModelPart_175.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_176 = 
      ((SolidModelPart) solidModelCompositePart_12.getChildParts().getPart("Body 36"));

    PartSurface partSurface_286 = 
      ((PartSurface) solidModelPart_176.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_177 = 
      ((SolidModelPart) solidModelCompositePart_12.getChildParts().getPart("Body 38"));

    PartSurface partSurface_287 = 
      ((PartSurface) solidModelPart_177.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_178 = 
      ((SolidModelPart) solidModelCompositePart_12.getChildParts().getPart("Body 41"));

    PartSurface partSurface_288 = 
      ((PartSurface) solidModelPart_178.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_179 = 
      ((SolidModelPart) solidModelCompositePart_12.getChildParts().getPart("Body 43"));

    PartSurface partSurface_289 = 
      ((PartSurface) solidModelPart_179.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_180 = 
      ((SolidModelPart) solidModelCompositePart_12.getChildParts().getPart("Body 45"));

    PartSurface partSurface_290 = 
      ((PartSurface) solidModelPart_180.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_181 = 
      ((SolidModelPart) solidModelCompositePart_12.getChildParts().getPart("f4cd8729-e3b4-4e0c-8ef1-25bca2369593_Body 3"));

    PartSurface partSurface_291 = 
      ((PartSurface) solidModelPart_181.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_182 = 
      ((SolidModelPart) solidModelCompositePart_7.getChildParts().getPart("conactPatch"));

    PartSurface partSurface_292 = 
      ((PartSurface) solidModelPart_182.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_183 = 
      ((SolidModelPart) solidModelCompositePart_7.getChildParts().getPart("Rim"));

    PartSurface partSurface_293 = 
      ((PartSurface) solidModelPart_183.getPartSurfaceManager().getPartSurface("Default"));

    PartSurface partSurface_294 = 
      ((PartSurface) solidModelPart_183.getPartSurfaceManager().getPartSurface("Default 2"));

    SolidModelPart solidModelPart_184 = 
      ((SolidModelPart) solidModelCompositePart_7.getChildParts().getPart("sockel 4"));

    PartSurface partSurface_295 = 
      ((PartSurface) solidModelPart_184.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_185 = 
      ((SolidModelPart) solidModelCompositePart_7.getChildParts().getPart("tire"));

    PartSurface partSurface_296 = 
      ((PartSurface) solidModelPart_185.getPartSurfaceManager().getPartSurface("contact_surface"));

    PartSurface partSurface_297 = 
      ((PartSurface) solidModelPart_185.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelCompositePart solidModelCompositePart_6 = 
      ((SolidModelCompositePart) solidModelCompositePart_7.getChildParts().getPart("wheelhub"));

    SolidModelPart solidModelPart_3 = 
      ((SolidModelPart) solidModelCompositePart_6.getChildParts().getPart("Body 1 7"));

    PartSurface partSurface_3 = 
      ((PartSurface) solidModelPart_3.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_186 = 
      ((SolidModelPart) solidModelCompositePart_6.getChildParts().getPart("de255532-0c4a-485e-9789-59152b929c88_Body"));

    PartSurface partSurface_298 = 
      ((PartSurface) solidModelPart_186.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_187 = 
      ((SolidModelPart) solidModelCompositePart_6.getChildParts().getPart("de255532-0c4a-485e-9789-59152b929c88_Body 2"));

    PartSurface partSurface_299 = 
      ((PartSurface) solidModelPart_187.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_188 = 
      ((SolidModelPart) solidModelCompositePart_6.getChildParts().getPart("TRM_SRF 2 7"));

    PartSurface partSurface_300 = 
      ((PartSurface) solidModelPart_188.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_189 = 
      ((SolidModelPart) solidModelCompositePart_6.getChildParts().getPart("TRM_SRF 3 9"));

    PartSurface partSurface_301 = 
      ((PartSurface) solidModelPart_189.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_190 = 
      ((SolidModelPart) solidModelCompositePart_6.getChildParts().getPart("TRM_SRF 4 8"));

    PartSurface partSurface_302 = 
      ((PartSurface) solidModelPart_190.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_191 = 
      ((SolidModelPart) solidModelCompositePart_6.getChildParts().getPart("TRM_SRF 5 8"));

    PartSurface partSurface_303 = 
      ((PartSurface) solidModelPart_191.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_192 = 
      ((SolidModelPart) solidModelCompositePart_6.getChildParts().getPart("TRM_SRF 6 8"));

    PartSurface partSurface_304 = 
      ((PartSurface) solidModelPart_192.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_193 = 
      ((SolidModelPart) solidModelCompositePart_6.getChildParts().getPart("TRM_SRF 7 8"));

    PartSurface partSurface_305 = 
      ((PartSurface) solidModelPart_193.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_194 = 
      ((SolidModelPart) solidModelCompositePart_6.getChildParts().getPart("TRM_SRF 8 8"));

    PartSurface partSurface_306 = 
      ((PartSurface) solidModelPart_194.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_195 = 
      ((SolidModelPart) solidModelCompositePart_6.getChildParts().getPart("TRM_SRF 9 7"));

    PartSurface partSurface_307 = 
      ((PartSurface) solidModelPart_195.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_196 = 
      ((SolidModelPart) solidModelCompositePart_6.getChildParts().getPart("TRM_SRF 10 5"));

    PartSurface partSurface_308 = 
      ((PartSurface) solidModelPart_196.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_197 = 
      ((SolidModelPart) solidModelCompositePart_6.getChildParts().getPart("TRM_SRF 11 6"));

    PartSurface partSurface_309 = 
      ((PartSurface) solidModelPart_197.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_198 = 
      ((SolidModelPart) solidModelCompositePart_6.getChildParts().getPart("TRM_SRF 12 4"));

    PartSurface partSurface_310 = 
      ((PartSurface) solidModelPart_198.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_199 = 
      ((SolidModelPart) solidModelCompositePart_6.getChildParts().getPart("TRM_SRF 14 6"));

    PartSurface partSurface_311 = 
      ((PartSurface) solidModelPart_199.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_200 = 
      ((SolidModelPart) solidModelCompositePart_6.getChildParts().getPart("TRM_SRF 15 6"));

    PartSurface partSurface_312 = 
      ((PartSurface) solidModelPart_200.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_201 = 
      ((SolidModelPart) solidModelCompositePart_6.getChildParts().getPart("TRM_SRF 16 6"));

    PartSurface partSurface_313 = 
      ((PartSurface) solidModelPart_201.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_202 = 
      ((SolidModelPart) solidModelCompositePart_6.getChildParts().getPart("TRM_SRF 17 6"));

    PartSurface partSurface_314 = 
      ((PartSurface) solidModelPart_202.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_203 = 
      ((SolidModelPart) solidModelCompositePart_6.getChildParts().getPart("TRM_SRF 18 6"));

    PartSurface partSurface_315 = 
      ((PartSurface) solidModelPart_203.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_204 = 
      ((SolidModelPart) solidModelCompositePart_6.getChildParts().getPart("TRM_SRF 19 6"));

    PartSurface partSurface_316 = 
      ((PartSurface) solidModelPart_204.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelPart solidModelPart_205 = 
      ((SolidModelPart) solidModelCompositePart_6.getChildParts().getPart("TRM_SRF 87"));

    PartSurface partSurface_317 = 
      ((PartSurface) solidModelPart_205.getPartSurfaceManager().getPartSurface("Default"));

    InterfaceBoundary interfaceBoundary_0 = 
      ((InterfaceBoundary) region_0.getBoundaryManager().getBoundary("Air/MRF-FL [0]"));

    InterfaceBoundary interfaceBoundary_1 = 
      ((InterfaceBoundary) region_0.getBoundaryManager().getBoundary("Air/MRF-FR [0]"));

    InterfaceBoundary interfaceBoundary_2 = 
      ((InterfaceBoundary) region_0.getBoundaryManager().getBoundary("Air/MRF-RL [0]"));

    InterfaceBoundary interfaceBoundary_3 = 
      ((InterfaceBoundary) region_0.getBoundaryManager().getBoundary("Air/MRF-RR [0]"));

    partDisplayer_11.getInputParts().setObjects(partSurface_106, partSurface_107, partSurface_108, partSurface_109, partSurface_110, partSurface_111, partSurface_112, partSurface_113, partSurface_114, partSurface_115, partSurface_116, partSurface_117, partSurface_118, partSurface_119, partSurface_120, partSurface_121, partSurface_122, partSurface_123, partSurface_124, partSurface_125, partSurface_126, partSurface_127, partSurface_128, partSurface_129, partSurface_130, partSurface_131, partSurface_132, partSurface_133, partSurface_134, partSurface_135, partSurface_136, partSurface_137, partSurface_138, partSurface_139, partSurface_140, partSurface_141, partSurface_142, partSurface_143, partSurface_0, partSurface_144, partSurface_145, partSurface_146, partSurface_147, partSurface_148, partSurface_149, partSurface_150, partSurface_151, partSurface_152, partSurface_153, partSurface_154, partSurface_155, partSurface_156, partSurface_157, partSurface_158, partSurface_159, partSurface_160, partSurface_161, partSurface_162, partSurface_163, partSurface_164, partSurface_165, partSurface_166, partSurface_167, partSurface_168, partSurface_169, partSurface_170, partSurface_171, partSurface_172, partSurface_173, partSurface_174, partSurface_175, partSurface_176, partSurface_177, partSurface_178, partSurface_179, partSurface_180, partSurface_181, partSurface_182, partSurface_183, partSurface_184, partSurface_185, partSurface_186, partSurface_187, partSurface_188, partSurface_189, partSurface_190, partSurface_191, partSurface_192, partSurface_193, partSurface_194, partSurface_195, partSurface_196, partSurface_197, partSurface_198, partSurface_199, partSurface_200, partSurface_201, partSurface_202, partSurface_203, partSurface_1, partSurface_204, partSurface_205, partSurface_206, partSurface_207, partSurface_208, partSurface_209, partSurface_210, partSurface_211, partSurface_212, partSurface_213, partSurface_214, partSurface_215, partSurface_216, partSurface_217, partSurface_218, partSurface_219, partSurface_220, partSurface_221, partSurface_222, partSurface_223, partSurface_224, partSurface_225, partSurface_226, partSurface_227, partSurface_228, partSurface_229, partSurface_230, partSurface_231, partSurface_232, partSurface_233, partSurface_234, partSurface_235, partSurface_236, partSurface_237, partSurface_238, partSurface_239, partSurface_240, partSurface_241, partSurface_242, partSurface_243, partSurface_244, partSurface_245, partSurface_246, partSurface_247, partSurface_248, partSurface_249, partSurface_250, partSurface_251, partSurface_252, partSurface_2, partSurface_253, partSurface_254, partSurface_255, partSurface_256, partSurface_257, partSurface_258, partSurface_259, partSurface_260, partSurface_261, partSurface_262, partSurface_263, partSurface_264, partSurface_265, partSurface_266, partSurface_267, partSurface_268, partSurface_269, partSurface_270, partSurface_271, partSurface_272, partSurface_273, partSurface_274, partSurface_275, partSurface_276, partSurface_277, partSurface_278, partSurface_279, partSurface_280, partSurface_281, partSurface_282, partSurface_283, partSurface_284, partSurface_285, partSurface_286, partSurface_287, partSurface_288, partSurface_289, partSurface_290, partSurface_291, partSurface_292, partSurface_293, partSurface_294, partSurface_295, partSurface_296, partSurface_297, partSurface_3, partSurface_298, partSurface_299, partSurface_300, partSurface_301, partSurface_302, partSurface_303, partSurface_304, partSurface_305, partSurface_306, partSurface_307, partSurface_308, partSurface_309, partSurface_310, partSurface_311, partSurface_312, partSurface_313, partSurface_314, partSurface_315, partSurface_316, partSurface_317, interfaceBoundary_0, interfaceBoundary_1, interfaceBoundary_2, interfaceBoundary_3);
  }

  private void execute2() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 1");

    PartDisplayer partDisplayer_11 = 
      ((PartDisplayer) scene_0.getDisplayerManager().getObject("Surface 1"));

    partDisplayer_11.setDisplayerColor(new DoubleVector(new double[] {0.0, 0.0, 0.0}));

    PartDisplayer partDisplayer_12 = 
      scene_0.getDisplayerManager().createPartDisplayer("Dummy", -1, 0);

    partDisplayer_12.copyProperties(partDisplayer_11);

    partDisplayer_12.setPresentationName("Surface 1 copy");

    SimpleTransform simpleTransform_0 = 
      ((SimpleTransform) simulation_0.getTransformManager().getObject("Simple Transform 1"));

    partDisplayer_12.setVisTransform(simpleTransform_0);

    PartDisplayer partDisplayer_13 = 
      scene_0.getDisplayerManager().createPartDisplayer("Surface", -1, 1);

    PartRepresentation partRepresentation_0 = 
      ((PartRepresentation) simulation_0.getRepresentationManager().getObject("Geometry"));

    partDisplayer_13.setRepresentation(partRepresentation_0);

    partDisplayer_13.getInputParts().setQuery(null);

    SolidModelCompositePart solidModelCompositePart_1 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("W_wheel_front-left"));

    SolidModelCompositePart solidModelCompositePart_0 = 
      ((SolidModelCompositePart) solidModelCompositePart_1.getChildParts().getPart("wheelhub"));

    SolidModelPart solidModelPart_37 = 
      ((SolidModelPart) solidModelCompositePart_0.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 25"));

    PartSurface partSurface_142 = 
      ((PartSurface) solidModelPart_37.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelCompositePart solidModelCompositePart_3 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("W_wheel_front-right"));

    SolidModelCompositePart solidModelCompositePart_2 = 
      ((SolidModelCompositePart) solidModelCompositePart_3.getChildParts().getPart("wheelhub"));

    SolidModelPart solidModelPart_95 = 
      ((SolidModelPart) solidModelCompositePart_2.getChildParts().getPart("7ddb066d-bda7-4abd-aec6-5a1949e91eef_Body 12"));

    PartSurface partSurface_202 = 
      ((PartSurface) solidModelPart_95.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelCompositePart solidModelCompositePart_5 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("W_wheel_rear-left"));

    SolidModelCompositePart solidModelCompositePart_4 = 
      ((SolidModelCompositePart) solidModelCompositePart_5.getChildParts().getPart("wheelhub"));

    SolidModelPart solidModelPart_143 = 
      ((SolidModelPart) solidModelCompositePart_4.getChildParts().getPart("de255532-0c4a-485e-9789-59152b929c88_Body 3"));

    PartSurface partSurface_253 = 
      ((PartSurface) solidModelPart_143.getPartSurfaceManager().getPartSurface("Default"));

    SolidModelCompositePart solidModelCompositePart_7 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("W_wheel_rear-right"));

    SolidModelCompositePart solidModelCompositePart_6 = 
      ((SolidModelCompositePart) solidModelCompositePart_7.getChildParts().getPart("wheelhub"));

    SolidModelPart solidModelPart_186 = 
      ((SolidModelPart) solidModelCompositePart_6.getChildParts().getPart("de255532-0c4a-485e-9789-59152b929c88_Body"));

    PartSurface partSurface_298 = 
      ((PartSurface) solidModelPart_186.getPartSurfaceManager().getPartSurface("Default"));

    partDisplayer_13.getInputParts().setObjects(partSurface_142, partSurface_202, partSurface_253, partSurface_298);

    PartDisplayer partDisplayer_14 = 
      scene_0.getDisplayerManager().createPartDisplayer("Dummy", -1, 0);

    partDisplayer_14.copyProperties(partDisplayer_13);

    partDisplayer_14.setPresentationName("Surface 2 copy");

    partDisplayer_14.setVisTransform(simpleTransform_0);

    PartDisplayer partDisplayer_15 = 
      scene_0.getDisplayerManager().createPartDisplayer("Surface", -1, 1);

    partDisplayer_15.setColorMode(PartColorMode.CONSTANT);

    partDisplayer_15.getInputParts().setQuery(null);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Air");

    Boundary boundary_5 = 
      region_0.getBoundaryManager().getBoundary("outlet");

    Boundary boundary_6 = 
      region_0.getBoundaryManager().getBoundary("Walls");

    partDisplayer_15.getInputParts().setObjects(boundary_5, boundary_6);

    partDisplayer_15.setDisplayerColor(new DoubleVector(new double[] {0.5, 0.5400000214576721, 0.5299999713897705}));

    AdvancedRenderingEffects advancedRenderingEffects_6 = 
      partDisplayer_15.getAdvancedRenderingEffects();

    advancedRenderingEffects_6.setEnableSurfaceShadows(true);

    AdvancedRenderingMaterials advancedRenderingMaterials_4 = 
      advancedRenderingEffects_6.getAdvancedRenderingMaterials();

    advancedRenderingMaterials_4.setAdvancedRenderingEffectMode(AdvancedRenderingMaterials.AdvancedRenderingEffectsMode.EMISSIVE);

    EmissiveEffectSettings emissiveEffectSettings_0 = 
      advancedRenderingMaterials_4.getEmissiveEffectSettings();

    emissiveEffectSettings_0.setIntensity(2.0);

    ScalarDisplayer scalarDisplayer_3 = 
      ((ScalarDisplayer) scene_0.getDisplayerManager().getObject("Resampled Volume Scalar 1 copy"));

    AdvancedRenderingEffects advancedRenderingEffects_7 = 
      scalarDisplayer_3.getAdvancedRenderingEffects();

    AdvancedRenderingMaterials advancedRenderingMaterials_5 = 
      advancedRenderingEffects_7.getAdvancedRenderingMaterials();

    advancedRenderingMaterials_5.setAdvancedRenderingEffectMode(AdvancedRenderingMaterials.AdvancedRenderingEffectsMode.EMISSIVE);

    ScalarDisplayer scalarDisplayer_2 = 
      ((ScalarDisplayer) scene_0.getDisplayerManager().getObject("Resampled Volume Scalar 1"));

    AdvancedRenderingEffects advancedRenderingEffects_5 = 
      scalarDisplayer_2.getAdvancedRenderingEffects();

    AdvancedRenderingMaterials advancedRenderingMaterials_6 = 
      advancedRenderingEffects_5.getAdvancedRenderingMaterials();

    advancedRenderingMaterials_6.setAdvancedRenderingEffectMode(AdvancedRenderingMaterials.AdvancedRenderingEffectsMode.EMISSIVE);

    partDisplayer_15.setVisibilityOverrideMode(DisplayerVisibilityOverride.HIDE_ALL_PARTS);

    PartDisplayer partDisplayer_16 = 
      scene_0.getDisplayerManager().createPartDisplayer("Surface", -1, 1);

    partDisplayer_16.setPresentationName("Suspension");

    partDisplayer_16.setColorMode(PartColorMode.CONSTANT);

    partDisplayer_16.setRepresentation(partRepresentation_0);

    partDisplayer_16.getInputParts().setQuery(null);

    SolidModelCompositePart solidModelCompositePart_8 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("z_000_remaining-parts"));

    CompositePart compositePart_1 = 
      ((CompositePart) solidModelCompositePart_8.getChildParts().getPart("Suspension_Front_Left"));

    CadPart cadPart_0 = 
      ((CadPart) compositePart_1.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body"));

    PartSurface partSurface_318 = 
      ((PartSurface) cadPart_0.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_1 = 
      ((CadPart) compositePart_1.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 2"));

    PartSurface partSurface_319 = 
      ((PartSurface) cadPart_1.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_2 = 
      ((CadPart) compositePart_1.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 3"));

    PartSurface partSurface_320 = 
      ((PartSurface) cadPart_2.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_3 = 
      ((CadPart) compositePart_1.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 4"));

    PartSurface partSurface_321 = 
      ((PartSurface) cadPart_3.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_4 = 
      ((CadPart) compositePart_1.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 5"));

    PartSurface partSurface_322 = 
      ((PartSurface) cadPart_4.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_5 = 
      ((CadPart) compositePart_1.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 9"));

    PartSurface partSurface_323 = 
      ((PartSurface) cadPart_5.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_6 = 
      ((CadPart) compositePart_1.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 10"));

    PartSurface partSurface_324 = 
      ((PartSurface) cadPart_6.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_7 = 
      ((CadPart) compositePart_1.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 11"));

    PartSurface partSurface_325 = 
      ((PartSurface) cadPart_7.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_8 = 
      ((CadPart) compositePart_1.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 12"));

    PartSurface partSurface_326 = 
      ((PartSurface) cadPart_8.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_9 = 
      ((CadPart) compositePart_1.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 13"));

    PartSurface partSurface_327 = 
      ((PartSurface) cadPart_9.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_10 = 
      ((CadPart) compositePart_1.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 14"));

    PartSurface partSurface_328 = 
      ((PartSurface) cadPart_10.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_11 = 
      ((CadPart) compositePart_1.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 15"));

    PartSurface partSurface_329 = 
      ((PartSurface) cadPart_11.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_12 = 
      ((CadPart) compositePart_1.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 16"));

    PartSurface partSurface_330 = 
      ((PartSurface) cadPart_12.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_13 = 
      ((CadPart) compositePart_1.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 17"));

    PartSurface partSurface_331 = 
      ((PartSurface) cadPart_13.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_14 = 
      ((CadPart) compositePart_1.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 18"));

    PartSurface partSurface_332 = 
      ((PartSurface) cadPart_14.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_15 = 
      ((CadPart) compositePart_1.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 19"));

    PartSurface partSurface_333 = 
      ((PartSurface) cadPart_15.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_16 = 
      ((CadPart) compositePart_1.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 20"));

    PartSurface partSurface_334 = 
      ((PartSurface) cadPart_16.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_17 = 
      ((CadPart) compositePart_1.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 21"));

    PartSurface partSurface_335 = 
      ((PartSurface) cadPart_17.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_18 = 
      ((CadPart) compositePart_1.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 22"));

    PartSurface partSurface_336 = 
      ((PartSurface) cadPart_18.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_19 = 
      ((CadPart) compositePart_1.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 23"));

    PartSurface partSurface_337 = 
      ((PartSurface) cadPart_19.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_20 = 
      ((CadPart) compositePart_1.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 24"));

    PartSurface partSurface_338 = 
      ((PartSurface) cadPart_20.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_21 = 
      ((CadPart) compositePart_1.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 25"));

    PartSurface partSurface_339 = 
      ((PartSurface) cadPart_21.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_22 = 
      ((CadPart) compositePart_1.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 26"));

    PartSurface partSurface_340 = 
      ((PartSurface) cadPart_22.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_23 = 
      ((CadPart) compositePart_1.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 27"));

    PartSurface partSurface_341 = 
      ((PartSurface) cadPart_23.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_24 = 
      ((CadPart) compositePart_1.getChildParts().getPart("DE    16571"));

    PartSurface partSurface_342 = 
      ((PartSurface) cadPart_24.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_25 = 
      ((CadPart) compositePart_1.getChildParts().getPart("DE    41271"));

    PartSurface partSurface_343 = 
      ((PartSurface) cadPart_25.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_26 = 
      ((CadPart) compositePart_1.getChildParts().getPart("S_FL02_J"));

    PartSurface partSurface_344 = 
      ((PartSurface) cadPart_26.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_27 = 
      ((CadPart) compositePart_1.getChildParts().getPart("S_FL02_U"));

    PartSurface partSurface_345 = 
      ((PartSurface) cadPart_27.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_28 = 
      ((CadPart) compositePart_1.getChildParts().getPart("S_FL03_L"));

    PartSurface partSurface_346 = 
      ((PartSurface) cadPart_28.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_29 = 
      ((CadPart) compositePart_1.getChildParts().getPart("S_FL03_L 2"));

    PartSurface partSurface_347 = 
      ((PartSurface) cadPart_29.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_30 = 
      ((CadPart) compositePart_1.getChildParts().getPart("S_FL04_T"));

    PartSurface partSurface_348 = 
      ((PartSurface) cadPart_30.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_31 = 
      ((CadPart) compositePart_1.getChildParts().getPart("S_FL05_R"));

    PartSurface partSurface_349 = 
      ((PartSurface) cadPart_31.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_32 = 
      ((CadPart) compositePart_1.getChildParts().getPart("S_FL06_P"));

    PartSurface partSurface_350 = 
      ((PartSurface) cadPart_32.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_33 = 
      ((CadPart) compositePart_1.getChildParts().getPart("TRM_SRF"));

    PartSurface partSurface_351 = 
      ((PartSurface) cadPart_33.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_34 = 
      ((CadPart) compositePart_1.getChildParts().getPart("TRM_SRF 2"));

    PartSurface partSurface_352 = 
      ((PartSurface) cadPart_34.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_35 = 
      ((CadPart) compositePart_1.getChildParts().getPart("TRM_SRF 3"));

    PartSurface partSurface_353 = 
      ((PartSurface) cadPart_35.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_36 = 
      ((CadPart) compositePart_1.getChildParts().getPart("TRM_SRF 4"));

    PartSurface partSurface_354 = 
      ((PartSurface) cadPart_36.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_37 = 
      ((CadPart) compositePart_1.getChildParts().getPart("TRM_SRF 5"));

    PartSurface partSurface_355 = 
      ((PartSurface) cadPart_37.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_38 = 
      ((CadPart) compositePart_1.getChildParts().getPart("TRM_SRF 6"));

    PartSurface partSurface_356 = 
      ((PartSurface) cadPart_38.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_39 = 
      ((CadPart) compositePart_1.getChildParts().getPart("TRM_SRF 7"));

    PartSurface partSurface_357 = 
      ((PartSurface) cadPart_39.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_40 = 
      ((CadPart) compositePart_1.getChildParts().getPart("TRM_SRF 8"));

    PartSurface partSurface_358 = 
      ((PartSurface) cadPart_40.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_41 = 
      ((CadPart) compositePart_1.getChildParts().getPart("TRM_SRF 9"));

    PartSurface partSurface_359 = 
      ((PartSurface) cadPart_41.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_42 = 
      ((CadPart) compositePart_1.getChildParts().getPart("TRM_SRF 11"));

    PartSurface partSurface_360 = 
      ((PartSurface) cadPart_42.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_43 = 
      ((CadPart) compositePart_1.getChildParts().getPart("TRM_SRF 13"));

    PartSurface partSurface_361 = 
      ((PartSurface) cadPart_43.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_44 = 
      ((CadPart) compositePart_1.getChildParts().getPart("TRM_SRF 22"));

    PartSurface partSurface_362 = 
      ((PartSurface) cadPart_44.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_45 = 
      ((CadPart) compositePart_1.getChildParts().getPart("TRM_SRF 23"));

    PartSurface partSurface_363 = 
      ((PartSurface) cadPart_45.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_46 = 
      ((CadPart) compositePart_1.getChildParts().getPart("TRM_SRF 24"));

    PartSurface partSurface_364 = 
      ((PartSurface) cadPart_46.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_47 = 
      ((CadPart) compositePart_1.getChildParts().getPart("TRM_SRF 25"));

    PartSurface partSurface_365 = 
      ((PartSurface) cadPart_47.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_48 = 
      ((CadPart) compositePart_1.getChildParts().getPart("TRM_SRF 26"));

    PartSurface partSurface_366 = 
      ((PartSurface) cadPart_48.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_49 = 
      ((CadPart) compositePart_1.getChildParts().getPart("TRM_SRF 27"));

    PartSurface partSurface_367 = 
      ((PartSurface) cadPart_49.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_50 = 
      ((CadPart) compositePart_1.getChildParts().getPart("TRM_SRF 28"));

    PartSurface partSurface_368 = 
      ((PartSurface) cadPart_50.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_51 = 
      ((CadPart) compositePart_1.getChildParts().getPart("TRM_SRF 29"));

    PartSurface partSurface_369 = 
      ((PartSurface) cadPart_51.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_52 = 
      ((CadPart) compositePart_1.getChildParts().getPart("TRM_SRF 30"));

    PartSurface partSurface_370 = 
      ((PartSurface) cadPart_52.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_53 = 
      ((CadPart) compositePart_1.getChildParts().getPart("TRM_SRF 35"));

    PartSurface partSurface_371 = 
      ((PartSurface) cadPart_53.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_54 = 
      ((CadPart) compositePart_1.getChildParts().getPart("TRM_SRF 36"));

    PartSurface partSurface_372 = 
      ((PartSurface) cadPart_54.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_55 = 
      ((CadPart) compositePart_1.getChildParts().getPart("TRM_SRF 38"));

    PartSurface partSurface_373 = 
      ((PartSurface) cadPart_55.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_56 = 
      ((CadPart) compositePart_1.getChildParts().getPart("TRM_SRF 39"));

    PartSurface partSurface_374 = 
      ((PartSurface) cadPart_56.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_57 = 
      ((CadPart) compositePart_1.getChildParts().getPart("TRM_SRF 41"));

    PartSurface partSurface_375 = 
      ((PartSurface) cadPart_57.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_58 = 
      ((CadPart) compositePart_1.getChildParts().getPart("TRM_SRF 43"));

    PartSurface partSurface_376 = 
      ((PartSurface) cadPart_58.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_59 = 
      ((CadPart) compositePart_1.getChildParts().getPart("TRM_SRF 44"));

    PartSurface partSurface_377 = 
      ((PartSurface) cadPart_59.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_60 = 
      ((CadPart) compositePart_1.getChildParts().getPart("TRM_SRF 45"));

    PartSurface partSurface_378 = 
      ((PartSurface) cadPart_60.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_61 = 
      ((CadPart) compositePart_1.getChildParts().getPart("TRM_SRF 47"));

    PartSurface partSurface_379 = 
      ((PartSurface) cadPart_61.getPartSurfaceManager().getPartSurface("Faces"));

    CompositePart compositePart_2 = 
      ((CompositePart) solidModelCompositePart_8.getChildParts().getPart("Suspension_Front_Right"));

    CadPart cadPart_62 = 
      ((CadPart) compositePart_2.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body"));

    PartSurface partSurface_380 = 
      ((PartSurface) cadPart_62.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_63 = 
      ((CadPart) compositePart_2.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 2"));

    PartSurface partSurface_381 = 
      ((PartSurface) cadPart_63.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_64 = 
      ((CadPart) compositePart_2.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 3"));

    PartSurface partSurface_382 = 
      ((PartSurface) cadPart_64.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_65 = 
      ((CadPart) compositePart_2.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 4"));

    PartSurface partSurface_383 = 
      ((PartSurface) cadPart_65.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_66 = 
      ((CadPart) compositePart_2.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 5"));

    PartSurface partSurface_384 = 
      ((PartSurface) cadPart_66.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_67 = 
      ((CadPart) compositePart_2.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 9"));

    PartSurface partSurface_385 = 
      ((PartSurface) cadPart_67.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_68 = 
      ((CadPart) compositePart_2.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 10"));

    PartSurface partSurface_386 = 
      ((PartSurface) cadPart_68.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_69 = 
      ((CadPart) compositePart_2.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 11"));

    PartSurface partSurface_387 = 
      ((PartSurface) cadPart_69.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_70 = 
      ((CadPart) compositePart_2.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 12"));

    PartSurface partSurface_388 = 
      ((PartSurface) cadPart_70.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_71 = 
      ((CadPart) compositePart_2.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 13"));

    PartSurface partSurface_389 = 
      ((PartSurface) cadPart_71.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_72 = 
      ((CadPart) compositePart_2.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 14"));

    PartSurface partSurface_390 = 
      ((PartSurface) cadPart_72.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_73 = 
      ((CadPart) compositePart_2.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 15"));

    PartSurface partSurface_391 = 
      ((PartSurface) cadPart_73.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_74 = 
      ((CadPart) compositePart_2.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 16"));

    PartSurface partSurface_392 = 
      ((PartSurface) cadPart_74.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_75 = 
      ((CadPart) compositePart_2.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 17"));

    PartSurface partSurface_393 = 
      ((PartSurface) cadPart_75.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_76 = 
      ((CadPart) compositePart_2.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 18"));

    PartSurface partSurface_394 = 
      ((PartSurface) cadPart_76.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_77 = 
      ((CadPart) compositePart_2.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 19"));

    PartSurface partSurface_395 = 
      ((PartSurface) cadPart_77.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_78 = 
      ((CadPart) compositePart_2.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 20"));

    PartSurface partSurface_396 = 
      ((PartSurface) cadPart_78.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_79 = 
      ((CadPart) compositePart_2.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 21"));

    PartSurface partSurface_397 = 
      ((PartSurface) cadPart_79.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_80 = 
      ((CadPart) compositePart_2.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 22"));

    PartSurface partSurface_398 = 
      ((PartSurface) cadPart_80.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_81 = 
      ((CadPart) compositePart_2.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 23"));

    PartSurface partSurface_399 = 
      ((PartSurface) cadPart_81.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_82 = 
      ((CadPart) compositePart_2.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 24"));

    PartSurface partSurface_400 = 
      ((PartSurface) cadPart_82.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_83 = 
      ((CadPart) compositePart_2.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 25"));

    PartSurface partSurface_401 = 
      ((PartSurface) cadPart_83.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_84 = 
      ((CadPart) compositePart_2.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 26"));

    PartSurface partSurface_402 = 
      ((PartSurface) cadPart_84.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_85 = 
      ((CadPart) compositePart_2.getChildParts().getPart("3391dc4c-2ec2-4215-b40c-d72048ed933a_Body 27"));

    PartSurface partSurface_403 = 
      ((PartSurface) cadPart_85.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_86 = 
      ((CadPart) compositePart_2.getChildParts().getPart("DE    16571"));

    PartSurface partSurface_404 = 
      ((PartSurface) cadPart_86.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_87 = 
      ((CadPart) compositePart_2.getChildParts().getPart("DE    41271"));

    PartSurface partSurface_405 = 
      ((PartSurface) cadPart_87.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_88 = 
      ((CadPart) compositePart_2.getChildParts().getPart("S_FL02_J"));

    PartSurface partSurface_406 = 
      ((PartSurface) cadPart_88.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_89 = 
      ((CadPart) compositePart_2.getChildParts().getPart("S_FL02_U"));

    PartSurface partSurface_407 = 
      ((PartSurface) cadPart_89.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_90 = 
      ((CadPart) compositePart_2.getChildParts().getPart("S_FL03_L"));

    PartSurface partSurface_408 = 
      ((PartSurface) cadPart_90.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_91 = 
      ((CadPart) compositePart_2.getChildParts().getPart("S_FL03_L 2"));

    PartSurface partSurface_409 = 
      ((PartSurface) cadPart_91.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_92 = 
      ((CadPart) compositePart_2.getChildParts().getPart("S_FL04_T"));

    PartSurface partSurface_410 = 
      ((PartSurface) cadPart_92.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_93 = 
      ((CadPart) compositePart_2.getChildParts().getPart("S_FL05_R"));

    PartSurface partSurface_411 = 
      ((PartSurface) cadPart_93.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_94 = 
      ((CadPart) compositePart_2.getChildParts().getPart("S_FL06_P"));

    PartSurface partSurface_412 = 
      ((PartSurface) cadPart_94.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_95 = 
      ((CadPart) compositePart_2.getChildParts().getPart("TRM_SRF"));

    PartSurface partSurface_413 = 
      ((PartSurface) cadPart_95.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_96 = 
      ((CadPart) compositePart_2.getChildParts().getPart("TRM_SRF 2"));

    PartSurface partSurface_414 = 
      ((PartSurface) cadPart_96.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_97 = 
      ((CadPart) compositePart_2.getChildParts().getPart("TRM_SRF 3"));

    PartSurface partSurface_415 = 
      ((PartSurface) cadPart_97.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_98 = 
      ((CadPart) compositePart_2.getChildParts().getPart("TRM_SRF 4"));

    PartSurface partSurface_416 = 
      ((PartSurface) cadPart_98.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_99 = 
      ((CadPart) compositePart_2.getChildParts().getPart("TRM_SRF 5"));

    PartSurface partSurface_417 = 
      ((PartSurface) cadPart_99.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_100 = 
      ((CadPart) compositePart_2.getChildParts().getPart("TRM_SRF 6"));

    PartSurface partSurface_418 = 
      ((PartSurface) cadPart_100.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_101 = 
      ((CadPart) compositePart_2.getChildParts().getPart("TRM_SRF 7"));

    PartSurface partSurface_419 = 
      ((PartSurface) cadPart_101.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_102 = 
      ((CadPart) compositePart_2.getChildParts().getPart("TRM_SRF 8"));

    PartSurface partSurface_420 = 
      ((PartSurface) cadPart_102.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_103 = 
      ((CadPart) compositePart_2.getChildParts().getPart("TRM_SRF 9"));

    PartSurface partSurface_421 = 
      ((PartSurface) cadPart_103.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_104 = 
      ((CadPart) compositePart_2.getChildParts().getPart("TRM_SRF 11"));

    PartSurface partSurface_422 = 
      ((PartSurface) cadPart_104.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_105 = 
      ((CadPart) compositePart_2.getChildParts().getPart("TRM_SRF 13"));

    PartSurface partSurface_423 = 
      ((PartSurface) cadPart_105.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_106 = 
      ((CadPart) compositePart_2.getChildParts().getPart("TRM_SRF 22"));

    PartSurface partSurface_424 = 
      ((PartSurface) cadPart_106.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_107 = 
      ((CadPart) compositePart_2.getChildParts().getPart("TRM_SRF 23"));

    PartSurface partSurface_425 = 
      ((PartSurface) cadPart_107.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_108 = 
      ((CadPart) compositePart_2.getChildParts().getPart("TRM_SRF 24"));

    PartSurface partSurface_426 = 
      ((PartSurface) cadPart_108.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_109 = 
      ((CadPart) compositePart_2.getChildParts().getPart("TRM_SRF 25"));

    PartSurface partSurface_427 = 
      ((PartSurface) cadPart_109.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_110 = 
      ((CadPart) compositePart_2.getChildParts().getPart("TRM_SRF 26"));

    PartSurface partSurface_428 = 
      ((PartSurface) cadPart_110.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_111 = 
      ((CadPart) compositePart_2.getChildParts().getPart("TRM_SRF 27"));

    PartSurface partSurface_429 = 
      ((PartSurface) cadPart_111.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_112 = 
      ((CadPart) compositePart_2.getChildParts().getPart("TRM_SRF 28"));

    PartSurface partSurface_430 = 
      ((PartSurface) cadPart_112.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_113 = 
      ((CadPart) compositePart_2.getChildParts().getPart("TRM_SRF 29"));

    PartSurface partSurface_431 = 
      ((PartSurface) cadPart_113.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_114 = 
      ((CadPart) compositePart_2.getChildParts().getPart("TRM_SRF 30"));

    PartSurface partSurface_432 = 
      ((PartSurface) cadPart_114.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_115 = 
      ((CadPart) compositePart_2.getChildParts().getPart("TRM_SRF 35"));

    PartSurface partSurface_433 = 
      ((PartSurface) cadPart_115.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_116 = 
      ((CadPart) compositePart_2.getChildParts().getPart("TRM_SRF 36"));

    PartSurface partSurface_434 = 
      ((PartSurface) cadPart_116.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_117 = 
      ((CadPart) compositePart_2.getChildParts().getPart("TRM_SRF 38"));

    PartSurface partSurface_435 = 
      ((PartSurface) cadPart_117.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_118 = 
      ((CadPart) compositePart_2.getChildParts().getPart("TRM_SRF 39"));

    PartSurface partSurface_436 = 
      ((PartSurface) cadPart_118.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_119 = 
      ((CadPart) compositePart_2.getChildParts().getPart("TRM_SRF 41"));

    PartSurface partSurface_437 = 
      ((PartSurface) cadPart_119.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_120 = 
      ((CadPart) compositePart_2.getChildParts().getPart("TRM_SRF 43"));

    PartSurface partSurface_438 = 
      ((PartSurface) cadPart_120.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_121 = 
      ((CadPart) compositePart_2.getChildParts().getPart("TRM_SRF 44"));

    PartSurface partSurface_439 = 
      ((PartSurface) cadPart_121.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_122 = 
      ((CadPart) compositePart_2.getChildParts().getPart("TRM_SRF 45"));

    PartSurface partSurface_440 = 
      ((PartSurface) cadPart_122.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_123 = 
      ((CadPart) compositePart_2.getChildParts().getPart("TRM_SRF 47"));

    PartSurface partSurface_441 = 
      ((PartSurface) cadPart_123.getPartSurfaceManager().getPartSurface("Faces"));

    CompositePart compositePart_3 = 
      ((CompositePart) solidModelCompositePart_8.getChildParts().getPart("Suspension_Rear_Left"));

    CadPart cadPart_124 = 
      ((CadPart) compositePart_3.getChildParts().getPart("Body 1"));

    PartSurface partSurface_442 = 
      ((PartSurface) cadPart_124.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_125 = 
      ((CadPart) compositePart_3.getChildParts().getPart("Body 93"));

    PartSurface partSurface_443 = 
      ((PartSurface) cadPart_125.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_126 = 
      ((CadPart) compositePart_3.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body"));

    PartSurface partSurface_444 = 
      ((PartSurface) cadPart_126.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_127 = 
      ((CadPart) compositePart_3.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 2"));

    PartSurface partSurface_445 = 
      ((PartSurface) cadPart_127.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_128 = 
      ((CadPart) compositePart_3.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 3"));

    PartSurface partSurface_446 = 
      ((PartSurface) cadPart_128.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_129 = 
      ((CadPart) compositePart_3.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 4"));

    PartSurface partSurface_447 = 
      ((PartSurface) cadPart_129.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_130 = 
      ((CadPart) compositePart_3.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 5"));

    PartSurface partSurface_448 = 
      ((PartSurface) cadPart_130.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_131 = 
      ((CadPart) compositePart_3.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 6"));

    PartSurface partSurface_449 = 
      ((PartSurface) cadPart_131.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_132 = 
      ((CadPart) compositePart_3.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 7"));

    PartSurface partSurface_450 = 
      ((PartSurface) cadPart_132.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_133 = 
      ((CadPart) compositePart_3.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 8"));

    PartSurface partSurface_451 = 
      ((PartSurface) cadPart_133.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_134 = 
      ((CadPart) compositePart_3.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 9"));

    PartSurface partSurface_452 = 
      ((PartSurface) cadPart_134.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_135 = 
      ((CadPart) compositePart_3.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 10"));

    PartSurface partSurface_453 = 
      ((PartSurface) cadPart_135.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_136 = 
      ((CadPart) compositePart_3.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 11"));

    PartSurface partSurface_454 = 
      ((PartSurface) cadPart_136.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_137 = 
      ((CadPart) compositePart_3.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 12"));

    PartSurface partSurface_455 = 
      ((PartSurface) cadPart_137.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_138 = 
      ((CadPart) compositePart_3.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 13"));

    PartSurface partSurface_456 = 
      ((PartSurface) cadPart_138.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_139 = 
      ((CadPart) compositePart_3.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 14"));

    PartSurface partSurface_457 = 
      ((PartSurface) cadPart_139.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_140 = 
      ((CadPart) compositePart_3.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 15"));

    PartSurface partSurface_458 = 
      ((PartSurface) cadPart_140.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_141 = 
      ((CadPart) compositePart_3.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 16"));

    PartSurface partSurface_459 = 
      ((PartSurface) cadPart_141.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_142 = 
      ((CadPart) compositePart_3.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 17"));

    PartSurface partSurface_460 = 
      ((PartSurface) cadPart_142.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_143 = 
      ((CadPart) compositePart_3.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 18"));

    PartSurface partSurface_461 = 
      ((PartSurface) cadPart_143.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_144 = 
      ((CadPart) compositePart_3.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 19"));

    PartSurface partSurface_462 = 
      ((PartSurface) cadPart_144.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_145 = 
      ((CadPart) compositePart_3.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 20"));

    PartSurface partSurface_463 = 
      ((PartSurface) cadPart_145.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_146 = 
      ((CadPart) compositePart_3.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 21"));

    PartSurface partSurface_464 = 
      ((PartSurface) cadPart_146.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_147 = 
      ((CadPart) compositePart_3.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 22"));

    PartSurface partSurface_465 = 
      ((PartSurface) cadPart_147.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_148 = 
      ((CadPart) compositePart_3.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 23"));

    PartSurface partSurface_466 = 
      ((PartSurface) cadPart_148.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_149 = 
      ((CadPart) compositePart_3.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 24"));

    PartSurface partSurface_467 = 
      ((PartSurface) cadPart_149.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_150 = 
      ((CadPart) compositePart_3.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 25"));

    PartSurface partSurface_468 = 
      ((PartSurface) cadPart_150.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_151 = 
      ((CadPart) compositePart_3.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 26"));

    PartSurface partSurface_469 = 
      ((PartSurface) cadPart_151.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_152 = 
      ((CadPart) compositePart_3.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 26 copy"));

    PartSurface partSurface_470 = 
      ((PartSurface) cadPart_152.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_153 = 
      ((CadPart) compositePart_3.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 27"));

    PartSurface partSurface_471 = 
      ((PartSurface) cadPart_153.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_154 = 
      ((CadPart) compositePart_3.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 28"));

    PartSurface partSurface_472 = 
      ((PartSurface) cadPart_154.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_155 = 
      ((CadPart) compositePart_3.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 29"));

    PartSurface partSurface_473 = 
      ((PartSurface) cadPart_155.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_156 = 
      ((CadPart) compositePart_3.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 30"));

    PartSurface partSurface_474 = 
      ((PartSurface) cadPart_156.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_157 = 
      ((CadPart) compositePart_3.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 31"));

    PartSurface partSurface_475 = 
      ((PartSurface) cadPart_157.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_158 = 
      ((CadPart) compositePart_3.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 32"));

    PartSurface partSurface_476 = 
      ((PartSurface) cadPart_158.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_159 = 
      ((CadPart) compositePart_3.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 33"));

    PartSurface partSurface_477 = 
      ((PartSurface) cadPart_159.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_160 = 
      ((CadPart) compositePart_3.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 34"));

    PartSurface partSurface_478 = 
      ((PartSurface) cadPart_160.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_161 = 
      ((CadPart) compositePart_3.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 35"));

    PartSurface partSurface_479 = 
      ((PartSurface) cadPart_161.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_162 = 
      ((CadPart) compositePart_3.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 36"));

    PartSurface partSurface_480 = 
      ((PartSurface) cadPart_162.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_163 = 
      ((CadPart) compositePart_3.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 37"));

    PartSurface partSurface_481 = 
      ((PartSurface) cadPart_163.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_164 = 
      ((CadPart) compositePart_3.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 38"));

    PartSurface partSurface_482 = 
      ((PartSurface) cadPart_164.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_165 = 
      ((CadPart) compositePart_3.getChildParts().getPart("DE    54825"));

    PartSurface partSurface_483 = 
      ((PartSurface) cadPart_165.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_166 = 
      ((CadPart) compositePart_3.getChildParts().getPart("DE    82055"));

    PartSurface partSurface_484 = 
      ((PartSurface) cadPart_166.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_167 = 
      ((CadPart) compositePart_3.getChildParts().getPart("DE    82073"));

    PartSurface partSurface_485 = 
      ((PartSurface) cadPart_167.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_168 = 
      ((CadPart) compositePart_3.getChildParts().getPart("S_RL02_U"));

    PartSurface partSurface_486 = 
      ((PartSurface) cadPart_168.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_169 = 
      ((CadPart) compositePart_3.getChildParts().getPart("S_RL02_U 2"));

    PartSurface partSurface_487 = 
      ((PartSurface) cadPart_169.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_170 = 
      ((CadPart) compositePart_3.getChildParts().getPart("S_RL03_L"));

    PartSurface partSurface_488 = 
      ((PartSurface) cadPart_170.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_171 = 
      ((CadPart) compositePart_3.getChildParts().getPart("S_RL03_L 2"));

    PartSurface partSurface_489 = 
      ((PartSurface) cadPart_171.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_172 = 
      ((CadPart) compositePart_3.getChildParts().getPart("S_RL04_T"));

    PartSurface partSurface_490 = 
      ((PartSurface) cadPart_172.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_173 = 
      ((CadPart) compositePart_3.getChildParts().getPart("S_RL06_P"));

    PartSurface partSurface_491 = 
      ((PartSurface) cadPart_173.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_174 = 
      ((CadPart) compositePart_3.getChildParts().getPart("S_RL06_P 2"));

    PartSurface partSurface_492 = 
      ((PartSurface) cadPart_174.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_175 = 
      ((CadPart) compositePart_3.getChildParts().getPart("S_RL08_D"));

    PartSurface partSurface_493 = 
      ((PartSurface) cadPart_175.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_176 = 
      ((CadPart) compositePart_3.getChildParts().getPart("S_RL08_D 2"));

    PartSurface partSurface_494 = 
      ((PartSurface) cadPart_176.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_177 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 3"));

    PartSurface partSurface_495 = 
      ((PartSurface) cadPart_177.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_178 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 4"));

    PartSurface partSurface_496 = 
      ((PartSurface) cadPart_178.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_179 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 5"));

    PartSurface partSurface_497 = 
      ((PartSurface) cadPart_179.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_180 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 6"));

    PartSurface partSurface_498 = 
      ((PartSurface) cadPart_180.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_181 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 7"));

    PartSurface partSurface_499 = 
      ((PartSurface) cadPart_181.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_182 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 8"));

    PartSurface partSurface_500 = 
      ((PartSurface) cadPart_182.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_183 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 9"));

    PartSurface partSurface_501 = 
      ((PartSurface) cadPart_183.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_184 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 10"));

    PartSurface partSurface_502 = 
      ((PartSurface) cadPart_184.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_185 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 11"));

    PartSurface partSurface_503 = 
      ((PartSurface) cadPart_185.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_186 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 12"));

    PartSurface partSurface_504 = 
      ((PartSurface) cadPart_186.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_187 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 13"));

    PartSurface partSurface_505 = 
      ((PartSurface) cadPart_187.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_188 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 14"));

    PartSurface partSurface_506 = 
      ((PartSurface) cadPart_188.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_189 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 15"));

    PartSurface partSurface_507 = 
      ((PartSurface) cadPart_189.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_190 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 16"));

    PartSurface partSurface_508 = 
      ((PartSurface) cadPart_190.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_191 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 17"));

    PartSurface partSurface_509 = 
      ((PartSurface) cadPart_191.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_192 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 18"));

    PartSurface partSurface_510 = 
      ((PartSurface) cadPart_192.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_193 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 19"));

    PartSurface partSurface_511 = 
      ((PartSurface) cadPart_193.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_194 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 20"));

    PartSurface partSurface_512 = 
      ((PartSurface) cadPart_194.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_195 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 21"));

    PartSurface partSurface_513 = 
      ((PartSurface) cadPart_195.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_196 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 22"));

    PartSurface partSurface_514 = 
      ((PartSurface) cadPart_196.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_197 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 23"));

    PartSurface partSurface_515 = 
      ((PartSurface) cadPart_197.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_198 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 24"));

    PartSurface partSurface_516 = 
      ((PartSurface) cadPart_198.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_199 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 25"));

    PartSurface partSurface_517 = 
      ((PartSurface) cadPart_199.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_200 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 27"));

    PartSurface partSurface_518 = 
      ((PartSurface) cadPart_200.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_201 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 28"));

    PartSurface partSurface_519 = 
      ((PartSurface) cadPart_201.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_202 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 29"));

    PartSurface partSurface_520 = 
      ((PartSurface) cadPart_202.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_203 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 30"));

    PartSurface partSurface_521 = 
      ((PartSurface) cadPart_203.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_204 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 31"));

    PartSurface partSurface_522 = 
      ((PartSurface) cadPart_204.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_205 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 32"));

    PartSurface partSurface_523 = 
      ((PartSurface) cadPart_205.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_206 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 33"));

    PartSurface partSurface_524 = 
      ((PartSurface) cadPart_206.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_207 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 34"));

    PartSurface partSurface_525 = 
      ((PartSurface) cadPart_207.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_208 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 35"));

    PartSurface partSurface_526 = 
      ((PartSurface) cadPart_208.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_209 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 36"));

    PartSurface partSurface_527 = 
      ((PartSurface) cadPart_209.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_210 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 37"));

    PartSurface partSurface_528 = 
      ((PartSurface) cadPart_210.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_211 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 38"));

    PartSurface partSurface_529 = 
      ((PartSurface) cadPart_211.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_212 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 39"));

    PartSurface partSurface_530 = 
      ((PartSurface) cadPart_212.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_213 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 40"));

    PartSurface partSurface_531 = 
      ((PartSurface) cadPart_213.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_214 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 41"));

    PartSurface partSurface_532 = 
      ((PartSurface) cadPart_214.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_215 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 42"));

    PartSurface partSurface_533 = 
      ((PartSurface) cadPart_215.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_216 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 43"));

    PartSurface partSurface_534 = 
      ((PartSurface) cadPart_216.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_217 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 44"));

    PartSurface partSurface_535 = 
      ((PartSurface) cadPart_217.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_218 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 45"));

    PartSurface partSurface_536 = 
      ((PartSurface) cadPart_218.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_219 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 46"));

    PartSurface partSurface_537 = 
      ((PartSurface) cadPart_219.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_220 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 47"));

    PartSurface partSurface_538 = 
      ((PartSurface) cadPart_220.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_221 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 48"));

    PartSurface partSurface_539 = 
      ((PartSurface) cadPart_221.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_222 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 49"));

    PartSurface partSurface_540 = 
      ((PartSurface) cadPart_222.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_223 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 50"));

    PartSurface partSurface_541 = 
      ((PartSurface) cadPart_223.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_224 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 51"));

    PartSurface partSurface_542 = 
      ((PartSurface) cadPart_224.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_225 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 52"));

    PartSurface partSurface_543 = 
      ((PartSurface) cadPart_225.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_226 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 53"));

    PartSurface partSurface_544 = 
      ((PartSurface) cadPart_226.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_227 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 54"));

    PartSurface partSurface_545 = 
      ((PartSurface) cadPart_227.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_228 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 55"));

    PartSurface partSurface_546 = 
      ((PartSurface) cadPart_228.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_229 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 56"));

    PartSurface partSurface_547 = 
      ((PartSurface) cadPart_229.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_230 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 57"));

    PartSurface partSurface_548 = 
      ((PartSurface) cadPart_230.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_231 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 58"));

    PartSurface partSurface_549 = 
      ((PartSurface) cadPart_231.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_232 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 59"));

    PartSurface partSurface_550 = 
      ((PartSurface) cadPart_232.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_233 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 61"));

    PartSurface partSurface_551 = 
      ((PartSurface) cadPart_233.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_234 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 64"));

    PartSurface partSurface_552 = 
      ((PartSurface) cadPart_234.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_235 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 65"));

    PartSurface partSurface_553 = 
      ((PartSurface) cadPart_235.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_236 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 66"));

    PartSurface partSurface_554 = 
      ((PartSurface) cadPart_236.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_237 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 67"));

    PartSurface partSurface_555 = 
      ((PartSurface) cadPart_237.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_238 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 68"));

    PartSurface partSurface_556 = 
      ((PartSurface) cadPart_238.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_239 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 69"));

    PartSurface partSurface_557 = 
      ((PartSurface) cadPart_239.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_240 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 70"));

    PartSurface partSurface_558 = 
      ((PartSurface) cadPart_240.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_241 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 71"));

    PartSurface partSurface_559 = 
      ((PartSurface) cadPart_241.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_242 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 72"));

    PartSurface partSurface_560 = 
      ((PartSurface) cadPart_242.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_243 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 73"));

    PartSurface partSurface_561 = 
      ((PartSurface) cadPart_243.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_244 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 74"));

    PartSurface partSurface_562 = 
      ((PartSurface) cadPart_244.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_245 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 75"));

    PartSurface partSurface_563 = 
      ((PartSurface) cadPart_245.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_246 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 76"));

    PartSurface partSurface_564 = 
      ((PartSurface) cadPart_246.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_247 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 77"));

    PartSurface partSurface_565 = 
      ((PartSurface) cadPart_247.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_248 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 78"));

    PartSurface partSurface_566 = 
      ((PartSurface) cadPart_248.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_249 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 79"));

    PartSurface partSurface_567 = 
      ((PartSurface) cadPart_249.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_250 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 80"));

    PartSurface partSurface_568 = 
      ((PartSurface) cadPart_250.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_251 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 81"));

    PartSurface partSurface_569 = 
      ((PartSurface) cadPart_251.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_252 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 82"));

    PartSurface partSurface_570 = 
      ((PartSurface) cadPart_252.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_253 = 
      ((CadPart) compositePart_3.getChildParts().getPart("TRM_SRF 83"));

    PartSurface partSurface_571 = 
      ((PartSurface) cadPart_253.getPartSurfaceManager().getPartSurface("Faces"));

    CompositePart compositePart_4 = 
      ((CompositePart) solidModelCompositePart_8.getChildParts().getPart("Suspension_Rear_Right"));

    CadPart cadPart_254 = 
      ((CadPart) compositePart_4.getChildParts().getPart("Body 1"));

    PartSurface partSurface_572 = 
      ((PartSurface) cadPart_254.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_255 = 
      ((CadPart) compositePart_4.getChildParts().getPart("Body 93"));

    PartSurface partSurface_573 = 
      ((PartSurface) cadPart_255.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_256 = 
      ((CadPart) compositePart_4.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body"));

    PartSurface partSurface_574 = 
      ((PartSurface) cadPart_256.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_257 = 
      ((CadPart) compositePart_4.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 2"));

    PartSurface partSurface_575 = 
      ((PartSurface) cadPart_257.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_258 = 
      ((CadPart) compositePart_4.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 3"));

    PartSurface partSurface_576 = 
      ((PartSurface) cadPart_258.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_259 = 
      ((CadPart) compositePart_4.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 4"));

    PartSurface partSurface_577 = 
      ((PartSurface) cadPart_259.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_260 = 
      ((CadPart) compositePart_4.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 5"));

    PartSurface partSurface_578 = 
      ((PartSurface) cadPart_260.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_261 = 
      ((CadPart) compositePart_4.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 6"));

    PartSurface partSurface_579 = 
      ((PartSurface) cadPart_261.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_262 = 
      ((CadPart) compositePart_4.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 7"));

    PartSurface partSurface_580 = 
      ((PartSurface) cadPart_262.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_263 = 
      ((CadPart) compositePart_4.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 8"));

    PartSurface partSurface_581 = 
      ((PartSurface) cadPart_263.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_264 = 
      ((CadPart) compositePart_4.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 9"));

    PartSurface partSurface_582 = 
      ((PartSurface) cadPart_264.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_265 = 
      ((CadPart) compositePart_4.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 10"));

    PartSurface partSurface_583 = 
      ((PartSurface) cadPart_265.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_266 = 
      ((CadPart) compositePart_4.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 11"));

    PartSurface partSurface_584 = 
      ((PartSurface) cadPart_266.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_267 = 
      ((CadPart) compositePart_4.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 12"));

    PartSurface partSurface_585 = 
      ((PartSurface) cadPart_267.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_268 = 
      ((CadPart) compositePart_4.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 13"));

    PartSurface partSurface_586 = 
      ((PartSurface) cadPart_268.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_269 = 
      ((CadPart) compositePart_4.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 14"));

    PartSurface partSurface_587 = 
      ((PartSurface) cadPart_269.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_270 = 
      ((CadPart) compositePart_4.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 15"));

    PartSurface partSurface_588 = 
      ((PartSurface) cadPart_270.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_271 = 
      ((CadPart) compositePart_4.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 16"));

    PartSurface partSurface_589 = 
      ((PartSurface) cadPart_271.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_272 = 
      ((CadPart) compositePart_4.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 17"));

    PartSurface partSurface_590 = 
      ((PartSurface) cadPart_272.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_273 = 
      ((CadPart) compositePart_4.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 18"));

    PartSurface partSurface_591 = 
      ((PartSurface) cadPart_273.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_274 = 
      ((CadPart) compositePart_4.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 19"));

    PartSurface partSurface_592 = 
      ((PartSurface) cadPart_274.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_275 = 
      ((CadPart) compositePart_4.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 20"));

    PartSurface partSurface_593 = 
      ((PartSurface) cadPart_275.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_276 = 
      ((CadPart) compositePart_4.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 21"));

    PartSurface partSurface_594 = 
      ((PartSurface) cadPart_276.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_277 = 
      ((CadPart) compositePart_4.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 22"));

    PartSurface partSurface_595 = 
      ((PartSurface) cadPart_277.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_278 = 
      ((CadPart) compositePart_4.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 23"));

    PartSurface partSurface_596 = 
      ((PartSurface) cadPart_278.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_279 = 
      ((CadPart) compositePart_4.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 24"));

    PartSurface partSurface_597 = 
      ((PartSurface) cadPart_279.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_280 = 
      ((CadPart) compositePart_4.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 25"));

    PartSurface partSurface_598 = 
      ((PartSurface) cadPart_280.getPartSurfaceManager().getPartSurface("Faces"));

    SolidModelPart solidModelPart_206 = 
      ((SolidModelPart) compositePart_4.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 26"));

    PartSurface partSurface_599 = 
      ((PartSurface) solidModelPart_206.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_281 = 
      ((CadPart) compositePart_4.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 27"));

    PartSurface partSurface_600 = 
      ((PartSurface) cadPart_281.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_282 = 
      ((CadPart) compositePart_4.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 28"));

    PartSurface partSurface_601 = 
      ((PartSurface) cadPart_282.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_283 = 
      ((CadPart) compositePart_4.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 29"));

    PartSurface partSurface_602 = 
      ((PartSurface) cadPart_283.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_284 = 
      ((CadPart) compositePart_4.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 30"));

    PartSurface partSurface_603 = 
      ((PartSurface) cadPart_284.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_285 = 
      ((CadPart) compositePart_4.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 31"));

    PartSurface partSurface_604 = 
      ((PartSurface) cadPart_285.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_286 = 
      ((CadPart) compositePart_4.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 32"));

    PartSurface partSurface_605 = 
      ((PartSurface) cadPart_286.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_287 = 
      ((CadPart) compositePart_4.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 33"));

    PartSurface partSurface_606 = 
      ((PartSurface) cadPart_287.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_288 = 
      ((CadPart) compositePart_4.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 34"));

    PartSurface partSurface_607 = 
      ((PartSurface) cadPart_288.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_289 = 
      ((CadPart) compositePart_4.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 35"));

    PartSurface partSurface_608 = 
      ((PartSurface) cadPart_289.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_290 = 
      ((CadPart) compositePart_4.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 36"));

    PartSurface partSurface_609 = 
      ((PartSurface) cadPart_290.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_291 = 
      ((CadPart) compositePart_4.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 37"));

    PartSurface partSurface_610 = 
      ((PartSurface) cadPart_291.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_292 = 
      ((CadPart) compositePart_4.getChildParts().getPart("d3b434bb-00e3-4014-b34b-768c9ff978bc_Body 38"));

    PartSurface partSurface_611 = 
      ((PartSurface) cadPart_292.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_293 = 
      ((CadPart) compositePart_4.getChildParts().getPart("DE    54825"));

    PartSurface partSurface_612 = 
      ((PartSurface) cadPart_293.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_294 = 
      ((CadPart) compositePart_4.getChildParts().getPart("DE    82055"));

    PartSurface partSurface_613 = 
      ((PartSurface) cadPart_294.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_295 = 
      ((CadPart) compositePart_4.getChildParts().getPart("DE    82073"));

    PartSurface partSurface_614 = 
      ((PartSurface) cadPart_295.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_296 = 
      ((CadPart) compositePart_4.getChildParts().getPart("S_RL02_U"));

    PartSurface partSurface_615 = 
      ((PartSurface) cadPart_296.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_297 = 
      ((CadPart) compositePart_4.getChildParts().getPart("S_RL02_U 2"));

    PartSurface partSurface_616 = 
      ((PartSurface) cadPart_297.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_298 = 
      ((CadPart) compositePart_4.getChildParts().getPart("S_RL03_L"));

    PartSurface partSurface_617 = 
      ((PartSurface) cadPart_298.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_299 = 
      ((CadPart) compositePart_4.getChildParts().getPart("S_RL03_L 2"));

    PartSurface partSurface_618 = 
      ((PartSurface) cadPart_299.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_300 = 
      ((CadPart) compositePart_4.getChildParts().getPart("S_RL04_T"));

    PartSurface partSurface_619 = 
      ((PartSurface) cadPart_300.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_301 = 
      ((CadPart) compositePart_4.getChildParts().getPart("S_RL06_P"));

    PartSurface partSurface_620 = 
      ((PartSurface) cadPart_301.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_302 = 
      ((CadPart) compositePart_4.getChildParts().getPart("S_RL06_P 2"));

    PartSurface partSurface_621 = 
      ((PartSurface) cadPart_302.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_303 = 
      ((CadPart) compositePart_4.getChildParts().getPart("S_RL08_D"));

    PartSurface partSurface_622 = 
      ((PartSurface) cadPart_303.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_304 = 
      ((CadPart) compositePart_4.getChildParts().getPart("S_RL08_D 2"));

    PartSurface partSurface_623 = 
      ((PartSurface) cadPart_304.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_305 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 3"));

    PartSurface partSurface_624 = 
      ((PartSurface) cadPart_305.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_306 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 4"));

    PartSurface partSurface_625 = 
      ((PartSurface) cadPart_306.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_307 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 5"));

    PartSurface partSurface_626 = 
      ((PartSurface) cadPart_307.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_308 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 6"));

    PartSurface partSurface_627 = 
      ((PartSurface) cadPart_308.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_309 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 7"));

    PartSurface partSurface_628 = 
      ((PartSurface) cadPart_309.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_310 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 8"));

    PartSurface partSurface_629 = 
      ((PartSurface) cadPart_310.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_311 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 9"));

    PartSurface partSurface_630 = 
      ((PartSurface) cadPart_311.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_312 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 10"));

    PartSurface partSurface_631 = 
      ((PartSurface) cadPart_312.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_313 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 11"));

    PartSurface partSurface_632 = 
      ((PartSurface) cadPart_313.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_314 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 12"));

    PartSurface partSurface_633 = 
      ((PartSurface) cadPart_314.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_315 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 13"));

    PartSurface partSurface_634 = 
      ((PartSurface) cadPart_315.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_316 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 14"));

    PartSurface partSurface_635 = 
      ((PartSurface) cadPart_316.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_317 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 15"));

    PartSurface partSurface_636 = 
      ((PartSurface) cadPart_317.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_318 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 16"));

    PartSurface partSurface_637 = 
      ((PartSurface) cadPart_318.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_319 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 17"));

    PartSurface partSurface_638 = 
      ((PartSurface) cadPart_319.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_320 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 18"));

    PartSurface partSurface_639 = 
      ((PartSurface) cadPart_320.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_321 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 19"));

    PartSurface partSurface_640 = 
      ((PartSurface) cadPart_321.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_322 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 20"));

    PartSurface partSurface_641 = 
      ((PartSurface) cadPart_322.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_323 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 21"));

    PartSurface partSurface_642 = 
      ((PartSurface) cadPart_323.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_324 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 22"));

    PartSurface partSurface_643 = 
      ((PartSurface) cadPart_324.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_325 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 23"));

    PartSurface partSurface_644 = 
      ((PartSurface) cadPart_325.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_326 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 24"));

    PartSurface partSurface_645 = 
      ((PartSurface) cadPart_326.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_327 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 25"));

    PartSurface partSurface_646 = 
      ((PartSurface) cadPart_327.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_328 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 27"));

    PartSurface partSurface_647 = 
      ((PartSurface) cadPart_328.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_329 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 28"));

    PartSurface partSurface_648 = 
      ((PartSurface) cadPart_329.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_330 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 29"));

    PartSurface partSurface_649 = 
      ((PartSurface) cadPart_330.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_331 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 30"));

    PartSurface partSurface_650 = 
      ((PartSurface) cadPart_331.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_332 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 31"));

    PartSurface partSurface_651 = 
      ((PartSurface) cadPart_332.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_333 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 32"));

    PartSurface partSurface_652 = 
      ((PartSurface) cadPart_333.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_334 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 33"));

    PartSurface partSurface_653 = 
      ((PartSurface) cadPart_334.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_335 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 34"));

    PartSurface partSurface_654 = 
      ((PartSurface) cadPart_335.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_336 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 35"));

    PartSurface partSurface_655 = 
      ((PartSurface) cadPart_336.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_337 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 36"));

    PartSurface partSurface_656 = 
      ((PartSurface) cadPart_337.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_338 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 37"));

    PartSurface partSurface_657 = 
      ((PartSurface) cadPart_338.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_339 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 38"));

    PartSurface partSurface_658 = 
      ((PartSurface) cadPart_339.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_340 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 39"));

    PartSurface partSurface_659 = 
      ((PartSurface) cadPart_340.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_341 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 40"));

    PartSurface partSurface_660 = 
      ((PartSurface) cadPart_341.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_342 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 41"));

    PartSurface partSurface_661 = 
      ((PartSurface) cadPart_342.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_343 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 42"));

    PartSurface partSurface_662 = 
      ((PartSurface) cadPart_343.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_344 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 43"));

    PartSurface partSurface_663 = 
      ((PartSurface) cadPart_344.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_345 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 44"));

    PartSurface partSurface_664 = 
      ((PartSurface) cadPart_345.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_346 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 45"));

    PartSurface partSurface_665 = 
      ((PartSurface) cadPart_346.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_347 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 46"));

    PartSurface partSurface_666 = 
      ((PartSurface) cadPart_347.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_348 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 47"));

    PartSurface partSurface_667 = 
      ((PartSurface) cadPart_348.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_349 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 48"));

    PartSurface partSurface_668 = 
      ((PartSurface) cadPart_349.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_350 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 49"));

    PartSurface partSurface_669 = 
      ((PartSurface) cadPart_350.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_351 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 50"));

    PartSurface partSurface_670 = 
      ((PartSurface) cadPart_351.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_352 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 51"));

    PartSurface partSurface_671 = 
      ((PartSurface) cadPart_352.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_353 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 52"));

    PartSurface partSurface_672 = 
      ((PartSurface) cadPart_353.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_354 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 53"));

    PartSurface partSurface_673 = 
      ((PartSurface) cadPart_354.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_355 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 54"));

    PartSurface partSurface_674 = 
      ((PartSurface) cadPart_355.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_356 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 55"));

    PartSurface partSurface_675 = 
      ((PartSurface) cadPart_356.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_357 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 56"));

    PartSurface partSurface_676 = 
      ((PartSurface) cadPart_357.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_358 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 57"));

    PartSurface partSurface_677 = 
      ((PartSurface) cadPart_358.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_359 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 58"));

    PartSurface partSurface_678 = 
      ((PartSurface) cadPart_359.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_360 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 59"));

    PartSurface partSurface_679 = 
      ((PartSurface) cadPart_360.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_361 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 61"));

    PartSurface partSurface_680 = 
      ((PartSurface) cadPart_361.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_362 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 64"));

    PartSurface partSurface_681 = 
      ((PartSurface) cadPart_362.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_363 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 65"));

    PartSurface partSurface_682 = 
      ((PartSurface) cadPart_363.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_364 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 66"));

    PartSurface partSurface_683 = 
      ((PartSurface) cadPart_364.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_365 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 67"));

    PartSurface partSurface_684 = 
      ((PartSurface) cadPart_365.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_366 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 68"));

    PartSurface partSurface_685 = 
      ((PartSurface) cadPart_366.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_367 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 69"));

    PartSurface partSurface_686 = 
      ((PartSurface) cadPart_367.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_368 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 70"));

    PartSurface partSurface_687 = 
      ((PartSurface) cadPart_368.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_369 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 71"));

    PartSurface partSurface_688 = 
      ((PartSurface) cadPart_369.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_370 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 72"));

    PartSurface partSurface_689 = 
      ((PartSurface) cadPart_370.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_371 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 73"));

    PartSurface partSurface_690 = 
      ((PartSurface) cadPart_371.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_372 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 74"));

    PartSurface partSurface_691 = 
      ((PartSurface) cadPart_372.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_373 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 75"));

    PartSurface partSurface_692 = 
      ((PartSurface) cadPart_373.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_374 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 76"));

    PartSurface partSurface_693 = 
      ((PartSurface) cadPart_374.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_375 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 77"));

    PartSurface partSurface_694 = 
      ((PartSurface) cadPart_375.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_376 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 78"));

    PartSurface partSurface_695 = 
      ((PartSurface) cadPart_376.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_377 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 79"));

    PartSurface partSurface_696 = 
      ((PartSurface) cadPart_377.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_378 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 80"));

    PartSurface partSurface_697 = 
      ((PartSurface) cadPart_378.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_379 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 81"));

    PartSurface partSurface_698 = 
      ((PartSurface) cadPart_379.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_380 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 82"));

    PartSurface partSurface_699 = 
      ((PartSurface) cadPart_380.getPartSurfaceManager().getPartSurface("Faces"));

    CadPart cadPart_381 = 
      ((CadPart) compositePart_4.getChildParts().getPart("TRM_SRF 83"));

    PartSurface partSurface_700 = 
      ((PartSurface) cadPart_381.getPartSurfaceManager().getPartSurface("Faces"));

    partDisplayer_16.getInputParts().setObjects(partSurface_318, partSurface_319, partSurface_320, partSurface_321, partSurface_322, partSurface_323, partSurface_324, partSurface_325, partSurface_326, partSurface_327, partSurface_328, partSurface_329, partSurface_330, partSurface_331, partSurface_332, partSurface_333, partSurface_334, partSurface_335, partSurface_336, partSurface_337, partSurface_338, partSurface_339, partSurface_340, partSurface_341, partSurface_342, partSurface_343, partSurface_344, partSurface_345, partSurface_346, partSurface_347, partSurface_348, partSurface_349, partSurface_350, partSurface_351, partSurface_352, partSurface_353, partSurface_354, partSurface_355, partSurface_356, partSurface_357, partSurface_358, partSurface_359, partSurface_360, partSurface_361, partSurface_362, partSurface_363, partSurface_364, partSurface_365, partSurface_366, partSurface_367, partSurface_368, partSurface_369, partSurface_370, partSurface_371, partSurface_372, partSurface_373, partSurface_374, partSurface_375, partSurface_376, partSurface_377, partSurface_378, partSurface_379, partSurface_380, partSurface_381, partSurface_382, partSurface_383, partSurface_384, partSurface_385, partSurface_386, partSurface_387, partSurface_388, partSurface_389, partSurface_390, partSurface_391, partSurface_392, partSurface_393, partSurface_394, partSurface_395, partSurface_396, partSurface_397, partSurface_398, partSurface_399, partSurface_400, partSurface_401, partSurface_402, partSurface_403, partSurface_404, partSurface_405, partSurface_406, partSurface_407, partSurface_408, partSurface_409, partSurface_410, partSurface_411, partSurface_412, partSurface_413, partSurface_414, partSurface_415, partSurface_416, partSurface_417, partSurface_418, partSurface_419, partSurface_420, partSurface_421, partSurface_422, partSurface_423, partSurface_424, partSurface_425, partSurface_426, partSurface_427, partSurface_428, partSurface_429, partSurface_430, partSurface_431, partSurface_432, partSurface_433, partSurface_434, partSurface_435, partSurface_436, partSurface_437, partSurface_438, partSurface_439, partSurface_440, partSurface_441, partSurface_442, partSurface_443, partSurface_444, partSurface_445, partSurface_446, partSurface_447, partSurface_448, partSurface_449, partSurface_450, partSurface_451, partSurface_452, partSurface_453, partSurface_454, partSurface_455, partSurface_456, partSurface_457, partSurface_458, partSurface_459, partSurface_460, partSurface_461, partSurface_462, partSurface_463, partSurface_464, partSurface_465, partSurface_466, partSurface_467, partSurface_468, partSurface_469, partSurface_470, partSurface_471, partSurface_472, partSurface_473, partSurface_474, partSurface_475, partSurface_476, partSurface_477, partSurface_478, partSurface_479, partSurface_480, partSurface_481, partSurface_482, partSurface_483, partSurface_484, partSurface_485, partSurface_486, partSurface_487, partSurface_488, partSurface_489, partSurface_490, partSurface_491, partSurface_492, partSurface_493, partSurface_494, partSurface_495, partSurface_496, partSurface_497, partSurface_498, partSurface_499, partSurface_500, partSurface_501, partSurface_502, partSurface_503, partSurface_504, partSurface_505, partSurface_506, partSurface_507, partSurface_508, partSurface_509, partSurface_510, partSurface_511, partSurface_512, partSurface_513, partSurface_514, partSurface_515, partSurface_516, partSurface_517, partSurface_518, partSurface_519, partSurface_520, partSurface_521, partSurface_522, partSurface_523, partSurface_524, partSurface_525, partSurface_526, partSurface_527, partSurface_528, partSurface_529, partSurface_530, partSurface_531, partSurface_532, partSurface_533, partSurface_534, partSurface_535, partSurface_536, partSurface_537, partSurface_538, partSurface_539, partSurface_540, partSurface_541, partSurface_542, partSurface_543, partSurface_544, partSurface_545, partSurface_546, partSurface_547, partSurface_548, partSurface_549, partSurface_550, partSurface_551, partSurface_552, partSurface_553, partSurface_554, partSurface_555, partSurface_556, partSurface_557, partSurface_558, partSurface_559, partSurface_560, partSurface_561, partSurface_562, partSurface_563, partSurface_564, partSurface_565, partSurface_566, partSurface_567, partSurface_568, partSurface_569, partSurface_570, partSurface_571, partSurface_572, partSurface_573, partSurface_574, partSurface_575, partSurface_576, partSurface_577, partSurface_578, partSurface_579, partSurface_580, partSurface_581, partSurface_582, partSurface_583, partSurface_584, partSurface_585, partSurface_586, partSurface_587, partSurface_588, partSurface_589, partSurface_590, partSurface_591, partSurface_592, partSurface_593, partSurface_594, partSurface_595, partSurface_596, partSurface_597, partSurface_598, partSurface_599, partSurface_600, partSurface_601, partSurface_602, partSurface_603, partSurface_604, partSurface_605, partSurface_606, partSurface_607, partSurface_608, partSurface_609, partSurface_610, partSurface_611, partSurface_612, partSurface_613, partSurface_614, partSurface_615, partSurface_616, partSurface_617, partSurface_618, partSurface_619, partSurface_620, partSurface_621, partSurface_622, partSurface_623, partSurface_624, partSurface_625, partSurface_626, partSurface_627, partSurface_628, partSurface_629, partSurface_630, partSurface_631, partSurface_632, partSurface_633, partSurface_634, partSurface_635, partSurface_636, partSurface_637, partSurface_638, partSurface_639, partSurface_640, partSurface_641, partSurface_642, partSurface_643, partSurface_644, partSurface_645, partSurface_646, partSurface_647, partSurface_648, partSurface_649, partSurface_650, partSurface_651, partSurface_652, partSurface_653, partSurface_654, partSurface_655, partSurface_656, partSurface_657, partSurface_658, partSurface_659, partSurface_660, partSurface_661, partSurface_662, partSurface_663, partSurface_664, partSurface_665, partSurface_666, partSurface_667, partSurface_668, partSurface_669, partSurface_670, partSurface_671, partSurface_672, partSurface_673, partSurface_674, partSurface_675, partSurface_676, partSurface_677, partSurface_678, partSurface_679, partSurface_680, partSurface_681, partSurface_682, partSurface_683, partSurface_684, partSurface_685, partSurface_686, partSurface_687, partSurface_688, partSurface_689, partSurface_690, partSurface_691, partSurface_692, partSurface_693, partSurface_694, partSurface_695, partSurface_696, partSurface_697, partSurface_698, partSurface_699, partSurface_700);
  }

  private void execute3() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 1");

    PartDisplayer partDisplayer_16 = 
      ((PartDisplayer) scene_0.getDisplayerManager().getObject("Suspension"));

    partDisplayer_16.setDisplayerColor(new DoubleVector(new double[] {0.8600000143051147, 0.1599999964237213, 0.1599999964237213}));

    PartDisplayer partDisplayer_17 = 
      scene_0.getDisplayerManager().createPartDisplayer("Dummy", -1, 0);

    partDisplayer_17.copyProperties(partDisplayer_16);

    partDisplayer_17.setPresentationName("Suspension copy");

    SimpleTransform simpleTransform_0 = 
      ((SimpleTransform) simulation_0.getTransformManager().getObject("Simple Transform 1"));

    partDisplayer_17.setVisTransform(simpleTransform_0);

    ScalarDisplayer scalarDisplayer_0 = 
      ((ScalarDisplayer) scene_0.getDisplayerManager().getObject("Isosurface Scalar 1"));

    scalarDisplayer_0.setVisibilityOverrideMode(DisplayerVisibilityOverride.USE_PART_PROPERTY);

    scalarDisplayer_0.setVisibilityOverrideMode(DisplayerVisibilityOverride.HIDE_ALL_PARTS);

    PartDisplayer partDisplayer_15 = 
      ((PartDisplayer) scene_0.getDisplayerManager().getObject("Surface 3"));

    partDisplayer_15.setVisibilityOverrideMode(DisplayerVisibilityOverride.USE_PART_PROPERTY);

    partDisplayer_15.setVisibilityOverrideMode(DisplayerVisibilityOverride.HIDE_ALL_PARTS);
  }
    private void execute4() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 1");

    SceneUpdate sceneUpdate_0 = 
      scene_0.getSceneUpdate();

    sceneUpdate_0.getUpdateModeOption().setSelected(StarUpdateModeOption.Type.TIMESTEP);

    TimeStepUpdateFrequency timeStepUpdateFrequency_0 = 
      sceneUpdate_0.getTimeStepUpdateFrequency();

    IntegerValue integerValue_0 = 
      timeStepUpdateFrequency_0.getTimeStepFrequencyQuantity();

    integerValue_0.getQuantity().setValue(3000.0);

//    String FileName = simulation_0.getPresentationName();
  //  simulation_0.saveState(resolvePath(FileName + ".sim"));


  }
}
