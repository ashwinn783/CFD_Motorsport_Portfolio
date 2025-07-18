// Simcenter STAR-CCM+ macro: cfl.java
// Written by Simcenter STAR-CCM+ 18.06.006
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.base.report.*;
import star.flow.*;
import star.meshing.*;

public class cfl extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    MaxReport maxReport_0 = 
      simulation_0.getReportManager().create("star.base.report.MaxReport");

    maxReport_0.setPresentationName("Max_CFL");

    PhysicsContinuum physicsContinuum_0 = 
      ((PhysicsContinuum) simulation_0.getContinuumManager().getContinuum("DES"));

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Air");

    physicsContinuum_0.add(region_0);

    Region region_1 = 
      simulation_0.getRegionManager().getRegion("MRF-FL");

    physicsContinuum_0.add(region_1);

    Region region_2 = 
      simulation_0.getRegionManager().getRegion("MRF-RL");

    physicsContinuum_0.add(region_2);

    Region region_3 = 
      simulation_0.getRegionManager().getRegion("MRF-FR");

    physicsContinuum_0.add(region_3);

    Region region_4 = 
      simulation_0.getRegionManager().getRegion("MRF-RR");

    physicsContinuum_0.add(region_4);

    CourantNumberFunction courantNumberFunction_0 = 
      ((CourantNumberFunction) simulation_0.getFieldFunctionManager().getFunction("CourantNumber"));

    maxReport_0.setFieldFunction(courantNumberFunction_0);

    maxReport_0.getParts().setQuery(null);

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

    Boundary boundary_13 = 
      region_1.getBoundaryManager().getBoundary("Default");

    Boundary boundary_14 = 
      region_1.getBoundaryManager().getBoundary("wheelhub");

    Boundary boundary_15 = 
      region_3.getBoundaryManager().getBoundary("Default");

    Boundary boundary_16 = 
      region_3.getBoundaryManager().getBoundary("wheelhub");

    Boundary boundary_17 = 
      region_2.getBoundaryManager().getBoundary("Default");

    Boundary boundary_18 = 
      region_2.getBoundaryManager().getBoundary("wheelhub");

    Boundary boundary_19 = 
      region_4.getBoundaryManager().getBoundary("Default");

    Boundary boundary_20 = 
      region_4.getBoundaryManager().getBoundary("wheelhub");

    maxReport_0.getParts().setObjects(region_0, boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, boundary_5, boundary_6, boundary_7, boundary_8, boundary_9, boundary_10, boundary_11, boundary_12, region_1, boundary_13, boundary_14, region_3, boundary_15, boundary_16, region_2, boundary_17, boundary_18, region_4, boundary_19, boundary_20);

    LatestMeshProxyRepresentation latestMeshProxyRepresentation_0 = 
      ((LatestMeshProxyRepresentation) simulation_0.getRepresentationManager().getObject("Latest Surface/Volume"));

    maxReport_0.setRepresentation(latestMeshProxyRepresentation_0);

    VolumeAverageReport volumeAverageReport_0 = 
      simulation_0.getReportManager().create("star.base.report.VolumeAverageReport");

    volumeAverageReport_0.setPresentationName("Mean_CFL");

    volumeAverageReport_0.setFieldFunction(courantNumberFunction_0);

    volumeAverageReport_0.getParts().setQuery(null);

    volumeAverageReport_0.getParts().setObjects(region_0, region_1, region_3, region_2, region_4);

    volumeAverageReport_0.setRepresentation(latestMeshProxyRepresentation_0);

    simulation_0.getMonitorManager().createMonitorAndPlot(new NeoObjectVector(new Object[] {volumeAverageReport_0, maxReport_0}), true, "Reports Plot");

    ReportMonitor reportMonitor_0 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Mean_CFL Monitor"));

    ReportMonitor reportMonitor_1 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Max_CFL Monitor"));

    MonitorPlot monitorPlot_0 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_0, reportMonitor_1}), "Reports Plot");

    monitorPlot_0.openInteractive();

    PlotUpdate plotUpdate_0 = 
      monitorPlot_0.getPlotUpdate();

    HardcopyProperties hardcopyProperties_0 = 
      plotUpdate_0.getHardcopyProperties();

    hardcopyProperties_0.setCurrentResolutionWidth(429);

    hardcopyProperties_0.setCurrentResolutionHeight(465);

    monitorPlot_0.setPresentationName("CFL");

    plotUpdate_0.setSaveAnimation(true);

    plotUpdate_0.setFilenameMode(WindowUpdate.FilenameModeEnum.CUSTOM);

    plotUpdate_0.setAnimationFilenameBase("CFL");

    plotUpdate_0.setAnimationFilePath("plots");

    IterationUpdateFrequency iterationUpdateFrequency_0 = 
      plotUpdate_0.getIterationUpdateFrequency();

    IntegerValue integerValue_0 = 
      iterationUpdateFrequency_0.getIterationFrequencyQuantity();

    integerValue_0.getQuantity().setValue(25.0);

    hardcopyProperties_0.setOutputWidth(800);

    hardcopyProperties_0.setOutputHeight(465);

    hardcopyProperties_0.setUseCurrentResolution(false);

    hardcopyProperties_0.setOutputHeight(450);
  }
}
