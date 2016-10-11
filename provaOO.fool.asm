push 0
push 50000
push 40000
lhp
sw
lhp
push 1
add
shp
lhp
sw
lhp
push 1
add
shp
lhp
push label0
lhp
sw
lhp
push 1 
add
shp
push label1
lhp
sw
lhp
push 1 
add
shp
lhp
sw
lhp
push 1
add
shp
lhp
push label2
lhp
sw
lhp
push 1 
add
shp
push label3
lhp
sw
lhp
push 1 
add
shp
push label9
lhp
sw
lhp
push 1 
add
shp
push 20000
push 5000
lhp
sw
lhp
push 1
add
shp
lhp
sw
lhp
push 1
add
shp
lhp
push label0
lhp
sw
lhp
push 1 
add
shp
push label1
lhp
sw
lhp
push 1 
add
shp
push -2
lfp
add
lfp
push 1
add
sw
push -2
lfp
add
lw
push 1
add
push -4
lfp
add
lw
push -1
beq label17
push 0
b label18
label17:
push 1
label18:
push 1
beq label15
push -4
lfp
add
lfp
push 1
add
sw
push -4
lfp
add
lw
push 0
add
b label16
label15:
push 0
label16:
print
halt

function0:
cfp
lra
push -2
lfp
lw
add
lw
srv
sra
sfp
pop
lrv
lra
js

function1:
cfp
lra
push -3
lfp
lw
add
lw
srv
sra
sfp
pop
lrv
lra
js

function2:
cfp
lra
push -2
lfp
lw
add
lw
srv
sra
sfp
pop
lrv
lra
js

function3:
cfp
lra
push 1
lfp
add
lfp
push 1
add
sw
push 1
lfp
add
lw
push 0
add
push 1
lfp
add
lfp
push 1
add
sw
push 1
lfp
add
lw
push 1
add
add
push 30000
bless label7
b label6
label7:
push 1
lfp
add
lfp
push 1
add
sw
push 1
lfp
add
lw
push 0
add
push 1
lfp
add
lfp
push 1
add
sw
push 1
lfp
add
lw
push 1
add
add
push 30000
beq label6
push 0
b label8
label6:
push 1
label8:
push 1
beq label4
push -1
b label5
label4:
push -2
lfp
lw
add
lfp
push 1
add
sw
push -2
lfp
lw
add
lw
push 0
add
lhp
sw
lhp
push 1
add
shp
lhp
push label0
lhp
sw
lhp
push 1 
add
shp
label5:
srv
sra
sfp
pop
pop
lrv
lra
js

function4:
cfp
lra
push 1
lfp
add
lfp
push 1
add
sw
push 1
lfp
add
lw
push 0
add
push 20000
bless label13
b label12
label13:
push 1
lfp
add
lfp
push 1
add
sw
push 1
lfp
add
lw
push 0
add
push 20000
beq label12
push 0
b label14
label12:
push 1
label14:
push 1
beq label10
push -1
b label11
label10:
push -2
lfp
lw
add
lfp
push 1
add
sw
push -2
lfp
lw
add
lw
push 0
add
push -2
lfp
lw
add
lfp
push 1
add
sw
push -2
lfp
lw
add
lw
push 1
add
lhp
sw
lhp
push 1
add
shp
lhp
sw
lhp
push 1
add
shp
lhp
push label0
lhp
sw
lhp
push 1 
add
shp
push label1
lhp
sw
lhp
push 1 
add
shp
label11:
srv
sra
sfp
pop
pop
lrv
lra
js
