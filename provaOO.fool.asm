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
push label8
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
beq label15
push 0
b label16
label15:
push 1
label16:
push 1
beq label13
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
b label14
label13:
push 0
label14:
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
push 30000
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
bless label6
push 0
b label7
label6:
push 1
label7:
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
push 20000
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
bless label11
push 0
b label12
label11:
push 1
label12:
push 1
beq label9
push -1
b label10
label9:
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
label10:
srv
sra
sfp
pop
pop
lrv
lra
js
