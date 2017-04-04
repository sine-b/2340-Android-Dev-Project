package edu.gatech.cs2340.a2340_android_dev_project.controllers;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.OnDataPointTapListener;
import com.jjoe64.graphview.series.PointsGraphSeries;
import com.jjoe64.graphview.series.Series;

import java.util.ArrayList;

import edu.gatech.cs2340.a2340_android_dev_project.model.PurityReport;
/**
 * Created by wes on 4/4/2017.
 */
public class DisplayGraph extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_view);

        // initiates the graph and gets the selected purity report
        ArrayList<PurityReport> purityReport = GetReportActivity.pr;
        GraphView point_graph = (GraphView) findViewById(R.id.graph);
        String con = GetReportActivity.con;
        //set manual x bounds
        point_graph.getViewport().setYAxisBoundsManual(true);
        point_graph.getViewport().setMaxY(1000);
        point_graph.getViewport().setMinY(0);

        //set manual y bounds
        point_graph.getViewport().setXAxisBoundsManual(true);
        point_graph.getViewport().setMaxX(12);
        point_graph.getViewport().setMinX(1);
        // sets the starting point of the graph
        PointsGraphSeries<DataPoint> point_series = new PointsGraphSeries<DataPoint>(new DataPoint[]{new DataPoint(0, 0)});
        point_graph.addSeries(point_series);
        point_series.setShape(PointsGraphSeries.Shape.RECTANGLE);
        point_series.setColor(Color.BLACK);
        point_series.setSize(2);

        // adds the data points to the graph
        PointsGraphSeries<DataPoint> ps;
        ps = new PointsGraphSeries<DataPoint>(getData(purityReport, con));
        point_graph.addSeries(ps);
        ps.setShape(PointsGraphSeries.Shape.RECTANGLE);
        ps.setColor(Color.RED);
        ps.setSize(18);
        // sets the x and y axis of the graph
        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(point_graph);
        staticLabelsFormatter.setHorizontalLabels(new String[]{"J", "F", "M", "A", "M", "J", "J", "A", "S", "O", "N", "D"});
        staticLabelsFormatter.setVerticalLabels(new String[]{"0", "100", "200", "300", "400", "500", "600", "700", "800", "900", "1000"});
        point_graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
        point_series.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPoint) {
                Toast.makeText(DisplayGraph.this, "Series1: On Data Point clicked: " + dataPoint, Toast.LENGTH_SHORT).show();
            }
        });

    }

    /*
     * returns an array of all the data points of the year for that location
     * @return a list of all the data points that mist be plotted
     */
    private DataPoint[] getData(ArrayList<PurityReport> purityReport, String con) {
        DataPoint[] dp = new DataPoint[purityReport.size()];
        double x;
        double y;
        for(int i = 0; i < purityReport.size(); i++){
            x = Integer.parseInt(purityReport.get(i).getDate().substring(0,2));
            if (con.toString().equals("Contaminant")) {
                y = purityReport.get(i).getContaminantNumber();
            } else {
                y = purityReport.get(i).getVirusNumber();
            }
            dp[i] = new DataPoint(x, y);
        }
        return dp;
    }
}