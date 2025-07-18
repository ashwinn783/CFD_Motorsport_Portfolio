// Simcenter STAR-CCM+ macro: mesh.java
// Written by Simcenter STAR-CCM+ 18.06.006
package macro;

import star.base.neo.*;
import star.base.query.*;
import star.cadmodeler.*;
import star.cadmodeler.ui.ModelReImportCommands;
import star.common.*;
import star.coupledflow.*;
import star.dualmesher.VolumeControlDualMesherSizeOption;
import star.flow.*;
import star.keturb.*;
import star.kwturb.*;
import star.meshing.*;
import star.motion.*;
import star.overset.OversetAmrCriterion;
import star.overset.UniformGapRefinement;
import star.prismmesher.*;
import star.resurfacer.AutomaticSurfaceRepairAutoMesher;
import star.resurfacer.ResurfacerAutoMesher;
import star.resurfacer.ResurfacerElementTypeOption;
import star.resurfacer.SurfaceGrowthRate;
import star.rsturb.EbRsAllYplusWallTreatment;
import star.rsturb.EbRsTurbModel;
import star.rsturb.ReynoldsStressTurbulence;
import star.surfacetools.OffsetPartsOperation;
import star.surfacewrapper.GeometricFeatureAngle;
import star.surfacewrapper.PartsTwoGroupContactPreventionSet;
import star.surfacewrapper.SurfaceWrapperAutoMeshOperation;
import star.trimmer.*;
import star.turbulence.*;
import star.vis.SimpleAnnotation;
import star.walldistance.WallDistanceModel;
import star.amr.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Vector;

public class mesh extends StarMacro {

    private Simulation simulation_0;
    private String directory;
    private Units units_1, units_mm;
    private SolidModelCompositePart frontwing, undertray, rearwing, monocoque, remaining;
    private Collection<SolidModelCompositePart> vehicle;
    private LabCoordinateSystem labCoordinateSystem_0;


