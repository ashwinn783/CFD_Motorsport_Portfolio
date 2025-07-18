// Simcenter STAR-CCM+ macro: yawch.java
// Written by Simcenter STAR-CCM+ 18.06.006
package macro;

import java.util.*;
import java.io.File;
import star.common.*;
import star.base.neo.*;
import star.base.report.*;
import star.flow.*;

public class yawch extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

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

    String FileName = simulation_0.getPresentationName();
    simulation_0.saveState(resolvePath(FileName + ".sim"));

  }
}
