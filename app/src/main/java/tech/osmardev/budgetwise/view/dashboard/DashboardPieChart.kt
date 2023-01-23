package tech.osmardev.budgetwise.view.dashboard

import android.os.Bundle
import android.graphics.Paint
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tech.osmardev.budgetwise.view.dashboard.ui.theme.*

/**
 * Created by Osmar Jrz. on 22/01/23
 */

class DashboardPieChart : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FullPieChart()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FullPieChart() {
    PieChartTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(white)
                .padding(1.dp)
            ,
            verticalArrangement = Arrangement.spacedBy(1.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Box(
                modifier = Modifier
            ){
                PieChart(
                    modifier = Modifier
                        .size(400.dp),
                    input = listOf(
                        PieChartInput(
                            color = brightBlue,
                            value = 29,
                            description = "Python"
                        ),
                        PieChartInput(
                            color = purple,
                            value = 21,
                            description = "Swift"
                        ),
                        PieChartInput(
                            color = blueGray,
                            value = 32,
                            description = "JavaScript"
                        ),
                        PieChartInput(
                            color = redOrange,
                            value = 18,
                            description = "Java"
                        ),
                        PieChartInput(
                            color = green,
                            value = 12,
                            description = "Ruby"
                        ),
                        PieChartInput(
                            color = orange,
                            value = 38,
                            description = "Kotlin"
                        ),
                    ),
                    centerText = "Budget"
                )
            }
        }
    }
}



@Composable
fun PieChart(
    modifier: Modifier = Modifier,
    radius:Float = 450f,
    innerRadius:Float = 225f,
    transparentWidth:Float = 10f,
    input:List<PieChartInput>,
    centerText:String = ""
) {
    var circleCenter by remember {
        mutableStateOf(Offset.Zero)
    }

    var inputList by remember {
        mutableStateOf(input)
    }
    var isCenterTapped by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Canvas(
            modifier = Modifier
        ){
            val width = size.width
            val height = size.height
            circleCenter = Offset(x= width/2f,y= height/2f)

            val totalValue = input.sumOf {
                it.value
            }
            val anglePerValue = 360f/totalValue
            var currentStartAngle = 0f

            inputList.forEach { pieChartInput ->
                val scale = 1.0f
                val angleToDraw = pieChartInput.value * anglePerValue
                scale(scale){
                    drawArc(
                        color = pieChartInput.color,
                        startAngle = currentStartAngle,
                        sweepAngle = angleToDraw,
                        useCenter = true,
                        size = Size(
                            width = radius*2f,
                            height = radius*2f
                        ),
                        topLeft = Offset(
                            (width-radius*2f)/2f,
                            (height - radius*2f)/2f
                        )
                    )
                    currentStartAngle += angleToDraw
                }
                var rotateAngle = currentStartAngle-angleToDraw/2f-90f
                var factor = 1f
                if(rotateAngle>90f){
                    rotateAngle = (rotateAngle+180).mod(360f)
                    factor = -0.92f
                }

                val percentage = (pieChartInput.value/totalValue.toFloat()*100).toInt()

                drawContext.canvas.nativeCanvas.apply {
                    if(percentage>3){
                        rotate(rotateAngle){
                            drawText(
                                "$percentage %",
                                circleCenter.x,
                                circleCenter.y+(radius-(radius-innerRadius)/2f)*factor,
                                Paint().apply {
                                    textSize = 13.sp.toPx()
                                    textAlign = Paint.Align.CENTER
                                    color = white.toArgb()
                                }
                            )
                        }
                    }
                }
            }
            drawContext.canvas.nativeCanvas.apply {
                drawCircle(
                    circleCenter.x,
                    circleCenter.y,
                    innerRadius,
                    Paint().apply {
                        color = white.copy(alpha = 1f).toArgb()
                    }
                )
            }

            drawCircle(
                color = white.copy(0.2f),
                radius = innerRadius+transparentWidth/2f
            )

        }
        Text(
            centerText,
            modifier = Modifier
                .width(Dp(innerRadius / 1.5f))
                .padding(25.dp),
            fontWeight = FontWeight.SemiBold,
            fontSize = 17.sp,
            textAlign = TextAlign.Center
        )

    }
}

data class PieChartInput(
    val color: Color,
    val value:Int,
    val description:String,
    val isTapped:Boolean = false
)