  public void execute() {
    Simulation simulation_0 = getActiveSimulation();
    directory = System.getProperty("user.dir");

    frontwing = ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("C_FRONTWING"));
    undertray = ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("C_UNDERTRAY"));
    rearwing =  ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("C_REARWING"));
    monocoque = ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("C_MONOCOQUE"));
    remaining = ((SolidModelCompositePart) simulation_0.get(SimulationPartManager.class).getPart("z_000_remaining-parts"));

    vehicle = new NeoObjectVector(new Object[]{frontwing, undertray, rearwing, monocoque, remaining});
    labCoordinateSystem_0 = simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

    units_1 = ((Units) simulation_0.getUnitsManager().getObject(""));
    units_mm = ((Units) simulation_0.getUnitsManager().getObject("mm"));

    addCAD();
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = getActiveSimulation();
    simulation_0.get(MeshOperationManager.class).executeAll();

    //remove();

    String FileName = simulation_0.getPresentationName();
    simulation_0.saveState(resolvePath(FileName + ".sim"));

  }

  private void addCAD() {
          File dir = new File(directory);
  
          for (File file : dir.listFiles()) {
              if (file.isFile() && (file.getPath().endsWith(".igs") || file.getPath().endsWith(".iges") || file.getPath().endsWith(".step") || file.getPath().endsWith(".stp") || file.getPath().endsWith(".stl"))) {
                  PartImportManager partImportManager_0 =
                          simulation_0.get(PartImportManager.class);
                  SolidModelCompositePart solidModelCompositePart_0 = remaining;
                  if (file.getName().toLowerCase().contains("frontwing")) {
                      solidModelCompositePart_0 = frontwing;
                  } else if (file.getName().toLowerCase().contains("undertray")) {
                      solidModelCompositePart_0 = undertray;
                  } else if (file.getName().toLowerCase().contains("rearwing")) {
                      solidModelCompositePart_0 = rearwing;
                  }
                  if (!solidModelCompositePart_0.getPresentationName().equals("z_000_remaining-parts")) {
                      Collection<GeometryPart> children = solidModelCompositePart_0.getChildParts().getParts();
                      solidModelCompositePart_0.getPartManager().removeParts(children);
  
                      /*
                      for (GeometryPart child : children) {
                          solidModelCompositePart_0.getChildParts().remove(child);
                      }
  
                       */
                  }
            partImportManager_0.importCadPart(resolvePath(file.getPath()), "SharpEdges", 30.0, 5, true, 1.0E-5, true, false, true, false, true, NeoProperty.fromString("{\'NX\': 1, \'STEP\': 1, \'SE\': 1, \'CGR\': 1, \'SW\': 1, \'IFC\': 1, \'ACIS\': 1, \'JT\': 1, \'IGES\': 1, \'CATIAV5\': 1, \'CATIAV4\': 1, \'3DXML\': 1, \'CREO\': 1, \'INV\': 1}"), true, false);
  
                  GeometryPart part;
                  try {
                       part = simulation_0.get(SimulationPartManager.class).getPart(file.getName().split("\\.")[0].toUpperCase());
                  }
                  catch(Exception e)
                  {
                       part = simulation_0.get(SimulationPartManager.class).getPart(file.getName().split("\\.")[0].toLowerCase());
                  }
  
                  solidModelCompositePart_0.getChildParts().reparentParts(Arrays.asList(part), solidModelCompositePart_0.getChildParts());
  
                  GeometryPart part_mir = part.duplicatePart(solidModelCompositePart_0.getPartManager());
  
                  part_mir.setPresentationName(part.getPresentationName() + "_MIR");
  
                  solidModelCompositePart_0.getChildParts().reflectParts(new NeoObjectVector(new Object[]{part_mir}), new DoubleVector(new double[]{0.0, 1.0, 0.0}), new NeoObjectVector(new Object[]{units_mm, units_mm, units_mm}), labCoordinateSystem_0);
              }
          }
      }

  private void remove(){
    Simulation simulation_0 = getActiveSimulation();

    Units units_5 = simulation_0.getUnitsManager().getPreferredUnits(Dimensions.Builder().length(2).build());
    Units units_6 = simulation_0.getUnitsManager().getPreferredUnits(Dimensions.Builder().length(3).build());
    Units units_7 = simulation_0.getUnitsManager().hasPreferredUnits(new IntVector(new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    MeshManager meshManager_0 = simulation_0.getMeshManager();

    Region region_0 = simulation_0.getRegionManager().getRegion("Air");
    meshManager_0.removeInvalidCells(new NeoObjectVector(new Object[] {region_0}), NeoProperty.fromString("{\'minimumContiguousFaceArea\': 0.0, \'minimumCellVolumeEnabled\': true, \'minimumVolumeChangeEnabled\': true, \'functionOperator\': 0, \'minimumContiguousFaceAreaEnabled\': true, \'minimumFaceValidityEnabled\': true, \'functionValue\': 0.0, \'functionEnabled\': false, \'function\': \'\', \'minimumVolumeChange\': 1.0E-11, \'minimumCellVolume\': 1.0E-13, \'minimumCellQualityEnabled\': true, \'minimumCellQuality\': 1.0E-6, \'minimumDiscontiguousCells\': 1, \'minimumDiscontiguousCellsEnabled\': true, \'minimumFaceValidity\': 0.55}"));
     
    Region region_1 = simulation_0.getRegionManager().getRegion("MRF-FR");
    meshManager_0.removeInvalidCells(new NeoObjectVector(new Object[] {region_1}), NeoProperty.fromString("{\'minimumContiguousFaceArea\': 0.0, \'minimumCellVolumeEnabled\': true, \'minimumVolumeChangeEnabled\': true, \'functionOperator\': 0, \'minimumContiguousFaceAreaEnabled\': true, \'minimumFaceValidityEnabled\': true, \'functionValue\': 0.0, \'functionEnabled\': false, \'function\': \'\', \'minimumVolumeChange\': 1.0E-10, \'minimumCellVolume\': 1.0E-12, \'minimumCellQualityEnabled\': true, \'minimumCellQuality\': 1.0E-8, \'minimumDiscontiguousCells\': 1, \'minimumDiscontiguousCellsEnabled\': true, \'minimumFaceValidity\': 0.51}"));

    Region region_2 = simulation_0.getRegionManager().getRegion("MRF-RR");
    meshManager_0.removeInvalidCells(new NeoObjectVector(new Object[] {region_2}), NeoProperty.fromString("{\'minimumContiguousFaceArea\': 0.0, \'minimumCellVolumeEnabled\': true, \'minimumVolumeChangeEnabled\': true, \'functionOperator\': 0, \'minimumContiguousFaceAreaEnabled\': true, \'minimumFaceValidityEnabled\': true, \'functionValue\': 0.0, \'functionEnabled\': false, \'function\': \'\', \'minimumVolumeChange\': 1.0E-10, \'minimumCellVolume\': 1.0E-12, \'minimumCellQualityEnabled\': true, \'minimumCellQuality\': 1.0E-8, \'minimumDiscontiguousCells\': 1, \'minimumDiscontiguousCellsEnabled\': true, \'minimumFaceValidity\': 0.51}"));

    Region region_3 = simulation_0.getRegionManager().getRegion("MRF-FL");
    meshManager_0.removeInvalidCells(new NeoObjectVector(new Object[] {region_3}), NeoProperty.fromString("{\'minimumContiguousFaceArea\': 0.0, \'minimumCellVolumeEnabled\': true, \'minimumVolumeChangeEnabled\': true, \'functionOperator\': 0, \'minimumContiguousFaceAreaEnabled\': true, \'minimumFaceValidityEnabled\': true, \'functionValue\': 0.0, \'functionEnabled\': false, \'function\': \'\', \'minimumVolumeChange\': 1.0E-10, \'minimumCellVolume\': 1.0E-12, \'minimumCellQualityEnabled\': true, \'minimumCellQuality\': 1.0E-8, \'minimumDiscontiguousCells\': 1, \'minimumDiscontiguousCellsEnabled\': true, \'minimumFaceValidity\': 0.51}"));

    Region region_4 = simulation_0.getRegionManager().getRegion("MRF-RL");
    meshManager_0.removeInvalidCells(new NeoObjectVector(new Object[] {region_4}), NeoProperty.fromString("{\'minimumContiguousFaceArea\': 0.0, \'minimumCellVolumeEnabled\': true, \'minimumVolumeChangeEnabled\': true, \'functionOperator\': 0, \'minimumContiguousFaceAreaEnabled\': true, \'minimumFaceValidityEnabled\': true, \'functionValue\': 0.0, \'functionEnabled\': false, \'function\': \'\', \'minimumVolumeChange\': 1.0E-10, \'minimumCellVolume\': 1.0E-12, \'minimumCellQualityEnabled\': true, \'minimumCellQuality\': 1.0E-8, \'minimumDiscontiguousCells\': 1, \'minimumDiscontiguousCellsEnabled\': true, \'minimumFaceValidity\': 0.51}"));
    
    }
}
