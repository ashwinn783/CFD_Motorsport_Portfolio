// Simcenter STAR-CCM+ macro: ops.java
// Written by Simcenter STAR-CCM+ 18.06.006
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.base.query.*;
import star.surfacetools.*;
import star.meshing.*;
import star.surfacewrapper.*;

public class ops extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

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
}
