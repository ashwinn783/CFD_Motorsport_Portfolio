import star.amr.AmrSolver;
import star.base.neo.DoubleVector;
import star.common.*;
import star.solidstress.ContactLinearizationOption;
import star.solidstress.ContactTypeOption;
import star.vis.*;

import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class postprocessing extends StarMacro {

    private Simulation simulation_0;
    private String postprocessing="xyz3";
    private String dirPath;
    private String workingDir = "/home/vault/iwst/iwst074h/";
    private String directory;
    private DecimalFormat df;
    private Units units_mm;
    private int xStart, xEnd, xResolution;
    private ArrayList<Scene> xSections;
    private ArrayList<Scene> ySections;
    private ArrayList<Scene> zSections;
    private ArrayList<Scene> threeDscenes;
    private ArrayList<String> plots;
    private int yStart, yEnd, yResolution;
    private int zStart, zEnd, zResolution;
    private boolean step = false;



private void LIC() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Scene scene_6 = 
      simulation_0.getSceneManager().getScene("Velocity");

    VectorDisplayer vectorDisplayer_2 = 
      ((VectorDisplayer) scene_6.getDisplayerManager().getObject("x-Section"));

    vectorDisplayer_2.setDisplayMode(VectorDisplayMode.VECTOR_DISPLAY_MODE_LIC);

    VectorDisplayer vectorDisplayer_0 = 
      ((VectorDisplayer) scene_6.getDisplayerManager().getObject("y-Section"));

    vectorDisplayer_0.setDisplayMode(VectorDisplayMode.VECTOR_DISPLAY_MODE_LIC);

    VectorDisplayer vectorDisplayer_3 = 
      ((VectorDisplayer) scene_6.getDisplayerManager().getObject("z-Section"));

    vectorDisplayer_3.setDisplayMode(VectorDisplayMode.VECTOR_DISPLAY_MODE_LIC);
  }






    @Override
    public void execute() {

LIC();

        simulation_0 = this.getActiveSimulation();
        directory = simulation_0.getSessionDir();
        df = new DecimalFormat("000");
        units_mm=((Units) simulation_0.getUnitsManager().getObject("mm"));

        xSections = new ArrayList<>();
        ySections = new ArrayList<>();
        zSections = new ArrayList<>();
        threeDscenes = new ArrayList<>();
        plots = new ArrayList<>();

        try {
            var br = new BufferedReader(new FileReader(directory+"/Settings"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" : ");
                if (parts.length > 1) {
                    String name = parts[0].trim();
                    String value = parts[1].trim();

                    if (name.equals("Settings/Scenes/x-Sections/Range/Start")) {
                        xStart = (int) Double.parseDouble(value);
                    } else if (name.equals("Settings/Scenes/x-Sections/Range/End")) {
                        xEnd = (int) Double.parseDouble(value);
                    } else if (name.equals("Settings/Scenes/x-Sections/Range/Resolution")) {
                        xResolution = (int) Double.parseDouble(value);
                    } else if (name.equals("Settings/Scenes/y-Sections/Range/Start")) {
                        yStart = (int) Double.parseDouble(value);
                    } else if (name.equals("Settings/Scenes/y-Sections/Range/End")) {
                        yEnd = (int) Double.parseDouble(value);
                    } else if (name.equals("Settings/Scenes/y-Sections/Range/Resolution")) {
                        yResolution = (int) Double.parseDouble(value);
                    } else if (name.equals("Settings/Scenes/z-Sections/Range/Start")) {
                        zStart = (int) Double.parseDouble(value);
                    } else if (name.equals("Settings/Scenes/z-Sections/Range/End")) {
                        zEnd = (int) Double.parseDouble(value);
                    } else if (name.equals("Settings/Scenes/z-Sections/Range/Resolution")) {
                        zResolution = (int) Double.parseDouble(value);
                    }
                    else if(name.equals("Settings/Run Settings/Remote Delete Time"))
                    {
                        try {
                            FileWriter fileWriter = new FileWriter(simulation_0.getSessionDir()+"/deleteDate.txt");
                            LocalDate tomorrow = LocalDate.now().plusDays((int) (Double.parseDouble(value)));
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                            String date = tomorrow.format(formatter);
                            fileWriter.write(date);
                            fileWriter.close();
                        } catch (IOException e) {

                        }
                    }



                    if(Boolean.parseBoolean(value))
                    {
                        String path[] = name.split("/");
                        if (name.contains("x-Section"))
                        {
                            xSections.add(simulation_0.getSceneManager().getScene(path[path.length-1]));
                        }
                        else if (name.contains("y-Section"))
                        {
                            ySections.add(simulation_0.getSceneManager().getScene(path[path.length-1]));
                        }
                        else if (name.contains("z-Section"))
                        {
                            zSections.add(simulation_0.getSceneManager().getScene(path[path.length-1]));
                        }
                        else if (name.contains("3D-Scenes"))
                        {
                            threeDscenes.add(simulation_0.getSceneManager().getScene(path[path.length-1]));
                        }
                        else if (name.contains("plots"))
                        {
                            plots.add(path[path.length-1]);
                        }
                        if(name.contains("Inspection"))
                        {
                            step=true;
                        }
                    }
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(step)
        {
            simulation_0.getSimulationIterator().step(1);
        }


        PlaneSection planeSection_x =
                ((PlaneSection) simulation_0.getPartManager().getObject("plane section x-direction"));
        PlaneSection planeSection_y =
                ((PlaneSection) simulation_0.getPartManager().getObject("plane section y-direction"));
        PlaneSection planeSection_z =
                ((PlaneSection) simulation_0.getPartManager().getObject("plane section z-direction"));

        ExecutorService executorService = Executors.newFixedThreadPool(20);
        

        int counter =0;

        if(postprocessing.contains("z")) {
            for (Scene scene : zSections) {
                if (scene.getDisplayerManager().hasDisplayer("3D")) {
                    scene.getDisplayerManager().getObject("3D").setVisibilityOverrideMode(DisplayerVisibilityOverride.HIDE_ALL_PARTS);
                }
                if (scene.getDisplayerManager().hasDisplayer("x-Section")) {
                    scene.getDisplayerManager().getObject("x-Section").setVisibilityOverrideMode(DisplayerVisibilityOverride.HIDE_ALL_PARTS);
                    scene.getDisplayerManager().getObject("y-Section").setVisibilityOverrideMode(DisplayerVisibilityOverride.HIDE_ALL_PARTS);
                    scene.getDisplayerManager().getObject("z-Section").setVisibilityOverrideMode(DisplayerVisibilityOverride.SHOW_ALL_PARTS);
                }
                if (scene.getDisplayerManager().hasDisplayer("x-Section-Outline")) {
                    scene.getDisplayerManager().getObject("x-Section-Outline").setVisibilityOverrideMode(DisplayerVisibilityOverride.HIDE_ALL_PARTS);
                    scene.getDisplayerManager().getObject("y-Section-Outline").setVisibilityOverrideMode(DisplayerVisibilityOverride.HIDE_ALL_PARTS);
                    scene.getDisplayerManager().getObject("z-Section-Outline").setVisibilityOverrideMode(DisplayerVisibilityOverride.SHOW_ALL_PARTS);
                }
                CurrentView currentView =
                        scene.getCurrentView();
                currentView.setInput(new DoubleVector(new double[]{0.7, 0.00, 0.0}), new DoubleVector(new double[]{0.7, 0.00, 1.0}), new DoubleVector(new double[]{0.0, 1.0, 0.0}), 1.20, 1, 30.0);
            }
counter = 0;
            for (int i = zStart; i < zEnd; i += zResolution) {
                counter += 1;
                final int counterF = counter;
                CountDownLatch latch = new CountDownLatch(zSections.size());
                int finalI = i;
                double z = i * 0.001;
                planeSection_z.getOriginCoordinate().setDefinition("[0.0, 0.0," + z + "]");
                for (Scene scene : zSections) {
                    executorService.submit(() -> {
                        //  Sie Ihre Methode hier aus
                        export(scene, "z-Section", counterF, finalI);
                        latch.countDown();
                    });
                }

                try {
                    latch.await();
                } catch (InterruptedException e) {
                    // Behandeln Sie die Ausnahme
                }
            }
        }

        if(postprocessing.contains("x")) {
         

            for (Scene scene : xSections) {
                if (scene.getDisplayerManager().hasDisplayer("3D")) {
                    scene.getDisplayerManager().getObject("3D").setVisibilityOverrideMode(DisplayerVisibilityOverride.HIDE_ALL_PARTS);
                }
                if (scene.getDisplayerManager().hasDisplayer("x-Section")) {
                    scene.getDisplayerManager().getObject("x-Section").setVisibilityOverrideMode(DisplayerVisibilityOverride.SHOW_ALL_PARTS);
                    scene.getDisplayerManager().getObject("y-Section").setVisibilityOverrideMode(DisplayerVisibilityOverride.HIDE_ALL_PARTS);
                    scene.getDisplayerManager().getObject("z-Section").setVisibilityOverrideMode(DisplayerVisibilityOverride.HIDE_ALL_PARTS);
                }
                if (scene.getDisplayerManager().hasDisplayer("x-Section-Outline")) {
                    scene.getDisplayerManager().getObject("x-Section-Outline").setVisibilityOverrideMode(DisplayerVisibilityOverride.SHOW_ALL_PARTS);
                    scene.getDisplayerManager().getObject("y-Section-Outline").setVisibilityOverrideMode(DisplayerVisibilityOverride.HIDE_ALL_PARTS);
                    scene.getDisplayerManager().getObject("z-Section-Outline").setVisibilityOverrideMode(DisplayerVisibilityOverride.HIDE_ALL_PARTS);
                }

                CurrentView currentView =
                        scene.getCurrentView();
                currentView.setInput(new DoubleVector(new double[]{0.0, 0.00, 0.6}), new DoubleVector(new double[]{1.0, 0.0, 0.6}), new DoubleVector(new double[]{0.0, 0.0, 1.0}), 0.8, 1, 30.0);
            }
counter =0;
            for (int i = xStart; i > xEnd; i -= xResolution) {
                counter += 1;
                final int counterF = counter;
                CountDownLatch latch = new CountDownLatch(xSections.size());
                int finalI = i;
                double x = i * 0.001;


                planeSection_x.getOriginCoordinate().setDefinition("[" + x + ", 0.0, 0.0]");

                for (Scene scene : xSections) {
                    executorService.submit(() -> {
                        //  Sie Ihre Methode hier aus
                        export(scene, "x-Section", counterF, finalI);
                        latch.countDown();
                    });
                }
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    // Behandeln Sie die Ausnahme
                }
            }
        }
        if(postprocessing.contains("y")) {
            for (Scene scene : ySections) {
                if (scene.getDisplayerManager().hasDisplayer("3D")) {
                    scene.getDisplayerManager().getObject("3D").setVisibilityOverrideMode(DisplayerVisibilityOverride.HIDE_ALL_PARTS);
                }
                if (scene.getDisplayerManager().hasDisplayer("x-Section")) {
                    scene.getDisplayerManager().getObject("x-Section").setVisibilityOverrideMode(DisplayerVisibilityOverride.HIDE_ALL_PARTS);
                    scene.getDisplayerManager().getObject("y-Section").setVisibilityOverrideMode(DisplayerVisibilityOverride.SHOW_ALL_PARTS);
                    scene.getDisplayerManager().getObject("z-Section").setVisibilityOverrideMode(DisplayerVisibilityOverride.HIDE_ALL_PARTS);
                }
                if (scene.getDisplayerManager().hasDisplayer("x-Section-Outline")) {
                    scene.getDisplayerManager().getObject("x-Section-Outline").setVisibilityOverrideMode(DisplayerVisibilityOverride.HIDE_ALL_PARTS);
                    scene.getDisplayerManager().getObject("y-Section-Outline").setVisibilityOverrideMode(DisplayerVisibilityOverride.SHOW_ALL_PARTS);
                    scene.getDisplayerManager().getObject("z-Section-Outline").setVisibilityOverrideMode(DisplayerVisibilityOverride.HIDE_ALL_PARTS);
                }
                CurrentView currentView =
                        scene.getCurrentView();
                currentView.setInput(new DoubleVector(new double[]{0.8, 0.0, 0.7}), new DoubleVector(new double[]{0.8, -1.0, 0.7}), new DoubleVector(new double[]{0.0, 0.0, 1.0}), 1.0, 1, 30.0);
            }
            counter = 0;
            for (int i = yStart; i > yEnd; i -= yResolution) {
                counter += 1;
                final int counterF = counter;
                CountDownLatch latch = new CountDownLatch(ySections.size());
                int finalI = i;
                double y = i * 0.001;
                planeSection_y.getOriginCoordinate().setDefinition("[0.0 ," + y + ", 0.0]");
                for (Scene scene : ySections) {
                    executorService.submit(() -> {
                        //  Sie Ihre Methode hier aus
                        export(scene, "y-Section", counterF, finalI);
                        latch.countDown();
                        scene.getRenderCanvas().createImage(100,200);
                    });
                }

                try {
                    latch.await();
                } catch (InterruptedException e) {
                    // Behandeln Sie die Ausnahme
                }
            }
        }

            
        if(postprocessing.contains("3"))
        {
            for (String plotName : plots)
            {
                StarPlot plot = simulation_0.getPlotManager().getPlot(plotName);
                plot.encode("plots/"+plotName);
            }
            for (Scene three : threeDscenes) {
                executorService.submit(() -> {
                    exportThree(three);
                });
            }
        }
        executorService.shutdown();



    }


    private void export(Scene scene,String section,int counter, int i)
    {

        int xRes=3000;
        int yRes=1600;
        /*
        if(scene.getPresentationName().equals("Velocity"))
        {
            xRes=2*xRes;
            yRes=2*yRes;
        }
         */
        
            scene.printToFile(new File(scene.getPresentationName()+"_"+section + "/" + df.format(counter) + "_" + scene.getPresentationName()+"_" + section + "_" + i + "mm.png"),xRes,yRes);

        
    }

    private void exportThree(Scene scene)
    {

        Displayer threeDisplayer = scene.getDisplayerManager().getObject("3D");
        threeDisplayer.setVisibilityOverrideMode(DisplayerVisibilityOverride.SHOW_ALL_PARTS);
        if (scene.getDisplayerManager().hasDisplayer("x-Section")) {
            Displayer xDisplayer = scene.getDisplayerManager().getObject("x-Section");
            Displayer yDisplayer = scene.getDisplayerManager().getObject("y-Section");
            Displayer zDisplayer = scene.getDisplayerManager().getObject("z-Section");
            xDisplayer.setVisibilityOverrideMode(DisplayerVisibilityOverride.HIDE_ALL_PARTS);
            yDisplayer.setVisibilityOverrideMode(DisplayerVisibilityOverride.HIDE_ALL_PARTS);
            zDisplayer.setVisibilityOverrideMode(DisplayerVisibilityOverride.HIDE_ALL_PARTS);
        }


        scene.export3DSceneFileAndWait(resolvePath("3D/"+scene.getPresentationName()+".sce"), scene.getPresentationName(), "", false, SceneFileCompressionLevel.HIGH);

        if (scene.getDisplayerManager().hasDisplayer("x-Section")) {
            Displayer xDisplayer = scene.getDisplayerManager().getObject("x-Section");
            Displayer yDisplayer = scene.getDisplayerManager().getObject("y-Section");
            Displayer zDisplayer = scene.getDisplayerManager().getObject("z-Section");
            xDisplayer.setVisibilityOverrideMode(DisplayerVisibilityOverride.SHOW_ALL_PARTS);
            yDisplayer.setVisibilityOverrideMode(DisplayerVisibilityOverride.SHOW_ALL_PARTS);
            zDisplayer.setVisibilityOverrideMode(DisplayerVisibilityOverride.SHOW_ALL_PARTS);
        }

    }



}

