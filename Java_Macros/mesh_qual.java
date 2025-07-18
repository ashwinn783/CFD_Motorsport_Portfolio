// Simcenter STAR-CCM+ macro: mesh_qual.java
// Written by Simcenter STAR-CCM+ 19.06.009
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;

public class mesh_qual extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    HistogramPlot histogramPlot_1 = 
      simulation_0.getPlotManager().create("star.common.HistogramPlot");

    histogramPlot_1.openInteractive();

    histogramPlot_1.setTitle("Cell quality");

    histogramPlot_1.getParts().setQuery(null);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Air");

    Region region_1 = 
      simulation_0.getRegionManager().getRegion("MRF-FL");

    Region region_2 = 
      simulation_0.getRegionManager().getRegion("MRF-FR");

    Region region_3 = 
      simulation_0.getRegionManager().getRegion("MRF-RL");

    Region region_4 = 
      simulation_0.getRegionManager().getRegion("MRF-RR");

    histogramPlot_1.getParts().setObjects(region_0, region_1, region_2, region_3, region_4);

    histogramPlot_1.setDisplayMode(HistogramDisplayModeEnum.SIDE_BY_SIDE);

    HistogramAxisType histogramAxisType_1 = 
      histogramPlot_1.getXAxisType();

    FieldFunctionUnits fieldFunctionUnits_1 = 
      histogramAxisType_1.getBinFunction();

    CellQualityFunction cellQualityFunction_0 = 
      ((CellQualityFunction) simulation_0.getFieldFunctionManager().getFunction("CellQuality"));

    fieldFunctionUnits_1.setFieldFunction(cellQualityFunction_0);

    Cartesian2DAxisManager cartesian2DAxisManager_1 = 
      ((Cartesian2DAxisManager) histogramPlot_1.getAxisManager());

    Cartesian2DAxis cartesian2DAxis_1 = 
      ((Cartesian2DAxis) cartesian2DAxisManager_1.getAxis("Left Axis"));

    cartesian2DAxis_1.setLogarithmic(true);

    HistogramPlot histogramPlot_2 = 
      simulation_0.getPlotManager().create("star.common.HistogramPlot");

    histogramPlot_2.openInteractive();

    histogramPlot_2.setTitle("Face validity");

    histogramPlot_2.getParts().setQuery(null);

    histogramPlot_2.getParts().setObjects(region_0, region_1, region_2, region_3, region_4);

    histogramPlot_2.setDisplayMode(HistogramDisplayModeEnum.SIDE_BY_SIDE);

    HistogramAxisType histogramAxisType_2 = 
      histogramPlot_2.getXAxisType();

    FieldFunctionUnits fieldFunctionUnits_2 = 
      histogramAxisType_2.getBinFunction();

    FaceValidityFunction faceValidityFunction_0 = 
      ((FaceValidityFunction) simulation_0.getFieldFunctionManager().getFunction("FaceValidity"));

    fieldFunctionUnits_2.setFieldFunction(faceValidityFunction_0);

    Cartesian2DAxisManager cartesian2DAxisManager_2 = 
      ((Cartesian2DAxisManager) histogramPlot_2.getAxisManager());

    Cartesian2DAxis cartesian2DAxis_2 = 
      ((Cartesian2DAxis) cartesian2DAxisManager_2.getAxis("Left Axis"));

    cartesian2DAxis_2.setLogarithmic(true);

    HistogramPlot histogramPlot_3 = 
      simulation_0.getPlotManager().create("star.common.HistogramPlot");

    histogramPlot_3.openInteractive();

    histogramPlot_3.setTitle("min Volume");

    histogramPlot_3.getParts().setQuery(null);

    histogramPlot_3.getParts().setObjects(region_0, region_1, region_2, region_3, region_4);

    histogramPlot_3.setDisplayMode(HistogramDisplayModeEnum.SIDE_BY_SIDE);

    HistogramAxisType histogramAxisType_3 = 
      histogramPlot_3.getXAxisType();

    FieldFunctionUnits fieldFunctionUnits_3 = 
      histogramAxisType_3.getBinFunction();

    PrimitiveFieldFunction primitiveFieldFunction_0 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("minVolumeReport"));

    fieldFunctionUnits_3.setFieldFunction(primitiveFieldFunction_0);

    histogramPlot_3.setTitle("skewness angle");

    SkewnessAngleFunction skewnessAngleFunction_0 = 
      ((SkewnessAngleFunction) simulation_0.getFieldFunctionManager().getFunction("SkewnessAngle"));

    fieldFunctionUnits_3.setFieldFunction(skewnessAngleFunction_0);

    Cartesian2DAxisManager cartesian2DAxisManager_3 = 
      ((Cartesian2DAxisManager) histogramPlot_3.getAxisManager());

    Cartesian2DAxis cartesian2DAxis_3 = 
      ((Cartesian2DAxis) cartesian2DAxisManager_3.getAxis("Left Axis"));

    cartesian2DAxis_3.setLogarithmic(true);

    HistogramPlot histogramPlot_4 = 
      simulation_0.getPlotManager().create("star.common.HistogramPlot");

    histogramPlot_4.openInteractive();

    histogramPlot_4.setTitle("Volume change");

    histogramPlot_4.getParts().setQuery(null);

    histogramPlot_4.getParts().setObjects(region_0, region_1, region_2, region_3, region_4);

    histogramPlot_4.setDisplayMode(HistogramDisplayModeEnum.SIDE_BY_SIDE);

    HistogramAxisType histogramAxisType_4 = 
      histogramPlot_4.getXAxisType();

    FieldFunctionUnits fieldFunctionUnits_4 = 
      histogramAxisType_4.getBinFunction();

    VolumeChangeFunction volumeChangeFunction_0 = 
      ((VolumeChangeFunction) simulation_0.getFieldFunctionManager().getFunction("VolumeChange"));

    fieldFunctionUnits_4.setFieldFunction(volumeChangeFunction_0);

    Cartesian2DAxisManager cartesian2DAxisManager_4 = 
      ((Cartesian2DAxisManager) histogramPlot_4.getAxisManager());

    Cartesian2DAxis cartesian2DAxis_4 = 
      ((Cartesian2DAxis) cartesian2DAxisManager_4.getAxis("Left Axis"));

    cartesian2DAxis_4.setLogarithmic(true);

    histogramPlot_1.encode(resolvePath("C:\\Users\\Ashwin\\Desktop\\1.png"), "png", 1920, 1080, true, false);

    histogramPlot_2.encode(resolvePath("C:\\Users\\Ashwin\\Desktop\\2.png"), "png", 1920, 1080, true, false);

    histogramPlot_3.encode(resolvePath("C:\\Users\\Ashwin\\Desktop\\3.png"), "png", 1920, 1080, true, false);

    histogramPlot_4.encode(resolvePath("C:\\Users\\Ashwin\\Desktop\\4.png"), "png", 1920, 1080, true, false);
  }
}
