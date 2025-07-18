// Simcenter STAR-CCM+ macro: b.java
// Written by Simcenter STAR-CCM+ 18.06.006
package macro;

import java.util.*;
import java.io.File;

import star.common.*;
import star.base.neo.*;
import star.amr.*;
import star.vis.*;
import star.cadmodeler.*;
import star.meshing.*;
import star.material.*;
import star.flow.*;
import star.base.query.*;
import star.surfacetools.*;
import star.surfacewrapper.*;
import star.base.report.*;
import star.prismmesher.*;

public class full extends StarMacro {

  public void execute() {
    prism();
    cad();
    driver1();
    driver2();
    ut();
   // ops();
    props();
    yawch();
    //mesh();
  }

  private void prism() {

    Simulation simulation_0 = 
      getActiveSimulation();

    AutoMeshOperation autoMeshOperation_0 = 
      ((AutoMeshOperation) simulation_0.get(MeshOperationManager.class).getObject("air"));

    NumPrismLayers numPrismLayers_0 = 
      autoMeshOperation_0.getDefaultValues().get(NumPrismLayers.class);

    IntegerValue integerValue_0 = 
      numPrismLayers_0.getNumLayersValue();

    integerValue_0.getQuantity().setValue(10.0);

    Units units_0 = 
      ((Units) simulation_0.getUnitsManager().getObject("mm"));

    autoMeshOperation_0.getDefaultValues().get(PrismWallThickness.class).setValueAndUnits(0.04, units_0);

    Units units_1 = 
      ((Units) simulation_0.getUnitsManager().getObject(""));

    autoMeshOperation_0.getDefaultValues().get(PrismLayerCoreLayerAspectRatio.class).setValueAndUnits(0.5, units_1);

    PhysicsContinuum physicsContinuum_0 = 
      ((PhysicsContinuum) simulation_0.getContinuumManager().getContinuum("k-epsilon Lag EB"));

    AmrModel amrModel_0 = 
      physicsContinuum_0.getModelManager().getModel(AmrModel.class);

    Units units_2 = 
      ((Units) simulation_0.getUnitsManager().getObject("m"));

    amrModel_0.getMinAdaptionCellSize().setValueAndUnits(6.5E-4, units_2);
  }
  private void cad() {

    Simulation simulation_0 = 
      getActiveSimulation();

    SolidModelCompositePart solidModelCompositePart_0 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("C_MONOCOQUE"));

    CompositePart compositePart_0 = 
      ((CompositePart) solidModelCompositePart_0.getChildParts().getPart("C_HR00_HEAD_RESTRAINT_ASM"));

    solidModelCompositePart_0.getChildParts().removeObjects(compositePart_0);

    PartImportManager partImportManager_0 = 
      simulation_0.get(PartImportManager.class);

    partImportManager_0.importCadPart(resolvePath("c_hr00_head_restraint_asm.stp"), "SharpEdges", 30.0, 5, true, 1.0E-5, true, false, false, false, true, NeoProperty.fromString("{\'NX\': 1, \'STEP\': 1, \'SE\': 1, \'CGR\': 1, \'SW\': 1, \'IFC\': 1, \'ACIS\': 1, \'JT\': 1, \'IGES\': 1, \'CATIAV5\': 1, \'CATIAV4\': 1, \'3DXML\': 1, \'CREO\': 1, \'INV\': 1}"), true, false);

    CompositePart compositePart_1 = 
      ((CompositePart) simulation_0.get(SimulationPartManager.class).getPart("C_HR00_HEAD_RESTRAINT_ASM"));

    solidModelCompositePart_0.getChildParts().reparentParts(Arrays.<GeometryPart>asList(compositePart_1), solidModelCompositePart_0.getChildParts());

    partImportManager_0.importCadPart(resolvePath("a_f000_frontwing_asm.stp"), "SharpEdges", 30.0, 5, true, 1.0E-5, true, false, false, false, true, NeoProperty.fromString("{\'NX\': 1, \'STEP\': 1, \'SE\': 1, \'CGR\': 1, \'SW\': 1, \'IFC\': 1, \'ACIS\': 1, \'JT\': 1, \'IGES\': 1, \'CATIAV5\': 1, \'CATIAV4\': 1, \'3DXML\': 1, \'CREO\': 1, \'INV\': 1}"), true, false);

