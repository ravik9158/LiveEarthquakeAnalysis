package guimods;


import java.util.ArrayList;
import java.util.List;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

public class MyDisplay extends PApplet {

	private UnfoldingMap map;
	public void setup() {
		size(950, 600, OPENGL);
		map = new UnfoldingMap(this, 50, 50, 700, 500, new Microsoft.RoadProvider());
		MapUtils.createDefaultEventDispatcher(this, map);
		
		Location valLoc = new Location(-38.14f, -73.03f);
		Location aLoc = new Location(-28.14f, -73.03f);
		Location bLoc = new Location(-44.14f, -53.03f);
		PointFeature valEq = new PointFeature(valLoc);
		PointFeature val2 = new PointFeature(aLoc);
		PointFeature val1 = new PointFeature(bLoc);
		valEq.addProperty("Location", "Cambodia");
		val1.addProperty("Location", "mbodia");
		val2.addProperty("Location", "bodia");
		
		List<PointFeature> bigeq = new ArrayList<PointFeature>();
		bigeq.add(valEq);
		bigeq.add(val1);
		bigeq.add(val2);
		
		List<Marker> markers = new ArrayList<Marker>();
		for(PointFeature eq : bigeq) {
			markers.add(new SimplePointMarker(eq.getLocation(), eq.getProperties()));
		}
		map.addMarkers(markers);
	}
	public void draw() {
		background(50);
		map.draw();
	}
}
