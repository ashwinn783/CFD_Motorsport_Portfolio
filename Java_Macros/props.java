// Simcenter STAR-CCM+ macro: props.java
// Written by Simcenter STAR-CCM+ 18.06.006
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.material.*;
import star.flow.*;

public class props extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

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
}