    SolidModelCompositePart solidModelCompositePart_1 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("C_FRONTWING"));

    CompositePart compositePart_2 = 
      ((CompositePart) solidModelCompositePart_1.getChildParts().getPart("A_F000_FRONTWING_ASM"));

    solidModelCompositePart_1.getChildParts().removeObjects(compositePart_2);

    CompositePart compositePart_3 = 
      ((CompositePart) simulation_0.get(SimulationPartManager.class).getPart("A_F000_FRONTWING_ASM"));

    solidModelCompositePart_1.getChildParts().reparentParts(Arrays.<GeometryPart>asList(compositePart_3), solidModelCompositePart_1.getChildParts());

    partImportManager_0.importCadPart(resolvePath("a_r000_rearwing_asm.stp"), "SharpEdges", 30.0, 5, true, 1.0E-5, true, false, false, false, true, NeoProperty.fromString("{\'NX\': 1, \'STEP\': 1, \'SE\': 1, \'CGR\': 1, \'SW\': 1, \'IFC\': 1, \'ACIS\': 1, \'JT\': 1, \'IGES\': 1, \'CATIAV5\': 1, \'CATIAV4\': 1, \'3DXML\': 1, \'CREO\': 1, \'INV\': 1}"), true, false);

    SolidModelCompositePart solidModelCompositePart_2 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("C_REARWING"));

    CompositePart compositePart_4 = 
      ((CompositePart) solidModelCompositePart_2.getChildParts().getPart("A_R000_REARWING_ASM"));

    solidModelCompositePart_2.getChildParts().removeObjects(compositePart_4);

    CompositePart compositePart_5 = 
      ((CompositePart) simulation_0.get(SimulationPartManager.class).getPart("A_R000_REARWING_ASM"));

    solidModelCompositePart_2.getChildParts().reparentParts(Arrays.<GeometryPart>asList(compositePart_5), solidModelCompositePart_2.getChildParts());

    partImportManager_0.importCadPart(resolvePath("e_bp00_buttons_and_panel_asm.stp"), "SharpEdges", 30.0, 5, true, 1.0E-5, true, false, false, false, true, NeoProperty.fromString("{\'NX\': 1, \'STEP\': 1, \'SE\': 1, \'CGR\': 1, \'SW\': 1, \'IFC\': 1, \'ACIS\': 1, \'JT\': 1, \'IGES\': 1, \'CATIAV5\': 1, \'CATIAV4\': 1, \'3DXML\': 1, \'CREO\': 1, \'INV\': 1}"), true, false);

    Scene scene_6 = 
      simulation_0.getSceneManager().getScene("3D-CAD Vehicle");

    CurrentView currentView_0 = 
      scene_6.getCurrentView();

    currentView_0.setInput(new DoubleVector(new double[] {0.7423606330914452, -0.19160055628258799, 0.5647964806044948}), new DoubleVector(new double[] {45.50601196619888, -88.86656679646968, 32.091017421673826}), new DoubleVector(new double[] {-0.06765021784927197, 0.3037252625534928, 0.9503548878770318}), 0.7597651050641501, 1, 30.0);

    CompositePart compositePart_8 = 
      ((CompositePart) simulation_0.get(SimulationPartManager.class).getPart("E_BP00_BUTTONS_AND_PANEL_ASM"));

    CompositePart compositePart_9 = 
      ((CompositePart) compositePart_8.getChildParts().getPart("E_BP01_LED_STRIP_2_0_B 3"));

    compositePart_8.getChildParts().removeObjects(compositePart_9);

    SolidModelCompositePart solidModelCompositePart_4 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("z_000_remaining-parts"));

    solidModelCompositePart_4.getChildParts().reparentParts(Arrays.<GeometryPart>asList(compositePart_8), solidModelCompositePart_4.getChildParts());
  }

  private void driver1() {

    Simulation simulation_0 = 
      getActiveSimulation();

      Units units_0 = ((Units) simulation_0.getUnitsManager().getObject("mm"));


    SolidModelCompositePart solidModelCompositePart_1 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("z_000_remaining-parts"));

    CompositePart compositePart_2 = 
      ((CompositePart) solidModelCompositePart_1.getChildParts().getPart("C_P002_FAHRER_GERADEAUS"));

    MeshPart meshPart_0 = 
      ((MeshPart) compositePart_2.getChildParts().getPart("driver"));

    LabCoordinateSystem labCoordinateSystem_0 = 
      simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

    compositePart_2.getChildParts().translateParts(new NeoObjectVector(new Object[] {meshPart_0}), new DoubleVector(new double[] {0.0, 7.5, 0.0}), new NeoObjectVector(new Object[] {units_0, units_0, units_0}), labCoordinateSystem_0);

    PartSurface partSurface_0 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface"));

    meshPart_0.getPartSurfaceManager().splitNonContiguousPartSurfaces(new NeoObjectVector(new Object[] {partSurface_0}));

    Scene scene_6 = 
      simulation_0.getSceneManager().getScene("3D-CAD Vehicle");

    CurrentView currentView_0 = 
      scene_6.getCurrentView();

    currentView_0.setInput(new DoubleVector(new double[] {0.7702038475270987, 0.26400988562178807, 0.5732843585529226}), new DoubleVector(new double[] {79.24680125593946, 46.33633852611267, 49.75251674090305}), new DoubleVector(new double[] {-0.3429169925608792, -0.3474837083441427, 0.8727330683826462}), 0.27866059911255514, 1, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.6833170420380358, 0.1813474015040311, 0.4801627096808012}), new DoubleVector(new double[] {40.76285051479227, 62.33330354898303, 72.78367823640394}), new DoubleVector(new double[] {-0.5053492273776546, -0.49576499648577993, 0.706285513548486}), 0.27866059911255514, 1, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.525264082297336, 0.3285550844424572, 0.5340607089193137}), new DoubleVector(new double[] {40.57965070827734, 62.44151562537274, 72.79221130075804}), new DoubleVector(new double[] {-0.5053492273776546, -0.49576499648577993, 0.7062855135484861}), 0.40798517400462075, 1, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.6672675262146404, 0.3117479295073089, 0.46272033175708094}), new DoubleVector(new double[] {40.72356998260452, 62.42767937846236, 72.72432708343064}), new DoubleVector(new double[] {-0.5053492273776546, -0.49576499648577993, 0.7062855135484861}), 0.40798517400462075, 1, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.6743278320672887, 0.3203253560655038, 0.46416507934047535}), new DoubleVector(new double[] {16.679880887431455, 38.919805731287106, 94.96087897147508}), new DoubleVector(new double[] {-0.6131807107021829, -0.6894927104864049, 0.3854986617474339}), 0.40798517400462075, 1, 30.0);

    PartSurface partSurface_1 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 92"));

    PartSurface partSurface_2 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 61"));

    PartSurface partSurface_3 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 88"));

    PartSurface partSurface_4 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 66"));

    PartSurface partSurface_5 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 79"));

    PartSurface partSurface_6 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 68"));

    PartSurface partSurface_7 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 62"));

    PartSurface partSurface_8 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 26"));

    PartSurface partSurface_9 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 58"));

    PartSurface partSurface_10 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 78"));

    PartSurface partSurface_11 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 56"));

    PartSurface partSurface_12 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 71"));

    PartSurface partSurface_13 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 85"));

    PartSurface partSurface_14 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 86"));

    PartSurface partSurface_15 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 91"));

    PartSurface partSurface_16 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 64"));

    PartSurface partSurface_17 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 74"));

    PartSurface partSurface_18 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 72"));

    PartSurface partSurface_19 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 82"));

    PartSurface partSurface_20 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 51"));

    PartSurface partSurface_21 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 75"));

    PartSurface partSurface_22 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 7"));

    meshPart_0.deleteMeshPartSurfaces(new NeoObjectVector(new Object[] {partSurface_1, partSurface_2, partSurface_3, partSurface_4, partSurface_5, partSurface_6, partSurface_7, partSurface_8, partSurface_9, partSurface_10, partSurface_11, partSurface_12, partSurface_13, partSurface_14, partSurface_15, partSurface_16, partSurface_17, partSurface_18, partSurface_19, partSurface_20, partSurface_21, partSurface_22}));

    currentView_0.setInput(new DoubleVector(new double[] {0.7563835614869214, 0.4172985507292182, 0.6260841130623613}), new DoubleVector(new double[] {72.9114573285714, 56.27687493743646, 49.00025502297062}), new DoubleVector(new double[] {-0.3084398406871945, -0.36301167104789694, 0.8792538833352196}), 0.40798517400462075, 1, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.6592545469837028, 0.29489993264925174, 0.44972104310478245}), new DoubleVector(new double[] {6.799169865839348, 43.099992862897125, 94.2406206173148}), new DoubleVector(new double[] {-0.590723518666262, -0.7187359141119928, 0.36669389176852235}), 0.40798517400462075, 1, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.7724191863297252, 0.23673201517659703, 0.3843078491960754}), new DoubleVector(new double[] {6.9168992600576225, 43.07364863457382, 94.24493679972011}), new DoubleVector(new double[] {-0.590723518666262, -0.7187359141119928, 0.36669389176852235}), 0.40798517400462075, 1, 30.0);

    PartSurface partSurface_23 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 73"));

    PartSurface partSurface_24 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 87"));

    PartSurface partSurface_25 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 94"));

    PartSurface partSurface_26 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 90"));

    PartSurface partSurface_27 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 60"));

    PartSurface partSurface_28 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 76"));

    PartSurface partSurface_29 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 80"));

    PartSurface partSurface_30 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 52"));

    PartSurface partSurface_31 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 81"));

    PartSurface partSurface_32 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 89"));

    PartSurface partSurface_33 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 63"));

    PartSurface partSurface_34 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 69"));

    PartSurface partSurface_35 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 67"));

    PartSurface partSurface_36 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 31"));

    PartSurface partSurface_37 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 84"));

    PartSurface partSurface_38 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 65"));

    PartSurface partSurface_39 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 70"));

    PartSurface partSurface_40 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 57"));

    PartSurface partSurface_41 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 93"));

    PartSurface partSurface_42 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 77"));

    PartSurface partSurface_43 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 59"));

    PartSurface partSurface_44 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 83"));

    PartSurface partSurface_45 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface 8"));

    meshPart_0.combinePartSurfaces(new NeoObjectVector(new Object[] {partSurface_23, partSurface_24, partSurface_25, partSurface_26, partSurface_27, partSurface_28, partSurface_29, partSurface_30, partSurface_31, partSurface_32, partSurface_33, partSurface_34, partSurface_35, partSurface_36, partSurface_37, partSurface_38, partSurface_39, partSurface_40, partSurface_41, partSurface_42, partSurface_43, partSurface_44, partSurface_45}));

    currentView_0.setInput(new DoubleVector(new double[] {0.9654277576406569, 0.42755283454011683, 0.7326431040647396}), new DoubleVector(new double[] {86.23995016668016, 36.65957740394795, 46.38836928278427}), new DoubleVector(new double[] {-0.27033293532808844, -0.44171172490652627, 0.8554594415617833}), 0.40798517400462075, 1, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.3623547688981108, 0.32796523613990436, 0.8250759118968072}), new DoubleVector(new double[] {86.36144940372151, 36.44296416177308, 46.33333887784915}), new DoubleVector(new double[] {-0.27033293532808844, -0.44171172490652627, 0.8554594415617833}), 0.40798517400462075, 1, 30.0);

    MeshPartFactory meshPartFactory_0 = 
      simulation_0.get(MeshPartFactory.class);

    meshPartFactory_0.newPartFromPartSurfaces(new NeoObjectVector(new Object[] {partSurface_23}));

    MeshPart meshPart_1 = 
      ((MeshPart) compositePart_2.getChildParts().getPart("Part"));

    MeshPart meshPart_2 = 
      (MeshPart) meshPart_1.duplicatePart(compositePart_2.getChildParts());

    meshPart_2.setPresentationName("Part copy");

    compositePart_2.getChildParts().reflectParts(new NeoObjectVector(new Object[] {meshPart_2}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), new NeoObjectVector(new Object[] {units_0, units_0, units_0}), labCoordinateSystem_0);

    currentView_0.setInput(new DoubleVector(new double[] {1.3623547688981108, 0.32796523613990436, 0.8250759118968072}), new DoubleVector(new double[] {86.36144940372151, 36.44296416177308, 46.33333887784915}), new DoubleVector(new double[] {-0.27033293532808844, -0.44171172490652627, 0.8554594415617833}), 0.40798517400462075, 1, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.9973370118668639, 0.17110908967202085, 0.6235221053458307}), new DoubleVector(new double[] {59.5294911174301, 38.010702387834655, 76.96896883391686}), new DoubleVector(new double[] {-0.4998710687629176, -0.5599316338669199, 0.660761288219233}), 0.40798517400462075, 1, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.854210980005778, 0.08525302348941777, 0.4820027080183227}), new DoubleVector(new double[] {59.509222345742, 38.004270508745655, 76.98769627108717}), new DoubleVector(new double[] {-0.4998710687629176, -0.5599316338669199, 0.660761288219233}), 0.29742123889378513, 1, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.8708621959651013, 0.09556177157103804, 0.5035218388261362}), new DoubleVector(new double[] {50.08167688636268, 53.661302997119, 74.21560802412657}), new DoubleVector(new double[] {-0.4700375375332632, -0.5346277234409045, 0.7023089851612807}), 0.29742123889378513, 1, 30.0);

    meshPartFactory_0.combineMeshParts(meshPart_2, new NeoObjectVector(new Object[] {meshPart_1, meshPart_0}));

    meshPart_2.setPresentationName("driver");

    currentView_0.setInput(new DoubleVector(new double[] {0.7247990883994531, 0.48313600479470153, 0.8911667960017011}), new DoubleVector(new double[] {49.74221624382839, 53.838364919645024, 74.31356593069508}), new DoubleVector(new double[] {-0.4700375375332632, -0.5346277234409045, 0.7023089851612807}), 0.5268944137231898, 1, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.5403779315358441, 0.42039538445077884, 0.4527276624808607}), new DoubleVector(new double[] {49.763157946072155, 53.99916080926321, 74.1827365139615}), new DoubleVector(new double[] {-0.4700375375332632, -0.5346277234409045, 0.7023089851612807}), 0.5268944137231898, 1, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.5065527383888908, 0.32218273270138564, 0.2918873512763776}), new DoubleVector(new double[] {1.0177614137504674, 50.81435875143005, 90.66924191898}), new DoubleVector(new double[] {-0.5596237887159342, -0.7221409629454246, 0.4066124011139925}), 0.5268944137231898, 1, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.5065527383888908, 0.32218273270138564, 0.2918873512763776}), new DoubleVector(new double[] {1.0177614137504674, 50.81435875143005, 90.66924191898}), new DoubleVector(new double[] {-0.5596237887159342, -0.7221409629454246, 0.4066124011139925}), 0.5268944137231898, 1, 30.0);

    PartSurface partSurface_46 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 54"));

    meshPartFactory_0.newPartFromPartSurfaces(new NeoObjectVector(new Object[] {partSurface_46}));

    MeshPart meshPart_3 = 
      ((MeshPart) compositePart_2.getChildParts().getPart("Part"));

    compositePart_2.getChildParts().translateParts(new NeoObjectVector(new Object[] {meshPart_3}), new DoubleVector(new double[] {0.0, 0.0, -6.0}), new NeoObjectVector(new Object[] {units_0, units_0, units_0}), labCoordinateSystem_0);

    currentView_0.setInput(new DoubleVector(new double[] {0.9556380244818949, 0.2500443043716105, 0.5862012879458725}), new DoubleVector(new double[] {1.465740769891027, 50.632987415846266, 90.76803682740055}), new DoubleVector(new double[] {-0.5596237887159342, -0.7221409629454246, 0.4066124011139925}), 0.2520172496901751, 1, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.9556380244818949, 0.2500443043716105, 0.5862012879458725}), new DoubleVector(new double[] {1.465740769891027, 50.632987415846266, 90.76803682740055}), new DoubleVector(new double[] {-0.5596237887159342, -0.7221409629454246, 0.4066124011139925}), 0.2520172496901751, 1, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.9545897206161764, 0.16215956785779306, 0.4297155951496199}), new DoubleVector(new double[] {-4.183592811698921, 37.92818599062714, 96.64368460847082}), new DoubleVector(new double[] {-0.5564258482743655, -0.78312524752233, 0.27767809071918587}), 0.2520172496901751, 1, 30.0);

    meshPartFactory_0.combineMeshParts(meshPart_2, new NeoObjectVector(new Object[] {meshPart_3}));

    currentView_0.setInput(new DoubleVector(new double[] {0.5841790694825587, 0.4783090023341461, 0.29366647467506546}), new DoubleVector(new double[] {-4.553642142799968, 38.24167969580404, 96.50086966482851}), new DoubleVector(new double[] {-0.5564258482743655, -0.78312524752233, 0.2776780907191858}), 0.7190276359244104, 1, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.5697062593511806, 0.36903096485176956, 0.34544228212526207}), new DoubleVector(new double[] {-4.567669288836396, 38.12912599384698, 96.54430028190215}), new DoubleVector(new double[] {-0.5564258482743655, -0.78312524752233, 0.2776780907191858}), 0.7190276359244104, 1, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.6152106335919497, 0.4756046012987511, 0.5244615277823406}), new DoubleVector(new double[] {48.41934769256243, 61.35992730580132, 69.18092763909371}), new DoubleVector(new double[] {-0.43476217431696484, -0.501845976517177, 0.7477516082476308}), 0.7190276359244104, 1, 30.0);

    PartSurface partSurface_47 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 36"));

    PartSurface partSurface_48 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 100"));

    PartSurface partSurface_49 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 44"));

    PartSurface partSurface_50 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 27"));

    PartSurface partSurface_51 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 20"));

    PartSurface partSurface_52 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 39"));

    PartSurface partSurface_53 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 15"));

    PartSurface partSurface_54 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 5"));

    PartSurface partSurface_55 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 19"));

    PartSurface partSurface_56 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 30"));

    PartSurface partSurface_57 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 34"));

    PartSurface partSurface_58 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 11"));

    PartSurface partSurface_59 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 42"));

    PartSurface partSurface_60 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 9"));

    PartSurface partSurface_61 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 99"));

    PartSurface partSurface_62 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 48"));

    PartSurface partSurface_63 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 50"));

    PartSurface partSurface_64 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 101"));

    PartSurface partSurface_65 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 25"));

    PartSurface partSurface_66 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 2"));

    PartSurface partSurface_67 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 55"));

    PartSurface partSurface_68 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 35"));

    PartSurface partSurface_69 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 41"));

    PartSurface partSurface_70 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 29"));

    PartSurface partSurface_71 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 96"));

    PartSurface partSurface_72 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 53"));

    PartSurface partSurface_73 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 21"));

    PartSurface partSurface_74 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 3"));

    PartSurface partSurface_75 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 46"));

    PartSurface partSurface_76 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 43"));

    PartSurface partSurface_77 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 28"));

    PartSurface partSurface_78 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 73"));

    PartSurface partSurface_79 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 97"));

    PartSurface partSurface_80 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 10"));

    PartSurface partSurface_81 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 38"));

    PartSurface partSurface_82 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 4"));

    PartSurface partSurface_83 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 13"));

    PartSurface partSurface_84 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 37"));

    PartSurface partSurface_85 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 32"));

    PartSurface partSurface_86 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 47"));

    PartSurface partSurface_87 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 22"));

    PartSurface partSurface_88 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 18"));

    PartSurface partSurface_89 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 6"));

    PartSurface partSurface_90 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 23"));

    PartSurface partSurface_91 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 17"));

    PartSurface partSurface_92 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 16"));

    PartSurface partSurface_93 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 14"));

    PartSurface partSurface_94 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 12"));

    PartSurface partSurface_95 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 98"));

    PartSurface partSurface_96 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 95"));

    PartSurface partSurface_97 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 33"));

    PartSurface partSurface_98 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 45"));

    PartSurface partSurface_99 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 40"));

    PartSurface partSurface_100 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 49"));

    PartSurface partSurface_101 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 24"));

    meshPart_2.combinePartSurfaces(new NeoObjectVector(new Object[] {partSurface_0, partSurface_47, partSurface_48, partSurface_49, partSurface_50, partSurface_51, partSurface_52, partSurface_53, partSurface_54, partSurface_55, partSurface_56, partSurface_57, partSurface_58, partSurface_59, partSurface_60, partSurface_61, partSurface_62, partSurface_63, partSurface_64, partSurface_65, partSurface_66, partSurface_67, partSurface_68, partSurface_69, partSurface_70, partSurface_71, partSurface_72, partSurface_73, partSurface_46, partSurface_74, partSurface_75, partSurface_76, partSurface_77, partSurface_23, partSurface_78, partSurface_79, partSurface_80, partSurface_81, partSurface_82, partSurface_83, partSurface_84, partSurface_85, partSurface_86, partSurface_87, partSurface_88, partSurface_89, partSurface_90, partSurface_91, partSurface_92, partSurface_93, partSurface_94, partSurface_95, partSurface_96, partSurface_97, partSurface_98, partSurface_99, partSurface_100, partSurface_101}));

    currentView_0.setInput(new DoubleVector(new double[] {0.5146273742937477, 0.34148934432771494, 0.3821030611742307}), new DoubleVector(new double[] {45.00356243618151, 73.73811841341889, 58.43148904021879}), new DoubleVector(new double[] {-0.3794747228393132, -0.4214133270485862, 0.8236563254853828}), 0.7190276359244104, 1, 30.0);

    meshPart_2.getPartSurfaceManager().splitNonContiguousPartSurfaces(new NeoObjectVector(new Object[] {partSurface_0}));

    PartSurface partSurface_102 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 9"));

    PartSurface partSurface_103 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 42"));

    PartSurface partSurface_104 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 29"));

    PartSurface partSurface_105 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 11"));

    PartSurface partSurface_106 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 32"));

    PartSurface partSurface_107 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 24"));

    PartSurface partSurface_108 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 22"));

    PartSurface partSurface_109 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 18"));

    PartSurface partSurface_110 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 21"));

    PartSurface partSurface_111 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 82"));

    PartSurface partSurface_112 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 25"));

    PartSurface partSurface_113 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 16"));

    PartSurface partSurface_114 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 46"));

    PartSurface partSurface_115 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 80"));

    PartSurface partSurface_116 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 26"));

    PartSurface partSurface_117 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 23"));

    PartSurface partSurface_118 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 4"));

    PartSurface partSurface_119 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 2"));

    PartSurface partSurface_120 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 41"));

    PartSurface partSurface_121 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 37"));

    PartSurface partSurface_122 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 20"));

    PartSurface partSurface_123 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 39"));

    PartSurface partSurface_124 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 44"));

    PartSurface partSurface_125 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 8"));

    PartSurface partSurface_126 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 7"));

    PartSurface partSurface_127 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 6"));

    PartSurface partSurface_128 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 10"));

    PartSurface partSurface_129 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 47"));

    PartSurface partSurface_130 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 31"));

    PartSurface partSurface_131 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 5"));

    PartSurface partSurface_132 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 12"));

    PartSurface partSurface_133 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 17"));

    PartSurface partSurface_134 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 40"));

    PartSurface partSurface_135 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 27"));

    PartSurface partSurface_136 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 15"));

    PartSurface partSurface_137 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 43"));

    PartSurface partSurface_138 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 36"));

    PartSurface partSurface_139 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 28"));

    PartSurface partSurface_140 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 30"));

    PartSurface partSurface_141 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 34"));

    PartSurface partSurface_142 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 14"));

    PartSurface partSurface_143 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 35"));

    PartSurface partSurface_144 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 3"));

    PartSurface partSurface_145 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 19"));

    PartSurface partSurface_146 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 45"));

    PartSurface partSurface_147 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 13"));

    PartSurface partSurface_148 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 33"));

    meshPart_2.combinePartSurfaces(new NeoObjectVector(new Object[] {partSurface_102, partSurface_103, partSurface_104, partSurface_105, partSurface_106, partSurface_107, partSurface_108, partSurface_109, partSurface_110, partSurface_111, partSurface_112, partSurface_113, partSurface_114, partSurface_115, partSurface_116, partSurface_117, partSurface_118, partSurface_119, partSurface_120, partSurface_121, partSurface_122, partSurface_123, partSurface_124, partSurface_125, partSurface_126, partSurface_127, partSurface_128, partSurface_0, partSurface_129, partSurface_130, partSurface_131, partSurface_132, partSurface_133, partSurface_134, partSurface_135, partSurface_136, partSurface_137, partSurface_138, partSurface_139, partSurface_140, partSurface_141, partSurface_142, partSurface_143, partSurface_144, partSurface_145, partSurface_146, partSurface_147, partSurface_148}));

    meshPartFactory_0.newPartFromPartSurfaces(new NeoObjectVector(new Object[] {partSurface_102}));

    MeshPart meshPart_4 = 
      ((MeshPart) compositePart_2.getChildParts().getPart("Part"));

    compositePart_2.getChildParts().translateParts(new NeoObjectVector(new Object[] {meshPart_4}), new DoubleVector(new double[] {0.0, 0.0, 62.5}), new NeoObjectVector(new Object[] {units_0, units_0, units_0}), labCoordinateSystem_0);

    currentView_0.setInput(new DoubleVector(new double[] {0.5686387921507394, 0.4814847119477052, 0.4416610476822275}), new DoubleVector(new double[] {11.840844954303703, 103.37841684064607, -2.9339493837640247}), new DoubleVector(new double[] {-0.22821638982208076, 0.05688621585036997, 0.9719471373809477}), 0.7190276359244104, 1, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.5413587400574882, 0.07083795537865001, 0.5317021352655031}), new DoubleVector(new double[] {11.85861252879706, 103.37898174120625, -2.8573984006048696}), new DoubleVector(new double[] {-0.22821638982208076, 0.05688621585036997, 0.9719471373809477}), 0.471754458022309, 1, 30.0);

    scene_6.setViewOrientation(new DoubleVector(new double[] {0.0, -1.0, 0.0}), new DoubleVector(new double[] {0.0, 0.0, 1.0}));

    compositePart_2.getChildParts().translateParts(new NeoObjectVector(new Object[] {meshPart_4}), new DoubleVector(new double[] {20.0, 0.0, 0.0}), new NeoObjectVector(new Object[] {units_0, units_0, units_0}), labCoordinateSystem_0);

    currentView_0.setInput(new DoubleVector(new double[] {0.5920387517731877, 0.07101697564787912, 0.5156328632580862}), new DoubleVector(new double[] {0.5920387517731877, -103.9105969656408, 0.5156328632580862}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 0.7597651050641501, 1, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.5699257732242353, 0.11390425818799764, 0.5045680812711247}), new DoubleVector(new double[] {81.04591530419737, -51.984706684509, 40.77274260032111}), new DoubleVector(new double[] {-0.1996750637001407, 0.3872624496115017, 0.900087586880992}), 0.7597651050641501, 1, 30.0);

    meshPartFactory_0.combineMeshParts(meshPart_2, new NeoObjectVector(new Object[] {meshPart_4}));

    PartSurface partSurface_149 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 87"));

    PartSurface partSurface_150 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 95"));

    PartSurface partSurface_151 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 58"));

    PartSurface partSurface_152 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 98"));

    PartSurface partSurface_153 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 101"));

    PartSurface partSurface_154 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 67"));

    PartSurface partSurface_155 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 83"));

    PartSurface partSurface_156 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 89"));

    PartSurface partSurface_157 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 51"));

    PartSurface partSurface_158 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 91"));

    PartSurface partSurface_159 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 62"));

    PartSurface partSurface_160 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 57"));

    PartSurface partSurface_161 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 93"));

    PartSurface partSurface_162 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 60"));

    PartSurface partSurface_163 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 85"));

    PartSurface partSurface_164 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 96"));

    PartSurface partSurface_165 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 65"));

    PartSurface partSurface_166 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 100"));

    PartSurface partSurface_167 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 99"));

    PartSurface partSurface_168 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 53"));

    PartSurface partSurface_169 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 55"));

    PartSurface partSurface_170 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 52"));

    PartSurface partSurface_171 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 50"));

    PartSurface partSurface_172 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 68"));

    PartSurface partSurface_173 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 61"));

    PartSurface partSurface_174 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 77"));

    PartSurface partSurface_175 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 74"));

    PartSurface partSurface_176 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 69"));

    PartSurface partSurface_177 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 86"));

    PartSurface partSurface_178 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 75"));

    PartSurface partSurface_179 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 76"));

    PartSurface partSurface_180 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 49"));

    PartSurface partSurface_181 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 73"));

    PartSurface partSurface_182 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 84"));

    PartSurface partSurface_183 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 64"));

    PartSurface partSurface_184 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 81"));

    PartSurface partSurface_185 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 56"));

    PartSurface partSurface_186 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 70"));

    PartSurface partSurface_187 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 63"));

    PartSurface partSurface_188 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 88"));

    PartSurface partSurface_189 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 54"));

    PartSurface partSurface_190 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 38"));

    PartSurface partSurface_191 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 72"));

    PartSurface partSurface_192 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 71"));

    PartSurface partSurface_193 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 92"));

    PartSurface partSurface_194 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 90"));

    PartSurface partSurface_195 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 102"));

    PartSurface partSurface_196 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 59"));

    PartSurface partSurface_197 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 79"));

    PartSurface partSurface_198 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 48"));

    PartSurface partSurface_199 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 78"));

    PartSurface partSurface_200 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 94"));

    PartSurface partSurface_201 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 97"));

    PartSurface partSurface_202 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 66"));

    meshPart_2.combinePartSurfaces(new NeoObjectVector(new Object[] {partSurface_102, partSurface_149, partSurface_150, partSurface_151, partSurface_152, partSurface_153, partSurface_154, partSurface_155, partSurface_156, partSurface_157, partSurface_158, partSurface_159, partSurface_160, partSurface_161, partSurface_162, partSurface_163, partSurface_164, partSurface_165, partSurface_166, partSurface_167, partSurface_168, partSurface_169, partSurface_170, partSurface_171, partSurface_172, partSurface_173, partSurface_174, partSurface_175, partSurface_176, partSurface_177, partSurface_178, partSurface_179, partSurface_180, partSurface_181, partSurface_182, partSurface_183, partSurface_184, partSurface_185, partSurface_186, partSurface_187, partSurface_188, partSurface_189, partSurface_190, partSurface_191, partSurface_192, partSurface_193, partSurface_194, partSurface_195, partSurface_196, partSurface_197, partSurface_198, partSurface_199, partSurface_200, partSurface_201, partSurface_202}));
  }

  private void driver2() {

    Simulation simulation_0 = 
      getActiveSimulation();

    SolidModelCompositePart solidModelCompositePart_1 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("z_000_remaining-parts"));

    CompositePart compositePart_2 = 
      ((CompositePart) solidModelCompositePart_1.getChildParts().getPart("C_P002_FAHRER_GERADEAUS"));

    MeshPart meshPart_2 = 
      ((MeshPart) compositePart_2.getChildParts().getPart("driver"));

    PartSurface partSurface_102 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface 9"));

    partSurface_102.setPresentationName("Surface");

    Scene scene_6 = 
      simulation_0.getSceneManager().getScene("3D-CAD Vehicle");

    CurrentView currentView_0 = 
      scene_6.getCurrentView();

    currentView_0.setInput(new DoubleVector(new double[] {0.5699257732242353, 0.11390425818799764, 0.5045680812711247}), new DoubleVector(new double[] {81.04591530419737, -51.984706684509, 40.77274260032111}), new DoubleVector(new double[] {-0.1996750637001407, 0.3872624496115017, 0.9000875868809919}), 0.7597651050641501, 1, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.4569671086368368, 0.178801613305344, 0.4406291045993407}), new DoubleVector(new double[] {76.48911513304444, -67.92283943831629, 21.469554229448445}), new DoubleVector(new double[] {-0.0339871114296591, 0.2600351040869305, 0.9650008398437665}), 0.7597651050641501, 1, 30.0);
  }

  private void ut() {

    Simulation simulation_0 = 
      getActiveSimulation();

    PartImportManager partImportManager_0 = 
      simulation_0.get(PartImportManager.class);

    partImportManager_0.importCadPart(resolvePath("a_u000_undertray_asm.stp"), "SharpEdges", 30.0, 5, true, 1.0E-5, true, false, false, false, true, NeoProperty.fromString("{\'NX\': 1, \'STEP\': 1, \'SE\': 1, \'CGR\': 1, \'SW\': 1, \'IFC\': 1, \'ACIS\': 1, \'JT\': 1, \'IGES\': 1, \'CATIAV5\': 1, \'CATIAV4\': 1, \'3DXML\': 1, \'CREO\': 1, \'INV\': 1}"), true, false);

    Scene scene_6 = 
      simulation_0.getSceneManager().getScene("3D-CAD Vehicle");

    CurrentView currentView_0 = 
      scene_6.getCurrentView();

    currentView_0.setInput(new DoubleVector(new double[] {0.692274958825619, 0.09772187294728885, 0.5044627335190669}), new DoubleVector(new double[] {76.55112539926938, -67.84869733942772, 21.485457318298163}), new DoubleVector(new double[] {-0.0339871114296591, 0.2600351040869305, 0.9650008398437665}), 0.8521652730685438, 1, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.8892002545193836, 0.010368589933261951, 0.3909168198031888}), new DoubleVector(new double[] {76.61830450790158, -67.81983756666634, 21.33602628330337}), new DoubleVector(new double[] {-0.0339871114296591, 0.2600351040869305, 0.9650008398437665}), 0.8521652730685438, 1, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.9322914963526668, -0.0325538388583112, 0.41381584477717404}), new DoubleVector(new double[] {62.02245534406754, -67.6680615740038, 50.10021260644882}), new DoubleVector(new double[] {-0.21799737086716958, 0.44222460201748526, 0.8700083606871184}), 0.8521652730685438, 1, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.7112952121128604, -0.9752272157475279, 0.8092305375877987}), new DoubleVector(new double[] {45.674504875268156, -78.86869116762739, -50.20343194354248}), new DoubleVector(new double[] {0.36056729510333224, -0.36001015183513496, 0.8604556445729931}), 0.8521652730685438, 1, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.1846817882311906, -0.5997484662714463, -0.09239656341747193}), new DoubleVector(new double[] {45.174448048276176, -78.5402650637239, -51.135873962843235}), new DoubleVector(new double[] {0.36056729510333224, -0.36001015183513496, 0.8604556445729931}), 0.8521652730685438, 1, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.3327569681032063, -0.188606743460646, 0.04766313912282172}), new DoubleVector(new double[] {45.45794929284431, -78.36906954523656, -51.1529557470693}), new DoubleVector(new double[] {0.36056729510333224, -0.36001015183513496, 0.8604556445729931}), 0.07552721845844172, 1, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.328544943317351, -0.1787236703811701, 0.053563181798932845}), new DoubleVector(new double[] {26.75450475567691, -88.34858369384605, -47.49079835188846}), new DoubleVector(new double[] {0.3605672951033332, -0.36001015183515217, 0.8604556445729876}), 0.07552721845844172, 1, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.3580346538369188, -0.1737036695521077, 0.05090835055852416}), new DoubleVector(new double[] {26.782962718889422, -88.33998589236309, -47.49152390426034}), new DoubleVector(new double[] {0.3605672951033332, -0.36001015183515217, 0.8604556445729876}), 0.04013826403826558, 1, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.0404769293179057, -0.2564867831659967, 0.03959715984682788}), new DoubleVector(new double[] {26.465970249931857, -88.42472914844933, -47.50389207433369}), new DoubleVector(new double[] {0.3605672951033332, -0.36001015183515217, 0.8604556445729876}), 0.35940925465187107, 1, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.0625053650937677, -0.3103773227483273, 0.006320368503954288}), new DoubleVector(new double[] {43.00650159668732, -77.50897635612897, -54.41523500846108}), new DoubleVector(new double[] {0.37303175494821855, -0.3906057615829537, 0.8415904281884852}), 0.35940925465187107, 1, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.3481399832571341, -0.1778534397742133, 0.03503122841502382}), new DoubleVector(new double[] {43.29139984415801, -77.37509717106272, -54.3855687212653}), new DoubleVector(new double[] {0.37303175494821855, -0.3906057615829537, 0.8415904281884852}), 0.05993960491130062, 1, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.3450926607018754, -0.17157281759505819, 0.03924312265041123}), new DoubleVector(new double[] {31.672823616482844, -85.07717392781086, -50.480282180649134}), new DoubleVector(new double[] {0.36636427278820183, -0.3756507413594174, 0.8512718368068569}), 0.05993960491130062, 1, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.237286684178986, -0.19203964294845832, 0.0032637376943922547}), new DoubleVector(new double[] {31.564205852504177, -85.09536807071379, -50.514909301007066}), new DoubleVector(new double[] {0.36636427278820183, -0.3756507413594174, 0.8512718368068569}), 0.27542076422223677, 1, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.120170558466822, -0.20747059764325115, -0.029564230420970006}), new DoubleVector(new double[] {31.44874578663662, -85.11543533521976, -50.550495911282155}), new DoubleVector(new double[] {0.36636427278820183, -0.3756507413594174, 0.8512718368068569}), 0.4879241962650215, 1, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.9401596898133255, -0.5201622109510087, -0.4191438387061748}), new DoubleVector(new double[] {31.15296794765721, -85.10402541193179, -50.74723246133812}), new DoubleVector(new double[] {0.36636427278820183, -0.3756507413594174, 0.8512718368068569}), 0.9508193334597498, 1, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.3033627817642275, -1.0190596220650447, -0.5545472671789127}), new DoubleVector(new double[] {81.75666534364008, -63.821881093572976, 12.710205934048961}), new DoubleVector(new double[] {-0.036773056631623384, 0.16119775611704876, 0.9862368000276727}), 0.9508193334597498, 1, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.394831709103399, -0.6110653066091145, 0.13524234935049181}), new DoubleVector(new double[] {81.91735790424794, -63.46792358385835, 13.411408809969371}), new DoubleVector(new double[] {-0.036773056631623384, 0.16119775611704876, 0.9862368000276727}), 0.9508193334597498, 1, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.5100090936507633, -0.7003650239950616, 0.1526579491529542}), new DoubleVector(new double[] {72.21965254366265, -65.65326797229227, 37.02498164783175}), new DoubleVector(new double[] {-0.20577100063073092, 0.3040307696558067, 0.9301739549148615}), 0.9508193334597498, 1, 30.0);

    currentView_0.setInput(new DoubleVector(new double[] {1.6787954018479292, -0.8877164373011391, 0.2554093703420696}), new DoubleVector(new double[] {57.95639924608248, -76.8896021985282, 40.68864102686792}), new DoubleVector(new double[] {-0.22345733793717146, 0.3236624570176146, 0.919407108978054}), 0.9508193334597498, 1, 30.0);

    SolidModelCompositePart solidModelCompositePart_0 = 
      ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("C_UNDERTRAY"));

    CompositePart compositePart_0 = 
      ((CompositePart) solidModelCompositePart_0.getChildParts().getPart("A_U000_UNDERTRAY_ASM"));

    CompositePart compositePart_1 = 
      ((CompositePart) compositePart_0.getChildParts().getPart("A_US00_SIDEPOD"));

    CompositePart compositePart_2 = 
      ((CompositePart) compositePart_0.getChildParts().getPart("A_US00_SIDEPOD_MIR"));

    CompositePart compositePart_3 = 
      ((CompositePart) compositePart_0.getChildParts().getPart("A_US00_SIDEWINGS_MIR"));

    CompositePart compositePart_4 = 
      ((CompositePart) compositePart_0.getChildParts().getPart("A_US00_SIDEWINGS"));

    compositePart_0.getChildParts().removeObjects(compositePart_1, compositePart_2, compositePart_3, compositePart_4);

    CompositePart compositePart_6 = 
      ((CompositePart) simulation_0.get(SimulationPartManager.class).getPart("A_U000_UNDERTRAY_ASM"));

    CompositePart compositePart_5 = 
      ((CompositePart) compositePart_6.getChildParts().getPart("A_US00_SIDEPOD"));

    CompositePart compositePart_7 = 
      ((CompositePart) compositePart_6.getChildParts().getPart("A_US00_SIDEWINGS"));

    CompositePart compositePart_8 = 
      ((CompositePart) compositePart_6.getChildParts().getPart("A_US00_SIDEPOD_MIR"));

    CompositePart compositePart_9 = 
      ((CompositePart) compositePart_6.getChildParts().getPart("A_US00_SIDEWINGS_MIR"));

    compositePart_0.getChildParts().reparentParts(Arrays.<GeometryPart>asList(compositePart_5, compositePart_7, compositePart_8, compositePart_9), compositePart_0.getChildParts());

    simulation_0.get(SimulationPartManager.class).removeObjects(compositePart_6);
  }
    private void ops() {

    Simulation simulation_0 = 
      getActiveSimulation();

    TransformPartsOperation transformPartsOperation_0 = 
      (TransformPartsOperation) simulation_0.get(MeshOperationManager.class).createTransformPartsOperation(new NeoObjectVector(new Object[] {}));

    transformPartsOperation_0.setPresentationName("VehicleState");

    UserTag userTag_0 = 
      ((UserTag) simulation_0.get(TagManager.class).getObject("Wrapper"));

    transformPartsOperation_0.getInputGeometryObjects().setQuery(new Query(new CompoundPredicate(CompoundOperator.And, Arrays.<QueryPredicate>asList(new TagPredicate(TagOperator.Contains, userTag_0), new NamePredicate(NameOperator.DoesNotContain, "t_open"), new NamePredicate(NameOperator.DoesNotStartWith, "W_"))), Query.STANDARD_MODIFIERS));

    RotationControl rotationControl_0 = 
      transformPartsOperation_0.getTransforms().createRotationControl();

    rotationControl_0.setPresentationName("Pitch");

    Units units_0 = 
      ((Units) simulation_0.getUnitsManager().getObject("mm"));

    rotationControl_0.getAxisVector().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 1.0, 0.0}));

    Units units_1 = 
      simulation_0.getUnitsManager().getInternalUnits(new IntVector(new int[] {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    rotationControl_0.getAngle().setDefinition("${RideHeigthPitch}");

    RotationControl rotationControl_1 = 
      transformPartsOperation_0.getTransforms().createRotationControl();

    rotationControl_1.setPresentationName("Roll");

    LabCoordinateSystem labCoordinateSystem_0 = 
      simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

    CartesianCoordinateSystem cartesianCoordinateSystem_0 = 
      ((CartesianCoordinateSystem) labCoordinateSystem_0.getLocalCoordinateSystemManager().getObject("CoRoll0"));

    rotationControl_1.setCoordinateSystem(cartesianCoordinateSystem_0);

    rotationControl_1.getAngle().setDefinition("${rollAngleDeg}/360*2*3.1416");

    TranslationControl translationControl_0 = 
      transformPartsOperation_0.getTransforms().createTranslationControl();

    Units units_2 = 
      simulation_0.getUnitsManager().getInternalUnits(new IntVector(new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    translationControl_0.getTranslationVector().setDefinition("[0.0, 0.0, ${RRH}-35]/1000");

    TransformPartsOperation transformPartsOperation_1 = 
      (TransformPartsOperation) simulation_0.get(MeshOperationManager.class).createTransformPartsOperation(new NeoObjectVector(new Object[] {}));

    transformPartsOperation_1.setPresentationName("Yaw");

    transformPartsOperation_1.setCreateNewOutputParts(true);

    transformPartsOperation_1.getInputGeometryObjects().setQuery(new Query(new NamePredicate(NameOperator.Contains, "t_open"), Query.STANDARD_MODIFIERS));

    RotationControl rotationControl_2 = 
      transformPartsOperation_1.getTransforms().createRotationControl();

    rotationControl_2.getAxisVector().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 0.0, 1.0}));

    rotationControl_2.getAngle().setDefinition("${Yaw}/360*2*3.1416");

    simulation_0.get(MeshOperationManager.class).createCopyOfMeshOperation("star.surfacewrapper.SurfaceWrapperAutoMeshOperation", "Z_Wrapper copy");

    SurfaceWrapperAutoMeshOperation surfaceWrapperAutoMeshOperation_0 = 
      ((SurfaceWrapperAutoMeshOperation) simulation_0.get(MeshOperationManager.class).getObject("Z_Wrapper copy"));

    SurfaceWrapperAutoMeshOperation surfaceWrapperAutoMeshOperation_1 = 
      ((SurfaceWrapperAutoMeshOperation) simulation_0.get(MeshOperationManager.class).getObject("Z_Wrapper"));

    surfaceWrapperAutoMeshOperation_0.copyProperties(surfaceWrapperAutoMeshOperation_1);

    simulation_0.get(MeshOperationManager.class).createCopyOfMeshOperation("star.meshing.SubtractPartsOperation", "A_Air copy");

    SubtractPartsOperation subtractPartsOperation_0 = 
      ((SubtractPartsOperation) simulation_0.get(MeshOperationManager.class).getObject("A_Air copy"));

    SubtractPartsOperation subtractPartsOperation_1 = 
      ((SubtractPartsOperation) simulation_0.get(MeshOperationManager.class).getObject("A_Air"));

    subtractPartsOperation_0.copyProperties(subtractPartsOperation_1);

    simulation_0.get(MeshOperationManager.class).createCopyOfMeshOperation("star.meshing.IntersectPartsOperation", "A_MRF-FR copy");

    IntersectPartsOperation intersectPartsOperation_0 = 
      ((IntersectPartsOperation) simulation_0.get(MeshOperationManager.class).getObject("A_MRF-FR copy"));

    IntersectPartsOperation intersectPartsOperation_1 = 
      ((IntersectPartsOperation) simulation_0.get(MeshOperationManager.class).getObject("A_MRF-FR"));

    intersectPartsOperation_0.copyProperties(intersectPartsOperation_1);

    simulation_0.get(MeshOperationManager.class).createCopyOfMeshOperation("star.meshing.IntersectPartsOperation", "A_MRF-RR copy");

    IntersectPartsOperation intersectPartsOperation_2 = 
      ((IntersectPartsOperation) simulation_0.get(MeshOperationManager.class).getObject("A_MRF-RR copy"));

    IntersectPartsOperation intersectPartsOperation_3 = 
      ((IntersectPartsOperation) simulation_0.get(MeshOperationManager.class).getObject("A_MRF-RR"));

    intersectPartsOperation_2.copyProperties(intersectPartsOperation_3);

    simulation_0.get(MeshOperationManager.class).createCopyOfMeshOperation("star.meshing.IntersectPartsOperation", "A_MRF-FL copy");

    IntersectPartsOperation intersectPartsOperation_4 = 
      ((IntersectPartsOperation) simulation_0.get(MeshOperationManager.class).getObject("A_MRF-FL copy"));

    IntersectPartsOperation intersectPartsOperation_5 = 
      ((IntersectPartsOperation) simulation_0.get(MeshOperationManager.class).getObject("A_MRF-FL"));

    intersectPartsOperation_4.copyProperties(intersectPartsOperation_5);

    simulation_0.get(MeshOperationManager.class).createCopyOfMeshOperation("star.meshing.IntersectPartsOperation", "A_MRF-RL copy");

    IntersectPartsOperation intersectPartsOperation_6 = 
      ((IntersectPartsOperation) simulation_0.get(MeshOperationManager.class).getObject("A_MRF-RL copy"));

    IntersectPartsOperation intersectPartsOperation_7 = 
      ((IntersectPartsOperation) simulation_0.get(MeshOperationManager.class).getObject("A_MRF-RL"));

    intersectPartsOperation_6.copyProperties(intersectPartsOperation_7);

    simulation_0.get(MeshOperationManager.class).createCopyOfMeshOperation("star.surfacetools.OffsetPartsOperation", "Y_small copy");

    OffsetPartsOperation offsetPartsOperation_0 = 
      ((OffsetPartsOperation) simulation_0.get(MeshOperationManager.class).getObject("Y_small copy"));

    OffsetPartsOperation offsetPartsOperation_1 = 
      ((OffsetPartsOperation) simulation_0.get(MeshOperationManager.class).getObject("Y_small"));

    offsetPartsOperation_0.copyProperties(offsetPartsOperation_1);

    simulation_0.get(MeshOperationManager.class).createCopyOfMeshOperation("star.meshing.AutoMeshOperation", "mesh mrf copy");

    AutoMeshOperation autoMeshOperation_0 = 
      ((AutoMeshOperation) simulation_0.get(MeshOperationManager.class).getObject("mesh mrf copy"));

    AutoMeshOperation autoMeshOperation_1 = 
      ((AutoMeshOperation) simulation_0.get(MeshOperationManager.class).getObject("mesh mrf"));

    autoMeshOperation_0.copyProperties(autoMeshOperation_1);

    simulation_0.get(MeshOperationManager.class).createCopyOfMeshOperation("star.meshing.ContactOperation", "Weak Contact Creator copy");

    ContactOperation contactOperation_0 = 
      ((ContactOperation) simulation_0.get(MeshOperationManager.class).getObject("Weak Contact Creator copy"));

    ContactOperation contactOperation_1 = 
      ((ContactOperation) simulation_0.get(MeshOperationManager.class).getObject("Weak Contact Creator"));

    contactOperation_0.copyProperties(contactOperation_1);

    simulation_0.get(MeshOperationManager.class).createCopyOfMeshOperation("star.meshing.AutoMeshOperation", "air copy");

    AutoMeshOperation autoMeshOperation_2 = 
      ((AutoMeshOperation) simulation_0.get(MeshOperationManager.class).getObject("air copy"));

    AutoMeshOperation autoMeshOperation_3 = 
      ((AutoMeshOperation) simulation_0.get(MeshOperationManager.class).getObject("air"));

    autoMeshOperation_2.copyProperties(autoMeshOperation_3);

    simulation_0.get(MeshOperationManager.class).removeObjects(surfaceWrapperAutoMeshOperation_1, autoMeshOperation_3, offsetPartsOperation_1, intersectPartsOperation_3, contactOperation_1, autoMeshOperation_1, subtractPartsOperation_1, intersectPartsOperation_1, intersectPartsOperation_5, intersectPartsOperation_7);

    SimpleBlockPart simpleBlockPart_0 = 
      ((SimpleBlockPart) simulation_0.get(SimulationPartManager.class).getPart("t_open-road-tunnel"));

    simulation_0.get(TagManager.class).setTags(simpleBlockPart_0, new NeoObjectVector(new Object[] {}));

    MeshOperationPart meshOperationPart_0 = 
      ((MeshOperationPart) simulation_0.get(SimulationPartManager.class).getPart("t_open-road-tunnel_Yaw"));

    simulation_0.get(TagManager.class).setTags(meshOperationPart_0, new NeoObjectVector(new Object[] {userTag_0}));

    surfaceWrapperAutoMeshOperation_0.setPresentationName("Z_Wrapper ");

    subtractPartsOperation_0.setPresentationName("A_Air");

    subtractPartsOperation_0.getInputGeometryObjects().setQuery(null);

    SimpleCylinderPart simpleCylinderPart_0 = 
      ((SimpleCylinderPart) simulation_0.get(SimulationPartManager.class).getPart("z_MRF-Front-Left"));

    SimpleCylinderPart simpleCylinderPart_1 = 
      ((SimpleCylinderPart) simulation_0.get(SimulationPartManager.class).getPart("z_MRF-Front-Right"));

    SimpleCylinderPart simpleCylinderPart_2 = 
      ((SimpleCylinderPart) simulation_0.get(SimulationPartManager.class).getPart("z_MRF-Rear-Left"));

    SimpleCylinderPart simpleCylinderPart_3 = 
      ((SimpleCylinderPart) simulation_0.get(SimulationPartManager.class).getPart("z_MRF-Rear-Right"));

    MeshOperationPart meshOperationPart_1 = 
      ((MeshOperationPart) simulation_0.get(SimulationPartManager.class).getPart("Z_Wrapper"));

    subtractPartsOperation_0.getInputGeometryObjects().setObjects(simpleCylinderPart_0, simpleCylinderPart_1, simpleCylinderPart_2, simpleCylinderPart_3, meshOperationPart_1);

    subtractPartsOperation_0.getTargetPartManager().setQuery(null);

    subtractPartsOperation_0.getTargetPartManager().setObjects(meshOperationPart_1);

    intersectPartsOperation_0.setPresentationName("A_MRF-FR");

    intersectPartsOperation_0.getInputGeometryObjects().setQuery(null);

    intersectPartsOperation_0.getInputGeometryObjects().setObjects(simpleCylinderPart_1, meshOperationPart_1);

    intersectPartsOperation_2.setPresentationName("A_MRF-RR");

    intersectPartsOperation_2.getInputGeometryObjects().setQuery(null);

    intersectPartsOperation_2.getInputGeometryObjects().setObjects(simpleCylinderPart_3, meshOperationPart_1);

    intersectPartsOperation_4.setPresentationName("A_MRF-FL");

    intersectPartsOperation_4.getInputGeometryObjects().setQuery(null);

    intersectPartsOperation_4.getInputGeometryObjects().setObjects(simpleCylinderPart_0, meshOperationPart_1);

    intersectPartsOperation_6.setPresentationName("A_MRF-RL ");

    intersectPartsOperation_6.getInputGeometryObjects().setQuery(null);

    intersectPartsOperation_6.getInputGeometryObjects().setObjects(simpleCylinderPart_2, meshOperationPart_1);

    offsetPartsOperation_0.setPresentationName("Y_small");

    autoMeshOperation_0.setPresentationName("mesh mrf");

    autoMeshOperation_0.getInputGeometryObjects().setQuery(null);

    MeshOperationPart meshOperationPart_2 = 
      ((MeshOperationPart) simulation_0.get(SimulationPartManager.class).getPart("A_MRF-FL"));

    MeshOperationPart meshOperationPart_3 = 
      ((MeshOperationPart) simulation_0.get(SimulationPartManager.class).getPart("A_MRF-FR"));

    MeshOperationPart meshOperationPart_4 = 
      ((MeshOperationPart) simulation_0.get(SimulationPartManager.class).getPart("A_MRF-RL"));

    MeshOperationPart meshOperationPart_5 = 
      ((MeshOperationPart) simulation_0.get(SimulationPartManager.class).getPart("A_MRF-RR"));

    autoMeshOperation_0.getInputGeometryObjects().setObjects(meshOperationPart_2, meshOperationPart_3, meshOperationPart_4, meshOperationPart_5);

    contactOperation_0.setPresentationName("Weak Contact Creator");

    contactOperation_0.getInputGeometryObjects().setQuery(null);

    MeshOperationPart meshOperationPart_6 = 
      ((MeshOperationPart) simulation_0.get(SimulationPartManager.class).getPart("A_Air"));

    contactOperation_0.getInputGeometryObjects().setObjects(meshOperationPart_6, meshOperationPart_2, meshOperationPart_3, meshOperationPart_4, meshOperationPart_5);

    autoMeshOperation_2.setPresentationName("air");

    autoMeshOperation_2.getInputGeometryObjects().setQuery(null);

    autoMeshOperation_2.getInputGeometryObjects().setObjects(meshOperationPart_6);

    SurfaceCustomMeshControl surfaceCustomMeshControl_0 = 
      ((SurfaceCustomMeshControl) autoMeshOperation_2.getCustomMeshControls().getObject("floor"));

    surfaceCustomMeshControl_0.getGeometryObjects().setQuery(null);

    PartSurface partSurface_0 = 
      ((PartSurface) meshOperationPart_6.getPartSurfaceManager().getPartSurface("Z_Wrapper.t_open-road-tunnel_Yaw.t_open-road-tunnel.floor"));

    surfaceCustomMeshControl_0.getGeometryObjects().setObjects(partSurface_0);

    SurfaceCustomMeshControl surfaceCustomMeshControl_1 = 
      ((SurfaceCustomMeshControl) autoMeshOperation_2.getCustomMeshControls().getObject("walls"));

    surfaceCustomMeshControl_1.getGeometryObjects().setQuery(null);

    PartSurface partSurface_1 = 
      ((PartSurface) meshOperationPart_6.getPartSurfaceManager().getPartSurface("Z_Wrapper.t_open-road-tunnel_Yaw.t_open-road-tunnel.inlet"));

    PartSurface partSurface_2 = 
      ((PartSurface) meshOperationPart_6.getPartSurfaceManager().getPartSurface("Z_Wrapper.t_open-road-tunnel_Yaw.t_open-road-tunnel.outlet"));

    PartSurface partSurface_3 = 
      ((PartSurface) meshOperationPart_6.getPartSurfaceManager().getPartSurface("Z_Wrapper.t_open-road-tunnel_Yaw.t_open-road-tunnel.top"));

    PartSurface partSurface_4 = 
      ((PartSurface) meshOperationPart_6.getPartSurfaceManager().getPartSurface("Z_Wrapper.t_open-road-tunnel_Yaw.t_open-road-tunnel.wall-left"));

    PartSurface partSurface_5 = 
      ((PartSurface) meshOperationPart_6.getPartSurfaceManager().getPartSurface("Z_Wrapper.t_open-road-tunnel_Yaw.t_open-road-tunnel.wall-right"));

    surfaceCustomMeshControl_1.getGeometryObjects().setObjects(partSurface_1, partSurface_2, partSurface_3, partSurface_4, partSurface_5);

    VolumeCustomMeshControl volumeCustomMeshControl_0 = 
      ((VolumeCustomMeshControl) autoMeshOperation_2.getCustomMeshControls().getObject("Y-Small"));

    volumeCustomMeshControl_0.getGeometryObjects().setQuery(null);

    MeshOperationPart meshOperationPart_7 = 
      ((MeshOperationPart) simulation_0.get(SimulationPartManager.class).getPart("Y_small"));

    volumeCustomMeshControl_0.getGeometryObjects().setObjects(meshOperationPart_7);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Air");

    region_0.getPartGroup().setQuery(null);

    region_0.getPartGroup().setObjects(meshOperationPart_6);

    Region region_1 = 
      simulation_0.getRegionManager().getRegion("MRF-FL");

    region_1.getPartGroup().setQuery(null);

    region_1.getPartGroup().setObjects(meshOperationPart_2);

    Region region_3 = 
      simulation_0.getRegionManager().getRegion("MRF-FR");

    region_3.getPartGroup().setQuery(null);

    region_3.getPartGroup().setObjects(meshOperationPart_3);

    Region region_2 = 
      simulation_0.getRegionManager().getRegion("MRF-RL");

    region_2.getPartGroup().setQuery(null);

    region_2.getPartGroup().setObjects(meshOperationPart_4);

    Region region_4 = 
      simulation_0.getRegionManager().getRegion("MRF-RR");

    region_4.getPartGroup().setQuery(null);

    region_4.getPartGroup().setObjects(meshOperationPart_5);
  }
  private void props() {

    Simulation simulation_0 = 
      getActiveSimulation();

    PhysicsContinuum physicsContinuum_0 = 
      ((PhysicsContinuum) simulation_0.getContinuumManager().getContinuum("k-epsilon Lag EB"));

    SingleComponentGasModel singleComponentGasModel_0 = 
      physicsContinuum_0.getModelManager().getModel(SingleComponentGasModel.class);

    Gas gas_0 = 
      ((Gas) singleComponentGasModel_0.getMaterial());

    ConstantMaterialPropertyMethod constantMaterialPropertyMethod_0 = 
      ((ConstantMaterialPropertyMethod) gas_0.getMaterialProperties().getMaterialProperty(ConstantDensityProperty.class).getMethod());

    Units units_0 = 
      ((Units) simulation_0.getUnitsManager().getObject("kg/m^3"));

    constantMaterialPropertyMethod_0.getQuantity().setValueAndUnits(1.154, units_0);

    ConstantMaterialPropertyMethod constantMaterialPropertyMethod_1 = 
      ((ConstantMaterialPropertyMethod) gas_0.getMaterialProperties().getMaterialProperty(DynamicViscosityProperty.class).getMethod());

    Units units_1 = 
      ((Units) simulation_0.getUnitsManager().getObject("Pa-s"));

    constantMaterialPropertyMethod_1.getQuantity().setValueAndUnits(1.716E-5, units_1);

    Units units_2 = 
      ((Units) simulation_0.getUnitsManager().getObject("Pa"));

    physicsContinuum_0.getReferenceValues().get(ReferencePressure.class).setValueAndUnits(94790.0, units_2);

    PhysicsContinuum physicsContinuum_1 = 
      ((PhysicsContinuum) simulation_0.getContinuumManager().getContinuum("LES"));

    SingleComponentGasModel singleComponentGasModel_1 = 
      physicsContinuum_1.getModelManager().getModel(SingleComponentGasModel.class);

    Gas gas_1 = 
      ((Gas) singleComponentGasModel_1.getMaterial());

    ConstantMaterialPropertyMethod constantMaterialPropertyMethod_2 = 
      ((ConstantMaterialPropertyMethod) gas_1.getMaterialProperties().getMaterialProperty(ConstantDensityProperty.class).getMethod());

    constantMaterialPropertyMethod_2.getQuantity().setValueAndUnits(1.154, units_0);

    ConstantMaterialPropertyMethod constantMaterialPropertyMethod_3 = 
      ((ConstantMaterialPropertyMethod) gas_1.getMaterialProperties().getMaterialProperty(DynamicViscosityProperty.class).getMethod());

    constantMaterialPropertyMethod_3.getQuantity().setValueAndUnits(1.716E-5, units_1);

    physicsContinuum_1.getReferenceValues().get(ReferencePressure.class).setValueAndUnits(94790.0, units_2);

    ScalarGlobalParameter scalarGlobalParameter_0 = 
      ((ScalarGlobalParameter) simulation_0.get(GlobalParameterManager.class).getObject("u_inlet"));

    Units units_3 = 
      ((Units) simulation_0.getUnitsManager().getObject("m/s"));

    scalarGlobalParameter_0.getQuantity().setValueAndUnits(16.477, units_3);
  }

  private void yawch() {

    Simulation simulation_0 = 
      getActiveSimulation();

    ScalarGlobalParameter scalarGlobalParameter_0 = 
      ((ScalarGlobalParameter) simulation_0.get(GlobalParameterManager.class).getObject("air_density"));

    Units units_0 = 
      ((Units) simulation_0.getUnitsManager().getObject("kg/m^3"));

    scalarGlobalParameter_0.getQuantity().setValueAndUnits(1.154, units_0);

    ForceReport forceReport_0 = 
      simulation_0.getReportManager().create("star.flow.ForceReport");

    ForceReport forceReport_1 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Drag"));

    forceReport_0.copyProperties(forceReport_1);

    forceReport_0.setPresentationName("Drag copy");

    simulation_0.getReportManager().getGroupsManager().groupObjects("", Arrays.<ClientServerObject>asList(forceReport_0));

    ForceReport forceReport_2 = 
      simulation_0.getReportManager().create("star.flow.ForceReport");

    ForceReport forceReport_3 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Fd Frontwing"));

    forceReport_2.copyProperties(forceReport_3);

    forceReport_2.setPresentationName("Fd Frontwing copy");

    simulation_0.getReportManager().getGroupsManager().groupObjects("", Arrays.<ClientServerObject>asList(forceReport_2));

    ForceReport forceReport_4 = 
      simulation_0.getReportManager().create("star.flow.ForceReport");

    ForceReport forceReport_5 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Fd Rearwing"));

    forceReport_4.copyProperties(forceReport_5);

    forceReport_4.setPresentationName("Fd Rearwing copy");

    simulation_0.getReportManager().getGroupsManager().groupObjects("", Arrays.<ClientServerObject>asList(forceReport_4));

    ForceReport forceReport_6 = 
      simulation_0.getReportManager().create("star.flow.ForceReport");

    ForceReport forceReport_7 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Fd Undertray"));

    forceReport_6.copyProperties(forceReport_7);

    forceReport_6.setPresentationName("Fd Undertray copy");

    simulation_0.getReportManager().getGroupsManager().groupObjects("", Arrays.<ClientServerObject>asList(forceReport_6));

    ForceReport forceReport_8 = 
      simulation_0.getReportManager().create("star.flow.ForceReport");

    ForceReport forceReport_9 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Fd Mono"));

    forceReport_8.copyProperties(forceReport_9);

    forceReport_8.setPresentationName("Fd Mono copy");

    simulation_0.getReportManager().getGroupsManager().groupObjects("", Arrays.<ClientServerObject>asList(forceReport_8));

    ForceReport forceReport_10 = 
      simulation_0.getReportManager().create("star.flow.ForceReport");

    ForceReport forceReport_11 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Fd Remaining"));

    forceReport_10.copyProperties(forceReport_11);

    forceReport_10.setPresentationName("Fd Remaining copy");

    simulation_0.getReportManager().getGroupsManager().groupObjects("", Arrays.<ClientServerObject>asList(forceReport_10));

    simulation_0.getReportManager().getGroupsManager().createGroup("New Group");

    ((ClientServerObjectGroup) simulation_0.getReportManager().getGroupsManager().getObject("New Group")).setPresentationName("Side");

    ((ClientServerObjectGroup) simulation_0.getReportManager().getGroupsManager().getObject("Side")).getGroupsManager().groupObjects("Side", Arrays.<ClientServerObject>asList(forceReport_0, forceReport_2, forceReport_8, forceReport_10, forceReport_4, forceReport_6));

    forceReport_0.setPresentationName("Side force");

    Units units_1 = 
      ((Units) simulation_0.getUnitsManager().getObject(""));

    forceReport_0.getDirection().setComponentsAndUnits(0.0, 1.0, 0.0, units_1);

    forceReport_2.setPresentationName("Fs Frontwing");

    forceReport_2.getDirection().setComponentsAndUnits(0.0, 1.0, 0.0, units_1);

    forceReport_8.setPresentationName("Fs Mono");

    forceReport_8.getDirection().setComponentsAndUnits(0.0, 1.0, 0.0, units_1);

    forceReport_4.setPresentationName("Fs Rearwing");

    forceReport_4.getDirection().setComponentsAndUnits(0.0, 1.0, 0.0, units_1);

    forceReport_10.setPresentationName("Fs Remaining");

    forceReport_10.getDirection().setComponentsAndUnits(0.0, 1.0, 0.0, units_1);

    forceReport_6.setPresentationName("Fs Undertray");

    forceReport_6.getDirection().setComponentsAndUnits(0.0, 1.0, 0.0, units_1);

    ForceCoefficientReport forceCoefficientReport_0 = 
      simulation_0.getReportManager().create("star.flow.ForceCoefficientReport");

    ForceCoefficientReport forceCoefficientReport_1 = 
      ((ForceCoefficientReport) simulation_0.getReportManager().getReport("CX"));

    forceCoefficientReport_0.copyProperties(forceCoefficientReport_1);

    forceCoefficientReport_0.setPresentationName("CX copy");

    simulation_0.getReportManager().getGroupsManager().groupObjects("", Arrays.<ClientServerObject>asList(forceCoefficientReport_0));

    ForceCoefficientReport forceCoefficientReport_2 = 
      simulation_0.getReportManager().create("star.flow.ForceCoefficientReport");

    ForceCoefficientReport forceCoefficientReport_3 = 
      ((ForceCoefficientReport) simulation_0.getReportManager().getReport("CX Rearwing"));

    forceCoefficientReport_2.copyProperties(forceCoefficientReport_3);

    forceCoefficientReport_2.setPresentationName("CX Rearwing copy");

    simulation_0.getReportManager().getGroupsManager().groupObjects("", Arrays.<ClientServerObject>asList(forceCoefficientReport_2));

    ForceCoefficientReport forceCoefficientReport_4 = 
      simulation_0.getReportManager().create("star.flow.ForceCoefficientReport");

    ForceCoefficientReport forceCoefficientReport_5 = 
      ((ForceCoefficientReport) simulation_0.getReportManager().getReport("CX Mono"));

    forceCoefficientReport_4.copyProperties(forceCoefficientReport_5);

    forceCoefficientReport_4.setPresentationName("CX Mono copy");

    simulation_0.getReportManager().getGroupsManager().groupObjects("", Arrays.<ClientServerObject>asList(forceCoefficientReport_4));

    ForceCoefficientReport forceCoefficientReport_6 = 
      simulation_0.getReportManager().create("star.flow.ForceCoefficientReport");

    ForceCoefficientReport forceCoefficientReport_7 = 
      ((ForceCoefficientReport) simulation_0.getReportManager().getReport("CX Remaining"));

    forceCoefficientReport_6.copyProperties(forceCoefficientReport_7);

    forceCoefficientReport_6.setPresentationName("CX Remaining copy");

    simulation_0.getReportManager().getGroupsManager().groupObjects("", Arrays.<ClientServerObject>asList(forceCoefficientReport_6));

    ForceCoefficientReport forceCoefficientReport_8 = 
      simulation_0.getReportManager().create("star.flow.ForceCoefficientReport");

    ForceCoefficientReport forceCoefficientReport_9 = 
      ((ForceCoefficientReport) simulation_0.getReportManager().getReport("CX Undertray"));

    forceCoefficientReport_8.copyProperties(forceCoefficientReport_9);

    forceCoefficientReport_8.setPresentationName("CX Undertray copy");

    simulation_0.getReportManager().getGroupsManager().groupObjects("", Arrays.<ClientServerObject>asList(forceCoefficientReport_8));

    ForceCoefficientReport forceCoefficientReport_10 = 
      simulation_0.getReportManager().create("star.flow.ForceCoefficientReport");

    ForceCoefficientReport forceCoefficientReport_11 = 
      ((ForceCoefficientReport) simulation_0.getReportManager().getReport("CX Frontwing"));

    forceCoefficientReport_10.copyProperties(forceCoefficientReport_11);

    forceCoefficientReport_10.setPresentationName("CX Frontwing copy");

    simulation_0.getReportManager().getGroupsManager().groupObjects("", Arrays.<ClientServerObject>asList(forceCoefficientReport_10));

    forceCoefficientReport_0.setPresentationName("CS");

    forceCoefficientReport_0.getDirection().setComponentsAndUnits(0.0, 1.0, 0.0, units_1);

    forceCoefficientReport_10.setPresentationName("CS Frontwing");

    forceCoefficientReport_10.getDirection().setComponentsAndUnits(0.0, 1.0, 0.0, units_1);

    forceCoefficientReport_4.setPresentationName("CS Mono");

    forceCoefficientReport_4.getDirection().setComponentsAndUnits(0.0, 1.0, 0.0, units_1);

    forceCoefficientReport_2.setPresentationName("CS Rearwing");

    forceCoefficientReport_2.getDirection().setComponentsAndUnits(0.0, 1.0, 0.0, units_1);

    forceCoefficientReport_6.setPresentationName("CS Remaining");

    forceCoefficientReport_6.getDirection().setComponentsAndUnits(0.0, 1.0, 0.0, units_1);

    forceCoefficientReport_8.setPresentationName("CS Undertray");

    forceCoefficientReport_8.getDirection().setComponentsAndUnits(0.0, 1.0, 0.0, units_1);

    ((ClientServerObjectGroup) simulation_0.getReportManager().getGroupsManager().getObject("Coefficients")).getGroupsManager().groupObjects("Coefficients", Arrays.<ClientServerObject>asList(forceCoefficientReport_8, forceCoefficientReport_4, forceCoefficientReport_10, forceCoefficientReport_0, forceCoefficientReport_2, forceCoefficientReport_6));

    ReportMonitor reportMonitor_0 = 
      forceCoefficientReport_0.createMonitor();

    ReportMonitor reportMonitor_1 = 
      forceCoefficientReport_2.createMonitor();

    ReportMonitor reportMonitor_2 = 
      forceCoefficientReport_10.createMonitor();

    ReportMonitor reportMonitor_3 = 
      forceCoefficientReport_6.createMonitor();

    ReportMonitor reportMonitor_4 = 
      forceCoefficientReport_8.createMonitor();

    ReportMonitor reportMonitor_5 = 
      forceCoefficientReport_4.createMonitor();

    ((ClientServerObjectGroup) simulation_0.getMonitorManager().getGroupsManager().getObject("Coefficients")).getGroupsManager().groupObjects("Coefficients", Arrays.<ClientServerObject>asList(reportMonitor_0, reportMonitor_1, reportMonitor_5, reportMonitor_3, reportMonitor_4, reportMonitor_2));

    simulation_0.getMonitorManager().getGroupsManager().createGroup("New Group");

    ((ClientServerObjectGroup) simulation_0.getMonitorManager().getGroupsManager().getObject("New Group")).setPresentationName("Side");

    simulation_0.getMonitorManager().createMonitorAndPlot(new NeoObjectVector(new Object[] {forceReport_0, forceReport_10, forceReport_6, forceReport_4, forceReport_8, forceReport_2}), true, "Reports Plot");

    ReportMonitor reportMonitor_6 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Side force Monitor"));

    ReportMonitor reportMonitor_7 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Fs Remaining Monitor"));

    ReportMonitor reportMonitor_8 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Fs Undertray Monitor"));

    ReportMonitor reportMonitor_9 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Fs Rearwing Monitor"));

    ReportMonitor reportMonitor_10 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Fs Mono Monitor"));

    ReportMonitor reportMonitor_11 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Fs Frontwing Monitor"));

    MonitorPlot monitorPlot_0 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_6, reportMonitor_7, reportMonitor_8, reportMonitor_9, reportMonitor_10, reportMonitor_11}), "Reports Plot");

    monitorPlot_0.openInteractive();

    PlotUpdate plotUpdate_0 = 
      monitorPlot_0.getPlotUpdate();

    HardcopyProperties hardcopyProperties_0 = 
      plotUpdate_0.getHardcopyProperties();

    hardcopyProperties_0.setCurrentResolutionWidth(1245);

    hardcopyProperties_0.setCurrentResolutionHeight(624);

    monitorPlot_0.setPresentationName("Side");

    IterationUpdateFrequency iterationUpdateFrequency_0 = 
      plotUpdate_0.getIterationUpdateFrequency();

    IntegerValue integerValue_0 = 
      iterationUpdateFrequency_0.getIterationFrequencyQuantity();

    integerValue_0.getQuantity().setValue(25.0);

    plotUpdate_0.setSaveAnimation(true);

    plotUpdate_0.setFilenameMode(WindowUpdate.FilenameModeEnum.CUSTOM);

    plotUpdate_0.setAnimationFilenameBase("side");

    plotUpdate_0.setAnimationFilePath("plots");

    hardcopyProperties_0.setOutputWidth(800);

    hardcopyProperties_0.setOutputHeight(624);

    hardcopyProperties_0.setUseCurrentResolution(false);

    hardcopyProperties_0.setOutputHeight(450);

    ((ClientServerObjectGroup) simulation_0.getMonitorManager().getGroupsManager().getObject("Side")).getGroupsManager().groupObjects("Side", Arrays.<ClientServerObject>asList(reportMonitor_11, reportMonitor_9, reportMonitor_10, reportMonitor_8, reportMonitor_7, reportMonitor_6));

    reportMonitor_11.setPlotLimit(500000);

    reportMonitor_10.setPlotLimit(500000);

    reportMonitor_9.setPlotLimit(500000);

    reportMonitor_7.setPlotLimit(500000);

    reportMonitor_8.setPlotLimit(500000);

  }

  private void mesh(){
    Simulation simulation_0 = getActiveSimulation();

    simulation_0.get(MeshOperationManager.class).executeAll();

    Units units_5 = simulation_0.getUnitsManager().getPreferredUnits(Dimensions.Builder().length(2).build());
    Units units_6 = simulation_0.getUnitsManager().getPreferredUnits(Dimensions.Builder().length(3).build());
    Units units_7 = simulation_0.getUnitsManager().hasPreferredUnits(new IntVector(new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    MeshManager meshManager_0 = simulation_0.getMeshManager();

    Region region_4 = simulation_0.getRegionManager().getRegion("Air");     
    Region region_1 = simulation_0.getRegionManager().getRegion("MRF-FR");
    Region region_2 = simulation_0.getRegionManager().getRegion("MRF-RR");
    Region region_3 = simulation_0.getRegionManager().getRegion("MRF-FL");
    Region region_0 = simulation_0.getRegionManager().getRegion("MRF-RL");

    meshManager_0.removeInvalidCells(new NeoObjectVector(new Object[] {region_0, region_1, region_2, region_3, region_4}), NeoProperty.fromString("{\'minimumContiguousFaceArea\': 0.0, \'minimumCellVolumeEnabled\': true, \'minimumVolumeChangeEnabled\': true, \'functionOperator\': 0, \'minimumContiguousFaceAreaEnabled\': false, \'minimumFaceValidityEnabled\': true, \'functionValue\': 0.0, \'functionEnabled\': false, \'function\': \'\', \'minimumVolumeChange\': 0.001, \'minimumCellVolume\': 1E-13, \'minimumCellQualityEnabled\': false, \'minimumCellQuality\': 1.0E-8, \'minimumDiscontiguousCells\': 1, \'minimumDiscontiguousCellsEnabled\': false, \'minimumFaceValidity\': 0.91}"));    
 
    String FileName = simulation_0.getPresentationName();
    simulation_0.saveState(resolvePath(FileName + ".sim"));
  }

}
