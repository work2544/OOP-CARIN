var Defs = {};


//Anti
Defs.anti = {};

Defs.anti.Knight = {
    value : 100,
    damage : 15,
    range : 80,
    rate : 60,

    shoot: function (viruses) {
        var virus = viruses[0];
        var _hp = virus.hp;
        var anti = this;

        if ((creep.hp -= turret.damage) <= 0 && _hp > 0) {
			turret.kills++;
		}
		
		if (turret.levels.full && Math.rand(9) === 0) {
			var start = 0;
			creep.x = 0
			creep.y = 0
			creep.nextpoint = 0;
		}
		
		game.run.push({ what: function () {
			canvas.lineCap = "square";
			canvas.lineWidth = 2;
			canvas.strokeStyle = "#EE82EE";
			canvas.beginPath();
			canvas.moveTo(anti.x, anti.y);
			canvas.lineTo(virus.x, virus.y);
			canvas.stroke();
		}, until: 6 });
	}
};