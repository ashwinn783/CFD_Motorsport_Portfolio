// Simcenter STAR-CCM+ macro: scenes.java
// Written by Simcenter STAR-CCM+ 18.06.006
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;

public class scenes extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Scene scene_6 = 
      simulation_0.getSceneManager().createScene("Scene");

    Scene scene_7 = 
      simulation_0.getSceneManager().getScene("Cp");

    scene_6.copyProperties(scene_7);

    scene_6.setPresentationName("Cp copy");

    simulation_0.getSceneManager().getGroupsManager().groupObjects("", Arrays.<ClientServerObject>asList(scene_6));

    scene_6.setPresentationName("Cp_Mean");

    scene_6.initializeAndWait();

    ScalarDisplayer scalarDisplayer_0 = 
      ((ScalarDisplayer) scene_6.getDisplayerManager().getObject("3D"));

    IdentityTransform identityTransform_0 = 
      ((IdentityTransform) simulation_0.getTransformManager().getObject("Identity"));

    scalarDisplayer_0.setVisTransform(identityTransform_0);

    PrimitiveFieldFunction primitiveFieldFunction_0 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("CpMeanMonitor"));

    scalarDisplayer_0.getScalarDisplayQuantity().setFieldFunction(primitiveFieldFunction_0);

    scalarDisplayer_0.getScalarDisplayQuantity().setAutoRange(AutoRangeMode.NONE);

    ScalarDisplayer scalarDisplayer_1 = 
      ((ScalarDisplayer) scene_6.getDisplayerManager().getObject("x-Section"));

    scalarDisplayer_1.getScalarDisplayQuantity().setFieldFunction(primitiveFieldFunction_0);

    scalarDisplayer_1.getScalarDisplayQuantity().setAutoRange(AutoRangeMode.NONE);

    ScalarDisplayer scalarDisplayer_2 = 
      ((ScalarDisplayer) scene_6.getDisplayerManager().getObject("y-Section"));

    scalarDisplayer_2.getScalarDisplayQuantity().setFieldFunction(primitiveFieldFunction_0);

    scalarDisplayer_2.getScalarDisplayQuantity().setAutoRange(AutoRangeMode.NONE);

    ScalarDisplayer scalarDisplayer_3 = 
      ((ScalarDisplayer) scene_6.getDisplayerManager().getObject("z-Section"));

    scalarDisplayer_3.getScalarDisplayQuantity().setFieldFunction(primitiveFieldFunction_0);

    scalarDisplayer_3.getScalarDisplayQuantity().setAutoRange(AutoRangeMode.NONE);

    Scene scene_8 = 
      simulation_0.getSceneManager().createScene("Scene");

    Scene scene_9 = 
      simulation_0.getSceneManager().getScene("CpT");

    scene_8.copyProperties(scene_9);

    scene_8.setPresentationName("CpT copy");

    simulation_0.getSceneManager().getGroupsManager().groupObjects("", Arrays.<ClientServerObject>asList(scene_8));

    scene_8.setPresentationName("CpT_Mean");

    scene_8.initializeAndWait();

    ScalarDisplayer scalarDisplayer_4 = 
      ((ScalarDisplayer) scene_8.getDisplayerManager().getObject("3D"));

    scalarDisplayer_4.setVisTransform(identityTransform_0);

    PrimitiveFieldFunction primitiveFieldFunction_1 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("CpTMeanMonitor"));

    scalarDisplayer_4.getScalarDisplayQuantity().setFieldFunction(primitiveFieldFunction_1);

    scalarDisplayer_4.getScalarDisplayQuantity().setAutoRange(AutoRangeMode.NONE);

    ScalarDisplayer scalarDisplayer_5 = 
      ((ScalarDisplayer) scene_8.getDisplayerManager().getObject("x-Section"));

    scalarDisplayer_5.getScalarDisplayQuantity().setFieldFunction(primitiveFieldFunction_1);

    scalarDisplayer_5.getScalarDisplayQuantity().setAutoRange(AutoRangeMode.NONE);

    ScalarDisplayer scalarDisplayer_6 = 
      ((ScalarDisplayer) scene_8.getDisplayerManager().getObject("y-Section"));

    scalarDisplayer_6.getScalarDisplayQuantity().setFieldFunction(primitiveFieldFunction_1);

    scalarDisplayer_6.getScalarDisplayQuantity().setAutoRange(AutoRangeMode.NONE);

    ScalarDisplayer scalarDisplayer_7 = 
      ((ScalarDisplayer) scene_8.getDisplayerManager().getObject("z-Section"));

    scalarDisplayer_7.getScalarDisplayQuantity().setFieldFunction(primitiveFieldFunction_1);

    scalarDisplayer_7.getScalarDisplayQuantity().setAutoRange(AutoRangeMode.NONE);

    Scene scene_10 = 
      simulation_0.getSceneManager().createScene("Scene");

    Scene scene_11 = 
      simulation_0.getSceneManager().getScene("Total pressure");

    scene_10.copyProperties(scene_11);

    scene_10.setPresentationName("Total pressure copy");

    simulation_0.getSceneManager().getGroupsManager().groupObjects("", Arrays.<ClientServerObject>asList(scene_10));

    scene_10.setPresentationName("Total pressure_Mean");

    scene_10.initializeAndWait();

    ScalarDisplayer scalarDisplayer_8 = 
      ((ScalarDisplayer) scene_10.getDisplayerManager().getObject("3D"));

    scalarDisplayer_8.setVisTransform(identityTransform_0);

    PrimitiveFieldFunction primitiveFieldFunction_2 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("TotalPressureMeanMonitor"));

    scalarDisplayer_8.getScalarDisplayQuantity().setFieldFunction(primitiveFieldFunction_2);

    scalarDisplayer_8.getScalarDisplayQuantity().setAutoRange(AutoRangeMode.NONE);

    ScalarDisplayer scalarDisplayer_9 = 
      ((ScalarDisplayer) scene_10.getDisplayerManager().getObject("x-Section"));

    scalarDisplayer_9.getScalarDisplayQuantity().setFieldFunction(primitiveFieldFunction_2);

    scalarDisplayer_9.getScalarDisplayQuantity().setAutoRange(AutoRangeMode.NONE);

    ScalarDisplayer scalarDisplayer_10 = 
      ((ScalarDisplayer) scene_10.getDisplayerManager().getObject("y-Section"));

    scalarDisplayer_10.getScalarDisplayQuantity().setFieldFunction(primitiveFieldFunction_2);

    scalarDisplayer_10.getScalarDisplayQuantity().setAutoRange(AutoRangeMode.NONE);

    ScalarDisplayer scalarDisplayer_11 = 
      ((ScalarDisplayer) scene_10.getDisplayerManager().getObject("z-Section"));

    scalarDisplayer_11.getScalarDisplayQuantity().setFieldFunction(primitiveFieldFunction_2);

    scalarDisplayer_11.getScalarDisplayQuantity().setAutoRange(AutoRangeMode.NONE);

    Scene scene_12 = 
      simulation_0.getSceneManager().createScene("Scene");

    Scene scene_13 = 
      simulation_0.getSceneManager().getScene("Velocity");

    scene_12.copyProperties(scene_13);

    scene_12.setPresentationName("Velocity copy");

    simulation_0.getSceneManager().getGroupsManager().groupObjects("", Arrays.<ClientServerObject>asList(scene_12));

    scene_12.setPresentationName("Velocity_Mean");

    scene_12.initializeAndWait();

    VectorDisplayer vectorDisplayer_0 = 
      ((VectorDisplayer) scene_12.getDisplayerManager().getObject("x-Section"));

    vectorDisplayer_0.setDisplayMode(VectorDisplayMode.VECTOR_DISPLAY_MODE_LIC);

    UserFieldFunction userFieldFunction_0 = 
      ((UserFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Mean Velocity"));

    vectorDisplayer_0.getVectorDisplayQuantity().setFieldFunction(userFieldFunction_0);

    vectorDisplayer_0.getVectorDisplayQuantity().setAutoRange(AutoRangeMode.NONE);

    VectorDisplayer vectorDisplayer_1 = 
      ((VectorDisplayer) scene_12.getDisplayerManager().getObject("y-Section"));

    vectorDisplayer_1.setDisplayMode(VectorDisplayMode.VECTOR_DISPLAY_MODE_LIC);

    vectorDisplayer_1.getVectorDisplayQuantity().setFieldFunction(userFieldFunction_0);

    vectorDisplayer_1.getVectorDisplayQuantity().setAutoRange(AutoRangeMode.NONE);

    VectorDisplayer vectorDisplayer_2 = 
      ((VectorDisplayer) scene_12.getDisplayerManager().getObject("z-Section"));

    vectorDisplayer_2.setDisplayMode(VectorDisplayMode.VECTOR_DISPLAY_MODE_LIC);

    vectorDisplayer_2.getVectorDisplayQuantity().setFieldFunction(userFieldFunction_0);

    vectorDisplayer_2.getVectorDisplayQuantity().setAutoRange(AutoRangeMode.NONE);
  }
}
